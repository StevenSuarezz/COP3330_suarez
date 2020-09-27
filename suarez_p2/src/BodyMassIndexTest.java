import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {

    // Score tests
    @Test
    public void testBmiScoreUnderweight(){
        BodyMassIndex bmi = new BodyMassIndex(72, 120);

        assertEquals(16.3, bmi.calculateBmiScore());
    }

    @Test
    public void testBmiScoreNormalWeight(){
        BodyMassIndex bmi = new BodyMassIndex(72, 150);

        assertEquals(20.3, bmi.calculateBmiScore());
    }

    @Test
    public void testBmiScoreOverweight(){
        BodyMassIndex bmi = new BodyMassIndex(72, 200);

        assertEquals(27.1, bmi.calculateBmiScore());
    }

    @Test
    public void testBmiScoreObesity(){
        BodyMassIndex bmi = new BodyMassIndex(72, 300);

        assertEquals(40.7, bmi.calculateBmiScore());
    }

    // Category tests
    @Test
    public void testBmiCategoryUnderweight(){
        BodyMassIndex bmi = new BodyMassIndex(72, 120);

        assertEquals("Underweight", bmi.calculateBmiCategory());
    }

    @Test
    public void testBmiCategoryNormalWeight(){
        BodyMassIndex bmi = new BodyMassIndex(72, 150);

        assertEquals("Normal Weight", bmi.calculateBmiCategory());
    }

    @Test
    public void testBmiCategoryOverweight(){
        BodyMassIndex bmi = new BodyMassIndex(72, 200);

        assertEquals("Overweight", bmi.calculateBmiCategory());
    }

    @Test
    public void testBmiCategoryObesity(){
        BodyMassIndex bmi = new BodyMassIndex(72, 300);

        assertEquals("Obesity", bmi.calculateBmiCategory());
    }


}