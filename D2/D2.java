import java.io.IOException;

public class D2 {
    public static void main(String[] args) throws IOException {
        String fileName = "data.txt";
        String[] list = Tlib.readFile(fileName);
        Token[] tokens = new Token[list.length];

        int c = 0;

        for (int i = 0; i < list.length; i++) {
            tokens[i] = new Token(list[i]);
        }
        for (int i = 0; i < list.length; i++) {
            if (tokens[i].check2()) {
                c++;
            }

            System.out.println(tokens[i]);
        }
        System.out.println("\nvalid passwords: " + c + "/" + tokens.length);
    }
}