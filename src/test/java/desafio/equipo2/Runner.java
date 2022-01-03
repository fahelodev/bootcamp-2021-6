package desafio.equipo2;

import junit.framework.JUnit4TestAdapter;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;


@RunWith(AllTests.class) public class Runner {
        public static TestSuite suite() {
            TestSuite suite = new TestSuite();
            suite.addTest(new JUnit4TestAdapter(ATC_Alojamientos.class));
            suite.addTest(new JUnit4TestAdapter(ATC_Traslados.class));
            suite.addTest(new JUnit4TestAdapter(ATC_Paquetes.class));


            return suite; }
    }

