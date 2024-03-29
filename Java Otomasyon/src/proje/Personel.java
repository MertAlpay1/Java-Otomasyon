
package proje;

public class Personel extends Person {

    String sirket,personeltip,tür;
    int ücret;

    public Personel( String ad, String soyad,String sirket, String personeltip,String tür, int ücret) {
        super(ad, soyad);
        this.sirket = sirket;
        this.tür=tür;
        this.personeltip = personeltip;
        this.ücret = ücret;
    }

    public String getSirket() {
        return sirket;
    }

    public String getTür() {
        return tür;
    }

    public int getÜcret() {
        return ücret;
    }

    public String getPersoneltip() {
        return personeltip;
    }

    @Override
    public String getAd() {
        return ad;
    }

    @Override
    public void setAd(String ad) {
        this.ad = ad;
    }

    @Override
    public String getSoyad() {
        return soyad;
    }

    @Override
    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public void setSirket(String sirket) {
        this.sirket = sirket;
    }

    public void setPersoneltip(String personeltip) {
        this.personeltip = personeltip;
    }

    public void setTür(String tür) {
        this.tür = tür;
    }

    public void setÜcret(int ücret) {
        this.ücret = ücret;
    }
    
    
    
    
}
