package srp;

public class HTMLOutput implements Output {
    final StringBuilder sb = new StringBuilder();

    @Override
    public void append(String s) {
        sb.append(s).append(System.lineSeparator());
    }

    @Override
    public String getStringResult() {
        return "<html><body>" + System.lineSeparator() + sb.toString() + "</body></html>";
    }
}
