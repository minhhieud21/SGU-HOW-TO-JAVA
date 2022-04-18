/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn;

import java.io.IOException;

/**
 *
 * @author HieuPhan
 */
public class MenuDoanhThu{
    DoanhThu tmot=new ThangMot();
    DoanhThu thai=new ThangHai();
    DoanhThu tba=new ThangBa();
    public void Xuat() throws IOException{
        System.out.printf("%-15s%-15s%-25s\n","Thang","Nhan vien","Doanh thu");
        tmot.NhapDT();
        tmot.XuatDT();
        thai.NhapDT();
        thai.XuatDT();
        tba.NhapDT();
        tba.XuatDT();
    }
    public static void main(String[] args) throws IOException{
        MenuDoanhThu a=new MenuDoanhThu();
        a.Xuat();
    }
}
