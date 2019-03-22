package offer;

public class GenerateMatrix {
    /**
     * @param n: An integer
     * @return: a square matrix
     */
    public int[][] generateMatrix(int n) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int[][] matrix = new int[n][n];
        int x = 0, y = 0, d = 0;
        int nx = 0, ny = 0;
        for (int i = 1; i <= n * n; i++) {
            matrix[x][y] = i;
            nx = x + dx[d];
            ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || matrix[nx][ny] != 0) {
                d = (d + 1) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
            }
            x = nx;
            y = ny;
        }

        return matrix;
    }
}
