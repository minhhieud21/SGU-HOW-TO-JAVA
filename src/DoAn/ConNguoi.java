/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author HieuPhan
 */
public class ConNguoi{
    public String hoten;
    public String cmnd;
    public String gioitinh;
    public String diachi;
    public String quequan;
    public String sdt;
    Scanner nhap = new Scanner(System.in);
    
    public ConNguoi(){
        this.hoten=null;
        this.cmnd=null;
        this.gioitinh=null;
        this.diachi=null;
        this.quequan=null;
        this.sdt=null;
    }

    public ConNguoi(String hoten,String cmnd,String gioitinh,String diachi,String quequan,String sdt){
        this.hoten=hoten;
        this.cmnd=cmnd;
        this.gioitinh=gioitinh;
        this.diachi=diachi;
        this.quequan=quequan;
        this.sdt=sdt;
    }

    public void setHoten(String hoten){
        this.hoten=hoten;
    }

    public void setCmnd(String cmnd){
        this.cmnd=cmnd;
    }

    public void setGioitinh(String gioitinh){
        this.gioitinh=gioitinh;
    }

    public void setDiachi(String diachi){
        this.diachi=diachi;
    }

    public void setQuequan(String quequan){
        this.quequan=quequan;
    }

    public void setSdt(String sdt){
        this.sdt=sdt;
    }

    public String getHoten(){
        return hoten;
    }

    public String getCmnd(){
        return cmnd;
    }

    public String getGioitinh(){
        return gioitinh;
    }

    public String getDiachi(){
        return diachi;
    }

    public String getQuequan(){
        return quequan;
    }

    public String getSdt(){
        return sdt;
    }
}
