public class Task_3 implements Task_3_base {
    @Override
    public int subtask_1_for(int n1, int n2, int a, int b) {
        // подсчитать, сколько чисел, кратных a, но не кратных b,
        // находится между числами n1 и n2 включительно
        int res = 0;
        int c = n1;
        if(c > n2){
            n1 = n2;
            n2 = c;
        }
        for(int i = n1; i <= n2; ++i)
        {
            if(i % a == 0 && i % b != 0)
                ++res;
        }
        return res;
    }

    @Override
    public int subtask_2_for(int num) {
        // Последовательность чисел строится следующим образом:
        // сначала идет одна единица,
        // потом две двойки,
        // потом три тройки,
        // ...
        // потом n раз число n
        // ...
        // Найти, какое число будет находиться в этой последовательности
        // на позиции num
        int counter = 0;
        for(int i = 1; i <= num; ++i)
        {
            for (int j = 0; j < i; ++j)
            {
                ++counter;
                if(num == counter)
                    return i;
            }
        }
        return 1;
    }

    @Override
    public int subtask_3_for(int num, int d, int cnt) {
        // Дана последовательность
        // a(0) = num
        // a(n) = a(n - 1) * d + 1
        // Найти сумму первых cnt элементов последовательности
        return 0;
    }

    @Override
    public int subtask_4_for(int n) {
        // Вычислить сумму
        // S(n) = 1 + 1 * 2 + 1 * 2 * 3 + ... + n!
        // для заданного n
        // (n! - это n-факториал. Кто не знает - гуглите)
        return 0;
    }
}
