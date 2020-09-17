import static org.junit.Assert.*;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GeneratorTest {
    @Test
    public void whenOk() {
        String template = "str1 = ${str1}, str2 = ${str2}";
        Map<String, String> substs = new HashMap<>();
        substs.put("str1", "aaa");
        substs.put("str2", "bbb");
        Generator gen = new GeneratorStr();
        assertTrue("str1 = aaa, str2 = bbb".equals(gen.produce(template, substs)));
    }

    @Test(expected=Exception.class)
    public void whenNoValuesInMap() {
        String template = "str1 = ${str1}, str2 = ${str2}";
        Map<String, String> substs = new HashMap<>();
        Generator gen = new GeneratorStr();
        gen.produce(template, substs);
    }

    @Test(expected=Exception.class)
    public void whenLessValuesInMap() {
        String template = "str1 = ${str1}, str2 = ${str2}";
        Map<String, String> substs = new HashMap<>();
        substs.put("str1", "aaa");
        Generator gen = new GeneratorStr();
        gen.produce(template, substs);
    }

    @Test(expected=Exception.class)
    public void whenTooMuchValuesInMap() {
        String template = "str1 = ${str1}, str2 = ${str2}";
        Map<String, String> substs = new HashMap<>();
        substs.put("str1", "aaa");
        substs.put("str2", "bbb");
        substs.put("str3", "bbb");
        Generator gen = new GeneratorStr();
        gen.produce(template, substs);
    }

    @Test
    public void whenTemplateHaveNoSubst() {
        String template = "str1 = aaa, str2 = bbb";
        Map<String, String> substs = new HashMap<>();
        Generator gen = new GeneratorStr();
        assertTrue(template.equals(gen.produce(template, substs)));
    }
}