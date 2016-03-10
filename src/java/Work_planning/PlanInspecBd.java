/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Work_planning;

import Hib_util.HibernateUtil_airbus;
import Work.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class PlanInspecBd {

    /**
     *
     * @param idloc
     * @return list of fal inspection according to a location
     */
    public static List<Fal> getidloc(int idloc) {
        List<Fal> lstQte = null;
        try {

            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();
            Query q = sh.createQuery("from InspectFal as L where L.idL=" + idloc);

            lstQte = (List<Fal>) (q.list());

        } catch (Exception e) {
        }

        return lstQte;

    }

    /**
     *
     * @param msn
     * @return  list of fal inspection according to a msn
     */
    public static List<InspectFal> search(int msn) {
        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();

        List<Aircraft> Ownerd;
        Query q = sh.createQuery("from Aircraft as a where a.msn =" + msn);
        Ownerd = (List<Aircraft>) q.list();
        int own = Ownerd.get(0).getMsn();

        List<InspectFal> Ownerd1;
        Query q2 = sh.createQuery("from InspectFal as o where o.aircraft =" + own);
        Ownerd1 = (List<InspectFal>) q2.list();
        return Ownerd1;


    }

    /**
     *
     * @param msn
     * @return  list of delivery inspection according to a msn
     */
    public static List<InspectDeliv> searchDE(int msn) {
        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();

        List<Aircraft> Ownerd;
        Query q = sh.createQuery("from Aircraft as a where a.msn =" + msn);
        Ownerd = (List<Aircraft>) q.list();
        int own = Ownerd.get(0).getMsn();

        List<InspectDeliv> Ownerd1;
        Query q2 = sh.createQuery("from InspectDeliv as o where o.aircraft =" + own);
        Ownerd1 = (List<InspectDeliv>) q2.list();
        return Ownerd1;
    }

    /**
     *
     * @param msn
     * @return  list of section inspection according to a msn
     */
    public static List<InspectSection> searchSE(int msn) {
        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();

        List<Aircraft> Ownerd;
        Query q = sh.createQuery("from Aircraft as a where a.msn =" + msn);
        Ownerd = (List<Aircraft>) q.list();
        int own = Ownerd.get(0).getMsn();

        List<InspectSection> Ownerd1;
        Query q2 = sh.createQuery("from InspectSection as o where o.aircraft =" + own);
        Ownerd1 = (List<InspectSection>) q2.list();
        return Ownerd1;

    }

    /**
     *
     * @param id
     * @param msn
     * @return  list of fal inspection according to a msn and fal step
     */
    public static List<InspectFal> searchFal(int id, int msn) {
        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();

        List<Fal> Ownerd;
        Query q = sh.createQuery("from Fal as a where a.idF = " + id);
        Ownerd = (List<Fal>) q.list();
        int own = Ownerd.get(0).getIdF();

        List<Aircraft> Ownerd2;
        Query q1 = sh.createQuery("from Aircraft as a where a.msn =" + msn);
        Ownerd2 = (List<Aircraft>) q1.list();
        int own1 = Ownerd2.get(0).getMsn();

        List<InspectFal> Ownerd1;
        Query q2 = sh.createQuery("from InspectFal as o where o.fal =" + own + " and o.aircraft=" + own1);
        Ownerd1 = (List<InspectFal>) q2.list();


        return Ownerd1;
    }

    /**
     *
     * @param id
     * @param msn
     * @return list of fal delivery according to a msn and delivery step
     */
    public static List<InspectDeliv> searchDel(int id, int msn) {
        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();

        List<Delivery> Ownerd;
        Query q = sh.createQuery("from Delivery as a where a.idD = " + id);
        Ownerd = (List<Delivery>) q.list();
        int own = Ownerd.get(0).getIdD();

        List<Aircraft> Ownerd2;
        Query q1 = sh.createQuery("from Aircraft as a where a.msn =" + msn);
        Ownerd2 = (List<Aircraft>) q1.list();
        int own1 = Ownerd2.get(0).getMsn();

        List<InspectDeliv> Ownerd1;
        Query q2 = sh.createQuery("from InspectDeliv as o where o.delivery =" + own + " and o.aircraft=" + own1);
        Ownerd1 = (List<InspectDeliv>) q2.list();


        return Ownerd1;
    }

    /**
     *
     * @param id
     * @param msn
     * @return list of fal section according to a msn and section step
     */
    public static List<InspectSection> searchSect(int id, int msn) {
        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();

        List<Section> Ownerd;
        Query q = sh.createQuery("from Section as a where a.idS = " + id);
        Ownerd = (List<Section>) q.list();
        int own = Ownerd.get(0).getIdS();

        List<Aircraft> Ownerd2;
        Query q1 = sh.createQuery("from Aircraft as a where a.msn =" + msn);
        Ownerd2 = (List<Aircraft>) q1.list();
        int own1 = Ownerd2.get(0).getMsn();

        List<InspectSection> Ownerd1;
        Query q2 = sh.createQuery("from InspectSection as o where o.section =" + own + " and o.aircraft=" + own1);
        Ownerd1 = (List<InspectSection>) q2.list();


        return Ownerd1;
    }

    /**
     *
     * @param air
     * @return information about an aicraft according to its type (A380,...)
     */
    public static List<Aircraft> seachDetail(String air) {
        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();
        Query q = sh.createQuery("from Aircraft as a where a.aircraftType like '%" + air + "%'");
        List<Aircraft> ow;
        ow = (List<Aircraft>) q.list();
        return ow;

    }

    /**
     *
     * @param id
     * @return list of aircraft of an owner according to his icao code
     */
    public static List<Aircraft> seachIcao(int id) {

        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();

        List<Owner> Ownerd;
        Query q = sh.createQuery("from Owner as a where a.idOw=" + id);
        Ownerd = (List<Owner>) q.list();
        String own = Ownerd.get(0).getIdOw();

        List<Aircraft> Ownerd1;
        Query q2 = sh.createQuery("from Aircraft as a where a.owner =" + own);
        Ownerd1 = (List<Aircraft>) q2.list();

        return Ownerd1;


    }

    /**
     *
     * @param id
     * @param air
     * @return information about the aicrafts of an owner according to the aicraft type
     */
    public static List<Aircraft> seachComb(int id, String air) {

        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();

        List<Owner> Ownerd;
        Query q = sh.createQuery("from Owner as a where a.idOw=" + id);
        Ownerd = (List<Owner>) q.list();
        String own = Ownerd.get(0).getIdOw();

        List<Aircraft> Ownerd1;
        Query q2 = sh.createQuery("from Aircraft as a where a.owner =" + own + " and a.aircraftType like '%" + air + "%' ");
        Ownerd1 = (List<Aircraft>) q2.list();

        return Ownerd1;


    }

    /**
     *
     * @param msn
     * @param star
     * @param end
     * @return information about the aicrafts of an owner according to the aicraft type according to an interval of date
     * for the fal inspection
     */
    public static List<InspectFal> searchF(int msn, String star, String end) {
        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();
        List<Object[]> Ownerd;
        List<InspectFal> Ownerd1 = null;
        Query q = sh.createSQLQuery(" select a.msn,s.DATEDEV "
                + " from  Inspect_Deliv as s , Aircraft as a "
                + " where s.msn = a.msn "
                + " and a.msn= " + msn
                + " and s.DATEDEV between '" + star + "' and '" + end + "'");


        if (!q.list().isEmpty()) {
            Ownerd = (List<Object[]>) q.list();
            for (Object[] row : Ownerd) {
                Query q2 = sh.createQuery("from InspectFal as o where o.aircraft = " + row[0] + "");
                Ownerd1 = (List<InspectFal>) q2.list();
            }


        }

        return Ownerd1;
    }

    /**
     *
     * @param msn
     * @param star
     * @param end
     * @return information about the aicrafts of an owner according to the aicraft type according to an interval of date
     * for the section inspection
     */
    public static List<InspectSection> searchS(int msn, String star, String end) {
        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();
        List<Object[]> Ownerd;
        List<InspectSection> Ownerd1 = null;
        Query q = sh.createSQLQuery(" select a.msn,s.DATEDEV "
                + " from  Inspect_Deliv as s , Aircraft as a "
                + " where s.msn = a.msn "
                + " and a.msn= " + msn
                + " and s.DATEDEV between '" + star + "' and '" + end + "'");


        if (!q.list().isEmpty()) {
            Ownerd = (List<Object[]>) q.list();
            for (Object[] row : Ownerd) {
                Query q2 = sh.createQuery("from InspectSection as o where o.aircraft = " + row[0] + "");
                Ownerd1 = (List<InspectSection>) q2.list();
            }


        }

        return Ownerd1;
    }

    /**
     *
     * @param msn
     * @param star
     * @param end
     * @return information about the aicrafts of an owner according to the aicraft type according to an interval of date
     * for the delivery inspection
     */
    public static List<InspectDeliv> searchD(int msn, String star, String end) {
        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();
        List<Object[]> Ownerd;
        List<InspectDeliv> Ownerd1 = null;
        Query q = sh.createSQLQuery(" select a.msn,s.DATEDEV "
                + " from  Inspect_Deliv as s , Aircraft as a "
                + " where s.msn = a.msn "
                + " and a.msn= " + msn
                + " and s.DATEDEV between '" + star + "' and '" + end + "'");


        Ownerd = (List<Object[]>) q.list();
        for (Object[] row : Ownerd) {
            Query q2 = sh.createQuery("from InspectDeliv as o where o.aircraft = " + row[0] + "");
            Ownerd1 = (List<InspectDeliv>) q2.list();

        }

        return Ownerd1;
    }
}