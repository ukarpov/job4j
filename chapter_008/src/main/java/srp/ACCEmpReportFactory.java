package srp;

import java.text.SimpleDateFormat;

public class ACCEmpReportFactory extends DefaultEmpReportFactory {
    @Override
    public RowBuilder<Employee> getRowBuilder() {
        return new RowBuilder<Employee>() {
            @Override
            public String buildRow(Employee data) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                return data.getName() + "; "
                        + sdf.format(data.getHired().getTime()) + "; "
                        + sdf.format(data.getFired().getTime()) + "; "
                        + String.format("%1$,.2f", data.getSalary()) + "; ";
            }

            @Override
            public String buildFirstRow() {
                return "Name; Hired; Fired; Salary; ";
            }
        };
    }
}
