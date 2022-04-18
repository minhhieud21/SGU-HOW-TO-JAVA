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
public class MenuDanhSachChiTietXe {
    CheckLoi check=new CheckLoi();
    DanhSachXe dsx=new DanhSachXe();
    Scanner Nhapmenudsctx=new Scanner(System.in);
    
    public void ThemXe() throws IOException{
        boolean tieptuc=false;
        do{
            System.out.println("++++++THEM XE MOI++++++");
            System.out.println("1.Them moi mot xe");
            System.out.println("2.Them moi nhieu xe");
            System.out.println("3.Tro lai danh sach chi tiet xe");
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
                    System.out.println("Ban chon them moi mot xe");
                    dsx.Them();
                    tieptuc=true;
                    break;
                case 2:
                    System.out.println("==================================================");
                    System.out.println("Ban chon them moi nhieu xe");
                    dsx.Themkphantu();
                    tieptuc=true;
                    break;
                case 3:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach chi tiet xe");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
            }
        }
        while(tieptuc);
    }
    
    public void TimKiemXe() throws IOException{
        boolean tieptuc=true;
        do{
            System.out.println("++++++TIM KIEM XE++++++");
            System.out.println("1.Tim kiem xe theo ma nhom");
            System.out.println("2.Tim kiem xe theo ma xe");
            System.out.println("3.Tim kiem xe theo ten xe");
            System.out.println("4.Tro lai danh sach chi tiet xe");
            System.out.println("==================================================");
            System.out.print("Chon hinh thuc ban muon su dung: ");
            int chonthem=check.kiemTraInt();
            while(chonthem>4 || chonthem<=0){
                System.out.println("Nhap sai cu phap!!!");
                System.out.println("==================================================");
                System.out.print("Chon lai hinh thuc ban muon su dung: ");
                chonthem=check.kiemTraInt();
            }
            switch(chonthem){
                case 1:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem xe theo ma nhom");
                    System.out.print("Nhap ma nhom can tim: ");
                    String manhom;
                    while(true){
                        manhom=check.kiemTraManhom();
                        if(dsx.kiemTraNhomxe(manhom)==true){
                            dsx.TimKiemNhom(manhom);
                            break;
                        }
                        else
                            System.out.println("Khong co ma nhom can tim");
                    }
                    tieptuc=true;
                    break;
                case 2:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem xe theo ma xe");
                    System.out.print("Nhap ma xe can tim: ");
                    String maxe;
                    while(true){
                        maxe=check.kiemTraMaxe();
                        if(dsx.kiemTraMaxe(maxe)==true){
                            dsx.TimKiemMa(maxe);
                            break;
                        }
                        else
                            System.out.println("Khong co ma xe can tim");
                    }
                    tieptuc=true;
                    break;
                case 3:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem xe theo ten xe");
                    System.out.print("Nhap ten xe can tim: ");
                    String tenxe;
                    while(true){
                        tenxe=Nhapmenudsctx.nextLine();
                        if(dsx.kiemTraTenxe(tenxe)==true){
                            dsx.TimKiemTen(tenxe);
                            break;
                        }
                        else
                            System.out.println("Khong co ten xe can tim");
                    }
                    tieptuc=true;
                    break;    
                case 4:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach chi tiet xe");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
            }
        }
        while(tieptuc);
    }
    
    public void MenuDanhSachXe() throws IOException{
        boolean tieptuc=false;
        do{
            System.out.println("==================================================");
            System.out.println("++++++DANH SACH CHI TIET XE++++++");
            System.out.println("1.Xuat danh sach chi tiet xe");
            System.out.println("2.Cap nhat so luong");
            System.out.println("3.Them moi chi tiet xe");
            System.out.println("4.Tim kiem chi tiet xe");
            System.out.println("5.Xoa chi tiet xe");
            System.out.println("6.Sua chi tiet xe");
            System.out.println("7.Tro lai menu chinh");
            System.out.println("==================================================");
            System.out.print("Chon chuc nang ban muon su dung: ");
            int choose=check.kiemTraInt();
            while(choose>7 || choose<=0){
                System.out.println("Nhap sai cu phap!!!");
                System.out.println("==================================================");
                System.out.print("Chon lai hinh thuc ban muon them: ");
                choose=check.kiemTraInt();
            }
            switch(choose){
                case 1:
                    dsx.XuatDanhSach();
                    tieptuc=true;
                    break;
                case 2:    
                    dsx.CapnhatSoluong();
                    dsx.XuatDanhSach();
                    tieptuc=true;
                    break;
                case 3:
                    ThemXe();
                    tieptuc=true;
                    break;
                case 4:
                    TimKiemXe();
                    tieptuc=true;
                    break;
                case 5:
                    dsx.Xoa();
                    tieptuc=true;
                    break;
                case 6:
                    dsx.Sua();
                    tieptuc=true;
                    break;
                case 7:
                    System.out.println("Tro lai menu chinh");
                    tieptuc=false;
                    break;
            }
        }
        while(tieptuc);
    }
}
