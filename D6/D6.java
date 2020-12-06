import java.io.IOException;

public class D6 {
    public static void main(String[] args) throws IOException {
        String fileName = "data.txt";
        String data = D6lib.readFile(fileName);
        System.out.println(data);

        System.out.println("=======================");
        String[] data2 = Tlib.stringToArr(data);
        Tlib.printArray(data2);

        System.out.println("=======================");
        String[] data3 = D6lib.organize(data2);
        Tlib.printArray(data3);

        System.out.println("=======================");
        Dictionary[] data4 = new Dictionary[data3.length];
        for (int i = 0; i < data4.length; i++) {
            data4[i] = new Dictionary(data3[i]);
            System.out.println(data4[i]);
        }

        System.out.println("=======================");
        int sum = 0;
        for (int i = 0; i < data4.length; i++) {
            sum += data4[i].length();
        }
        System.out.println("somma: " + sum);

    }
}
