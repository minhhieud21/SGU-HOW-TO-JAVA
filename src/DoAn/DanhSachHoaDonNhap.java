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
public class DanhSachHoaDonNhap implements DanhSach{
    CheckLoi cl=new CheckLoi();
    private int n;
    private HoaDonNhap[] Arrhdn = new HoaDonNhap[100];
    Scanner Nhapdshdn=new Scanner(System.in);
    
    public DanhSachHoaDonNhap(){
    }
    
    public DanhSachHoaDonNhap(HoaDonNhap[] Arrhdn,int n){
        this.Arrhdn=Arrhdn;
        this.n=n;
    }
    
    public DanhSachHoaDonNhap(DanhSachHoaDonNhap hoadonnhap){
        Arrhdn=hoadonnhap.Arrhdn;
        n=hoadonnhap.n;
    }
    
    @Override
    public void NhapDanhSach()throws IOException{
        System.out.print("Nhap so luong hoa don nhap: ");
        n=cl.kiemTraSoLuong();
        Arrhdn= new HoaDonNhap[n];
        for(int i=0;i<n;i++){
            Arrhdn[i]=new HoaDonNhap();
            Arrhdn[i].NhapHd();
            Arrhdn[i].ghifile();
        }
    }
    
    @Override
    public void XuatDanhSach()throws IOException{     
        System.out.println("Danh sach hoa don nhap: ");
        System.out.printf("%-15s%-15s%-15s%-10s%-10s%-13s%-15s%-20s%-20s\n","Ma hoa don","Ma nhan vien","Ma phan phoi","Ma nhom","Ma xe","Thang nam","So luong","Gia nhap","Tong tien");
            for(int i=0;i<n;i++)
                Arrhdn[i].XuatHd();
    }
    
    @Override
    public void Them() throws IOException{
        System.out.println("Nhap thong tin hoa don nhap can them : ");
        HoaDonNhap hdn = new HoaDonNhap();
        hdn.NhapHd();
        Arrhdn=Arrays.copyOf(Arrhdn,Arrhdn.length+1);
        Arrhdn[n]=hdn;
//        Arrhdn[n].ghifile();
        n++;
    }
    
    @Override
    public void Themkphantu() throws IOException{
        System.out.print("Nhap so luong hoa don nhap can them: ");
        int k=cl.kiemTraSoLuong();
        for(int i=0;i<k;i++){
            int a=i+1;
            System.out.println("Hoa don nhap can them ("+a+"): ");
            Them();
        }
    }
    
    public void TimKiemMaHd(String mhdtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrhdn[i].getMahd().equals(mhdtim)==true){
                dem++;
                Arrhdn[i].XuatHd();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ma hoa don!!!");
    }
    
    public void TimKiemMaNv(String mnvtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrhdn[i].getMasnv().equals(mnvtim)==true){
                dem++;
                Arrhdn[i].XuatHd();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ma nhan vien!!!");
    }
    
    public void TimKiemManpp(String mnpptim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrhdn[i].getManpp().equals(mnpptim)==true){
                dem++;
                Arrhdn[i].XuatHd();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ma nha phan phoi!!!");
    }
    
     public void TimKiemManhom(String mnhomtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrhdn[i].getManhom().equals(mnhomtim)==true){
                dem++;
                Arrhdn[i].XuatHd();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ma nhom xe!!!");
    }
    
    public void TimKiemMaxe(String mxetim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrhdn[i].getMaxe().equals(mxetim)==true){
                dem++;
                Arrhdn[i].XuatHd();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ma xe!!!");
    }
    
    public void TimKiemThang(String thangtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrhdn[i].getThang().equals(thangtim)==true){
                dem++;
                Arrhdn[i].XuatHd();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay hoa don nhap theo thang!!!");
    }
    
    public void TimKiemNam(String namtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrhdn[i].getNam().equals(namtim)==true){
                dem++;
                Arrhdn[i].XuatHd();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay hoa don nhap theo nam!!!");
    }
    
    public void TimKiemNamThang(String thangtim,String namtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrhdn[i].getNam().equals(namtim)==true){
                if(Arrhdn[i].getThang().equals(thangtim)==true){
                    dem++;
                    Arrhdn[i].XuatHd();
                }
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay hoa don theo thang nam!!!");
    }
    
    public int TimKiem(String ma){
        int vitri=-1;
        for(int i=0;i<n;i++)
            if(ma.compareTo(Arrhdn[i].getMahd())==0){
                vitri=i;
                break;
            }
        return vitri;
    }
    
    @Override
    public void Xoa() throws IOException{
        System.out.print("Nhap ma hoa don nhap can xoa: ");
        String mahdnxoa=cl.kiemTraMaHdn();
        int vt=TimKiem(mahdnxoa);
        HoaDonNhap[] arrxoa=new HoaDonNhap[n];
        while(vt==-1){
            System.out.println("Khong tim thay ma hoa don nhap can xoa!!!");
            System.out.print("Nhap lai ma hoa don nhap can xoa: ");
            mahdnxoa=cl.kiemTraMaHdn();
            vt=TimKiem(mahdnxoa);
        }
        if(vt!=-1){
            arrxoa=Arrays.copyOf(Arrhdn,Arrhdn.length+1);
            for(int i=vt;i<n;i++)
                Arrhdn[i]=arrxoa[i+1];
            n--;
        }
        System.out.println("Xoa thanh cong thong tin hoa don nhap!!!");
    }
    
    @Override
    public void Sua() throws IOException{
        boolean tieptuc=false;
        System.out.print("Nhap ma hoa don nhap can sua thong tin: ");
        String mahdnsua=cl.kiemTraMaHdn();
        int vt=TimKiem(mahdnsua);
        while(vt==-1){
            System.out.println("Khong tim thay ma hoa don nhap can sua!!!");
            System.out.print("Nhap lai ma hoa don nhap can sua: ");
            mahdnsua=cl.kiemTraMaHdn();
            vt=TimKiem(mahdnsua);
        }
        do{
            System.out.println("++++++SUA THONG TIN HOA DON NHAP++++++");
            System.out.println("1.Thay doi ma nhan vien");     
            System.out.println("2.Thay doi ma nha phan phoi");
            System.out.println("3.Thay doi ma nhom xe");
            System.out.println("4.Thay doi ma xe");
            System.out.println("5.Thay doi thang hoa don nhap");;
            System.out.println("6.Thay doi nam hoa don nhap");
            System.out.println("7.Thay doi so luong nhap");
            System.out.println("8.Tro lai danh sach bao hanh");
            System.out.print("Chon thong tin ban muon sua: ");
            int chonthaydoi=cl.kiemTraInt();
            while(chonthaydoi>8 || chonthaydoi<=0){
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
                            if(dsnv.kiemTraChucvuQuanLy(masnvmoi)==true)
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
                    Arrhdn[vt].setMasnv(masnvmoi);
                    break;
                case 2:
                    DanhSachNhaPhanPhoi dsnpp=new DanhSachNhaPhanPhoi();
                    dsnpp.docfile();
                    String mnppmoi;
                    System.out.print("Nhap lai ma nha phan phoi: ");
                    while(true){
                        mnppmoi=cl.kiemTraManpp();
                        if(dsnpp.kiemTraMnpp(mnppmoi)==true){
                            break;
                        }
                        else{
                            System.out.println("Ma nha phan phoi khong co trong danh sach nha phan phoi");
                            System.out.print("Nhap lai ma nha phan phoi: ");
                        }
                    }
                    Arrhdn[vt].setManpp(mnppmoi);
                    break;
                case 3:
                    DanhSachThongTinXe dsttx=new DanhSachThongTinXe();
                    dsttx.docfile();
                    String manhommoi;
                    long gianhapmoi;
                    System.out.print("Nhap lai ma nhom xe: ");
                    while(true){
                        manhommoi=cl.kiemTraManhom();
                        if(dsttx.kiemTraManhom(manhommoi)==true){
                            break;
                        }
                        else{
                            System.out.println("Ma nhom khong co trong danh sach thong tin xe");
                            System.out.print("Nhap lai ma nhom xe: ");
                        }
                    }
                    Arrhdn[vt].setManhom(manhommoi);
                    gianhapmoi=dsttx.Laygianhap(manhommoi);
                    Arrhdn[vt].setGianhap(gianhapmoi);
                    Arrhdn[vt].setTongtien();
                    break;
                case 4:
                    String maxemoi;
                    System.out.print("Nhap lai ma xe: ");
                    maxemoi=cl.kiemTraMaxe();
                    Arrhdn[vt].setMaxe(maxemoi);
                    break;
                case 5:
                    String thangmoi;
                    System.out.print("Nhap lai thang nhap: ");
                    thangmoi=cl.kiemTraThang();
                    Arrhdn[vt].setThang(thangmoi);
                    break;
                case 6:
                    String nammoi;
                    System.out.print("Nhap lai nam nhap: ");
                    nammoi=cl.kiemTraNam();
                    Arrhdn[vt].setNam(nammoi);
                    break;
                case 7:
                    int soluongmoi;
                    System.out.print("Nhap lai so luong nhap: ");
                    soluongmoi=cl.kiemTraSoLuong();
                    Arrhdn[vt].setSoluong(soluongmoi);
                    Arrhdn[vt].setTongtien();
                    break;
                case 8:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach hoa don nhap");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
            }
            System.out.println("Thong tin hoa don nhap da sua!!!");
            Arrhdn[vt].XuatHd();
        }
        while(tieptuc);
    }
    
    public boolean kiemTraMaHd(String mahd){
        for(int i=0;i<n;i++)
            if(Arrhdn[i].getMahd().equals(mahd)==true)
                return true;
        return false;
    }
    
    public boolean kiemTraMaNv(String manv){
        for(int i=0;i<n;i++)
            if(Arrhdn[i].getMasnv().equals(manv)==true)
                return true;
        return false;
    }

    public boolean kiemTraMnpp(String mnpp){
        for(int i=0;i<n;i++)
            if(Arrhdn[i].getManpp().equals(mnpp)==true)
                return true;
        return false;
    }
    
    public boolean kiemTraManhom(String mn){
        for(int i=0;i<n;i++)
            if(Arrhdn[i].getManhom().equals(mn)==true)
                return true;
        return false;
    }
    
    public boolean kiemTraMaxe(String mx){
        for(int i=0;i<n;i++)
            if(Arrhdn[i].getMaxe().equals(mx)==true)
                return true;
        return false;
    }
        
    public boolean kiemTraThang(String thang){
        for(int i=0;i<n;i++)
            if(Arrhdn[i].getThang().equals(thang)==true)
                return true;
        return false;
    }
    
    public boolean kiemTraNam(String nam){
        for(int i=0;i<n;i++)
            if(Arrhdn[i].getNam().equals(nam)==true)
                return true;
        return false;
    }
    
    public long Laytien(String thang,String nam){
        long tongxuat=0;
        for(int i=0;i<n;i++)
            if(Arrhdn[i].getNam().equals(nam)==true)
                if(Arrhdn[i].getThang().equals(thang)==true)
                    tongxuat+=Arrhdn[i].getTongtien();
        return tongxuat;
    }
    
    public String Laymanhom(String maxe){
        String manhom=null;
        for(int i=0;i<n;i++)
            if(Arrhdn[i].getMaxe().equals(maxe)==true)
                manhom=Arrhdn[i].getManhom();
        return manhom;
    }
    
    public int Laysoluong(String maxe){
        int soluong=0;
        for(int i=0;i<n;i++)
            if(Arrhdn[i].getMaxe().equals(maxe)==true)
                soluong+=Arrhdn[i].getSoluong();
        return soluong;
    }
    
    @Override
    public void docfile() throws IOException{
        FileInputStream fis = null;
        DataInputStream dis = null;
        n=0;
        try {
            fis=new FileInputStream("HoaDonNhap.dat");
            dis=new DataInputStream(fis);
            try{
                while(true){
                    String mahd=dis.readUTF();
                    String masnv=dis.readUTF();
                    String manpp=dis.readUTF();
                    String manhom=dis.readUTF();
                    String maxe=dis.readUTF();
                    String thang=dis.readUTF();
                    String nam=dis.readUTF();
                    int soluong=dis.readInt();
                    long gianhap=dis.readLong();
                    long tongtien=dis.readLong();
                    Arrhdn[n]=new HoaDonNhap(mahd,masnv,manpp,manhom,maxe,thang,nam,soluong,gianhap,tongtien);
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
    
    @Override
    public void ghifile() throws IOException{
        try{
            FileOutputStream fos = new FileOutputStream("HoaDonNhap.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            for(int i=0;i<n;i++){
                Arrhdn[i].ghifile();
            }
            dos.close();
            fos.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
