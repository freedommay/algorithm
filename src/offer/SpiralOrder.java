package offer;

import java.util.LinkedList;
import java.util.List;

public class SpiralOrder {

    private List<Integer> result = new LinkedList<>();
    /**
     * @param matrix: a matrix of m x n elements
     * @return: an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) return result;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        while (columns > start * 2 && rows > start * 2) {
            printMatrix(matrix, rows, columns, start);
            start = start + 1;
        }
        return result;
    }

    private void printMatrix(int[][] matrix, int rows, int columns, int start) {
        int endX = columns - start - 1;
        int endY = rows - start - 1;
        for (int i = start; i <= endX; i++) {
            result.add(matrix[start][i]);
        }
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                result.add(matrix[i][endX]);
            }
        }
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                result.add(matrix[endY][i]);
            }
        }
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                result.add(matrix[i][start]);
            }
        }
    }
}
