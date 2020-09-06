package srp;

import java.util.List;

public interface Output {
    void append(List<ReportCell> columns);
    String getResult();
}
