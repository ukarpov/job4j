package ru.job4j.io;

public class FindArgs {
    private final String[] args;
    private String dir = "";
    private String mask = "";
    private String out = "";
    private String regexp;
    private FindModes mode;
    private boolean is_valid = true;

    public FindArgs(String[] args) {
        this.args = args;
    }

    public enum FindModes {
        BY_MASK,
        BY_EXACT,
        BY_REGEXP
    }

    public void validate() {
        for(int i = 0; i < this.args.length; i++) {
            switch (this.args[i]) {
                case "-d":
                    dir = this.args[++i];
                    break;
                case "-n":
                    mask = this.args[++i];
                    break;
                case "-m":
                    setMode(FindModes.BY_MASK);
                    break;
                case "-f":
                    setMode(FindModes.BY_EXACT);
                    break;
                case "-r":
                    setMode(FindModes.BY_REGEXP);
                    break;
                case "-o":
                    out = this.args[++i];
                    break;
                default:
                    System.out.println("Unsupported param " + this.args[i]);
                    is_valid = false;
            }
        }

        checkParam(dir, "Source directory is not defined!");
        checkParam(mask, "Search mask is not defined!");
        checkParam(out, "Result file is not defined!");
        checkParam(mode, "Search mode is not defined!");
    }

    private void setMode(FindModes mode) {
        if (this.mode == null) {
            this.mode = mode;
            if (this.mode == FindModes.BY_MASK || this.mode == FindModes.BY_REGEXP) {
                regexp = this.mask.replace(".", "\\.").replace("*", ".*");
            }
        } else {
            System.out.println("Multiply modes parameter");
            is_valid = false;
        }
    }

    private void checkParam(String p, String msg) {
        if (p.equals("")) {
            System.out.println(msg);
            is_valid = false;
        }
    }

    private void checkParam(FindModes param, String msg) {
        if (param == null) {
            System.out.println(msg);
            is_valid = false;
        }
    }

    public boolean valid() {
        validate();
        return is_valid;
    }

    public String directory() {
        return dir;
    }

    public FindModes mode() {
        return mode;
    }

    public String mask() {
        return mask;
    }

    public String regexp() {
        return regexp;
    }

    public String output() {
        return out;
    }

    public static void printHelp() {
        System.out.println(
                "Ключи" + System.lineSeparator() +
                "    -d - директория в которая начинать поиск." + System.lineSeparator() +
                "    -n - имя файл, маска, либо регулярное выражение." + System.lineSeparator() +
                "    -m - искать по макс, либо -f - полное совпадение имени. -r регулярное выражение." + System.lineSeparator() +
                "    -o - результат записать в файл." + System.lineSeparator() + System.lineSeparator() +
                "Пример: java -jar find.jar -d c:/ -n *.txt -m -o log.txt");
    }
}
