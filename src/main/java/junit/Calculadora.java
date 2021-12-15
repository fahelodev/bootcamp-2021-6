package junit;

public class Calculadora {

    private int ans;

    public Calculadora() {
        ans = 0;
    }

    public int add(int numero1, int numero2){
        ans = numero1 + numero2;
        return ans;
    }

    public int sub(int numero1, int numero2){
        ans = numero1 - numero2;
        return ans;
    }

    public int ans() {
        return ans;
    }

}
