package projetoboot;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Set;

public class Functions {

    public static String SetToString(Set<String> set) {
        String ret = "";
        boolean first = true;
        for (String s : set) {            
            if (!first) {
                ret += " ";
            }
            ret += s;
            first = false;
        }
        return ret;
    }

    public static boolean CheckDateIsValid(int[] calendar) {
        boolean ret;
        try {
            LocalDate.of(calendar[0] > 0 ? calendar[0] : 2016, calendar[1] > 0
                    ? calendar[1] : 12, calendar[2] > 0 ? calendar[2] : 1);
            ret = true;
        } catch (DateTimeException e) {
            ret = false;
        }
        return ret;
    }
}

