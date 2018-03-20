package Threads;

import Exceptions.MatrixMultiplyException;
import Matrix.Matrix;

import java.util.ArrayList;
import java.util.List;

public class MultithreadMultiplyer {

    public Matrix multiply (Matrix matrixA, Matrix matrixB, int threadCount) throws InterruptedException, MatrixMultiplyException {
        List<Integer> rows = new ArrayList<>();
        int totalRowCount = matrixA.getRows();
        if (matrixA.getRows() == matrixB.getCols() && matrixA.getCols() == matrixB.getRows()){
            Matrix res = new Matrix(matrixA.getRows(), matrixB.getCols(), false);
            //rows.add(0);
            for (int i =0; i< threadCount; i++){
                int rowCount = totalRowCount/(threadCount-i);
                rows.add(rowCount);
                totalRowCount -= rowCount;
            }
            List<Thread> threads = new ArrayList<>();
            int offset = 0;
            for (int i =0; i< threadCount; i++){
                if(rows.get(i)>0) {
                    threads.add(new Thread(new MatrixRunnable(rows.get(i), offset, matrixA, matrixB, res)));
                }
                offset += rows.get(i);
            }
            for(Thread thread: threads){
                thread.start();
            }
            for(Thread thread: threads){
                thread.join();
            }
            return res;
        }else {
            throw new MatrixMultiplyException(
                    String.format("Invalid size of input matrices. %dx%d * %dx%d",
                    matrixA.getCols(),matrixA.getRows(),
                    matrixB.getCols(),matrixB.getRows()));
        }
    }
}
