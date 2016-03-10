/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fonctions;

import Hib_util.HibernateUtil_airbus;
import Work.Delivery;
import Work.Fal;
import Work.Section;
import Work.Services;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class service_bd {

    /**
     *
     * @return information about a section
     */
    public static List<Section> getSection() {
        List<Section> lststation = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            Query q = sh.createQuery("from Section");


            lststation = (List<Section>) q.list();
            sh.close();
        } catch (Exception e) {
        }
        return lststation;
    }

    /**
     *
     * @return information about a fal
     */
    public static List<Fal> getFal() {
        List<Fal> lststation = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            Query q = sh.createQuery("from Fal");

            lststation = (List<Fal>) q.list();
            sh.close();
        } catch (Exception e) {
        }
        return lststation;
    }

    /**
     *
     * @return information about a delivery
     */
    public static List<Delivery> getDelivery() {
        List<Delivery> lststation = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            Query q = sh.createQuery("from Delivery");

            lststation = (List<Delivery>) q.list();
            sh.close();
        } catch (Exception e) {
        }
        return lststation;
    }

    /**
     * allow to update deadline of a step of a specific phase
     * @param idstat
     * @param namestat
     * @param iddays
     */
    public static void Maj_stat(String idstat, String namestat, int iddays) {

        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();
            char cher = idstat.charAt(0);
            SQLQuery L = sh.createSQLQuery("UPDATE " + idstat + " SET  DAYS_" + cher + "= " + iddays + " WHERE NAME_" + cher + " like '%" + namestat + "%'");
            int result = L.executeUpdate();
            sh.getTransaction().commit();

            sh.close();

        } catch (Exception e) {
        }

    }

    /**
     *
     * @return list of services
     */
    public static List<Services> List_ser() {
        List<Services> lstserv = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();
            Query q = sh.createQuery("from Services");
            lstserv = (List<Services>) q.list();

        } catch (Exception e) {
        }
        return lstserv;
    }
}
