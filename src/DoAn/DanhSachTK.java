/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author HieuPhan
 */
public class DanhSachTK implements DanhSach{
    private int n;
    private String biengian;
    private TaiKhoan[] mangTK = new TaiKhoan[100];
    Scanner sc=new Scanner(System.in);
    public DanhSachTK(){}
    public DanhSachTK(TaiKhoan[] mangTK,int n){
        this.mangTK=mangTK;
        this.n=n;
    }
    public DanhSachTK(DanhSachTK taikhoan1){
        mangTK=taikhoan1.mangTK;
        n=taikhoan1.n;
    }
    @Override
    public void NhapDanhSach()throws IOException{
        System.out.print("Nhap so luong tai khoan: ");
        n=Integer.parseInt(sc.nextLine());
        mangTK= new TaiKhoan[n];
        for(int i=0;i<n;i++){
            mangTK[i]=new TaiKhoan();
            mangTK[i].NhapTK();
            mangTK[i].ghifile();
        }
    }
    @Override
    public void XuatDanhSach()throws IOException{     
        System.out.println("Danh sach tai khoan: ");
        System.out.printf("%-9s%-22s%-8s\n","MSNV","Mat khau","Quyen");
        for(int i=0;i<n;i++)
            mangTK[i].XuatTK();
    }
    @Override
    public void Them() throws IOException{
        System.out.println("Nhap thong tin tai khoan can them : ");
        TaiKhoan tk = new TaiKhoan();
        tk.NhapTK();
        mangTK=Arrays.copyOf(mangTK,mangTK.length+1);
        mangTK[n]=tk;
        mangTK[n].ghifile();
        n++;
        
    }
    @Override
    public void Themkphantu() throws IOException{
        System.out.print("Nhap so luong tai khoan can them: ");
        int k=Integer.parseInt(sc.nextLine());
        for(int i=0;i<k;i++){
            int a=i+1;
            System.out.println("Nhan vien can them ("+a+"): ");
            Them();
        }
    }
    public void TimKiemMa(String mnvtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(mangTK[i].getMsnv().equals(mnvtim)==true){
                dem++;
                System.out.printf("%-9s%-22s%-8s\n","MSNV","Mat khau","Quyen");
                mangTK[i].XuatTK();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ma nhan vien!!!");
    }
     
    public int TimKiem(String ma){

        int vitri=-1;
        for(int i=0;i<n;i++)
            if(ma.compareTo(mangTK[i].getMsnv())== 0){
                vitri=i;
                break;
            }
        return vitri;
    }
    @Override
    public void Xoa() throws IOException{
        System.out.print("Nhap ma nhan vien can xoa: ");
        String manvxoa=sc.nextLine();
        int vt=TimKiem(manvxoa);
        if(vt == 0 ){
            System.out.println("Ban khong the xoa tai khoan ADMIN");
        }
        else{
            TaiKhoan[] arrxoa=new TaiKhoan[n];
            while(vt==-1){
                System.out.println("Khong tim thay ma tai khoan can xoa!!!");
                System.out.print("Nhap lai ma nhan vien can xoa: ");
                manvxoa=sc.nextLine();
                vt=TimKiem(manvxoa);
            }
            if(vt!=-1){
                arrxoa=Arrays.copyOf(mangTK,mangTK.length+1);
                for(int i=vt;i<n;i++)
                    mangTK[i]=arrxoa[i+1];
                n--;
            }
            System.out.println("Xoa thanh cong thong tin nhan vien!!!");}
    }
    public static boolean checkPassword(String str){
        return str.matches("^[a-zA-Z0-9]{8,20}");
    }
    public static boolean checkMsnv(String str){
        return str.matches("^[0-9]{6}");
    }
    public static boolean checkQuyen(String str){
        return str.matches("^[1-2]{1}");
    } 
    @Override
    public void Sua() {
        boolean tieptuc=false;
        System.out.print("Nhap ma nhan vien can sua thong tin: ");
        String manvsua=sc.nextLine();
        int vt=TimKiem(manvsua);
        while(vt==-1){
            System.out.println("Khong tim thay ma nhan vien can sua!!!");
            System.out.print("Nhap lai ma nhan vien can sua: ");
            manvsua=sc.nextLine();
            vt=TimKiem(manvsua);
        }
        do{
            System.out.println("++++++SUA THONG TIN TAI KHOAN++++++");    
            System.out.println("1.Thay doi quyen cua nhan vien");
            System.out.println("2.Thay doi mat khau cho nhan vien");
            System.out.println("0.De thoat ");
            System.out.print("Chon : ");
            String chonthaydoi = sc.nextLine();
            boolean check ;
            switch(chonthaydoi){
                case "1":
                    String Quyen;
                    check = false;
                    if(vt==0){
                        System.out.println("Khong the thay doi quyen ADMIN");
                    }
                    else {
                        while(check == false){
                            System.out.println("Nhap Quyen moi: ");
                            System.out.println("1. Nhan Vien ");
                            System.out.println("2. Quan Ly ");
                            System.out.print("Chon : ");
                            Quyen = sc.nextLine();
                            if(checkQuyen(Quyen)==true){
                                biengian = Quyen;
                                check = true;}
                            else {
                                System.out.println("Ki tu ban nhap khong hop le !!Thu lai !!\n");}
                        }
                        mangTK[vt].setQuyen(biengian);
                        if(vt!=0){
                            System.out.println("Thong tin nhan vien da sua!!!");
                            System.out.printf("%-9s%-22s%-8s\n","MSNV","Mat khau","Quyen");
                            mangTK[vt].XuatTK();}  
                    }
                    break;
                case "2":
                    String passmoi;
                    check = false;
                    while(check == false){
                        System.out.print("Nhap Mat Khau moi : ");
                        passmoi = sc.nextLine();
                        if(checkPassword(passmoi)==true){
                            biengian = passmoi;
                            check = true;}
                        else {
                            System.out.println("Vui long nhap mat khau 8 den 20 chu cai hoac so !!\n");}
                    }
                    mangTK[vt].setPassword(biengian);  
                    System.out.println("Thong tin nhan vien da sua!!!");
                    System.out.printf("%-9s%-22s%-8s\n","MSNV","Mat khau","Quyen");
                    mangTK[vt].XuatTK();  
                    break;
                case "0":
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach tai khoan");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
                default:
                    System.out.println("Ki tu nhap khong hop le! Vui long nhap lai");
                    break;
            }
            
        }
        while(tieptuc);
    }
    //////////////
    public boolean kiemTraManv(String manv){
        for(int i=0;i<n;i++)
            if(mangTK[i].getMsnv().equals(manv)==true)
                return true;
        return false;
    }    
    public boolean ktPass(String x,int y){
        if(mangTK[y].getPassword().equals(x))
            return true;
        return false;
    }
    public int LayQuyen(int x){
        int k = Integer.parseInt(mangTK[x].getQuyen());
        return k;
    }
    @Override
    public void docfile() throws IOException{
        FileInputStream fis = null;
        DataInputStream dis = null;
        n=0;
        try {
            fis=new FileInputStream("TaiKhoan.dat");
            dis=new DataInputStream(fis);
            try{
                while(true){
                    String masnv=dis.readUTF();
                    String Password=dis.readUTF();
                    String Quyen=dis.readUTF();
                    mangTK[n]= new TaiKhoan(masnv,Password,Quyen);
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
            FileOutputStream fos = new FileOutputStream("TaiKhoan.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            for(int i=0;i<n;i++){
                mangTK[i].ghifile();
            }
            dos.close();
            fos.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
