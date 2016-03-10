/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Work_define;

import Hib_util.HibernateUtil_airbus;
import Work.*;
import Work_servlet.Saving_services;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

public class ServicesBD {

    /**
     *
     * @return a list of services
     */
    public static List<Services> getServices() {
        List<Services> lstservices = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            Query q = sh.createQuery("from Services s order by s.nameServ");

            lstservices = (List<Services>) q.list();

        } catch (Exception e) {
        }

        return lstservices;
    }

    /**
     *
     * @return list of location
     */
    public static List<Location> getLocation() {
        List<Location> lstlocation = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            Query q = sh.createQuery("from Location as L order by L.nameL");

            lstlocation = (List<Location>) q.list();

        } catch (Exception e) {
        }

        return lstlocation;
    }

    /**
     *
     * @param idloc
     * @return information about a specific location
     */
    public static List<Location> getidloc2(int idloc) {
        List<Location> lstQte = null;
        try {

            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();
            Query q = sh.createQuery("from Location as L where L.idL=" + idloc);

            lstQte = (List<Location>) (q.list());

        } catch (Exception e) {
        }

        return lstQte;

    }

    /**
     *
     * @param i
     * @return information about a specific owner
     */
    public static List<Owner> getIDowner(int i) {
        List<Owner> lstQte = null;
        try {

            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();
            Query q = sh.createQuery("from Owner as O where O.idOw=" + i);

            lstQte = (List<Owner>) (q.list());

        } catch (Exception e) {
        }

        return lstQte;

    }

    /**
     *
     * @param name
     * @return information according to his name
     */
    public static Owner getidOwner_type(String name) {
        List<Owner> lstQte;
        Owner id_owner = null;
        try {

            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();
            Query q = sh.createQuery("from Owner as O Where O.fullName like '%" + name + "%'");

            lstQte = (List<Owner>) (q.list());
            id_owner = (Owner) lstQte.get(0);

        } catch (Exception e) {
        }

        return id_owner;

    }

    /**
     *
     * @param name
     * @return  ID of an owner according to his name
     */
    public static Integer getidOwner(String name) {
        List<Owner> lstQte;
        Integer idowwn = null;
        try {

            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();
            Query q = sh.createQuery("from Owner as O Where O.fullName like '%" + name + "%'");

            lstQte = (List<Owner>) (q.list());

            Owner idown_find = (Owner) lstQte.get(0);
            idowwn = Integer.parseInt(idown_find.getIdOw());
            sh.getTransaction().commit();
            sh.close();
        } catch (Exception e) {
        }

        return idowwn;

    }

    /**
     *
     * @param name
     * @return list of owner according to their name of their icao code
     */
    public static List<Owner> getowner_list(String name) {
        List<Owner> lstQte = null;

        try {

            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();
            Query q = sh.createQuery("from Owner as O Where O.fullName like '%" + name + "%'"
                    + "or O.icaoCode like '%" + name + "%'");

            lstQte = (List<Owner>) (q.list());

        } catch (Exception e) {
        }

        return lstQte;

    }


    /**
     *
     * @param idserv
     * @return information about a services according to its ID
     */
    public static List<Services> getidServi2(int idserv) {
        List<Services> lstQte = null;
        try {

            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();
            Query q = sh.createQuery("from Services as L where L.idServ=" + idserv);


            lstQte = (List<Services>) (q.list());

        } catch (Exception e) {
        }

        return lstQte;

    }



    /**
     *
     * @param namebd
     * @param idres
     * @return information about a resource according to its ID
     */
    public static List<Object> getid_reources(String namebd, int idres) {
        List<Object> lstQte = null;
        try {

            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();
            Query q = null;
            if ("Office".equals(namebd)) {
                q = sh.createQuery("from Office as L where L.codeO=" + idres);
            }
            if ("Car".equals(namebd)) {
                q = sh.createQuery("from Car as L where L.idC=" + idres);
            }
            if ("Secretary".equals(namebd)) {
                q = sh.createQuery("from Secretary as L where L.idSec=" + idres);
            }
            if ("Hostess".equals(namebd)) {
                q = sh.createQuery("from Hostess as L where L.idHos=" + idres);
            }

            lstQte = (List<Object>) (q.list());

        } catch (Exception e) {
        }

        return lstQte;

    }

    /**
     *
     * @param nameserv
     * @param varid
     * @param varloc
     * @return list of available resources according to its ID and location
     */
    public static List<Object> availableserv(String nameserv, int varid, int varloc) {
        List<Object> lstservices = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            Query q = sh.createQuery("from " + nameserv + " where id_serv=" + varid + " and id_l=" + varloc);

            lstservices = (List<Object>) q.list();
            sh.close();
        } catch (Exception e) {
        }

        return lstservices;
    }

    /**
     *
     * @param nameserv
     * @param varid
     * @return information about a secretary according to her ID
     */
    public static List<Secretary> availablesec(String nameserv, int varid) {
        List<Secretary> lstservices = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            Query q = sh.createQuery("from " + nameserv + " as s where s.idSec=" + varid + "");

            lstservices = (List<Secretary>) q.list();

        } catch (Exception e) {
        }

        return lstservices;
    }

    /**
     *
     * @param nameserv
     * @param varid
     * @return information about a car according to its ID
     */
    public static List<Car> availableCar(String nameserv, int varid) {
        List<Car> lstservices = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            Query q = sh.createQuery("from " + nameserv + " as c where c.idC = " + varid + "");

            lstservices = (List<Car>) q.list();

        } catch (Exception e) {
        }

        return lstservices;
    }

    /**
     *
     * @param nameserv
     * @param varid
     * @return information about a office according to its ID
     */
    public static List<Office> availableOff(String nameserv, int varid) {
        List<Office> lstservices = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            Query q = sh.createQuery("from " + nameserv + " as o where o.codeO= " + varid + "");

            lstservices = (List<Office>) q.list();

        } catch (Exception e) {
        }

        return lstservices;
    }

    /**
     *
     * @param nametable
     * @param idloc
     * @return list of resources according to a location
     */
    public static List<Object[]> serviceselondate2(String nametable, int idloc) {
        List<Object[]> lstservices = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            if ("Secretary".equals(nametable)) {
                Query q = sh.createSQLQuery("SELECT s.first_name_sec, s.last_name_sec, s.phone_sec, s.mobile_sec, s.id_sec "
                        + "FROM secretary s WHERE S.id_l =" + idloc + " AND s.status_Sec = 'free' AND s.id_sec NOT IN (SELECT a.id_sec FROM "
                        + "allocate_s a WHERE a.STATUS_S = 'waiting' OR a.STATUS_S = 'plan' OR a.STATUS_S = 'inprogress')");
                lstservices = (List<Object[]>) q.list();
            }

            if ("Car".equals(nametable)) {
                Query q = sh.createSQLQuery("SELECT s.brand, s.model, s.registration, s.id_c FROM car s "
                        + "WHERE S.id_l =" + idloc + " AND s.status_car = 'free' aND s.id_c NOT IN (SELECT a.id_c "
                        + "FROM allocate_c a WHERE a.STATUS_c = 'waiting' OR a.STATUS_c = 'plan' "
                        + "OR a.STATUS_c = 'inprogress')");
                lstservices = (List<Object[]>) q.list();
            }

            if ("Office".equals(nametable)) {
                Query q = sh.createSQLQuery("SELECT s.building, s.code_o FROM office s "
                        + "WHERE S.id_l =" + idloc + " AND s.status_off = 'free' AND s.code_o NOT IN "
                        + "(SELECT a.code_o FROM allocate_o a WHERE a.STATUS_o = 'waiting' "
                        + "OR a.STATUS_o = 'plan' OR a.STATUS_o = 'inprogress')");

                lstservices = (List<Object[]>) q.list();
            }

            if ("Hostess".equals(nametable)) {
                Query q = sh.createSQLQuery("SELECT s.first_name_Hos, s.last_name_Hos, s.phone_Hos, s.mobile_Hos, s.id_Hos "
                        + "FROM Hostess s WHERE S.id_l =" + idloc + " AND s.status_Hos = 'free' AND s.id_Hos NOT IN (SELECT a.id_Hos FROM "
                        + "allocate_h a WHERE a.STATUS_h = 'waiting' OR a.STATUS_h = 'plan' OR a.STATUS_h = 'inprogress')");
                lstservices = (List<Object[]>) q.list();
            }



            sh.getTransaction().commit();
        } catch (Exception e) {
        }

        return lstservices;
    }

    /**
     *
     * @param nametable
     * @return the last ID of a resource in order to do auto-increment
     */
    public static Integer last_id(String nametable) {
        List<Integer> lstservices = null;
        int id_serv = 0;


        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();


        if ("Car".equals(nametable)) {
            Query q = sh.createQuery("select max(c.idC+1) from Car c");

            lstservices = (List<Integer>) q.list();
            id_serv = lstservices.get(0);
        }

        if ("Secretary".equals(nametable)) {
            Query q = sh.createQuery("select max(c.idSec+1) from Secretary c");

            lstservices = (List<Integer>) q.list();
            id_serv = lstservices.get(0);
        }

        if ("Hostess".equals(nametable)) {
            Query q = sh.createQuery("select max(c.idHos+1) from Hostess c");

            lstservices = (List<Integer>) q.list();
            id_serv = lstservices.get(0);
        }

        if ("Office".equals(nametable)) {
            List<Long> lstservices2 = null;

            Query q = sh.createQuery("SELECT max(o.codeO+1) FROM Office o ");

            lstservices2 = (List<Long>) q.list();
            String xx = (String) lstservices2.get(0).toString();

            int id_find2 = Integer.parseInt(xx);
            id_serv = id_find2;
        }

        return id_serv;


    }

    /**
     *
     * @param nametable
     * @param idloc
     * @param date1
     * @param date2
     * @return list of available resources according to a location and an interval of date
     */
    public static List<Object[]> serviceselondate(String nametable, int idloc, String date1, String date2) {
        List<Object[]> lstservices = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            if ("Secretary".equals(nametable)) {
                Query q = sh.createSQLQuery("select s.first_name_sec,s.last_name_sec,s.phone_sec,s.mobile_sec,s.id_sec "
                        + "from secretary s where S.status_sec !='blocked' and S.id_l=" + idloc + " and "
                        + "s.id_sec not in ( SELECT al.id_sec FROM allocate_s al where "
                        + "(al.date_start_s between '" + date1 + "' and '" + date2 + "') or "
                        + "(al.date_end_s between '" + date1 + "' and '" + date2 + "')"
                        + " or ('" + date1 + "' between date_start_s and al.date_end_s)"
                        + " or ('" + date2 + "' between date_start_s and al.date_end_s))");
                lstservices = (List<Object[]>) q.list();
            }

            if ("Car".equals(nametable)) {
                Query q = sh.createSQLQuery("select s.brand,s.model,s.registration,s.id_c "
                        + "from Car s where S.status_car !='blocked' and S.id_l=" + idloc + " "
                        + "and s.id_c not in( SELECT al.id_c FROM allocate_c al where  "
                        + "(al.date_start_c between '" + date1 + "' and '" + date2 + "') or "
                        + "(al.date_end_c between '" + date1 + "' and '" + date2 + "')"
                        + " or ('" + date1 + "' between date_start_c and al.date_end_c)"
                        + " or ('" + date2 + "' between date_start_c and al.date_end_c))");
                lstservices = (List<Object[]>) q.list();
            }

            if ("Office".equals(nametable)) {
                Query q = sh.createSQLQuery("select s.building,s.code_o "
                        + "from Office s where S.status_off !='blocked' and S.id_l=" + idloc + " "
                        + "and s.code_o not in ( SELECT al.code_o FROM allocate_o al where "
                        + "(al.date_start_o between '" + date1 + "' and '" + date2 + "') or "
                        + "(al.date_end_o between '" + date1 + "' and '" + date2 + "')"
                        + " or ('" + date1 + "' between date_start_o and al.date_end_o)"
                        + " or ('" + date2 + "' between date_start_o and al.date_end_o))");
                lstservices = (List<Object[]>) q.list();
            }

            if ("Hostess".equals(nametable)) {
                Query q = sh.createSQLQuery("select s.first_name_hos,s.last_name_hos,s.phone_hos,s.mobile_hos,s.id_hos "
                        + "from Hostess s where S.status_hos !='blocked' and S.id_l=" + idloc + " and "
                        + "s.id_hos not in( SELECT al.id_hos FROM allocate_h al where "
                        + "(al.date_start_h between '" + date1 + "' and '" + date2 + "') or "
                        + "(al.date_end_h between '" + date1 + "' and '" + date2 + "') "
                        + " or ('" + date1 + "' between date_start_h and al.date_end_h)"
                        + " or ('" + date2 + "' between date_start_h and al.date_end_h))");
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
     * @param idown
     * @return list of allocated resources for an owner
     */
    public static List<Object[]> listbooking(String nametable, Integer idown) {
        List<Object[]> lstservices = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            if ("Secretary".equals(nametable)) {
                Query q = sh.createSQLQuery("select s.first_name_sec,s.last_name_sec,s.phone_sec,"
                        + "s.mobile_sec,al.DATE_START_S,al.DATE_end_S,s.id_sec,al.STATUS_s "
                        + "from secretary s, allocate_s al where s.id_sec=al.id_sec and (al.STATUS_s='waiting' "
                        + "or al.STATUS_s='inprogress' or al.STATUS_s='plan') and al.id_ow=" + idown);
                lstservices = (List<Object[]>) q.list();
            }


            if ("Car".equals(nametable)) {
                Query q = sh.createSQLQuery("select s.brand,s.model,s.registration,"
                        + "al.DATE_START_c,al.DATE_end_c,s.id_c,al.STATUS_c "
                        + "from Car s, allocate_c al where s.id_c=al.id_c and (al.STATUS_c='waiting' "
                        + "or al.STATUS_c='inprogress' or al.STATUS_c='plan') and al.id_ow=" + idown);
                lstservices = (List<Object[]>) q.list();
            }

            if ("Office".equals(nametable)) {
                Query q = sh.createSQLQuery("Select s.building,al.DATE_START_o,al.DATE_end_o,s.code_o, al.STATUS_o "
                        + "from Office s, allocate_o al where s.code_o=al.code_o and (al.STATUS_o='waiting' "
                        + "or al.STATUS_o='inprogress' or al.STATUS_o='plan') and al.id_ow=" + idown + " "
                        + "order by al.DATE_START_o");
                lstservices = (List<Object[]>) q.list();
            }

            if ("Hostess".equals(nametable)) {
                Query q = sh.createSQLQuery("select s.first_name_hos,s.last_name_hos,s.phone_hos,"
                        + "s.mobile_hos,al.DATE_START_h,al.DATE_end_h,s.id_hos,al.STATUS_h "
                        + "from hostess s, allocate_h al where s.id_hos=al.id_hos and (al.STATUS_h='waiting' "
                        + "or al.STATUS_h='inprogress' or al.STATUS_h='plan') and al.id_ow=" + idown + " "
                        + "order by al.DATE_START_h");
                lstservices = (List<Object[]>) q.list();
            }
            sh.getTransaction().commit();
            sh.close();

        } catch (Exception e) {
        }

        return lstservices;
    }

    /**
     * change the status of a resource when it is deleted
     * @param nameserv
     * @param ress
     */
    public static void update_status_ress(String nameserv, int ress) {
        String status = "blocked";
        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();

        if ("Secretary".equals(nameserv)) {

            List<Secretary> listS = null;

            try {

                Query q = sh.createQuery("from Secretary S where S.idSec=" + ress + "");
                listS = (List<Secretary>) (q.list());
                Secretary sec = listS.get(0);

                sec.setStatusSec(status);
                sh.save(sec);


            } catch (Exception e) {
            }
        }


        if ("Car".equals(nameserv)) {
            List<Car> listS = null;

            try {

                Query q = sh.createQuery("from Car S where S.idC=" + ress + "");
                listS = (List<Car>) (q.list());
                Car car = listS.get(0);

                car.setStatusCar(status);
                sh.save(car);

            } catch (Exception e) {
            }
        }

        if ("Office".equals(nameserv)) {
            List<Office> listS = null;

            try {

                Query q = sh.createQuery("from Office S where S.codeO=" + ress + "");

                listS = (List<Office>) (q.list());
                Office sec = listS.get(0);

                sec.setStatusOff(status);
                sh.save(sec);


            } catch (Exception e) {
            }

        }


        if ("Hostess".equals(nameserv)) {
            List<Hostess> listS = null;

            try {
                Query q = sh.createQuery("from Hostess S where S.idHos=" + ress + "");

                listS = (List<Hostess>) (q.list());
                Hostess sec = listS.get(0);

                sec.setStatusHos(status);
                sh.save(sec);


            } catch (Exception e) {
            }

        }
        sh.getTransaction().commit();
    }

    /**
     * remove a resource which is planned
     * @param nameserv
     * @param ress
     */
    public static void delete_resource_md(String nameserv, int ress) {
        if ("Office".equals(nameserv)) {
            List<AllocateO> lstservices = null;


            try {
                Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
                sh.beginTransaction();

                Query q = sh.createQuery("from AllocateO O where O.office=" + ress + " and O.statusO='plan'");
                lstservices = (List<AllocateO>) q.list();

                AllocateO listAll = lstservices.get(0);
                sh.delete(listAll);
                sh.getTransaction().commit();
                sh.close();
            } catch (Exception e) {
            }
        }


        if ("Car".equals(nameserv)) {
            List<AllocateC> lstservices = null;


            try {
                Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
                sh.beginTransaction();

                Query q = sh.createQuery("from AllocateC O where  O.car=" + ress + " and O.statusC='plan'");

                lstservices = (List<AllocateC>) q.list();

                AllocateC listAll = lstservices.get(0);
                sh.delete(listAll);
                sh.getTransaction().commit();
                sh.close();
            } catch (Exception e) {
            }
        }

        if ("Secretary".equals(nameserv)) {
            List<AllocateS> lstservices = null;


            try {
                Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
                sh.beginTransaction();

                Query q = sh.createQuery("from AllocateS O where O.secretary=" + ress + " and O.statusS='plan'");

                lstservices = (List<AllocateS>) q.list();

                AllocateS listAll = lstservices.get(0);
                sh.delete(listAll);
                sh.getTransaction().commit();
                sh.close();

            } catch (Exception e) {
            }
        }

    }

    /**
     * remove a resource booked
     * @param nameserv
     * @param owner
     * @param ress
     * @param state
     * @param dateend
     */
    public static void delete_resource_book(String nameserv, int owner, int ress, String state, String dateend) {
        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();

        if ("Office".equals(nameserv)) {
            List<AllocateO> lstservices = null;
            try {
                Query q = sh.createQuery("from AllocateO O where O.owner=" + owner + " "
                        + "and O.office=" + ress + " and O.statusO='" + state + "' and O.dateEndO='" + dateend + "'");

                lstservices = (List<AllocateO>) q.list();

                AllocateO listAll = lstservices.get(0);
                sh.delete(listAll);
                sh.getTransaction().commit();
                sh.close();
            } catch (Exception e) {
            }
        }


        if ("Car".equals(nameserv)) {
            List<AllocateC> lstservices = null;

            try {
                Query q = sh.createQuery("from AllocateC O where O.owner=" + owner + " "
                        + "and O.car=" + ress + " and O.statusC='" + state + "' and O.dateEndC='" + dateend + "'");

                lstservices = (List<AllocateC>) q.list();

                AllocateC listAll = lstservices.get(0);
                sh.delete(listAll);
                sh.getTransaction().commit();
                sh.close();
            } catch (Exception e) {
            }
        }

        if ("Secretary".equals(nameserv)) {
            List<AllocateS> lstservices;


            try {

                Query q = sh.createQuery("from AllocateS O where O.owner=" + owner + " "
                        + "and O.secretary=" + ress + " and O.statusS='" + state + "' and O.dateEndS='" + dateend + "'");

                lstservices = (List<AllocateS>) q.list();

                AllocateS listAll = lstservices.get(0);
                sh.delete(listAll);
                sh.getTransaction().commit();
                sh.close();

            } catch (Exception e) {
            }
        }

        if ("Hostess".equals(nameserv)) {
            try {
                Query q = sh.createQuery("from AllocateH O where O.owner=" + owner + " "
                        + " and O.hostess=" + ress + " and O.statusH='" + state + "' and O.dateEndH='" + dateend + "'");;

                List<AllocateH> lstservices = (List<AllocateH>) q.list();

                AllocateH listAll = lstservices.get(0);
                sh.delete(listAll);
                sh.getTransaction().commit();
                sh.close();

            } catch (Exception e) {
            }
        }

    }

    /**
     *
     * @param varid
     * @return information about a secretary
     */
    public static List<Secretary> availableservee(int varid) {
        List<Secretary> lstservices = null;
        try {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            Query q = sh.createQuery("from Secretary where id_serv=" + varid + "");

            lstservices = (List<Secretary>) q.list();

        } catch (Exception e) {
        }

        return lstservices;
    }

    /**
     * allow to confirm all the resource booked of an owner, they will get the status 'plan'
     * @param idown
     * @param status
     */
    public static void action_booking(int idown, String status) {
        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();

        try {
            List<Owner> Ownerd;
            Query q = sh.createQuery("from Owner as o where o.idOw=" + idown);
            Ownerd = (List<Owner>) q.list();
            String own = Ownerd.get(0).getIdOw();

            List<AllocateO> Allocate;
            List<AllocateC> AllocateC;
            List<AllocateH> AllocateH;
            List<AllocateS> AllocateS;

            Query q2 = sh.createQuery("from AllocateO as o where o.owner='" + own + "' "
                    + " and o.statusO='waiting'");

            Allocate = (List<AllocateO>) q2.list();
            if (!Allocate.isEmpty()) {
                for (AllocateO allo_temp_o : Allocate) {
                    allo_temp_o.setStatusO(status);
                }
            }


            Query q3 = sh.createQuery("from AllocateC as o where o.owner='" + own + "' "
                    + " and o.statusC='waiting'");

            AllocateC = (List<AllocateC>) q3.list();

            if (!AllocateC.isEmpty()) {
                for (AllocateC allo_temp_c : AllocateC) {
                    allo_temp_c.setStatusC(status);
                }
            }



            Query q4 = sh.createQuery("from AllocateH as o where o.owner='" + own + "' "
                    + " and o.statusH='waiting'");

            AllocateH = (List<AllocateH>) q4.list();

            if (!AllocateH.isEmpty()) {
                for (AllocateH allo_temp_h : AllocateH) {
                    allo_temp_h.setStatusH(status);
                }
            }



            Query q5 = sh.createQuery("from AllocateS as o where o.owner='" + own + "' "
                    + " and o.statusS='waiting'");

            AllocateS = (List<AllocateS>) q5.list();

            if (!AllocateS.isEmpty()) {
                for (AllocateS allo_temp_s : AllocateS) {
                    allo_temp_s.setStatusS(status);
                }
            }


            sh.getTransaction().commit();
            sh.close();
        } catch (Exception e) {
        }
    }

    /**
     * allow to create a booking for a specific resource according to an owner, interval of date
     * @param begin
     * @param end
     * @param namebd
     * @param idresbooked
     * @param owner_rec
     */
    public static void recbooking_office(String begin, String end, String namebd,
            int idresbooked, Owner owner_rec) {

        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();

        changeformat_date datechange = new changeformat_date();
        String date_begin = datechange.change_date(begin);
        String date_end = datechange.change_date(end);

        SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");

        List<Object> resource = ServicesBD.getid_reources(namebd, idresbooked);
        String od = owner_rec.getIdOw();

        if ("Office".equals(namebd)) {

            Office id_find = (Office) resource.get(0);
            AllocateO alloG = new AllocateO();
            AllocateOId alloID = new AllocateOId();

            alloG.setDateEndO(null);
            alloG.setOffice(id_find);
            alloG.setOwner(owner_rec);

            alloID.setIdOw(od);
            alloID.setCodeO(id_find.getCodeO());
            Date date;
            try {
                date = formatdate.parse(date_begin);
                alloID.setDateStartO(date);

                date = formatdate.parse(date_end);
                alloG.setDateEndO(date);
            } catch (ParseException ex) {
                Logger.getLogger(Saving_services.class.getName()).log(Level.SEVERE, null, ex);
            }

            alloG.setId(alloID);
            alloG.setStatusO("waiting");
            sh.save(alloG);
        }

        if ("Car".equals(namebd)) {

            Car id_find = (Car) resource.get(0);
            AllocateC alloG = new AllocateC();
            AllocateCId alloID = new AllocateCId();

            alloG.setDateEndC(null);
            alloG.setCar(id_find);
            alloG.setOwner(owner_rec);

            alloID.setIdOw(od);
            alloID.setIdC(id_find.getIdC());
            Date date;
            try {
                date = formatdate.parse(date_begin);
                alloID.setDateStartC(date);

                date = formatdate.parse(date_end);
                alloG.setDateEndC(date);
            } catch (ParseException ex) {
                Logger.getLogger(Saving_services.class.getName()).log(Level.SEVERE, null, ex);
            }

            alloG.setId(alloID);
            alloG.setStatusC("waiting");
            sh.save(alloG);
        }

        if ("Hostess".equals(namebd)) {

            Hostess id_find = (Hostess) resource.get(0);
            AllocateH alloG = new AllocateH();
            AllocateHId alloID = new AllocateHId();

            alloG.setDateEndH(null);
            alloG.setHostess(id_find);
            alloG.setOwner(owner_rec);


            alloID.setIdOw(od);
            alloID.setIdHos(id_find.getIdHos());
            Date date;
            try {
                date = formatdate.parse(date_begin);
                alloID.setDateStartH(date);

                date = formatdate.parse(date_end);
                alloG.setDateEndH(date);
            } catch (ParseException ex) {
                Logger.getLogger(Saving_services.class.getName()).log(Level.SEVERE, null, ex);
            }

            alloG.setId(alloID);
            alloG.setStatusH("waiting");
            sh.save(alloG);
        }

        if ("Secretary".equals(namebd)) {

            Secretary id_find = (Secretary) resource.get(0);
            AllocateS alloG = new AllocateS();
            AllocateSId alloID = new AllocateSId();

            alloG.setDateEndS(null);
            alloG.setSecretary(id_find);
            alloG.setOwner(owner_rec);
            alloID.setIdSec(idresbooked);
            alloID.setIdOw(od);
            alloID.setIdSec(id_find.getIdSec());
            Date date;
            try {
                date = formatdate.parse(date_begin);
                alloID.setDateStartS(date);

                date = formatdate.parse(date_end);
                alloG.setDateEndS(date);
            } catch (ParseException ex) {
                Logger.getLogger(Saving_services.class.getName()).log(Level.SEVERE, null, ex);
            }

            alloG.setId(alloID);
            alloG.setStatusS("waiting");
            sh.save(alloG);
        }


        sh.getTransaction().commit();
    }
}
