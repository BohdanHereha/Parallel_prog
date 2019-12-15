-----------Package Data, body-----------
with Text_IO, Ada.Integer_Text_IO;
use Text_IO, Ada.Integer_Text_IO;
package body Data is

   --Read Vector
   procedure Vector_Input(A: out Vector) is
   begin
      for i in 1..n loop
         Get(A(i));
      end loop;
   end Vector_Input;

   --Write vector on screen
   procedure Vector_Output(A: in Vector) is
   begin
      for i in 1..n loop
         Put(A(i));
         Put(" ");
      end loop;
   end Vector_Output;

   --Read matrix
   procedure Matrix_Input(A: out Matrix) is
   begin
      for i in 1..n loop
         for j in 1..n loop
            Get(A(i)(j));
         end loop;
      end loop;
   end Matrix_Input;

   --Write matrix on screen
   procedure Matrix_Output (A: in Matrix) is
   begin
      for i in 1..n loop
         for j in 1..n loop
            Put(A(i)(j));
            Put(" ");
         end loop;
         Put_Line(" ");
      end loop;
   end Matrix_Output;

   --Multiplication of matrices
   function Matrix_Multiplication(A, B: in Matrix) return Matrix is
      P: Matrix;
      S: Integer;
   begin
      for k in 1..n loop
         for i in 1..n loop
            s := 0;
            for j in 1..n loop
               S := S + A(k)(j)*B(j)(i);
               P(k)(i) := s;
            end loop;
         end loop;
      end loop;
      return P;
   end Matrix_Multiplication;

   --Multiplication of matrix and integer
   function Matrix_Integer_Multiplication(A: in Matrix; k: in Integer) return Matrix is
      P: Matrix;
   begin
      for i in 1..n loop
         for j in 1..n loop
            P(i)(j):=A(i)(j)*k;
         end loop;
      end loop;
      return P;
   end Matrix_Integer_Multiplication;

   --Multiplication of vector and matrix
   function Vector_Matrix_Multiplication(A: in Vector; B: in Matrix) return Vector is
      P: Vector;
      s: Integer;
   begin
      for i in 1..n loop
         s := 0;
         for j in 1..n loop
            S := s + A(i)*B(j)(i);
         end loop;
         P(i) := S;
      end loop;
      return P;
   end Vector_Matrix_Multiplication;

   --Multiplication of Vector and Integer
   function Vector_Integer_Multiplication (A: in Vector; e: in Integer) return Vector is
      B: Vector;
   begin
      for i in 1..n loop
         B(i) := A(i)*e;
      end loop;
      return B;
   end Vector_Integer_Multiplication;

   --Difference of Vectors
   function Vector_Difference(A, B: in Vector) return Vector is
      S: Vector;
   begin
      for i in 1..n loop
         S(i) := A(i)-B(i);
      end loop;
      return S;
   end Vector_Difference;


   --Sorting of vector
   procedure Vector_Sorting(A: in out Vector) is
      S: Integer;
   begin
      for i in 1..n loop
         for j in i..n loop
            if A(i)>A(j) then
               S:=A(j);
               A(j):=A(i);
               A(i):=S;
            end if;
         end loop;
      end loop;
   end Vector_Sorting;

   --Filling matrix with ones
   procedure Matrix_Filling_Ones(A: out Matrix) is
   begin
      for i in 1..n loop
         for j in 1..n loop
            A(i)(j) := 1;
         end loop;
      end loop;
   end Matrix_Filling_Ones;

   --Filling vector with ones
   procedure Vector_Filling_Ones (A: out vector) is
   begin
      for i in 1..n loop
         A(i) := 1;
      end loop;
   end Vector_Filling_Ones;

   --Calculation function 1
   function Func1 (A, B: in Vector; MA, MC : in Matrix; e: in Integer) return Vector is
      MD:Matrix;
      C,D,F:Vector;
   begin
      MD:=Matrix_Multiplication(MA,MC);
      D:=Vector_Matrix_Multiplication(B,MD);
      F:=Vector_Integer_Multiplication(D,e);
      C:=Vector_Difference(A,F);
      return C;
   end Func1;

   --Calculation function 2
   function Func2 (MF, MG: in Matrix; k: in Integer) return Matrix is
      MD, MN: Matrix;
   begin
      MD:=Matrix_Multiplication(MF,MG);
      MN:=Matrix_Integer_Multiplication(MD, k);
      return MN;
   end Func2;

   --Calculation function 3
   function Func3 (P: out Vector; MR, MT : in Matrix) return Vector is
      MD:Matrix;
      O:Vector;
   begin
      Vector_Sorting(P);
      MD:=Matrix_Multiplication(MR,MT);
      O:=Vector_Matrix_Multiplication(P,MD);
      return O;
   end Func3;
end Data;
