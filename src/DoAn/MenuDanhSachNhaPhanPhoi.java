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
public class MenuDanhSachNhaPhanPhoi{
    CheckLoi check=new CheckLoi();
    DanhSachNhaPhanPhoi dsnpp=new DanhSachNhaPhanPhoi();
    Scanner Nhapmenudsnpp=new Scanner(System.in);
    
    public void ThemNhaPhanPhoi() throws IOException{
        boolean tieptuc=false;
        do{
            System.out.println("++++++THEM NHA PHAN PHOI MOI++++++");
            System.out.println("1.Them moi mot nha phan phoi");
            System.out.println("2.Them moi nhieu nha phan phoi");
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
                    System.out.println("Ban chon them moi mot nha phan phoi");
                    dsnpp.Them();
                    tieptuc=true;
                    break;
                case 2:
                    System.out.println("==================================================");
                    System.out.println("Ban chon them moi nhieu nha phan phoi");
                    dsnpp.Themkphantu();
                    tieptuc=true;
                    break;
                case 3:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach nha phan phoi");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
            }
        }
        while(tieptuc);
    }

    public void TimKiemNhaPhanPhoi()throws IOException{
        boolean tieptuc=true;
        do{
            System.out.println("++++++TIM KIEM NHA PHAN PHOI++++++");
            System.out.println("1.Tim kiem nha phan phoi theo ma");
            System.out.println("2.Tim kiem nha phan phoi theo ten");
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
                    System.out.println("Ban chon tim kiem nha phan phoi theo ma");
                    System.out.print("Nhap ma nha phan phoi can tim: ");
                    String mnpp;
                    while(true){
                        mnpp=check.kiemTraMa();
                        if(dsnpp.kiemTraMnpp(mnpp)==true){
                            dsnpp.TimKiemMa(mnpp);
                            break;
                        }
                        else
                            System.out.println("Khong co ma nha phan phoi can tim");
                    }
                    tieptuc=true;
                    break;
                case 2:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem nha phan phoi theo ten");
                    System.out.print("Nhap ten nha phan phoi can tim: ");
                    String tennpp;
                    while(true){
                        tennpp=Nhapmenudsnpp.nextLine();
                        if(dsnpp.kiemTraTennpp(tennpp)==true){
                            dsnpp.TimKiemTen(tennpp);
                            break;
                        }
                        else
                            System.out.println("Khong co ten nha phan phoi can tim");
                    }
                    tieptuc=true;
                    break;
                case 3:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach nha phan phoi");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
            }
        }
        while(tieptuc);
    }
    
    public void MenuDanhSachNhaPhanPhoi() throws IOException{
        boolean tieptuc=false;
        do{
            System.out.println("++++++DANH SACH CHI TIET NHA PHAN PHOI++++++");
            System.out.println("1.Xuat danh sach nha phan phoi");
            System.out.println("2.Them moi nha phan phoi");
            System.out.println("3.Tim kiem nha phan phoi");
            System.out.println("4.Xoa nha phan phoi");
            System.out.println("5.Sua nha phan phoi");
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
                    dsnpp.XuatDanhSach();
                    tieptuc=true;
                    break;
                case 2:
                    ThemNhaPhanPhoi();
                    tieptuc=true;
                    break;
                case 3:
                    TimKiemNhaPhanPhoi();
                    tieptuc=true;
                    break;
                case 4:
                    dsnpp.Xoa();
                    tieptuc=true;
                    break;
                case 5:
                    dsnpp.Sua();
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
