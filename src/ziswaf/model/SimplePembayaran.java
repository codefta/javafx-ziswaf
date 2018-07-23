/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziswaf.model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Fathi
 */
public class SimplePembayaran {
    //Data Jamaah
    private int idJamaah;
    private String namaJamaah;
    private String alamatJamaah;
    private String statusJamaah;
    //Data Wakaf
    private int noWakaf;
    private String jenisWakaf;
    private int targetWakaf;
    private String progressWakaf;
    
    private int nominal;
    private LocalDate waktuTransaksi;
    private int jumlah;
    public SimplePembayaran(int idJamaah, String namaJamaah, String alamatJamaah, String statusJamaah, int noWakaf, String jenisWakaf, int targetWakaf, String progressWakaf, int nominal, LocalDate waktuTransaksi) {
        this.idJamaah = idJamaah;
        this.namaJamaah = namaJamaah;
        this.alamatJamaah = alamatJamaah;
        this.statusJamaah = statusJamaah;
        this.noWakaf = noWakaf;
        this.jenisWakaf = jenisWakaf;
        this.targetWakaf = targetWakaf;
        this.progressWakaf = progressWakaf;
        this.nominal = nominal;
        this.waktuTransaksi = waktuTransaksi;
    }
    
    public int getIdJamaah() {
        return idJamaah;
    }

    public void setIdJamaah(int idJamaah) {
        this.idJamaah = idJamaah;
    }

    public String getNamaJamaah() {
        return namaJamaah;
    }

    public void setNamaJamaah(String namaJamaah) {
        this.namaJamaah = namaJamaah;
    }

    public String getAlamatJamaah() {
        return alamatJamaah;
    }

    public void setAlamatJamaah(String alamatJamaah) {
        this.alamatJamaah = alamatJamaah;
    }

    public String getStatusJamaah() {
        return statusJamaah;
    }

    public void setStatusJamaah(String statusJamaah) {
        this.statusJamaah = statusJamaah;
    }

    public int getNoWakaf() {
        return noWakaf;
    }

    public void setNoWakaf(int noWakaf) {
        this.noWakaf = noWakaf;
    }

    public String getJenisWakaf() {
        return jenisWakaf;
    }

    public void setJenisWakaf(String jenisWakaf) {
        this.jenisWakaf = jenisWakaf;
    }

    public int getTargetWakaf() {
        return targetWakaf;
    }

    public void setTargetWakaf(int targetWakaf) {
        this.targetWakaf = targetWakaf;
    }

    public String getProgressWakaf() {
        return progressWakaf;
    }

    public void setProgressWakaf(String progressWakaf) {
        this.progressWakaf = progressWakaf;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public LocalDate getWaktuTransaksi() {
        return waktuTransaksi;
    }

    public void setWaktuTransaksi(LocalDate waktuTransaksi) {
        this.waktuTransaksi = waktuTransaksi;
    }
    
}
