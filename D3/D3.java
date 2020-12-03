import java.io.IOException;

public class D3 {
    public static void main(String[] args) throws IOException {
        String fileName = "data.txt";
        String[] list = Tlib.readFile(fileName);

        int height = list.length;
        int width = list[0].length();

        System.out.println("height: " + height + ", width: " + width);
        System.out.println("==================");

        char[][] matrix = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = list[i].charAt(j);
            }
        }

        int c = 1;
        c *= testSlope(0, 0, 1, 1, matrix);
        c *= testSlope(0, 0, 3, 1, matrix);
        c *= testSlope(0, 0, 5, 1, matrix);
        c *= testSlope(0, 0, 7, 1, matrix);
        c *= testSlope(0, 0, 1, 2, matrix);

        System.out.print("result: " + c);
    }

    public static int testSlope(int startX, int startY, int stepX, int stepY, char[][] matrix) {
        int x = startX;
        int y = startY;

        int height = matrix.length;
        int width = matrix[0].length;

        int c = 0;
        while (y < height) {
            // System.out.print("x: " + x + ", y: " + y);
            x = Tlib.toMod(x, width);

            if (matrix[y][x] == '#') {
                c++;
                // System.out.print(", hit");
            }
            x += stepX;
            y += stepY;
            // System.out.println("");
        }
        return c;
    }
}