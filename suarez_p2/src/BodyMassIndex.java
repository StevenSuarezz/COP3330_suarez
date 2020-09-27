public class BodyMassIndex {
    private double height;
    private double weight;

    public BodyMassIndex(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public double calculateBmiScore(){
        double score = 703 * weight / Math.pow(height, 2);
        double roundedScore = Math.round(score * 10) / 10.0;

        return roundedScore;
    }

    public String calculateBmiCategory(){
        double score = calculateBmiScore();

        if(score < 18.5){
            return "Underweight";
        } else if (score <= 24.9){
            return "Normal Weight";
        } else if(score <= 29.9){
            return "Overweight";
        } else {
            return "Obesity";
        }
    }

}
