package Work;
// Generated 31 mars 2012 07:45:37 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Inspector generated by hbm2java
 */
public class Inspector  implements java.io.Serializable {


     private int idI;
     private String firstNameI;
     private String lastNameI;
     private String phoneI;
     private String faxI;
     private String mobileI;
     private String emailI;
     private Set<InspectFal> inspectFals = new HashSet<InspectFal>(0);
     private Set<Charge> charges = new HashSet<Charge>(0);
     private Set<InspectSection> inspectSections = new HashSet<InspectSection>(0);
     private Set<InspectDeliv> inspectDelivs = new HashSet<InspectDeliv>(0);

    public Inspector() {
    }

	
    public Inspector(int idI) {
        this.idI = idI;
    }
    public Inspector(int idI, String firstNameI, String lastNameI, String phoneI, String faxI, String mobileI, String emailI, Set<InspectFal> inspectFals, Set<Charge> charges, Set<InspectSection> inspectSections, Set<InspectDeliv> inspectDelivs) {
       this.idI = idI;
       this.firstNameI = firstNameI;
       this.lastNameI = lastNameI;
       this.phoneI = phoneI;
       this.faxI = faxI;
       this.mobileI = mobileI;
       this.emailI = emailI;
       this.inspectFals = inspectFals;
       this.charges = charges;
       this.inspectSections = inspectSections;
       this.inspectDelivs = inspectDelivs;
    }
   
    public int getIdI() {
        return this.idI;
    }
    
    public void setIdI(int idI) {
        this.idI = idI;
    }
    public String getFirstNameI() {
        return this.firstNameI;
    }
    
    public void setFirstNameI(String firstNameI) {
        this.firstNameI = firstNameI;
    }
    public String getLastNameI() {
        return this.lastNameI;
    }
    
    public void setLastNameI(String lastNameI) {
        this.lastNameI = lastNameI;
    }
    public String getPhoneI() {
        return this.phoneI;
    }
    
    public void setPhoneI(String phoneI) {
        this.phoneI = phoneI;
    }
    public String getFaxI() {
        return this.faxI;
    }
    
    public void setFaxI(String faxI) {
        this.faxI = faxI;
    }
    public String getMobileI() {
        return this.mobileI;
    }
    
    public void setMobileI(String mobileI) {
        this.mobileI = mobileI;
    }
    public String getEmailI() {
        return this.emailI;
    }
    
    public void setEmailI(String emailI) {
        this.emailI = emailI;
    }
    public Set<InspectFal> getInspectFals() {
        return this.inspectFals;
    }
    
    public void setInspectFals(Set<InspectFal> inspectFals) {
        this.inspectFals = inspectFals;
    }
    public Set<Charge> getCharges() {
        return this.charges;
    }
    
    public void setCharges(Set<Charge> charges) {
        this.charges = charges;
    }
    public Set<InspectSection> getInspectSections() {
        return this.inspectSections;
    }
    
    public void setInspectSections(Set<InspectSection> inspectSections) {
        this.inspectSections = inspectSections;
    }
    public Set<InspectDeliv> getInspectDelivs() {
        return this.inspectDelivs;
    }
    
    public void setInspectDelivs(Set<InspectDeliv> inspectDelivs) {
        this.inspectDelivs = inspectDelivs;
    }




}

