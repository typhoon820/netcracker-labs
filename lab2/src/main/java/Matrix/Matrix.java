package Matrix;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    private int[][] elemets;

    private int rows, cols;

    public Matrix(int rows, int cols, boolean random) {
        this.rows = rows;
        this.cols = cols;
        elemets = new int[rows][cols];
        if (random) {
            Random rng = new Random();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int num = rng.nextInt(100);
                    elemets[i][j] = num;
                }
            }
        }
    }

    public int[][] getElemets() {
        return elemets;
    }

    public void setElemets(int[][] elemets) {
        this.elemets = elemets;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }


    public int get(int i, int j) throws ArrayIndexOutOfBoundsException {
        return elemets[i][j];
    }

    public void set(int i, int j, int value) throws ArrayIndexOutOfBoundsException {
        elemets[i][j] = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix = (Matrix) o;

        if (rows != matrix.rows) return false;
        if (cols != matrix.cols) return false;
        return Arrays.deepEquals(elemets, matrix.elemets);
    }

    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(elemets);
        result = 31 * result + rows;
        result = 31 * result + cols;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int[] rows : elemets) {
            sb.append("| ");
            for (int elem : rows) {
                sb.append(elem).append((elem / 10 > 0) ? " " : "  ");
            }
            sb.append("|").append("\n");
        }
        return sb.toString();
    }
}
