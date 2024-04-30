package com.mh.biz.pojo;

import com.mh.utils.Utils;

public class Helado {
    private String posicion;
    private String nombre;
    private double precio;
    private String tipo;
    private int cantidad = 5;
    
    public Helado(String posicion, String nombre, double precio, String tipo, int cantidad) {
        this.posicion = posicion;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return  posicion + " :: " + nombre + " :: " + precio + "€ :: " + tipo + " :: " + cantidad ;
    }
    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPosicion() {
        return posicion;
    }
}
