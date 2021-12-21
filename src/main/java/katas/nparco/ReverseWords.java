package katas.nparco;

public class ReverseWords {
    public static String reverseWords(String s){
        char[] str = s.toCharArray();
        int cont = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' '){
                reverse(str, cont, i-1);
                cont = i + 1;
            }else if (i == str.length -1){
                reverse(str, cont, i);
            }
        }
        return new String(str);
    }

    private static void reverse(char[] str, int inicio, int fin) {
        while(inicio <= fin){
            char acum = str[inicio];
            str[inicio++] = str[fin];
            str[fin--] = acum;
        }
    }
}
