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
public class DoanhThu{
    public String thang;
    public String masnv;
    public long doanhthu;
    Scanner dt=new Scanner(System.in);
    
    public DoanhThu(){
        this.thang=null;
        this.masnv=null;
        this.doanhthu=0;
    }
    
    public DoanhThu(String thang,String masnv,long doanhthu){
        this.thang=thang;
        this.masnv=masnv;
        this.doanhthu=doanhthu;
    }

    public void setMasnv(String masnv) {
        this.masnv = masnv;
    }
    
    public void setThang(){
        String thangmoi;
        thangmoi=dt.nextLine();
        this.thang=thangmoi;
    }

    public void setDoanhthu(long doanhthu){
        this.doanhthu=doanhthu;
    }

    public String getThang(){
        return thang;
    }

    public long getDoanhthu(){
        return doanhthu;
    }
    
    public void NhapDT()throws IOException{        
    }
    public void XuatDT(){
    }
}
