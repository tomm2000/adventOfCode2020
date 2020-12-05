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
        System.out.println("total string (" + text + ")");
        this.fields = 0;
        int a = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ' || text.charAt(i) == '\n' || i == text.length() - 1) {
                String id = text.substring(a, a + 4);
                String val;

                if (i == text.length() - 1) {
                    val = text.substring(a + 4);
                } else {
                    val = text.substring(a + 4, i);
                }

                System.out.print("evaluing string (" + id + " " + val + ")");
                a = i + 1;

                switch (id) {
                    case "byr:":
                        if (!(val.length() == 4)) {
                            break;
                        }
                        if (!(Integer.parseInt(val) >= 1920)) {
                            break;
                        }
                        if (!(Integer.parseInt(val) <= 2002)) {
                            break;
                        }
                        this.fields++;
                        break;

                    case "iyr:":
                        if (!(val.length() == 4)) {
                            break;
                        }
                        if (!(Integer.parseInt(val) >= 2010)) {
                            break;
                        }
                        if (!(Integer.parseInt(val) <= 2020)) {
                            break;
                        }
                        this.fields++;
                        break;

                    case "eyr:":
                        if (!(val.length() == 4)) {
                            break;
                        }
                        if (!(Integer.parseInt(val) >= 2020)) {
                            break;
                        }
                        if (!(Integer.parseInt(val) <= 2030)) {
                            break;
                        }
                        this.fields++;
                        break;

                    case "hgt:":
                        if (!(val.length() == 4 || val.length() == 5)) {
                            break;
                        }
                        String meas = val.substring(val.length() - 2);
                        String num = val.substring(0, val.length() - 2);
                        if (meas.equals("cm")) {
                            if (!(Integer.parseInt(num) >= 150)) {
                                break;
                            }
                            if (!(Integer.parseInt(num) <= 193)) {
                                break;
                            }
                        } else if (meas.equals("in")) {
                            if (!(Integer.parseInt(num) >= 59)) {
                                break;
                            }
                            if (!(Integer.parseInt(num) <= 76)) {
                                break;
                            }
                        } else {
                            if (!(false)) {
                                break;
                            }
                        }
                        this.fields++;
                        break;

                    case "hcl:":
                        if (!(val.length() == 7)) {
                            break;
                        }
                        for (int j = 1; j < val.length(); j++) {
                            char c = val.charAt(j);
                            if (!(((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f')))) {
                                break;
                            }
                        }
                        this.fields++;
                        break;

                    case "ecl:":
                        if (!(val.length() == 3)) {
                            break;
                        }
                        boolean ok = false;
                        switch (val) {
                            case "amb":
                            case "blu":
                            case "brn":
                            case "gry":
                            case "grn":
                            case "hzl":
                            case "oth":
                                ok = true;
                                break;
                            default:
                                ok = false;
                        }
                        if (ok)
                            this.fields++;
                        break;

                    case "pid:":
                        if (!(val.length() == 9)) {
                            break;
                        }
                        for (int j = 0; j < val.length(); j++) {
                            char c = val.charAt(j);
                            if (!((c >= '0' && c <= '9'))) {
                                break;
                            }
                        }
                        this.fields++;
                        break;

                    case "cid:":
                        // this.fields++;
                        break;
                }
                System.out.println(" " + this.fields);
            }
        }
    }

    public boolean check() {
        System.out.println("fields: " + this.fields + "\n");
        return this.fields >= 7;
    }
}