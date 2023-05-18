import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[]{19,7,60,90,1005,200,3,2,9,30,27,7};
        MinMaxHeap minMaxHeap = new MinMaxHeap(a);
        minMaxHeap.buildHeap(a);
        //int[] arrNew = new int[a.length];
        //arrNew = minMaxHeap.heapDelete(a,1);
       // minMaxHeap.heapDelete(a,1);
       //System.out.println(Arrays.toString(arrNew) + "  " + Arrays.toString(a));
       minMaxHeap.heapSort(a);
       System.out.println(Arrays.toString(a));

    }
}