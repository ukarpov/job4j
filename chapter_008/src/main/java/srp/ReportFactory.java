package srp;

import java.util.Comparator;
import java.util.function.Predicate;

public interface ReportFactory<T> {
    Predicate<T> getFilter();
    Comparator<T> getComparator();
    Output getOutput();
    RowBuilder<T> getRowBuilder();
}
