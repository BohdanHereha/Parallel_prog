#include "Data.h"
#include <windows.h>
#include <iostream>
#include <mpi.h>

#define N 22

#pragma push_macro("max")
#undef max

void Thread1();
void Thread2();
void Thread3();

using namespace std;

int main(int argc, char** argv)
{
	
	MPI_Comm my_comm;
	MPI_Group my_group;

	MPI_Init(&argc, &argv);
#pragma comment(linker, "/STACK:200000000")
	int tid;

	MPI_Comm_group(MPI_COMM_WORLD, &my_group);
	MPI_Comm_create(MPI_COMM_WORLD, my_group, &my_comm);
	MPI_Comm_rank(my_comm, &tid);
	switch (tid) {
	case 0:
		Thread1();
		break;
	case 1:
		Thread2();
		break;
	case 2:
		Thread3();
		break;
	}
	MPI_Finalize();
	return 0;
}

void Thread1()
{
	cout << "Thread 1 started...\n";

	Vector* B = new Vector(N, true);
	Vector* C = new Vector(N, true);
	Matrix* MA = new Matrix(N, true);
	Matrix* ME = new Matrix(N, true);

	Matrix* MD = *(*MA * *ME) * (*B * *C);
	delete B, C, MA, ME;
	cout << "\nF1 = \n";
	MD->print();
	cout << "Thread 1 finished\n";
}

void Thread2()
{
	cout << "Thread 2 started...\n";

	Matrix* MF = new Matrix(N, true);
	Matrix* MK = new Matrix(N, true);
	Matrix* MH = new Matrix(N, true);

	Matrix* MG = *(MK->transpose()) * *(*MH * *MF);

	cout << "\nF2 = \n";
	MG->print();
	delete MF, MK, MH;

	cout << "Thread 2 finished\n";
}

void Thread3()
{
	cout << "Thread 3 started...\n";

	Vector* T = new Vector(N, true);
	Matrix* MP = new Matrix(N, true);
	Matrix* MR = new Matrix(N, true);

	Vector* O = *T * ((*MP * *MR)->max());
	delete T, MP, MR;
	cout << "\nF3 = \n";
	O->print();
	cout << "Thread 3 finished\n";
}