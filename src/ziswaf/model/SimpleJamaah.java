/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziswaf.model;

/**
 *
 * @author Fathi
 */
public class SimpleJamaah {
    private int id;
    private String nama;
    private String alamat;
    private String status;
    
    public SimpleJamaah(int id, String nama, String alamat, String status){
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
