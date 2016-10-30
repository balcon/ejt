package study.unit1.ex04;

public class Arrays {

    public static void main(String[] args) {

        double[] array = {1.2, 6.6, 3.4, 7.8, 1.9, 2.78, 3.1415, 2.7};
        double max = Double.MIN_VALUE;
        for (int i = 0; i < array.length / 2; i++) {
            double a = array[i] + array[array.length - i - 1];
            if (a > max) max = a;
        }
        System.out.println("Max=" + max);

        //Max=9.7415
    }
}