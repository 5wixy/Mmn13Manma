import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[]{19,7,60,90,1005,200,3,2,9,30,27,7};
        int[] list1 = new int[]{19, 7, 60, 90, 1005, 200, 3, 2, 9, 30, 27, 7};
        int[] list2 = new int[]{10, 25, 42, 88, 601, 303, 50, 12, 9, 30, 27, 7};
        int[] list3 = new int[]{17, 35, 74, 122, 890, 404, 20, 15, 9, 30, 27, 7};
        int[] list4 = new int[]{5, 8, 16, 32, 128, 256, 4, 2, 9, 30, 27, 7};
        int[] list5 = new int[]{1, 3, 6, 12, 24, 48, 96, 192, 9, 30, 27, 7};

        MinMaxHeap minMaxHeap = new MinMaxHeap(a);
        minMaxHeap.buildHeap(a);
        System.out.println(Arrays.toString(a));

        minMaxHeap.buildHeap(a);
        System.out.println(Arrays.toString(a));

        minMaxHeap.buildHeap(a);
        System.out.println(Arrays.toString(a));

        minMaxHeap.buildHeap(a);
        System.out.println(Arrays.toString(a));

        minMaxHeap.buildHeap(a);
        System.out.println(Arrays.toString(a));

        minMaxHeap.buildHeap(a);
        System.out.println(Arrays.toString(a));




    }
}