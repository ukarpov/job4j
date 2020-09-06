package srp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HREmpReportFactory extends DefaultEmpReportFactory {
    @Override
    public Comparator<Employee> getComparator() {
        return (o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary());
    }

    @Override
    public RowBuilder<Employee> getRowBuilder() {
        return new RowBuilder<Employee>() {
            @Override
            public List<ReportCell> buildRow(Employee data) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                List<ReportCell> row = new ArrayList<>();
                row.add(new ReportCell("Name", data.getName()));
                row.add(new ReportCell("Salary", Double.toString(data.getSalary())));
                return row;
            }

            @Override
            public List<ReportCell> buildFirstRow() {
                List<ReportCell> fr = new ArrayList<>();
                fr.add(new ReportCell("Name", "Name"));
                fr.add(new ReportCell("Salary", "Salary"));
                return fr;
            }
        };
    }
}
