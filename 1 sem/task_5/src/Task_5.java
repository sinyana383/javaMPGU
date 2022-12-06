import java.util.*;

public class Task_5 implements Task_5_base {
    @Override
    public ArrayList<Integer> subtask_1_ArrayList(ArrayList<Integer> data, int k, int n) {
        // Выбрать из данного списка элементы, кратные k, но не кратные n
        // и сформировать из них новый список.
        // Вернуть новый список в качестве результата
        if (data == null)
            return null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < data.size(); ++i)
        {
            if(data.get(i) % k == 0 && data.get(i) % n != 0)
                list.add(data.get(i));
        }
        return list;
    }

    @Override
    public ArrayList<Integer> subtask_2_ArrayList(int size) {
        // сгенерировать и вернуть список размера size,
        // содержащий первые size элементов последовательности, описанной в
        // задаче subtask_2_for задания task_3
        if(size < 0)
            return null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int main = 0;
        int i = 1;
        while (main < size)
        {
            for (int j = 0; j < i && main < size; ++j)
            {
                list.add(i);
                ++main;
            }
            ++i;
        }
        return list;
    }

    @Override
    public HashSet<Integer> subtask_3_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите пересечение множеств s1 и s2
        if(s1 == null || s2 == null)
            return null;
        HashSet<Integer> res = new HashSet<>();
        for(int element: s1)
        {
            if(s2.contains(element))
                res.add(element);
        }
        return res;
    }

    @Override
    public HashSet<Integer> subtask_4_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите объединение множеств s1 и s2
        HashSet<Integer> res = new HashSet<>();
        res.addAll(s1);
        res.addAll(s2);
        return res;
    }

    @Override
    public HashSet<Integer> subtask_5_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите дополнение множества s1 до множества s2
        HashSet<Integer> res = new HashSet<>();
        for(int i: s2)
        {
            if(!s1.contains(i))
                res.add(i);
        }
        return res;
    }

    @Override
    public HashSet<Integer> subtask_6_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // постройте множество, содержащее элементы, содержащиеся либо только в s1,
        // либо только в s2, но не в обоих множествах одновременно
        HashSet<Integer> res = new HashSet<>();
        for(int i: s2)
        {
            if(!s1.contains(i))
                res.add(i);
        }
        for(int i: s1)
        {
            if(!s2.contains(i))
                res.add(i);
        }
        return res;
    }

    @Override
    public HashMap<String, Double> subtask_7_HashMap(ArrayList<String> data) {
        // Дан список строк. Построить словарь, содержащий частоты слов
        // для данного списка в процентах
        int size = data.size();
        HashMap<String, Double> res = new HashMap<String, Double>();
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        for(int i = 0; i < data.size(); ++i)
        {
            String getStr = data.get(i);
            if(!count.containsKey(getStr))
                count.put(getStr, 1);
            else
                count.put(getStr, count.get(getStr) + 1);
        }
        for(String key: count.keySet())
        {
            double per = (double)count.get(key) * 100 /  (double)size;
            res.put(key, per);
        }
        return res;
    }

    @Override
    public HashMap<String, Double> subtask_8_HashMap(ArrayList<Double> data) {
        // Дан список чисел. Сформировать словарь, содержащий среднее,
        // максимальное и минимальное значения из данного списка. Ключи
        // словаря "mean", "max", "min" соответственно
        HashMap<String, Double> res = new HashMap<String,Double>(3);
        // ЧТО ЗНАЧИТ СРЕДНЕЕ???
        int max_in = 0;
        int min_in = 0;
        if(data.size() >= 3)
        {
            res.put("min", data.get(1));
            min_in = 1;
            res.put("max", data.get(2));
            max_in = 2;
        }
        double sum = 0;
        for(int i = 0; i < data.size(); ++i)
        {
            double num = data.get(i);
            if(num > res.get("max"))
            {
                res.put("max", num);
                max_in = i;
            }
            if(num < res.get("min"))
            {
                res.put("min", num);
                min_in = i;
            }
            sum += data.get(i);
        }
        res.put("mean", sum/data.size());
        return res;
    }
}
