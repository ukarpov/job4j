package srp;

import java.util.List;

public class JSONOutput implements Output {
    final StringBuilder sb = new StringBuilder();

    @Override
    public void append(List<ReportCell> columns) {
        sb.append("{");
        columns.forEach(s -> sb.append(s.getColumnName() + ": ").append(s.getColumnValue()).append(", " + System.lineSeparator()));
        sb.append("}").append(System.lineSeparator());
    }

    @Override
    public String getResult() {
        return "{[" + System.lineSeparator() + sb.toString() + "]}";
    }
}
