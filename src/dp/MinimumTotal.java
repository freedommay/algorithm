package dp;

public class MinimumTotal {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        int dimension = triangle.length;
        int[][] result = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            result[dimension - 1][i] = triangle[dimension - 1][i];
        }
        for (int i = dimension - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                result[i][j] = Math.min(result[i+1][j], result[i+1][j+1]) + triangle[i][j];
            }
        }
        return result[0][0];
    }
}
