
package proje;


public class Route {
    public String kalkıs,varıs,tür,sefersayı;
    public int mesafe;

    public Route(String tür,String sefersayı,String kalkıs, String varıs, int mesafe) {
        this.sefersayı=sefersayı;
        this.tür = tür;
        this.kalkıs = kalkıs;
        this.varıs = varıs;
        this.mesafe = mesafe;
    }
       public Route(String tür, String sefersayı, String kalkıs, String varıs) {
        this.sefersayı = sefersayı;
        this.tür = tür;
        this.kalkıs = kalkıs;
        this.varıs = varıs;
       
    }
    

    public String getSefersayı() {
        
        return sefersayı;
    }

    public void setSefersayı(String sefersayı) {
        this.sefersayı = sefersayı;
    }
    

    public String getKalkıs() {
        return kalkıs;
    }

    public String getVarıs() {
        return varıs;
    }

    public String getTür() {
        return tür;
    }

    public int getMesafe() {
        return mesafe;
    }

    public void setMesafe(int mesafe) {
        this.mesafe = mesafe;
    }
    
    
    
    
    public int MesafeBul(String tür,String kalkıs,String varıs){
        int mesafe1=0;
        int mesafe2=0;
       switch(tür){
           case "otobus":
              
            mesafe1 = calculateOtobusMesafe(kalkıs);
            mesafe2 = calculateOtobusMesafe(varıs);               
        break;
           case"tren":
               
            mesafe1 = calculateTrenMesafe(kalkıs);
            mesafe2 = calculateTrenMesafe(varıs);                                         
             break;  
              case "ucak":
            mesafe1 = calculateUcakMesafe(kalkıs);
            mesafe2 = calculateUcakMesafe(varıs);
            break;
            
           default:
               
               
               System.out.println("Mesafe bul çalışmadı ");
               
               
           break;
    }
    
        int totalMesafe = Math.abs(mesafe1 - mesafe2);
    return totalMesafe;
    }  
  private int calculateOtobusMesafe(String city) {
 
    switch (city) {
        case "istanbul":
            return 0;
        case "kocaeli":
            return 100;
        case "ankara":
            return 500;
        case "eskisehir":
            return 300;
        case "konya":
            return 600;
        default:
            System.out.println("Mesafe bul çalışmadı1");
            return 0;
    }
}  
private int calculateTrenMesafe(String city) {
    switch (city) {
        case "istanbul":
            return 0;
        case "kocaeli":
            return 75;
        case "bilecik":
            return 225;
        case "ankara":
            return 375;
        case "eskisehir":
            return 300;
        case "konya":
            return 450;
        default:
            System.out.println("Mesafe bul çalışmadı2");
            return 0;
    }
}    
   private int calculateUcakMesafe(String city) {
    switch (city) {
        case "istanbul":
            return 0;
        case "ankara":
            return 250;
        case "konya":
            return 300;
        default:
            System.out.println("Mesafe bul çalışmadı3");
            return 0;
    }
    
    
    
    
} 

    public void setKalkıs(String kalkıs) {
        this.kalkıs = kalkıs;
    }

    public void setVarıs(String varıs) {
        this.varıs = varıs;
    }

    public void setTür(String tür) {
        this.tür = tür;
    }
    
    
    
}
