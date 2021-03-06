package Work;
// Generated 31 mars 2012 07:45:37 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Aircraft generated by hbm2java
 */
public class Aircraft  implements java.io.Serializable {


     private int msn;
     private Owner owner;
     private String projectCode;
     private String program;
     private String aircraftType;
     private String projectName;
     private String fordsCode;
     private String sapCode;
     private String falRank;
     private Integer engNumer;
     private String cirComment;
     private Integer crewNumber;
     private Set<InspectFal> inspectFals = new HashSet<InspectFal>(0);
     private Set<InspectSection> inspectSections = new HashSet<InspectSection>(0);
     private Set<InspectDeliv> inspectDelivs = new HashSet<InspectDeliv>(0);

    public Aircraft() {
    }

	
    public Aircraft(int msn, Owner owner) {
        this.msn = msn;
        this.owner = owner;
    }
    public Aircraft(int msn, Owner owner, String projectCode, String program, String aircraftType, String projectName, String fordsCode, String sapCode, String falRank, Integer engNumer, String cirComment, Integer crewNumber, Set<InspectFal> inspectFals, Set<InspectSection> inspectSections, Set<InspectDeliv> inspectDelivs) {
       this.msn = msn;
       this.owner = owner;
       this.projectCode = projectCode;
       this.program = program;
       this.aircraftType = aircraftType;
       this.projectName = projectName;
       this.fordsCode = fordsCode;
       this.sapCode = sapCode;
       this.falRank = falRank;
       this.engNumer = engNumer;
       this.cirComment = cirComment;
       this.crewNumber = crewNumber;
       this.inspectFals = inspectFals;
       this.inspectSections = inspectSections;
       this.inspectDelivs = inspectDelivs;
    }
   
    public int getMsn() {
        return this.msn;
    }
    
    public void setMsn(int msn) {
        this.msn = msn;
    }
    public Owner getOwner() {
        return this.owner;
    }
    
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public String getProjectCode() {
        return this.projectCode;
    }
    
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }
    public String getProgram() {
        return this.program;
    }
    
    public void setProgram(String program) {
        this.program = program;
    }
    public String getAircraftType() {
        return this.aircraftType;
    }
    
    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }
    public String getProjectName() {
        return this.projectName;
    }
    
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public String getFordsCode() {
        return this.fordsCode;
    }
    
    public void setFordsCode(String fordsCode) {
        this.fordsCode = fordsCode;
    }
    public String getSapCode() {
        return this.sapCode;
    }
    
    public void setSapCode(String sapCode) {
        this.sapCode = sapCode;
    }
    public String getFalRank() {
        return this.falRank;
    }
    
    public void setFalRank(String falRank) {
        this.falRank = falRank;
    }
    public Integer getEngNumer() {
        return this.engNumer;
    }
    
    public void setEngNumer(Integer engNumer) {
        this.engNumer = engNumer;
    }
    public String getCirComment() {
        return this.cirComment;
    }
    
    public void setCirComment(String cirComment) {
        this.cirComment = cirComment;
    }
    public Integer getCrewNumber() {
        return this.crewNumber;
    }
    
    public void setCrewNumber(Integer crewNumber) {
        this.crewNumber = crewNumber;
    }
    public Set<InspectFal> getInspectFals() {
        return this.inspectFals;
    }
    
    public void setInspectFals(Set<InspectFal> inspectFals) {
        this.inspectFals = inspectFals;
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


