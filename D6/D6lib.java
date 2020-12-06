import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class D6lib {

    static String readFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line;
        String text = "";

        int i = 0;
        while ((line = br.readLine()) != null) {
            text += line + '\n';
            i++;
        }

        // close resources
        br.close();
        fr.close();
        // System.out.print("ciccia");
        return text;
    }

    static String[] organize(String[] text) {

        String[] out = new String[countEmptyLines(text)];
        int j = 0;

        for (int i = 0; i < out.length; i++) {
            out[i] = "";
        }

        for (int i = 0; i < text.length; i++) {
            if (text[i] != null && !text[i].isBlank()) {
                out[j] += text[i] + " ";
            } else {
                j++;
            }
        }
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
            System.out.println("[" + s[i] + "]");
        }
    }

    static int countEmptyLines(String[] arr) {
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null || arr[i].isBlank()) {
                c++;
            }
        }
        return c;
    }
}
