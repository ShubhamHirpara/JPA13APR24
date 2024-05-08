package co.pragra.learning.springjpa13apr24.utility;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class UtilityHelperTest {

    UtilityHelper utilityHelper = null;

    // before methods

    @Before
    public void prepare(){
        utilityHelper = new UtilityHelper();
    }

    @Test
    public void calculateTest(){
        Assertions.assertEquals(2,utilityHelper.calculate(4,2));

    }

    @Test
    public void checkEvenTest(){
        Assertions.assertTrue(utilityHelper.checkEven(2));
    }
    @Test(expected = Exception.class)
    public void calculateTestException(){
        utilityHelper.calculate(2,0);
    }
}
