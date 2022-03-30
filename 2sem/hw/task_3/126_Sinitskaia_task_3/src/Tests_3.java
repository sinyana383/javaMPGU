import org.junit.*;

public class Tests_3 extends Assert {
    static class TestComparator implements MyComparator<Integer>
    {
        @Override
        public int compare(Integer first, Integer second)
        {
            return first - second;
        }
    }

    @Test
    public void QuickSort_TwoElements_SuccessSort()
    {
        Integer[] arr = {27, -27};
        QuickSort<Integer> selectionSort = new QuickSort<>();
        selectionSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[] {-27, 27}, arr);
    }

    @Test
    public void QuickSort_contrastParams_SuccessSort()
    {
        Integer[] arr = {6,1,7,9,3,8,2,5,4,0};
        QuickSort<Integer> selectionSort = new QuickSort<>();
        selectionSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[] {0,1,2,3,4,5,6,7,8,9}, arr);
    }

    @Test
    public void MergeSort_TwoElements_SuccessSort()
    {
        Integer[] arr = {27, -27};
        MergeSort<Integer> mergeSort = new MergeSort<>();
        mergeSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[] {-27, 27}, arr);
    }

    @Test
    public void MergeSort_FourElements_SuccessSort()
    {
        Integer[] arr = {3, 4, 1, 2};
        MergeSort<Integer> mergeSort = new MergeSort<>();
        mergeSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[] {1, 2, 3, 4}, arr);
    }

    @Test
    public void MergeSort_contrastParams_SuccessSort()
    {
        Integer[] arr = {6,1,7,9,3,8,2,5,4,0};
        MergeSort<Integer> mergeSort = new MergeSort<>();
        mergeSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[] {0,1,2,3,4,5,6,7,8,9}, arr);}
}
