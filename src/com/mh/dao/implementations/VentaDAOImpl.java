package com.mh.dao.implementations;

import com.mh.biz.pojo.Venta;
import com.mh.dao.interfaces.VentaDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Pedro Rodriguez Aranda
 */
public class VentaDAOImpl implements VentaDAO, AutoCloseable {

    static {
        try {
            Class.forName(com.mh.utils.Configuration.DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Connection con = null;

    public VentaDAOImpl() throws Exception {
        try {
            con = DriverManager.getConnection(com.mh.utils.Configuration.URL);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void insertarVenta(Venta venta) throws Exception {

        String sql = "INSERT INTO venta(fecha_hora,posicion,nombre,precio,tipo,cantidad) VALUES (datetime('now'),?,?,?,?,?)";
        ResultSet rs = null;

        try (PreparedStatement ps = con.prepareStatement(sql);) {

            ps.setString(1, venta.getPosicion());
            ps.setString(2, venta.getNombre());
            ps.setDouble(3, venta.getPrecio());
            ps.setString(4, venta.getTipo());
            ps.setInt(5, venta.getCantidad());

            int r = ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
        }

    }

    @Override
    public List<Venta> getVentas() throws Exception {
        List<Venta> ventas = new ArrayList<Venta>();
        String sql = "SELECT fecha_hora, posicion, nombre, precio, tipo, cantidad FROM venta order by fecha_hora desc;";

        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {
                ventas.add(new Venta(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getDouble(4),
                        rs.getString(5), rs.getInt(6)));
            }

        } catch (Exception e) {
            throw e;
        }
        return ventas;
    }

    @Override
    public void close() throws Exception {
        con.close();
    }

}
