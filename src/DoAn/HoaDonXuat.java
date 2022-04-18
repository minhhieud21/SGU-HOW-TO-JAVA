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
public class HoaDonXuat extends HoaDon{
    CheckLoi cl=new CheckLoi();
    public String makh;
    public long giaban;
    public static int hdx=600;
    DecimalFormat format=new DecimalFormat("###,###,###,### VND");
    Scanner nhaphdx=new Scanner(System.in);
    
    public HoaDonXuat(){
        this.mahd=null;
        this.masnv=null;
        this.makh=null;
        this.maxe=null;
        this.thang=null;
        this.nam=null;
        this.soluong=0;
        this.giaban=0;
        this.tongtien=0;
        hdx++;
    }
    
    public HoaDonXuat(String mahd,String masnv,String makh,String maxe,String thang,String nam,int soluong,long giaban,long tongtien){
        this.mahd=mahd;
        this.masnv=masnv;
        this.makh=makh;
        this.maxe=maxe;
        this.thang=thang;
        this.nam=nam;
        this.soluong=soluong;
        this.giaban=giaban;
        this.tongtien=tongtien;
        hdx++;
    }

    public void setMakh(String makh){
        this.makh=makh;
    }

    public void setGiaban(long giaban){
        this.giaban=giaban;
    }

    public String getMakh(){
        return makh;
    }

    public int getSoluong(){
        return soluong;
    }

    public long getGiaban(){
        return giaban;
    }
    
    @Override
    public void setTongtien(){
        this.tongtien=soluong*giaban;
    }
    
    @Override
    public void NhapHd() throws IOException{
        DanhSachNhanVien dsnv=new DanhSachNhanVien();
        dsnv.docfile();
        DanhSachXe dsx=new DanhSachXe();
        dsx.docfile();
        DanhSachKhachHang dskh=new DanhSachKhachHang();
        dskh.docfile();
        System.out.println("Nhap thong tin hoa don xuat");
        mahd="HDX"+String.valueOf(hdx);
        System.out.print("Nhap ma nhan vien: ");
        while(true){
            masnv=cl.kiemTraMaNv();
            if(dsnv.kiemTraManv(masnv)==true){
                if(dsnv.kiemTraChucvuBanHang(masnv)==true)
                    break;
                else{
                    System.out.println("Day khong phai ma cua nhan vien ban hang");
                    System.out.print("Nhap lai ma nhan vien: ");        
                }
            }
            else{
                System.out.println("Ma nhan vien khong co trong danh sach nhan vien");
                System.out.print("Nhap lai ma nhan vien: ");
            }
        }
        System.out.print("Nhap ma khach hang: ");
        while(true){
            makh=cl.kiemTraMaKh();
            if(dskh.kiemTraMaKh(makh)==true){
                if(dskh.kiemTraMuaxe(makh)==true)
                    break;
                else{
                    System.out.println("Day khong phai ma cua khach hang mua xe");
                    System.out.print("Nhap lai ma khach hang: ");     
                }
            }
            else{
                System.out.println("Ma khach hang khong co trong danh sach khach hang");
                System.out.print("Nhap lai ma khach hang: ");
            }
        }
        System.out.print("Nhap ma xe: ");
        while(true){
            maxe=cl.kiemTraMaxe();
            if(dsx.kiemTraMaxe(maxe)==true){
                break;
            }
            else{
                System.out.println("Ma xe khong co trong danh sach xe");
                System.out.print("Nhap lai ma xe: ");
            }
        }
        System.out.print("Nhap thang ban xe: ");
        thang=cl.kiemTraThang();
        System.out.print("Nhap nam ban xe: ");
        nam=cl.kiemTraNam();
        System.out.print("Nhap so luong xe ban: ");
        while(true){
            soluong=cl.kiemTraSoLuong();
            if(soluong<dsx.Laysoluong(maxe))
                break;
            else{
                System.out.println("So luong xe trong danh xe khong du");
                System.out.print("Nhap lai so luong xe ban: ");
            }
        }
        giaban=dsx.Laygiaban(maxe);
        setTongtien();
    }
    
    @Override
    public void XuatHd(){
        System.out.printf("%-15s%-15s%-15s%-15s%-2s%-1s%-10s%-15s%-20s%-20s\n",mahd,masnv,makh,maxe,thang,"/",nam,soluong,format.format(giaban),format.format(tongtien));
    }
    
    public void ghifile() throws IOException{
        try { 
            FileOutputStream fos = new FileOutputStream("HoaDonXuat.dat",true);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF(mahd);
            dos.writeUTF(masnv);
            dos.writeUTF(makh);
            dos.writeUTF(maxe);
            dos.writeUTF(thang);
            dos.writeUTF(nam);
            dos.writeInt(soluong);
            dos.writeLong(giaban);
            dos.writeLong(tongtien);
            dos.close();
            fos.close();
        } 
        catch (FileNotFoundException e) {
                e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws IOException{
        HoaDonXuat hdx=new HoaDonXuat();
        hdx.NhapHd();
        hdx.XuatHd();
    }
}
