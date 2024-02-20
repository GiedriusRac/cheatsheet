import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({Hooks.class, FirstTest.class})
public class SuiteTest {
}
