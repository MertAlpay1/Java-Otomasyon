
package proje;


public class Reservation {
    Passenger passenger;
    String sefer;

    int koltuk;
    
    public Reservation(Passenger passenger, String sefer, int koltuk) {
        this.passenger = passenger;
        this.sefer = sefer;
        this.koltuk = koltuk;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getSefer() {
        return sefer;
    }

    public void setSefer(String sefer) {
        this.sefer = sefer;
    }

    public int getKoltuk() {
        return koltuk;
    }

    public void setKoltuk(int koltuk) {
        this.koltuk = koltuk;
    }

    
    
    
}
