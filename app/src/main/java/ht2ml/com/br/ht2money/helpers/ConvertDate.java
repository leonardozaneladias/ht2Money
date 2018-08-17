package ht2ml.com.br.ht2money.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConvertDate {

    public static Calendar stringToDate(String strDate){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(strDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return c;
    }
}
