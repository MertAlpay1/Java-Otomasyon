
package proje;

public class Trip {
    
  public Vehicle vehicle;
  public Gidişat gidişat;
  public int zaman;
  public int[] mesafe;
  public int[] fiyat;

    public Trip(Vehicle vehicle, Gidişat gidişat, int zaman) {
        this.vehicle = vehicle;
        this.gidişat = gidişat;
        this.zaman = zaman;
        Mesafeayar();
        Fiyatayar();
    }

    public int getZaman() {
        return zaman;
    }

    //Doğru çizgisi olarak düşündüm 
    public void Mesafeayar(){
           
    mesafe = new int[gidişat.getGüzergah().length];
        
    for(int i = 0;i<gidişat.getGüzergah().length;i++){
    
     if(null == vehicle.route.getTür()){
                  
         System.out.println("Tür bulunamadi");
         break;
     }  
     else switch (vehicle.route.getTür()) {
         
            case "otobus":
                
                if("istanbul".equals(gidişat.getGüzergah()[i]))
                    mesafe[i]=0;
                if("kocaeli".equals(gidişat.getGüzergah()[i]))
                    mesafe[i]=100;
                 if("ankara".equals(gidişat.getGüzergah()[i]))
                    mesafe[i]=500;
                 if("eskisehir".equals(gidişat.getGüzergah()[i]))
                    mesafe[i]=300;
                 if("konya".equals(gidişat.getGüzergah()[i]))
                    mesafe[i]=600;
               
                break;
               
            case "tren":
                 if("istanbul".equals(gidişat.getGüzergah()[i]))
                    mesafe[i]=0;
                 if("kocaeli".equals(gidişat.getGüzergah()[i]))
                    mesafe[i]=75;
                 if("bilecik".equals(gidişat.getGüzergah()[i]))
                    mesafe[i]=225;
                 if("ankara".equals(gidişat.getGüzergah()[i]))
                    mesafe[i]=375;
                 if("eskisehir".equals(gidişat.getGüzergah()[i]))
                    mesafe[i]=300;
                 if("konya".equals(gidişat.getGüzergah()[i]))
                    mesafe[i]=450;
                 
                break;
                
                
                   
            default:
                 if("istanbul".equals(gidişat.getGüzergah()[i]))
                    mesafe[i]=0;
                  if("ankara".equals(gidişat.getGüzergah()[i]))
                    mesafe[i]=250;
                 if("konya".equals(gidişat.getGüzergah()[i]))
                    mesafe[i]=300;
                  
                break;
        }
}
  
    }
    
    public void Fiyatayar(){
        
         fiyat = new int[mesafe.length/2];
        
        for(int i=0;i<mesafe.length/2;i++){
         
        
            if(null == mesafe){
                  
         System.out.println("Mesafe  bulunamadi");
         break;
     } 
            
           else switch (vehicle.route.getTür()) {
         
            case "otobus":
                
                 
                  fiyat[i] = calculateOtobusFiyat(mesafe[i], mesafe[i+1]);
               
            break;
               
            case "tren":
                   fiyat[i] = calculateTrenFiyat(mesafe[i], mesafe[i+1]);
                 
             break;
             //ucak      
            default:
                
               fiyat[i] = calculateUcakFiyat(mesafe[i], mesafe[i+1]);
                
                  
                break;
       }             
     }     
   }
    
    
 
    
    
private int calculateOtobusFiyat(int mesafe1, int mesafe2) {
    
    return Math.abs(mesafe1 - mesafe2) / 2;
}

private int calculateTrenFiyat(int mesafe1, int mesafe2) {
   
    return (int) (Math.abs(mesafe1 - mesafe2) * (2.0 / 3.0));
}

private int calculateUcakFiyat(int mesafe1, int mesafe2) {
    
    return Math.abs(mesafe1 - mesafe2) * 4;
}

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Gidişat getGidişat() {
        return gidişat;
    }

    public void setGidişat(Gidişat gidişat) {
        this.gidişat = gidişat;
    }

    public int[] getMesafe() {
        return mesafe;
    }

    public void setMesafe(int[] mesafe) {
        this.mesafe = mesafe;
    }

    public int[] getFiyat() {
        return fiyat;
    }

    public void setFiyat(int[] fiyat) {
        this.fiyat = fiyat;
    }
    
    
  
  

  
  
}
