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
public class MenuTK{
    DoAn.DanhSachTK dstk = new DoAn.DanhSachTK();
    Scanner sc = new Scanner(System.in);
    private String biengian ;
    public void ThemNhanVien() throws IOException{
        boolean tieptuc=false;
        do{
            System.out.println("\n++++++THEM TAI KHOAN++++++");
            System.out.println("1.Them moi mot tai khoan");
            System.out.println("2.Them moi nhieu tai khoan");
            System.out.println("3.Tro lai danh sach tai khoan");
            System.out.println("==================================================");
            System.out.print("Chon : ");
            String chonthem = sc.nextLine();
            switch(chonthem){
                case "1":
                    System.out.println("==================================================");
                    System.out.println("Ban chon them moi mot tai khoan");
                    dstk.Them();
                    tieptuc=true;
                    break;
                case "2":
                    System.out.println("==================================================");
                    System.out.println("Ban chon them moi nhieu tai khoan");
                    dstk.Themkphantu();
                    tieptuc=true;
                    break;
                case "3":
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach tai khoan");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
                default:
                    System.out.println("Ky tu nhap khong hop le !!!!!");
                    break;
            }
        }
        while(tieptuc);
    }
    public static boolean checkMsnv(String str){
        return str.matches("^[0-9]{6}");
    }
    public void MenuTaiKhoan() throws IOException{
        boolean tieptuc=false;
        do{
            System.out.println("++++++MENU TAI KHOAN++++++");
            System.out.println("1.Xuat danh sach tai khoan");
            System.out.println("2.Them moi tai khoan");
            System.out.println("3.Tim kiem tai khoan");
            System.out.println("4.Xoa tai khoan");
            System.out.println("5.Sua tai khoan");
            System.out.println("6.Tro lai menu chinh");
            System.out.println("==================================================");
            System.out.print("Chon : ");
            String choose = sc.nextLine();
            switch(choose){
                case "1":
                    dstk.XuatDanhSach();
                    tieptuc=true;
                    break;
                case "2":
                    ThemNhanVien();
                    tieptuc=true;
                    break;
                case "3":
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem nhan vien theo ma");
                    while(true){
                        boolean check = false;
                        String msnvmoi;
                        while(check == false){
                            System.out.print("Nhap MSNV: ");
                            msnvmoi = sc.nextLine();
                            if(checkMsnv(msnvmoi)==true){
                                biengian = msnvmoi;
                                check = true;}
                            else {
                            System.out.println("Ma so nhan vien gom co 6 so\n");}
                    }
                        if(checkMsnv(biengian)==true){
                            dstk.TimKiemMa(biengian);
                            break;
                        }
                        else
                            System.out.println("Khong co ma nhan vien can tim");
                    }
                    tieptuc=true;
                    break;
                case "4":
                    dstk.Xoa();
                    tieptuc=true;
                    break;
                case "5":
                    dstk.Sua();
                    tieptuc=true;
                    break;
                case "6":
                    System.out.println("Tro lai menu chinh");
                    tieptuc=false;
                    break;
                default:
                    System.out.println("Ki tu nhap ko hop le ! Nhap lai\n");
                    break;
            }
        }
        while(tieptuc);
    }
    public static void main(String[] args) throws IOException {
        MenuTK menu = new MenuTK();
//        menu.dstk.NhapDanhSach();
        menu.dstk.docfile();
        menu.MenuTaiKhoan();
    }
}
