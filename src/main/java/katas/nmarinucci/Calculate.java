package katas.nmarinucci;

public class Calculate {
    public static String bmi(double weight, double height){
        double bmiVar = weight / (height*height);
        String bmiRes = "";
        if(bmiVar > 30) bmiRes = "Obese";
        if(bmiVar <= 30.0) bmiRes = "Overweight";
        if(bmiVar <= 25.0) bmiRes = "Normal";
        if(bmiVar <= 18.5) bmiRes = "Underweight";
        return bmiRes;
    }
}
