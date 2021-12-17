package junit.mentoria;

import org.junit.Test;

public class ParametrosAnotacionTest {

    @Test(expected = ArithmeticException.class)
    public void errorDivisionCeroTest(){
        int num1 =20;
        int num2 =0;
        int divCero = num1/num2;
    }

    @Test(timeout = 1200)
    public void testDeTiempoLimite(){
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
