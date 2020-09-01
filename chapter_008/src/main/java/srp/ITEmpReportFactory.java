package srp;

public class ITEmpReportFactory extends DefaultEmpReportFactory {
    @Override
    public Output getOutput() {
        return new HTMLOutput();
    }
}
