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
public class DanhSachKhachHang implements DanhSach {
    CheckLoi cl=new CheckLoi();
    private int n;
    private KhachHang[] Arrkh = new KhachHang[100];
    Scanner Nhapdskh=new Scanner(System.in);
     
    public DanhSachKhachHang(){
    }
    
    public DanhSachKhachHang(KhachHang[] Arrkh,int n){
        this.Arrkh=Arrkh;
        this.n=n;
    }
    
    public DanhSachKhachHang(DanhSachKhachHang khachhang){
        Arrkh=khachhang.Arrkh;
        n=khachhang.n;
    }
    
    @Override
    public void NhapDanhSach() throws IOException{
        System.out.print("Nhap so luong khach hang: ");
        n=cl.kiemTraSoLuong();
        Arrkh= new KhachHang[n];
        for(int i=0;i<n;i++){
            Arrkh[i]=new KhachHang();
            Arrkh[i].NhapKh();
            Arrkh[i].ghifile();
        }
    }
    
    @Override
    public void XuatDanhSach() throws IOException{
        System.out.println("Danh sach khach hang: ");
        System.out.printf("%-15s%-25s%-20s%-15s%-15s\n","Ma khach hang","Ho ten","Loai giao dich","Dia chi","So dien thoai");
        for(int i=0;i<n;i++)
            Arrkh[i].XuatKh();
    }
    
    @Override
    public void Them() throws IOException{
        System.out.println("Nhap thong tin khach hang can them: ");
        KhachHang kh = new KhachHang();
        kh.NhapKh();
        Arrkh=Arrays.copyOf(Arrkh,Arrkh.length+1);
        Arrkh[n]=kh;
//        Arrkh[n].ghifile();
        n++;
    }
    
    @Override
    public void Themkphantu() throws IOException{
        System.out.print("Nhap so luong khach hang can them: ");
        int k=cl.kiemTraSoLuong();
        for(int i=0;i<k;i++){
            int a=i+1;
            System.out.println("Khach hang can them ("+a+"): ");
            Them();
        }
    }
    
    public void TimKiemMa(String manvtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrkh[i].getMakh().equals(manvtim)==true){
                dem++;
                Arrkh[i].XuatKh();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ma khach hang!!!");
    }
    
    public void TimKiemTen(String tennvtim){
        int dem=0;
        for(int i=0;i<n;i++){
            if(Arrkh[i].getHoten().equals(tennvtim)==true){
                dem++;
                Arrkh[i].XuatKh();
            }
        }
        if(dem==0)
            System.out.println("Khong tim thay ten Khach hang!!!");
    }
    
    public int TimKiem(String ma){
        int vitri=-1;
        for(int i=0;i<n;i++)
            if(ma.compareTo(Arrkh[i].getMakh())==0){
                vitri=i;
                break;
            }
        return vitri;
    }
    
    @Override
    public void Xoa() throws IOException{
        System.out.print("Nhap ma khach hang can xoa: ");
        String makhxoa=cl.kiemTraMaKh();
        int vt=TimKiem(makhxoa);
        KhachHang[] arrxoa=new KhachHang[n];
        while(vt==-1){
            System.out.println("Khong tim thay ma khach hang can xoa!!!");
            System.out.print("Nhap lai ma khach hang can xoa: ");
            makhxoa=cl.kiemTraMaKh();
            vt=TimKiem(makhxoa);
        }
        if(vt!=-1){
            arrxoa=Arrays.copyOf(Arrkh,Arrkh.length+1);
            for(int i=vt;i<n;i++)
                Arrkh[i]=arrxoa[i+1];
            n--;
        }
        System.out.println("Xoa thanh cong thong tin khach hang!!!");
    }
    
    @Override
    public void Sua(){
        boolean tieptuc=false;
        System.out.print("Nhap ma khach hang can sua thong tin: ");
        String makhsua=cl.kiemTraMaKh();;
        int vt=TimKiem(makhsua);
        while(vt==-1){
            System.out.println("Khong tim thay ma khach hang can sua!!!");
            System.out.print("Nhap lai ma khach hang can sua: ");
            makhsua=cl.kiemTraMaKh();;
            vt=TimKiem(makhsua);
        }
        do{
            System.out.println("++++++SUA KHACH HANG++++++");
            System.out.println("1.Thay doi ho ten khach hang");
            System.out.println("2.Thay doi loai giao dich khach hang");
            System.out.println("3.Thay doi dia chi khach hang");
            System.out.println("4.Thay doi so dien thoai khach hang");
            System.out.println("5.Tro lai danh sach khach hang ");
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
                    String hotenmoi;
                    System.out.print("Nhap lai ho ten khach hang: ");
                    hotenmoi=cl.kiemTraTenKh();
                    Arrkh[vt].setHoten(hotenmoi);
                    break;
                case 2:
                    System.out.println("Chon hinh thuc giao dich: ");
                    System.out.println("\t1.Mua xe");
                    System.out.println("\t2.Sua chua");
                    System.out.print("Chon: ");
                    int chonchucvu=cl.kiemTraInt();
                    while(chonchucvu>3 || chonchucvu<=0){
                        System.out.println("Chon sai cu phap!!!");
                        System.out.print("Chon lai hinh thuc giao dich: ");
                        chonchucvu=cl.kiemTraInt();
                    }
                    switch(chonchucvu){
                        case 1:
                            System.out.println("Hinh thuc giao dich: Mua xe");
                            Arrkh[vt].setLoaigd("Mua xe");
                            break;
                        case 2:
                            System.out.println("Hinh thuc giao dich: Sua chua");
                            Arrkh[vt].setLoaigd("Sua chua");
                            break;
                    }
                case 3:
                    String diachimoi;
                    System.out.print("Nhap lai dia chi khach hang: ");
                    diachimoi=Nhapdskh.nextLine();
                    Arrkh[vt].setDiachi(diachimoi);
                    break;
                case 4:
                    String dienthoaimoi;
                    System.out.print("Nhap lai so dien thoai khach hang: ");
                    dienthoaimoi=cl.kiemTraSdt();
                    Arrkh[vt].setSdt(dienthoaimoi);
                    break;
                case 8:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach khach hang ");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
            }
            System.out.println("Thong tin khach hang da sua!!!");
            Arrkh[vt].XuatKh();
        }
        while(tieptuc);
    }
    
    public boolean kiemTraMaKh(String makh){
	for(int i = 0; i < n; i++){
            if(Arrkh[i].getMakh().equals(makh) == true)
		return true;
	}
	return false;
    }

    public boolean kiemTraTenKh(String ten){
	for(int i = 0; i < n; i++){
            if(Arrkh[i].getHoten().equals(ten) == true){
		return true;
            }
	}
	return false;
    }
    
    public boolean kiemTraMuaxe(String makh){
        for(int i=0;i<n;i++)
            if(Arrkh[i].getMakh().equals(makh)==true)
                if(Arrkh[i].getLoaigd().equals("Mua xe")==true)
                    return true;
        return false;
    }
    
    @Override
    public void docfile() throws IOException{
        FileInputStream fis = null;
        DataInputStream dis = null;
        n=0;
        try {
            fis=new FileInputStream("KhachHang.dat");
            dis=new DataInputStream(fis);
            try{
                while(true){
                    String makh=dis.readUTF();
                    String hoten=dis.readUTF();
                    String loaigd=dis.readUTF();
                    String diachi=dis.readUTF();
                    String sdt=dis.readUTF();
                    Arrkh[n]=new KhachHang(makh,hoten,loaigd,diachi,sdt);
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
            FileOutputStream fos = new FileOutputStream("KhachHang.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            for(int i=0;i<n;i++){
                Arrkh[i].ghifile();
            }
            dos.close();
            fos.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
