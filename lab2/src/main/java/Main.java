import Exceptions.MatrixMultiplyException;
import Matrix.Matrix;
import Threads.MultithreadMultiplyer;

public class Main {
    public static void main(String[] args) {
        int size = 1000;
        int threads = 4;
        Matrix a = new Matrix(size, size -200, true);
        Matrix b = new Matrix(size-200, size, true);
        Matrix c = new Matrix(a.getCols(), b.getRows(), false);
        Matrix d = new Matrix(a.getCols(), b.getRows(), false);

        MultithreadMultiplyer multiplyer = new MultithreadMultiplyer();
        try {
            c = multiplyer.multiply(a,b,threads);
        } catch (InterruptedException | MatrixMultiplyException e) {
            e.printStackTrace();
        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
