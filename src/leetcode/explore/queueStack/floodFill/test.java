package site.pushy.algorithms.leetcode.explore.queueStack.floodFill;

/**
 * @author Pushy
 * @since 2019/4/9 12:13
 */
public class test {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initColor = image[sr][sc];
        if (newColor == initColor) {
            return image;
        }
        DFS(image, sr, sc, newColor, initColor);
        return image;
    }

    public void DFS(int[][] image, int sr, int sc, int newColor, int initColor) {
        image[sr][sc] = newColor;
        if (sr > 0 && image[sr - 1][sc] == initColor) {
            DFS(image, sr - 1, sc, newColor, initColor);
        }
        if (sr < image.length - 1 && image[sr + 1][sc] == initColor) {
            DFS(image, sr + 1, sc, newColor, initColor);
        }

        if (sc > 0 && image[sr][sc - 1] == initColor) {
            DFS(image, sr, sc - 1, newColor, initColor);
        }
        if (sc < image[0].length - 1 && image[sr][sc + 1] == initColor) {
            DFS(image, sr, sc + 1, newColor, initColor);
        }
    }
}
