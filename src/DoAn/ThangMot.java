/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn;

import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

/**
 *
 * @author HieuPhan
 */

public class ThangMot extends DoanhThu{
    DecimalFormat format=new DecimalFormat("###,###,###,### VND");
    Scanner tm=new Scanner(System.in);
    @Override
    public void setThang(){
        this.thang="Thang mot";
    }
    
    @Override
    public void NhapDT() throws IOException{
        DanhSachNhanVien dsnv=new DanhSachNhanVien();
        dsnv.docfile();
        DanhSachBaoHanh dsbh=new DanhSachBaoHanh();
        dsbh.docfile();
        DanhSachHoaDonNhap dshdn=new DanhSachHoaDonNhap();
        dshdn.docfile();
        DanhSachHoaDonXuat dshdx=new DanhSachHoaDonXuat();
        dshdx.docfile();
        setThang();
        setMasnv("311101");
        String thang="1";
        String nam="2020";
        doanhthu=dshdx.Laytien(thang, nam)+dsbh.Laytien(thang, nam)-dshdn.Laytien(thang, nam);
    }
    
    @Override
    public void XuatDT(){
        System.out.printf("%-15s%-15s%-25s\n",thang,masnv,format.format(doanhthu));
    }
    
    public static void main(String[] args) throws IOException{
        ThangMot tmot=new ThangMot();
        tmot.NhapDT();
        tmot.XuatDT();
    }
}
