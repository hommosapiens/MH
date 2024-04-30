package com.mh.dao.implementations;

import com.mh.biz.pojo.Helado;
import com.mh.dao.interfaces.HeladoDAO;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class HeladoDAOImpl implements HeladoDAO, AutoCloseable {

    static {
        try {
            Class.forName(com.mh.utils.Configuration.DRIVER);
        } catch (Exception e) {
            System.out.println("Error al cargar los drivers");
        }
    }

    Connection con = null;

    public HeladoDAOImpl() throws Exception {
        try {
            con = DriverManager.getConnection(com.mh.utils.Configuration.URL);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Helado getHeladoByPosition(String posicion) throws Exception {

        String sql = "SELECT posicion, nombre, precio, tipo, cantidad FROM helado WHERE posicion = ?";

        Helado h = null;
        ResultSet rs = null;

        try (PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, posicion);
            rs = ps.executeQuery();
            if (rs.next()) {
            h = new Helado(rs.getString(1), rs.getString(2),
                    rs.getInt(3), rs.getString(4), rs.getInt(5));
            }
            

        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return h;
    }

    @Override
    public int updateHelado(Helado h) throws Exception {
        int r = 0;
        String sql = "UPDATE helado SET cantidad = ?, nombre = ?, tipo = ?, precio = ? where posicion = ?";

        try (PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1, h.getCantidad());
            ps.setString(2, h.getNombre());
            ps.setString(3, h.getTipo());
            ps.setDouble(4, h.getPrecio());
            ps.setString(5, h.getPosicion());

            r = ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        }
        return r;
    }

    @Override
    public List<Helado> getListHelado() throws Exception {
        List<Helado> helados = new ArrayList<Helado>();
        String sql = "SELECT posicion, nombre, precio, tipo, cantidad FROM helado";

        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {
                helados.add(new Helado(rs.getString(1), rs.getString(2),
                        rs.getDouble(3), rs.getString(4), rs.getInt(5)));
            }

        } catch (Exception e) {
            throw e;
        }
        return helados;
    }

    @Override
    public void close() throws Exception {
        con.close();
    }

}
