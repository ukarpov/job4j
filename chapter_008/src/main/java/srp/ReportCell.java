package srp;

public class ReportCell {
    private final String columnName;
    private final String columnValue;

    public ReportCell(String columnName, String columnValue) {
        this.columnName = columnName;
        this.columnValue = columnValue;
    }


    public String getColumnName() {
        return columnName;
    }

    public String getColumnValue() {
        return columnValue;
    }
}
