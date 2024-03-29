package proje;

import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Admin extends User {

   public static List<Company> companylist = new ArrayList<>();
     
    
    public Admin(String kullaniciAdi, String sifre) {
        super(kullaniciAdi, sifre);
        
    }
public static void initializeDataAdmin(){
        companylist.add(new Company("sirketA", "123"));      
        companylist.add(new Company("sirketB", "123"));
        companylist.add(new Company("sirketC", "123"));
        companylist.add(new Company("sirketD", "123"));
        companylist.add(new Company("sirketF", "123"));
    
    
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
    
    public void admingui()
    {
      
        JFrame frame = new JFrame("Admin Panel");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        
     JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        
        JButton viewCompaniesButton = new JButton("Var olan firmalari görüntüle");
        viewCompaniesButton.addActionListener(e -> viewCompanies());
        buttonPanel.add(viewCompaniesButton);

        
        JButton addCompanyButton = new JButton("Yeni Bir Firma Kaydı Yap");
        addCompanyButton.addActionListener(e -> addCompany());
        buttonPanel.add(addCompanyButton);

        
        JButton deleteCompanyButton = new JButton("Şirket Sil");
        deleteCompanyButton.addActionListener(e -> deleteCompany());
        buttonPanel.add(deleteCompanyButton);

       
        JButton setServiceFeeButton = new JButton("Günlük Hizmet Bedeli Ayarla");
        setServiceFeeButton.addActionListener(e -> setServiceFee());
        buttonPanel.add(setServiceFeeButton);

        frame.add(buttonPanel);
        frame.setVisible(true);
    }

    private void viewCompanies() {
       
        JDialog adminDialog = new JDialog((JFrame)null, "Var Olan Firmalar", true);
    adminDialog.setSize(300, 200);
    
    
    JPanel dialogPanel = new JPanel();
    dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.Y_AXIS));

    
    for (Company company : companylist) {
        JLabel companyLabel = new JLabel("Şirket Adı: " + company.getKullaniciAdi());
        dialogPanel.add(companyLabel);
    }

    
    adminDialog.add(dialogPanel);

    
    adminDialog.setVisible(true);

        
    }

    private void addCompany() {
        JDialog adminDialog = new JDialog((JFrame)null, "Yeni Firma Kaydı", true);
    adminDialog.setSize(300, 200);
    
    String companyName = JOptionPane.showInputDialog(adminDialog, "Firma adını giriniz:", "Yeni Firma", JOptionPane.QUESTION_MESSAGE);
    String companyPassword = JOptionPane.showInputDialog(adminDialog, "Firma şifresini giriniz:", "Yeni Firma", JOptionPane.QUESTION_MESSAGE);
    
 if (companyName != null && !companyName.isEmpty() && companyPassword != null && !companyPassword.isEmpty()) {
        
        Company newCompany = new Company(companyName, companyPassword);
        companylist.add(newCompany);
        
     
    
        
        JOptionPane.showMessageDialog(adminDialog, "Yeni firma başarıyla eklendi!", "Başarı", JOptionPane.INFORMATION_MESSAGE);
    } else {
        
        JOptionPane.showMessageDialog(adminDialog, "Geçersiz giriş. Firma adı ve şifre gereklidir.", "Hata", JOptionPane.ERROR_MESSAGE);
    }

    
    
    adminDialog.setVisible(true);
        
    }

    private void deleteCompany() {
        String[] companyNames = new String[companylist.size()];
    for (int i = 0; i < companylist.size(); i++) {
        companyNames[i] = companylist.get(i).getKullaniciAdi();
    }

    // Kullanıcıya şirket seçtir
    String selectedCompanyName = (String) JOptionPane.showInputDialog(null,"Silinecek firmayı seçiniz:",
            "Firma Silme",JOptionPane.QUESTION_MESSAGE,null,companyNames,companyNames[0]
    );
            

    // Kullanıcı bir firma seçtiyse silme işlemini gerçekleştir
    if (selectedCompanyName != null) {
        for (Company company : companylist) {
            if (company.getKullaniciAdi().equals(selectedCompanyName)) {
                Company.setDeletedCompany(company);
                companylist.remove(company);
                
               
            
                
                break;
            }
        }

        // Silme işlemi başarıyla gerçekleştiğine dair bilgi mesajı göster
        JOptionPane.showMessageDialog(null, "Firma başarıyla silindi.", "Başarı", JOptionPane.INFORMATION_MESSAGE);
    }
    }

    private void setServiceFee() {
         
          String hizmetbedel = JOptionPane.showInputDialog(null, "Günlük hizmet bedelini giriniz (varsayılan: " + Hizmetbedeli.getHizmetBedeli() + "):", "Hizmet Bedeli Ayarla", JOptionPane.QUESTION_MESSAGE);

    try {
        int newServiceFee = (hizmetbedel != null && !hizmetbedel.isEmpty()) ? Integer.parseInt(hizmetbedel) : Hizmetbedeli.getHizmetBedeli();
        
        Hizmetbedeli.setHizmetBedeli(newServiceFee);

       

        JOptionPane.showMessageDialog(null, "Tüm şirketlerin günlük hizmet bedeli başarıyla güncellendi.", "Başarı", JOptionPane.INFORMATION_MESSAGE);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Geçersiz giriş. Lütfen geçerli bir sayı girin.", "Hata", JOptionPane.ERROR_MESSAGE);
    }
    
    
    
    
    
}

    public static List<Company> getCompanylist() {
        return companylist;
    }

    public static void setCompanylist(List<Company> companylist) {
        Admin.companylist = companylist;
    }

   @Override
    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

   @Override
    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

   @Override
    public String getSifre() {
        return sifre;
    }

   @Override
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    
    
    
}      
