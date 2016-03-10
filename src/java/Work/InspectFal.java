package Work;
// Generated 31 mars 2012 07:45:37 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * InspectFal generated by hbm2java
 */
public class InspectFal  implements java.io.Serializable {


     private InspectFalId id;
     private Inspector inspector;
     private Aircraft aircraft;
     private Location location;
     private Fal fal;
     private String statusFal;
     private Date start;
     private Date end;
     private Date dateEndF;
     private String comments;
     private String mailF;
     private Date dateIns;

    public InspectFal() {
    }

	
    public InspectFal(InspectFalId id, Inspector inspector, Aircraft aircraft, Location location, Fal fal, String comments, String mailF) {
        this.id = id;
        this.inspector = inspector;
        this.aircraft = aircraft;
        this.location = location;
        this.fal = fal;
        this.comments = comments;
        this.mailF = mailF;
    }
    public InspectFal(InspectFalId id, Inspector inspector, Aircraft aircraft, Location location, Fal fal, String statusFal, Date start, Date end, Date dateEndF, String comments, String mailF, Date dateIns) {
       this.id = id;
       this.inspector = inspector;
       this.aircraft = aircraft;
       this.location = location;
       this.fal = fal;
       this.statusFal = statusFal;
       this.start = start;
       this.end = end;
       this.dateEndF = dateEndF;
       this.comments = comments;
       this.mailF = mailF;
       this.dateIns = dateIns;
    }
   
    public InspectFalId getId() {
        return this.id;
    }
    
    public void setId(InspectFalId id) {
        this.id = id;
    }
    public Inspector getInspector() {
        return this.inspector;
    }
    
    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }
    public Aircraft getAircraft() {
        return this.aircraft;
    }
    
    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
    public Location getLocation() {
        return this.location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
    public Fal getFal() {
        return this.fal;
    }
    
    public void setFal(Fal fal) {
        this.fal = fal;
    }
    public String getStatusFal() {
        return this.statusFal;
    }
    
    public void setStatusFal(String statusFal) {
        this.statusFal = statusFal;
    }
    public Date getStart() {
        return this.start;
    }
    
    public void setStart(Date start) {
        this.start = start;
    }
    public Date getEnd() {
        return this.end;
    }
    
    public void setEnd(Date end) {
        this.end = end;
    }
    public Date getDateEndF() {
        return this.dateEndF;
    }
    
    public void setDateEndF(Date dateEndF) {
        this.dateEndF = dateEndF;
    }
    public String getComments() {
        return this.comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }
    public String getMailF() {
        return this.mailF;
    }
    
    public void setMailF(String mailF) {
        this.mailF = mailF;
    }
    public Date getDateIns() {
        return this.dateIns;
    }
    
    public void setDateIns(Date dateIns) {
        this.dateIns = dateIns;
    }




}


