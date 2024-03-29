
package proje;


public class Passenger extends Person {

    int tc;
    String dogumtarih;

    public Passenger(String ad,String soyad,int tc,String dogumtarih) {
        super(ad, soyad);
        this.tc = tc;
        this.dogumtarih = dogumtarih;
    }

    public int getTc() {
        return tc;
    }

    public void setTc(int tc) {
        this.tc = tc;
    }

    public String getDogumtarih() {
        return dogumtarih;
    }

    public void setDogumtarih(String dogumtarih) {
        this.dogumtarih = dogumtarih;
    }

    @Override
    public void setSoyad(String soyad) {
        super.setSoyad(soyad); 
    }

    @Override
    public String getSoyad() {
        return super.getSoyad(); 
    }

    @Override
    public void setAd(String ad) {
        super.setAd(ad); 
    }

    @Override
    public String getAd() {
        return super.getAd(); 
    }
    
    

    
    
}
