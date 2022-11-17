/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model;

import com.koneksi.koneksi;
import com.view.form_perpus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class model_perpus implements com.controller.interface_perpus{

    @Override
    public void Simpan(form_perpus p) throws SQLException {
         try {
            Connection con = koneksi.getcon();
            String sql = "insert into rakBuku values(?,?)";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, p.txtNo.getText());
            prepare.setString(2, p.txtJudul.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
            prepare.close();
            Baru(p);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(p);
            p.setLebarKolom();
        }
    }

    @Override
    public void Ubah(form_perpus p) throws SQLException {
          try {
            Connection con = koneksi.getcon();
            String sql = "update rakBuku set No=?, Judul_Buku=?, " + " where No=?";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, p.txtNo.getText());
            prepare.setString(2, p.txtJudul.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diSimpan");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(p);
            p.setLebarKolom();
            Baru(p);
        }
    }

    @Override
    public void Hapus(form_perpus p) throws SQLException {
         try {
            Connection con = koneksi.getcon();
            String sql = "delete from rakBuku WHERE No = ?";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, p.txtNo.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(p);
            p.setLebarKolom();
            Baru(p);
        }
    }

    @Override
    public void Tampil(form_perpus p) throws SQLException {
         p.tblmodel.getDataVector().removeAllElements();
        p.tblmodel.fireTableDataChanged();
        try {
            Connection con = koneksi.getcon();
            Statement stt = con.createStatement();
            String sql = "select * from rakBuku ";
            ResultSet res = stt.executeQuery(sql);
            while (res.next()) {
                Object[] ob = new Object[8];
                ob[0] = res.getString(1);
                ob[1] = res.getString(2);
                p.tblmodel.addRow(ob);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Baru(form_perpus p) throws SQLException {
        p.txtNo.setText("");
        p.txtJudul.setText("");
    }

    @Override
    public void KlikTabel(form_perpus p) throws SQLException {
         try {
            int pilih = p.tableBuku.getSelectedRow();
            if (pilih == -1) {
                return;
            }
            p.txtNo.setText(p.tblmodel.getValueAt(pilih, 0).toString());
            p.txtJudul.setText(p.tblmodel.getValueAt (pilih, 1).toString());   
        } catch (Exception e) {   
        }      
    }    
}
