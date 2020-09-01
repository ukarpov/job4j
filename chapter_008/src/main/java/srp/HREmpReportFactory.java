package srp;

import java.util.Comparator;

public class HREmpReportFactory extends DefaultEmpReportFactory {
    @Override
    public Comparator<Employee> getComparator() {
        return (o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary());
    }

    @Override
    public RowBuilder<Employee> getRowBuilder() {
        return new RowBuilder<Employee>() {
            @Override
            public String buildRow(Employee data) {
                return data.getName() + "; "
                        + data.getSalary() + "; ";
            }

            @Override
            public String buildFirstRow() {
                return "Name; Salary; ";
            }
        };
    }
}
