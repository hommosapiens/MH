package com.mh.gui;

import com.mh.biz.pojo.Helado;
import com.mh.biz.*;
import com.mh.exceptions.*;
import java.util.Scanner;

public class Exec {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MaquinaHelados mh = null;
        try {
            mh = new MaquinaHelados();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String opcion;
        do {
            opcion = menu(sc);
            switch (opcion) {
                case "1":
                    mostrar(mh);
                    break;
                case "2":
                    introDinero(mh, sc);
                    break;
                case "3":
                    pedirHelado(mh, sc);
                    break;
            }
        } while (!opcion.equalsIgnoreCase("S"));
        salir(mh);
    }

    public static String menu(Scanner sc) {
        String opcion = "";
        System.out.println("--------------Menú principal-----------");
        System.out.println("1.- Mostrar helados");
        System.out.println("2.- Introducir monedas");
        System.out.println("3.- Pedir helado");
        System.out.println("S.- Salir y apagar máquina de helados");
        do {
            System.out.println("--------------------------------------");
            System.out.print("Introduzca una opción: ");
            opcion = sc.nextLine();
        } while (!(opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equalsIgnoreCase("S")));
        return opcion;
    }

    public static void mostrar(MaquinaHelados mh) {

        try {
            System.out.println("-----Listado de helados------");
            System.out.println(mh.cargarHelados());
            System.out.println("-----------------------------");
            System.out.println("Dispones de " + mh.getMonedero() + "€");
            System.out.println("-----------------------------");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado. Por favor, contacte con el administrador.");
        }

    }

    public static void introDinero(MaquinaHelados mh, Scanner sc) {
        String opcion;
        System.out.println("---------Introduzca monedas--------");
        mostrarMonedas();
        do {
            System.out.print("Elija una opción: ");
            opcion = sc.nextLine();
            if ((!(opcion.equalsIgnoreCase("A") || opcion.equalsIgnoreCase("B") 
                    || opcion.equalsIgnoreCase("C") || opcion.equalsIgnoreCase("D") 
                    || opcion.equalsIgnoreCase("E") || opcion.equalsIgnoreCase("F")
                    || opcion.equalsIgnoreCase("S")))) {
                System.out.print("Opción incorrecta. ");
            } else {
                if (!opcion.equalsIgnoreCase("S")) {
                    mh.setMonedero(mh.getMonedero() + traducirDinero(opcion.toUpperCase()));
                    System.out.println("El dinero acumulado es: " + mh.getMonedero() + "€");
                }
            }
        } while (!(opcion.equalsIgnoreCase("S")));
    }

    public static double traducirDinero(String opcion) {
        switch (opcion) {
            case "A":
                return 0.05d;
            case "B":
                return 0.1d;
            case "C":
                return 0.2d;
            case "D":
                return 0.5d;
            case "E":
                return 1d;
            case "F":
                return 2d;
            default:
                return 0d;
        }
    }

    public static void mostrarMonedas() {
        System.out.println("A.- 0,05€");
        System.out.println("B.- 0,10€");
        System.out.println("C.- 0,20€");
        System.out.println("D.- 0,50€");
        System.out.println("E.- 1,00€");
        System.out.println("F.- 2,00€");
        System.out.println("S.- Salir");
    }

    public static void pedirHelado(MaquinaHelados mh, Scanner sc) {
        Helado conseguido;
        String posicion = "";
        System.out.println("------------Pedir Helado-------------");
        System.out.print("Introduzca la posición: ");
        posicion = sc.nextLine();
        try {
            conseguido = mh.pedirHelado(posicion);
            if (conseguido != null) {
                System.out.println("Aquí tiene su " + conseguido.getNombre() + " de tipo " + conseguido.getTipo());
                System.out.println("No olvide su cambio: " + mh.getMonedero() + "€");
                mh.setMonedero(0);
            }
        } catch (NotValidPositionException e) {
            System.out.println("Posición introducida inexistente");
        } catch (QuantityExceededException e) {
            System.out.println("No quedan helados en esa posición");
        } catch (NotEnoughMoneyException e) {
            System.out.println("No tiene dinero suficiente para ese helado");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado. Por favor, contacte con el administrador.");
        }
    }
    
    public static void salir(MaquinaHelados mh) {
        System.out.println("-----------------------------");
        System.out.println("Apagando máquina de helados.....");
        System.out.println("No olvide recoger su cambio: " + mh.getMonedero() + "€");
        System.out.println("Ingresos totales de la máquina de helados: " + mh.getIngresos() + "€");
        System.out.println("-----------------------------");
    }

}
