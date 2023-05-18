import java.util.Arrays;

public class MinMaxHeap {

    int[] heapArr;
    int size;

    public MinMaxHeap(int[] heapArr){
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
    private boolean hasChildren(int[] h, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        return leftChild < h.length || rightChild < h.length;
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
    private int findBiggest(int[] heapArr, int i) {
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



    private int findSmallest(int[] h, int i) {
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





   public void heapify(int[] heapArr, int m) {
        while (2* m < heapArr.length) {
            int i = m;
            if (isEvenLvl(m)) {
                if (hasChildren(heapArr,m)) {
                    m = findBiggest(heapArr, i);
                    if (heapArr[m] > heapArr[i]) {
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
                else break;
            } else {
                if (hasChildren(heapArr,m)) {
                    m = findSmallest(heapArr, i);
                    if (heapArr[m] < heapArr[i]) {
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

                }
                else break;
            }
        }
    }



    public void buildHeap(int[] heapArr){
        for(int i = heapArr.length/2; i>=0; i--){
            heapify(heapArr,i);


        }


    }
    public int heapExtractMax(int[] heapArr){
        if(size < 1){
            System.out.println("ERROR: HEAP UNDERFLOW");
        }
        int max = heapArr[0];
        heapArr[0] = heapArr[heapArr.length-1];
        this.size--;
        //TODO REMOVE LAST
        heapify(heapArr,0);
        return max;

    }
    public int heapExtractMin(int[] heapArr){
        if(size < 1){
            System.out.println("ERROR: HEAP UNDERFLOW");
        }
        int min = Integer.MAX_VALUE;
        int minInd = Integer.MAX_VALUE;
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
        heapArr[minInd] = heapArr[heapArr.length-1];
        //TODO remove last
        heapify(heapArr,1);



        return min;
    }
    public int[] heapInsert(int[] heapArr,int key){

        int[] tempHeap = new int[heapArr.length+1];
        for (int i = 0; i < heapArr.length; i++) {
            tempHeap[i] = heapArr[i];
        }
        tempHeap[heapArr.length] = key;
        this.size++;
        int index = tempHeap.length-1;
        while(index >= 0){
            heapify(tempHeap,index);
            index = parent(index);
           // System.out.println(Arrays.toString(tempHeap));

        }
        this.heapArr = tempHeap;
        return tempHeap;


    }
    public int[] heapDelete(int[] heapArr, int i){
        int[] tempHeap = new int[heapArr.length-1];
        swap(heapArr,i,heapArr.length-1);
        for (int j = 0; j < tempHeap.length; j++) {
            tempHeap[j] = heapArr[j];
        }
        this.size--;
        int index = tempHeap.length-1;
        while(index > 0){
            heapify(tempHeap,index);
            index = parent(index);
        }
        this.heapArr = tempHeap;
        return tempHeap;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void heapSort(int[] heapArr) {
        int[] sorted = new int[heapArr.length];
        for (int i = 0; i < sorted.length ; i++)
            sorted[i]= heapExtractMin(heapArr);

       // System.out.println(Arrays.toString(sorted));
        }

       public void maxHeapify(int arr[], int i)
        {
            int largest = i; // Initialize largest as root
            int l = 2 * i + 1; // left = 2*i + 1
            int r = 2 * i + 2; // right = 2*i + 2

            // If left child is larger than root
            if (l < arr.length && arr[l] > arr[largest])
                largest = l;

            // If right child is larger than largest so far
            if (r < arr.length && arr[r] > arr[largest])
                largest = r;

            // If largest is not root
            if (largest != i) {
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;

                // Recursively heapify the affected sub-tree
                heapify(arr, largest);
            }
        }



}
