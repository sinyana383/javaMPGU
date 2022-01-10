package task;

public class DoubleLinkedListSorter {
    public static <T extends Comparable<T>> void sort(DoubleLinkedListItem<T> list) {
        if(list == null)
            return;
        if(list.getNext() == null)
            return;

    }
}
