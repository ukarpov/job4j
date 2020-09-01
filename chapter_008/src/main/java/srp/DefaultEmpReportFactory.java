package srp;

import java.text.SimpleDateFormat;
import java.util.Comparator;
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
            public String buildRow(Employee data) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                return data.getName() + "; "
                        + sdf.format(data.getHired().getTime()) + "; "
                        + sdf.format(data.getFired().getTime()) + "; "
                        + data.getSalary() + "; ";
            }

            @Override
            public String buildFirstRow() {
                return "Name; Hired; Fired; Salary; ";
            }
        };
    }
}
