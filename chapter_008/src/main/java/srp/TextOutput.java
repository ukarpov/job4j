package srp;

public class TextOutput implements Output {
    final StringBuilder sb = new StringBuilder();

    @Override
    public void append(String s) {
        sb.append(s).append(System.lineSeparator());
    }

    @Override
    public String getStringResult() {
        return sb.toString();
    }
}
