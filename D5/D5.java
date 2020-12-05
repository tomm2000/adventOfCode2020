import java.io.IOException;

public class D5 {
    public static void main(String[] args) throws IOException {
        String fileName = "data.txt";
        String[] data = D5lib.readFile(fileName);
        int[] id = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            id[i] = Integer.parseInt(D5lib.parseSeat(data[i]), 2);
        }

        /*
         * int min = Integer.MAX_VALUE; int minPos = 0; int max = 0; int maxPos = 0; for
         * (int i = 0; i < data.length; i++) { if (id[i] > max) { max = id[i]; maxPos =
         * i; } if (id[i] < min) { min = id[i]; minPos = i; } }
         */

        Tlib.bubbleSort(id);

        System.out.println(id[0]);
        System.out.println(id[id.length - 1]);

        int missing = 0;
        int c = 0;

        for (int i = 0; i < id.length - 1; i++) {
            if (id[i] != id[i + 1] - 1) {
                missing = id[i];
                c++;
            }
        }

        System.out.println("seat id: " + (missing + 1) + ", debug: " + c);

    }
}
