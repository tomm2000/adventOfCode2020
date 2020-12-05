public class Document {
    String raw;
    int fields;
    String cid = null; // (Country ID)

    public Document(String raw) {
        this.raw = raw;
        parseDocument();
    }

    public void parseDocument() {
        parseDocument(this.raw);
    }

    public void parseDocument(String text) {
        boolean ok = true;
        this.fields = 0;
        int a = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                String id = text.substring(a, a + 4);
                String val = text.substring(a + 4, i);
                a = i + 1;

                switch (id) {
                    case "byr":
                        ok = Tlib.sw(val.length() == 4, ok);
                        ok = Tlib.sw(Integer.parseInt(val) >= 1920, ok);
                        ok = Tlib.sw(Integer.parseInt(val) <= 2002, ok);
                        break;

                    case "iyr":
                        ok = Tlib.sw(val.length() == 4, ok);
                        ok = Tlib.sw(Integer.parseInt(val) >= 2010, ok);
                        ok = Tlib.sw(Integer.parseInt(val) <= 2020, ok);
                        break;

                    case "hgt":
                        ok = Tlib.sw(val.length() == 4 || val.length() == 5, ok);
                        String meas = val.substring(val.length() - 2);
                        String num = val.substring(0, val.length() - 2);
                        if (meas.equals("cm")) {
                            ok = Tlib.sw(Integer.parseInt(num) >= 150, ok);
                            ok = Tlib.sw(Integer.parseInt(num) <= 193, ok);
                        } else if (meas.equals("in")) {
                            ok = Tlib.sw(Integer.parseInt(num) >= 59, ok);
                            ok = Tlib.sw(Integer.parseInt(num) <= 76, ok);
                        } else {
                            ok = Tlib.sw(false, ok);
                        }
                        break;

                    case "ecl":
                        ok = Tlib.sw(val.length() == 7, ok);
                        for (int j = 1; j < val.length(); j++) {
                            char c = val.charAt(j);
                            ok = Tlib.sw(((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f')), ok);
                        }
                        break;

                    case "pid":
                        ok = Tlib.sw(val.length() == 9, ok);
                        for (int j = 0; j < val.length(); j++) {
                            char c = val.charAt(j);
                            ok = Tlib.sw((c >= '0' && c <= '9'), ok);
                        }
                        break;

                    case "cid":
                        ok = Tlib.sw(true, ok);

                }
            }
        }
    }

    public boolean check() {
        // System.out.println("fields: " + this.fields);
        return this.fields == 7;
    }
}