using System;

using System.Threading;

namespace lab3
{
    class Lab3
    {
        private static readonly int N = 10;
        private static Matrix result, result1;
        private static long result2;
        private static Matrix result22;
        private static Matrix result3;
        private static Matrix result4;
        private static AutoResetEvent event_1 = new AutoResetEvent(false);
        public class F1
        {
            public Matrix getResult()
            {
                return result;
            }

            private int N;

            public F1(int N)
            {
                this.N = N;
            }

            public void run()
            {
                Console.WriteLine("Thread 1 start...");
                Matrix MF = new Matrix(N), MG = new Matrix(N);
                result = MF.multiply(MG);
                result1 = result.sort();
                Console.WriteLine("Thread 1 end");
            }
        }

        public class F2
        {
            public Matrix getResult()
            {
                return result22;
            }

            private int N;

            public F2(int N)
            {
                this.N = N;
            }

            public void run()
            {
                Console.WriteLine("Thread 2 start...");
                Matrix MA = new Matrix(N), MB = new Matrix(N), MC = new Matrix(N), MD = new Matrix(N);
                result22 = MA.sum(MB.multiply(MC.multiply(MD)));
                result2 = result22.max();
                Console.WriteLine("Thread 2 end");
            }
        }

        public class F3
        {
            public Matrix getResult()
            {
                return result3;
            }

            private int N;

            public F3(int N)
            {
                this.N = N;
            }

            public void run()
            {
                Console.WriteLine("Thread 3 start...");
                Matrix MZ = new Matrix(N), MQ = new Matrix(N);
                result3 = MZ.multiply(MQ);
                event_1.Set();
                Console.WriteLine("Thread 3 end");
            }
        }

        public class F4
        {
            public Matrix getResult()
            {
                return result4;
            }

            private int N;

            public F4(int N)
            {
                this.N = N;
            }

            public void run()
            {
                Console.WriteLine("Thread 4 start...");
                Matrix MY = new Matrix(N);
                event_1.WaitOne();
                result4 = MY.div(result3);
                Console.WriteLine("Thread 4 end");
            }
        }
        static void Main(string[] args)
        {
            Console.WriteLine("Lab 3 start...");
            Console.WriteLine();

            Thread f1 = new Thread((new F1(N)).run);
            Thread f2 = new Thread((new F2(N)).run);
            Thread f3 = new Thread((new F3(N)).run);
            Thread f4 = new Thread((new F4(N)).run);
            
            f1.Priority = ThreadPriority.Lowest;
            f2.Priority = ThreadPriority.Normal;
            f3.Priority = ThreadPriority.BelowNormal;
            f4.Priority = ThreadPriority.Highest;

            f1.Start();
            f2.Start();
            f3.Start();
            f4.Start();

            f1.Join();
            f2.Join();
            f3.Join();
            f4.Join();

            Console.WriteLine("\n\n");

            Console.ForegroundColor = ConsoleColor.Magenta;
            Console.WriteLine("=========F1=========\n");
            //Console.WriteLine(result.toString());
            Console.WriteLine(result1.toString());
            Console.ResetColor();

            Console.ForegroundColor = ConsoleColor.Blue;
            Console.WriteLine("=========F2=========\n");
            Console.WriteLine(result2);
            //Console.WriteLine(result22.toString());
            Console.ResetColor();

            Console.ForegroundColor = ConsoleColor.Green;
            Console.WriteLine("\n=========F3=========\n");
            Console.WriteLine(result4.toString());
            Console.ResetColor();

            Console.WriteLine("Lab 3 end");
            Console.Write("Press any key...");

            Console.ReadKey();
        }
    }
}
