package co.pragra.learning.springjpa13apr24.utility;

import org.hibernate.query.sqm.sql.internal.AnyDiscriminatorPathInterpretation;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

public class CasioTest {

    Casio casio;

    UtilityHelper utilityHelper = Mockito.mock(UtilityHelper.class);
    @Before
    public void before(){
        casio = new Casio(utilityHelper);
    }
    @Test
    public void actionTest(){
        // When and then return statemets
//        Mockito.when(utilityHelper.calculate(Mockito.anyInt(),Mockito.anyInt())).thenReturn(6);
//        Assertions.assertEquals(17, casio.action(3));
        //Mockito.times(2).verify(utilityHelper.calculate(Mockito.anyInt(),Mockito.anyInt()));
    }
    //Mock -> Mockito framework
}
