/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fonctions;

import Hib_util.HibernateUtil_airbus;
import Work.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class Envoi_Maj_Mail {

    /**
     * 
     * @param ID_I
     * @return information about an inspector
     */
    public static List<Inspector> getInspector(String ID_I) {
        List<Inspector> lstservices = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            Query q = sh.createQuery("from Inspector as Insp where  Insp.idI = " + ID_I);

            lstservices = (List<Inspector>) q.list();

        } catch (Exception e) {
        }

        return lstservices;
    }

    /**
     * 
     * @param MSN
     * @return information about an aircraft
     */
    public static List<Aircraft> getAircraft(String MSN) {
        List<Aircraft> lstservices = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            Query q = sh.createQuery("from Aircraft as air where  air.msn = " + MSN);

            //stock résultat requête
            lstservices = (List<Aircraft>) q.list();

        } catch (Exception e) {
        }

        return lstservices;
    }

    /**
     * 
     * @param ID_L
     * @return information about a Location
     */
    public static List<Location> getLocation(String ID_L) {
        List<Location> lstservices = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            Query q = sh.createQuery("from Location as Loc where  Loc.idL = " + ID_L);

            //stock résultat requête
            lstservices = (List<Location>) q.list();

        } catch (Exception e) {
        }

        return lstservices;
    }

    /**
     *
     * @param ID_D
     * @return information about a Delivery 
     */
    public static List<Delivery> getDelivery(String ID_D) {
        List<Delivery> lstservices = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            Query q = sh.createQuery("from Delivery as del where  del.idD = " + ID_D);

            //stock résultat requête
            lstservices = (List<Delivery>) q.list();

        } catch (Exception e) {
        }

        return lstservices;
    }

    /**
     *
     * @param ID_D
     * @return information about a section
     */
    public static List<Section> getSection(String ID_D) {
        List<Section> lstservices = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            Query q = sh.createQuery("from Section as sec where  sec.idS = " + ID_D);
            lstservices = (List<Section>) q.list();

        } catch (Exception e) {
        }

        return lstservices;
    }

    /**
     *
     * @param ID_D
     * @return  information about a FAL
     */
    public static List<Fal> getFal(String ID_D) {
        List<Fal> lstservices = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            Query q = sh.createQuery("from Fal as Fal where  Fal.idF = " + ID_D);

            lstservices = (List<Fal>) q.list();

        } catch (Exception e) {
        }

        return lstservices;
    }

    /**
     *
     * @param ID_D
     * @param ID_I
     * @param MSN
     * @param ID_L
     * @return 
     */
    public static List<InspectDeliv> searchInspectDeliv(String ID_D, String ID_I, String MSN, String ID_L) {
        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();


        List<Aircraft> Ownerd1;
        Query q1 = sh.createQuery("from Aircraft as a where a.msn = " + MSN);
        Ownerd1 = (List<Aircraft>) q1.list();
        int own1 = Ownerd1.get(0).getMsn();

        List<Delivery> Ownerd2;
        Query q2 = sh.createQuery("from Delivery as Del where Del.idD = " + ID_D);
        Ownerd2 = (List<Delivery>) q2.list();
        int own2 = Ownerd2.get(0).getIdD();


        List<Location> Ownerd3;
        Query q3 = sh.createQuery("from Location as Loc where Loc.idL = " + ID_L);
        Ownerd3 = (List<Location>) q3.list();
        int own3 = Ownerd3.get(0).getIdL();

        List<Inspector> Ownerd4;
        Query q4 = sh.createQuery("from Inspector as Insp where Insp.idI = " + ID_I);
        Ownerd4 = (List<Inspector>) q4.list();
        int own4 = Ownerd4.get(0).getIdI();

        List<InspectDeliv> OwnerdFin;
        Query qFin = sh.createQuery("from InspectDeliv as inspdel where "
                + " inspdel.inspector = " + own4 + " and "
                + " inspdel.delivery =" + own2 + " and "
                + " inspdel.location = " + own3 + " and "
                + " inspdel.aircraft = " + own1 + " ");
        OwnerdFin = (List<InspectDeliv>) qFin.list();
        return OwnerdFin;

    }

    /**
     *
     * @param ID_D
     * @param ID_I
     * @param MSN
     * @return
     */
    public static List<InspectSection> searchInspectSec(String ID_D, String ID_I, String MSN) {
        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();

        List<Aircraft> Ownerd11 = getAircraft(MSN);
        int own1 = Ownerd11.get(0).getMsn();

        List<Section> Ownerd21 = getSection(ID_D);
        int own2 = Ownerd21.get(0).getIdS();

        List<Inspector> Ownerd12 = getInspector(ID_I);
        int own4 = Ownerd12.get(0).getIdI();

        List<InspectSection> OwnerdFin;
        Query qFin = sh.createQuery("from InspectSection as inspSec where "
                + " inspSec.inspector = " + own4 + " and "
                + " inspSec.section =" + own2 + " and "
                + " inspSec.aircraft = " + own1 + " ");
        OwnerdFin = (List<InspectSection>) qFin.list();
        return OwnerdFin;

    }

    /**
     *
     * @param ID_D
     * @param ID_I
     * @param MSN
     * @param ID_L
     * @return
     */
    public static List<InspectFal> searchInspectFal(String ID_D, String ID_I, String MSN, String ID_L) {
        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();

        List<Aircraft> Ownerd11 = getAircraft(MSN);
        int own1 = Ownerd11.get(0).getMsn();

        List<Fal> Ownerd21 = getFal(ID_D);
        int own2 = Ownerd21.get(0).getIdF();

        List<Inspector> Ownerd12 = getInspector(ID_I);
        int own4 = Ownerd12.get(0).getIdI();

        List<Location> Ownerd13 = getLocation(ID_L);
        int own5 = Ownerd13.get(0).getIdL();

        List<InspectFal> OwnerdFin;
        Query qFin = sh.createQuery("from InspectFal as ifal where "
                + " ifal.inspector = " + own4 + " and "
                + " ifal.location = " + own5 + " and "
                + " ifal.fal = " + own2 + " and "
                + " ifal.aircraft = " + own1 + " ");
        OwnerdFin = (List<InspectFal>) qFin.list();
        return OwnerdFin;


    }
}
