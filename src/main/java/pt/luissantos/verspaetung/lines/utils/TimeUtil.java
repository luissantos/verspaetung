package pt.luissantos.verspaetung.lines.utils;

import javax.validation.ConstraintViolationException;
import java.time.LocalTime;
import java.util.HashSet;

public class TimeUtil {

    public static LocalTime parseTime(String time){

        if(time == null || time.length() != 6){
            throw new ConstraintViolationException( "Invalid time format. Correct format is HHMMSS",new HashSet<>());
        }

        try {
            String h  = time.substring(0,2);
            String m = time.substring(2,4);
            String s = time.substring(4,6);


            return LocalTime.of(Integer.parseInt(h),Integer.parseInt(m),Integer.parseInt(s));
        }catch (Exception ex){
            throw new ConstraintViolationException( "Invalid time format. Correct format is HHMMSS",new HashSet<>());
        }

    }
}
