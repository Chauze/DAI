package Work;
// Generated 31 mars 2012 07:45:37 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * AllocateHId generated by hbm2java
 */
public class AllocateHId  implements java.io.Serializable {


     private int idHos;
     private String idOw;
     private Date dateStartH;

    public AllocateHId() {
    }

    public AllocateHId(int idHos, String idOw, Date dateStartH) {
       this.idHos = idHos;
       this.idOw = idOw;
       this.dateStartH = dateStartH;
    }
   
    public int getIdHos() {
        return this.idHos;
    }
    
    public void setIdHos(int idHos) {
        this.idHos = idHos;
    }
    public String getIdOw() {
        return this.idOw;
    }
    
    public void setIdOw(String idOw) {
        this.idOw = idOw;
    }
    public Date getDateStartH() {
        return this.dateStartH;
    }
    
    public void setDateStartH(Date dateStartH) {
        this.dateStartH = dateStartH;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AllocateHId) ) return false;
		 AllocateHId castOther = ( AllocateHId ) other; 
         
		 return (this.getIdHos()==castOther.getIdHos())
 && ( (this.getIdOw()==castOther.getIdOw()) || ( this.getIdOw()!=null && castOther.getIdOw()!=null && this.getIdOw().equals(castOther.getIdOw()) ) )
 && ( (this.getDateStartH()==castOther.getDateStartH()) || ( this.getDateStartH()!=null && castOther.getDateStartH()!=null && this.getDateStartH().equals(castOther.getDateStartH()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdHos();
         result = 37 * result + ( getIdOw() == null ? 0 : this.getIdOw().hashCode() );
         result = 37 * result + ( getDateStartH() == null ? 0 : this.getDateStartH().hashCode() );
         return result;
   }   


}

