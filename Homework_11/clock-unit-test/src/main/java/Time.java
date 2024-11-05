/**
 * A time for a race distance.
 * Can be in the form MM:SS or HH:MM:SS
 */
public class Time {
    
    private final String strTime;
    private final double dblTime;
    private Integer hours;
    private Integer minutes;
    private Integer seconds;
    
    /**
     * Constructor
     * Example usage: 1:25:37
     * @param time - the time as a string
     * @throws IllegalArgumentException if the time cannot be parsed properly
     */
    public Time(String time) {
        String[] tokens = time.split(":");
        
        if (tokens.length == 2) {
            try {
                minutes = Integer.parseInt(tokens[0]);
                seconds = Integer.parseInt(tokens[1]);
                
                if (seconds < 0 || seconds > 59 || minutes < 0 || minutes > 59) {
                    throw new IllegalArgumentException(time + " is not a valid time");
                }
                
                // Bug fix: Ensure dblTime is calculated correctly in minutes
                this.dblTime = minutes + seconds / 60.0;
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException(time + " is not a valid time");
            }
        } else if (tokens.length == 3) {
            try {
                hours = Integer.parseInt(tokens[0]);
                minutes = Integer.parseInt(tokens[1]);
                seconds = Integer.parseInt(tokens[2]);
                
                if (seconds < 0 || seconds > 59 || minutes < 0 || minutes > 59 || hours < 0) {
                    throw new IllegalArgumentException(time + " is not a valid time");
                }
                
                // Bug fix: Correct calculation of dblTime in minutes
                this.dblTime = 60 * hours + minutes + seconds / 60.0;
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException(time + " is not a valid time");
            }
        } else {
            throw new IllegalArgumentException(time + " is not a valid time");
        }
        
        // Bug fix: Ensure fields are set consistently
        this.strTime = convert(this.dblTime);
    }

    /**
     * Constructor. 
     * Example usage: 4.5 = "4:30"
     * @param time - the time as a double value
     * @throws IllegalArgumentException if time is negative
     */
    public Time(double time){
        // Bug fix: Check for negative time values
        if (time < 0) {
            throw new IllegalArgumentException("Time cannot be negative");
        }
        this.dblTime = time;
        this.strTime = convert(time);
    }

    /**
     * Get the hours of this time.
     * @return - the hours
     */
    public int getHours(){
        return hours == null ? 0 : hours;
    }

    /**
     * Get the minutes for this time
     * @return - the minutes
     */
    public int getMinutes(){
        return minutes == null ? 0 : minutes;
    }

    /**
     * Get the seconds for this time
     * @return - the seconds
     */
    public int getSeconds(){
        return seconds == null ? 0 : seconds;
    }
    
    /**
     * Get the time as a double
     * Example: 4.5 = "4:30"
     * @return - the time
     */
    public double toValue() {
        return dblTime;
    }
    
    @Override
    /**
     * Get the time as a string
     * "4:14" or "3:07:48"
     * @return - the string representation
     */
    public String toString() {
        return this.strTime;
    }

    private String convert(double time) {
        String convertedTime;

        if (time < 60){
            convertedTime = convert(time, false);
        } else {
            int convertedHours = (int) (time / 60);
            double convertedMinutes = time - (60 * convertedHours);
            this.hours = convertedHours;
            // Bug fix: Ensure minutes and seconds are set correctly
            convertedTime = convertedHours + ":" + convert(convertedMinutes, true);
        }

        return convertedTime;
    }

    private String convert(double time, boolean hasHours){
        // Bug fix: Changed condition to 'time > 60' to allow time equal to 60 minutes
        if (time > 60){
            throw new IllegalArgumentException("Time exceeds 60 minutes.");
        }

        int convertedMinutes = (int)time;
        double convertedSeconds = 60 * (time - convertedMinutes);

        // Bug fix: Remove redundant casting and rounding
        int roundedSeconds = (int)Math.round(convertedSeconds);

        if (roundedSeconds == 60) {
            convertedMinutes++;
            roundedSeconds = 0;
        }
        
        // Bug fix: Set minutes and seconds correctly
        if (hasHours) {
            this.minutes = convertedMinutes;
        } else {
            this.minutes = convertedMinutes;
        }
        this.seconds = roundedSeconds;

        return (hasHours ? pad(convertedMinutes) : convertedMinutes) + ":" + pad(roundedSeconds);
    }
    
    /**
     * Bug fix: Added missing 'pad' method to format numbers less than 10
     * Pads a value as a two-digit representation.
     * e.g., 9 becomes "09"
     * @param value - the value to pad
     * @return - the padded string
     */
    private String pad(int value) {
        return (value < 10) ? "0" + value : String.valueOf(value);
    }
}
