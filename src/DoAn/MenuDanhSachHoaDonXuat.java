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
public class MenuDanhSachHoaDonXuat {
    CheckLoi check=new CheckLoi();
    DanhSachHoaDonXuat dshdx=new DanhSachHoaDonXuat();
    Scanner Nhapmenudshdx=new Scanner(System.in);
    
    public void ThemHoaDonXuat() throws IOException{
        boolean tieptuc=false;
        do{
            System.out.println("++++++THEM HOA DON XUAT MOI++++++");
            System.out.println("1.Them moi mot thong tin hoa don xuat");
            System.out.println("2.Them moi nhieu thong tin hoa don xuat");
            System.out.println("3.Tro lai danh sach hoa don xuat");
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
                    System.out.println("Ban chon them moi mot thong tin hoa don xuat");
                    dshdx.Them();
                    tieptuc=true;
                    break;
                case 2:
                    System.out.println("==================================================");
                    System.out.println("Ban chon them moi nhieu thong tin hoa don xuat");
                    dshdx.Themkphantu();
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
    
    public void TimKiemHoaDonXuat()throws IOException{
        boolean tieptuc=true;
        do{
            System.out.println("++++++TIM KIEM HOA DON XUAT++++++");
            System.out.println("1.Tim kiem thong tin hoa don xuat theo ma hoa don ");
            System.out.println("2.Tim kiem thong tin hoa don xuat theo ma nhan vien");
            System.out.println("3.Tim kiem thong tin hoa don xuat theo ma khach hang");
            System.out.println("4.Tim kiem thong tin hoa don xuat theo ma xe");
            System.out.println("5.Tim kiem thong tin hoa don xuat theo thang nam");
            System.out.println("6.Tro lai danh sach hoa don xuat");
            System.out.println("==================================================");
            System.out.print("Chon hinh thuc ban muon su dung: ");
            int chonthem=check.kiemTraInt();
            while(chonthem>6 || chonthem<=0){
                System.out.println("Nhap sai cu phap!!!");
                System.out.println("==================================================");
                System.out.print("Chon lai hinh thuc ban muon su dung: ");
                chonthem=check.kiemTraInt();
            }
            switch(chonthem){
                case 1:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem thong tin hoa don xuat theo ma hoa don");
                    System.out.print("Nhap ma hoa don xuat can tim: ");
                    String mahd;
                    while(true){
                        mahd=check.kiemTraMaHdx();
                        if(dshdx.kiemTraMaHd(mahd)==true){
                            dshdx.TimKiemMaHd(mahd);
                            break;
                        }
                        else
                            System.out.println("Khong co ma hoa don can tim");
                    }
                    tieptuc=true;
                    break;
                case 2:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem thong tin hoa don xuat theo ma nhan vien");
                    System.out.print("Nhap ma nhan vien can tim: ");
                    String manv;
                    while(true){
                        manv=check.kiemTraMaNv();
                        if(dshdx.kiemTraMaNv(manv)==true){
                            dshdx.TimKiemMaNv(manv);
                            break;
                        }
                        else
                            System.out.println("Khong co ma nhan vien can tim");
                    }
                    tieptuc=true;
                    break;
                case 3:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem thong tin hoa don xuat theo ma khach hang");
                    System.out.print("Nhap ma nha phan phoi can tim: ");
                    String makh;
                    while(true){
                        makh=check.kiemTraMaKh();
                        if(dshdx.kiemTraMakh(makh)==true){
                            dshdx.TimKiemMakh(makh);
                            break;
                        }
                        else
                            System.out.println("Khong co ma khach hang can tim");
                    }
                    tieptuc=true;
                    break;
                case 4:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem thong tin hoa don xuat theo ma xe");
                    System.out.print("Nhap ma xe can tim: ");
                    String maxe;
                    while(true){
                        maxe=check.kiemTraMaxe();
                        if(dshdx.kiemTraMaxe(maxe)==true){
                            dshdx.TimKiemMaxe(maxe);
                            break;
                        }
                        else
                            System.out.println("Khong co ma xe can tim");
                    }
                    tieptuc=true;
                    break;
                case 5:    
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem thong tin hoa don nhap theo thang nam");
                    String thang,nam;
                    System.out.print("Nhap nam nhap can tim: ");
                    while(true){
                        nam=check.kiemTraNam();
                        if(dshdx.kiemTraNam(nam)==true){
                            System.out.print("Nhap thang nhap can tim: ");
                            while(true){
                                thang=check.kiemTraThang();
                                if(dshdx.kiemTraThang(thang)==true){
                                    dshdx.TimKiemNamThang(thang,nam);
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
    
    public void MenuDanhSachHoaDonXuat() throws IOException{
        boolean tieptuc=false;
        do{
            System.out.println("==================================================");
            System.out.println("++++++DANH SACH HOA DON XUAT++++++");
            System.out.println("1.Xuat danh sach hoa don xuat");
            System.out.println("2.Them moi hoa don xuat");
            System.out.println("3.Tim kiem hoa don xuat");
            System.out.println("4.Xoa hoa don xuat");
            System.out.println("5.Sua hoa don xuat");
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
                    dshdx.XuatDanhSach();
                    tieptuc=true;
                    break;
                case 2:
                    ThemHoaDonXuat();
                    tieptuc=true;
                    break;
                case 3:
                    TimKiemHoaDonXuat();
                    tieptuc=true;
                    break;
                case 4:
                    dshdx.Xoa();
                    tieptuc=true;
                    break;
                case 5:
                    dshdx.Sua();
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
