package pt.luissantos.verspaetung.lines.utils;


import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;


public class TimeUtilTest {

    @Test
    public void testStringIsParsedIntoLocalTime() {

        LocalTime lt = TimeUtil.parseTime("120559");

        Assert.assertEquals(LocalTime.of(12,05,59),lt);

    }

    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void testThatInvalidTimeThrowsException() {

        LocalTime lt = TimeUtil.parseTime("120560");
    }


    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void testThatInvalidTimeFormatThrowsException() {

        LocalTime lt = TimeUtil.parseTime("AA0560");
    }
}
