#include "Data.h"
#include "omp.h"
#include <windows.h>
#include <iostream>


#define N 15	

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
void Task1();
void Task2();
void Task3();
Vector* C = new Vector(N, false);
Matrix* MG = new Matrix(N, false);
Vector* O = new Vector(N, false);


using namespace std;
int main()
{
	
	omp_set_num_threads(3);
#pragma omp parallel num_threads(3)
	{
#pragma omp sections
		{

#pragma omp section
			{
				Task1();

			}
#pragma omp section

			{
				Task2();

			}

#pragma omp section
			{
				Task3();

			}
		}
	}
	printf("\nF1 = \n");
	SetColor(12);
	C->print();
	SetColor(15);
	printf("\nF2 = \n");
	SetColor(2);
	MG->print();
	SetColor(15);
	printf("\nF3 = \n");
	SetColor(9);
	O->print();
	SetColor(15);
	cout << "Main thread finished execution!\n";
	system("pause");
	return 0;
}

void Task1()
{
	cout << "Thread 1 started!\n";

	Vector* A = new Vector(N, true);
	Vector* B = new Vector(N, true);
	Matrix* MA = new Matrix(N, true);
	Matrix* ME = new Matrix(N, true);

	C = *(*(*MA * *ME) * *(A->sort())) + *(B->sort());
	delete A, B, MA, ME;

	cout << "Thread 1 finished execution!\n";


}


void Task2()
{
	cout << "Thread 2 started!\n";

	Matrix* MF = new Matrix(N, true);
	Matrix* MK = new Matrix(N, true);
	Matrix* ML = new Matrix(N, true);
	
	MG = *(*(MF->sort()) * *MK) + *ML;

	delete MF, MK, ML;

	cout << "Thread 2 finished execution!\n";
}

void Task3()
{
	cout << "Thread 3 started!\n";

	Vector* S = new Vector(N, true);
	Matrix* MP = new Matrix(N, true);
	Matrix* MR = new Matrix(N, true);

	O = *((*MP * *MR)->sort()) * *S;
	delete  S, MP, MR;

	cout << "Thread 3 finished execution\n";
}
