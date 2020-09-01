package srp;

import java.util.Comparator;
import java.util.function.Predicate;

public class ReportEngine {
    private final Store store;
    private final Predicate filter;
    private final Comparator cmp;
    private final Output out;
    private final RowBuilder rb;

    public ReportEngine(Store store, ReportFactory reportFactory) {
        this.store = store;
        this.filter = reportFactory.getFilter();
        this.cmp = reportFactory.getComparator();
        this.out = reportFactory.getOutput();
        this.rb = reportFactory.getRowBuilder();
    }

    // формат вывода (вывод) >> Output
    // состав вывода (поля, формат полей) >>
    // **сортировка >> кампаратор

    public String generate() {
        //StringBuilder text = new StringBuilder();
        //text.append("Name; Hired; Fired; Salary");
        out.append(rb.buildFirstRow());
        var el = store.findBy(filter);
        el.sort(cmp);
        for (var row : el) {
            out.append(rb.buildRow(row));
//            text.append(employee.getName()).append(";")
//                    .append(employee.getHired()).append(";")
//                    .append(employee.getFired()).append(";")
//                    .append(employee.getSalary()).append(";");
        }
        //return text.toString();
        return out.getStringResult();
    }
}
