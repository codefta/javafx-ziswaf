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
public class SimpleWakaf {
    private int no;
    private String jenisWakaf;
    private int targetWakaf;
    private String progressWakaf;

    public SimpleWakaf(int no, String jenisWakaf, int targetWakaf, String progressWakaf) {
        this.no = no;
        this.jenisWakaf = jenisWakaf;
        this.targetWakaf = targetWakaf;
        this.progressWakaf = progressWakaf;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
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
    
}
