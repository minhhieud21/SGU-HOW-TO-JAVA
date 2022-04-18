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
public class DanhSachNhanVien implements DanhSach{
    CheckLoi cl=new CheckLoi();
    private int n;
    private NhanVien[] Arrnv = new NhanVien[100];
    Scanner Nhapdsnv=new Scanner(System.in);
    
    public DanhSachNhanVien(){
    }
    
    public DanhSachNhanVien(NhanVien[] Arrnv,int n){
        this.Arrnv=Arrnv;
        this.n=n;
    }
    
    public DanhSachNhanVien(DanhSachNhanVien nhanvien){
        Arrnv=nhanvien.Arrnv;
        n=nhanvien.n;
    }
    
    @Override
    public void NhapDanhSach()throws IOException{
        System.out.print("Nhap so luong nhan vien: ");
        n=cl.kiemTraSoLuong();
        Arrnv= new NhanVien[n];
        for(int i=0;i<n;i++){
            Arrnv[i]=new NhanVien();
            Arrnv[i].NhapNv();
            Arrnv[i].ghifile();
        }
    }
    
    @Override
    public void XuatDanhSach()throws IOException{     
        System.out.println("Danh sach nhan vien: ");
        System.out.printf("%-15s%-25s%-15s%-20s%-15s%-15s\n","Ma nhan vien","Ho ten","Chuc vu","Luong","Dia chi","So dien thoai");
            for(int i=0;i<n;i++)
                Arrnv[i].XuatNv();
    }
    
    @Override
    public void Them() throws IOException{
        System.out.println("Nhap thong tin nhan vien can them : ");
        NhanVien nv = new NhanVien();
        nv.NhapNv();
        Arrnv=Arrays.copyOf(Arrnv,Arrnv.length+1);
        Arrnv[n]=nv;
//        Arrnv[n].ghifile();
        n++;
    }
    
    @Override
    public void Themkphantu() throws IOException{
        System.out.print("Nhap so luong nhan vien can them: ");
        int k=cl.kiemTraSoLuong();
        for(int i=0;i<k;i++){
            int a=i+1;
            System.out.println("Nhan vien can them ("+a+"): ");
            Them();
        }
    }
    
    public void TimKiemMa(String mnvtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrnv[i].getMasnv().equals(mnvtim)==true){
                dem++;
                Arrnv[i].XuatNv();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ma nhan vien!!!");
    }
    
    public void TimKiemTen(String tennvtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrnv[i].getHoten().equals(tennvtim)==true){
                dem++;
                Arrnv[i].XuatNv();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ho ten nhan vien!!!");
    }
    
    public int TimKiem(String ma){
        int vitri=-1;
        for(int i=0;i<n;i++)
            if(ma.compareTo(Arrnv[i].getMasnv())==0){
                vitri=i;
                break;
            }
        return vitri;
    }
    
    @Override
    public void Xoa() throws IOException{
        System.out.print("Nhap ma nhan vien can xoa: ");
        String manvxoa=cl.kiemTraMaNv();
        int vt=TimKiem(manvxoa);
        NhanVien[] arrxoa=new NhanVien[n];
        while(vt==-1){
            System.out.println("Khong tim thay ma nhan vien can xoa!!!");
            System.out.print("Nhap lai ma nhan vien can xoa: ");
            manvxoa=cl.kiemTraMaNv();
            vt=TimKiem(manvxoa);
        }
        if(vt!=-1){
            arrxoa=Arrays.copyOf(Arrnv,Arrnv.length+1);
            for(int i=vt;i<n;i++)
                Arrnv[i]=arrxoa[i+1];
            n--;
        }
        System.out.println("Xoa thanh cong thong tin nhan vien!!!");
    }
    
    @Override
    public void Sua(){
        boolean tieptuc=false;
        System.out.print("Nhap ma nhan vien can sua thong tin: ");
        String manvsua=cl.kiemTraMaNv();
        int vt=TimKiem(manvsua);
        while(vt==-1){
            System.out.println("Khong tim thay ma nhan vien can sua!!!");
            System.out.print("Nhap lai ma nhan vien can sua: ");
            manvsua=cl.kiemTraMaNv();
            vt=TimKiem(manvsua);
        }
        do{
            System.out.println("++++++SUA THONG TIN NHAN VIEN++++++");
            System.out.println("1.Thay doi ten nhan vien");     
            System.out.println("2.Thay doi chuc vu nhan vien");
            System.out.println("3.Thay doi dia chi nhan vien");;
            System.out.println("4.Thay doi so dien thoai nhan vien");
            System.out.println("5.Tro lai danh sach nhan vien");
            System.out.print("Chon thong tin ban muon sua: ");
            int chonthaydoi=cl.kiemTraInt();
            while(chonthaydoi>5 || chonthaydoi<=0){
                System.out.println("Nhap sai cu phap!!!");
                System.out.println("==================================================");
                System.out.print("Chon lai thong tin ban muon sua: ");
                chonthaydoi=cl.kiemTraInt();
            }
            switch(chonthaydoi){
                case 1:
                    String tennvmoi;
                    System.out.print("Nhap lai ten nhan vien: ");
                    tennvmoi=cl.kiemTraTenNv();
                    Arrnv[vt].setHoten(tennvmoi);
                    break;
                case 2:
                    System.out.println("Chon lai chuc vu nhan vien:");
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
                                Arrnv[vt].setChucvu("Quan ly");
                                Arrnv[vt].setHeso((float)0.5);
                                Arrnv[vt].setLuongcoban(10000000);
                                Arrnv[vt].setLuong();
                                break;
                            case 2:
                                System.out.println("Chuc vu cua nhan vien: Ban hang");
                                Arrnv[vt].setChucvu("Ban hang");
                                Arrnv[vt].setHeso((float)0.4);
                                Arrnv[vt].setLuongcoban(7000000);
                                Arrnv[vt].setLuong();
                                break;
                            case 3:
                                System.out.println("Chuc vu cua nhan vien: Sua chua");
                                Arrnv[vt].setChucvu("Sua chua");
                                Arrnv[vt].setHeso((float)0.2);
                                Arrnv[vt].setLuongcoban(7000000);
                                Arrnv[vt].setLuong();
                                break;
                        }
                    break;
                case 3:
                    String diachimoi;
                    System.out.print("Nhap lai dia chi: ");
                    diachimoi=Nhapdsnv.nextLine();
                    Arrnv[vt].setDiachi(diachimoi);
                    break;
                case 4:
                    String dienthoaimoi;
                    System.out.print("Nhap lai so dien thoai: ");
                    dienthoaimoi=cl.kiemTraSdt();
                    Arrnv[vt].setSdt(dienthoaimoi);
                    break;
                
                case 5:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach nhan vien");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
            }
            System.out.println("Thong tin nhan vien da sua!!!");
            Arrnv[vt].XuatNv();
        }
        while(tieptuc);
    }
    
    public boolean kiemTraManv(String manv){
        for(int i=0;i<n;i++)
            if(Arrnv[i].getMasnv().equals(manv)==true)
                return true;
        return false;
    }
    
    public boolean kiemTraTennv(String tennv){
        for(int i=0;i<n;i++)
            if(Arrnv[i].getHoten().equals(tennv)==true)
                return true;
        return false;
    }
    
    public boolean kiemTraChucvuSuachua(String manv){
        for(int i=0;i<n;i++)
            if(Arrnv[i].getMasnv().equals(manv)==true)
                if(Arrnv[i].getChucvu().equals("Sua chua")==true)
                    return true;
        return false;
    }
    
    public boolean kiemTraChucvuQuanLy(String manv){
        for(int i=0;i<n;i++)
            if(Arrnv[i].getMasnv().equals(manv)==true)
                if(Arrnv[i].getChucvu().equals("Quan ly")==true)
                    return true;
        return false;
    }
    
    public boolean kiemTraChucvuBanHang(String manv){
        for(int i=0;i<n;i++)
            if(Arrnv[i].getMasnv().equals(manv)==true)
                if(Arrnv[i].getChucvu().equals("Ban hang")==true)
                    return true;
        return false;
    }
    
    public int LayQuyen(String msnv){
        for(int i=0;i<n;i++)
            if(Arrnv[i].getMasnv().equals(msnv)==true){
                if(Arrnv[i].getChucvu().equals("Quan ly")==true)
                    return 2;
                else return 1;
                }
        return 0;
    }
    
    @Override
    public void docfile() throws IOException{
        FileInputStream fis = null;
        DataInputStream dis = null;
        n=0;
        try {
            fis=new FileInputStream("NhanVien.dat");
            dis=new DataInputStream(fis);
            try{
                while(true){
                    String masnv=dis.readUTF();
                    String hoten=dis.readUTF();
                    String chucvu=dis.readUTF();
                    long luong=dis.readLong();
                    String diachi=dis.readUTF();
                    String sdt=dis.readUTF();
                    Arrnv[n]=new NhanVien(masnv,hoten,chucvu,luong,diachi,sdt);
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
            FileOutputStream fos = new FileOutputStream("NhanVien.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            for(int i=0;i<n;i++){
                Arrnv[i].ghifile();
            }
            dos.close();
            fos.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
