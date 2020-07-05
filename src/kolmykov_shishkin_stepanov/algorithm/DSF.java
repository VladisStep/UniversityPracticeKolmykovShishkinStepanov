package kolmykov_shishkin_stepanov.algorithm;

import java.util.Vector;

public class DSF { // класс системы непересекающихся множеств
    int[] set; // номер множества
    int[] rnk; // ранг
    int size = 0;

    Vector<Vector<Integer>> prevSet = new Vector<Vector<Integer>>();
    Vector<Vector<Integer>> prevRnk = new Vector<Vector<Integer>>();

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
            Vector <Integer> tmpSet = new Vector<>();
            Vector <Integer> tmpRnk = new Vector<>();
            for (int i = 0; i < size; i++) {
                tmpSet.addElement(set[i]);
                tmpRnk.addElement(rnk[i]);
            }
            prevSet.addElement(tmpSet);
            prevRnk.addElement(tmpRnk);
            return false;
        }

        Vector <Integer> tmpSet = new Vector<>();
        Vector <Integer> tmpRnk = new Vector<>();
        for (int i = 0; i < size; i++) {
            tmpSet.addElement(set[i]);
            tmpRnk.addElement(rnk[i]);
        }
        prevSet.addElement(tmpSet);
        prevRnk.addElement(tmpRnk);

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
        Vector <Integer> tmpSet = new Vector<>();
        Vector <Integer> tmpRnk = new Vector<>();
        tmpSet = prevSet.lastElement();
        tmpRnk = prevRnk.lastElement();

        for (int i = 0; i < size; i++) {
            set[i] = tmpSet.elementAt(i);
            rnk[i] = tmpRnk.elementAt(i);
        }

        prevSet.remove(prevSet.size() - 1);
        prevRnk.remove(prevRnk.size() - 1);
    }
}
