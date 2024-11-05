/**
 * The Clock class representing the time in 
 * both 12 hour h:mm:ss AM/PM and 
 * 24 hour hh:mm:ss formats.
 * 
 * @author mcpar
 *
 */
public class Clock {
	
	private int hours;
	private int minutes;
	private int seconds;
	

	/**
	 * Constructor
	 * @param hours - the initial hours
	 * @param minutes - the initial minutes
	 * @param seconds - the initial seconds
	 */
	public Clock(int hours, int minutes, int seconds) {
		// Bug fix: Added checks for maximum values (hours >= 24, minutes and seconds >= 60)
		// Also corrected the exception message to reflect that negative values are not permitted
		if (hours < 0 || hours >= 24 || minutes < 0 || minutes >= 60 || seconds < 0 || seconds >= 60) { 
			throw new IllegalArgumentException("Invalid time values provided");
		}
		
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	/**
	 * Add an hour to the clock.
	 */
	public void addHour() {
	    // Bug fix: Simplified to keep hours within 0-23 using modulo operation
	    hours = (hours + 1) % 24;
	}
	
	/**
	 * Add a minute to the clock.
	 */
	public void addMinute() {
	    // Bug fix: Corrected logic to increment minutes and reset to 0 when reaching 60
	    // Also calls addHour() when minutes reset to 0
	    minutes = (minutes + 1);
	    if (minutes >= 60) {
	        minutes = 0;
	        addHour();
	    }
	}

	/**
	 * Add a second to the clock.
	 */
	public void addSecond() {
	    // Bug fix: Corrected logic to increment seconds and reset to 0 when reaching 60
	    // Also calls addMinute() when seconds reset to 0
	    seconds = (seconds + 1);
	    if (seconds >= 60) {
	        seconds = 0;
	        addMinute();
	    }
	}
	
	/**
	 * Get the time in 24 hour format: hh:mm:ss
	 * @return - the 24 hour format time
	 */
	public String get24HourFormat() {
	    String format24;

	    format24 = pad(hours) + ":" + pad(minutes) + ":" + pad(seconds);

	    return format24;
	}

	/**
	 * Get the suffix
	 * @return - the suffix
	 */
	private String getSuffix() {
	    String suffix;

	    if (hours < 12) {
	        suffix = "AM";
	    }
	    else {
	        suffix = "PM";
	    }

	    return suffix;
	}

	/**
	 * Get the 12 hour format: h:mm:ss AM/PM
	 * @return - the 12 hour format
	 */
	public String get12HourFormat() {
	    // Bug fix: Use a local variable for displayHour to avoid modifying the hours field
	    int displayHour = hours;
	    if (displayHour == 0) {
	    	displayHour = 12;
	    }
	    else if (displayHour > 12) {
	    	displayHour = displayHour - 12;
	    }

	    String format12 = displayHour + ":" + pad(minutes) + ":" + pad(seconds) + " " + getSuffix();

	    return format12;
	}

	/**
	 * Pads a value as a two-digit representation.
	 * e.g. 9 is "09"
	 * @param value - the value to pad
	 * @return - the value as two-digits.
	 */
	private String pad(int value) {
	    // Bug fix: Corrected condition to 'value < 10' to pad single-digit numbers from 0 to 9
	    if (value < 10) {
	        return "0" + value;
	    }
	    else {
	        return String.valueOf(value);
	    }
	}
	
}
