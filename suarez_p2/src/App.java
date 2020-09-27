import java.util.ArrayList;

public class App {

    private static boolean moreInput(){
        return false;
    }

    private static double getUserHeight(){
        return 0;
    }

    private static double getUserWeight(){
        return 0;
    }

    private static void displayBmiInfo(BodyMassIndex bmi){

    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData){

    }

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

}
