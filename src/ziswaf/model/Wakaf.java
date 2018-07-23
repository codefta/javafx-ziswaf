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
 * @author Fathi
 */
public class Wakaf {
    private IntegerProperty no;
    private StringProperty jenisWakaf;
    private IntegerProperty targetWakaf;
    private StringProperty progressWakaf;
    
    public Wakaf(int no, String jenisWakaf, int targetWakaf, String progressWakaf){
        this.no = new SimpleIntegerProperty(1 +(1 + (int) (Math.random()* 254667)));
        this.jenisWakaf = new SimpleStringProperty(jenisWakaf);
        this.targetWakaf = new SimpleIntegerProperty(targetWakaf);
        this.progressWakaf = new SimpleStringProperty(progressWakaf);
    }
    
    public Wakaf(){
        this(0, "", 0, "");
    }
    public void setNo(int no){
        this.no.set(no);
    }
    
    public int getNo(){
        return this.no.get();
    }
    
    public IntegerProperty noProperty(){
        return no;
    }
    
    public void setJenisWakaf(String jenisWakaf){
        this.jenisWakaf.set(jenisWakaf);
    }
    
    public String getJenisWakaf(){
        return this.jenisWakaf.get();
    }
    
    public StringProperty jenisWakafProperty(){
        return jenisWakaf;
    }
    
    public void setTargetWakaf(int targetWakaf){
        this.targetWakaf.set(targetWakaf);
    }
    
    public int getTargetWakaf(){
        return this.targetWakaf.get();
    }
    
    public IntegerProperty targetWakafProperty(){
        return targetWakaf;
    }
    
    public void setProgressBar(String progressBar){
        this.progressWakaf.set(progressBar);
    }
    
    public String getProgressWakaf(){
        return this.progressWakaf.get();
    }
    
    public StringProperty progressWakafProperty(){
        return progressWakaf;
    }
    
    @Override
    public String toString(){
        return getJenisWakaf();
    }
}
