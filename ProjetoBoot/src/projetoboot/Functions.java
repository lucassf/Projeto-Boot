package projetoboot;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Set;

public class Functions {
    
    // Exibe os elementos de um set de strings separados por vírgula
    public static String SetToString(Set<String> set) {
        String ret = "";
        boolean first = true;
        for (String s : set) {
            ret += s;
            if (!first){
                ret+=",";
            }
            first=false;
        }
        return ret.substring(1);
    }
    
    // Verifica o array "calendar" é uma data válida
    // calendar[0] = ano, calendar[1]=mês, calendar[2] = dia
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
    
    // Retorna um formato padronizado de representação de data
    public static String getDateFormat(){
        return "dd/MM/yyyy - HH:mm:ss";
    }
}
