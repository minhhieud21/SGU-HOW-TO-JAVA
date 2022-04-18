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
public class MenuDanhSachThongTinXe{
    CheckLoi check=new CheckLoi();
    DanhSachThongTinXe dsttx=new DanhSachThongTinXe();
    Scanner Nhapmenudsttx=new Scanner(System.in);
    
    public void ThemThongTinXe() throws IOException{
        boolean tieptuc=false;
        do{
            System.out.println("++++++THEM THONG TIN XE MOI++++++");
            System.out.println("1.Them moi mot thong tin xe");
            System.out.println("2.Them moi nhieu thong tin xe");
            System.out.println("3.Tro lai danh sach nha phan phoi");
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
                    System.out.println("Ban chon them moi mot thong tin xe");
                    dsttx.Them();
                    tieptuc=true;
                    break;
                case 2:
                    System.out.println("==================================================");
                    System.out.println("Ban chon them moi nhieu thong tin xe");
                    dsttx.Themkphantu();
                    tieptuc=true;
                    break;
                case 3:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach chi nha phan phoi");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
            }
        }
        while(tieptuc);
    }
    
    public void TimKiemThongTinXe()throws IOException{
        boolean tieptuc=true;
        do{
            System.out.println("++++++TIM KIEM THONG TIN XE++++++");
            System.out.println("1.Tim kiem thong tin xe theo ma");
            System.out.println("2.Tim kiem thong tin xe theo ten");
            System.out.println("3.Tro lai danh sach nha phan phoi");
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
                    System.out.println("Ban chon tim kiem thong tin xe theo ma");
                    System.out.print("Nhap ma nhom xe can tim: ");
                    String manhom;
                    while(true){
                        manhom=check.kiemTraManhom();
                        if(dsttx.kiemTraManhom(manhom)==true){
                            dsttx.TimKiemMa(manhom);
                            break;
                        }
                        else
                            System.out.println("Khong co ma nhom can tim");
                    }
                    tieptuc=true;
                    break;
                case 2:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem thong tin xe theo ten");
                    System.out.print("Nhap ten xe can tim: ");
                    String tenxe;
                    while(true){
                        tenxe=Nhapmenudsttx.nextLine();
                        if(dsttx.kiemTraTenxe(tenxe)==true){
                            dsttx.TimKiemTen(tenxe);
                            break;
                        }
                        else
                            System.out.println("Khong co ten xe can tim");
                    }
                    tieptuc=true;
                    break;
                case 3:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach thong tin xe");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
            }
        }
        while(tieptuc);
    }
    
    public void MenuDanhSachThongTinXe() throws IOException{
        boolean tieptuc=false;
        do{
            System.out.println("==================================================");
            System.out.println("++++++DANH SACH THONG TIN XE++++++");
            System.out.println("1.Xuat danh sach thong tin xe");
            System.out.println("2.Them moi thong tin xe");
            System.out.println("3.Tim kiem thong tin xe");
            System.out.println("4.Xoa thong tin xe");
            System.out.println("5.Sua thong tin xe");
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
                    dsttx.XuatDanhSach();
                    tieptuc=true;
                    break;
                case 2:
                    ThemThongTinXe();
                    tieptuc=true;
                    break;
                case 3:
                    TimKiemThongTinXe();
                    tieptuc=true;
                    break;
                case 4:
                    dsttx.Xoa();
                    tieptuc=true;
                    break;
                case 5:
                    dsttx.Sua();
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
