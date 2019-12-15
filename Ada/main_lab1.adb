----------------Main programm------------------------

--Parallel and distributed computing.
--Labwork 1. Ada. Subprograms and packages
--Hereha Bohdan
--IP-73
--24.09.2019
--Func1: C = A-B*(MA*MC)*e
--Func2: MF = MF*MG*k
--Func3: O = sort(P)*(MR*MT)

with Data, Text_IO, Ada.Integer_Text_IO, System.Multiprocessors;
use Text_IO, Ada.Integer_Text_IO, System.Multiprocessors;

procedure Main_Lab1 is
   n: Integer := 3 ;
   package data1 is new data (n);
   use data1;

   CPU0: CPU_Range :=0;
   CPU1: CPU_Range :=1;
   CPU2: CPU_Range :=2;
   f1,f3: Vector;
   f2: Matrix;

   procedure tasks is
      task T1 is
         pragma Priority(1);
         pragma Storage_Size(100000);
         pragma CPU(CPU0);
      end;
      task body T1 is
         A, B: Vector;
         MA, MC: Matrix;
         e: Integer;

      begin
         Put_Line("T1 started");
         Vector_Filling_Ones(A);
         Vector_Filling_Ones(B);
         Matrix_Filling_Ones(MA);
         Matrix_Filling_Ones(MC);
         e:=1;
         f1:=Func1(A, B, MA, MC, e);
         delay(1.0);
      end T1;

      task T2 is
         pragma Priority(3);
         pragma Storage_Size(100000);
         pragma CPU(CPU1);
      end;
      task body T2 is
         MF, MG: Matrix;
         k: Integer;
      begin
         Put_Line("T2 started");
         Matrix_Filling_Ones(MF);
         Matrix_Filling_Ones(MG);
         k:=1;
         f2:=Func2(MF, MG, k);
         delay(2.0);
      end T2;

      task T3 is
         pragma Priority(5);
         pragma Storage_Size(100000);
         pragma CPU(CPU2);
      end;
      task body T3 is
         MT, MR : Matrix;
         P: Vector;

      begin
         Put_Line("T3 started");
         Vector_Filling_Ones(P);
         Matrix_Filling_Ones(MR);
         Matrix_Filling_Ones(MT);
         f3:=Func3(P, MR, MT);
         delay(3.0);
      end T3;

   begin
      null;
   end tasks;


Begin
   tasks;

   Put_Line("Func1: C = A-B*(MA*MC)*e");
   Vector_Output(f1);
   New_Line;
   New_Line;
   Put_Line("T1 finished");

   Put_Line("Func2: MF = MF*MG*k");
   Matrix_Output(f2);
   New_Line;
   New_Line;
   Put_Line("T2 finished");

   Put_Line("Func3: O = sort(P)*(MR*MT)");
   Vector_Output(f3);
   New_Line;
   New_Line;
   Put_Line("T3 finished");

End Main_Lab1;
