package srp;

import java.util.List;

public class XMLOutput implements Output {
    final StringBuilder sb = new StringBuilder();

    @Override
    public void append(List<ReportCell> columns) {
        sb.append("<ROW>");
        columns.forEach(s -> sb.append("<"+s.getColumnName()+">").append(s.getColumnValue()).append("</"+s.getColumnName()+">"));
        sb.append("</ROW>").append(System.lineSeparator());
    }

    @Override
    public String getResult() {
        return "<ROOT>" + System.lineSeparator() + sb.toString() + "</ROOT>";
    }
}
