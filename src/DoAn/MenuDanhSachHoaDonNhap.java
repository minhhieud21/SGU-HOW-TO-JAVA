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
public class MenuDanhSachHoaDonNhap{
    CheckLoi check=new CheckLoi();
    DanhSachHoaDonNhap dshdn=new DanhSachHoaDonNhap();
    Scanner Nhapmenudshdn=new Scanner(System.in);
    
    public void ThemHoaDonNhap() throws IOException{
        boolean tieptuc=false;
        do{
            System.out.println("++++++THEM HOA DON NHAP MOI++++++");
            System.out.println("1.Them moi mot thong tin hoa don nhap");
            System.out.println("2.Them moi nhieu thong tin hoa don nhap");
            System.out.println("3.Tro lai danh sach hoa don nhap");
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
                    System.out.println("Ban chon them moi mot thong tin hoa don nhap");
                    dshdn.Them();
                    tieptuc=true;
                    break;
                case 2:
                    System.out.println("==================================================");
                    System.out.println("Ban chon them moi nhieu thong tin hoa don nhap");
                    dshdn.Themkphantu();
                    tieptuc=true;
                    break;
                case 3:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach hoa don nhap");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
            }
        }
        while(tieptuc);
    }
    
    public void TimKiemHoaDonNhap()throws IOException{
        boolean tieptuc=true;
        do{
            System.out.println("++++++TIM KIEM HOA DON NHAP++++++");
            System.out.println("1.Tim kiem thong tin hoa don nhap theo ma hoa don ");
            System.out.println("2.Tim kiem thong tin hoa don nhap theo ma nhan vien");
            System.out.println("3.Tim kiem thong tin hoa don nhap theo ma nha phan phoi");
            System.out.println("4.Tim kiem thong tin hoa don nhap theo ma nhom xe");
            System.out.println("5.Tim kiem thong tin hoa don nhap theo ma xe");
            System.out.println("6.Tim kiem thong tin hoa don nhap theo thang nam");
            System.out.println("7.Tro lai danh sach hoa don nhap");
            System.out.println("==================================================");
            System.out.print("Chon hinh thuc ban muon su dung: ");
            int chonthem=check.kiemTraInt();
            while(chonthem>7 || chonthem<=0){
                System.out.println("Nhap sai cu phap!!!");
                System.out.println("==================================================");
                System.out.print("Chon lai hinh thuc ban muon su dung: ");
                chonthem=check.kiemTraInt();
            }
            switch(chonthem){
                case 1:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem thong tin hoa don nhap theo ma hoa don");
                    System.out.print("Nhap ma hoa don nhap can tim: ");
                    String mahd;
                    while(true){
                        mahd=check.kiemTraMaHdn();
                        if(dshdn.kiemTraMaHd(mahd)==true){
                            dshdn.TimKiemMaHd(mahd);
                            break;
                        }
                        else
                            System.out.println("Khong co ma hoa don can tim");
                    }
                    tieptuc=true;
                    break;
                case 2:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem thong tin hoa don nhap theo ma nhan vien");
                    System.out.print("Nhap ma nhan vien can tim: ");
                    String manv;
                    while(true){
                        manv=check.kiemTraMaNv();
                        if(dshdn.kiemTraMaNv(manv)==true){
                            dshdn.TimKiemMaNv(manv);
                            break;
                        }
                        else
                            System.out.println("Khong co ma nhan vien can tim");
                    }
                    tieptuc=true;
                    break;
                case 3:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem thong tin hoa don nhap theo ma nha phan phoi");
                    System.out.print("Nhap ma nha phan phoi can tim: ");
                    String mnpp;
                    while(true){
                        mnpp=check.kiemTraManpp();
                        if(dshdn.kiemTraMnpp(mnpp)==true){
                            dshdn.TimKiemManpp(mnpp);
                            break;
                        }
                        else
                            System.out.println("Khong co ma nha phan phoi can tim");
                    }
                    tieptuc=true;
                    break;
                case 4:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem thong tin hoa don nhap theo ma nhom xe");
                    System.out.print("Nhap ma nhom xe can tim: ");
                    String manhom;
                    while(true){
                        manhom=check.kiemTraManhom();
                        if(dshdn.kiemTraManhom(manhom)==true){
                            dshdn.TimKiemManhom(manhom);
                            break;
                        }
                        else
                            System.out.println("Khong co ma nhom xe can tim");
                    }
                    tieptuc=true;
                    break;
                case 5:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem thong tin hoa don nhap theo ma xe");
                    System.out.print("Nhap ma xe can tim: ");
                    String maxe;
                    while(true){
                        maxe=check.kiemTraMaxe();
                        if(dshdn.kiemTraMaxe(maxe)==true){
                            dshdn.TimKiemMaxe(maxe);
                            break;
                        }
                        else
                            System.out.println("Khong co ma xe can tim");
                    }
                    tieptuc=true;
                    break;
                case 6:    
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem thong tin hoa don nhap theo thang nam");
                    String thang,nam;
                    System.out.print("Nhap nam nhap can tim: ");
                    while(true){
                        nam=check.kiemTraNam();
                        if(dshdn.kiemTraNam(nam)==true){
                            System.out.print("Nhap thang nhap can tim: ");
                            while(true){
                                thang=check.kiemTraThang();
                                if(dshdn.kiemTraThang(thang)==true){
                                    dshdn.TimKiemNamThang(thang,nam);
                                    break;
                                }
                                else
                                    System.out.println("Khong co thang nhap can tim");
                            }
                            break;
                        }
                        else
                            System.out.println("Khong co nam nhap can tim");
                    }
                    tieptuc=true;
                    break;
                case 7:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach nhan vien");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
            }
        }
        while(tieptuc);
    }
    
    public void MenuDanhSachHoaDonNhap() throws IOException{
        boolean tieptuc=false;
        do{
            System.out.println("==================================================");
            System.out.println("++++++DANH SACH HOA DON NHAP++++++");
            System.out.println("1.Xuat danh sach hoa don nhap");
            System.out.println("2.Them moi hoa don nhap");
            System.out.println("3.Tim kiem hoa don nhap");
            System.out.println("4.Xoa hoa don nhap");
            System.out.println("5.Sua hoa don nhap");
            System.out.println("6.Tro lai menu chinh");
            System.out.println("==================================================");
            System.out.print("Chon chuc nang ban muon su dung: ");
            int choose=check.kiemTraInt();
            while(choose>6 || choose<=0){
                System.out.println("Nhap sai cu phap!!!");
                System.out.println("==================================================");
                System.out.print("Chon lai hinh thuc ban muon su dung: ");
                choose=check.kiemTraInt();
            }
            switch(choose){
                case 1:
                    dshdn.XuatDanhSach();
                    tieptuc=true;
                    break;
                case 2:
                    ThemHoaDonNhap();
                    tieptuc=true;
                    break;
                case 3:
                    TimKiemHoaDonNhap();
                    tieptuc=true;
                    break;
                case 4:
                    dshdn.Xoa();
                    tieptuc=true;
                    break;
                case 5:
                    dshdn.Sua();
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
