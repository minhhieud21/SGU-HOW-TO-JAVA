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
public class DanhSachNhaPhanPhoi implements DanhSach{
    CheckLoi cl=new CheckLoi();
    private int n;
    private NhaPhanPhoi[] Arrnpp = new NhaPhanPhoi[100];
    Scanner Nhapdsnpp=new Scanner(System.in);
    
    public DanhSachNhaPhanPhoi(){
    }
    
    public DanhSachNhaPhanPhoi(NhaPhanPhoi[] Arrnpp,int n){
        this.Arrnpp=Arrnpp;
        this.n=n;
    }
    
    public DanhSachNhaPhanPhoi(DanhSachNhaPhanPhoi nhaphanphoi){
        Arrnpp=nhaphanphoi.Arrnpp;
        n=nhaphanphoi.n;
    }
    
    @Override
    public void NhapDanhSach()throws IOException{
        System.out.print("Nhap so luong nha phan phoi: ");
        n=cl.kiemTraSoLuong();
        Arrnpp= new NhaPhanPhoi[n];
        for(int i=0;i<n;i++){
            Arrnpp[i]=new NhaPhanPhoi();
            Arrnpp[i].NhapNpp();
            Arrnpp[i].ghifile();
        }
    }
    
    @Override
    public void XuatDanhSach()throws IOException{     
        System.out.println("Danh sach nha phan phoi: ");
        System.out.printf("%-25s%-25s%-15s%-25s\n","Ma nha phan phoi","Ten nha phan phoi","Dien thoai","Dia chi");
            for(int i=0;i<n;i++)
                Arrnpp[i].XuatNpp();
    }
    
    public void Them() throws IOException{
        System.out.println("Nhap thong tin nha phan phoi can them : ");
        NhaPhanPhoi npp = new NhaPhanPhoi();
        npp.NhapNpp();
        Arrnpp=Arrays.copyOf(Arrnpp,Arrnpp.length+1);
        Arrnpp[n]=npp;
//        Arrnpp[n].ghifile();
        n++;
    }
    
    @Override
    public void Themkphantu() throws IOException{
        System.out.print("Nhap so luong nha phan phoi can them: ");
        int k=cl.kiemTraSoLuong();
        for(int i=0;i<k;i++){
            int a=i+1;
            System.out.println("Nha phan phoi can them ("+a+"): ");
            Them();
        }
    }
    
    public void TimKiemMa(String mnpptim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrnpp[i].getMnpp().equals(mnpptim)==true){
                dem++;
                Arrnpp[i].XuatNpp();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ma nha phan phoi!!!");
    }
    
    public void TimKiemTen(String tennpptim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrnpp[i].getTennpp().equals(tennpptim)==true){
                dem++;
                Arrnpp[i].XuatNpp();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ten nha phan phoi!!!");
    }
    
    public int TimKiem(String ma){
        int vitri=-1;
        for(int i=0;i<n;i++)
            if(ma.compareTo(Arrnpp[i].getMnpp())==0){
                vitri=i;
                break;
            }
        return vitri;
    }
    
    @Override
    public void Xoa() throws IOException{
        System.out.print("Nhap ma nha phan phoi can xoa: ");
        String manppxoa=cl.kiemTraManpp();
        int vt=TimKiem(manppxoa);
        NhaPhanPhoi[] arrxoa=new NhaPhanPhoi[n];
        while(vt==-1){
            System.out.println("Khong tim thay ma nha phan phoi can xoa!!!");
            System.out.print("Nhap lai ma nha phan phoi can xoa: ");
            manppxoa=cl.kiemTraManpp();
            vt=TimKiem(manppxoa);
        }
        if(vt!=-1){
            arrxoa=Arrays.copyOf(Arrnpp,Arrnpp.length+1);
            for(int i=vt;i<n;i++)
                Arrnpp[i]=arrxoa[i+1];
            n--;
        }
        System.out.println("Xoa thanh cong thong tin nha phan phoi!!!");
    }
    
    @Override
    public void Sua(){
        boolean tieptuc=false;
        System.out.print("Nhap ma nha phan phoi can sua thong tin: ");
        String manppsua=cl.kiemTraManpp();
        int vt=TimKiem(manppsua);
        while(vt==-1){
            System.out.println("Khong tim thay ma nha phan phoi can sua!!!");
            System.out.print("Nhap lai ma nha phan phoi can sua: ");
            manppsua=cl.kiemTraManpp();
            vt=TimKiem(manppsua);
        }
        do{
            System.out.println("++++++SUA THONG TIN NHA PHAN PHOI++++++");
            System.out.println("1.Thay doi ma nha phan phoi");
            System.out.println("2.Thay doi ten nha phan phoi");
            System.out.println("3.Thay doi so dien thoai nha phan phoi");
            System.out.println("4.Thay doi dia chi nha phan phoi");
            System.out.println("5.Tro lai danh sach nha phan phoi");
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
                    String manhaphanphoimoi;
                    do{
                        System.out.print("Nhap lai ma nha phan phoi: ");
                        manhaphanphoimoi=cl.kiemTraManpp();
                        if(-1 != TimKiem(manhaphanphoimoi))
                            System.out.println("Ma nha phan phoi da ton tai!!!");
                        else
                            break;
                    }
                    while(true);
                    Arrnpp[vt].setMnpp(manhaphanphoimoi);
                    break;
                case 2:
                    String tennhaphanphoimoi;
                    System.out.print("Nhap lai ten nha phan phoi: ");
                    tennhaphanphoimoi=Nhapdsnpp.nextLine();
                    Arrnpp[vt].setTennpp(tennhaphanphoimoi);
                    break;
                case 3:
                    String dienthoaimoi;
                    System.out.print("Nhap lai so dien thoai: ");
                    dienthoaimoi=cl.kiemTraSdt();
                    Arrnpp[vt].setDienthoai(dienthoaimoi);
                    break;
                case 4:
                    String diachimoi;
                    System.out.print("Nhap lai dia chi: ");
                    diachimoi=Nhapdsnpp.nextLine();
                    Arrnpp[vt].setDiachi(diachimoi);
                    break;
                case 5:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach nha pohan phoi");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
            }
            System.out.println("Thong tin nha phan phoi da sua!!!");
            Arrnpp[vt].XuatNpp();
        }
        while(tieptuc);
    }
    
    public boolean kiemTraMnpp(String mnpp){
        for(int i=0;i<n;i++)
            if(Arrnpp[i].getMnpp().equals(mnpp)==true)
                return true;
        return false;
    }
    
    public boolean kiemTraTennpp(String tennpp){
        for(int i=0;i<n;i++)
            if(Arrnpp[i].getTennpp().equals(tennpp)==true)
                return true;
        return false;
    }
    
    @Override
    public void docfile() throws IOException{
        FileInputStream fis = null;
        DataInputStream dis = null;
        n=0;
        try {
            fis=new FileInputStream("NhaPhanPhoi.dat");
            dis=new DataInputStream(fis);
            try{
                while(true){
                    String mnpp=dis.readUTF();
                    String tennpp=dis.readUTF();
                    String dienthoai=dis.readUTF();
                    String diachi=dis.readUTF();
                    Arrnpp[n]=new NhaPhanPhoi(mnpp,tennpp,dienthoai,diachi);
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
            FileOutputStream fos = new FileOutputStream("NhaPhanPhoi.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            for(int i=0;i<n;i++){
                Arrnpp[i].ghifile();
            }
            dos.close();
            fos.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}