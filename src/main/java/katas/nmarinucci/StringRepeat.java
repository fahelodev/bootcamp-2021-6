package katas.nmarinucci;

import java.util.Collections;

public class StringRepeat {
    public static String repeatStr(final int repeat, final String string){
        return String.join("", Collections.nCopies(repeat, string));
    }
}
