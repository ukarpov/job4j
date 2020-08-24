package ru.job4j.io;

public class ArgZip {

    private final String[] args;
    private String dir = "";
    private String ext = "";
    private String out = "";
    private boolean isValid = true;

    public ArgZip(String[] args) {
        this.args = args;
    }

    private void checkParam(String param, String msg) {
        if (param.equals("")) {
            System.out.println(msg);
            isValid = false;
        }
    }

    public void validate() {
        for (int i = 0; i < this.args.length; i++) {
            switch (this.args[i]) {
                case "-d":
                    dir = this.args[++i];
                    break;
                case "-e":
                    ext = this.args[++i];
                    break;
                case "-o":
                    out = this.args[++i];
                    break;
                default:
                    System.out.println("Unsupported param " + this.args[i]);
                    isValid = false;
            }
        }

        checkParam(dir, "Source directory is not defined!");
        checkParam(ext, "Excluded files are not defined!");
        checkParam(out, "Result file is not defined!");
    }

    public boolean valid() {
        validate();
        return isValid;
    }

    public String directory() {
        return dir;
    }

    public String exclude() {
        return ext;
    }

    public String output() {
        return out;
    }
}
