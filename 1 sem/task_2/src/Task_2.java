public class Task_2 implements Task_2_base {
    @Override
    public int subtask_1_while(int num) {
        // Найти максимальное число, являющееся полным квадратом,
        // не превосходящее заданное натуральное num
        int maxSqrt = 1;
        for(int i = 1; i <= num; ++i)
        {
            int squere = (int)Math.sqrt(i);
            if(squere*squere == i)
                maxSqrt = i;
        }
        return maxSqrt;
    }

    @Override
    public int subtask_2_while(int num) {
        // Последовательность целых чисел p(n) определяется следующим образом:
        // p(0) = 1
        // p(k) = 2 * p(k - 1) + 6, k > 0
        //Найти элемент последовательности с номером num
        if (num > 0)
            return 2 * subtask_2_while(num - 1) + 6;
        if(num == 0)
            return 1;
        return 0;
    }

    @Override
    public boolean subtask_3_while(int num, int base) {
        // Проверить, является ли число num натуральной степенью числа base
        if(num < 1)
            return false;
        if(num == 1)
            return true;
        int res = 1;
        int power = 1;
        while(res < num)
            res *= base;
        if(res == num)
            return true;
        return false;
    }

    @Override
    public int subtask_4_while(int start, int end) {
        // Вычислить, за какое минимальное число операций
        // вычесть 1
        // поделить на 2
        // число start можно превратить в end. Гарантируется, что start >= end >= 1
        int res = 0;
        while(start > end)
        {
            while (start % 2 == 0 && (start / 2) >= end)
            {
                start /= 2;
                ++res;
            }
            if(start > end)
            {
                --start;
                ++res;
            }

        }
        return res;
    }
}
