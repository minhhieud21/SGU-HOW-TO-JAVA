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
import java.io.IOException;

public interface DanhSach{
    void NhapDanhSach() throws IOException;
    void XuatDanhSach() throws IOException;
    void Them() throws IOException;
    void Themkphantu() throws IOException;
    void Xoa() throws IOException;
    void Sua() throws IOException;
    void docfile() throws IOException;
    void ghifile() throws IOException;
}
