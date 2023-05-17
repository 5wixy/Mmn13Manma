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
        return (int) Math.floor((i-1)/2);

    }

    public boolean isGrandChild(int i, int d) {
        if (d == 4 * i || d == 4 * i + 1 || d == 4 * i + 2 || d == 4 * i + 3) {
            return true;
        }
        return false;


    }

    public boolean isEvenLvl(int i) {

        double lg2i = Math.log(i) / Math.log(2);


        if (lg2i % 2 == 0) {
            return true;
        }
        return false;

    }

    public int findSmallest(int i) {
       return findSmallest(i,Integer.MAX_VALUE);

    }

    private int findSmallest(int i, int min) {
        if(i >= heapArr.length){
            return min;

        }
        if(heapArr[i] < min){
            min = i;
        }
        return Math.min(findSmallest(right(i),min),findSmallest(left(i),min));

    }

    public int findBiggest(int i) {
        return findBiggest(i,Integer.MIN_VALUE);

    }

    private int findBiggest(int i, int max) {
        if(i >= heapArr.length){
            return max;

        }
        if(heapArr[i] > max){
            max = i;
        }
        return Math.max(findBiggest(right(i),max),findBiggest(left(i),max));

    }




    public void heapify(int[] heapArr, int m) {
        while (2 * m < heapArr.length) {
            int i = m;
            if (isEvenLvl(m)) {
                m = findBiggest(i);
                if (heapArr[m] > heapArr[i]) {
                    int temp = heapArr[i];
                    heapArr[i] = heapArr[m];
                    heapArr[m] = temp;
                    if (isGrandChild(i, m)) {
                        if (heapArr[m] > heapArr[parent(m)]) {
                            int temp2 = heapArr[m];
                            heapArr[m] = heapArr[parent(m)];
                            heapArr[m] = temp2;

                        }

                    }

                }


            } else {
                m = findSmallest(i);
                if (heapArr[m] < heapArr[i]) {
                    int temp = heapArr[i];
                    heapArr[i] = heapArr[m];
                    heapArr[m] = temp;
                    if (isGrandChild(i, m)) {
                        if (heapArr[m] < heapArr[parent(m)]) {
                            int temp2 = heapArr[m];
                            heapArr[m] = heapArr[parent(m)];
                            heapArr[m] = temp2;


                        }


                    }


                }


            }
        }
    }
    public void buildHeap(int[] heapArr){
        for(int i = (int) Math.floor(heapArr.length/2); i>=0; i--){
            heapify(heapArr,i);


        }


    }


    public  void main(String[] args) {
        int[] a = new int[]{3,50,20,8,45,19,50,100,17,90};
        buildHeap(a);
        Arrays.toString(a);

    }

}
