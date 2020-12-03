import java.io.IOException;

public class D1 {
    public static void main(String[] args) throws IOException {
        String fileName = "data.txt";
        String[] list = Tlib.readFile(fileName);
        int[] intList = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            intList[i] = Integer.valueOf(list[i]);
        }

        int x = 0;
        int y = 0;
        int z = 0;

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                for (int k = 0; k < list.length; k++) {
                    if (intList[i] + intList[j] + intList[k] == 2020) {
                        x = intList[i];
                        y = intList[j];
                        z = intList[k];
                    }
                }
            }
        }

        System.out.print("x: " + x + ", y: " + y + ", z: " + z + ", prod: " + x * y * z);

    }
}