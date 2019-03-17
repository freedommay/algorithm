package offer;

public class SearchMatrix {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return 0;
        int r = matrix.length;
        int c = matrix[0].length;
        int number = 0;
        for (int i = r - 1, j = 0; i >= 0 && j < c;) {
            if (matrix[i][j] == target) {
                number++;
                i--;
                j++;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return number;
    }
}
