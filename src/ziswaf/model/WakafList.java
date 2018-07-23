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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Fathi
 */
public class WakafList {
    private ObservableList<Wakaf> daftarWakaf;
    private String extFile;
    
    public WakafList(){
        daftarWakaf = FXCollections.observableArrayList();
        extFile = "Wakaf.xml";
    }
    
    public ObservableList<Wakaf> get(){
        return daftarWakaf;
    }
    
    public void setFromArray(SimpleWakaf[] array){
        daftarWakaf = FXCollections.observableArrayList();
        
        for(SimpleWakaf k: array){
            daftarWakaf.add(new Wakaf(k.getNo(), k.getJenisWakaf(), k.getTargetWakaf(), k.getProgressWakaf()));
        }
    }
    
    public void loadXMLFile(){
        try{
            XStream xs = new XStream(new StaxDriver());
            FileInputStream in = new FileInputStream(extFile);
            String s = "";
            int c = in.read();
            while (c != -1) {
                s += (char) c;
                c = in.read();
            }
            
            SimpleWakaf[]array = (SimpleWakaf[]) xs.fromXML(s);
            this.setFromArray(array);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public SimpleWakaf[] getArray(){
        SimpleWakaf[] array = new SimpleWakaf[daftarWakaf.size()];
        for (int i= 0; i < daftarWakaf.size(); i++){
            int no = daftarWakaf.get(i).getNo();
            String jenisWakaf = daftarWakaf.get(i).getJenisWakaf();
            int targetWakaf = daftarWakaf.get(i).getTargetWakaf();
            String progressWakaf = daftarWakaf.get(i).getProgressWakaf();
            array[i] = new SimpleWakaf(no, jenisWakaf, targetWakaf, progressWakaf);
        }
        return array;
    }
    
    public void saveXMLFile(){
        SimpleWakaf[] array = this.getArray();
        XStream xs = new XStream(new StaxDriver());
        String xml = xs.toXML(array);
        
        try{
            FileOutputStream out = new FileOutputStream(extFile);
            byte[] bytes = xml.getBytes("UTF-8");
            out.write(bytes);
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
