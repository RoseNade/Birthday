package Utils;

import java.time.LocalDate;

public class DateFactory {
    public static LocalDate getLocalDate(){
        return LocalDate.of(DateUtil.ranNum(1960, 2010), DateUtil.ranNum(1,12), DateUtil.ranNum(1,28));
    }
}
