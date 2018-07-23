/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziswaf.model;

import java.time.LocalDate;
import java.util.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Fathi
 */
public class Pembayaran {
    private ObjectProperty<Jamaah> jamaah;
    private ObjectProperty<Wakaf> wakaf;
    private IntegerProperty nominal;
    private ObjectProperty<LocalDate> waktuTransaksi;

    public Pembayaran(Jamaah jamaah, Wakaf wakaf, int nominal, LocalDate waktuTransaksi) {
        this.jamaah = new SimpleObjectProperty<Jamaah>(jamaah);
        this.wakaf = new SimpleObjectProperty<Wakaf>(wakaf);
        this.nominal = new SimpleIntegerProperty(nominal);
        this.waktuTransaksi = new SimpleObjectProperty<LocalDate>(waktuTransaksi);
    }
    
    public Jamaah getJamaah() {
        return jamaah.get();
    }

    public void setJamaah(Jamaah jamaah) {
        this.jamaah.set(jamaah);
    }
    
    public ObjectProperty<Jamaah> jamaahProperty(){
        return jamaah;
    }

    public Wakaf getWakaf() {
        return wakaf.get();
    }

    public void setWakaf(Wakaf wakaf) {
        this.wakaf.set(wakaf);
    }
    
    public ObjectProperty<Wakaf> wakafProperty(){
        return wakaf;
    }
    
    public IntegerProperty nominalProperty(){
        return nominal;
    }
    public Integer getNominal() {
        return this.nominal.get();
    }

    public void setNominal(Integer nominal) {
        this.nominal.set(nominal);
    }
    
    public LocalDate getWaktuTransaksi() {
        return waktuTransaksi.get();
    }

    public void setWaktuTransaksi(LocalDate waktuTransaksi) {
        this.waktuTransaksi.set(waktuTransaksi);
    }
    
    public ObjectProperty<LocalDate> waktuTransaksiProperty(){
        return waktuTransaksi;
    }
   
}
