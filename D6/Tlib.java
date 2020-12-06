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

  static void printArray(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println('[' + arr[i] + ']');
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

  public static boolean sw(boolean sw, boolean value) {
    if (sw) {
      return value;
    } else {
      return false;
    }
  }

  public static int avg(int a, int b) {
    return (int) (a + b) / 2;
  }

  static void bubbleSort(int[] arr) {
    int n = arr.length;
    int temp = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 1; j < (n - i); j++) {
        if (arr[j - 1] > arr[j]) {
          // swap elements
          temp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = temp;
        }

      }
    }

  }

  static char[] appendChar(char[] s, char text) {

    char[] out = new char[s.length + 1];

    for (int i = 0; i < s.length; i++) {
      out[i] = s[i];
    }
    out[out.length - 1] = text;
    return out;
  }

  static int countLinesString(String s) {
    int c = 1;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '\n') {
        c++;
      }
    }
    System.out.println("lines: " + c);
    return c;
  }

  static String[] stringToArr(String s) {
    String[] out = new String[countLinesString(s)];
    int j = 0;
    int n = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '\n') {
        out[n] = s.substring(j, i);
        j = i + 1;
        n++;
      }
    }
    return out;
  }

  static int countChars(String s, char c) {
    int n = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == c) {
        n++;
      }
    }
    return n;
  }
}
