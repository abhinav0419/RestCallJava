package com.rest.attendance.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    
    public static String formatDateDDMMYYYYHHMMSS(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        
        if(date != null) {
            return format.format(date);
        }
        
        return null;
    }
    
    public static String formatDateYYYYMMDD(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        if(date != null)
        {
            return format.format(date);
        }
        return null;
    }
    
}
