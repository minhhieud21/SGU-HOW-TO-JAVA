/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author HieuPhan
 */
public class TaiKhoan{
    protected String Password;
    protected String Quyen;
    protected String msnv;
    Scanner sc = new Scanner(System.in);
    TaiKhoan(){
        this.msnv=null;
        this.Password=null;
        this.Quyen=null;
    }
    public TaiKhoan(String msnv,String Password,String Quyen){
        this.msnv=msnv;
        this.Password = Password;
        this.Quyen=Quyen;
    }
	public String getPassword() {
		return Password;
	}
	public void setPasswor() {
        System.out.print("PassWord : ");
        Password = sc.nextLine();
    }
    public String getQuyen() {
		return Quyen;
	}
	public void setQuye() {
        System.out.print("Nhap quyen duoc giao : \n1. Nhan vien\n2. Quan ly\nChon : ");
        Quyen = sc.nextLine();
        System.out.println();
    }
    public String getMsnv() {
		return msnv;
	}
	public void setMsn() {
        System.out.print("Nhap ma so nhan vien : ");
        msnv = sc.nextLine();
	}
    public static boolean checkPassword(String str){
        return str.matches("^[a-zA-Z0-9]{8,20}");
    }
    public static boolean checkMsnv(String str){
        return str.matches("^[0-9]{6}");
    }
    public static boolean checkQuyen(String str){
        return str.matches("^[1-2]{1}");
    } 
     
    public void NhapTK() throws IOException{
        DanhSachNhanVien nu = new DanhSachNhanVien();
        nu.docfile();
        DanhSachTK tk = new DanhSachTK();
        tk.docfile();
        boolean check = false;
        System.out.println("---------DANG KI---------");
            while(check == false){
                setMsn();
                if(checkMsnv(msnv)==true){
                    if(tk.TimKiem(msnv) != -1)
                        {System.out.println("MSNV nay da dang ki roi!\n");
                        check = false;}
                    else if(nu.TimKiem(msnv) == -1){
                            System.out.println("Ma nhan vien nay khong co trong danh sach nhan vien\n");
                            check = false ;}
                    else{
                        if(nu.LayQuyen(msnv) == 2){
                            Quyen = "2";
                        }
                        else {Quyen = "1";}
                        check = true;
                        break;}}
                else {
                    System.out.println("Ma so nhan vien gom co 6 so\n");}
                    }
        check = false;
        while(check == false){
            setPasswor();
            if(checkPassword(Password)==true){
                check = true;}
            else {
                System.out.println("Vui long nhap mat khau 8 den 20 chu cai hoac so !!\n");}
        }
        

    }
    public void XuatTK(){
        String mot = "1";
        String hai = "2";
        String ba = "3";
        if(Quyen.trim().equals(mot.trim())){
            System.out.printf("%-9s%-22s%-8s\n",msnv,Password,"NHAN VIEN");
        }
        if(Quyen.trim().equals(hai.trim())){
            System.out.printf("%-9s%-22s%-8s\n",msnv,Password,"QUAN LY");
        }
        if(Quyen.trim().equals(ba.trim())){
            System.out.printf("%-9s%-22s%-8s\n",msnv,Password,"ADMIN");
        }
    }
    public void ghifile() throws IOException{
        try { 
            FileOutputStream fos = new FileOutputStream("TaiKhoan.dat",true);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF(msnv);
            dos.writeUTF(Password);
            dos.writeUTF(Quyen);
            dos.close();
            fos.close();
       	} 
        catch (FileNotFoundException e) {
                e.printStackTrace();
        }
    }
	public void setPassword(String password) {
		Password = password;
	}
	public void setQuyen(String quyen) {
		Quyen = quyen;
	}
	public void setMsnv(String msnv) {
		this.msnv = msnv;
    }
    public static void main(String[] args) throws IOException {
        TaiKhoan tk = new TaiKhoan();
        tk.NhapTK();
    }
}
