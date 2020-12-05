import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class D5lib {

    static String[] readFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String[] lines = new String[Tlib.countLines(fileName)];
        int i = 0;

        while ((line = br.readLine()) != null) {
            lines[i] = line;
            i++;
        }
        // close resources
        br.close();
        fr.close();
        // System.out.print("ciccia");
        return lines;
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
            System.out.println("[" + s[i] + "]");
        }
    }

    static String parseSeat(String code) {
        String out = "";
        for (int i = 0; i < 10; i++) {
            if (code.charAt(i) == 'B' || code.charAt(i) == 'R') {
                out += '1';
            } else if (code.charAt(i) == 'F' || code.charAt(i) == 'L') {
                out += '0';
            }
        }
        return out;
    }
}
