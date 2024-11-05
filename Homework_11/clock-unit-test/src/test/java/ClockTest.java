import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ClockTest {

    private Clock clock;

    @Before
    public void setUp() {
        // Initialize a Clock instance before each test
        clock = new Clock(23, 59, 59);
    }

    @Test
    public void testConstructorValidTime() {
        Clock clock = new Clock(12, 30, 45);
        assertEquals("12:30:45", clock.get24HourFormat());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegativeValues() {
        new Clock(-1, 30, 45);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorExceedingHourLimit() {
        new Clock(24, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorExceedingMinuteLimit() {
        new Clock(12, 60, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorExceedingSecondLimit() {
        new Clock(12, 0, 60);
    }

    @Test
    public void testAddSecond() {
        clock.addSecond();
        assertEquals("00:00:00", clock.get24HourFormat());
    }

    @Test
    public void testAddMinute() {
        clock.addMinute();
        assertEquals("00:00:59", clock.get24HourFormat());
    }

    @Test
    public void testAddHour() {
        clock.addHour();
        assertEquals("00:59:59", clock.get24HourFormat());
    }

    @Test
    public void testGet24HourFormat() {
        Clock clock = new Clock(5, 7, 9);
        assertEquals("05:07:09", clock.get24HourFormat());
    }

    @Test
    public void testGet12HourFormatAM() {
        Clock clock = new Clock(5, 7, 9);
        assertEquals("5:07:09 AM", clock.get12HourFormat());
    }

    @Test
    public void testGet12HourFormatPM() {
        Clock clock = new Clock(15, 7, 9);
        assertEquals("3:07:09 PM", clock.get12HourFormat());
    }

    @Test
    public void testGet12HourFormatMidnight() {
        Clock clock = new Clock(0, 0, 0);
        assertEquals("12:00:00 AM", clock.get12HourFormat());
    }

    @Test
    public void testGet12HourFormatNoon() {
        Clock clock = new Clock(12, 0, 0);
        assertEquals("12:00:00 PM", clock.get12HourFormat());
    }

    @Test
    public void testPadMethod() {
        // Testing the pad method indirectly via get24HourFormat
        Clock clock = new Clock(9, 8, 7);
        assertEquals("09:08:07", clock.get24HourFormat());
    }

    @Test
    public void testAddSecondIncrementMinute() {
        Clock clock = new Clock(12, 34, 59);
        clock.addSecond();
        assertEquals("12:35:00", clock.get24HourFormat());
    }

    @Test
    public void testAddMinuteIncrementHour() {
        Clock clock = new Clock(12, 59, 0);
        clock.addMinute();
        assertEquals("13:00:00", clock.get24HourFormat());
    }

    @Test
    public void testAddHourWrapAround() {
        Clock clock = new Clock(23, 0, 0);
        clock.addHour();
        assertEquals("00:00:00", clock.get24HourFormat());
    }
}
