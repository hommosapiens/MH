package com.mh.biz;

import com.mh.biz.pojo.Helado;
import com.mh.biz.pojo.Venta;
import com.mh.dao.implementations.HeladoDAOImpl;
import com.mh.dao.implementations.VentaDAOImpl;
import com.mh.exceptions.*;
import com.mh.utils.Utils;
import java.util.List;

public class MaquinaHelados {

    private double monedero = 0;
    private double ingresos = 0;

    public Helado pedirHelado(String posicion) throws Exception {
        Helado h = null;

        try (HeladoDAOImpl hdi = new HeladoDAOImpl(); VentaDAOImpl vdi = new VentaDAOImpl();) {
            h = hdi.getHeladoByPosition(posicion);

            if (h == null) {
                throw new NotValidPositionException();
            } else if (h.getPrecio() > monedero) {
                throw new NotEnoughMoneyException();
            } else if (h.getCantidad() <= 0) {
                throw new QuantityExceededException();
            } else {
                Venta v = new Venta("", h.getPosicion(), h.getNombre(), h.getPrecio(), h.getTipo(), 1);
                vdi.insertarVenta(v);
                h.setCantidad(h.getCantidad() - 1);
                hdi.updateHelado(h);

                this.setMonedero(this.getMonedero() - h.getPrecio());
                this.setIngresos(this.getIngresos() + h.getPrecio());
            }
        } catch (Exception e) {
            throw e;
        }
        return h;
    }

    public List<Helado> cargarHelados() throws Exception {
        List<Helado> helados = null;
        try (HeladoDAOImpl hdi = new HeladoDAOImpl();) {
            helados = hdi.getListHelado();
        } catch (Exception e) {
            throw e;
        }
        return helados;
    }

    public List<Venta> cargarVentas() throws Exception {
        List<Venta> ventas = null;
        try (VentaDAOImpl hdi = new VentaDAOImpl();) {
            ventas = hdi.getVentas();
        } catch (Exception e) {
            throw e;
        }
        return ventas;
    }

    public double getMonedero() {
        return monedero;
    }

    public double getIngresos() {
        return ingresos;
    }

    public void setMonedero(double monedero) {
        this.monedero = Utils.redondeoDosDecimales(monedero);
    }

    public void setIngresos(double ingresos) {
        this.ingresos = Utils.redondeoDosDecimales(ingresos);
    }

}
