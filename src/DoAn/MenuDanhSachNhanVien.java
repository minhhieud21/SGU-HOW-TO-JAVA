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
public class MenuDanhSachNhanVien {
    CheckLoi check=new CheckLoi();
    DanhSachNhanVien dsnv=new DanhSachNhanVien();
    Scanner Nhapmenudsnv=new Scanner(System.in);
    
    public void ThemNhanVien() throws IOException{
        boolean tieptuc=false;
        do{
            System.out.println("++++++THEM NHAN VIEN MOI++++++");
            System.out.println("1.Them moi mot nhan vien");
            System.out.println("2.Them moi nhieu nhan vien");
            System.out.println("3.Tro lai danh sach nhan vien");
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
                    System.out.println("Ban chon them moi mot nhan vien");
                    dsnv.Them();
                    tieptuc=true;
                    break;
                case 2:
                    System.out.println("==================================================");
                    System.out.println("Ban chon them moi nhieu nhan vien");
                    dsnv.Themkphantu();
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
    
    public void TimKiemNhanVien()throws IOException{
        boolean tieptuc=true;
        do{
            System.out.println("++++++TIM KIEM NHAN VIEN++++++");
            System.out.println("1.Tim kiem nhan vien theo ma");
            System.out.println("2.Tim kiem nhan vien theo ten");
            System.out.println("3.Tro lai danh sach nhan vien");
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
                    System.out.println("Ban chon tim kiem nhan vien theo ma");
                    System.out.print("Nhap ma nhan vien can tim: ");
                    String mnv;
                    while(true){
                        mnv=check.kiemTraMaNv();
                        if(dsnv.kiemTraManv(mnv)==true){
                            dsnv.TimKiemMa(mnv);
                            break;
                        }
                        else
                            System.out.println("Khong co ma nhan vien can tim");
                    }
                    tieptuc=true;
                    break;
                case 2:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem nhan vien theo ten");
                    System.out.print("Nhap ho ten nhan vien can tim: ");
                    String tennv;
                    while(true){
                        tennv=check.kiemTraTenNv();
                        if(dsnv.kiemTraTennv(tennv)==true){
                            dsnv.TimKiemTen(tennv);
                            break;
                        }
                        else
                            System.out.println("Khong co ten nhan vien can tim");
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
    
    public void MenuDanhSachNhanVien() throws IOException{
        boolean tieptuc=false;
        do{
            System.out.println("++++++DANH SACH CHI TIET NHAN VIEN++++++");
            System.out.println("1.Xuat danh sach nhan vien");
            System.out.println("2.Them moi nhan vien");
            System.out.println("3.Tim kiem nhan vien");
            System.out.println("4.Xoa nhan vien");
            System.out.println("5.Sua nhan vien");
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
                    dsnv.XuatDanhSach();
                    tieptuc=true;
                    break;
                case 2:
                    ThemNhanVien();
                    tieptuc=true;
                    break;
                case 3:
                    TimKiemNhanVien();
                    tieptuc=true;
                    break;
                case 4:
                    dsnv.Xoa();
                    tieptuc=true;
                    break;
                case 5:
                    dsnv.Sua();
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
