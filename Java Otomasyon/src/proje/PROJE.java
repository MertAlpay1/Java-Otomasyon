package proje;

public class PROJE {

    
    public static void main(String[] args) {

   
     Admin.initializeDataAdmin();
     Company.initializeDataCompany();
     Customer.initializeDataCustomer();
     
    
     
     //New Loginimpl gerek 
     ILoginable login = new LoginImpl();
     login.createAndShowGUI();
     
      
    }             
}
