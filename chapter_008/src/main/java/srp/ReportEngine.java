package srp;

import java.util.Comparator;
import java.util.function.Predicate;

public class ReportEngine {
    private final Store store;
    private final Predicate filter;
    private final Comparator cmp;
    private Output out;
    private final RowBuilder rb;

    public ReportEngine(Store store, ReportFactory reportFactory) {
        this.store = store;
        this.filter = reportFactory.getFilter();
        this.cmp = reportFactory.getComparator();
        this.out = reportFactory.getOutput();
        this.rb = reportFactory.getRowBuilder();
    }

    public String generate(boolean printHeader) {
        if (printHeader) {
            out.append(rb.buildFirstRow());
        }
        var el = store.findBy(filter);
        el.sort(cmp);
        for (var row : el) {
            out.append(rb.buildRow(row));
        }
        return out.getResult();
    }

    public String generate() {
        return generate(true);
    }

    public void setOutput(Output newOut) {
        this.out = newOut;
    }
}
