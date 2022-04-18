/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author HieuPhan
 */
public class MenuDanhSachKhachHang{
    CheckLoi check=new CheckLoi();
    DanhSachKhachHang dskh=new DanhSachKhachHang();
    Scanner Nhapmenudskh=new Scanner(System.in);
    
    public void ThemKhachHang() throws IOException{
        boolean tieptuc=false;
        do{
            System.out.println("++++++THEM KHACH HANG MOI++++++");
            System.out.println("1.Them moi mot khach hang");
            System.out.println("2.Them moi nhieu khach hang");
            System.out.println("3.Tro lai danh sach khach hang");
            System.out.println("==================================================");
            System.out.print("Chon hinh thuc ban muon them: ");
            int chonthem=check.kiemTraInt();
            while(chonthem>3 || chonthem<=0){
                System.out.println("Nhap sai cu phap!!!");
                System.out.println("==================================================");
                System.out.print("Chon lai hinh thuc ban muon them: ");
                chonthem=check.kiemTraInt();
            }
            switch(chonthem){
                case 1:
                    System.out.println("==================================================");
                    System.out.println("Ban chon them moi mot khach hang");
                    dskh.Them();
                    tieptuc=true;
                    break;
                case 2:
                    System.out.println("==================================================");
                    System.out.println("Ban chon them moi nhieu khach hang");
                    dskh.Themkphantu();
                    tieptuc=true;
                    break;
                case 3:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach nhan vien");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
            }
        }
        while(tieptuc);
    }
    
    public void TimKiemKhachHang()throws IOException{
        boolean tieptuc=true;
        do{
            System.out.println("++++++TIM KIEM KHACH HANG++++++");
            System.out.println("1.Tim kiem khach hang theo ma");
            System.out.println("2.Tim kiem khach hang theo ten");
            System.out.println("3.Tro lai danh sach khach hang");
            System.out.println("==================================================");
            System.out.print("Chon hinh thuc ban muon su dung: ");
            int chonthem=check.kiemTraInt();
            while(chonthem>3 || chonthem<=0){
                System.out.println("Nhap sai cu phap!!!");
                System.out.println("==================================================");
                System.out.print("Chon lai hinh thuc ban muon su dung: ");
                chonthem=check.kiemTraInt();
            }
            switch(chonthem){
                case 1:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem khach hang theo ma");
                    System.out.print("Nhap ma khach hang can tim: ");
                    String mkh;
                    while(true){
                        mkh=check.kiemTraMaKh();
                        if(dskh.kiemTraMaKh(mkh)==true){
                            dskh.TimKiemMa(mkh);
                            break;
                        }
                        else
                            System.out.println("Khong co ma nhan vien can tim");
                    }
                    tieptuc=true;
                    break;
                case 2:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem khach hang theo ten");
                    System.out.print("Nhap ho ten khach hang can tim: ");
                    String tenkh;
                    while(true){
                        tenkh=check.kiemTraTenKh();
                        if(dskh.kiemTraTenKh(tenkh)==true){
                            dskh.TimKiemTen(tenkh);
                            break;
                        }
                        else
                            System.out.println("Khong co ten khach hang can tim");
                    }
                    tieptuc=true;
                    break;
                case 3:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach nhan vien");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
            }
        }
        while(tieptuc);
    }
    
    public void MenuDanhSachKhachHang() throws IOException{
        boolean tieptuc=false;
        do{
            System.out.println("++++++DANH SACH KHACH HANG++++++");
            System.out.println("1.Xuat danh sach khach hang");
            System.out.println("2.Them moi khach hang");
            System.out.println("3.Tim kiem khach hang");
            System.out.println("4.Xoa khach hang");
            System.out.println("5.Sua khach hang");
            System.out.println("6.Tro lai menu chinh");
            System.out.println("==================================================");
            System.out.print("Chon chuc nang ban muon su dung: ");
            int choose=check.kiemTraInt();
            while(choose>6 || choose<=0){
                System.out.println("Nhap sai cu phap!!!");
                System.out.println("==================================================");
                System.out.print("Chon lai hinh thuc ban muon them: ");
                choose=check.kiemTraInt();
            }
            switch(choose){
                case 1:
                    dskh.XuatDanhSach();
                    tieptuc=true;
                    break;
                case 2:
                    ThemKhachHang();
                    tieptuc=true;
                    break;
                case 3:
                    TimKiemKhachHang();
                    tieptuc=true;
                    break;
                case 4:
                    dskh.Xoa();
                    tieptuc=true;
                    break;
                case 5:
                    dskh.Sua();
                    tieptuc=true;
                    break;
                case 6:
                    System.out.println("Tro lai menu chinh");
                    tieptuc=false;
                    break;
            }
        }
        while(tieptuc);
    }
}

