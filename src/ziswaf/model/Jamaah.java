/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziswaf.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Intel
 */

public class Jamaah{
    private IntegerProperty idJamaah;
    private StringProperty namaJamaah;
    private StringProperty alamatJamaah;
    private StringProperty statusJamaah;
    
    public Jamaah(int idJamaah, String namaJamaah, String alamatJamaah, String statusJamaah ){
        this.idJamaah = new SimpleIntegerProperty(17523 +(0 + (int) (Math.random() * 1000)));
        this.namaJamaah = new SimpleStringProperty(namaJamaah);
        this.alamatJamaah = new SimpleStringProperty(alamatJamaah);
        this.statusJamaah = new SimpleStringProperty(statusJamaah);
    }
    public Jamaah(){
        this(0, "", "", "");
    }
    
    public void setIdJamaah(Integer id){
        this.idJamaah.set(id);
    }
    
    public Integer getIdJamaah(){
        return this.idJamaah.get();
    }
    
    public IntegerProperty idJamaahProperty(){
        return idJamaah;
    }
    
    public void setNamaJamaah(String nama){
        this.namaJamaah.set(nama);
    }
    
    public String getNamaJamaah(){
        return this.namaJamaah.get();
    }
    
    public StringProperty namaJamaahProperty(){
        return namaJamaah;
    }
    
    public void setAlamatJamaah(String alamat){
        this.alamatJamaah.set(alamat);
    }
    
    public String getAlamatJamaah(){
        return this.alamatJamaah.get();
    }
    
    public StringProperty alamatJamaahProperty(){
        return alamatJamaah;
    }
    
    public void setStatusJamaah(String status){
        this.statusJamaah.set(status);
    }
    
    public String getStatusJamaah(){
        return this.statusJamaah.get();
    }
    
    public StringProperty statusJamaahProperty(){
        return statusJamaah;
    }
    
    @Override
    public String toString(){
        return /*getIdJamaah() + " - " + */getNamaJamaah();
    }
}
/*public class Jamaah {
    private IntegerProperty idJamaah;
    private StringProperty nama;
    private StringProperty alamat;
    private StringProperty status;
    
    public Jamaah(int idJamaah, String nama, String alamat, String status){
        this.idJamaah = new SimpleIntegerProperty(idJamaah);//(2280000 +(0 + (int) (Math.random() * 1000)));
        this.nama = new SimpleStringProperty(nama);
        this.alamat = new SimpleStringProperty(alamat);
        this.status = new SimpleStringProperty(status);
    }
    
    public Jamaah(){
        this(0,"","","");
    }
       
    public void setNama(String nama){
        this.nama.set(nama);
    }
    
    public StringProperty getNamaProperty(){
        return nama;
    }
    
    public String getNama(){
        return this.nama.get();
        
    } 
   
    public String getAlamat(){
        return this.alamat.get();
    }
    
    public void setAlamat(String alamat){
        this.alamat.set(alamat);
    }
    
    public StringProperty alamatProperty(){
        return alamat;
    }
    
  /*  public String getAlamat2(){
        return alamat.get();
    } */
    /*
    public int getIdJamaah(){
        return this.idJamaah.get();
    }
    
    public IntegerProperty getIdJamaahProperty(){
        return idJamaah;
    }
    
    public void setIdJamaah(Integer id){
        this.idJamaah.set(id);
    } */
   
    /* public void setIdJamaah(){
        if (idJamaah == null) {
            idJamaah.set(2280000+(0 + (int) (Math.random() * 1000)));
        }else{
            idJamaah.get();
        }
    } */

  /*
    public void setStatus(String status){
        this.status.set(status);
    }
    
    public String getStatus(){
        return this.status.get();
    }
    
    public StringProperty statusProperty(){
        return status;
    }
    */
    /*public String getStatus2(){
        return status.get();
    }

    public void getNamaJamaah() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 

   
    
}
    */

