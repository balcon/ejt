package study.unit1.ex05;

public class Arrays2D {

    public static void main(String[] args) {

        final int matrixsize=11;
        int[][] matrix=new int[matrixsize][matrixsize];

        for(int i=0;i<matrixsize;i++){
            matrix[i][i]=1;
            matrix[i][matrixsize-i-1]=1;
        }

        for(int[] row:matrix){
            for(int element:row) System.out.print(element+" ");
            System.out.println();
        }

        // 1 0 0 0 0 0 0 0 0 0 1
        // 0 1 0 0 0 0 0 0 0 1 0
        // 0 0 1 0 0 0 0 0 1 0 0
        // 0 0 0 1 0 0 0 1 0 0 0
        // 0 0 0 0 1 0 1 0 0 0 0
        // 0 0 0 0 0 1 0 0 0 0 0
        // 0 0 0 0 1 0 1 0 0 0 0
        // 0 0 0 1 0 0 0 1 0 0 0
        // 0 0 1 0 0 0 0 0 1 0 0
        // 0 1 0 0 0 0 0 0 0 1 0
        // 1 0 0 0 0 0 0 0 0 0 1

    }
}