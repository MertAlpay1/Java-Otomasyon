package proje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static proje.Admin.companylist;
import static proje.Customer.transport;

public class Company extends User implements IProfitable {
    
    
    private Vehicle vehicle;
    private static Route route;
    static  List<Vehicle> vehiclelist = new ArrayList<>();
    static List<Route> seferListesi = new ArrayList<>();
    static List<Personel> personelList = new ArrayList<>();
       
    private static Company deletedCompany;
   
   
   private Company currentCompany;
    static Route sefer1 = new Route("tren", "sefer1", "istanbul", "ankara", 750);
    static Route sefer2 = new Route("tren", "sefer2", "istanbul", "konya", 900);
    static Route sefer3 = new Route("otobus", "sefer3", "istanbul", "ankara", 2000);
    static Route sefer4 = new Route("otobus", "sefer4", "istanbul", "konya", 1200);
    static Route sefer5 = new Route("ucak", "sefer5", "istanbul", "konya", 600);
    static Route sefer6 = new Route("ucak", "sefer6", "istanbul", "ankara", 500);
    
    static Personel personel1=new Personel("Mert","Alpo","sirketA","sofor","otobus",5000); 
    static Personel personel2=new Personel("a", "a", "sirketA", "hizmet","otobus", 2000);
   static Personel personel3 = new Personel("b", "b", "sirketB", "sofor", "otobus", 3000);
   static Personel personel4 = new Personel("", "", "sirketB", "hizmet", "otobus", 1500);

  static Personel personel5 = new Personel("e", "e", "sirketC", "sofor", "otobus", 4000);
  static Personel personel6 = new Personel("g", "g", "sirketC", "hizmet", "otobus", 2000);
  static Personel personel7 = new Personel("f", "f", "sirketC", "sofor", "ucak", 10000);
  static Personel personel8 = new Personel("h", "h", "sirketC", "hizmet", "ucak", 6000);
  static Personel personel9 = new Personel("i", "i", "sirketD", "sofor", "tren", 2000);
  static Personel personel10 = new Personel("j", "j", "sirketD", "hizmet", "tren", 1000);
  static Personel personel11 = new Personel("k", "k", "sirketF", "sofor", "ucak", 7500);
  static Personel personel12 = new Personel("l", "l", "sirketF", "hizmet", "ucak", 4000);
    public Company(String kullanıcıad,String sifre)
    {
        super(kullanıcıad,sifre);
    
         
    }
        

    public static void initializeDataCompany(){
        vehiclelist.add( new Bus("sirketA","otobus 1", "Benzin",10, 20, sefer3));   
        vehiclelist.add( new Bus("sirketA","otobus 2", "Benzin",10, 15, sefer3));   
        vehiclelist.add( new Bus("sirketB","otobus 1", "Motorin",5, 15, sefer3));
        vehiclelist.add( new Bus("sirketB","otobus 2", "Motorin",5, 20, sefer4));
        vehiclelist.add( new Bus("sirketC","otobus 1", "Motorin",6, 20, sefer4));
        vehiclelist.add( new Airplane("sirketC","ucak 1", "Gaz",25, 30, sefer5));
        vehiclelist.add( new Airplane("sirketC","ucak 2", "Gaz",25, 30, sefer5));
        vehiclelist.add( new Train("sirketD","tren 1", "Elektrik",3, 25, sefer1));
        vehiclelist.add( new Train("sirketD","tren 2", "Elektrik",3, 25, sefer2));
        vehiclelist.add( new Train("sirketD","tren 3", "Elektrik",3, 25, sefer2));
        vehiclelist.add( new Airplane("sirketF","ucak 1", "Gaz",20, 30, sefer6));
        vehiclelist.add( new Airplane("sirketF","ucak 2", "Gaz",20, 30, sefer6));
        
        seferListesi.add(new Route("tren", "sefer1", "istanbul", "ankara", 750));
        seferListesi.add(new Route("tren", "sefer2", "istanbul", "konya", 900));
        seferListesi.add(new Route("otobus", "sefer3", "istanbul", "ankara", 2000));
        seferListesi.add(new Route("otobus", "sefer4", "istanbul", "ankara", 2000));
        seferListesi.add(new Route("ucak", "sefer5", "istanbul", "konya", 600));
        seferListesi.add(new Route("ucak", "sefer6", "istanbul", "ankara", 500));
       
        personelList.add(personel1);
        personelList.add(personel2);
        personelList.add(personel3);
        personelList.add(personel4);
        personelList.add(personel5);
        personelList.add(personel6);
        personelList.add(personel7);
        personelList.add(personel8);
        personelList.add(personel9);
        personelList.add(personel10);
        personelList.add(personel11);
        personelList.add(personel12);
       
    }
        
    
        
       
 
 
    public void companygui(){
        
         JFrame frame = new JFrame(getKullaniciAdi() + " - Şirket Paneli");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);

         JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        
        JButton Görüntüle = new JButton("Aracları Görüntüle");
        Görüntüle.addActionListener(e -> Görüntüle());
        buttonPanel.add(Görüntüle);

        // Button for viewing existing companies
        JButton AracEkle = new JButton("Arac Ekle");
        AracEkle.addActionListener(e -> aracEkle());
        buttonPanel.add(AracEkle);

        // Button for adding a new company
        JButton AracSil = new JButton("Arac Sil");
        AracSil.addActionListener(e -> aracSil());
        buttonPanel.add(AracSil);

        // Button for deleting a company
        JButton Seferekle = new JButton("Sefer Ekle");
        Seferekle.addActionListener(e -> seferEkle());
        buttonPanel.add(Seferekle);

        JButton Sefersil = new JButton("Sefer Sil");
        Sefersil.addActionListener(e -> seferSil());
        buttonPanel.add(Sefersil);
        
        JButton Günlükkar = new JButton("Günlük Kar Hesabı");
        Günlükkar.addActionListener(e -> gunlukKarHesapla());
        buttonPanel.add(Günlükkar);
       
        frame.add(buttonPanel);
        frame.setVisible(true);
         
    }

    private void Görüntüle(){
        
    JFrame vehicleFrame = new JFrame("Araçlar");
        vehicleFrame.setSize(400, 300);
        vehicleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (Vehicle vehicle : vehiclelist) {
            if (vehicle.getSirket().equals(getKullaniciAdi())) {
                Route route = vehicle.getRoute();
                JLabel label = new JLabel("Araç ID: " + vehicle.getAracno() + " - Yakıt Türü: " + vehicle.getYakitTuru()+
                        "- Kapasite: "+vehicle.getKapasite()+"-sefer:"+route.getSefersayı());
                panel.add(label);
            }
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        vehicleFrame.add(scrollPane);

        vehicleFrame.setLocationRelativeTo(null);
        vehicleFrame.setVisible(true);
    }


    

        
    
    
  private void aracEkle() {
    JDialog aracEkleDialog = new JDialog((JFrame) null, "Araç Ekle", true);
    aracEkleDialog.setSize(400, 300);

    // Araç türlerini içeren bir dizi
    String[] aracTurleri = {"otobus", "ucak", "tren"};

    // Kullanıcıdan araç türünü seçmesini iste
    String selectedAracTur = (String) JOptionPane.showInputDialog(null,
            "Lütfen aracın türünü seçiniz:", "Araç Türü", JOptionPane.QUESTION_MESSAGE, null,
            aracTurleri, aracTurleri[0]);

    if (selectedAracTur != null) {
        // Diğer araç özelliklerini kullanıcıdan al
        String aracID = JOptionPane.showInputDialog(null, "Araç ID'sini giriniz:", "Araç ID", JOptionPane.QUESTION_MESSAGE);
        String yakitTuru = "";

        // Seçilen araç türüne göre uygun yakıt türünü seç
        switch (selectedAracTur) {
            case "otobus":
                String[] otobusYakitTurleri = {"Benzin", "Motorin"};
                yakitTuru = (String) JOptionPane.showInputDialog(null,
                        "Lütfen otobüsün yakıt türünü seçiniz:", "Yakıt Türü", JOptionPane.QUESTION_MESSAGE, null,
                        otobusYakitTurleri, otobusYakitTurleri[0]);
                break;
            case "ucak":
                yakitTuru = "Gaz";
                break;
            case "tren":
                yakitTuru = "Elektrik";
                break;
        }

        String kapasiteStr = JOptionPane.showInputDialog(null, "Kapasiteyi giriniz:", "Kapasite", JOptionPane.QUESTION_MESSAGE);
        String kmUcretStr = JOptionPane.showInputDialog(null, "Kilometre Ücretini giriniz:", "Kilometre Ücreti", JOptionPane.QUESTION_MESSAGE);

        try {
            int kapasite = Integer.parseInt(kapasiteStr);
            int kmUcret = Integer.parseInt(kmUcretStr);

            // Kullanıcının sefer seçimini yapmasını sağla
           List<String> seferIDs = new ArrayList<>();


          for (Route sefer : seferListesi) {
            if (sefer.getTür().equals(selectedAracTur)) {
              seferIDs.add(sefer.getSefersayı());
               }
           }

          
          String selectedSeferID = (String) JOptionPane.showInputDialog(null,
           "Lütfen aracınızın seferini seçiniz:", "Sefer Seçimi", JOptionPane.QUESTION_MESSAGE, null,
            seferIDs.toArray(new String[0]), seferIDs.get(0));

           Route selectedRoute = null;

            // Seçilen sefer ID'sine göre uygun rota bilgisini bul
            for (Route route : seferListesi) {
             if (route.getSefersayı().equals(selectedSeferID)) {
                selectedRoute = route;
                break;
                }
              }

            // Seçilen araç türüne ve sefere göre uygun aracı oluştur
            Vehicle newVehicle = null;

            switch (selectedAracTur) {
                case "otobus":
                    newVehicle = new Bus(getKullaniciAdi(), aracID, yakitTuru, kmUcret, kapasite, selectedRoute);
                    break;
                case "ucak":
                    newVehicle = new Airplane(getKullaniciAdi(), aracID, yakitTuru, kmUcret, kapasite, selectedRoute);
                    break;
                case "tren":
                    newVehicle = new Train(getKullaniciAdi(), aracID, yakitTuru, kmUcret, kapasite, selectedRoute);
                    break;
            }

            // Oluşturulan aracı listeye ekle
            if (newVehicle != null) {
                vehiclelist.add(newVehicle);
                Customer.addVehicle(newVehicle);
                JOptionPane.showMessageDialog(aracEkleDialog, "Araç başarıyla eklendi!", "Başarı", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(aracEkleDialog, "Arac eklenemedi.", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(aracEkleDialog, "Geçersiz kapasite veya kilometre ücreti. Lütfen geçerli sayılar girin.", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }

    aracEkleDialog.setVisible(true);
}

   private void aracSil() {
    String[] aracIDs = new String[vehiclelist.size()];

    // Kullanıcının şirketine ait araçları seçeneğe ekle
    int index = 0;
    for (int i = 0; i < vehiclelist.size(); i++) {
        Vehicle vehicle = vehiclelist.get(i);
        if (vehicle.getSirket().equals(getKullaniciAdi())) {
            aracIDs[index++] = vehicle.getAracno();
        }
    }

    // Kullanıcıya araç seçtir
    String selectedAracID = (String) JOptionPane.showInputDialog(
            null, "Silinecek aracı seçiniz:",
            "Araç Silme", JOptionPane.QUESTION_MESSAGE, null,
            Arrays.copyOf(aracIDs, index), aracIDs[0]
    );

    // Kullanıcı bir araç seçtiyse silme işlemini gerçekleştir
    if (selectedAracID != null) {
        for (int i = 0; i < vehiclelist.size(); i++) {
            Vehicle vehicle = vehiclelist.get(i);
            if (vehicle.getAracno().equals(selectedAracID) && vehicle.getSirket().equals(getKullaniciAdi())) {
                vehiclelist.remove(i);
                JOptionPane.showMessageDialog(null, "Araç başarıyla silindi.", "Başarı", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
    }
}
   
    private void seferEkle() {
        
        
         JDialog seferEkleDialog = new JDialog((JFrame) null, "Sefer Ekle", true);
    seferEkleDialog.setSize(400, 300);

    // Sefer türlerini içeren bir dizi
    String[] seferTurleri = {"otobus", "ucak", "tren"};

    // Kullanıcıdan sefer türünü seçmesini iste
    String selectedSeferTur = (String) JOptionPane.showInputDialog(null,
            "Lütfen seferin türünü seçiniz:", "Sefer Türü", JOptionPane.QUESTION_MESSAGE, null,
            seferTurleri, seferTurleri[0]);

    if (selectedSeferTur != null) {
        // Diğer sefer özelliklerini kullanıcıdan al
         
        String seferid=JOptionPane.showInputDialog(null, "Seferid giriniz:", "İd", JOptionPane.QUESTION_MESSAGE);
        String kalkis = JOptionPane.showInputDialog(null, "Kalkış noktasını giriniz:", "Kalkış", JOptionPane.QUESTION_MESSAGE);
        String varis = JOptionPane.showInputDialog(null, "Varış noktasını giriniz:", "Varış", JOptionPane.QUESTION_MESSAGE);
                       
        try {
            

            // Yeni bir rota oluştur
            Route newSefer = new Route(selectedSeferTur,seferid ,kalkis, varis);

            int mesafe=newSefer.MesafeBul(selectedSeferTur, kalkis, varis);
            newSefer.setMesafe(mesafe);

            System.out.println(mesafe);
            
            String[] güzergah = null;
            
            switch(selectedSeferTur){
            
            case"otobus":
            
        
        
        String otobusGüzergah = JOptionPane.showInputDialog(null, "Otobüs güzergahını : \n"
                + "istanbul-kocaeli-eskisehir-ankara-konya-ankara-eskisehir-kocaeli-istanbul formatında giriniz", "Güzergah", JOptionPane.QUESTION_MESSAGE);

        // Girilen güzergahı kullan
        güzergah = otobusGüzergah.split("-");
                
                break;
            case"tren":
            String trenGüzergah = JOptionPane.showInputDialog(null, "Tren güzergahını:\n"
                + "istanbul-kocaeli-bilecik-eskisehir-ankara-konya-ankara-eskisehir-bilecik-kocaeli-istanbul formatında giriniz", "Güzergah", JOptionPane.QUESTION_MESSAGE);
                
                 güzergah = trenGüzergah.split("-");
                break;
            case"ucak":
            
                 String ucakGüzergah = JOptionPane.showInputDialog(null, "Uçak güzergahını:\n"
                + "istanbul-ankara-konya-ankara-konya formatında giriniz", "Güzergah", JOptionPane.QUESTION_MESSAGE);
                
                güzergah = ucakGüzergah.split("-");
                break;
            default:
                System.out.println("gecersiz sefer tur");
         }
            
            if (güzergah != null) {
                System.out.print("Güzergah: ");
                for (String durak : güzergah) {
                    System.out.println(durak );
                }
               
            }
            
            Gidişat newgidiş=new Gidişat(seferid, güzergah);
            
           System.out.println("1.durak=" + newgidiş.getGüzergah().length);

            
            // Oluşturulan rotayı sefer listesine ekle
            seferListesi.add(newSefer);
            Customer.addGidişat(newgidiş);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(seferEkleDialog, "Geçersiz fiyat. Lütfen geçerli bir sayı girin.", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }

    seferEkleDialog.setVisible(true);
       
    }

    private void seferSil() {
        
    
   List<String> seferIDs = new ArrayList<>();

    // Kullanıcının şirketine ait seferleri seçeneğe ekle
    for (Route sefer : seferListesi) {
        seferIDs.add(sefer.getSefersayı());
    }

    // Kullanıcıya sefer seçtir
    String selectedSeferID = (String) JOptionPane.showInputDialog(
            null, "Silinecek seferi seçiniz:",
            "Sefer Silme", JOptionPane.QUESTION_MESSAGE, null,
            seferIDs.toArray(new String[0]), seferIDs.get(0)
    );

    // Kullanıcı bir sefer seçtiyse silme işlemini gerçekleştir
    if (selectedSeferID != null) {
        // Silinecek seferin bağlı olduğu araçları kontrol et
        boolean hasAssociatedVehicle = false;
        for (Vehicle vehicle : vehiclelist) {
            if (vehicle.getRoute() != null && vehicle.getRoute().getSefersayı().equals(selectedSeferID)&&vehicle.getSirket().equals(kullaniciAdi)) {
                
                  vehicle.route.setSefersayı("NULL");
                
                
            }
        }

        
    }
        
        
    }

    @Override
    public void gunlukKarHesapla() {
        JFrame frame = new JFrame("Günlük Kar Hesaplama");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

      
        JLabel label = new JLabel("Lütfen bir tarih seçin (4-10 Aralık ):");
        panel.add(label);

        
        Integer[] dates = {4, 5, 6, 7, 8, 9, 10};
        JComboBox<Integer> dateComboBox = new JComboBox<>(dates);
        panel.add(dateComboBox);

        // Create a JButton for calculation
        JButton calculateButton = new JButton("Hesapla");
        panel.add(calculateButton);

        // Add an ActionListener to the button
        calculateButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
               
                gunlukKarHesapla((int) dateComboBox.getSelectedItem());
            }
        });

        // Set up the frame
        
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
       
    @Override
 public void gunlukKarHesapla(int selectedDate) {

 
        int biletfiyat=0;
        int Toplamgider=0;
        int Toplamkar=0;
        int sofor=0;
        int hizmet=0;
        int yakıt=0;
        int toplampersonel=0;
        int hizmetbedeli=Hizmetbedeli.getHizmetBedeli();
        int zaman=selectedDate;
        
        
        for(Transport transport:transport){
            if (transport.trip.vehicle.getSirket().equals(getKullaniciAdi()) && transport.trip.vehicle.getRoute() != null&&
              transport.trip.vehicle.route.getSefersayı()!="NULL" && transport.trip.getZaman()==zaman ){
            
                biletfiyat=biletfiyat+transport.getTicketPrice();
                yakıt=yakıt+transport.trip.vehicle.CalculateFuelCost();
               
               for(Personel personel:personelList){
                
                if(personel.getSirket().equals(getKullaniciAdi())&&personel.getTür().equals(transport.trip.vehicle.route.getTür())){
                
                   switch(personel.getPersoneltip()){
                       
                       case"sofor":
                           //2kere gidiş dönüş ve 2 tane personel 
                           sofor=sofor+(personel.getÜcret())*4;
                    
                           break;
                       case"hizmet":
                           
                           hizmet=hizmet+(personel.getÜcret())*4;
                                                              
                           break;
                           
                               
                }
                   
            }
            
            
        }
            
      } 
    }
      toplampersonel=hizmet+sofor;  
      Toplamgider=toplampersonel+yakıt+hizmetbedeli;
      Toplamkar=biletfiyat-Toplamgider;
       // System.out.println("personel fiyatları:"+toplampersonel);  
       // System.out.println("bilet fiyat:"+biletfiyat);  
       // System.out.println("yakıt parası:"+yakıt);
       // System.out.println("Hizmet Bedeli:"+hizmetbedeli);
        
       // System.out.println("toplam gider:"+Toplamgider);
       // System.out.println("Toplam kar/zarar:"+Toplamkar);
       String resultMessage = "Personel Fiyatları: " + toplampersonel +
                "\nBilet Fiyatı: " + biletfiyat +
                "\nYakıt Parası: " + yakıt +
                "\nHizmet Bedeli: " + hizmetbedeli +
                "\nToplam Gider: " + Toplamgider +
                "\nToplam Kar/Zarar: " + Toplamkar;

        JOptionPane.showMessageDialog(null, resultMessage, "Günlük Kar Hesaplaması", JOptionPane.INFORMATION_MESSAGE);
    
    }


      
       @Override
    public void createAndShowGUI() {
    }

    @Override
    public void showAdmin() {
    }

    @Override
    public void showSirket() {
    }

    @Override
    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

   

    @Override
    public String getSifre() {
        return sifre;
    }

    


    public static Company getDeletedCompany() {
        return deletedCompany;
    }

    public static void setDeletedCompany(Company deletedCompany) {
        Company.deletedCompany = deletedCompany;
    }
}
