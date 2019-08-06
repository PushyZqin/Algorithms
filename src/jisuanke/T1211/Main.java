package jisuanke.T1211;

import java.util.Scanner;

/**
 * @author Pushy
 * @since 2019-5-8 15:39:21
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] strs = line.split(" ");

            int W = Integer.parseInt(strs[0]), H = Integer.parseInt(strs[1]);

            char[][] matrix = new char[H][W];
            for (int i = 0; i < H; i++) {
                line = scanner.nextLine().trim();
                matrix[i] = line.toCharArray();
            }

            int res = solution(matrix, W, H);
            count = 0;
            System.out.println(res);
        }
    }

    private static int count = 0;

    private static final Integer[][] next = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    private static int solution(char[][] matrix, int w, int h) {
        boolean[][] visited = new boolean[h][w];
        int startX = -1, startY = -1;

        for (int i = 0; i < matrix.length; i++) {  // 找到起始点的坐标
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '@') {
                    startX = i;
                    startY = j;
                }
            }
        }
        dfs(matrix, visited, startX, startY);
        return count;
    }

    private static void dfs(char[][] matrix, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nextX = x + next[i][0];
            int nextY = y + next[i][1];

            if (nextX < 0 || nextX >= matrix.length || nextY < 0 || nextY >= matrix[0].length
                    || visited[nextX][nextY] || matrix[nextX][nextY] != '.') {
                continue;
            }
            dfs(matrix, visited, nextX, nextY);
        }
    }

}