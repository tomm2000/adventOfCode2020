import javax.swing.text.Document;

public class Dictionary {
    private char[] content;

    public Dictionary() {
        content = new char[0];
    }

    public Dictionary(String str) {
        Dictionary[] d = new Dictionary[Tlib.countChars(str, ' ')];
        int n = 0;

        for (int i = 0; i < d.length; i++) {
            d[i] = new Dictionary();
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                n++;
            } else {
                d[n].push(str.charAt(i));
            }
        }

        Dictionary a = intersect(d);
        this.content = a.getContent();
    }

    public void push(char c) {
        if (!contains(c) && c != '\n')
            content = Tlib.appendChar(content, c);
    }

    public boolean contains(char c) {
        for (int i = 0; i < content.length; i++) {
            if (content[i] == c) {
                return true;
            }
        }
        return false;
    }

    public int length() {
        return content.length;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < content.length; i++) {
            s += content[i];
        }
        return "[" + s + "]";
    }

    public char[] getContent() {
        return content;
    }

    public char charAt(int i) {
        return content[i];
    }

    public static Dictionary intersect(Dictionary a, Dictionary b) {
        Dictionary out = new Dictionary();
        for (int i = 0; i < a.length(); i++) {
            if (b.contains(a.charAt(i))) {
                out.push(a.charAt(i));
            }
        }
        return out;
    }

    public static Dictionary intersect(Dictionary[] d) {
        for (int i = 0; i < d[0].length(); i++) {
            for (int j = 0; j < d.length; j++) {
                d[0] = intersect(d[0], d[j]);
            }
        }
        return d[0];
    }
}
