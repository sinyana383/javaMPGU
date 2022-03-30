import org.junit.*;

public class Task2_Tests extends Assert{
    static class TestComparator implements MyComparator<Integer>
    {
        @Override
        public int compare(Integer first, Integer second)
        {
            return first - second;
        }
    }

    @Test
    public void BubbleSort_RandomParams_SuccessSort()
    {
        Integer[] arr = {1, 0, -19, 3};
        BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();
        bubbleSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[] {-19, 0, 1, 3}, arr);
    }

    @Test
    public void BubbleSort_ReverseOrder_SuccessSort()
    {
        Integer[] arr = {3, 1, 0, -19};
        BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();
        bubbleSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[] {-19, 0, 1, 3}, arr);
    }
    @Test
    public void SelectionSort_TwoElements_SuccessSort()
    {
        Integer[] arr = {3, 1};
        SelectionSort<Integer> selectionSort = new SelectionSort<>();
        selectionSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[] {1, 3}, arr);
    }

    @Test
    public void SelectionSort_RandomOrder_SuccessSort()
    {
        Integer[] arr = {3, 0, 1, -19};
        SelectionSort<Integer> selectionSort = new SelectionSort<>();
        selectionSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[] {-19, 0, 1, 3}, arr);
    }

    @Test
    public void InsertionSort_RandomOrder_SuccessSort()
    {
        Integer[] arr = {3, 0, 1, -19};
        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        insertionSort.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[] {-19, 0, 1, 3}, arr);
    }

}
