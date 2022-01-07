package junit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class AssertTest {

    @Test
    public void numeros() {
        //enteros
        assertEquals(4,4);//validacion positiva
        assertNotEquals(4,3);//validacion negativa

        //float
        assertEquals(2.56,2.50,0.1);
    }



    @Test
    public void arrays() {
        //declarando un objeto array
        ArrayList<String> arrayList1 = new ArrayList<String>();
        ArrayList<String> arrayList2 = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            String elementoDelArray = ""+(i+1);
            arrayList1.add(elementoDelArray);
            arrayList2.add(elementoDelArray);
        }
        //assertEquals(arrayList1,arrayList2);

        //convertir objeto array a array clasico
        String[] array1 = arrayList1.toArray(new String[0]);
        String[] array2 = arrayList2.toArray(new String[0]);
        assertArrayEquals(array1,array2);



    }

    @Test
    public void objetos() throws InterruptedException {

        //comprar objetos si estan en la mismo espacio de memoria

        Date objeto1 = new Date();
        //Thread.sleep(5000);
        Date objeto2 = objeto1;


       // assertEquals(objeto1,objeto2);//comparo atributos
        assertSame(objeto1,objeto2);

    }
}