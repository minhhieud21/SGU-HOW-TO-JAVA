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
public class HoaDonNhap extends HoaDon{
    CheckLoi cl=new CheckLoi();
    public String manhom;
    public String manpp;
    public long gianhap;
    public static int hdn=400;
    DecimalFormat format=new DecimalFormat("###,###,###,### VND");
    Scanner nhaphdn=new Scanner(System.in);
    
    public HoaDonNhap(){
        this.mahd=null;
        this.masnv=null;
        this.manpp=null;
        this.manhom=null;
        this.maxe=null;
        this.thang=null;
        this.nam=null;
        this.soluong=0;
        this.gianhap=0;
        this.tongtien=0;
        hdn++;
    }
    
    public HoaDonNhap(String mahd,String masnv,String manpp,String manhom,String maxe,String thang,String nam,int soluong,long gianhap,long tongtien){
        this.mahd=mahd;
        this.masnv=masnv;
        this.manpp=manpp;
        this.manhom=manhom;
        this.maxe=maxe;
        this.thang=thang;
        this.nam=nam;
        this.soluong=soluong;
        this.gianhap=gianhap;
        this.tongtien=tongtien;
        hdn++;
    }

    public void setManhom(String manhom){
        this.manhom=manhom;
    }

    public void setManpp(String manpp){
        this.manpp=manpp;
    }

    public void setGianhap(long gianhap){
        this.gianhap=gianhap;
    }

    public String getManhom() {
        return manhom;
    }

    public String getManpp() {
        return manpp;
    }

    public long getGianhap() {
        return gianhap;
    }
    
    @Override
    public void setTongtien(){
        this.tongtien=soluong*gianhap;
    }
  
    @Override
    public void NhapHd() throws IOException{
        DanhSachNhanVien dsnv=new DanhSachNhanVien();
        dsnv.docfile();
        DanhSachThongTinXe dsttx=new DanhSachThongTinXe();
        dsttx.docfile();
        DanhSachNhaPhanPhoi dsnpp=new DanhSachNhaPhanPhoi();
        dsnpp.docfile();
        System.out.println("Nhap thong tin hoa don nhap");
        mahd="HDN"+String.valueOf(hdn);
        System.out.print("Nhap ma nhan vien: ");
        while(true){
            masnv=cl.kiemTraMaNv();
            if(dsnv.kiemTraManv(masnv)==true){
                if(dsnv.kiemTraChucvuQuanLy(masnv)==true)
                    break;
                else{
                    System.out.println("Day khong phai ma cua nhan vien quan ly");
                    System.out.print("Nhap lai ma nhan vien: ");        
                }
            }
            else{
                System.out.println("Ma nhan vien khong co trong danh sach nhan vien");
                System.out.print("Nhap lai ma nhan vien: ");
            }
        }
        System.out.print("Nhap ma nha phan phoi: ");
        while(true){
            manpp=cl.kiemTraManpp();
            if(dsnpp.kiemTraMnpp(manpp)==true){
                break;
            }
            else{
                System.out.println("Ma nha phan phoi khong co trong danh sach nha phan phoi");
                System.out.print("Nhap lai ma nha phan phoi: ");
            }
        }
        System.out.print("Nhap ma nhom xe: ");
        while(true){
            manhom=cl.kiemTraManhom();
            if(dsttx.kiemTraManhom(manhom)==true){
                break;
            }
            else{
                System.out.println("Ma nhom khong co trong danh sach thong tin xe");
                System.out.print("Nhap lai ma nhom xe: ");
            }
        }
        System.out.print("Nhap ma xe: ");
        maxe=cl.kiemTraMaxe();
        System.out.print("Nhap thang nhap xe: ");
        thang=cl.kiemTraThang();
        System.out.print("Nhap nam nhap xe: ");
        nam=cl.kiemTraNam();
        System.out.print("Nhap so luong nhap: ");
        soluong=cl.kiemTraSoLuong();
        gianhap=dsttx.Laygianhap(manhom);
        setTongtien();
    }
    
    @Override
    public void XuatHd(){
        System.out.printf("%-15s%-15s%-15s%-10s%-10s%-2s%-1s%-10s%-15s%-20s%-20s\n",mahd,masnv,manpp,manhom,maxe,thang,"/",nam,soluong,format.format(gianhap),format.format(tongtien));
    }
    
    public void ghifile() throws IOException{
        try { 
            FileOutputStream fos = new FileOutputStream("HoaDonNhap.dat",true);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF(mahd);
            dos.writeUTF(masnv);
            dos.writeUTF(manpp);
            dos.writeUTF(manhom);
            dos.writeUTF(maxe);
            dos.writeUTF(thang);
            dos.writeUTF(nam);
            dos.writeInt(soluong);
            dos.writeLong(gianhap);
            dos.writeLong(tongtien);
            dos.close();
            fos.close();
        } 
        catch (FileNotFoundException e) {
                e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws IOException{
        HoaDonNhap hdn=new HoaDonNhap();
        hdn.NhapHd();
        hdn.XuatHd();
    }
}
