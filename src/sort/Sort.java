package sort;

public class Sort {

    public boolean isSorted(Comparable []a){
        for (int i = 1; i < a.length; i++) {
            if (comp(a[i-1],a[i]) > 0){
                return false;
            }
        }
        return true;
    }

    public void exch(Comparable []a, int i, int j){
        assert i < a.length && j < a.length;
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public int comp(Comparable a, Comparable b){
        return a.compareTo(b);
    }

    public void selectionSort(Comparable []a){
        if (null == a || a.length <= 1){
            return;
        }
        int N = a.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (comp(a[j],a[min]) < 0){
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public void insertionSort(Comparable []a){
        if (null == a || a.length <= 1){
            return;
        }
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && comp(a[j],a[j-1]) < 0; j--){
                exch(a, j , j -1);
            }
        }
    }

    public void insertionSortImprove(Comparable []a){
        if (null == a || a.length <= 1){
            return;
        }
        int N = a.length;
        for (int i = 0; i < N; i++) {
            Comparable e = a[i];
            int j;
            for (j = i; j > 0 && comp(e, a[j-1]) < 0; j--){
                a[j] = a[j-1];
            }
            a[j] = e;
        }
    }

    public void mergeSort(Comparable []a){
        if (null == a || a.length <= 1){
            return;
        }

        _mergeSort(a, 0, a.length - 1);
    }

    public void mergeSortBU(Comparable []a){
        int N = a.length;

        for (int sz = 1; sz < N ; sz += sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                _merge(a, lo,lo + sz - 1, Math.min(lo + sz + sz - 1, N -1));
            }
        }
    }

    private void _mergeSort(Comparable []a, int l, int r){
        if (l >= r){
            return;
        }
        int mid = l + (r - l)/2;
        _mergeSort(a,l, mid);
        _mergeSort(a, mid + 1, r);
        if(comp(a[mid],a[mid+1]) > 0)
            _merge(a, l, mid, r);
    }
    private void _merge(Comparable []a, int l, int mid, int r){
        Comparable []aux = new Comparable[r - l + 1];
        for (int i = l; i <= r ; i++) {
            aux[i - l] = a[i];
        }
        int left = l;
        int right = mid+1;
        int k = l;
        while (left <= mid && right <= r){
            if (comp(aux[left-l],aux[right-l]) <= 0){
                a[k++] = aux[left - l];
                left ++;
            }else{
                a[k++] = aux[right - l];
                right ++;
            }
        }
        while (left <= mid){
            a[k++] = aux[left - l];
            left ++;
        }
        while (right <= r){
            a[k++] = aux[right - l];
            right ++;
        }
    }

    public void bubbleSort(Comparable []a){
        if (null == a || a.length <= 1){
            return;
        }
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = N - 2; j >= 0 ; j--) {
                if (comp(a[j+1], a[j]) < 0){
                    exch(a,j+1, j);
                }
            }
        }
    }


    // 快排1
    public void quickSort1(Comparable []a){
        quickSort1(a, 0 , a.length - 1);
    }
    private void quickSort1(Comparable []a, int lo, int hi){
        if (lo >= hi){
            return;
        }
        int p = partition1(a, lo, hi);
        quickSort1(a, lo, p - 1);
        quickSort1(a, p + 1, hi);
    }

    // 选择子数组起始位置作为partition元素
    private int partition1(Comparable []a, int lo, int hi){
        Comparable v = a[lo];
        int i = lo, j = hi+1;
        while (true){
            while (comp(a[++i], v) <= 0) if (i == hi) break;
            while (comp(a[--j], v) > 0) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }


}
