
package proje;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static proje.Admin.companylist;

public class LoginImpl implements ILoginable {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "123";

  
    boolean oldu_mu=false;
    

    private Admin admin;
    private Company currentCompany;

  
    
    @Override
    public void createAndShowGUI() {
        JFrame frame = new JFrame("Bilet Otomasyonu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JMenuBar menuBar = new JMenuBar();
        JMenu girisMenu = new JMenu("Giriş");
        JMenuItem adminItem = new JMenuItem("Admin Girişi");
        JMenuItem sirketItem = new JMenuItem("Şirket Girişi");
        

        adminItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdmin(frame);
            }
        });

        sirketItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSirket(frame);
            }
        });

        

        girisMenu.add(adminItem);
        girisMenu.add(sirketItem);
       

        menuBar.add(girisMenu);
        frame.setJMenuBar(menuBar);

        // "Bilet Al" butonu
        JButton biletButton = new JButton("Bilet Al");
        biletButton.setBounds(0, 75, 100, 40);  // Butonun konumu ve boyutu

        biletButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer customer = new Customer();
                customer.customergui();
                
                
            }
        });

        frame.add(biletButton);
        frame.setLayout(null);  // Layout yöneticisi kullanılmayacak
        frame.setVisible(true);
    }

   

  
    public void showAdmin(JFrame parentFrame) {
        JDialog adminDialog = new JDialog(parentFrame, "Admin Girişi", true);
        adminDialog.setSize(300, 200);

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Giriş");

        adminDialog.setLayout(new GridLayout(4, 1));
        adminDialog.add(new JLabel("Kullanıcı Adı:"));
        adminDialog.add(usernameField);
        adminDialog.add(new JLabel("Şifre:"));
        adminDialog.add(passwordField);
        adminDialog.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();

                if (username.equals(ADMIN_USERNAME) && Arrays.equals(password, ADMIN_PASSWORD.toCharArray())) {
                    adminDialog.dispose();
                    admin=new Admin("admin","123");
                    admin.admingui();
                    
                    // Perform actions for successful admin login
                } else {
                    JOptionPane.showMessageDialog(parentFrame, "Geçersiz kullanıcı adı veya şifre", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        adminDialog.setVisible(true);
    }

 
    public void showSirket(JFrame parentFrame) {
        JDialog sirketdialog = new JDialog(parentFrame, "Şirket Girişi", true);
        sirketdialog.setSize(300, 200);

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Giriş");

        sirketdialog.setLayout(new GridLayout(4, 1));
        sirketdialog.add(new JLabel("Kullanıcı Adı:"));
        sirketdialog.add(usernameField);
        sirketdialog.add(new JLabel("Şifre:"));
        sirketdialog.add(passwordField);
        sirketdialog.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                String passwordString = String.valueOf(password);

               for (Company company : companylist) {
             if (company.getKullaniciAdi().equals(username) && company.getSifre().equals(passwordString)) {
              oldu_mu = true;
                sirketdialog.dispose();
                 currentCompany = new Company(username, passwordString);
                 currentCompany.companygui();
                  break;
                }
               }
                if(!oldu_mu) {
                    JOptionPane.showMessageDialog(parentFrame, "Geçersiz kullanıcı adı veya şifre", "Hata", JOptionPane.ERROR_MESSAGE);
                }
                oldu_mu=false;
            }
        });

        sirketdialog.setVisible(true);
    }

    @Override
    public void showAdmin() {
    }

    @Override
    public void showSirket() {
    }

    public boolean isOldu_mu() {
        return oldu_mu;
    }

    public void setOldu_mu(boolean oldu_mu) {
        this.oldu_mu = oldu_mu;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Company getCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(Company currentCompany) {
        this.currentCompany = currentCompany;
    }

    
    
    
}