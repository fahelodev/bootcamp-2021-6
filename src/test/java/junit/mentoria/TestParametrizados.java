package junit.mentoria;

import static org.junit.Assert.*;

import junit.mentoria.Calculadora;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(value = Parameterized.class)
public class TestParametrizados {

   /*  Pruebas a realizar para metodo Multiplicacion
            +*+ = +  -> 5,5,25
            +*- = -  -> 5,-5,-25
            -*+ = - -> -5,5,-25
            -*- = + -> -5,-5,25
  */

    private int num1,num2,validacion;

    public TestParametrizados(int num1, int num2, int validacion) {
        this.num1 = num1;
        this.num2 = num2;
        this.validacion = validacion;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]> datosParametrizados = new ArrayList<>();
        datosParametrizados.add(new Object[] {5,5,25});
        datosParametrizados.add(new Object[] {5,-5,-25});
        datosParametrizados.add(new Object[] {-5,5,-25});
        datosParametrizados.add(new Object[] {-5,-5,25});
        return datosParametrizados;
    }

    @Test
    public void validacionSignosDeMultiplicar(){
        Calculadora calculadora = new Calculadora();
        int res = calculadora.multiplicar(num1,num2);
        assertEquals(validacion,res);
    }

}
