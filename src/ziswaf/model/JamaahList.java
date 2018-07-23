/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziswaf.model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Intel
 */
public class JamaahList {
    private ObservableList<Jamaah> list;
    private String extFile;
    
    public JamaahList(){
        list  = FXCollections.observableArrayList();
        extFile= "Jamaah.xml";
    }
    
    public ObservableList<Jamaah> get(){
        return list;
    }
    
    public void setFromArray(SimpleJamaah[] array){
        list = FXCollections.observableArrayList();
        for(SimpleJamaah k: array){
            list.add(new Jamaah(k.getId(), k.getNama(), k.getAlamat(), k.getStatus()));
        }
    }
    
    public void loadXMLFile(){
        try{
            XStream xs = new XStream(new StaxDriver());
            FileInputStream in = new FileInputStream(extFile);
            String s = "";
            int c = in.read();
            while (c != -1){ 
                s += (char) c;
                c = in.read();
            }
            
            SimpleJamaah[] array = (SimpleJamaah[]) xs.fromXML(s);
            this.setFromArray(array);
        } catch(Exception e){
            e.printStackTrace();
        } 
    }
    
    public SimpleJamaah[] getArray(){
        SimpleJamaah[] array = new SimpleJamaah[list.size()];
        for (int i = 0; i<list.size(); i++){
            int idJamaah = list.get(i).getIdJamaah();
            String namaJamaah = list.get(i).getNamaJamaah();
            String alamatJamaah = list.get(i).getAlamatJamaah();
            String statusJamaah = list.get(i).getStatusJamaah();
            array[i] = new SimpleJamaah(idJamaah, namaJamaah, alamatJamaah, statusJamaah);
        }
        return array;
    }
    
    public void saveXMLFile(){
        SimpleJamaah[] array = this.getArray();
        XStream xs = new XStream(new StaxDriver());
        String xml = xs.toXML(array);
        
        try{
            FileOutputStream out = new FileOutputStream(extFile);
            byte[] bytes = xml.getBytes("UTF-8");
            out.write(bytes);
            out.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}



