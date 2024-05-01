package co.pragra.learning.springjpa13apr24.utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilityHelperTest {

    UtilityHelper utilityHelper = new UtilityHelper();
    @Test
    public void calculateTest(){
        Assertions.assertEquals(10,utilityHelper.calculate(2,3));

    }

    @Test
    public void checkEvenTest(){
        Assertions.assertTrue(utilityHelper.checkEven(2));
    }
}
