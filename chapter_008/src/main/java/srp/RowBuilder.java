package srp;

import java.util.List;

public interface RowBuilder<T> {
    List<ReportCell> buildRow(T data);
    List<ReportCell> buildFirstRow();
}
