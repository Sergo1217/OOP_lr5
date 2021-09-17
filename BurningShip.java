import java.awt.geom.Rectangle2D;

/**
 * Этот класс вычисляет фрактал  BurningShip,
 * a также содержит метод инициализации диапазона
 */
public class BurningShip extends FractalGenerator {

    public static final int MAX_ITERATIONS = 2000;

    /**
     * Этот метод принимает объект диапазона.
     */
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -2.5;
        range.width = 4;
        range.height = 4;
    }

    /**
     * Метод реализует итерационную функция BurningShip
     * **/
    public int numIterations(double x, double y) {

        int count = 0;
        double re = 0;
        double im = 0;

        while (re * re + im * im <= 4) {
            double nextRe = re * re - im * im + x;
            double nextIm = 2 * re * im + y;

            re = Math.abs(nextRe);
            im = Math.abs(nextIm);
            if (count++ == Mandelbrot.MAX_ITERATIONS) return -1;
        }

        return count;
    }

    public String toString() {
        return "Burning Ship";
    }
}