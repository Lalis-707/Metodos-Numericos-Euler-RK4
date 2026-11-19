package Ecuaciones_Lineales.Unidad05y06.MetodoRungeKutta;

import Ecuaciones_Lineales.Unidad05y06.MetodoEuler.MetodoEuler;

public class Main {

    public static void main(String[] args) {

        double x0 = 0.0;
        double y0 = 1.0;
        double xFinal = 0.3;

        // =========================================
        // METODO DE EULER
        // =========================================

        System.out.println("\n==========================================");
        System.out.println("          METODO DE EULER");
        System.out.println("==========================================");

        MetodoEuler.resolver(x0, y0, 0.1, xFinal);

        MetodoEuler.resolver(x0, y0, 0.05, xFinal);

        MetodoEuler.resolver(x0, y0, 0.01, xFinal);


        // =========================================
        // METODO RUNGE-KUTTA 4
        // =========================================

        System.out.println("\n==========================================");
        System.out.println("       RUNGE-KUTTA DE 4to ORDEN");
        System.out.println("==========================================");

        MetodoRungeKutta.resolver(
                x0,
                y0,
                0.1,
                xFinal
        );
    }
}