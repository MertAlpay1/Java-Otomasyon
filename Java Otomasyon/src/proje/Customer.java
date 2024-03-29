package proje;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static proje.Admin.companylist;

public class Customer {

private Vehicle vehicle;
private Route route;

private static List<Trip> trips;
public static  List<Transport> transport;
public static List<Vehicle> vehicles = new ArrayList<>();
public static List<Gidişat> seferListesi = new ArrayList<>();
List<Transport> availableTransports = new ArrayList<>();
private String[] sehirler1 = {"istanbul", "ankara", "konya"};
private String[] sehirler2 = {"istanbul","kocaeli", "bilecik", "eskisehir", "ankara", "konya"};
private Integer[] zamanAraligi = {4, 5, 6, 7, 8, 9, 10};




 public static Gidişat gidiş1 = new Gidişat("sefer1", new String[]{"istanbul", "kocaeli", "bilecik", "eskisehir", "ankara", "eskisehir", "bilecik", "kocaeli", "istanbul"});
 public static Gidişat gidiş2 = new Gidişat("sefer2", new String[]{"istanbul", "kocaeli", "bilecik", "eskisehir", "konya", "eskisehir", "bilecik", "kocaeli", "istanbul"});
 public static Gidişat gidiş3 = new Gidişat("sefer3", new String[]{"istanbul", "kocaeli", "ankara", "kocaeli", "istanbul", "kocaeli", "ankara", "kocaeli", "istanbul"});
 public static Gidişat gidiş4 = new Gidişat("sefer4", new String[]{"istanbul", "kocaeli", "eskisehir", "konya", "eskisehir", "kocaeli", "istanbul"});
 public static Gidişat gidiş5 = new Gidişat("sefer5", new String[]{"istanbul", "konya", "istanbul"});
 public static Gidişat gidiş6 = new Gidişat("sefer6", new String[]{"istanbul", "ankara", "istanbul"});
 
 
         
    public Customer() {
        
        

   
        
        
    } 
   
 
            
            
            
    public static void initializeDataCustomer()
    {
        
        transport = new ArrayList<>();
        
        int index = 0;
       
        
         
         seferListesi.add(gidiş1);
         seferListesi.add(gidiş2);
         seferListesi.add(gidiş3);
         seferListesi.add(gidiş4);
         seferListesi.add(gidiş5);
         seferListesi.add(gidiş6);
         
        
        Bus otobusA1 = new Bus("sirketA", "otobus 1", "Benzin", 10, 20,Company.sefer3);
        Bus otobusA2 = new Bus("sirketA", "otobus 2", "Benzin", 10, 15,Company.sefer3);
        Bus otobusB1 = new Bus("sirketB", "otobus 1", "Motorin", 5, 15,Company.sefer3);
        Bus otobusB2 = new Bus("sirketB", "otobus 2", "Motorin", 5, 20,Company.sefer4);
        Bus otobusC1 = new Bus("sirketC", "otobus 1", "Motorin", 6, 20,Company.sefer4);
        Airplane ucakC1 = new Airplane("sirketC", "ucak 1", "Gaz", 25, 30,Company.sefer5);
        Airplane ucakC2 = new Airplane("sirketC", "ucak 2", "Gaz", 25, 30,Company.sefer5);
        Train trenD1 = new Train("sirketD", "tren 1", "Elektrik", 3, 25,Company.sefer1);
        Train trenD2 = new Train("sirketD", "tren 2", "Elektrik", 3, 25,Company.sefer2);
        Train trenD3 = new Train("sirketD", "tren 3", "Elektrik", 3, 25,Company.sefer2);
        Airplane ucakF1 = new Airplane("sirketF", "ucak 1", "Gaz", 20, 30,Company.sefer6);
        Airplane ucakF2 = new Airplane("sirketF", "ucak 2", "Gaz", 20, 30,Company.sefer6);

        
        vehicles.add(otobusA1);
        vehicles.add(otobusA2);
        vehicles.add(otobusB1);
        vehicles.add(otobusB2);
        vehicles.add(otobusC1);
        vehicles.add(ucakC1);
        vehicles.add(ucakC2);
        vehicles.add(trenD1);
        vehicles.add(trenD2);
        vehicles.add(trenD3);
        vehicles.add(ucakF1);
        vehicles.add(ucakF2);
        
        
        trips = new ArrayList<>();
        
        for (Vehicle vehicle : vehicles) {
            for (Gidişat sefer : seferListesi) {
            for (int i = 4; i <= 10; i++) {
                
            if (vehicle.route != null && (vehicle.route.getSefersayı() == null ? sefer.getRoutename() == null : vehicle.route.getSefersayı().equals(sefer.getRoutename()))) {
           
                Trip newTrip = new Trip(vehicle, sefer, i);
                trips.add(newTrip);
                Transport newTransport = new Transport(newTrip);
                newTransport.randomizeSeatStatus();
                transport.add(newTransport);
          }
        }
       }
      }
         
       
        
    }
   public static void addVehicle(Vehicle newVehicle) {
       
          vehicles.add(newVehicle);
          
            for (Gidişat sefer : seferListesi) {
            for (int i = 4; i <= 10; i++) {
                
            if (newVehicle.route != null && (newVehicle.route.getSefersayı() == null ? sefer.getRoutename() == null : newVehicle.route.getSefersayı().equals(sefer.getRoutename()))) {
           
                Trip newTrip = new Trip(newVehicle, sefer, i);
                trips.add(newTrip);
                Transport newTransport = new Transport(newTrip);
                newTransport.randomizeSeatStatus();
                transport.add(newTransport);
          }
        }
       
      }
   }
    public static void addGidişat(Gidişat gidişat)  {
        
        seferListesi.add(gidişat);
        
        for(Vehicle vehicle:vehicles){
         for (int i = 4; i <= 10; i++) {
           if (vehicle.route != null && vehicle.route.getSefersayı() != null 
                   && vehicle.route.getSefersayı().equals(gidişat.getRoutename())) {
       
               Trip newTrip = new Trip(vehicle, gidişat, i);
                trips.add(newTrip);
                Transport newTransport = new Transport(newTrip);
                newTransport.randomizeSeatStatus();
                transport.add(newTransport);
               
              } 
           }
    }   
            
    }          
       
    public void customergui(){
        
    JFrame frame = new JFrame("Müşteri Paneli");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel lblKalkis = new JLabel("Nereden kalkacaksınız?");
        lblKalkis.setBounds(20, 30, 150, 20);
        frame.getContentPane().add(lblKalkis);

        JComboBox<String> cmbKalkis = new JComboBox<>(sehirler1);
        cmbKalkis.setBounds(180, 30, 150, 20);
        frame.getContentPane().add(cmbKalkis);

        JLabel lblVaris = new JLabel("Nereye gideceksiniz?");
        lblVaris.setBounds(20, 60, 150, 20);
        frame.getContentPane().add(lblVaris);

        JComboBox<String> cmbVaris = new JComboBox<>(sehirler2);
        cmbVaris.setBounds(180, 60, 150, 20);
        frame.getContentPane().add(cmbVaris);
        
        JLabel lblZaman = new JLabel("Yolculuk zamanı (4-10 Aralık ):");
        lblZaman.setBounds(20, 90, 200, 20);
        frame.getContentPane().add(lblZaman);

        JComboBox<Integer> cmbZaman = new JComboBox<>(zamanAraligi);
        cmbZaman.setBounds(220, 90, 60, 20);
        frame.getContentPane().add(cmbZaman);

        JLabel lblYolcuSayisi = new JLabel("Kaç kişi yolculuk yapacak?");
        lblYolcuSayisi.setBounds(20, 120, 150, 20);
        frame.getContentPane().add(lblYolcuSayisi);

        JTextField txtYolcuSayisi = new JTextField();
        txtYolcuSayisi.setBounds(180, 120, 150, 20);
        frame.getContentPane().add(txtYolcuSayisi);

        JButton btnOnayla = new JButton("Onayla");
        btnOnayla.setBounds(180, 150, 100, 30);
        frame.getContentPane().add(btnOnayla);

        btnOnayla.addActionListener(e -> {
            String kalkis = (String) cmbKalkis.getSelectedItem();
            String varis = (String) cmbVaris.getSelectedItem();
            int zaman = (int) cmbZaman.getSelectedItem();
            int yolcuSayisi = Integer.parseInt(txtYolcuSayisi.getText());
           if(kalkis!=varis){
            for(Transport transport:transport){
                
                if(zaman==transport.trip.getZaman()&&
        Arrays.asList(transport.trip.gidişat.getGüzergah()).contains(varis) && Arrays.asList(transport.trip.gidişat.getGüzergah()).contains(kalkis)&&  
        transport.getBoskoltuk()>=yolcuSayisi && transport.trip.vehicle.route.getSefersayı() != null ) {
                
                    
                  availableTransports.add(transport);  
         
            }   
          }     
           }
           else  
           JOptionPane.showMessageDialog(frame, "Kalkış ve varış noktası aynı olamaz.", "Hata", JOptionPane.ERROR_MESSAGE);
             if (availableTransports.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Uygun sefer bulunamadı.", "Hata", JOptionPane.ERROR_MESSAGE);
        } else {
            String[] transportOptions = new String[availableTransports.size()];
            for (int i = 0; i < availableTransports.size(); i++) {
                transportOptions[i] = "Araç Bilgileri: " + availableTransports.get(i).trip.vehicle.getSirket() + "  " +
                        availableTransports.get(i).trip.vehicle.getAracno() +
                        " - Sefer: " + availableTransports.get(i).trip.gidişat.getRoutename() +
                        " - Boş Koltuk Sayısı: " + availableTransports.get(i).getBoskoltuk() +
                        " - Bilet Fiyatı: " + availableTransports.get(i).getBiletFiyat(kalkis,varis);
            }
             

            String selectedTransport = (String) JOptionPane.showInputDialog(
                    frame,
                    "Lütfen bir sefer seçin:",
                    "Uygun Seferler",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    transportOptions,
                    transportOptions[0]);                      
             
             if (selectedTransport != null) {
           
                 int bosk=availableTransports.get(Arrays.asList(transportOptions).indexOf(selectedTransport)).getBoskoltuk();
                 
            Transport newReservation = new Transport(availableTransports.get(Arrays.asList(transportOptions).indexOf(selectedTransport)).trip);
            
            newReservation.copySeatStatus(availableTransports.get(Arrays.asList(transportOptions).indexOf(selectedTransport)).getSeatStatus());
            newReservation.setBoskoltuk(bosk);
            newReservation.setSeatsayi(availableTransports.get(Arrays.asList(transportOptions).indexOf(selectedTransport)).trip.vehicle.getKapasite());
            newReservation.setTicketPrice(availableTransports.get(Arrays.asList(transportOptions).indexOf(selectedTransport)).getTicketPrice()); 
            newReservation.setGelgit(availableTransports.get(Arrays.asList(transportOptions).indexOf(selectedTransport)).getGelgit());
            newReservation.setYolcusayi(yolcuSayisi);          
            newReservation.setYolcuödemesayi(yolcuSayisi);
            newReservation.setBiletfiyat(newReservation.getBiletFiyat(kalkis,varis));
            
            
            
            newReservation.reservationgui();
   
         }     
             
             
     }
              
              
             
          
            
        });
    
    
    
    
    
        }
   }
                





