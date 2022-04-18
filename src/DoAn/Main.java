/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn;

import java.util.*;
import java.io.*;
import java.text.*;

/**
 *
 * @author HieuPhan
 */
public class Main{
    public static void main(String[] args) throws IOException{
        CheckLoi check=new CheckLoi();
        boolean tieptuc=false;
        boolean kiemtra5=false;
        DangNhap dn=new DangNhap();
        System.out.println("--------------XIN CHAO----------------");
	System.out.println("-----------HAY DANG NHAP--------------\n");
	int a = dn.login();
        switch(a){
            case 1:
                do{
                    System.out.println("+================================+");
                    System.out.println("||\t\t\t\t||");
                    System.out.println("||\t---MENU NHAN VIEN---\t||");
                    System.out.println("||\t\t\t\t||");
                    System.out.println("+================================+\n");
                    System.out.println("-----------QUAN LY CUA HANG BAN XE-----------");
                    System.out.println("1.Quan ly chi tiet xe");    
                    System.out.println("2.Quan ly hoa don xuat");
                    System.out.println("3.Quan ly bao hanh");
                    System.out.println("4.Thoat khoi chuong trinh");
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
                            MenuDanhSachChiTietXe menudsx=new MenuDanhSachChiTietXe();
//                            menudsx.dsx.NhapDanhSach();
                            menudsx.dsx.docfile();
                            menudsx.MenuDanhSachXe();
                            tieptuc=true;
                            break;
                        case 2:
                            MenuDanhSachHoaDonNhap menuhdn=new MenuDanhSachHoaDonNhap();
//                            menuhdn.dshdn.NhapDanhSach();
                            menuhdn.dshdn.docfile();
                            menuhdn.MenuDanhSachHoaDonNhap();
                            tieptuc=true;
                            break;
                        case 3:
                            MenuDanhSachBaoHanh menubh=new MenuDanhSachBaoHanh();
//                            menubh.dsbh.NhapDanhSach();
                            menubh.dsbh.docfile();
                            menubh.MenuDanhSachBaoHanh();
                            tieptuc=true;
                            break;
                    } 
                }
                while(tieptuc);
                break;
            case 2:
                do{
                    System.out.println("+================================+");
                    System.out.println("||\t\t\t\t||");
                    System.out.println("||\t----MENU QUAN LY----\t||");
                    System.out.println("||\t\t\t\t||");
                    System.out.println("+================================+\n");
                    System.out.println("-----------QUAN LY CUA HANG BAN XE-----------");
                    System.out.println("1.Quan ly thong tin xe");
                    System.out.println("2.Quan ly nhan vien");
                    System.out.println("3.Quan ly khach hang");
                    System.out.println("4.Quan ly kinh doanh");
                    System.out.println("5.Quan ly doanh thu");
                    System.out.println("6.Quan ly nha phan phoi");
                    System.out.println("7.Thoat khoi chuong trinh");
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
                            boolean kiemtra=false;
                            do{
                                System.out.println("==================================================");
                                System.out.println("++++++QUAN LY THONG TIN XE++++++");
                                System.out.println("1.Quan ly thong tin xe");
                                System.out.println("2.Quan ly chi tiet xe");
                                System.out.println("3.Tro lai quan ly cua hang");
                                System.out.print("Chon hinh thuc ban muon su dung: ");
                                int chonqlttx=check.kiemTraInt();
                                while(chonqlttx>3 || chonqlttx<=0){
                                    System.out.println("Nhap sai cu phap!!!");
                                    System.out.println("==================================================");
                                    System.out.print("Chon lai hinh thuc ban muon su dung: ");
                                    chonqlttx=check.kiemTraInt();
                                }
                                switch(chonqlttx){
                                    case 1:
                                        MenuDanhSachThongTinXe menuttx=new MenuDanhSachThongTinXe();
        //                                menuttx.dsttx.NhapDanhSach();
                                        menuttx.dsttx.docfile();
                                        menuttx.MenuDanhSachThongTinXe();
                                        kiemtra=true;
                                        break;
                                    case 2:
                                        MenuDanhSachChiTietXe menuctx=new MenuDanhSachChiTietXe();
        //                                menuctx.dsx.NhapDanhSach();
                                        menuctx.dsx.docfile();
                                        menuctx.MenuDanhSachXe();
                                        kiemtra=true;
                                        break;
                                    case 3:
                                        kiemtra=false;
                                        break;
                                }
                            }
                            while(kiemtra);
                            tieptuc=true;
                            break;
                        case 2:
                            MenuDanhSachNhanVien menunv=new MenuDanhSachNhanVien();
        //                    menunv.dsnv.NhapDanhSach();
                            menunv.dsnv.docfile();
                            menunv.MenuDanhSachNhanVien();
                            tieptuc=true;
                            break;
                        case 3:
                            MenuDanhSachKhachHang menukh=new MenuDanhSachKhachHang();
        //                    menukh.dskh.NhapDanhSach();
                            menukh.dskh.docfile();
                            menukh.MenuDanhSachKhachHang();
                            tieptuc=true;
                            break;
                        case 4:
                            boolean kiemtra2=false;
                            do{
                                System.out.println("==================================================");
                                System.out.println("++++++QUAN LY KINH DOANH++++++");
                                System.out.println("1.Quan ly hoa don nhap");
                                System.out.println("2.Quan ly hoa don xuat");
                                System.out.println("3.Quan ly bao hanh");
                                System.out.println("4.Tro lai quan ly cua hang");
                                System.out.print("Chon hinh thuc ban muon su dung: ");
                                int chonqlttx=check.kiemTraInt();
                                while(chonqlttx>4 || chonqlttx<=0){
                                    System.out.println("Nhap sai cu phap!!!");
                                    System.out.println("==================================================");
                                    System.out.print("Chon lai hinh thuc ban muon su dung: ");
                                    chonqlttx=check.kiemTraInt();
                                }
                                switch(chonqlttx){
                                    case 1:
                                        MenuDanhSachHoaDonNhap menuhdn=new MenuDanhSachHoaDonNhap();
        //                                menuhdn.dshdn.NhapDanhSach();
                                        menuhdn.dshdn.docfile();
                                        menuhdn.MenuDanhSachHoaDonNhap();
                                        kiemtra2=true;
                                        break;
                                    case 2:
                                        MenuDanhSachHoaDonXuat menuhdx=new MenuDanhSachHoaDonXuat();
        //                                menuhdx.dshdx.NhapDanhSach();
                                        menuhdx.dshdx.docfile();
                                        menuhdx.MenuDanhSachHoaDonXuat();
                                        kiemtra2=true;
                                        break;
                                    case 3:
                                        MenuDanhSachBaoHanh menubh=new MenuDanhSachBaoHanh();
        //                                menubh.dsbh.NhapDanhSach();
                                        menubh.dsbh.docfile();
                                        menubh.MenuDanhSachBaoHanh();
                                        kiemtra2=true;
                                        break;
                                    case 4:
                                        kiemtra2=false;
                                        break;
                                }
                            }
                            while(kiemtra2);
                            tieptuc=true;
                            break;
                        case 5:
                            MenuDoanhThu menudt=new MenuDoanhThu();
                            menudt.Xuat();
                            tieptuc=true;
                            break;
                        case 6:
                            MenuDanhSachNhaPhanPhoi menunpp=new MenuDanhSachNhaPhanPhoi();
        //                    menunpp.dsnpp.NhapDanhSach();
                            menunpp.dsnpp.docfile();
                            menunpp.MenuDanhSachNhaPhanPhoi();
                            tieptuc=true;
                            break;
                        case 7:
                            tieptuc=false;
                            break;
                    }
                }
                while(tieptuc);
                break;
            case 3:
                do{
                    System.out.println("+================================+");
                    System.out.println("||\t\t\t\t||");
                    System.out.println("||\t----MENU ADMIN----\t||");
                    System.out.println("||\t\t\t\t||");
                    System.out.println("+================================+\n");
                    System.out.println("-----------QUAN LY CUA HANG BAN XE-----------");
                    System.out.println("1.Quan ly thong tin xe");
                    System.out.println("2.Quan ly nhan vien");
                    System.out.println("3.Quan ly khach hang");
                    System.out.println("4.Quan ly kinh doanh");
                    System.out.println("5.Quan ly doanh thu");
                    System.out.println("6.Quan ly nha phan phoi");
                    System.out.println("7.Quan ly tai khoan");
                    System.out.println("8.Thoat khoi chuong trinh");
                    System.out.print("Chon hinh thuc ban muon su dung: ");
                    int chonthem=check.kiemTraInt();
                    while(chonthem>8 || chonthem<=0){
                        System.out.println("Nhap sai cu phap!!!");
                        System.out.println("==================================================");
                        System.out.print("Chon lai hinh thuc ban muon su dung: ");
                        chonthem=check.kiemTraInt();
                    }
                    switch(chonthem){
                        case 1:
                            boolean kiemtra=false;
                            do{
                                System.out.println("==================================================");
                                System.out.println("++++++QUAN LY THONG TIN XE++++++");
                                System.out.println("1.Quan ly thong tin xe");
                                System.out.println("2.Quan ly chi tiet xe");
                                System.out.println("3.Tro lai quan ly cua hang");
                                System.out.print("Chon hinh thuc ban muon su dung: ");
                                int chonqlttx=check.kiemTraInt();
                                while(chonqlttx>3 || chonqlttx<=0){
                                    System.out.println("Nhap sai cu phap!!!");
                                    System.out.println("==================================================");
                                    System.out.print("Chon lai hinh thuc ban muon su dung: ");
                                    chonqlttx=check.kiemTraInt();
                                }
                                switch(chonqlttx){
                                    case 1:
                                        MenuDanhSachThongTinXe menuttx=new MenuDanhSachThongTinXe();
        //                                menuttx.dsttx.NhapDanhSach();
                                        menuttx.dsttx.docfile();
                                        menuttx.MenuDanhSachThongTinXe();
                                        kiemtra=true;
                                        break;
                                    case 2:
                                        MenuDanhSachChiTietXe menuctx=new MenuDanhSachChiTietXe();
        //                                menuctx.dsx.NhapDanhSach();
                                        menuctx.dsx.docfile();
                                        menuctx.MenuDanhSachXe();
                                        kiemtra=true;
                                        break;
                                    case 3:
                                        kiemtra=false;
                                        break;
                                }
                            }
                            while(kiemtra);
                            tieptuc=true;
                            break;
                        case 2:
                            MenuDanhSachNhanVien menunv=new MenuDanhSachNhanVien();
        //                    menunv.dsnv.NhapDanhSach();
                            menunv.dsnv.docfile();
                            menunv.MenuDanhSachNhanVien();
                            tieptuc=true;
                            break;
                        case 3:
                            MenuDanhSachKhachHang menukh=new MenuDanhSachKhachHang();
        //                    menukh.dskh.NhapDanhSach();
                            menukh.dskh.docfile();
                            menukh.MenuDanhSachKhachHang();
                            tieptuc=true;
                            break;
                        case 4:
                            boolean kiemtra2=false;
                            do{
                                System.out.println("==================================================");
                                System.out.println("++++++QUAN LY KINH DOANH++++++");
                                System.out.println("1.Quan ly hoa don nhap");
                                System.out.println("2.Quan ly hoa don xuat");
                                System.out.println("3.Quan ly bao hanh");
                                System.out.println("4.Tro lai quan ly cua hang");
                                System.out.print("Chon hinh thuc ban muon su dung: ");
                                int chonqlttx=check.kiemTraInt();
                                while(chonqlttx>4 || chonqlttx<=0){
                                    System.out.println("Nhap sai cu phap!!!");
                                    System.out.println("==================================================");
                                    System.out.print("Chon lai hinh thuc ban muon su dung: ");
                                    chonqlttx=check.kiemTraInt();
                                }
                                switch(chonqlttx){
                                    case 1:
                                        MenuDanhSachHoaDonNhap menuhdn=new MenuDanhSachHoaDonNhap();
        //                                menuhdn.dshdn.NhapDanhSach();
                                        menuhdn.dshdn.docfile();
                                        menuhdn.MenuDanhSachHoaDonNhap();
                                        kiemtra2=true;
                                        break;
                                    case 2:
                                        MenuDanhSachHoaDonXuat menuhdx=new MenuDanhSachHoaDonXuat();
        //                                menuhdx.dshdx.NhapDanhSach();
                                        menuhdx.dshdx.docfile();
                                        menuhdx.MenuDanhSachHoaDonXuat();
                                        kiemtra2=true;
                                        break;
                                    case 3:
                                        MenuDanhSachBaoHanh menubh=new MenuDanhSachBaoHanh();
        //                                menubh.dsbh.NhapDanhSach();
                                        menubh.dsbh.docfile();
                                        menubh.MenuDanhSachBaoHanh();
                                        kiemtra2=true;
                                        break;
                                    case 4:
                                        kiemtra2=false;
                                        break;
                                }
                            }
                            while(kiemtra2);
                            tieptuc=true;
                            break;
                        case 5:
                            MenuDoanhThu menudt=new MenuDoanhThu();
                            menudt.Xuat();
                            tieptuc=true;
                            break;
                        case 6:
                            MenuDanhSachNhaPhanPhoi menunpp=new MenuDanhSachNhaPhanPhoi();
        //                    menunpp.dsnpp.NhapDanhSach();
                            menunpp.dsnpp.docfile();
                            menunpp.MenuDanhSachNhaPhanPhoi();
                            tieptuc=true;
                            break;
                        case 7:
                            MenuTK menutk=new MenuTK();
//                            menutk.dstk.NhapDanhSach();
                            menutk.dstk.docfile();
                            menutk.MenuTaiKhoan();
                            tieptuc=true;
                            break;
                        case 8:
                            tieptuc=false;
                            break;
                    }
                }
                while(tieptuc);
                break;
        }
    }
}
