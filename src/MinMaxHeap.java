public class MinMaxHeap {

    int[] heapArr;
    int length = heapArr.length;
    int heapSize = 0;

    public int left(int i){
        return 2*i;

    }
    public int right(int i){

    return 2*i + 1;
    }
    public int parent(int i){
        return (int) Math.floor(i);

    }
     public void heapify(int[] heapArr, int i)   {
         int l = left(i);
         int r = right(i);
         if(l <= length)

     }









}
