
    package proje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
    import java.util.Random;
    import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;


    public class Transport implements IReservable {
  
        Trip trip;
        private int seatsayi;
        public boolean[] seatStatus;
        //güzergah uzunluğu
        int ticketPrice=0;
        int gelgit=0;
        int doldurulankoltuks;
        int boskoltuk;
        
        int yolcuödemesayi;
        int biletfiyat;
        
        int yolcusayi;
        public List<Passenger> passengers;
        private List<Integer> selectedSeatNumbers = new ArrayList<>();
      
        public Transport(Trip trip) {
            this.trip = trip;

           this.seatsayi = trip.vehicle.getKapasite(); 
           
           this.seatStatus = new boolean[seatsayi];
           
        }
     public void randomizeSeatStatus() {
         Random random = new Random();
         boskoltuk=seatsayi;
            for(int j=0;j<trip.gidişat.getGüzergah().length;j++){

                if(trip.gidişat.getGüzergah()[j]==trip.vehicle.route.getVarıs()){
                    gelgit++;               
                }

            }
            gelgit=gelgit*2;
             int doluKoltukSayisi = 0;
            int secim=random.nextInt(2);
            switch(secim){
               
                case 0:
                      doluKoltukSayisi = (random.nextInt(4)+2) *seatsayi/5 ;
                    break;
                case 1:
                    int randoma=random.nextInt(4);
                      doluKoltukSayisi = seatsayi-randoma;
                    break;
                
            }

                
             
             doldurulankoltuks = 0;

            while(doldurulankoltuks < doluKoltukSayisi){
           
                int randomseat=random.nextInt(trip.vehicle.getKapasite());
                                                   
                if (!seatStatus[randomseat]){   
                    
                    seatStatus[randomseat]=true;
                    
                int randomIndex = random.nextInt(trip.fiyat.length);
                ticketPrice = trip.fiyat[randomIndex]+ticketPrice;
                doldurulankoltuks++;
                boskoltuk--;
            }

            
     }
            ticketPrice=ticketPrice*gelgit;
            
            
        }
     
     
@Override
public void reservationgui() {
    
    
    
    JFrame frame = new JFrame("Koltuk Seçimi");
    frame.setSize(600, 450);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    JLabel infoLabel = new JLabel("Lütfen bir koltuk seçiniz:");
    frame.add(infoLabel, BorderLayout.NORTH);

    JPanel seatPanel = new JPanel(new GridLayout(2, seatsayi / 2));
    ButtonGroup seatButtonGroup = new ButtonGroup();

  
    for (int i = 0; i < seatsayi; i++) {
        JToggleButton seatButton = new JToggleButton(Integer.toString(i + 1));
        seatButton.setActionCommand(Integer.toString(i + 1));

        // Boş koltukları yeşil, dolu koltukları kırmızı göster
        if (!seatStatus[i]) {
            seatButton.setBackground(Color.GREEN);
        } else {
            seatButton.setBackground(Color.RED);
            seatButton.setEnabled(false); // Dolu koltukları seçilemez yap
        }

        seatButton.addActionListener(e -> handleSeatSelection(Integer.parseInt(e.getActionCommand())));
        seatPanel.add(seatButton);
        seatButtonGroup.add(seatButton);
    }
 

    frame.add(seatPanel, BorderLayout.CENTER);

    JButton closeButton = new JButton("Kapat");
    closeButton.addActionListener(e -> frame.dispose());
    frame.add(closeButton, BorderLayout.SOUTH);

    
    
    
    
    
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
           
}

    private void handleSeatSelection(int selectedSeat) {
        if (seatStatus[selectedSeat - 1]) {
            JOptionPane.showMessageDialog(null, "Bu koltuk dolu, lütfen başka bir koltuk seçin.", "Hata", JOptionPane.ERROR_MESSAGE);
        } else {
            int result = JOptionPane.showConfirmDialog(null, "Seçtiğiniz koltuk boş, rezervasyon yapmak istiyor musunuz?", "Onay", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                
                selectedSeatNumbers.add(selectedSeat);
                
                seatStatus[selectedSeat - 1] = true;
                handlePassengerInformation();
                boskoltuk--;
                yolcusayi--;
                          
                 if (yolcusayi == 0) {
             
                     //Belirtilen yolcu sayısına ulaştığında ödeme ekranına gel
                     performPayment();
                     
                     
                    }
            }
        }
    }

        @Override
      public void handlePassengerInformation() {
        JFrame passengerFrame = new JFrame("Yolcu Bilgileri");
        passengerFrame.setSize(450, 300);
        passengerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        passengerFrame.setLayout(new GridLayout(5, 5));

        JLabel nameLabel = new JLabel("Ad:");
        JTextField nameField = new JTextField();

        JLabel surnameLabel = new JLabel("Soyad:");
        JTextField surnameField = new JTextField();

        JLabel tcLabel = new JLabel("TC No:");
        JTextField tcField = new JTextField();
 
         JLabel dtarihLabel = new JLabel("Dogum Tarihi:");
        JTextField dtarihField = new JTextField();
        
        passengerFrame.add(nameLabel);
        passengerFrame.add(nameField);
        passengerFrame.add(surnameLabel);
        passengerFrame.add(surnameField);
        passengerFrame.add(tcLabel);
        passengerFrame.add(tcField);
        passengerFrame.add(dtarihLabel);
        passengerFrame.add(dtarihField);
        
        JButton confirmButton = new JButton("Onayla");
        confirmButton.addActionListener(e -> {
            String name = nameField.getText();
            String surname = surnameField.getText();
            int tc = Integer.parseInt(tcField.getText());
            String dtarih=dtarihField.getText();
            
            Passenger passenger = new Passenger(name,surname,tc,dtarih);
            passengers = new ArrayList<>();
            passengers.add(passenger);
            
                 
            passengerFrame.dispose(); 
        });

        
        passengerFrame.add(confirmButton);

        passengerFrame.setLocationRelativeTo(null);
        passengerFrame.setVisible(true);
    }
     
        @Override
      public void performPayment() {
        JFrame payFrame = new JFrame("Yolcu Bilgileri");
        payFrame.setSize(450, 300);
        payFrame.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
          
        JLabel paymentLabel = new JLabel("Toplam Ödeme Tutarı: " + biletfiyat*yolcuödemesayi + " TL");
          payFrame.add(paymentLabel);
        
          ticketPrice=ticketPrice+biletfiyat*yolcuödemesayi;
          
          
          JButton payButton = new JButton("Ödeme Yap");
          
    payButton.addActionListener(e -> {
          
         JOptionPane.showMessageDialog(null, "Ödeme işlemi başarıyla tamamlandı!");
        
         showReservationDetails();

        
        
    });
    
        payFrame.add(payButton);
        payFrame.setLocationRelativeTo(null);
        payFrame.setVisible(true);
    }
        @Override
      public void showReservationDetails() {
      
       JFrame detailsFrame = new JFrame("Rezervasyon Detayları");
        detailsFrame.setSize(400, 200);
        detailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        detailsFrame.setLayout(new FlowLayout());

        JLabel vehicleLabel = new JLabel("Araç No: " + trip.vehicle.getAracno());
        JLabel companyLabel = new JLabel("Şirket: " + trip.vehicle.getSirket());
        JLabel routeLabel = new JLabel("Güzergah: " + trip.gidişat.getRoutename());
        JLabel seatNumbersLabel = new JLabel("Rezerve Edilen Koltuklar: " + RezerveKoltuklar());

         for (int i = 0; i < passengers.size() && i < selectedSeatNumbers.size(); i++) {
        int seatNumber = selectedSeatNumbers.get(i);
        Passenger passenger = passengers.get(i);

        Reservation newReservation = new Reservation(passenger, trip.vehicle.route.getSefersayı(), seatNumber);

    }
         
        detailsFrame.add(vehicleLabel);
        detailsFrame.add(companyLabel);
        detailsFrame.add(routeLabel);
        detailsFrame.add(seatNumbersLabel);

        detailsFrame.setLocationRelativeTo(null);
        detailsFrame.setVisible(true);
          
          
      }
      private String RezerveKoltuklar() {
        StringBuilder formattedSeatNumbers = new StringBuilder();
        for (Integer seatNumber : selectedSeatNumbers) {
            formattedSeatNumbers.append(seatNumber).append(", ");
        }
        if (formattedSeatNumbers.length() > 0) {
            formattedSeatNumbers.delete(formattedSeatNumbers.length() - 2, formattedSeatNumbers.length());
        }
        return formattedSeatNumbers.toString();
    }
      
      
      
    public void copySeatStatus(boolean[] source) {
    this.seatStatus = Arrays.copyOf(source, source.length);
}
     
     
        public boolean[] getSeatStatus() {
            return seatStatus;
        }

    public void setSeatsayi(int seatsayi) {
        this.seatsayi = seatsayi;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setGelgit(int gelgit) {
        this.gelgit = gelgit;
    }

    public int getSeatsayi() {
        return seatsayi;
    }

    public int getGelgit() {
        return gelgit;
    }

    public void setYolcusayi(int yolcusayi) {
        this.yolcusayi = yolcusayi;
    }

   

    public void setYolcuödemesayi(int yolcuödemesayi) {
        this.yolcuödemesayi = yolcuödemesayi;
    }

    public void setBiletfiyat(int biletfiyat) {
        this.biletfiyat = biletfiyat;
    }
        
    
        

 public int getBiletFiyat(String ilk, String son) {
    int fiyat = 0;
    int mesafe1 = 0;
    int mesafe2 = 0;

   
          
            switch (trip.vehicle.route.getTür()) {
                case "otobus":
                    if ("ankara".equals(ilk))
                        mesafe1 = 500;
                    if ("konya".equals(ilk))
                        mesafe1 = 600;
                    
                    if ("kocaeli".equals(son))
                        mesafe2 = 100;
                    if ("ankara".equals(son))
                        mesafe2 = 500;
                    if ("eskisehir".equals(son))
                        mesafe2 = 300;
                    if ("konya".equals(son))
                        mesafe2 = 600;
                     if("itsanbul".equals(son))
                        mesafe2=0;
                    fiyat= Math.abs(mesafe1 - mesafe2) / 2;
                    break;

                case "tren":
                    if ("ankara".equals(ilk))
                        mesafe1 = 375;
                     if ("konya".equals(ilk))
                        mesafe1 = 450;
                    if ("kocaeli".equals(son))
                        mesafe2 = 75;
                    if ("bilecik".equals(son))
                        mesafe2 = 225;
                    if ("ankara".equals(son))
                        mesafe2 = 375;
                    if ("eskisehir".equals(son))
                        mesafe2 = 300;
                    if ("konya".equals(son))
                        mesafe2 = 450;
                     if("itsanbul".equals(son))
                        mesafe2=0;
                    fiyat=(int) (Math.abs(mesafe1 - mesafe2) * (2.0 / 3.0));
                    break;

                default:
                    
                    if ("ankara".equals(ilk))
                        mesafe1 = 250;
                    if ("konya".equals(ilk))
                        mesafe1 = 300;
                    
                    if ("ankara".equals(son))
                        mesafe2 = 250;
                    if ("konya".equals(son))
                        mesafe2 = 300;
                    if("itsanbul".equals(son))
                        mesafe2=0;
                   fiyat= Math.abs(mesafe1 - mesafe2) * 4;
                    break;
            }
        
    
    
        return fiyat;
 }
 
 
 
    public int getTicketPrice() {
        return ticketPrice;
    }

    public int getBoskoltuk() {
        return boskoltuk;
    }

    public void setBoskoltuk(int boskoltuk) {
        this.boskoltuk = boskoltuk;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public int getDoldurulankoltuks() {
        return doldurulankoltuks;
    }

    public void setDoldurulankoltuks(int doldurulankoltuks) {
        this.doldurulankoltuks = doldurulankoltuks;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<Integer> getSelectedSeatNumbers() {
        return selectedSeatNumbers;
    }

    public void setSelectedSeatNumbers(List<Integer> selectedSeatNumbers) {
        this.selectedSeatNumbers = selectedSeatNumbers;
    }

    

    

        
        

    }
