import java.io.IOException;

public class D4 {
    public static void main(String[] args) throws IOException {
        String fileName = "data.txt";
        String rawData = D4lib.readFile(fileName);
        // System.out.println(rawData);

        String[] data = D4lib.organize(rawData);

        /// System.out.println("valid passports: " + c);
        D4lib.printArr(data);

        Document[] finalData = new Document[data.length];

        int c = 0;
        for (int i = 0; i < data.length; i++) {
            finalData[i] = new Document(data[i]);

            if (finalData[i].check()) {
                c++;
            }
        }
        System.out.println("valid: " + c + "/" + finalData.length);
    }
}
