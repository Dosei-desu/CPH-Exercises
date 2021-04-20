package business.services;

public class BmiUtil {

    public static Double calcBMI(Double height, Double weight){
        return weight / ((height/100) * (height/100));
    }

    public static String getCategory(Double bmi){
        String category = "";

        if(bmi > 30){
            category = "Obese";
        }else if(bmi > 25){
            category = "Overweight";
        }else if(bmi >= 18.5){
            category = "Normal";
        }else{
            category = "Underweight";
        }

        return category;
    }
}
