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
public class DanhSachBaoHanh implements DanhSach{
    CheckLoi cl=new CheckLoi();
    private int n;
    private BaoHanh[] Arrbh = new BaoHanh[100];
    Scanner Nhapdsbh=new Scanner(System.in);
    
    public DanhSachBaoHanh(){
    }
    
    public DanhSachBaoHanh(BaoHanh[] Arrbh,int n){
        this.Arrbh=Arrbh;
        this.n=n;
    }
    
    public DanhSachBaoHanh(DanhSachBaoHanh baohanh){
        Arrbh=baohanh.Arrbh;
        n=baohanh.n;
    }
    
    @Override
    public void NhapDanhSach()throws IOException{
        System.out.print("Nhap so luong bao hanh: ");
        n=cl.kiemTraSoLuong();
        Arrbh= new BaoHanh[n];
        for(int i=0;i<n;i++){
            Arrbh[i]=new BaoHanh();
            Arrbh[i].NhapBh();
            Arrbh[i].ghifile();
        }
    }
    
    @Override
    public void XuatDanhSach()throws IOException{     
        System.out.println("Danh sach bao hanh: ");
        System.out.printf("%-15s%-15s%-15s%-13s%-15s\n","Ma bao hanh","Ma nhan vien","Ma khach hang","Thang nam","Tong tien");
            for(int i=0;i<n;i++)
                Arrbh[i].XuatBh();
    }
    
    @Override
    public void Them() throws IOException{
        System.out.println("Nhap thong tin bao hanh can them : ");
        BaoHanh bh = new BaoHanh();
        bh.NhapBh();
        Arrbh=Arrays.copyOf(Arrbh,Arrbh.length+1);
        Arrbh[n]=bh;
//        Arrbh[n].ghifile();
        n++;
    }
    
    @Override
    public void Themkphantu() throws IOException{
        System.out.print("Nhap so luong bao hanh can them: ");
        int k=cl.kiemTraSoLuong();
        for(int i=0;i<k;i++){
            int a=i+1;
            System.out.println("Bao hanh can them ("+a+"): ");
            Them();
        }
    }
    
    public void TimKiemMaBh(String mbhtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrbh[i].getMabaohanh().equals(mbhtim)==true){
                dem++;
                Arrbh[i].XuatBh();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ma bao hanh!!!");
    }
    
    public void TimKiemMaNv(String mnvtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrbh[i].getMasnv().equals(mnvtim)==true){
                dem++;
                Arrbh[i].XuatBh();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ma nhan vien!!!");
    }
    
    public void TimKiemMaKh(String mkhtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrbh[i].getMakh().equals(mkhtim)==true){
                dem++;
                Arrbh[i].XuatBh();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ma khach hang!!!");
    }
    
    public void TimKiemThang(String thangtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrbh[i].getThang().equals(thangtim)==true){
                dem++;
                Arrbh[i].XuatBh();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay bao hanh theo thang!!!");
    }
    
    public void TimKiemNam(String namtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrbh[i].getNam().equals(namtim)==true){
                dem++;
                Arrbh[i].XuatBh();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay bao hanh theo nam!!!");
    }
    
    public void TimKiemNamThang(String thangtim,String namtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrbh[i].getNam().equals(namtim)==true){
                if(Arrbh[i].getThang().equals(thangtim)==true){
                    dem++;
                    Arrbh[i].XuatBh();
                }
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay bao hanh theo thang nam!!!");
    }
    
    public int TimKiem(String ma){
        int vitri=-1;
        for(int i=0;i<n;i++)
            if(ma.compareTo(Arrbh[i].getMabaohanh())==0){
                vitri=i;
                break;
            }
        return vitri;
    }
    
    @Override
    public void Xoa() throws IOException{
        System.out.print("Nhap ma bao hanh can xoa: ");
        String mabhxoa=cl.kiemTraMaBh();
        int vt=TimKiem(mabhxoa);
        BaoHanh[] arrxoa=new BaoHanh[n];
        while(vt==-1){
            System.out.println("Khong tim thay ma bao hanh can xoa!!!");
            System.out.print("Nhap lai ma bao hanh can xoa: ");
            mabhxoa=cl.kiemTraMaBh();
            vt=TimKiem(mabhxoa);
        }
        if(vt!=-1){
            arrxoa=Arrays.copyOf(Arrbh,Arrbh.length+1);
            for(int i=vt;i<n;i++)
                Arrbh[i]=arrxoa[i+1];
            n--;
        }
        System.out.println("Xoa thanh cong thong tin bao hanh!!!");
    }
    
    @Override
    public void Sua() throws IOException{
        boolean tieptuc=false;
        System.out.print("Nhap ma bao hanh can sua thong tin: ");
        String mabhsua=cl.kiemTraMaBh();
        int vt=TimKiem(mabhsua);
        while(vt==-1){
            System.out.println("Khong tim thay ma bao hanh can sua!!!");
            System.out.print("Nhap lai ma bao hanh can sua: ");
            mabhsua=cl.kiemTraMaBh();
            vt=TimKiem(mabhsua);
        }
        do{
            System.out.println("++++++SUA THONG TIN BAO HANH++++++");
            System.out.println("1.Thay doi ma nhan vien");     
            System.out.println("2.Thay doi ma khach hang");
            System.out.println("3.Thay doi thang bao hanh");;
            System.out.println("4.Thay doi nam bao hanh");
            System.out.println("5.Thay doi gia tien bao hanh");
            System.out.println("6.Tro lai danh sach bao hanh");
            System.out.print("Chon thong tin ban muon sua: ");
            int chonthaydoi=cl.kiemTraInt();
            while(chonthaydoi>6 || chonthaydoi<=0){
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
                            if(dsnv.kiemTraChucvuSuachua(masnvmoi)==true)
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
                    Arrbh[vt].setMasnv(masnvmoi);
                    break;
                case 2:
                    DanhSachKhachHang dskh=new DanhSachKhachHang();
                    dskh.docfile();
                    String makhmoi;
                    System.out.print("Nhap lai ma khach hang: ");
                    while(true){
                        makhmoi=cl.kiemTraMaKh();
                        if(dskh.kiemTraMaKh(makhmoi)==true){
                            break;
                        }
                        else{
                            System.out.println("Ma khach hang khong co trong danh sach khach hang");
                            System.out.print("Nhap lai ma khach hang: ");
                        }
                    }
                    Arrbh[vt].setMasnv(makhmoi);
                    break;
                case 3:
                    String thangmoi;
                    System.out.print("Nhap lai thang bao hanh: ");
                    thangmoi=cl.kiemTraThang();
                    Arrbh[vt].setThang(thangmoi);
                    break;
                case 4:
                    String nammoi;
                    System.out.print("Nhap lai nam bao hanh: ");
                    nammoi=cl.kiemTraNam();
                    Arrbh[vt].setNam(nammoi);
                    break;
                case 5:
                    long thanhtienmoi;
                    System.out.print("Nhap lai gia tien bao hanh: ");
                    thanhtienmoi=Long.parseLong(cl.kiemTraTien());
                    Arrbh[vt].setThanhtien(thanhtienmoi);
                    break;
                case 6:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach bao hanh");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
            }
            System.out.println("Thong tin nhan vien da sua!!!");
            Arrbh[vt].XuatBh();
        }
        while(tieptuc);
    }
    
    public boolean kiemTraMaBh(String mabh){
        for(int i=0;i<n;i++)
            if(Arrbh[i].getMabaohanh().equals(mabh)==true)
                return true;
        return false;
    }
    
    public boolean kiemTraMaNv(String manv){
        for(int i=0;i<n;i++)
            if(Arrbh[i].getMasnv().equals(manv)==true)
                return true;
        return false;
    }

    public boolean kiemTraMaKh(String makh){
        for(int i=0;i<n;i++)
            if(Arrbh[i].getMakh().equals(makh)==true)
                return true;
        return false;
    }
        
    public boolean kiemTraThang(String thang){
        for(int i=0;i<n;i++)
            if(Arrbh[i].getThang().equals(thang)==true)
                return true;
        return false;
    }
    
    public boolean kiemTraNam(String nam){
        for(int i=0;i<n;i++)
            if(Arrbh[i].getNam().equals(nam)==true)
                return true;
        return false;
    }
    
    public long Laytien(String thang,String nam){
        long tongxuat=0;
        for(int i=0;i<n;i++)
            if(Arrbh[i].getNam().equals(nam)==true)
                if(Arrbh[i].getThang().equals(thang)==true)
                    tongxuat+=Arrbh[i].getThanhtien();
        return tongxuat;
    }
    
    @Override
    public void docfile() throws IOException{
        FileInputStream fis = null;
        DataInputStream dis = null;
        n=0;
        try {
            fis=new FileInputStream("BaoHanh.dat");
            dis=new DataInputStream(fis);
            try{
                while(true){
                    String mabaohanh=dis.readUTF();
                    String masnv=dis.readUTF();
                    String makh=dis.readUTF();
                    String thang=dis.readUTF();
                    String nam=dis.readUTF();
                    long thanhtien=dis.readLong();
                    Arrbh[n]=new BaoHanh(mabaohanh,masnv,makh,thang,nam,thanhtien);
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
            FileOutputStream fos = new FileOutputStream("BaoHanh.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            for(int i=0;i<n;i++){
                Arrbh[i].ghifile();
            }
            dos.close();
            fos.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
