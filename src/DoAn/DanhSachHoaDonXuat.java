/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn;

import java.io.*;
import java.util.*;
import java.text.*;

/**
 *
 * @author HieuPhan
 */
public class DanhSachHoaDonXuat{
    CheckLoi cl=new CheckLoi();
    private int n;
    private HoaDonXuat[] Arrhdx = new HoaDonXuat[100];
    Scanner Nhapdshdn=new Scanner(System.in);
    
    public DanhSachHoaDonXuat(){
    }
    
    public DanhSachHoaDonXuat(HoaDonXuat[] Arrhdx,int n){
        this.Arrhdx=Arrhdx;
        this.n=n;
    }
    
    public DanhSachHoaDonXuat(DanhSachHoaDonXuat hoadonxuat){
        Arrhdx=hoadonxuat.Arrhdx;
        n=hoadonxuat.n;
    }
    
    public void NhapDanhSach()throws IOException{
        System.out.print("Nhap so luong hoa don nhap: ");
        n=cl.kiemTraSoLuong();
        Arrhdx= new HoaDonXuat[n];
        for(int i=0;i<n;i++){
            Arrhdx[i]=new HoaDonXuat();
            Arrhdx[i].NhapHd();
            Arrhdx[i].ghifile();
        }
    }
    
    public void XuatDanhSach()throws IOException{     
        System.out.println("Danh sach hoa don nhap: ");
        System.out.printf("%-15s%-15s%-15s%-15s%-13s%-15s%-20s%-20s\n","Ma hoa don","Ma nhan vien","Ma khach hang","Ma xe","Thang nam","So luong","Gia ban","Tong tien");
            for(int i=0;i<n;i++)
                Arrhdx[i].XuatHd();
    }
    
    public void Them() throws IOException{
        System.out.println("Nhap thong tin hoa don xuat can them : ");
        HoaDonXuat hdx = new HoaDonXuat();
        hdx.NhapHd();
        Arrhdx=Arrays.copyOf(Arrhdx,Arrhdx.length+1);
        Arrhdx[n]=hdx;
//        Arrhdx[n].ghifile();
        n++;
    }
    
    public void Themkphantu() throws IOException{
        System.out.print("Nhap so luong hoa don xuat can them: ");
        int k=cl.kiemTraSoLuong();
        for(int i=0;i<k;i++){
            int a=i+1;
            System.out.println("Hoa don xuat can them ("+a+"): ");
            Them();
        }
    }
    
    public void TimKiemMaHd(String mhdtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrhdx[i].getMahd().equals(mhdtim)==true){
                dem++;
                Arrhdx[i].XuatHd();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ma hoa don!!!");
    }
    
    public void TimKiemMaNv(String mnvtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrhdx[i].getMasnv().equals(mnvtim)==true){
                dem++;
                Arrhdx[i].XuatHd();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ma nhan vien!!!");
    }
    
    public void TimKiemMakh(String makhtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrhdx[i].getMakh().equals(makhtim)==true){
                dem++;
                Arrhdx[i].XuatHd();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ma khach hang!!!");
    }
    
    public void TimKiemMaxe(String mxetim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrhdx[i].getMaxe().equals(mxetim)==true){
                dem++;
                Arrhdx[i].XuatHd();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ma xe!!!");
    }
    
    public void TimKiemThang(String thangtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrhdx[i].getThang().equals(thangtim)==true){
                dem++;
                Arrhdx[i].XuatHd();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay hoa don xuat theo thang!!!");
    }
    
    public void TimKiemNam(String namtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrhdx[i].getNam().equals(namtim)==true){
                dem++;
                Arrhdx[i].XuatHd();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay hoa don xuat theo nam!!!");
    }
    
    public void TimKiemNamThang(String thangtim,String namtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrhdx[i].getNam().equals(namtim)==true){
                if(Arrhdx[i].getThang().equals(thangtim)==true){
                    dem++;
                    Arrhdx[i].XuatHd();
                }
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay hoa don theo thang nam!!!");
    }
    
    public int TimKiem(String ma){
        int vitri=-1;
        for(int i=0;i<n;i++)
            if(ma.compareTo(Arrhdx[i].getMahd())==0){
                vitri=i;
                break;
            }
        return vitri;
    }
    
    public void Xoa() throws IOException{
        System.out.print("Nhap ma hoa don xuat can xoa: ");
        String mahdxxoa=cl.kiemTraMaHdx();
        int vt=TimKiem(mahdxxoa);
        HoaDonXuat[] arrxoa=new HoaDonXuat[n];
        while(vt==-1){
            System.out.println("Khong tim thay ma hoa don xuat can xoa!!!");
            System.out.print("Nhap lai ma hoa don xuat can xoa: ");
            mahdxxoa=cl.kiemTraMaHdx();
            vt=TimKiem(mahdxxoa);
        }
        if(vt!=-1){
            arrxoa=Arrays.copyOf(Arrhdx,Arrhdx.length+1);
            for(int i=vt;i<n;i++)
                Arrhdx[i]=arrxoa[i+1];
            n--;
        }
        System.out.println("Xoa thanh cong thong tin hoa don xuat!!!");
    }
    
    public void Sua() throws IOException{
        boolean tieptuc=false;
        System.out.print("Nhap ma hoa don xuat can sua thong tin: ");
        String mahdxsua=cl.kiemTraMaHdx();
        int vt=TimKiem(mahdxsua);
        while(vt==-1){
            System.out.println("Khong tim thay ma hoa don xuat can sua!!!");
            System.out.print("Nhap lai ma hoa don xuat can sua: ");
            mahdxsua=cl.kiemTraMaHdx();
            vt=TimKiem(mahdxsua);
        }
        do{
            System.out.println("++++++SUA THONG TIN HOA DON XUAT++++++");
            System.out.println("1.Thay doi ma nhan vien");     
            System.out.println("2.Thay doi ma khach hang");
            System.out.println("3.Thay doi ma xe");
            System.out.println("4.Thay doi thang hoa don xuat");;
            System.out.println("5.Thay doi nam hoa don xuat");
            System.out.println("6.Thay doi so luong nhap");
            System.out.println("7.Tro lai danh sach bao hanh");
            System.out.print("Chon thong tin ban muon sua: ");
            int chonthaydoi=cl.kiemTraInt();
            while(chonthaydoi>7 || chonthaydoi<=0){
                System.out.println("Nhap sai cu phap!!!");
                System.out.println("==================================================");
                System.out.print("Chon lai thong tin ban muon sua: ");
                chonthaydoi=cl.kiemTraInt();
            }
            switch(chonthaydoi){
                case 1:
                    DanhSachNhanVien dsnv=new DanhSachNhanVien();
                    dsnv.docfile();
                    String masnvmoi;
                    System.out.print("Nhap lai ma nhan vien: ");
                    while(true){
                        masnvmoi=cl.kiemTraMaNv();
                        if(dsnv.kiemTraManv(masnvmoi)==true){
                            if(dsnv.kiemTraChucvuBanHang(masnvmoi)==true)
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
                    Arrhdx[vt].setMasnv(masnvmoi);
                    break;
                case 2:
                    DanhSachKhachHang dskh=new DanhSachKhachHang();
                    dskh.docfile();
                    String makhmoi;
                    System.out.print("Nhap ma khach hang: ");
                    while(true){
                        makhmoi=cl.kiemTraMaKh();
                        if(dskh.kiemTraMaKh(makhmoi)==true){
                            if(dskh.kiemTraMuaxe(makhmoi)==true)
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
                    Arrhdx[vt].setMakh(makhmoi);
                    break;
                case 3:
                    DanhSachXe dsx=new DanhSachXe();
                    dsx.docfile();
                    String maxemoi;
                    long giabanmoi;
                    System.out.print("Nhap lai ma nhom xe: ");
                    while(true){
                        maxemoi=cl.kiemTraMaxe();
                        if(dsx.kiemTraMaxe(maxemoi)==true){
                            break;
                        }
                        else{
                            System.out.println("Ma xe khong co trong danh sach xe");
                            System.out.print("Nhap lai ma xe: ");
                        }
                    }
                    giabanmoi=dsx.Laygiaban(maxemoi);
                    Arrhdx[vt].setGiaban(giabanmoi);
                    Arrhdx[vt].setTongtien();
                    break;
                case 4:
                    String thangmoi;
                    System.out.print("Nhap lai thang ban: ");
                    thangmoi=cl.kiemTraThang();
                    Arrhdx[vt].setThang(thangmoi);
                    break;
                case 5:
                    String nammoi;
                    System.out.print("Nhap lai nam ban: ");
                    nammoi=cl.kiemTraNam();
                    Arrhdx[vt].setNam(nammoi);
                    break;
                case 6:
                    int soluongmoi;
                    String maxe;
                    maxe=Arrhdx[vt].getMaxe();
                    System.out.print("Nhap lai so luong ban: ");
                    while(true){
                        DanhSachXe dsx1=new DanhSachXe();
                        dsx1.docfile();
                        soluongmoi=cl.kiemTraSoLuong();
                        if(soluongmoi<dsx1.Laysoluong(maxe))
                            break;
                        else{
                            System.out.println("So luong xe trong danh xe khong du");
                            System.out.print("Nhap lai so luong xe ban: ");
                        }
                    }
                    Arrhdx[vt].setSoluong(soluongmoi);
                    Arrhdx[vt].setTongtien();
                    break;
                case 7:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach hoa don xuat");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
            }
            System.out.println("Thong tin hoa don xuat da sua!!!");
            Arrhdx[vt].XuatHd();
        }
        while(tieptuc);
    }
    
    public boolean kiemTraMaHd(String mahd){
        for(int i=0;i<n;i++)
            if(Arrhdx[i].getMahd().equals(mahd)==true)
                return true;
        return false;
    }
    
    public boolean kiemTraMaNv(String manv){
        for(int i=0;i<n;i++)
            if(Arrhdx[i].getMasnv().equals(manv)==true)
                return true;
        return false;
    }

    public boolean kiemTraMakh(String makh){
        for(int i=0;i<n;i++)
            if(Arrhdx[i].getMakh().equals(makh)==true)
                return true;
        return false;
    }
    
    public boolean kiemTraMaxe(String mx){
        for(int i=0;i<n;i++)
            if(Arrhdx[i].getMaxe().equals(mx)==true)
                return true;
        return false;
    }
    
    public int Laysoluong(String maxe){
        int soluongban=0;
        for(int i=0;i<n;i++)
            if(Arrhdx[i].getMaxe().equals(maxe)==true)
                soluongban+=Arrhdx[i].getSoluong();
        return soluongban;
    }
        
    public boolean kiemTraThang(String thang){
        for(int i=0;i<n;i++)
            if(Arrhdx[i].getThang().equals(thang)==true)
                return true;
        return false;
    }
    
    public boolean kiemTraNam(String nam){
        for(int i=0;i<n;i++)
            if(Arrhdx[i].getNam().equals(nam)==true)
                return true;
        return false;
    }
    
    public long Laytien(String thang,String nam){
        long tongxuat=0;
        for(int i=0;i<n;i++)
            if(Arrhdx[i].getNam().equals(nam)==true)
                if(Arrhdx[i].getThang().equals(thang)==true)
                    tongxuat+=Arrhdx[i].getTongtien();
        return tongxuat;
    }
    
    public void docfile() throws IOException{
        FileInputStream fis = null;
        DataInputStream dis = null;
        n=0;
        try {
            fis=new FileInputStream("HoaDonXuat.dat");
            dis=new DataInputStream(fis);
            try{
                while(true){
                    String mahd=dis.readUTF();
                    String masnv=dis.readUTF();
                    String makh=dis.readUTF();
                    String maxe=dis.readUTF();
                    String thang=dis.readUTF();
                    String nam=dis.readUTF();
                    int soluong=dis.readInt();
                    long giaban=dis.readLong();
                    long tongtien=dis.readLong();
                    Arrhdx[n]=new HoaDonXuat(mahd,masnv,makh,maxe,thang,nam,soluong,giaban,tongtien);
                    n++;
                }
            }
            catch (EOFException e){
            }
            finally{
                dis.close();
            }
        } 
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally{
            fis.close();
        }	
    }
    
    public void ghifile() throws IOException{
        try{
            FileOutputStream fos = new FileOutputStream("HoaDonXuat.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            for(int i=0;i<n;i++){
                Arrhdx[i].ghifile();
            }
            dos.close();
            fos.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
