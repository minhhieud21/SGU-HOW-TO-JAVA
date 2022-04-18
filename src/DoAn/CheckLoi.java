/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn;

/**
 *
 * @author HieuPhan
 */
import java.util.Scanner;
import java.io.IOException;
import java.lang.*;
import java.text.SimpleDateFormat;

public class CheckLoi{
    Scanner sc = new Scanner(System.in);
    
    public String kiemTraYN(){
	String s;
        while(true){
            String regex = "[yn]";
            s=sc.nextLine();
            //boolean check;
            if(s.matches(regex)==true)
                break;
            else
                System.out.println("**Ký tự nhập không hợp lệ ** Xin vui lòng nhập lại**");
	}
	return s;
    }
    
    public String kiemTraManhom(){
	String s;
	String regex="[a-zA-Z0-9]{5}";
        while(true){
            try{
                s=sc.nextLine();
                if(s.matches(regex)==true)
                    break;
                else{
                    System.out.println("!!!Ma nhom xe khong hop le!!!");
                    System.out.println("Yeu cau ma nhan vien gom 5 ki tu so va chu");
                    System.out.print("Nhap lai ma nhom xe: ");
                }
            }
            catch(Exception e){
                System.out.println("**Lỗi dữ liệu. Nhập lại.**");
            }
        }
        return s;
    }
    
    public String kiemTraManpp(){
	String s;
	String regex="[a-zA-Z0-9]{5}";
        while(true){
            try{
                s=sc.nextLine();
                if(s.matches(regex)==true)
                    break;
                else{
                    System.out.println("!!!Ma nha phan phoi khong hop le!!!");
                    System.out.println("Yeu cau ma nha phan phoi gom 5 ky tu so va chu");
                    System.out.print("Nhap lai ma nha phan phoi: ");
                }
            }
            catch(Exception e){
                System.out.println("**Lỗi dữ liệu. Nhập lại.**");
            }
        }
        return s;
    }
    
    public String kiemTraMaxe(){
	String s;
	String regex="[a-zA-Z]{2}[0-9]{3}";
        while(true){
            try{
                s=sc.nextLine();
                if(s.matches(regex)==true)
                    break;
                else{
                    System.out.println("!!!Ma xe khong hop le!!!");
                    System.out.println("Yeu cau ma xe gom 5 ki tu gồm 2 ky tu chu va 3 ky tu so");
                    System.out.print("Nhap lai ma xe: ");
                }
            }
            catch(Exception e){
                System.out.println("**Lỗi dữ liệu. Nhập lại.**");
            }
        }
        return s;
    }
    
    public String kiemTraMaBh(){
	String s;
	String regex="BH[0-9]{3}";
        while(true){
            try{
                s=sc.nextLine();
                if(s.matches(regex)==true)
                    break;
                else{
                    System.out.println("!!!Ma bao hanh khong hop le!!!");
                    System.out.println("Yeu cau ma bao hanh gom 5 ki tu: BH(0-9)");
                    System.out.print("Nhap lai ma bao hanh: ");
                }
            }
            catch(Exception e){
                System.out.println("**Lỗi dữ liệu. Nhập lại.**");
            }
        }
        return s;
    }
        
    public String kiemTraMaHdn(){
	String s;
	String regex="HDN[0-9]{3}";
        while(true){
            try{
                s=sc.nextLine();
                if(s.matches(regex)==true)
                    break;
                else{
                    System.out.println("!!!Ma hoa don khong hop le!!!");
                    System.out.println("Yeu cau ma hoa don gom 6 ki tu: HDN(0-9)");
                    System.out.print("Nhap lai ma hoa don nhap: ");
                }
            }
            catch(Exception e){
                System.out.println("**Lỗi dữ liệu. Nhập lại.**");
            }
        }
        return s;
    }
    
    public String kiemTraMaHdx(){
	String s;
	String regex="HDX[0-9]{3}";
        while(true){
            try{
                s=sc.nextLine();
                if(s.matches(regex)==true)
                    break;
                else{
                    System.out.println("!!!Ma hoa don khong hop le!!!");
                    System.out.println("Yeu cau ma hoa don gom 6 ki tu: HDX(0-9)");
                    System.out.print("Nhap lai ma hoa don xuat: ");
                }
            }
            catch(Exception e){
                System.out.println("**Lỗi dữ liệu. Nhập lại.**");
            }
        }
        return s;
    }

    public String kiemTraMaNv(){
	String s;
	String regex="[0-9]{6}";
        while(true){
            try{
                s=sc.nextLine();
                if(s.matches(regex)==true)
                    break;
                else{
                    System.out.println("!!!Ma nhan vien khong hop le!!!");
                    System.out.println("Yeu cau ma nhan vien gom 6 ki tu (0-9)");
                    System.out.print("Nhap lai ma nhan vien: ");
                }
            }
            catch(Exception e){
                System.out.println("**Lỗi dữ liệu. Nhập lại.**");
            }
        }
        return s;
    }
    
    public String kiemTraMaKh(){
	String s;
	String regex="[0-9]{6}";
        while(true){
            try{
                s=sc.nextLine();
                if(s.matches(regex)==true)
                    break;
                else{
                    System.out.println("!!!Ma khach hang khong hop le!!!");
                    System.out.println("Yeu cau ma khach hang gom 6 ki tu (0-9)");
                    System.out.print("Nhap lai ma khach hang: ");
                }
            }
            catch(Exception e){
                System.out.println("**Lỗi dữ liệu. Nhập lại.**");
            }
        }
        return s;
    }
    
    public String kiemTraMa(){
	String s;
	String regex="[0-9]{6}";
        while(true){
            try{
                s=sc.nextLine();
                if(s.matches(regex)==true)
                    break;
                else
                    System.out.println("**Mã chứa kí tự lạ hoặc không phù hợp. Nhập lại.**");
            }
            catch(Exception e){
                System.out.println("**Lỗi dữ liệu. Nhập lại.**");
            }
        }
        return s;
    }

    public String kiemTraSdt() {
	String sdt;
	String regex = "0[1-9][0-9]{8}";
	while(true){
            try{
                sdt=sc.nextLine();
                if(sdt.matches(regex)==true)
		break;
                else{
                    System.out.println("!!!So dien thoai khong hop le!!!");
                    System.out.print("Nhap lai so dien thoai: ");
                }
            }
            catch(Exception e){
		System.out.println("**Lỗi dữ liệu . Nhập lại.**");
            }
	}
	return sdt;
    }
    
    public String kiemTraThang() {
	String thang;
	String regex = "[1-9]{1}";
        String regex1 = "1[0-2]{1}";
	while(true){
            try{
                thang=sc.nextLine();
                if(thang.matches(regex)==true)
                    break;
                else if(thang.matches(regex1)==true)
                    break;
                else{
                    System.out.println("!!!Thang khong hop le!!!");
                    System.out.print("Nhap lai thang: ");
                }
            }
            catch(Exception e){
		System.out.println("**Lỗi dữ liệu . Nhập lại.**");
            }
	}
	return thang;
    }
    
    public String kiemTraNam() {
	String nam;
	String regex = "20[1-2]{1}[0-9]{1}";
	while(true){
            try{
                nam=sc.nextLine();
                if(nam.matches(regex)==true)
                    break;
                else{
                    System.out.println("!!!Nam khong hop le!!!");
                    System.out.print("Nhap lai nam: ");
                }
            }
            catch(Exception e){
		System.out.println("**Lỗi dữ liệu . Nhập lại.**");
            }
	}
	return nam;
    }

    public String kiemTraTen(){
	String ten;
	String regex = "[\\pL\\p{Mn}*\\s]+";
        while(true){
            try{
                ten=sc.nextLine();
                if(ten.matches(regex)==true)
                    break;
                else{
                    System.out.println("!!!Nhap khong hop le!!!");
                    System.out.print("Nhap lai ten: ");
                }
            }
            catch(Exception e){
                System.out.println("** Lỗi dữ liệu. Nhập lại. **");
            }
        }
        return ten;
    }
    
    public String kiemTraTenNv(){
	String ten;
	String regex = "[\\pL\\p{Mn}*\\s]+";
        while(true){
            try{
                ten=sc.nextLine();
                if(ten.matches(regex)==true)
                    break;
                else{
                    System.out.println("!!!Ho ten nhan vien khong hop le!!!");
                    System.out.print("Nhap lai ho ten nhan vien: ");
                }
            }
            catch(Exception e){
                System.out.println("** Lỗi dữ liệu. Nhập lại. **");
            }
        }
        return ten;
    }
    
     public String kiemTraTenKh(){
	String ten;
	String regex = "[\\pL\\p{Mn}*\\s]+";
        while(true){
            try{
                ten=sc.nextLine();
                if(ten.matches(regex)==true)
                    break;
                else{
                    System.out.println("!!!Ho ten khach hang khong hop le!!!");
                    System.out.print("Nhap lai ho ten khach hang: ");
                }
            }
            catch(Exception e){
                System.out.println("** Lỗi dữ liệu. Nhập lại. **");
            }
        }
        return ten;
    }

    public int kiemTraInt() {
	int Int=0;
	while(true){
            try{
		Int = Integer.parseInt(sc.nextLine());
		if(Int<0){
                    System.out.println("!!!Nhap chon khong phu hop!!!");
                    System.out.print("Chon lai: ");
                }
                else
                    break;
            }
            catch(Exception e){
		System.out.println("!!!Nhap chon khong phu hop!!!");
                System.out.print("Chon lai: ");
            }
	}
	return Int;
    }
    
    public int kiemTraSoLuong() {
	int Int=0;
	while(true){
            try{
		Int = Integer.parseInt(sc.nextLine());
		if(Int<0){
                    System.out.println("!!!Nhap so luong khong phu hop!!!");
                    System.out.print("Nhap lai so luong: ");
                }
                else
                    break;
            }
            catch(Exception e){
		System.out.println("!!!Nhap so luong khong phu hop!!!");
                    System.out.print("Nhap lai so luong: ");
            }
	}
	return Int;
    }
    
    public String kiemTraTien(){
        String tien;
	String regex = "[1-9]{1}[0-9]{4,9}";
	while(true){
            try{
                tien=sc.nextLine();
                if(tien.matches(regex)==true)
                    break;
                else{
                    System.out.println("!!!Gia tien khong hop le!!!");
                    System.out.print("Nhap lai tien: ");
                }
            }
            catch(Exception e){
		System.out.println("**Lỗi dữ liệu . Nhập lại.**");
            }
	}
	return tien;
    }
}