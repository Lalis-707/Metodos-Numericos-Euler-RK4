package Ecuaciones_Lineales.Unidad05y06.MetodoEuler;

public class MetodoEuler {

    public static double evaluarFuncion(double x, double y) {
        return x - y;
    }

    public static double solucionExacta(double x) {
        return x - 1 + 2 * Math.exp(-x);
    }

    public static void resolver(double x0, double y0,
                                double h, double xFinal) {

        int nPasos = (int) Math.round((xFinal - x0) / h);

        double x = x0;
        double y = y0;

        System.out.println("\nMETODO DE EULER");
        System.out.println("h = " + h);

        System.out.printf("%-5s %-10s %-15s %-15s %-15s%n",
                "n", "x", "Euler", "Exacta", "Error");

        for (int i = 0; i <= nPasos; i++) {

            double exacta = solucionExacta(x);
            double error = Math.abs(exacta - y);

            System.out.printf(
                    "%-5d %-10.4f %-15.8f %-15.8f %-15.8f%n",
                    i, x, y, exacta, error
            );

            if (i < nPasos) {
                double pendiente = evaluarFuncion(x, y);

                y = y + h * pendiente;
                x = x + h;
            }
        }
    }
}