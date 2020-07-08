package kolmykov_shishkin_stepanov.algorithm;

import java.util.ArrayList;

public class DSF { // класс системы непересекающихся множеств
    int[] set; // номер множества
    int[] rnk; // ранг
    int size = 0;

    ArrayList<ArrayList<Integer>> prevSet = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> prevRnk = new ArrayList<ArrayList<Integer>>();


    DSF(int size) {
        this.size = size;
        set = new int[size];
        rnk = new int[size];
        for (int i = 0; i < size; i++)
            set[i] = i;
    }

    // Возвращает множество, которому принадлежит x
    int set(int x) {
        return x == set[x] ? x : (set[x] = set(set[x]));
    }

    // Если u и v лежат в разных множествах, то сливаем их и возвращаем true
    boolean union(int u, int v) {   //функция слияния
        if ((u = set(u)) == (v = set(v))) {
            ArrayList <Integer> tmpSet = new ArrayList<>();
            ArrayList <Integer> tmpRnk = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                tmpSet.add(set[i]);
                tmpRnk.add(rnk[i]);
            }
            prevSet.add(tmpSet);
            prevRnk.add(tmpRnk);
            return false;
        }

        ArrayList <Integer> tmpSet = new ArrayList<>();
        ArrayList <Integer> tmpRnk = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            tmpSet.add(set[i]);
            tmpRnk.add(rnk[i]);
        }
        prevSet.add(tmpSet);
        prevRnk.add(tmpRnk);

        if (rnk[u] < rnk[v]) {
            set[u] = v;
        } else {
            set[v] = u;
            if (rnk[u] == rnk[v])
                rnk[u]++;
        }
        return true;
    }

    void unUnionForPrev() {     //функция, которая отменяет предыдущее слияние для отката назад

        ArrayList <Integer> tmpSet = new ArrayList<>();
        ArrayList <Integer> tmpRnk = new ArrayList<>();
        tmpSet = prevSet.get(prevSet.size() - 1);
        tmpRnk = prevRnk.get(prevRnk.size() - 1);

        for (int i = 0; i < size; i++) {
            set[i] = tmpSet.get(i);
            rnk[i] = tmpRnk.get(i);
        }

        prevSet.remove(prevSet.size() - 1);
        prevRnk.remove(prevRnk.size() - 1);
    }
}
