public class Token {
    private int min;
    private int max;
    private char letter;
    private String password;

    public Token(String _input) {
        parse(_input);
    }

    private void parse(String s) {
        int i = 0;
        String str = "";
        while (Character.isDigit(s.charAt(i))) {
            str += s.charAt(i);
            i++;
        }
        min = Integer.parseInt(str);
        i++;

        str = "";
        while (Character.isDigit(s.charAt(i))) {
            str += s.charAt(i);
            i++;
        }
        max = Integer.parseInt(str);
        i++;

        letter = s.charAt(i);
        i++;
        i++;

        password = s.substring(i, s.length());
    }

    private int countLetter() {
        int c = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == letter) {
                c++;
            }
        }
        return c;
    }

    public boolean check() {
        return (countLetter() >= min && countLetter() <= max);
    }

    public boolean check2() {
        boolean a = password.charAt(min) == letter;
        boolean b = password.charAt(max) == letter;
        return Tlib.XOR(a, b);
    }

    public String toString() {
        return min + "-" + max + " " + letter + ": " + password + " ==> " + check2();
    }
}
