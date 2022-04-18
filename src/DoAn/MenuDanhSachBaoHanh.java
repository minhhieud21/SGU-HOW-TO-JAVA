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
public class MenuDanhSachBaoHanh{
    CheckLoi check=new CheckLoi();
    DanhSachBaoHanh dsbh=new DanhSachBaoHanh();
    Scanner Nhapmenudsbh=new Scanner(System.in);
    
    public void ThemBaoHanh() throws IOException{
        boolean tieptuc=false;
        do{
            System.out.println("++++++THEM BAO HANH MOI++++++");
            System.out.println("1.Them moi mot thong tin bao hanh");
            System.out.println("2.Them moi nhieu thong tin bao hanh");
            System.out.println("3.Tro lai danh sach bao hanh");
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
                    System.out.println("Ban chon them moi mot thong tin bao hanh");
                    dsbh.Them();
                    tieptuc=true;
                    break;
                case 2:
                    System.out.println("==================================================");
                    System.out.println("Ban chon them moi nhieu thong tin bao hanh");
                    dsbh.Themkphantu();
                    tieptuc=true;
                    break;
                case 3:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach bao hanh");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
            }
        }
        while(tieptuc);
    }
    
    public void TimKiemBaoHanh()throws IOException{
        boolean tieptuc=true;
        do{
            System.out.println("++++++TIM KIEM BAO HANH++++++");
            System.out.println("1.Tim kiem thong tin bao hanh theo ma bao hanh");
            System.out.println("2.Tim kiem thong tin bao hanh theo ma nhan vien");
            System.out.println("3.Tim kiem thong tin bao hanh theo ma khach hang");
            System.out.println("4.Tim kiem thong tin bao hanh theo thang nam");
            System.out.println("5.Tro lai danh sach bao hanh");
            System.out.println("==================================================");
            System.out.print("Chon hinh thuc ban muon su dung: ");
            int chonthem=check.kiemTraInt();
            while(chonthem>5 || chonthem<=0){
                System.out.println("Nhap sai cu phap!!!");
                System.out.println("==================================================");
                System.out.print("Chon lai hinh thuc ban muon su dung: ");
                chonthem=check.kiemTraInt();
            }
            switch(chonthem){
                case 1:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem thong tin bao hanh theo ma bao hanh");
                    System.out.print("Nhap ma bao hanh can tim: ");
                    String mabh;
                    while(true){
                        mabh=check.kiemTraMaBh();
                        if(dsbh.kiemTraMaBh(mabh)==true){
                            dsbh.TimKiemMaBh(mabh);
                            break;
                        }
                        else
                            System.out.println("Khong co ma bao hanh can tim");
                    }
                    tieptuc=true;
                    break;
                case 2:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem thong tin bao hanh theo ma nhan vien");
                    System.out.print("Nhap ma nhan vien can tim: ");
                    String manv;
                    while(true){
                        manv=check.kiemTraMaNv();
                        if(dsbh.kiemTraMaNv(manv)==true){
                            dsbh.TimKiemMaNv(manv);
                            break;
                        }
                        else
                            System.out.println("Khong co ma nhan vien can tim");
                    }
                    tieptuc=true;
                    break;
                case 3:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem thong tin bao hanh theo ma khach hang");
                    System.out.print("Nhap ma khach hang can tim: ");
                    String makh;
                    while(true){
                        makh=check.kiemTraMaKh();
                        if(dsbh.kiemTraMaKh(makh)==true){
                            dsbh.TimKiemMaKh(makh);
                            break;
                        }
                        else
                            System.out.println("Khong co ma khach hang can tim");
                    }
                    tieptuc=true;
                    break;
                case 4:    
                    System.out.println("==================================================");
                    System.out.println("Ban chon tim kiem thong tin bao hanh theo thang nam");
                    String thang,nam;
                    System.out.print("Nhap nam bao hanh can tim: ");
                    while(true){
                        nam=check.kiemTraNam();
                        if(dsbh.kiemTraNam(nam)==true){
                            System.out.print("Nhap thang bao hanh can tim: ");
                            while(true){
                                thang=check.kiemTraThang();
                                if(dsbh.kiemTraThang(thang)==true){
                                    dsbh.TimKiemNamThang(thang,nam);
                                    break;
                                }
                                else
                                    System.out.println("Khong co thang bao hanh can tim");
                            }
                            break;
                        }
                        else
                            System.out.println("Khong co nam bao hanh can tim");
                    }
                    tieptuc=true;
                    break;
                case 5:
                    System.out.println("==================================================");
                    System.out.println("Ban chon tro lai danh sach nhan vien");
                    System.out.println("==================================================");
                    tieptuc=false;
                    break;
            }
        }
        while(tieptuc);
    }
    
    public void MenuDanhSachBaoHanh() throws IOException{
        boolean tieptuc=false;
        do{
            System.out.println("==================================================");
            System.out.println("++++++DANH SACH BAO HANH++++++");
            System.out.println("1.Xuat danh sach bao hanh");
            System.out.println("2.Them moi bao hanh");
            System.out.println("3.Tim kiem bao hanh");
            System.out.println("4.Xoa bao hanh");
            System.out.println("5.Sua bao hanh");
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
                    dsbh.XuatDanhSach();
                    tieptuc=true;
                    break;
                case 2:
                    ThemBaoHanh();
                    tieptuc=true;
                    break;
                case 3:
                    TimKiemBaoHanh();
                    tieptuc=true;
                    break;
                case 4:
                    dsbh.Xoa();
                    tieptuc=true;
                    break;
                case 5:
                    dsbh.Sua();
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
