/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

/**
 *
 * @author HieuPhan
 */
public class ChiTietXe extends ThongTinXe{
    CheckLoi cl=new CheckLoi();
    public String maxe;
    public String loaixe;
    public int soluong;
    public long dongia;
    DecimalFormat format=new DecimalFormat("###,###,###,### VNĐ");
    Scanner Nhapctx=new Scanner(System.in);
    
    public ChiTietXe(){
        super();
        this.maxe=null;
        this.loaixe=null;
        this.soluong=0;
        this.dongia=0;
    }

    public ChiTietXe(String manhom,String maxe,String tenxe,String loaixe,int soluong,long dongia){
        this.manhom=manhom;
        this.maxe=maxe;
        this.tenxe=tenxe;
        this.loaixe=loaixe;
        this.soluong=soluong;
        this.dongia=dongia;
    }

    public void setMaxe(String maxe){
        this.maxe=maxe;
    }
    
    public void setLoaixe(String loaixe){
        this.loaixe=loaixe;
    }

    public void setDongia(long dongia){
        this.dongia=dongia;
    }
    
    public void setSoluong(int soluong){
        this.soluong=soluong;
    }

    public String getMaxe(){
        return maxe;
    }
    
    public String getLoaixe(){
        return loaixe;
    }

    public long getDongia(){
        return dongia;
    }
    
    public int getSoluong(){
        return soluong;
    }
    
    public void NhapCtx() throws IOException{
        DanhSachThongTinXe dsttx=new DanhSachThongTinXe();
        dsttx.docfile();
        DanhSachHoaDonNhap dshdn=new DanhSachHoaDonNhap();
        dshdn.docfile();
        System.out.print("Nhap ma xe: ");
        while(true){
            maxe=cl.kiemTraMaxe();
            if(dshdn.kiemTraMaxe(maxe)==true){
                break;
            }
            else{
                System.out.println("Ma xe khong co trong danh sach hoa don nhap");
                System.out.print("Nhap lai ma xe: ");
            }
        }
        manhom=dshdn.Laymanhom(maxe);
        soluong=dshdn.Laysoluong(maxe);
        dongia=(long)(dsttx.Laygianhap(manhom)+0.05*dsttx.Laygianhap(manhom));
        System.out.print("Nhap ten xe: ");
        tenxe=Nhapttx.nextLine();
        System.out.print("Nhap loai xe: ");
        loaixe=Nhapctx.nextLine();
    }
     
    public void XuatCtx(){
        System.out.printf("%-15s%-10s%-15s%-15s%-10s%-20s\n",manhom,maxe,tenxe,loaixe,soluong,format.format(dongia));
    }

    @Override
    public String toString() {
        return manhom+","+maxe+","+tenxe+","+loaixe+","+soluong+"\n"+dongia+"\n";
    } 

    public void ghifile() throws IOException{
        try { 
            FileOutputStream fos = new FileOutputStream("ChiTietXe.dat",true);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF(manhom);
            dos.writeUTF(maxe);
            dos.writeUTF(tenxe);
            dos.writeUTF(loaixe);
            dos.writeInt(soluong);
            dos.writeLong(dongia);
            dos.close();
            fos.close();
        } 
        catch (FileNotFoundException e) {
                e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws IOException{
        ChiTietXe ctx=new ChiTietXe();
        ctx.NhapCtx();
        ctx.XuatCtx();
    }
}
