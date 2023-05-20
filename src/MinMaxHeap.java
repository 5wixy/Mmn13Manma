import javax.swing.*;
import java.util.Arrays;

public class MinMaxHeap {

    double[] heapArr;
    int size;

    public MinMaxHeap(double[] heapArr){
        this.heapArr = heapArr;
        this.size = heapArr.length;

    }
    public int left(int i) {
        return 2 * i+1;

    }

    public int right(int i) {

        return 2 * i + 2;
    }

    public int parent(int i) {
        if (i == 0) {
            return -1; // Root node has no parent
        }
        return (i - 1) / 2;

    }
    private boolean hasChildren(double[] heapArr, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        return leftChild < heapArr.length || rightChild < heapArr.length;
    }

    public boolean isGrandChild(int i, int d) {

        int parentL = left(i);
        int parentR = right(i);
        return parent(d) == parentL || parent(d) == parentR;


    }

    public boolean isEvenLvl(int i) {

        int level = (int) (Math.log(i + 1) / Math.log(2));
        return level % 2 == 0;

    }
    private int findBiggest(double[] heapArr, int i) {
    int leftChild = 2 * i + 1;
    int rightChild = 2 * i + 2;
    int biggestChild = leftChild;
    int leftGrandchild = 2 * leftChild + 1;
    int rightGrandchild = 2 * leftChild + 2;
    int rightLeftGrandchild = 2 * leftChild + 3;
    int rightRightGrandchild = 2 * leftChild + 4;

    if (rightChild < heapArr.length && heapArr[rightChild] > heapArr[biggestChild]) {
        biggestChild = rightChild;
    }

    if (rightGrandchild < heapArr.length && heapArr[rightGrandchild] > heapArr[biggestChild]) {
        biggestChild = rightGrandchild;
    }

    if (leftGrandchild < heapArr.length && heapArr[leftGrandchild] > heapArr[biggestChild]) {
        biggestChild = leftGrandchild;
    }
        if (rightLeftGrandchild < heapArr.length && heapArr[rightLeftGrandchild] > heapArr[biggestChild]) {
            biggestChild = rightLeftGrandchild;
        }
        if (rightRightGrandchild < heapArr.length && heapArr[rightRightGrandchild] > heapArr[biggestChild]) {
            biggestChild = rightRightGrandchild;
        }

    return biggestChild;
}



    private int findSmallest(double[] h, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int smallestChild = leftChild;
        int leftGrandchild = 2 * leftChild + 1;
        int rightGrandchild = 2 * leftChild + 2;
        int rightLeftGrandchild = 2 * leftChild + 3;
        int rightRightGrandchild = 2 * leftChild + 4;

        if (rightChild < h.length && h[rightChild] < h[smallestChild]) {
            smallestChild = rightChild;
        }
        if (rightGrandchild < h.length && h[rightGrandchild] < h[smallestChild]) {
            smallestChild = rightGrandchild;
        }

        if (leftGrandchild < h.length && h[leftGrandchild] < h[smallestChild]) {
            smallestChild = leftGrandchild;
        }
        if (rightLeftGrandchild < h.length && h[rightLeftGrandchild] < h[smallestChild]) {
            smallestChild = rightLeftGrandchild;
        }
        if (rightRightGrandchild < h.length && h[rightRightGrandchild] < h[smallestChild]) {
            smallestChild = rightRightGrandchild;
        }

        return smallestChild;
    }



    public void heapify(double[] heapArr, int m) {
        while (2* m < heapArr.length) {
            int i = m;
            if (isEvenLvl(m)) {
                if (hasChildren(heapArr,m)) {
                    m = findBiggest(heapArr, i);
                    if (heapArr[m] > heapArr[i]) {
                        double temp = heapArr[i];
                        heapArr[i] = heapArr[m];
                        heapArr[m] = temp;
                        if (isGrandChild(i, m)) {
                            if (heapArr[m] < heapArr[parent(m)]) {
                                swap(heapArr,m,parent(m));

                            }

                        }

                    }

                }
                else break;
            } else {
                if (hasChildren(heapArr,m)) {
                    m = findSmallest(heapArr, i);
                    if (heapArr[m] < heapArr[i]) {
                        double temp = heapArr[i];
                        heapArr[i] = heapArr[m];
                        heapArr[m] = temp;
                        if (isGrandChild(i, m)) {
                            if (heapArr[m] > heapArr[parent(m)]) {
                                swap(heapArr,m,parent(m));


                            }


                        }


                    }

                }
                else break;
            }
        }
    }


    public void buildHeap(double[] heapArr){
        for(int i = heapArr.length/2; i>=0; i--){
            heapify(heapArr,i);

        }


    }
    public double[] heapExtractMax(double[] heapArr){
        if(heapArr.length < 1){
            System.out.println("ERROR: HEAP UNDERFLOWmax");
        }
        double max = heapArr[0];
        int maxInd = 0;
        swap(heapArr,maxInd,heapArr.length-1);

        heapArr = heapDelete(heapArr, heapArr.length-1);
        int index = heapArr.length-1;
        while(index > 0) {
            heapify(heapArr, 0);
            index = parent(index);

        }
        this.size--;
        System.out.println(max);
        return heapArr;

    }
    public double[] heapExtractMin(double[] heapArr){
        if(size < 1){
            System.out.println("ERROR: HEAP UNDERFLOW");
        }

        double min = Integer.MAX_VALUE;
        int minInd = Integer.MAX_VALUE;

        if(heapArr.length == 1){
            min = heapArr[0];
            minInd = 0;
            heapArr = heapDelete(heapArr,0);
            System.out.println(min);

            return heapArr;
        }
        if(right(0) < size){
            if(heapArr[left(0)] < heapArr[right(0)]){
                min = heapArr[left(0)];
                minInd = 1;

            }
            else{
                min = heapArr[right(0)];
                minInd = 2;
            }
        }
        if(size < 3){
            min = heapArr[left(0)];
            minInd = 1;

        }
        System.out.println(heapArr[minInd]);
        heapArr= heapDelete(heapArr, minInd);
        return heapArr;

    }
    public double[] heapInsert(double[] heapArr,double value){

        double[] tempHeap = Arrays.copyOf(heapArr,heapArr.length+1);

        tempHeap[tempHeap.length-1] = value;
        this.size++;
        int index = tempHeap.length-1;
        while(index >= 0){
            heapify(tempHeap,index);
            index = parent(index);

        }
        return tempHeap;



    }
    public double[] heapDelete(double[] heapArr, int i){
        int index=i;
        swap(heapArr,i,heapArr.length-1);
        double[] tempHeap = Arrays.copyOf(heapArr, heapArr.length - 1);
        size--;
        while (index>=0)
        {
            heapify(tempHeap,index);
            index = parent(index);
        }
        return tempHeap;
    }
    private void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public double[] heapSort(double[] heapArr) {
        int i = 0;
        double[] sorted = new double[heapArr.length];
        while(i < sorted.length){
            sorted[i] = heapArr[0];
            heapArr = heapDelete(heapArr,0);
            i++;
        }
        return sorted;
    }
}
