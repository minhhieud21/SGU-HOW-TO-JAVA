/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author HieuPhan
 */
public abstract class HoaDon{
    public String mahd;
    public String masnv;
    public String maxe;
    public String thang;
    public String nam;
    public int soluong;
    public long tongtien;
    Scanner nhaphd=new Scanner(System.in);
    
    public HoaDon(){
        this.mahd=null;
        this.masnv=null;
        this.maxe=null;
        this.thang=null;
        this.nam=null;
        this.soluong=0;
        this.tongtien=0;
    }
    
    public HoaDon(String mahd,String masnv,String maxe,String thang,String nam,int soluong,long tongtien){
        this.mahd=mahd;
        this.masnv=masnv;
        this.maxe=maxe;
        this.thang=thang;
        this.nam=nam;
        this.soluong=soluong;
        this.tongtien=tongtien;
    }

    public void setMahd(String mahd){
        this.mahd=mahd;
    }

    public void setMasnv(String masnv){
        this.masnv=masnv;
    }

    public void setMaxe(String maxe){
        this.maxe=maxe;
    }

    public void setThang(String thang){
        this.thang=thang;
    }

    public void setNam(String nam){
        this.nam= nam;
    }
    
    public void setSoluong(int soluong){
        this.soluong=soluong;
    }

    public String getMahd(){
        return mahd;
    }

    public String getMasnv(){
        return masnv;
    }

    public String getMaxe(){
        return maxe;
    }

    public String getThang(){
        return thang;
    }

    public String getNam(){
        return nam;
    }

    public int getSoluong(){
        return soluong;
    }

    public long getTongtien(){
        return tongtien;
    }
    
    public abstract void setTongtien();
    public abstract void NhapHd() throws IOException;
    public abstract void XuatHd();
}
