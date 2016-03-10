/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Work_define;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Fast
 */
public class changeformat_date {

    /**
     * convert date format dd-MM-yyyy to yyyy-MM-dd
     * @param date
     * @return
     */
    public String change_date(String date) {
        final SimpleDateFormat sdf_yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
        final SimpleDateFormat sdf_ddMMyyyy = new SimpleDateFormat("dd-MM-yyyy");

        java.util.Date judDate1 = new java.util.Date();

        try {
            judDate1 = sdf_ddMMyyyy.parse(date);
        } catch (ParseException e) {
        }

        java.sql.Date sqlDate1 = new java.sql.Date(judDate1.getTime());

        date = sdf_yyyyMMdd.format(sqlDate1);

        return date;
    }

    /**
     * convert date format yyyy-MM-dd to dd-MM-yyyy
     * @param date
     * @return
     */
    public String change_date_reverse(String date) {
        final SimpleDateFormat sdf_yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
        final SimpleDateFormat sdf_ddMMyyyy = new SimpleDateFormat("dd-MM-yyyy");

        java.util.Date judDate1 = new java.util.Date();

        try {
            judDate1 = sdf_yyyyMMdd.parse(date);
        } catch (ParseException e) {
        }

        java.sql.Date sqlDate1 = new java.sql.Date(judDate1.getTime());

        date = sdf_ddMMyyyy.format(sqlDate1);

        return date;
    }
}
