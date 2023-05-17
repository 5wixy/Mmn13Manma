import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[]{3,50,20,8,45,19,50,100,17,90};
        MinMaxHeap minMaxHeap = new MinMaxHeap(a);
        minMaxHeap.buildHeap(a);



        System.out.println(Arrays.toString(minMaxHeap.heapInsert(a,120)));
        System.out.println(Arrays.toString(a));

    }
}