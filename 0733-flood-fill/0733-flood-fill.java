class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if(color==originalColor){
            return image;
        }
        floodFill(image, sr, sc,color,originalColor);
        return image;
        
    }   
    public int[][] floodFill(int[][] image, int sr, int sc, int color, int originalColor) {
        image[sr][sc] = color;
        int[][] dir = { {-1, 0} , {0, 1} , {0, -1} , {1, 0}};
        int n = image[0].length;
        for(int i=0; i<dir.length; i++){
            int x = sr + dir[i][0];
            int y = sc + dir[i][1];
            if(x < 0 || x >= image.length || y < 0 || y >= image[0].length){
                continue;
            }
            if(image[x][y] == originalColor){
                floodFill(image, x, y, color);
            }
        }
        return image;
    }
}