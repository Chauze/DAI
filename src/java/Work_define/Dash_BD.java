/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Work_define;

import Hib_util.HibernateUtil_airbus;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Fast
 */
public class Dash_BD {

   /**
    * 
    * @param nametable
    * @param idloc
    * @param date1
    * @param date2
    * @return information about a service according to a location and an interval of date
    */
    public static List<Object[]> dash_filter_date(String nametable, int idloc, String date1, String date2) {
        List<Object[]> lstservices = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();


            if ("Secretary".equals(nametable)) {
                //Select all the secretary who are affected or not, according to a location an interval of date
                Query q = sh.createSQLQuery("select s.first_name_sec,s.last_name_sec,s.phone_sec,s.mobile_sec,al.DATE_START_S,al.DATE_end_S,s.id_sec,al.STATUS_s,al.id_ow "
                        + "FROM secretary s LEFT OUTER JOIN allocate_s al ON s.id_sec = al.id_sec AND ( al.date_start_s IS NULL )  "
                        + "WHERE s.id_l =" + idloc + " and s.status_sec='free' union "
                        + "select s.first_name_sec,s.last_name_sec,s.phone_sec,s.mobile_sec,al.DATE_START_S,al.DATE_end_S,s.id_sec,al.STATUS_s,al.id_ow "
                        + "FROM secretary s , allocate_s al  where s.id_sec = al.id_sec and ( al.STATUS_s='inprogress' or al.STATUS_s='plan') "
                        + "and s.status_sec='free' and ((al.date_start_s between '" + date1 + "' and '" + date2 + "') "
                        + "or (al.date_end_s between '" + date1 + "' and '" + date2 + "') "
                        + "or ('" + date1 + "' between date_start_s and al.date_end_s) or ('" + date2 + "' "
                        + "between date_start_s and al.date_end_s))"
                        + " and s.id_l =" + idloc);
                lstservices = (List<Object[]>) q.list();
            }

            if ("Car".equals(nametable)) {
                Query q = sh.createSQLQuery("select s.brand,s.model,s.registration,s.id_c,al.DATE_START_c,al.DATE_end_c,s.id_c,al.STATUS_c,al.id_ow "
                        + "FROM Car s LEFT OUTER JOIN allocate_c al ON s.id_c = al.id_c  AND ( al.date_start_c IS NULL )  "
                        + "WHERE s.id_l =" + idloc + " and s.status_car='free' union "
                        + "select s.brand,s.model,s.registration,s.id_c,al.DATE_START_c,al.DATE_end_c,s.id_c,al.STATUS_c,al.id_ow  "
                        + "FROM Car s , allocate_c al  where s.id_c = al.id_c  and ( al.STATUS_c='inprogress' or al.STATUS_c='plan') "
                        + "and s.status_car='free' and ((al.date_start_c between '" + date1 + "' and '" + date2 + "') "
                        + "or (al.date_end_c between '" + date1 + "' and '" + date2 + "') "
                        + "or ('" + date1 + "' between date_start_c and al.date_end_c) or ('" + date2 + "' "
                        + "between date_start_c and al.date_end_c))"
                        + " and s.id_l =" + idloc);
                lstservices = (List<Object[]>) q.list();
            }

            if ("Office".equals(nametable)) {
                Query q = sh.createSQLQuery("select s.building,"
                        + "al.DATE_START_O,al.DATE_end_O,s.code_o,al.STATUS_O,al.id_ow "
                        + "FROM Office s LEFT OUTER JOIN allocate_o al ON s.code_o = al.code_o AND ( al.date_start_o IS NULL )  "
                        + "WHERE s.id_l =" + idloc + " and s.status_off='free' union "
                        + "select s.building,"
                        + "al.DATE_START_O,al.DATE_end_O,s.code_o,al.STATUS_O,al.id_ow  "
                        + "FROM Office s , allocate_o al  where s.code_o = al.code_o and ( al.STATUS_o='inprogress' or al.STATUS_o='plan') "
                        + "and s.status_off='free' and ((al.date_start_o between '" + date1 + "' and '" + date2 + "') "
                        + "or (al.date_end_o between '" + date1 + "' and '" + date2 + "') "
                        + "or ('" + date1 + "' between date_start_o and al.date_end_o) or ('" + date2 + "' "
                        + "between date_start_o and al.date_end_o))"
                        + " and s.id_l =" + idloc);
                lstservices = (List<Object[]>) q.list();
            }

            if ("Hostess".equals(nametable)) {
                 Query q = sh.createSQLQuery("select s.first_name_hos,s.last_name_hos,s.phone_hos,"
                        + "s.mobile_hos,al.DATE_START_h,al.DATE_end_h,s.id_hos,al.STATUS_h,al.id_ow "
                        + "FROM Hostess s LEFT OUTER JOIN allocate_h al ON s.id_hos = al.id_hos AND ( al.date_start_h IS NULL )  "
                        + "WHERE s.id_l =" + idloc + " and s.status_hos='free'  union "
                        + "select  s.first_name_hos,s.last_name_hos,s.phone_hos,"
                        + "s.mobile_hos,al.DATE_START_h,al.DATE_end_h,s.id_hos,al.STATUS_h,al.id_ow "
                        + "FROM Hostess s , allocate_h al  where s.id_hos = al.id_hos and ( al.STATUS_h='inprogress' or al.STATUS_h='plan') "
                        + "and s.status_hos='free' and ((al.date_start_h between '" + date1 + "' and '" + date2 + "') "
                        + "or (al.date_end_h between '" + date1 + "' and '" + date2 + "') "
                        + "or ('" + date1 + "' between date_start_h and al.date_end_h) or ('" + date2 + "' "
                        + "between date_start_h and al.date_end_h))"
                        + " and s.id_l =" + idloc);
                lstservices = (List<Object[]>) q.list();
            }

            sh.getTransaction().commit();
            sh.close();

        } catch (Exception e) {
        }

        return lstservices;
    }

    /**
     * 
     * @param nametable
     * @param idloc
    * @return information about a service according to a location
     */
    public static List<Object[]> dash_filter_nodate(String nametable, int idloc) {
        List<Object[]> lstservices = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            if ("Secretary".equals(nametable)) {
                Query q = sh.createSQLQuery("select s.first_name_sec,s.last_name_sec,s.phone_sec,"
                        + "s.mobile_sec,al.DATE_START_S,al.DATE_end_S,s.id_sec,al.STATUS_s,al.id_ow "
                        + "FROM secretary s LEFT OUTER JOIN allocate_s al ON s.id_sec = al.id_sec "
                        + "AND ( al.date_start_s IS NULL or al.date_start_s is not null) and "
                        + "( al.STATUS_s='inprogress' or al.STATUS_s='plan') and s.status_sec='free' "
                        + " WHERE s.id_l =" + idloc);
                lstservices = (List<Object[]>) q.list();
            }

            if ("Car".equals(nametable)) {
                Query q = sh.createSQLQuery("select s.brand,s.model,s.registration,s.id_c,"
                        + "al.DATE_START_c,al.DATE_end_c,s.id_c,al.STATUS_c,al.id_ow "
                        + "FROM Car s LEFT OUTER JOIN allocate_c al ON s.id_c = al.id_c "
                        + "AND ( al.date_start_c IS NULL or al.date_start_c is not null) and "
                        + "( al.STATUS_c='inprogress' or al.STATUS_c='plan') and s.status_car='free' "
                        + " WHERE s.id_l =" + idloc);
                lstservices = (List<Object[]>) q.list();
            }

            if ("Office".equals(nametable)) {

                Query q = sh.createSQLQuery("select s.building,"
                        + "al.DATE_START_O,al.DATE_end_O,s.code_o,al.STATUS_O,al.id_ow "
                        + "FROM Office s LEFT OUTER JOIN allocate_O al ON s.code_o = al.code_o "
                        + "AND ( al.date_start_o IS NULL or al.date_start_o is not null) and "
                        + "( al.STATUS_o='inprogress' or al.STATUS_o='plan') and s.status_off='free' "
                        + " WHERE s.id_l =" + idloc);
                lstservices = (List<Object[]>) q.list();
            }

            if ("Hostess".equals(nametable)) {
                Query q = sh.createSQLQuery("select s.first_name_hos,s.last_name_hos,s.phone_hos,"
                        + "s.mobile_hos,al.DATE_START_h,al.DATE_end_h,s.id_hos,al.STATUS_h,al.id_ow "
                        + "FROM Hostess s LEFT OUTER JOIN allocate_h al ON s.id_hos = al.id_hos "
                        + "AND ( al.date_start_h IS NULL or al.date_start_h is not null) and "
                        + "( al.STATUS_h='inprogress' or al.STATUS_h='plan') and s.status_hos='free' "
                        + "  WHERE s.id_l =" + idloc);
                lstservices = (List<Object[]>) q.list();
            }

            sh.getTransaction().commit();
            sh.close();

        } catch (Exception e) {
        }

        return lstservices;
    }

   
}
