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
public class ThongTinXe{
    CheckLoi cl=new CheckLoi();
    public String manhom;
    public String tenxe;
    public int somau;
    public String thongsoxe;
    public static int baohanh=3;
    public long gianhap;
    DecimalFormat format=new DecimalFormat("###,###,###,### VND");
    Scanner Nhapttx=new Scanner(System.in);
    
    public ThongTinXe(){
        this.manhom=null;
        this.tenxe=null;
        this.somau=0;
        this.thongsoxe=null;
        this.gianhap=0;
    }

    public ThongTinXe(String manhom,String tenxe,int somau,String thongsoxe,int baohanh,long gianhap){
        this.manhom=manhom;
        this.tenxe=tenxe;
        this.somau=somau;
        this.thongsoxe=thongsoxe;
        this.baohanh=baohanh;
        this.gianhap=gianhap;
    }

    public void setManhom(String manhom){
        this.manhom=manhom;
    }

    public void setTenxe(String tenxe){
        this.tenxe=tenxe;
    }

    public void setSomau(int somau){
        this.somau=somau;
    }

    public void setThongsoxe(String thongsoxe){
        this.thongsoxe=thongsoxe;
    }

    public void setBaohanh(int baohanh){
        this.baohanh=baohanh;
    }
    
    public void setGianhap(long gianhap){
        this.gianhap=gianhap;
    }
    
    public String getManhom(){
        return manhom;
    }
    
    public String getTenxe(){
        return tenxe;
    }
    
    public int getSomau(){
        return somau;
    }
    
    public String getThongsoxe(){
        return thongsoxe;
    }
    
    public int getBaohanh(){
        return baohanh;
    }
    
    public long getGianhap(){
        return gianhap;
    }
    
    public void NhapTtx(){
        System.out.print("Nhap ma nhom xe: ");
        manhom=cl.kiemTraManhom();
        System.out.print("Nhap ten xe: ");
        tenxe=Nhapttx.nextLine();
        System.out.print("Nhap so mau xe: ");
        somau=Integer.parseInt(Nhapttx.nextLine());
        System.out.print("Nhap loai xe: ");
        thongsoxe=Nhapttx.nextLine();
        System.out.print("Nhap gia nhap xe: ");
        gianhap=Long.parseLong(Nhapttx.nextLine());
    }
    
    public void XuatTtx(){
        System.out.printf("%-10s%-20s%-10s%-15s%-10s%-20s\n",manhom,tenxe,somau,thongsoxe,baohanh,format.format(gianhap));
    }
    
    @Override
    public String toString() {
        return manhom+","+tenxe+","+somau+","+thongsoxe+","+baohanh+","+gianhap;
    }
    
    public void ghifile() throws IOException{
        try { 
            FileOutputStream fos = new FileOutputStream("ThongTinXe.dat",true);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF(manhom);
            dos.writeUTF(tenxe);
            dos.writeInt(somau);
            dos.writeUTF(thongsoxe);
            dos.writeInt(baohanh);
            dos.writeLong(gianhap);
            dos.close();
            fos.close();
        } 
        catch (FileNotFoundException e) {
                e.printStackTrace();
        }
    }
}
