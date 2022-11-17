/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller;

import com.view.form_perpus;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public interface interface_perpus {
    public void Simpan(form_perpus p) throws SQLException;
    public void Ubah(form_perpus p) throws SQLException;
    public void Hapus(form_perpus p) throws SQLException;
    public void Tampil(form_perpus p) throws SQLException;
    public void Baru(form_perpus p) throws SQLException;
    public void KlikTabel(form_perpus p) throws SQLException;
}
