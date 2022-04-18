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
import java.util.Scanner;

/**
 *
 * @author HieuPhan
 */
public class KhachHang extends ConNguoi{
    CheckLoi cl=new CheckLoi();
    public String makh;
    public String loaigd;
    public static int demkh=200100;
    Scanner nhapkh = new Scanner(System.in);
    
    public KhachHang(){      
        this.makh=null;
        this.hoten=null;
        this.loaigd=null;
        this.diachi=null;
        this.sdt=null;
        demkh++;
    }
    
    public KhachHang(String makh,String hoten,String loaigd,String diachi,String sdt){
        this.makh=makh;
        this.hoten=hoten;
        this.loaigd=loaigd;
        this.diachi=diachi;
        this.sdt=sdt;
        demkh++;
    }

    public void setMakh(String makh){
        this.makh=makh;
    }

    public void setLoaigd(String loaigd){
        this.loaigd=loaigd;
    }

    public String getMakh(){
        return makh;
    }

    public String getLoaigd(){
        return loaigd;
    }
    
    public void NhapKh(){
        System.out.println("Nhap thong tin khach hang: ");
        makh=String.valueOf(demkh);
        System.out.print("Nhap ho ten khach hang: ");
        hoten=cl.kiemTraTenKh();
        System.out.println("Chon hinh thuc giao dich: ");
        System.out.println("\t1.Mua xe");
        System.out.println("\t2.Sua chua");
        System.out.print("Chon: ");
        int chonchucvu=cl.kiemTraInt();
        while(chonchucvu>2 || chonchucvu<=0){
            System.out.println("Chon sai cu phap!!!");
            System.out.print("Chon lai hinh thuc giao dich: ");
            chonchucvu=cl.kiemTraInt();
        }
        switch(chonchucvu){
            case 1:
                System.out.println("Hinh thuc giao dich: Mua xe");
                loaigd="Mua xe";
                break;
            case 2:
                System.out.println("Hinh thuc giao dich: Sua chua");
                loaigd="Sua chua";
                break;
        }
        System.out.print("Nhap dia chi khach hang: ");
        diachi=nhapkh.nextLine();
        System.out.print("Nhap so dien thoai khach hang: ");
        sdt=cl.kiemTraSdt();
    }
    
    public void XuatKh(){
        System.out.printf("%-15s%-25s%-20s%-15s%-15s\n",makh,hoten,loaigd,diachi,sdt);
    }
    
    public void ghifile() throws IOException{
        try { 
            FileOutputStream fos = new FileOutputStream("KhachHang.dat",true);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF(makh);
            dos.writeUTF(hoten);
            dos.writeUTF(loaigd);
            dos.writeUTF(diachi);
            dos.writeUTF(sdt);
            dos.close();
            fos.close();
       	} 
        catch (FileNotFoundException e) {
                e.printStackTrace();
        }
    }
}
