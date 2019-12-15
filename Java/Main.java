package com.company;

public class Main {

    public static final int N = 5;
    public static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_RED = "\u001B[0m";
    static public int[][] resultMatrix1 = new int[Main.N][Main.N];
    public static int[][] resultMatrix2 = new int[Main.N][Main.N];
    public static int[] resultVector = new int[Main.N];

    static public class FirstTask extends Thread {
        public static int[] vectorA = new int[Main.N];
        public static int[][] matrixMA = new int[Main.N][Main.N];
        public static int[][] matrixMD = new int[Main.N][Main.N];

        @Override
        public void run() {
            System.out.println("Start 1 thread...");
            inputDataRandom();
            //inputDataOnes();
            resultMatrix1 = multIntegerWithMatrix(searchMin(vectorA), multMatrix(matrixMA, matrixMD));
            System.out.println("Finish 1 thread...");
        }

        private void inputDataRandom() {
            randomMatrix(matrixMA);
            randomMatrix(matrixMD);
            randomVector(vectorA);
        }

        private void randomVector(int[] vector) {
            for (int i = 0; i < vector.length; i++) {
                vector[i] = (int) (Math.random() * 5) + 1;
            }
        }

        private void randomMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = (int) (Math.random() * 5) + 1;
                }
            }
        }

        static public void displayResult1(int[][] resultMatrix1) {
            for (int i = 0; i < resultMatrix1.length; i++) {
                for (int j = 0; j < resultMatrix1[i].length; j++) {
                    System.out.print(ANSI_PURPLE + resultMatrix1[i][j] + "\t" + ANSI_RESET);
                }
                System.out.println();
            }
        }

        /*
        private void inputDataOnes() {
            onesMatrix(matrixMA);
            onesMatrix(matrixMD);
            onesVector(vectorA);
        }
        private void onesVector(int[] vector) {
            for (int i = 0; i < vector.length; i++) {
                vector[i] = 1;
            }
        }
        private void onesMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = 1;
                }
            }
        }
        */
        private int[][] multMatrix(int[][] firstMatrix, int[][] secondMatrix) {
            int[][] resultMatrix = new int[Main.N][Main.N];

            for (int i = 0; i < firstMatrix.length; i++) {
                for (int j = 0; j < firstMatrix.length; j++) {
                    for (int k = 0; k < firstMatrix.length; k++) {
                        resultMatrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                    }
                }
            }
            return resultMatrix;
        }

        private int[][] multIntegerWithMatrix(int k, int[][] firstMatrix) {
            int[][] resultMatrix = new int[Main.N][Main.N];
            int tmpMult;

            for (int i = 0; i < firstMatrix.length; i++) {
                for (int j = 0; j < firstMatrix.length; j++) {
                    tmpMult = firstMatrix[i][j] * k;
                    resultMatrix[i][j] = tmpMult;
                }
            }

            return resultMatrix;
        }

        private int searchMin(int[] vector) {
            int value = vector[0];
            for (int i = 0; i < vector.length; i++) {
                if (vector[i] < value)
                    value = vector[i];
            }

            return value;
        }
    }

    public static class SecondTask extends Thread {

        public static int[][] matrixMX = new int[Main.N][Main.N];
        public static int[][] matrixMY = new int[Main.N][Main.N];
        public static int[] vectorB = new int[Main.N];
        public static int[] vectorC = new int[Main.N];

        @Override
        public void run() {
            System.out.println("Start 2 thread...");
            inputData();
            //inputDataOnes();
            resultMatrix2 = multIntegerWithMatrix(multVectors(vectorB, vectorC), multMatrix(matrixMX, matrixMY));
            System.out.println("Finish 2 thread...");
        }

        private void inputData() {
            randomMatrix(matrixMX);
            randomMatrix(matrixMY);
            randomVector(vectorB);
            randomVector(vectorC);
        }

        private void randomVector(int[] vector) {
            for (int i = 0; i < vector.length; i++) {
                vector[i] = (int) (Math.random() * 3) + 1;
            }
        }

        private void randomMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = (int) (Math.random() * 3) + 1;
                }
            }
        }

        static public void displayResult2(int[][] resultMatrix1) {
            for (int i = 0; i < resultMatrix1.length; i++) {
                for (int j = 0; j < resultMatrix1[i].length; j++) {
                    System.out.print(ANSI_BLUE + resultMatrix1[i][j] + "\t" + ANSI_RESET);
                }
                System.out.println();
            }
        }

        /*
        private void inputDataOnes() {
            onesMatrix(matrixMA);
            onesMatrix(matrixMD);
            onesVector(vectorA);
        }
        private void onesVector(int[] vector) {
            for (int i = 0; i < vector.length; i++) {
                vector[i] = 1;
            }
        }
        private void onesMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = 1;
                }
            }
        }
        */
        private int multVectors(int[] firstVector, int[] secondVector) {
            int resultSum = 0;

            for (int i = 0; i < firstVector.length; i++) {
                resultSum += firstVector[i] * secondVector[i];
            }
            return resultSum;
        }

        private int[][] multMatrix(int[][] firstMatrix, int[][] secondMatrix) {
            int[][] resultMatrix = new int[Main.N][Main.N];

            for (int i = 0; i < firstMatrix.length; i++) {
                for (int j = 0; j < firstMatrix.length; j++) {
                    for (int k = 0; k < firstMatrix.length; k++) {
                        resultMatrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                    }
                }
            }
            return resultMatrix;
        }

        private int[][] multIntegerWithMatrix(int k, int[][] firstMatrix) {
            int[][] resultMatrix = new int[Main.N][Main.N];
            int tmpMult;

            for (int i = 0; i < firstMatrix.length; i++) {
                for (int j = 0; j < firstMatrix.length; j++) {
                    tmpMult = firstMatrix[i][j] * k;
                    resultMatrix[i][j] = tmpMult;
                }
            }
            return resultMatrix;
        }
    }

    public static class ThirdTask extends Thread {
        public static int[][] matrixME = new int[Main.N][Main.N];
        public static int[][] matrixMF = new int[Main.N][Main.N];
        public static int[][] matrixMG = new int[Main.N][Main.N];
        public static int[] vectorF = new int[Main.N];
        public static int[] vectorD = new int[Main.N];

        @Override
        public void run() {
            System.out.println("Start 3 thread...");
            inputData();
            //inputDataOnes();
            resultVector = multVectorMatrix(multIntegerWithVector(vectorF, searchMin(vectorD)),
                    addingMatrix(multMatrix(matrixME, matrixMF), matrixMG));
            System.out.println("Finish 3 thread...");
        }

        private void inputData() {
            randomMatrix(matrixME);
            randomMatrix(matrixMF);
            randomMatrix(matrixMG);
            randomVector(vectorD);
            randomVector(vectorF);
        }

        private void randomVector(int[] vector) {
            for (int i = 0; i < vector.length; i++) {
                vector[i] = (int) (Math.random() * 5) + 1;
            }
        }

        private void randomMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = (int) (Math.random() * 5) + 1;
                }
            }
        }

        static private void displayResult3(int[] resultVector) {
            for (int aResultVector : resultVector) {
                System.out.print(ANSI_RED + aResultVector + " " + ANSI_RESET);
            }
        }

        /*
        private void inputDataOnes() {
            onesMatrix(matrixMA);
            onesMatrix(matrixMD);
            onesVector(vectorA);
        }
        private void onesVector(int[] vector) {
            for (int i = 0; i < vector.length; i++) {
                vector[i] = 1;
            }
        }
        private void onesMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = 1;
                }
            }
        }
        */
        private int searchMin(int[] vector) {
            int value = vector[0];
            for (int i = 0; i < vector.length; i++) {
                if (vector[i] < value)
                    value = vector[i];
            }

            return value;
        }

        private int[][] multMatrix(int[][] firstMatrix, int[][] secondMatrix) {
            int[][] resultMatrix = new int[Main.N][Main.N];
            int tmpMult;

            for (int i = 0; i < firstMatrix.length; i++) {
                for (int j = 0; j < firstMatrix.length; j++) {
                    tmpMult = firstMatrix[i][j] * secondMatrix[i][j];
                    resultMatrix[i][j] = tmpMult;
                }
            }

            return resultMatrix;
        }

        private int[] multVectorMatrix(int[] vector, int[][] matrix) {
            int[] resultVector = new int[Main.N];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    resultVector[i] += vector[j] * matrix[j][i];
                }
            }
            return resultVector;
        }

        private int[][] addingMatrix(int[][] firstMatrix, int[][] secondMatrix) {
            int[][] resultMatrix = new int[Main.N][Main.N];

            for (int i = 0; i < firstMatrix.length; i++) {
                for (int j = 0; j < firstMatrix.length; j++) {
                    resultMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];

                }
            }
            return resultMatrix;
        }

        private int[] multIntegerWithVector(int[] vector, int value) {
            for (int i = 0; i < vector.length; i++) {
                vector[i] = vector[i] * value;
            }

            return vector;
        }
    }

    public static void main(String[] args) {

        FirstTask firstTask = new FirstTask();
        SecondTask secondTask = new SecondTask();
        ThirdTask thirdTask = new ThirdTask();

        firstTask.setPriority(10);
        secondTask.setPriority(5);
        thirdTask.setPriority(1);

        firstTask.start();
        secondTask.start();
        thirdTask.start();

        try {
            firstTask.join();
            secondTask.join();
            thirdTask.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("\nT1\n");
        firstTask.displayResult1(resultMatrix1);
        System.out.printf("\nT2\n");
        secondTask.displayResult2(resultMatrix1);
        System.out.printf("\nT3\n");
        thirdTask.displayResult3(resultVector);

    }
}