package Threads;


import Matrix.Matrix;

public class MatrixRunnable implements Runnable {

    private int rowsCount, offset;
    private Matrix matrixA, matrixB, result;


    public MatrixRunnable(int rowsCount, int offset, Matrix matrixA, Matrix matrixB, Matrix result) {
        this.rowsCount = rowsCount;
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.result = result;
        this.offset = offset;
    }


    @Override
    public void run() {
        for (int i = offset; i < offset + rowsCount; i++) {
            for (int j = 0; j < matrixB.getCols(); j++) {
                int sum = 0;
                for (int k = 0; k < matrixB.getRows(); k++) {
                    sum += matrixA.get(i, k) * matrixB.get(k, j);
                }
                result.set(i, j, sum);
            }
        }

    }
}
