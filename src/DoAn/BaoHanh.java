/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author HieuPhan
 */
public class BaoHanh {
    CheckLoi cl=new CheckLoi();
    public String mabaohanh;
    public String masnv;
    public String makh;
    public String thang;
    public String nam;
    public long thanhtien;
    public static int dembh=100;
    DecimalFormat format=new DecimalFormat("###,###,### VND");
    Scanner nhapbh=new Scanner(System.in);
    
    public BaoHanh(){
        this.mabaohanh=null;
        this.masnv=null;
        this.makh=null;
        this.thang=null;
        this.nam=null;
        this.thanhtien=0;
        dembh++;
    }
    
    public BaoHanh(String mabaohanh,String masnv,String makh,String thang,String nam,long thanhtien){
        this.mabaohanh=mabaohanh;
        this.masnv=masnv;
        this.makh=makh;
        this.thang=thang;
        this.nam=nam;
        this.thanhtien=thanhtien;
        dembh++;
    }

    public void setMabaohanh(String mabaohanh){
        this.mabaohanh=mabaohanh;
    }

    public void setMasnv(String masnv){
        this.masnv=masnv;
    }

    public void setMakh(String makh){
        this.makh=makh;
    }

    public void setThang(String thang){
        this.thang=thang;
    }
    
    public void setNam(String nam){
        this.nam=nam;
    }

    public void setThanhtien(long thanhtien){
        this.thanhtien=thanhtien;
    }

    public String getMabaohanh(){
        return mabaohanh;
    }

    public String getMasnv(){
        return masnv;
    }

    public String getMakh(){
        return makh;
    }

    public String getThang(){
        return thang;
    }
    
    public String getNam(){
        return nam;
    }

    public long getThanhtien(){
        return thanhtien;
    }
    
    public void NhapBh() throws IOException{
        DanhSachNhanVien dsnv=new DanhSachNhanVien();
        dsnv.docfile();
        DanhSachKhachHang dskh=new DanhSachKhachHang();
        dskh.docfile();
        System.out.println("Nhap thong tin bao hanh: ");
        mabaohanh="BH"+String.valueOf(dembh);
        System.out.print("Nhap ma nhan vien sua chua: ");
        while(true){
            masnv=cl.kiemTraMaNv();
            if(dsnv.kiemTraManv(masnv)==true){
                if(dsnv.kiemTraChucvuSuachua(masnv)==true)
                    break;
                else{
                    System.out.println("Day khong phai ma cua nhan vien sua chua");
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
                break;
            }
            else{
                System.out.println("Ma khach hang khong co trong danh sach khach hang");
                System.out.print("Nhap lai ma khach hang: ");
            }
        }
        System.out.print("Nhap thang sua chua: ");
        thang=cl.kiemTraThang();
        System.out.print("Nhap nam sua chua: ");
        nam=cl.kiemTraNam();
        System.out.print("Nhap tong tien sua chua: ");
        thanhtien=Long.parseLong(cl.kiemTraTien());
    }
    
    public void XuatBh(){
        System.out.printf("%-15s%-15s%-15s%-2s%-1s%-10s%-15s\n",mabaohanh,masnv,makh,thang,"/",nam,format.format(thanhtien));
    }
    
    public void ghifile() throws IOException{
        try { 
            FileOutputStream fos = new FileOutputStream("BaoHanh.dat",true);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF(mabaohanh);
            dos.writeUTF(masnv);
            dos.writeUTF(makh);
            dos.writeUTF(thang);
            dos.writeUTF(nam);
            dos.writeLong(thanhtien);
            dos.close();
            fos.close();
       	} 
        catch (FileNotFoundException e) {
                e.printStackTrace();
        }
    }
}
