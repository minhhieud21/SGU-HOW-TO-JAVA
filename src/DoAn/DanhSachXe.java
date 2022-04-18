/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn;

import java.io.*;
import java.text.*;
import java.util.*;

/**
 *
 * @author HieuPhan
 */
public class DanhSachXe implements DanhSach{
    CheckLoi cl=new CheckLoi();
    private int n;
    private ChiTietXe[] Arrctx = new ChiTietXe[100];
    Scanner Nhapdsctx=new Scanner(System.in);
     
    public DanhSachXe(){
    }
    
    public DanhSachXe(ChiTietXe[] Arrctx,int n){
        this.Arrctx=Arrctx;
        this.n=n;
    }
    
    public DanhSachXe(DanhSachXe xe){
        Arrctx=xe.Arrctx;
        n=xe.n;
    }
    
    @Override
    public void NhapDanhSach() throws IOException{
        System.out.print("Nhap so luong xe: ");
        n=cl.kiemTraSoLuong();
        Arrctx= new ChiTietXe[n];
        for(int i=0;i<n;i++){
            Arrctx[i]=new ChiTietXe();
            Arrctx[i].NhapCtx();
            Arrctx[i].ghifile();
        }
    }
    
    @Override
    public void XuatDanhSach() throws IOException{
        System.out.println("Danh sach xe: ");
        System.out.printf("%-15s%-10s%-15s%-15s%-10s%-20s\n","Ma nhom xe","Ma xe","Ten xe","Loai xe","So luong","Don gia");
        for(int i=0;i<n;i++)
            Arrctx[i].XuatCtx();
    }
    
    @Override
    public void Them() throws IOException{
        System.out.println("Nhap thong tin xe can them : ");
        ChiTietXe ctx = new ChiTietXe();
        ctx.NhapCtx();
        Arrctx=Arrays.copyOf(Arrctx,Arrctx.length+1);
        Arrctx[n]=ctx;
//        Arrctx[n].ghifile();
        n++;
    }
    
    @Override
    public void Themkphantu() throws IOException{
        System.out.print("Nhap so luong xe can them: ");
        int k=cl.kiemTraSoLuong();
        for(int i=0;i<k;i++){
            int a=i+1;
            System.out.println("Xe can them ("+a+"): ");
            Them();
        }
    }
    
    public void TimKiemNhom(String nhomxetim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrctx[i].getManhom().equals(nhomxetim)==true){
                dem++;
                Arrctx[i].XuatCtx();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay nhom xe!!!");
    }
    
    public void TimKiemMa(String maxetim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrctx[i].getMaxe().equals(maxetim)==true){
                dem++;
                Arrctx[i].XuatCtx();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ma xe!!!");
    }
    
    public void TimKiemTen(String tenxetim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrctx[i].getTenxe().equals(tenxetim)==true){
                dem++;
                Arrctx[i].XuatCtx();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ten xe!!!");
    }
    
    public int TimKiem(String ma){
        int vitri=-1;
        for(int i=0;i<n;i++)
            if(ma.compareTo(Arrctx[i].getMaxe())==0){
                vitri=i;
                break;
            }
        return vitri;
    }
    
    @Override
    public void Xoa() throws IOException{
        System.out.print("Nhap ma xe can xoa: ");
        String maxexoa=cl.kiemTraMaxe();
        int vt=TimKiem(maxexoa);
        ChiTietXe[] arrxoa=new ChiTietXe[n];
        while(vt==-1){
            System.out.println("Khong tim thay ma xe can xoa!!!");
            System.out.print("Nhap lai ma xe can xoa: ");
            maxexoa=cl.kiemTraMaxe();
            vt=TimKiem(maxexoa);
        }
        if(vt!=-1){
            arrxoa=Arrays.copyOf(Arrctx,Arrctx.length+1);
            for(int i=vt;i<n;i++)
                Arrctx[i]=arrxoa[i+1];
            n--;
        }
        System.out.println("Xoa thanh cong thong tin chi tiet xe!!!");
    }
    
    @Override
    public void Sua() throws IOException{
        boolean tieptuc=false;
        System.out.print("Nhap ma xe can sua thong tin chi tiet: ");
        String maxesua=cl.kiemTraMaxe();
        int vt=TimKiem(maxesua);
        while(vt==-1){
            System.out.println("Khong tim thay ma xe can sua!!!");
            System.out.print("Nhap lai ma xe can sua: ");
            maxesua=cl.kiemTraMaxe();
            vt=TimKiem(maxesua);
        }
        do{
            System.out.println("++++++SUA THONG TIN CHI TIET XE++++++");
            System.out.println("1.Thay doi ma xe");
            System.out.println("2.Thay doi ten xe");     
            System.out.println("3.Thay doi loai xe");
            System.out.println("4.Tro lai danh sach chi tiet xe");
            System.out.print("Chon thong tin ban muon sua: ");
            int chonthaydoi=cl.kiemTraInt();
            while(chonthaydoi>4 || chonthaydoi<=0){
                System.out.println("Nhap sai cu phap!!!");
                System.out.println("==================================================");
                System.out.print("Chon lai thong tin ban muon sua: ");
                chonthaydoi=cl.kiemTraInt();
            }
            switch(chonthaydoi){
                case 1:
                    DanhSachThongTinXe dsttx=new DanhSachThongTinXe();
                    dsttx.docfile();
                    DanhSachHoaDonNhap dshdn=new DanhSachHoaDonNhap();
                    dshdn.docfile();
                    String maxemoi;
                    do{
                        System.out.print("Nhap lai ma xe: ");
                        maxemoi=cl.kiemTraMaxe();
                        if(-1 != TimKiem(maxemoi))
                            System.out.println("Ma xe da ton tai!!!");
                        else
                            break;
                    }
                    while(true);
                    Arrctx[vt].setMaxe(maxemoi);
                    String manhom=dshdn.Laymanhom(maxemoi);
                    int soluong=dshdn.Laysoluong(maxemoi);
                    long dongia=(long)(dsttx.Laygianhap(manhom)+0.05*dsttx.Laygianhap(manhom));
                    Arrctx[vt].setManhom(manhom);
                    Arrctx[vt].setSoluong(soluong);
                    Arrctx[vt].setDongia(dongia);
                    break;
                case 2:
                    String tenxemoi;
                    System.out.print("Nhap lai ten xe: ");
                    tenxemoi=Nhapdsctx.nextLine();
                    Arrctx[vt].setTenxe(tenxemoi);
                    break;
                case 3:
                    String loaixemoi;
                    System.out.print("Nhap lai loai xe: ");
                    loaixemoi=Nhapdsctx.nextLine();
                    Arrctx[vt].setLoaixe(loaixemoi);
                    break;
                case 4:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach chi tiet xe");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
            }
            System.out.println("Thong tin xe da sua!!!");
            Arrctx[vt].XuatCtx();
        }
        while(tieptuc);
    }
    
    public void CapnhatSoluong() throws IOException{
        DanhSachHoaDonNhap dshdn=new DanhSachHoaDonNhap();
        dshdn.docfile();
        DanhSachHoaDonXuat dshdx=new DanhSachHoaDonXuat();
        dshdx.docfile();
        String layma;
        int soluongmoi;
        for(int i=0;i<n;i++){
            layma=Arrctx[i].getMaxe();
            soluongmoi=dshdn.Laysoluong(layma)-dshdx.Laysoluong(layma);
            Arrctx[i].setSoluong(soluongmoi);
        }
    }
    
    public boolean kiemTraNhomxe(String manhom){
	for(int i=0; i < n; i++){
            if(Arrctx[i].getManhom().equals(manhom) == true)
		return true;
	}
	return false;
    }
    
    public boolean kiemTraMaxe(String maxe){
	for(int i = 0; i < n; i++){
            if(Arrctx[i].getMaxe().equals(maxe) == true)
		return true;
	}
	return false;
    }

    public boolean kiemTraTenxe(String ten){
	for(int i = 0; i < n; i++){
            if(Arrctx[i].getTenxe().equals(ten) == true){
		return true;
            }
	}
	return false;
    }
    
    public int Laysoluong(String maxe){
        int soluong=0;
        for(int i = 0; i < n; i++)
            if(Arrctx[i].getMaxe().equals(maxe)==true)
                soluong=Arrctx[i].getSoluong();
        return soluong;           
    }
    
    public long Laygiaban(String maxe){
        long giaban=0;
        for(int i = 0; i < n; i++)
            if(Arrctx[i].getMaxe().equals(maxe)==true)
                giaban=Arrctx[i].getDongia();
        return giaban;     
    }
    
    @Override
    public void docfile() throws IOException{
        FileInputStream fis = null;
        DataInputStream dis = null;
        n=0;
        try {
            fis=new FileInputStream("ChiTietXe.dat");
            dis=new DataInputStream(fis);
            try{
                while(true){
                    String manhom=dis.readUTF();
                    String maxe=dis.readUTF();
                    String tenxe=dis.readUTF();
                    String loaixe=dis.readUTF();
                    int soluong=dis.readInt();
                    long dongia=dis.readLong();
                    Arrctx[n]=new ChiTietXe(manhom,maxe,tenxe,loaixe,soluong,dongia);
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
            FileOutputStream fos = new FileOutputStream("ChiTietXe.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            for(int i=0;i<n;i++){
                Arrctx[i].ghifile();
            }
            dos.close();
            fos.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
