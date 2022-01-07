package junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
//el archivo .class son los archivos en tiempo de ejecucion
@Suite.SuiteClasses({CalculadoraTest.class, AssertTest.class})
public class JunitRunner {


}
