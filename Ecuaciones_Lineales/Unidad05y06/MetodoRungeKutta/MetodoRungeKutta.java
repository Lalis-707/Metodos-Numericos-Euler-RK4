package Ecuaciones_Lineales.Unidad05y06.MetodoRungeKutta;

public class MetodoRungeKutta {

    public static double evaluarFuncion(double x, double y) {
        return x + y;
    }

    public static double solucionExacta(double x) {
        return 2 * Math.exp(x) - x - 1;
    }

    public static void resolver(double x0, double y0,
                                double h, double xFinal) {

        int nPasos = (int) Math.round((xFinal - x0) / h);

        double x = x0;
        double y = y0;

        System.out.println("\nMETODO RUNGE-KUTTA DE 4to ORDEN");
        System.out.println("h = " + h);

        System.out.printf("%-5s %-10s %-15s %-15s %-15s%n",
                "n", "x", "RK4", "Exacta", "Error");

        for (int i = 0; i <= nPasos; i++) {

            double exacta = solucionExacta(x);
            double error = Math.abs(exacta - y);

            System.out.printf(
                    "%-5d %-10.4f %-15.8f %-15.8f %-15.8f%n",
                    i, x, y, exacta, error
            );

            if (i < nPasos) {

                double k1 = evaluarFuncion(x, y);

                double k2 = evaluarFuncion(
                        x + h / 2,
                        y + (h / 2) * k1
                );

                double k3 = evaluarFuncion(
                        x + h / 2,
                        y + (h / 2) * k2
                );

                double k4 = evaluarFuncion(
                        x + h,
                        y + h * k3
                );

                y = y + (h / 6) *
                        (k1 + 2 * k2 + 2 * k3 + k4);

                x = x + h;
            }
        }
    }
}