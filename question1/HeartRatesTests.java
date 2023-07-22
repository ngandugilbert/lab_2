import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HeartRatesTests {
    // Test max heart rate
    @Test
    public void MaxHeartRateTest() {
        // arrange
        var user = new HeartRates();
        var expected = 196.00;

        // act
        user.setBirthDate(01, 2, 1999);
        var actual = user.getMaxHeartRate();
        // assert
        assertEquals(expected, actual);
    }

    // test for upper range
    @Test
    public void testUpperRange() {
        // arrange
        var user = new HeartRates();
        var expected = 166.60;
        // act

        user.setBirthDate(01, 2, 1999);
        var actual = user.getUpperRange();
        // assert
        assertEquals(expected, actual);
    }

    // test for lower range
    @Test
    public void testLowerRange() {
        // arrange
        var user = new HeartRates();
        var expected = 98.00;
        // act
        user.setBirthDate(01, 2, 1999);
        var actual = user.getLowerRange();
        // assert
        assertEquals(expected, actual);
    }
}
