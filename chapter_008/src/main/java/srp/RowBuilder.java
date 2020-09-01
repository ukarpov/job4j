package srp;

import java.util.List;

public interface RowBuilder<T> {
    String buildRow(T data);
    String buildFirstRow();
}
