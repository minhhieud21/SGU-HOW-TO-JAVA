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
 * @author SeaPhan
 */
public class DangNhap {
   public DangNhap(){}
    public static boolean checkMsnv(String str){
        return str.matches("^[0-9]{6}");
    }
    Scanner sc = new Scanner(System.in);
    public int login() throws IOException{
        int ketqua = 0;
        int dem = 0;
        boolean bien = false;
        while(bien == false){
            System.out.print("MSNV : ");
            String kt = sc.nextLine();
            String msnvv = kt.toLowerCase();
            if(checkMsnv(msnvv)==true){
                DanhSachTK tk = new DanhSachTK();
                tk.docfile();
                int kiemtra = tk.TimKiem(msnvv) ;
                if(kiemtra != -1){
                    while(bien == false){
                        System.out.print("PassWord : ");
                        String nhap = sc.nextLine();
                        if(tk.ktPass(nhap,kiemtra) == true){
                            ketqua = tk.LayQuyen(kiemtra);
                            bien =true;
                            break;  }
                        else {
                            System.out.println("Sai PassWord !!Nhap lai\n");
                            dem++;
                            if(dem==5){
                                System.out.print("Ban Nhap Sai Nhieu Lan ! Thu lai sau!\n\n");
                                bien = true;
                            }
                        }
                        }
                    
                }
                else {
                    System.out.println("MSNV nay chua co tai khoan!\n");}
            }
            else System.out.println("MSNV la 6 chu so !!\n");
        }
        return ketqua;
        
    }
    public static void main(String[] args) throws IOException {
        DangNhap dn = new DangNhap();
        System.out.print(dn.login());    
    } 
}
