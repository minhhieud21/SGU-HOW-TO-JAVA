/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

/**
 *
 * @author HieuPhan
 */
public class NhanVien extends ConNguoi{
    CheckLoi cl=new CheckLoi();
    public String masnv;
    public String chucvu;
    public long luongcoban;
    public float heso;
    public long luong;
    public static int dem=311100;
    DecimalFormat format=new DecimalFormat("###,###,### VND");
    Scanner nhapnv=new Scanner(System.in);
	
    public NhanVien(){
	this.masnv=null;
        this.hoten=null;
	this.chucvu=null;
	this.luongcoban=0;
        this.heso=0.0f;
        this.luong=0;
        this.diachi=null;
        this.sdt=null;
        dem++;
    }

    public NhanVien(String masnv,String hoten,String chucvu,long luong,String diachi,String sdt){
        this.masnv=masnv;
        this.hoten=hoten;
        this.chucvu=chucvu;
        this.luong=luong;
        this.diachi=diachi;
        this.sdt=sdt;
        dem++;
    }

    public void setMasnv(String masnv){
        this.masnv=masnv;
    }

    public void setChucvu(String chucvu){
        this.chucvu=chucvu;
    }

    public void setLuongcoban(long luongcoban){
        this.luongcoban=luongcoban;
    }
    
    public void setHeso(float heso){
        this.heso=heso;
    }
    
    public void setLuong(){
        this.luong=(long)(luongcoban+(long)luongcoban*heso);
    }

    public String getMasnv(){
        return masnv;
    }

    public String getChucvu(){
        return chucvu;
    }
    
    public float getHeso(){
        return heso;
    }

    public long getLuongcoban(){
        return luongcoban;
    }
    
    public long getLuong(){
        return luong;
    }
    
    public void NhapNv(){
        System.out.println("Nhap thong tin nhan vien:");
        masnv=String.valueOf(dem);
        System.out.print("Nhap ho ten nhan vien: ");
        hoten=cl.kiemTraTenNv();
        System.out.println("Chon chuc vu cua nhan vien: ");
        System.out.println("\t1.Nhan vien quan ly");
        System.out.println("\t2.Nhan vien ban hang");
        System.out.println("\t3.Nhan vien sua chua");
        System.out.print("Chon: ");
        int chonchucvu=cl.kiemTraInt();
        while(chonchucvu>3 || chonchucvu<=0){
            System.out.println("Chon sai cu phap!!!");
            System.out.print("Chon lai chuc vu nhan vien: ");
            chonchucvu=cl.kiemTraInt();
        }
        switch(chonchucvu){
            case 1:
                System.out.println("Chuc vu cua nhan vien: Quan ly");
                chucvu="Quan ly";
                setHeso((float)0.5);
                setLuongcoban(10000000);
                setLuong();
                break;
            case 2:
                System.out.println("Chuc vu cua nhan vien: Ban hang");
                chucvu="Ban hang";
                setHeso((float)0.4);
                setLuongcoban(7000000);
                setLuong();
                break;
            case 3:
                System.out.println("Chuc vu cua nhan vien: Sua chua");
                chucvu="Sua chua";
                setHeso((float)0.2);
                setLuongcoban(7000000);
                setLuong();
                break;
        }
        System.out.print("Nhap dia chi nhan vien: ");
        diachi=nhapnv.nextLine();
        System.out.print("Nhap so dien thoai nhan vien: ");
        sdt=cl.kiemTraSdt();
    }
    
    public void XuatNv(){
        System.out.printf("%-15s%-25s%-15s%-20s%-15s%-15s\n",masnv,hoten,chucvu,format.format(luong),diachi,sdt);
    }
        
    public void ghifile() throws IOException{
        try { 
            FileOutputStream fos = new FileOutputStream("NhanVien.dat",true);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF(masnv);
            dos.writeUTF(hoten);
            dos.writeUTF(chucvu);
            dos.writeLong(luong);
            dos.writeUTF(diachi);
            dos.writeUTF(sdt);
            dos.close();
            fos.close();
       	} 
        catch (FileNotFoundException e) {
                e.printStackTrace();
        }
    }
}
