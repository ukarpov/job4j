package srp;

import java.util.List;

public class HTMLOutput implements Output {
    final StringBuilder sb = new StringBuilder();

    @Override
    public void append(List<ReportCell> columns) {
        sb.append("<tr>");
        columns.forEach(s -> sb.append("<th>").append(s.getColumnValue()).append("</th>"));
        sb.append("</tr>").append(System.lineSeparator());
    }

    @Override
    public String getResult() {
        return "<html><body><table>" + System.lineSeparator() + sb.toString() + "</table></body></html>";
    }
}
