import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BMICalcTest {
    
    private static final double DELTA = 0.01; 
    
    @Test
    public void testBMICalculation() {
        // Test case 1: Standard BMI calculation
        float weight1 = 70.0f;
        float height1 = 1.75f;
        double expectedBMI1 = 22.86; 
        double actualBMI1 = BMICalc.calculateBMI(weight1, height1);
        assertEquals(expectedBMI1, actualBMI1, DELTA, 
            "BMI calculation failed for weight=70kg, height=1.75m");
        
        // Test case 2: Different values
        float weight2 = 85.0f;
        float height2 = 1.80f;
        double expectedBMI2 = 26.23; 
        double actualBMI2 = BMICalc.calculateBMI(weight2, height2);
        assertEquals(expectedBMI2, actualBMI2, DELTA,
            "BMI calculation failed for weight=85kg, height=1.80m");
        
        // Test case 3: Verify result is positive (confirms double calculation)
        assertTrue(actualBMI1 > 0, "BMI result should be positive");
        assertTrue(actualBMI2 > 0, "BMI result should be positive");
    }
}