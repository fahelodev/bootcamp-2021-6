package katas.nmarinucci;

public class Paper{
    public static int paperWork(int n, int m){
        int blanckPages = n*m;
        if(n<0 || m<0) blanckPages = 0;
        return blanckPages;
    }
}