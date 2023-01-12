import org.example.BerlinClock;
import org.junit.Assert;
import org.junit.Test;

public class BerlinClockTest {
    BerlinClock berlinClock = new BerlinClock();
    //testing the minutes reprisentation for the first top row
    @Test
    public void TestSingleMinutesRow(){
        Assert.assertEquals("OOOO",berlinClock.getSingleMinutes("00"));
        Assert.assertEquals("YYYY",berlinClock.getSingleMinutes("59"));
        Assert.assertEquals("YYOO",berlinClock.getSingleMinutes("32"));
        Assert.assertEquals("YYYY",berlinClock.getSingleMinutes("34"));
        Assert.assertEquals("OOOO",berlinClock.getSingleMinutes("35"));
    }
    @Test
    public void TestFiveMinutesRow(){
        Assert.assertEquals("OOOOOOOOOOO",berlinClock.getFiveMinutes("00"));
        Assert.assertEquals("YYRYYRYYRYY",berlinClock.getFiveMinutes("59"));
        Assert.assertEquals("OOOOOOOOOOO",berlinClock.getFiveMinutes("04"));
        Assert.assertEquals("YYRYOOOOOOO",berlinClock.getFiveMinutes("23"));
        Assert.assertEquals("YYRYYRYOOOO",berlinClock.getFiveMinutes("35"));
    }

    @Test
    public void TestSingleHoursRow(){
        Assert.assertEquals("OOOO",berlinClock.getSingleHours("00"));
        Assert.assertEquals("RRRO",berlinClock.getSingleHours("23"));
        Assert.assertEquals("RROO",berlinClock.getSingleHours("02"));
        Assert.assertEquals("RRRO",berlinClock.getSingleHours("08"));
        Assert.assertEquals("RRRR",berlinClock.getSingleHours("14"));
    }

    @Test
    public void TestFiveHoursRow(){
        Assert.assertEquals("OOOO",berlinClock.getFiveHours("00"));
        Assert.assertEquals("RRRR",berlinClock.getFiveHours("23"));
        Assert.assertEquals("OOOO",berlinClock.getFiveHours("02"));
        Assert.assertEquals("ROOO",berlinClock.getFiveHours("08"));
        Assert.assertEquals("RRRO",berlinClock.getFiveHours("16"));
    }

    @Test
    public void testSecondsLamp(){
        Assert.assertEquals("Y",berlinClock.getSecondsLamp("00"));
        Assert.assertEquals("O",berlinClock.getSecondsLamp("59"));
    }

    @Test
    public void testValidDigitalInput() {
        Assert.assertTrue(berlinClock.isValidFormat("13:45:22"));
    }

    @Test
    public void testInvalidHour() {
        Assert.assertFalse(berlinClock.isValidFormat("25:45:22"));
    }

    @Test
    public void testInvalidMinutes() {
        Assert.assertFalse(berlinClock.isValidFormat("13:61:22"));
    }

    @Test
    public void testInvalidSeconds() {
        Assert.assertFalse(berlinClock.isValidFormat("13:45:62"));
    }

    @Test
    public void testMissingSeconds() {
        Assert.assertFalse(berlinClock.isValidFormat("13:45"));
    }
    @Test
    public void testTooManyParts() {
        Assert.assertFalse(berlinClock.isValidFormat("13:45:22:11"));
    }
    @Test
    public void testInvalidDelimiter() {
        Assert.assertFalse(berlinClock.isValidFormat("13-45-22"));
    }

    @Test
    public void testEmptyInput() {
        Assert.assertFalse(berlinClock.isValidFormat(""));
    }
    @Test
    public void testTooManySegments() {
        Assert.assertFalse(berlinClock.isValidFormat("13:45:22:11:12:13"));
    }

    @Test
    public void BerlinToSeconds(){
        Assert.assertEquals("00",berlinClock.berlinToSecondsLamp("Y"));
        Assert.assertEquals("01",berlinClock.berlinToSecondsLamp("O"));
    }
    @Test
    public void berlinToHours(){
        Assert.assertEquals("00",berlinClock.berlinToHours("OOOOOOOO"));
        Assert.assertEquals("23",berlinClock.berlinToHours("RRRRRRRO"));
        Assert.assertEquals("16",berlinClock.berlinToHours("RRROROOO"));
        Assert.assertEquals("11",berlinClock.berlinToHours("RROOROOO"));
    }
    @Test
    public void berlinToMinutes(){
        Assert.assertEquals("00",berlinClock.berlinToMinutes("OOOOOOOOOOOOOOO"));
        Assert.assertEquals("59",berlinClock.berlinToMinutes("YYRYYRYYRYYYYYY"));
        Assert.assertEquals("50",berlinClock.berlinToMinutes("YYRYYRYYRYOOOOO"));
        Assert.assertEquals("37",berlinClock.berlinToMinutes("YYRYYRYOOOOYYOO"));
    }
    @Test
    public void testValidBerlinFormat(){
        Assert.assertTrue(berlinClock.berlinInputIsValid("YRRROROOOYYRYYRYYRYOOOOO"));
        Assert.assertTrue(berlinClock.berlinInputIsValid("ORRRRRRROYYRYYRYYRYYYYYY"));
        Assert.assertTrue(berlinClock.berlinInputIsValid("YRRROROOOYYRYYRYYRYOOOOO"));
        Assert.assertTrue(berlinClock.berlinInputIsValid("ORROOROOOYYRYYRYOOOOYYOO"));
    }
}