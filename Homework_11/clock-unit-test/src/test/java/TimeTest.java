import static org.junit.Assert.*;
import org.junit.Test;

public class TimeTest {

    @Test
    public void testConstructorWithValidString_HHMMSS() {
        Time time = new Time("1:25:37");
        assertEquals(1, time.getHours());
        assertEquals(25, time.getMinutes());
        assertEquals(37, time.getSeconds());
        assertEquals("1:25:37", time.toString());
    }

    @Test
    public void testConstructorWithValidString_MMSS() {
        Time time = new Time("45:20");
        assertEquals(0, time.getHours());
        assertEquals(45, time.getMinutes());
        assertEquals(20, time.getSeconds());
        assertEquals("45:20", time.toString());
    }

    @Test
    public void testConstructorWithInvalidStringFormat() {
        try {
            new Time("invalid");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("invalid is not a valid time", e.getMessage());
        }
    }

    @Test
    public void testConstructorWithInvalidStringValues() {
        try {
            new Time("25:61");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("25:61 is not a valid time", e.getMessage());
        }
    }

    @Test
    public void testConstructorWithDoubleUnder60Minutes() {
        Time time = new Time(45.5);
        assertEquals(0, time.getHours());
        assertEquals(45, time.getMinutes());
        assertEquals(30, time.getSeconds());
        assertEquals("45:30", time.toString());
    }

    @Test
    public void testConstructorWithDoubleOver60Minutes() {
        Time time = new Time(125.75); // 2 hours, 5 minutes, 45 seconds
        assertEquals(2, time.getHours());
        assertEquals(5, time.getMinutes());
        assertEquals(45, time.getSeconds());
        assertEquals("2:05:45", time.toString());
    }

    @Test
    public void testToValue() {
        Time time = new Time("1:30:00");
        assertEquals(90.0, time.toValue(), 0.0001);
    }

    @Test
    public void testPaddingInConvertMethod() {
        Time time = new Time("1:5:7");
        assertEquals("1:05:07", time.toString());
    }

    @Test
    public void testExactHourInDoubleConstructor() {
        Time time = new Time(120.0); // Exactly 2 hours
        assertEquals(2, time.getHours());
        assertEquals(0, time.getMinutes());
        assertEquals(0, time.getSeconds());
        assertEquals("2:00:00", time.toString());
    }

    @Test
    public void testTimeExceedingLimitsInStringConstructor() {
        try {
            new Time("0:60:00");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("0:60:00 is not a valid time", e.getMessage());
        }
    }

    @Test
    public void testNegativeTimeInStringConstructor() {
        try {
            new Time("-1:30");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("-1:30 is not a valid time", e.getMessage());
        }
    }

    @Test
    public void testNegativeTimeInDoubleConstructor() {
        try {
            new Time(-45.0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Time cannot be negative", e.getMessage());
        }
    }

    @Test
    public void testTimeEqualTo60InConvertMethod() {
        Time time = new Time(60.0);
        assertEquals(1, time.getHours());
        assertEquals(0, time.getMinutes());
        assertEquals(0, time.getSeconds());
        assertEquals("1:00:00", time.toString());
    }

    @Test
    public void testRoundUpSeconds() {
        Time time = new Time(10.999); // Should round seconds to 60, increment minutes
        assertEquals(0, time.getHours());
        assertEquals(11, time.getMinutes());
        assertEquals(0, time.getSeconds());
        assertEquals("11:00", time.toString());
    }

    @Test
    public void testMaximumTimeInDoubleConstructor() {
        Time time = new Time(999.999);
        assertEquals(16, time.getHours());
        assertEquals(40, time.getMinutes()); // Corrected expected value
        assertEquals(0, time.getSeconds());  // Corrected expected value
        assertEquals("16:40:00", time.toString());
    }


    @Test
    public void testZeroTime() {
        Time time = new Time(0.0);
        assertEquals(0, time.getHours());
        assertEquals(0, time.getMinutes());
        assertEquals(0, time.getSeconds());
        assertEquals("0:00", time.toString());
    }
}
