generic
   n: Integer;
package Data is

   ---Declaration of private types
   type Vector is private;
   type Matrix is private;

   --Read Vector
   procedure Vector_Input(A: out Vector);

   --Write vector on screen
   procedure Vector_Output(A: in Vector);

   --Read matrix
   procedure Matrix_Input(A: out Matrix);

   --Write matrix on screen
   procedure Matrix_Output (A: in Matrix);

   --Calculation function 1
   function Func1 (A, B: in Vector; MA, MC : in Matrix; e: in Integer) return Vector;

   --Calculation function 2
   function Func2 (MF, MG: in Matrix; k: in Integer) return Matrix;

   --Calculation function 3
   function Func3 (P: out Vector; MR, MT : in Matrix) return Vector;


   --Filling matrix with ones
   procedure Matrix_Filling_Ones(A: out Matrix);

   --Filling vector with ones
   procedure Vector_Filling_Ones (A: out vector);


   --Determination private types
   private
   type Vector is array (1..n) of Integer;
   type Matrix is array (1..n) of Vector;

end Data;
