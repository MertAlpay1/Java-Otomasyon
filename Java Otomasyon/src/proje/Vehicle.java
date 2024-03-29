
package proje;


public abstract class Vehicle {
    
    public String sirket;
    public String aracno;
    public String yakitTuru;
    public int kmucret;
    public int kapasite;
    public Route route;

    public Vehicle(String sirket,String aracno, String yakitTuru, int kmucret, int kapasite, Route route) {
        this.sirket=sirket;
        this.aracno = aracno;
        this.yakitTuru = yakitTuru;
        this.kmucret = kmucret;
        this.kapasite = kapasite;
        this.route = route;
    }

    public String getSirket() {
        return sirket;
    }

    public String getAracno() {
        return aracno;
    }
    public String getAractür(){
        
       String aracno = getAracno();
        
    int lastIndex = aracno.length() - 1;
    
    
    while (lastIndex >= 0 && Character.isDigit(aracno.charAt(lastIndex))) {
        lastIndex--;
    }
    
    
    String aracTür = aracno.substring(0, lastIndex + 1);
    
    return aracTür;
        
    }
    
    
    public String getYakitTuru() {
        return yakitTuru;
    }

    public int getKmucret() {
        return kmucret;
    }

    public int getKapasite() {
        return kapasite;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

 public int CalculateFuelCost(){
       
       int yakıtUcret=kmucret*route.getMesafe();
       
       return yakıtUcret;
   }

    public void setSirket(String sirket) {
        this.sirket = sirket;
    }

    public void setAracno(String aracno) {
        this.aracno = aracno;
    }

    public void setYakitTuru(String yakitTuru) {
        this.yakitTuru = yakitTuru;
    }

    public void setKmucret(int kmucret) {
        this.kmucret = kmucret;
    }

    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }


    
 
    
    
    
   

}
