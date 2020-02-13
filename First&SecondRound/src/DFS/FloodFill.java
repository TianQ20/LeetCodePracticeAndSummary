package DFS;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int Color = image[sr][sc];
        if (Color != newColor) {
            dfs(image, sr, sc, Color, newColor);
        }
        return image;
    }

    private void dfs(int[][] image, int r, int c, int Color, int newColor) {
        if (image[r][c] == Color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r - 1, c, Color, newColor);
            if (c >= 1) dfs(image, r, c - 1, Color, newColor);
            if (r + 1 < image.length) dfs(image, r + 1, c, Color, newColor);
            if (c + 1 < image[0].length) dfs(image, r, c + 1, Color, newColor);
        }
    }
}