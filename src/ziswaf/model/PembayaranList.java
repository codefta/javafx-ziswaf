/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziswaf.model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Fathi
 */
public class PembayaranList {
    private ObservableList<Pembayaran> daftarPembayaran;
    private String extFile;
    private int total;
    
    public PembayaranList(){
        daftarPembayaran = FXCollections.observableArrayList();
        extFile = "Pembayaran.xml";
    }

    public ObservableList<Pembayaran> get() {
        return daftarPembayaran;
        
    }    
    
    public int get2(){
        return total;
    }
    
    public void addData(Pembayaran pembayaran){
        daftarPembayaran.add(pembayaran);
    }
    
    public void setFromArray(SimplePembayaran[] array){
        daftarPembayaran = FXCollections.observableArrayList();
        
        for(SimplePembayaran p : array){
           Jamaah j  = new Jamaah(p.getIdJamaah(), p.getNamaJamaah(), p.getAlamatJamaah(), p.getStatusJamaah());
           Wakaf k = new Wakaf(p.getNoWakaf(), p.getJenisWakaf(), p.getTargetWakaf(), p.getProgressWakaf());
           daftarPembayaran.add(new Pembayaran(j, k, p.getNominal(), p.getWaktuTransaksi()));
        }
    }
    
    public void loadXMLFile(){
        try {
            XStream xs = new XStream(new StaxDriver());
            FileInputStream in = new FileInputStream(extFile);
            String s = "";
            int c = in.read();
            while(c != -1){
                s+= (char) c;
                c = in.read();
            }
            
            SimplePembayaran[] array = (SimplePembayaran[]) xs.fromXML(s);
            this.setFromArray(array);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public SimplePembayaran[] getArray(){
        SimplePembayaran[] array = new SimplePembayaran[daftarPembayaran.size()];
        for(int i = 0; i<daftarPembayaran.size(); i++){
            Pembayaran p = daftarPembayaran.get(i);
            int idJamaah = p.getJamaah().getIdJamaah();
            String namaJamaah = p.getJamaah().getNamaJamaah();
            String alamatJamaah = p.getJamaah().getAlamatJamaah();
            String statusJamaah = p.getJamaah().getStatusJamaah();
            int noWakaf = p.getWakaf().getNo();
            String jenisWakaf = p.getWakaf().getJenisWakaf();
            int targetWakaf = p.getWakaf().getTargetWakaf();
            String progressWakaf = p.getWakaf().getProgressWakaf();
            int nominal = p.getNominal();
            LocalDate waktuTransaksi = p.getWaktuTransaksi();            
            array[i] = new SimplePembayaran(idJamaah, namaJamaah, alamatJamaah, statusJamaah, noWakaf, jenisWakaf, targetWakaf, progressWakaf, nominal, waktuTransaksi);
        }
        return array;
    }
    
    public void saveXMLFile(){
        SimplePembayaran[] array = this.getArray();
        XStream xs = new XStream(new StaxDriver());
        String xml = xs.toXML(array);
        
        try{
            FileOutputStream out = new FileOutputStream(extFile);
            byte[] bytes = xml.getBytes("UTF-8");
            out.write(bytes);
            out.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
