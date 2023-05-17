import java.util.Arrays;

public class MinMaxHeap {

    int[] heapArr;
    //int length = heapArr.length;

    public MinMaxHeap(int[] heapArr){
        this.heapArr = heapArr;

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
    private boolean hasChildren(int[] h, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        return leftChild < h.length || rightChild < h.length;
    }

    public boolean isGrandChild(int i, int d) {
       // if (d == 4 * i || d == 4 * i + 1 || d == 4 * i + 2 || d == 4 * i + 3) {
           // return true;
      // }
        //return false;
        int parent = parent(i);
        return parent != -1 && parent(d) == parent;


    }

    public boolean isEvenLvl(int i) {

        int level = (int) (Math.log(i + 1) / Math.log(2));
        return level % 2 == 0;

    }
    private int findBiggest(int[] heapArr, int i) {
    int leftChild = 2 * i + 1;
    int rightChild = 2 * i + 2;
    int biggestChild = leftChild;

    if (rightChild < this.heapArr.length && heapArr[rightChild] > heapArr[leftChild]) {
        biggestChild = rightChild;
    }

    int leftGrandchild = 2 * leftChild + 1;
    int rightGrandchild = 2 * leftChild + 2;
    int rightLeftGrandchild = 2 * leftChild + 3;
    int rightRightGrandchild = 2 * leftChild + 4;

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



    private int findSmallest(int[] h, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int smallestChild = leftChild;

        if (rightChild < h.length && h[rightChild] < h[leftChild]) {
            smallestChild = rightChild;
        }

        int leftGrandchild = 2 * leftChild + 1;
        int rightGrandchild = 2 * leftChild + 2;
        int rightLeftGrandchild = 2 * leftChild + 3;
        int rightRightGrandchild = 2 * leftChild + 4;

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





   public void heapify(int[] heapArr, int m) {
        while (2 * m < heapArr.length) {
            int i = m;
            if (isEvenLvl(m)) {
                m = findBiggest(heapArr,i);
                if (heapArr[m] > heapArr[i]) {
                    int temp = heapArr[i];
                    heapArr[i] = heapArr[m];
                    heapArr[m] = temp;
                    if (isGrandChild(i, m)) {
                        if (heapArr[m] > heapArr[parent(m)]) {
                            int temp2 = heapArr[m];
                            heapArr[m] = heapArr[parent(m)];
                            heapArr[parent(m)] = temp2;

                        }

                    }

                }


            } else {
                m = findSmallest(heapArr,i);
                if (heapArr[m] < heapArr[i]) {
                    int temp = heapArr[i];
                    heapArr[i] = heapArr[m];
                    heapArr[m] = temp;
                    if (isGrandChild(i, m)) {
                        if (heapArr[m] < heapArr[parent(m)]) {
                            int temp2 = heapArr[m];
                            heapArr[m] = heapArr[parent(m)];
                            heapArr[parent(m)] = temp2;


                        }


                    }


                }


            }
        }
    }



    public void buildHeap(int[] heapArr){
        for(int i = heapArr.length/2; i>=0; i--){
            heapify(heapArr,i);


        }


    }


    public  void main(String[] args) {
        int[] a = new int[]{3,50,20,8,45,19,50,100,17,90};
        buildHeap(a);
        Arrays.toString(a);

    }

}
