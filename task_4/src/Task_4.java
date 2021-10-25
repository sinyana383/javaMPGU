public class Task_4 implements Task_4_base {
    @Override
    public int[] subtask_1_arrays(int size, int a0, int d) {
        // сгенерировать и вернуть массив размера size, содержащий элементы
        // арифметической прогрессии с первым членом a0 и разностью d
        if (size <= 0)
            return null;
        int arr[];
        arr = new int[size];
        for(int i = 0; i < size; ++i)
            arr[i] = a0 + d * i;
        return arr;
    }

    @Override
    public int[] subtask_2_arrays(int size) {
        // сгенерировать и вернуть массив размера size, первые два элемента
        // которого равны единице, а каждый следующий - сумме всех предыдущих
        if (size <= 0)
            return null;
        int arr[];
        arr = new int[size];
        arr[0] = 1;
        for(int i = 0; i < size; ++i)
        {
            int prev_sum = 0;
            for (int j = 0; j < i; ++j)
                prev_sum += arr[j];
            arr[i] += prev_sum;
        }
        return arr;
    }

    @Override
    public int[] subtask_3_arrays(int size) {
        // сгенерировать и вернуть массив размера size, содержащий первые
        // size чисел последовательности фибоначчи.
        // https://ru.wikipedia.org/wiki/Числа_Фибоначчи
        if (size <= 0)
            return null;
        int arr[] = new int[size];
        arr[0] = 0;
        if(size == 1)
            return arr;
        arr[1] = 1;
        for(int i = 2; i < size; ++i)
            arr[i] = arr[i - 2] + arr[i - 1];
        return arr;
    }

    @Override
    public int subtask_4_arrays(int[] data) {
        // Для данного массива вычислить максимальный элемент
        int max_el;
        if(data == null)
            return 0;
        max_el = data[0];
        for (int i = 1; i < data.length; ++i)
        {
            if(data[i] > max_el)
                max_el = data[i];
        }
        return max_el;
    }

    @Override
    public int subtask_5_arrays(int[] data, int k) {
        // Для данного массива вычислить максимальный элемент
        // кратный k. Гарантируется, что как минумум один такой элемент
        // в массиве есть
        int max_el = -2147483648;
        int flag = 0;
        if(data == null)
            return 0;
        for (int i = 0; i < data.length; ++i)
        {
            if(data[i] % k == 0 && data[i] > max_el)
                max_el = data[i];
        }
        return max_el;
    }

    @Override
    public int[] subtask_6_arrays(int[] arr1, int[] arr2) {
        // Даны два массива arr1, arr2.
        // Произвести слияние данных массивов в один отсортированный
        // по возрастанию массив.
        if(arr1 == null || arr2 == null)
            return null;
        int size = arr1.length + arr2.length;
        int arr[] = new int[size];
        int i = 0;

        for(; i < arr1.length; ++i)
            arr[i] = arr1[i];
        for (int j = 0; j < arr2.length; ++j)
            arr[i + j] = arr2[j];

        for(i = 0; i < size; ++i)
        {
            for (int j = 0; j < size - i - 1; ++j)
            {
                if(arr[j] > arr[j + 1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    @Override
    public int[] subtask_7_arrays(int[] arr1, int[] arr2) {
        // Даны два отсортированных по возрастанию массива arr1, arr2.
        // Произвести слияние данных массивов в один также отсортированный
        // по возрастанию массив.
        // Используйте алгоритм, время работы которого будет пропорционально сумме
        // размеров arr1 и arr2, а не их произведению
        if(arr1 == null || arr2 == null)
            return null;
        int size = arr1.length + arr2.length;
        int arr[] = new int[size];
        int main = 0;
        int i = 0;
        int j = 0;
        while (i < arr1.length || j < arr2.length) {
            if(i < arr1.length)
            {
                if(j < arr2.length)
                {
                    if (arr1[i] > arr2[j] || j + 1 == arr2.length) {
                        arr[main] = arr1[i];
                        ++main;
                        ++i;
                    }
                }
                else
                {
                    arr[main] = arr1[i];
                    ++main;
                    ++i;
                }
            }
            else if (j < arr2.length)
            {
                arr[main] = arr2[j];
                ++main;
                ++j;
            }
        }

        return arr;
    }
}
