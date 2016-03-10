package Work;
// Generated 31 mars 2012 07:45:37 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Owner generated by hbm2java
 */
public class Owner  implements java.io.Serializable {


     private String idOw;
     private Owner owner;
     private String mainFax;
     private String mainPhone;
     private String fullName;
     private String icaoCode;
     private String shortName;
     private String emailOw;
     private Set<Charge> charges = new HashSet<Charge>(0);
     private Set<AllocateO> allocateOs = new HashSet<AllocateO>(0);
     private Set<Owner> owners = new HashSet<Owner>(0);
     private Set<Aircraft> aircrafts = new HashSet<Aircraft>(0);
     private Set<AllocateH> allocateHs = new HashSet<AllocateH>(0);
     private Set<AllocateC> allocateCs = new HashSet<AllocateC>(0);
     private Set<AllocateS> allocateSs = new HashSet<AllocateS>(0);

    public Owner() {
    }

	
    public Owner(String idOw) {
        this.idOw = idOw;
    }
    public Owner(String idOw, Owner owner, String mainFax, String mainPhone, String fullName, String icaoCode, String shortName, String emailOw, Set<Charge> charges, Set<AllocateO> allocateOs, Set<Owner> owners, Set<Aircraft> aircrafts, Set<AllocateH> allocateHs, Set<AllocateC> allocateCs, Set<AllocateS> allocateSs) {
       this.idOw = idOw;
       this.owner = owner;
       this.mainFax = mainFax;
       this.mainPhone = mainPhone;
       this.fullName = fullName;
       this.icaoCode = icaoCode;
       this.shortName = shortName;
       this.emailOw = emailOw;
       this.charges = charges;
       this.allocateOs = allocateOs;
       this.owners = owners;
       this.aircrafts = aircrafts;
       this.allocateHs = allocateHs;
       this.allocateCs = allocateCs;
       this.allocateSs = allocateSs;
    }
   
    public String getIdOw() {
        return this.idOw;
    }
    
    public void setIdOw(String idOw) {
        this.idOw = idOw;
    }
    public Owner getOwner() {
        return this.owner;
    }
    
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public String getMainFax() {
        return this.mainFax;
    }
    
    public void setMainFax(String mainFax) {
        this.mainFax = mainFax;
    }
    public String getMainPhone() {
        return this.mainPhone;
    }
    
    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }
    public String getFullName() {
        return this.fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getIcaoCode() {
        return this.icaoCode;
    }
    
    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }
    public String getShortName() {
        return this.shortName;
    }
    
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    public String getEmailOw() {
        return this.emailOw;
    }
    
    public void setEmailOw(String emailOw) {
        this.emailOw = emailOw;
    }
    public Set<Charge> getCharges() {
        return this.charges;
    }
    
    public void setCharges(Set<Charge> charges) {
        this.charges = charges;
    }
    public Set<AllocateO> getAllocateOs() {
        return this.allocateOs;
    }
    
    public void setAllocateOs(Set<AllocateO> allocateOs) {
        this.allocateOs = allocateOs;
    }
    public Set<Owner> getOwners() {
        return this.owners;
    }
    
    public void setOwners(Set<Owner> owners) {
        this.owners = owners;
    }
    public Set<Aircraft> getAircrafts() {
        return this.aircrafts;
    }
    
    public void setAircrafts(Set<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }
    public Set<AllocateH> getAllocateHs() {
        return this.allocateHs;
    }
    
    public void setAllocateHs(Set<AllocateH> allocateHs) {
        this.allocateHs = allocateHs;
    }
    public Set<AllocateC> getAllocateCs() {
        return this.allocateCs;
    }
    
    public void setAllocateCs(Set<AllocateC> allocateCs) {
        this.allocateCs = allocateCs;
    }
    public Set<AllocateS> getAllocateSs() {
        return this.allocateSs;
    }
    
    public void setAllocateSs(Set<AllocateS> allocateSs) {
        this.allocateSs = allocateSs;
    }




}

