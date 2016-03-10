/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fonctions;

import Hib_util.HibernateUtil_airbus;
import Work.Services;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.hibernate.Query;
import org.hibernate.Session;

public class consult_serv {

    static Locale locale = Locale.getDefault();
    static Date actuelle = new Date();
    static DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

    public static String date() {

        String dat = dateformat.format(actuelle);
        return dat;

    }

    /**
     *
     * @return list of services
     */
    public static List<Services> getServices() {
        List<Services> lstservices = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            Query q = sh.createQuery("from Services");

            lstservices = (List<Services>) q.list();

        } catch (Exception e) {
        }

        return lstservices;
    }

    /**
     *
     * @param serv
     * @return steps from a specific phase example ground check for delivery
     * phase
     */
    public static List<String> getServicesPart(String serv) {
        List<String> lstservices = null;
        try {

            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();
            char cher = serv.charAt(0);

            List L = sh.createSQLQuery("select NAME_" + cher + " from " + serv + "").list();

            lstservices = (List<String>) L;

        } catch (Exception e) {
        }

        return lstservices;
    }

    /**
     *
     * @param serv
     * @return
     */
    public static List<Object[]> getStep(String serv) {
        List<Object[]> lstinsp = null;


        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();
        String cher = serv.substring(0, 5);


        if ("delivery".equals(serv)) {

            Query L = sh.createSQLQuery("select del.NAME_D, ac.AIRCRAFT_TYPE, ow.SHORT_NAME, insp.FIRST_NAME_I, "
                    + " InsD.ID_D , InsD.ID_I, InsD.MSN, InsD.ID_L  "
                    + "from delivery del, inspect_" + cher + " InsD , aircraft  ac, owner ow,  inspector insp "
                    + " where 	InsD.MAIL_D = 'Not sent' and InsD.STATUS_DEL  = 'Not inspected' "
                    + "and ac.MSN = InsD.MSN "
                    + "and ow.ID_OW =ac.ID_OW  and InsD.ID_I = insp.ID_I "
                    + "and del.ID_D = InsD.ID_D order by ac.AIRCRAFT_TYPE desc ");

            lstinsp = (List<Object[]>) L.list();

        } else if ("fal".equals(serv)) {

            Query L = sh.createSQLQuery("select del.NAME_F, ac.AIRCRAFT_TYPE, ow.SHORT_NAME, insp.FIRST_NAME_I "
                    + " from fal del, inspect_Fal InsD , aircraft  ac, owner ow,  inspector insp "
                    + " where "
                    + "  ac.MSN = InsD.MSN "
                    + " and ow.ID_OW =ac.ID_OW  and InsD.ID_I = insp.ID_I "
                    + " and del.ID_f = InsD.ID_f order by ac.AIRCRAFT_TYPE desc ");
            lstinsp = (List<Object[]>) L.list();
        } else if ("section".equals(serv)) {
            char comb = serv.charAt(0);
            String cher1 = serv.substring(0, 4);
            Query L = sh.createSQLQuery("select del.NAME_" + comb + ", ac.AIRCRAFT_TYPE, ow.SHORT_NAME, insp.FIRST_NAME_I  "
                    + "from section del, inspect_" + comb + " InsD , aircraft  ac, owner ow,  inspector insp "
                    + " where 	InsD.MAIL_" + comb + " = 'Not sent' and InsD.STATUS_" + cher1 + "  = 'Not inspected' "
                    + "and ac.MSN = InsD.MSN "
                    + "and ow.ID_OW =ac.ID_OW  and InsD.ID_I = insp.ID_I "
                    + "and del.ID_D = InsD.ID_D order by ac.AIRCRAFT_TYPE desc ");
            lstinsp = (List<Object[]>) L.list();
        }



        return lstinsp;
    }

    /**
     * 
     * @return list of fal where email were not sent in time
     */
    public static List<Object[]> get_steps_fal_delay() {

        List<Object[]> lstdelay = null;
        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();


        Query L = sh.createSQLQuery(" select   ow.FULL_NAME, ac.MSN, ac.AIRCRAFT_TYPE ,  del.NAME_F,  "
                + " InsD.DATE_START_F,  InsD.DATE_END_F , "
                + " del.DAYS_F - DATEDIFF( InsD.DATE_START_F , CURDATE() )     "
                + " from fal del, inspect_Fal InsD , aircraft  ac, owner ow "
                + " where ac.MSN = InsD.MSN "
                + " and ow.ID_OW =ac.ID_OW "
                + " and InsD.MAIL_F = \"Not sent\" "
                + "AND del.DAYS_F - DATEDIFF( InsD.DATE_START_F , CURDATE() ) >=0"
                + " and del.ID_f = InsD.ID_f order by ow.SHORT_NAME asc, ac.MSN asc, del.NAME_F asc ");


        lstdelay = (List<Object[]>) L.list();
        sh.getTransaction().commit();

        return lstdelay;
    }

    /**
     * 
     * @return list of delivery where email were not sent in time
     */
    public static List<Object[]> get_steps_deliv_delay() {

        List<Object[]> lstdelay = null;

        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();


        Query L = sh.createSQLQuery(" select   ow.FULL_NAME, ac.MSN,   ac.AIRCRAFT_TYPE ,  del.NAME_D,  "
                + " InsD.DATEDEV,  "
                + " del.DAYS_D - DATEDIFF( InsD.DATEDEV , CURDATE() )     "
                + " from delivery del, inspect_deliv InsD , aircraft  ac, owner ow "
                + " where ac.MSN = InsD.MSN "
                + " and ow.ID_OW =ac.ID_OW "
                + " and InsD.MAIL_D = \"Not sent\" "
                + "AND del.DAYS_D - DATEDIFF( InsD.DATEDEV , CURDATE() ) >=0"
                + " and del.ID_d = InsD.ID_d order by ow.SHORT_NAME asc, ac.MSN asc, del.NAME_D asc ");


        lstdelay = (List<Object[]>) L.list();
        sh.getTransaction().commit();

        return lstdelay;
    }

    /**
     * 
     * @return list of section where email were not sent in time
     */
    public static List<Object[]> get_steps_Section_delay() {

        List<Object[]> lstdelay = null;

        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();


        Query L = sh.createSQLQuery(" select   ow.FULL_NAME, ac.MSN,   ac.AIRCRAFT_TYPE ,  del.NAME_S,  "
                + " InsD.DATE_START_S ,  InsD.DATE_END_S , "
                + " del.DAYS_S - DATEDIFF( InsD.DATE_START_S , CURDATE() )    "
                + " from section del, inspect_section InsD , aircraft  ac, owner ow "
                + " where ac.MSN = InsD.MSN "
                + " and ow.ID_OW =ac.ID_OW "
                + " and InsD.MAIL_S = \"Not sent\""
                + "AND del.DAYS_S - DATEDIFF( InsD.DATE_START_S , CURDATE() ) >=0"
                + " and del.ID_s = InsD.ID_s order by ow.SHORT_NAME asc, ac.MSN asc, del.NAME_S asc ");


        lstdelay = (List<Object[]>) L.list();
        sh.getTransaction().commit();

        return lstdelay;
    }
}
