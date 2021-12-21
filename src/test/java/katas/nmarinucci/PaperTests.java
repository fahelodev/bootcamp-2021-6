package katas.nmarinucci;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PaperTests {

    @Test
    public void test1(){
        assertEquals("Failed at paperWork(5,5)",25, Paper.paperWork(5,5));
    }

    @Test
    public void test2(){
        assertEquals("Failed at paperWork(5,-5)",0, Paper.paperWork(5,-5));
    }

    @Test
    public void test3(){
        assertEquals("Failed at paperWork(-5,-5)",0, Paper.paperWork(-5,-5));
    }

    @Test
    public void test4(){
        assertEquals("Failed at paperWork(-5,5)",0, Paper.paperWork(-5,5));
    }

    @Test
    public void test5(){
        assertEquals("Failed at paperWork(5,0)",0, Paper.paperWork(5,0));
    }
}