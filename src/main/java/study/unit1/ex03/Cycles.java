package study.unit1.ex03;

import static java.lang.Math.tan;

public class Cycles {

    public static void main(String[] args) {

        final double a = -10;
        final double b = 13;
        final double h = 3.1;
        System.out.println("\tx\t\t\tF(x)");
        for (double x = a; x <= b; x += h) System.out.printf("%7.2f %10.2f\n", x, tan(2 * x) - 3);

        //   x			F(x)
        // -10,00      -5,24
        // -6,90       -5,85
        // -3,80       -6,85
        // -0,70       -8,80
        // 2,40        -14,38
        // 5,50        -228,95
        // 8,60        9,67
        // 11,70       3,12
    }

}