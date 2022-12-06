public class SelectionSort<T> implements Sort<T> {
    @Override
    public void sort(T[] data, MyComparator<T> comparator) {
        for(int sortedSize = 0; sortedSize < data.length - 1; ++sortedSize) { //
            int maxInd = 1;
            for(int i = 0; i < data.length - sortedSize; ++i) { //
                if(comparator.compare(data[i], data[maxInd]) > 0)
                    maxInd = i; //
            }
            T tmp = data[data.length - 1 - sortedSize]; //
            data[data.length - 1 - sortedSize] = data[maxInd]; //
            data[maxInd] = tmp;
        }
    }
}
