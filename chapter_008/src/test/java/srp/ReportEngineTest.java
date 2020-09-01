package srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store, new DefaultEmpReportFactory());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary; ")
                .append(System.lineSeparator())
                .append(worker.getName()).append("; ")
                .append(sdf.format(worker.getHired().getTime())).append("; ")
                .append(sdf.format(worker.getFired().getTime())).append("; ")
                .append(worker.getSalary()).append("; ")
                .append(System.lineSeparator());
        assertThat(engine.generate(), is(expect.toString()));
    }

    @Test
    public void whenITFormat() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store, new ITEmpReportFactory());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        StringBuilder expect = new StringBuilder()
                .append("<html><body>").append(System.lineSeparator())
                .append("Name; Hired; Fired; Salary; ")
                .append(System.lineSeparator())
                .append(worker.getName()).append("; ")
                .append(sdf.format(worker.getHired().getTime())).append("; ")
                .append(sdf.format(worker.getFired().getTime())).append("; ")
                .append(worker.getSalary()).append("; ")
                .append(System.lineSeparator())
                .append("</body></html>");
        assertThat(engine.generate(), is(expect.toString()));
    }

    @Test
    public void whenACCFormat() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store, new ACCEmpReportFactory());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary; ")
                .append(System.lineSeparator())
                .append(worker.getName()).append("; ")
                .append(sdf.format(worker.getHired().getTime())).append("; ")
                .append(sdf.format(worker.getFired().getTime())).append("; ")
                .append(String.format("%1$,.2f", worker.getSalary())).append("; ")
                .append(System.lineSeparator());
        assertThat(engine.generate(), is(expect.toString()));
    }

    @Test
    public void whenHRGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store, new HREmpReportFactory());
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary; ")
                .append(System.lineSeparator())
                .append(worker.getName()).append("; ")
                .append(worker.getSalary()).append("; ")
                .append(System.lineSeparator());
        assertThat(engine.generate(), is(expect.toString()));
    }
}
