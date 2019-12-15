#include "Data.h"
#include <windows.h>
#include <stdexcept>
#include <stdio.h>
#include <iostream>
#define THREAD_STACK_SIZE 1000000 // 1 MB
#define N 10
#pragma push_macro("max")
#undef max

void SetColor(int ForgC)
{
	WORD wColor;

	HANDLE hStdOut = GetStdHandle(STD_OUTPUT_HANDLE);
	CONSOLE_SCREEN_BUFFER_INFO csbi;

	if (GetConsoleScreenBufferInfo(hStdOut, &csbi))
	{
		wColor = (csbi.wAttributes & 0xF0) + (ForgC & 0x0F);
		SetConsoleTextAttribute(hStdOut, wColor);
	}
	return;
}

void Thread1();
void Thread2();
void Thread3();
void Thread4();
void Thread5();

Matrix * ML = new Matrix(N, false);
Vector * M = new Vector(N, false);
Vector * Q = new Vector(N, false);
Matrix * MQ = new Matrix(N, false);
int t;

HANDLE event1;
HANDLE event2;
using namespace std;

int main()
{
	cout << "Main Thread started...\n\n";
	DWORD Tid1, Tid2, Tid3, Tid4, Tid5;
	
	event1 = CreateEvent(NULL, TRUE, FALSE, NULL);
	event2 = CreateEvent(NULL, TRUE, FALSE, NULL);

	HANDLE T1 = CreateThread(NULL, THREAD_STACK_SIZE, (LPTHREAD_START_ROUTINE)Thread1, NULL, CREATE_SUSPENDED, &Tid1);
	HANDLE T2 = CreateThread(NULL, THREAD_STACK_SIZE, (LPTHREAD_START_ROUTINE)Thread2, NULL, CREATE_SUSPENDED, &Tid2);
	HANDLE T3 = CreateThread(NULL, THREAD_STACK_SIZE, (LPTHREAD_START_ROUTINE)Thread3, NULL, CREATE_SUSPENDED, &Tid3);
	HANDLE T4 = CreateThread(NULL, THREAD_STACK_SIZE, (LPTHREAD_START_ROUTINE)Thread4, NULL, CREATE_SUSPENDED, &Tid4);
	HANDLE T5 = CreateThread(NULL, THREAD_STACK_SIZE, (LPTHREAD_START_ROUTINE)Thread5, NULL, CREATE_SUSPENDED, &Tid5);

	SetThreadPriority(T1, 1);
	SetThreadPriority(T2, 5);
	SetThreadPriority(T3, 5);
	SetThreadPriority(T4, 2);
	SetThreadPriority(T5, 3);

	ResumeThread(T1);
	ResumeThread(T2);
	ResumeThread(T3);
	ResumeThread(T4);
	ResumeThread(T5);

	WaitForSingleObject(T1, INFINITE);
	WaitForSingleObject(T2, INFINITE);
	WaitForSingleObject(T3, INFINITE);
	WaitForSingleObject(T4, INFINITE);
	WaitForSingleObject(T5, INFINITE);

	CloseHandle(T1);
	CloseHandle(T2);
	CloseHandle(T3);
	CloseHandle(T4);
	CloseHandle(T5);
	
	printf("\nF1 = \n", ML);
	SetColor(12);
	M->print();
	SetColor(15);
	printf("\nF2 = \n", MQ);
	SetColor(2);
	MQ->print();
	SetColor(15);
	printf("\nF3 = \n", t);
	SetColor(9);
	cout << "   " << t << "\n";
	SetColor(15);
	cout << "\nMain thread finished\n";

	system("pause");
	return 0;
}

void Thread1()
{
	cout << "Thread 1 started...\n";
	Matrix* MA = new Matrix(N, true);
	Matrix* MB = new Matrix(N, true);
	ML = *MA * *MB;
	SetEvent(event1);
	delete MA, MB;
	cout << "Thread 1 finished\n";
}

void Thread2()
{
	cout << "Thread 2 started...\n";
	Vector* A = new Vector(N, true);
	Vector* B = new Vector(N, true);
	Q = *A + *B;
	SetEvent(event2);
	delete A, B;
	cout << "Thread 2 finished\n";
}

void Thread3()
{
	DWORD dwWaitResult;
	cout << "Thread 3 started...\n";
	WaitForSingleObject(event1, 1);
	WaitForSingleObject(event2, 1);
	M = *ML * *Q;
	cout << "Thread 3 finished\n";
}

void Thread4()
{
	cout << "Thread 4 started...\n";
	Matrix* MD = new Matrix(N, true);
	Matrix* MF = new Matrix(N, true);
	MQ = *MD->transpose() * *MF;
	delete MD, MF;
	cout << "Thread 4 finished\n";
}

void Thread5()
{
	cout << "Thread 5 started...\n";

	Vector* X = new Vector(N, true);
	Vector* Y = new Vector(N, true);
	Matrix* MG = new Matrix(N, true);
	Matrix* MJ = new Matrix(N, true);
	Matrix* MK = new Matrix(N, true);
	t = (*(*(*MG * *MJ) * *X) + *(*MK * *Y))->max();
	delete X, Y, MJ, MG, MK;
	cout << "Thread 5 finished\n";
}