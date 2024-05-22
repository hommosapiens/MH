package com.mh.dao.interfaces;

import com.mh.biz.pojo.Venta;
import java.util.List;

public interface VentaDAO {

    public void insertarVenta(Venta venta) throws Exception;

    public List<Venta> getVentas() throws Exception;

}
