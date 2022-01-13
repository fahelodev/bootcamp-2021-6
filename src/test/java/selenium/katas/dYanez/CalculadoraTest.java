package junit;



import org.junit.*;

import static org.junit.Assert.*;

public class CalculadoraTest {

    Calculadora calculadoraTest;


    @Before
    public void Setup(){
        //configurar las pre-condiciones del Test
        calculadoraTest = new Calculadora();

        System.out.println("before()");
    }

    @After
    public void after(){
        //Espacio para confirmar/ejecutar/validar  las poscondicones
        System.out.println("before()");
    }

    @Test
    public void testSub(){
        System.out.println("testSub()");
        Calculadora calculadoraTest = new Calculadora();
        int resultadoObtenido = calculadoraTest.sub(3,2);
        int resultadoEsperado = 1;
        assertEquals(resultadoObtenido, resultadoEsperado);
    }

    public void Close(){
        System.out.println("after()");
    }

    @Test
    public void testSum(){
        System.out.println("testSum()");
        int resultado = calculadoraTest.add(3,2);
        int resultadoEsperado = 5;
        assertEquals(resultado,resultadoEsperado);
    }

    @Test
    public void testAnsSum(){
        System.out.println("testAnsSum()");
        int resultado = calculadoraTest.add(3,2);
        int resultadoEsperado = calculadoraTest.ans();
        assertEquals(resultado,resultadoEsperado);
    }

    @Test
    public void testSuB(){
        System.out.println("testSuB()");
        int resultado = calculadoraTest.sub(3,2);
        int resultadoEsperado = 1;
        assertEquals(resultado,resultadoEsperado);
    }

    @BeforeClass
    public static void beforeClass(){
        //instanciar otras Clases que son necesarias para la ejecucion del test
        System.out.println("beforeClass()");
    }

    @AfterClass
    public static void CloseClass(){
        //instanciar otras Clases que son necesarias para la ejecucion del test
        System.out.println("afterClass()");
    }


}