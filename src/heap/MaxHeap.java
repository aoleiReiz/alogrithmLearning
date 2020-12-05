package heap;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> {

    private List<E> data;

    public MaxHeap(int capacity){
        data = new ArrayList<>(capacity);
    }
    public MaxHeap(){
        data = new ArrayList<>();
    }
    public MaxHeap(E []arr){
        data = new ArrayList<>(Arrays.asList(arr));
        for (int i = parent(data.size()-1); i >=0 ; i--) {
            siftDown(i);
        }
    }

    public int size(){
        return data.size();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public int parent(int index){
        if (index == 0){
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1)/2;
    }

    public int leftChild(int index){
        return 2 * index + 1;
    }

    public int rightChild( int index){
        return 2 * index + 2;
    }

    public void add(E e){
        data.add(e);
        siftUp(data.size()-1);
    }

    public void swap(int i, int j){
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    private void siftUp(int k){
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k))<0){
            swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax(){
        if (isEmpty()){
            throw new IllegalArgumentException("Heap is empty");
        }
        return data.get(0);
    }

    public E extractMax(){
        E e = findMax();

        swap(0, data.size()-1);
        data.remove(data.size()-1);
        siftDown(0);
        return e;
    }

    private void siftDown(int k){
        while (leftChild(k)<data.size()){
            int j = leftChild(k);
            if (j + 1 < data.size() && data.get(j+1).compareTo(data.get(j))>0){
                j++;
            }
            if (data.get(k).compareTo(data.get(j))>=0){
                break;
            }
            swap(k,j);
            k = j;
        }
    }

    public E replace(E e){
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

}
