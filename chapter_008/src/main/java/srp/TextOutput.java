package srp;

import java.util.List;

public class TextOutput implements Output {
    final StringBuilder sb = new StringBuilder();

    @Override
    public void append(List<ReportCell> columns) {
        columns.stream().forEach(s -> sb.append(s.getColumnValue()).append("; "));
        sb.append(System.lineSeparator());
    }

    @Override
    public String getResult() {
        return sb.toString();
    }
}
