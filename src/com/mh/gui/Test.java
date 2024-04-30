package com.mh.gui;

import com.mh.biz.MaquinaHelados;
import com.mh.biz.pojo.Venta;

public class Test {

    public static void main(String[] args) {
        MaquinaHelados mh = new MaquinaHelados();

        try {
            for (Venta venta : mh.cargarVentas()) {
                System.out.println(venta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
