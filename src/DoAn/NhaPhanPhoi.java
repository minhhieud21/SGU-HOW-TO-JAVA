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
public class NhaPhanPhoi {
    CheckLoi cl=new CheckLoi();
    public String mnpp;
    public String tennpp;
    public String dienthoai;
    public String diachi;
    Scanner scanner = new Scanner(System.in);
    
    public NhaPhanPhoi(){
        this.mnpp=null;
        this.tennpp=null;
        this.dienthoai=null;
        this.diachi=null;
    }
    
    public NhaPhanPhoi(String mnpp,String tennpp,String dienthoai,String diachi){
        this.mnpp=mnpp;
        this.tennpp=tennpp;
        this.dienthoai=dienthoai;
        this.diachi=diachi;
    }

    public void setMnpp(String mnpp){
        this.mnpp = mnpp;
    }

    public void setTennpp(String tennpp){
        this.tennpp=tennpp;
    }

    public void setDienthoai(String dienthoai){
        this.dienthoai=dienthoai;
    }

    public void setDiachi(String diachi){
        this.diachi=diachi;
    }

    public String getMnpp(){
        return mnpp;
    }

    public String getTennpp(){
        return tennpp;
    }
    
    public String getDienthoai(){
        return dienthoai;
    }

    public String getDiachi(){
        return diachi;
    }
        
    public void NhapNpp(){
        System.out.print("Nhap ma nha phan phoi: ");
        mnpp=cl.kiemTraManpp();
        System.out.print("Nhap ten nha phan phoi: ");
        tennpp=cl.kiemTraTen();
        System.out.print("Nhap so dien thoai nha phan phoi: ");
        dienthoai=cl.kiemTraSdt();
        System.out.print("Nhap dia chi nha phan phoi: ");
        diachi=scanner.nextLine();
    }
    
    public void XuatNpp(){
        System.out.printf("%-25s%-25s%-15s%-25s\n",mnpp,tennpp,dienthoai,diachi);
    }

    @Override
    public String toString() {
        return mnpp+","+tennpp+","+dienthoai+","+diachi;
    }
    
    public void ghifile() throws IOException{
        try { 
            FileOutputStream fos = new FileOutputStream("NhaPhanPhoi.dat",true);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF(mnpp);
            dos.writeUTF(tennpp);
            dos.writeUTF(dienthoai);
            dos.writeUTF(diachi);
            dos.close();
            fos.close();
        } 
        catch (FileNotFoundException e) {
                e.printStackTrace();
        }
    }
}
