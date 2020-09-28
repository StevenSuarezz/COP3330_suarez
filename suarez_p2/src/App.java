import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static final Scanner scan = new Scanner(System.in);

    // Calls scan.nextLine(); to clear the input buffer
    private static void clearInputBuffer(){
        scan.nextLine();
    }

    // Asks the user if they have more information to input
    private static boolean moreInput(){
        System.out.println("Do you wish to enter more data? Enter 'Y' or 'N'");

        String ans = scan.nextLine();
        return ans.toLowerCase().equals("y");
    }

    // Asks the user to enter a height. Only accepts positive values
    private static double getUserHeight(){
        System.out.println("Please enter a valid height in inches: ");

        double height = scan.nextDouble();
        clearInputBuffer();

        if(height <= 0){
            return getUserHeight();
        } else {
            return height;
        }
    }

    // Asks the user to enter a weight. Only accepts positive values
    private static double getUserWeight(){
        System.out.println("Please enter a valid weight in pounds: ");

        double weight = scan.nextDouble();
        clearInputBuffer();

        if(weight <= 0){
            return getUserWeight();
        } else {
            return weight;
        }
    }

    // Displays the BMI score and category of an entry
    private static void displayBmiInfo(BodyMassIndex bmi){
        System.out.println("Score: " + bmi.calculateBmiScore() + ", Category: " + bmi.calculateBmiCategory() + "\n");
    }

    // Averages the BMI scores in the array list that is passed in
    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData){
        double scoreSum = 0.0;

        for (BodyMassIndex bmi : bmiData){
            scoreSum += bmi.calculateBmiScore();
        }

        double average = scoreSum / bmiData.size();

        System.out.println("The average BMI score is: " + average);
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
