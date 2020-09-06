package srp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class DefaultEmpReportFactory implements ReportFactory<Employee> {
    @Override
    public Predicate<Employee> getFilter() {
        return (em -> true);
    }

    @Override
    public Comparator<Employee> getComparator() {
        return Comparator.comparing(Employee::getName);
    }

    @Override
    public Output getOutput() {
        return new TextOutput();
    }

    @Override
    public RowBuilder<Employee> getRowBuilder() {
        return new RowBuilder<Employee>() {
            @Override
            public List<ReportCell> buildRow(Employee data) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                List<ReportCell> row = new ArrayList<>();
                row.add(new ReportCell("Name", data.getName()));
                row.add(new ReportCell("Hired", sdf.format(data.getHired().getTime())));
                row.add(new ReportCell("Fired", sdf.format(data.getFired().getTime())));
                row.add(new ReportCell("Salary", Double.toString(data.getSalary())));
                return row;
            }

            @Override
            public List<ReportCell> buildFirstRow() {
                List<ReportCell> fr = new ArrayList<>();
                fr.add(new ReportCell("Name", "Name"));
                fr.add(new ReportCell("Hired", "Hired"));
                fr.add(new ReportCell("Fired", "Fired"));
                fr.add(new ReportCell("Salary", "Salary"));
                return fr;
            }
        };
    }
}
