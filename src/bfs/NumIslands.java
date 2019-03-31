package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int lands = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j]) {
                    markByBFS(grid, i, j);
                    lands++;
                }
            }
        }
        return lands;
    }

    private class Coordinate {
        private int x;
        private int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void markByBFS(boolean[][] grid, int x, int y) {
        int[] directionX = {0, 1, 0, -1};
        int[] directionY = {1, 0, -1, 0};
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        while (!queue.isEmpty()) {
            Coordinate coor = queue.poll();
            for (int i = 0; i < 4; i++) {
                Coordinate adj = new Coordinate(
                        coor.x + directionX[i],
                        coor.y + directionY[i]
                );
                if (isValid(adj, grid) && grid[adj.x][adj.y]) {
                    grid[adj.x][adj.y] = false;
                    queue.offer(adj);
                }
            }
        }

    }

    private boolean isValid(Coordinate coor, boolean[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        return coor.x >= 0 && coor.x < column && coor.y >= 0 && coor.y < row;
    }
}
