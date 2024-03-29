
package proje;


public class Bus extends Vehicle {

    public Bus(String sirket, String aracno, String yakitTuru, int kmucret, int kapasite, Route route) {
        super(sirket, aracno, yakitTuru, kmucret, kapasite, route);
    }

    @Override
    public void setKapasite(int kapasite) {
        super.setKapasite(kapasite);
    }

    @Override
    public void setKmucret(int kmucret) {
        super.setKmucret(kmucret); 
    }

    @Override
    public void setYakitTuru(String yakitTuru) {
        super.setYakitTuru(yakitTuru);
    }

    @Override
    public void setAracno(String aracno) {
        super.setAracno(aracno); 
    }

    @Override
    public void setSirket(String sirket) {
        super.setSirket(sirket); 
    }

    @Override
    public int CalculateFuelCost() {
        return super.CalculateFuelCost(); 
    }

    @Override
    public void setRoute(Route route) {
        super.setRoute(route); 
    }

    @Override
    public Route getRoute() {
        return super.getRoute(); 
    }

    @Override
    public int getKapasite() {
        return super.getKapasite();
    }

    @Override
    public int getKmucret() {
        return super.getKmucret(); 
    }

    @Override
    public String getYakitTuru() {
        return super.getYakitTuru(); 
    }

    @Override
    public String getAractür() {
        return super.getAractür();
    }

    @Override
    public String getAracno() {
        return super.getAracno(); 
    }

    @Override
    public String getSirket() {
        return super.getSirket(); 
    }

   
    

   
  
   
    
   
 
    
}
