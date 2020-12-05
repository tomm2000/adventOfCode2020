import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class D4lib {

    static String readFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line;
        String text = "";

        while ((line = br.readLine()) != null) {
            text += "\n" + line;
        }

        // close resources
        br.close();
        fr.close();
        // System.out.print("ciccia");
        return text;
    }

    static String[] organize(String text) {
        int a = 1;
        String[] out = new String[0];

        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) == '\n' && text.charAt(i + 1) == '\n') {
                out = append(out, text.substring(a, i));
                a = i + 2;
            }
        }
        out = append(out, text.substring(a, text.length()));
        return out;
    }

    static String[] append(String[] s, String text) {

        String[] out = new String[s.length + 1];

        for (int i = 0; i < s.length; i++) {
            out[i] = s[i];
        }
        out[out.length - 1] = text;
        return out;
    }

    static void printArr(String[] s) {
        for (int i = 0; i < s.length; i++) {
            System.out.println("[ " + s[i] + " ]\n");
        }
    }
}
