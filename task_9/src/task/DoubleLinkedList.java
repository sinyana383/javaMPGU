package task;

public class DoubleLinkedList<T extends Comparable<T>> {
    private DoubleLinkedListItem<T> head;
    public DoubleLinkedList()
    {
    }

    public int getSize()
    {
        DoubleLinkedListItem<T> temp;
        temp = head;
        int i = 1;
        if (temp == null)
            return 0;
        while ((temp = temp.getNext()) != null)
            ++i;
        return i;
    }
    public DoubleLinkedListItem getFirst()
    {
        return head;
    }
    public DoubleLinkedListItem getLast()
    {
        DoubleLinkedListItem<T> temp;
        temp = head;
        if(temp == null)
            return null;
        while (temp.getNext() != null)
            temp = temp.getNext();
        return temp;
    }

    public DoubleLinkedListItem<T> findFirstItem(T data)
    {
        DoubleLinkedListItem<T> temp;
        temp = head;
        while (temp != null)
        {
            if(temp.getData() == data)
                return temp;
            temp = temp.getNext();
        }
        return null;
    }
    public DoubleLinkedListItem<T> findLastItem(T data)
    {
        DoubleLinkedListItem<T> temp;
        DoubleLinkedListItem<T> find = null;
        temp = head;
        if (temp == null)
            return null;
        while (temp != null)
        {
            if(temp.getData() == data)
                find = temp;
            temp = temp.getNext();
        }
        return find;
    }

    public void remove(DoubleLinkedListItem<T> item)
    {
        if (item == null)
            return;
        if (head == item)
            head = head.getNext();
        else {
            if (item.getPrev() != null)
                item.getPrev().setNext(item.getNext());
            if (item.getNext() != null)
                item.getNext().setPrev(item.getPrev());
        }
        item = null;
    }
    public void insertBefore(DoubleLinkedListItem<T> item, T data)
    {
        if(item == null)
        {
            DoubleLinkedListItem<T> newItem= new DoubleLinkedListItem<>(data);
            if (head == null)
                head = newItem;
            else
            {
                DoubleLinkedListItem<T> last =  getLast();
                last.setNext(newItem);
                newItem.setPrev(last);
            }
            return;
        }
        DoubleLinkedListItem<T> newItem = new DoubleLinkedListItem<T>(data);
        newItem.setPrev(item.getPrev());
        if(item.getPrev() != null)
            item.getPrev().setNext(newItem);
        item.setPrev(newItem);
        newItem.setNext(item);
        if(item == head)
            head = newItem;
    }
    public void insertAfter(DoubleLinkedListItem<T> item, T data)
    {
        if(item == null)
        {
            DoubleLinkedListItem<T> newItem= new DoubleLinkedListItem<>(data);
            if (head == null)
                head = newItem;
            else
            {
                DoubleLinkedListItem<T> first =  getFirst();
                head = newItem;
                newItem.setNext(first);
                first.setPrev(newItem);
            }
            return;
        }
        DoubleLinkedListItem<T> newItem = new DoubleLinkedListItem<T>(data);
        newItem.setNext(item.getNext());
        if (item.getNext() != null)
            item.getNext().setPrev(newItem);
        item.setNext(newItem);
        newItem.setPrev(item);
    }
}
