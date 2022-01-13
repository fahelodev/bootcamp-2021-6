package junit;

import org.junit.Test;

public class ParametrosFuncionTest {

    @Test(expected = ArithmeticException.class)
    public void errorDivisionCeroTest() {
        int num1 = 20;
        int num2 = 0;
        int divCero = num1 / num2;
    }
    @Test(timeout = 1200)
    public void testDeTiempoLimite() {
        try{
            Thread.sleep(800);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
