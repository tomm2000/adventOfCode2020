import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Tlib {

  static String[] readFile(String fileName) throws IOException {
    File file = new File(fileName);
    FileReader fr = new FileReader(file);
    BufferedReader br = new BufferedReader(fr);
    String line;
    String[] lines = new String[countLines(fileName)];
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

  static int countLines(String filename) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    int lines = 0;
    while (reader.readLine() != null)
      lines++;
    reader.close();
    return lines;
  }

  static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static boolean XOR(boolean a, boolean b) {
    return (a && !b) || (!a && b);
  }

  public static int toMod(int n, int mod) {
    if (n < mod) {
      return n;
    } else {
      return toMod(n - mod, mod);
    }
  }
}
