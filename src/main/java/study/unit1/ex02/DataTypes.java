package study.unit1.ex02;

public class DataTypes {

    public static void main(String[] args) {

        final int arraysize = 10;

        final double epsilon = 0.02; //change Ɛ here

        int min_index = 0;
        double[] array = new double[arraysize];

        for (int i = 0; i < arraysize; i++) {
            array[i] = 1. / ((i + 1) * (i + 1));
            if (min_index == 0 && array[i] < epsilon)
                min_index = i;
            System.out.printf("\n a[%d]- %.5f", i, array[i]);
        }
        System.out.printf("\nMinimal index is %d", min_index);

        //a[0]- 1,00000
        //a[1]- 0,25000
        //a[2]- 0,11111
        //a[3]- 0,06250
        //a[4]- 0,04000
        //a[5]- 0,02778
        //a[6]- 0,02041
        //a[7]- 0,01563
        //a[8]- 0,01235
        //a[9]- 0,01000
        //Minimal index is 7

    }
}
