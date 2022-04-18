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
public class DanhSachThongTinXe implements DanhSach{
    CheckLoi cl=new CheckLoi();
    private int n;
    private ThongTinXe[] Arrttx = new ThongTinXe[100];
    Scanner Nhapdsttx=new Scanner(System.in);
    
    public DanhSachThongTinXe(){
    }
    
    public DanhSachThongTinXe(ThongTinXe[] Arrttx,int n){
        this.Arrttx=Arrttx;
        this.n=n;
    }
    
    public DanhSachThongTinXe(DanhSachThongTinXe thongtinxe){
        Arrttx=thongtinxe.Arrttx;
        n=thongtinxe.n;
    }
    
    @Override
    public void NhapDanhSach()throws IOException{
        System.out.print("Nhap so luong thong tin xe: ");
        n=cl.kiemTraSoLuong();
        Arrttx= new ThongTinXe[n];
        for(int i=0;i<n;i++){
            Arrttx[i]=new ThongTinXe();
            Arrttx[i].NhapTtx();
            Arrttx[i].ghifile();
        }
    }
    
    @Override
    public void XuatDanhSach()throws IOException{     
        System.out.println("Danh sach nha phan phoi: ");
        System.out.printf("%-10s%-20s%-10s%-15s%-10s%-20s\n","Ma nhom","Ten xe","So mau","Loai xe","Bao hanh","Gia nhap");
            for(int i=0;i<n;i++)
                Arrttx[i].XuatTtx();
    }
    
    @Override
    public void Them() throws IOException{
        System.out.println("Nhap thong tin xe can them : ");
        ThongTinXe ttx = new ThongTinXe();
        ttx.NhapTtx();
        Arrttx=Arrays.copyOf(Arrttx,Arrttx.length+1);
        Arrttx[n]=ttx;
//        Arrttx[n].ghifile();
        n++;
    }
    
    @Override
    public void Themkphantu() throws IOException{
        System.out.print("Nhap so luong thong tin xe can them: ");
        int k=cl.kiemTraSoLuong();
        for(int i=0;i<k;i++){
            int a=i+1;
            System.out.println("Thong tin xe can them ("+a+"): ");
            Them();
        }
    }
    
    public void TimKiemMa(String manhomtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrttx[i].getManhom().equals(manhomtim)==true){
                dem++;
                Arrttx[i].XuatTtx();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ma nhom!!!");
    }
    
    public void TimKiemTen(String tenxetim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrttx[i].getTenxe().equals(tenxetim)==true){
                dem++;
                Arrttx[i].XuatTtx();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ten xe!!!");
    }
    
    public int TimKiem(String ma){
        int vitri=-1;
        for(int i=0;i<n;i++)
            if(ma.compareTo(Arrttx[i].getManhom())==0){
                vitri=i;
                break;
            }
        return vitri;
    }
    
    @Override
    public void Xoa() throws IOException{
        System.out.print("Nhap ma nhom can xoa: ");
        String manhomxoa=cl.kiemTraManhom();
        int vt=TimKiem(manhomxoa);
        ThongTinXe[] arrxoa=new ThongTinXe[n];
        while(vt==-1){
            System.out.println("Khong tim thay ma nhom can xoa!!!");
            System.out.print("Nhap lai ma nhom can xoa: ");
            manhomxoa=cl.kiemTraManhom();
            vt=TimKiem(manhomxoa);
        }
        if(vt!=-1){
            arrxoa=Arrays.copyOf(Arrttx,Arrttx.length+1);
            for(int i=vt;i<n;i++)
                Arrttx[i]=arrxoa[i+1];
            n--;
        }
        System.out.println("Xoa thanh cong thong tin xe!!!");
    }
    
    @Override
    public void Sua(){
        boolean tieptuc=false;
        System.out.print("Nhap ma nhom xe can sua thong tin: ");
        String manhomsua=cl.kiemTraManhom();
        int vt=TimKiem(manhomsua);
        while(vt==-1){
            System.out.println("Khong tim thay ma nhom can sua!!!");
            System.out.print("Nhap lai ma nhom can sua: ");
            manhomsua=cl.kiemTraManhom();
            vt=TimKiem(manhomsua);
        }
        do{
            System.out.println("++++++SUA THONG TIN XE++++++");
            System.out.println("1.Thay doi ma nhom xe");
            System.out.println("2.Thay doi ten xe");     
            System.out.println("3.Thay doi so mau xe");
            System.out.println("4.Thay doi phan khoi xe");
            System.out.println("5.Thay doi so nam bao hanh xe");
            System.out.println("6.Thay doi gia nhap xe");
            System.out.println("7.Tro lai danh sach thong tin xe");
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
                    String manhomxemoi;
                    do{
                        System.out.print("Nhap lai ma nhom xe: ");
                        manhomxemoi=cl.kiemTraManhom();
                        if(-1 != TimKiem(manhomxemoi))
                            System.out.println("Ma nhom xe da ton tai!!!");
                        else
                            break;
                    }
                    while(true);
                    Arrttx[vt].setManhom(manhomxemoi);
                    break;
                case 2:
                    String tenxemoi;
                    System.out.print("Nhap lai ten xe: ");
                    tenxemoi=Nhapdsttx.nextLine();
                    Arrttx[vt].setTenxe(tenxemoi);
                    break;
                case 3:
                    int somaumoi;
                    System.out.print("Nhap lai so mau xe: ");
                    somaumoi=Integer.parseInt(Nhapdsttx.nextLine());
                    Arrttx[vt].setSomau(somaumoi);
                    break;
                case 4:
                    String thongsoxemoi;
                    System.out.print("Nhap lai thong so xe: ");
                    thongsoxemoi=Nhapdsttx.nextLine();
                    Arrttx[vt].setThongsoxe(thongsoxemoi);
                    break;
                case 5:
                    int baohanhmoi;
                    System.out.print("Nhap lai so nam bao hanh xe: ");
                    baohanhmoi=Integer.parseInt(Nhapdsttx.nextLine());
                    Arrttx[vt].setBaohanh(baohanhmoi);
                    break;
                case 6:
                    long gianhapmoi;
                    System.out.print("Nhap lai gia nhap xe: ");
                    gianhapmoi=Long.parseLong(Nhapdsttx.nextLine());
                    Arrttx[vt].setGianhap(gianhapmoi);
                    break;
                case 7:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach thong tin xe");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
            }
            System.out.println("Thong tin xe da sua!!!");
            Arrttx[vt].XuatTtx();
        }
        while(tieptuc);
    }
    
    public boolean kiemTraManhom(String manhom){
        for(int i=0;i<n;i++)
            if(Arrttx[i].getManhom().equals(manhom)==true)
                return true;
        return false;
    }
    
    public boolean kiemTraTenxe(String tenxe){
        for(int i=0;i<n;i++)
            if(Arrttx[i].getTenxe().equals(tenxe)==true)
                return true;
        return false;
    }
    
    public long Laygianhap(String manhom){
        long tiennhap=0;
        for(int i=0;i<n;i++)
            if(Arrttx[i].getManhom().equals(manhom)==true)
                tiennhap=Arrttx[i].getGianhap();
        return tiennhap;
    }
    
    @Override
    public void docfile() throws IOException{
        FileInputStream fis = null;
        DataInputStream dis = null;
        n=0;
        try {
            fis=new FileInputStream("ThongTinXe.dat");
            dis=new DataInputStream(fis);
            try{
                while(true){
                    String manhom=dis.readUTF();
                    String tenxe=dis.readUTF();
                    int somau=dis.readInt();
                    String thongsoxe=dis.readUTF();
                    int baohanh=dis.readInt();
                    long gianhap=dis.readLong();
                    Arrttx[n]=new ThongTinXe(manhom,tenxe,somau,thongsoxe,baohanh,gianhap);
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
            FileOutputStream fos = new FileOutputStream("ThongTinXe.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            for(int i=0;i<n;i++){
                Arrttx[i].ghifile();
            }
            dos.close();
            fos.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
    