package kolmykov_shishkin_stepanov.algorithm;

import java.util.Vector;

public class DSF { // класс системы непересекающихся множеств
    int[] set; // номер множества
    int[] rnk; // ранг

    Vector<Integer> prevU = new Vector<Integer>();
    Vector<Integer> prevV = new Vector<Integer>();
    Vector<Integer> prevSetU = new Vector<Integer>();
    Vector<Integer> prevSetV = new Vector<Integer>();
    Vector<Integer> prevRnk = new Vector<Integer>();

    DSF(int size) {
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
        int tmpSetU = set[u];
        int tmpSetV = set[v];
        if ((u = set(u)) == (v = set(v))) {
            prevU.addElement(u);
            prevV.addElement(v);
            if (tmpSetU != set[u]) {
                prevSetU.addElement(set[u]);
            }
            else
                prevSetU.addElement(-1);
            if (tmpSetV != set[v])
                prevSetV.addElement(set[v]);
            else
                prevSetV.addElement(-1);
            prevRnk.addElement(-1);
            return false;
        }

        prevU.addElement(u);
        prevV.addElement(v);
        prevSetU.addElement(set[u]);
        prevSetV.addElement(set[v]);
        prevRnk.addElement(rnk[u]);
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
        int u = prevU.lastElement();
        int v = prevV.lastElement();

        if (prevRnk.lastElement() == -1) {
            if (prevSetU.lastElement() != -1) {
                set[u] = prevSetU.lastElement();
            }
            if (prevSetV.lastElement() != -1)
                set[v] = prevSetV.lastElement();

            prevU.remove(prevU.size() - 1);
            prevV.remove(prevV.size() - 1);
            prevSetU.remove(prevSetU.size() - 1);
            prevSetV.remove(prevSetV.size() - 1);
            prevRnk.remove(prevRnk.size() - 1);
            return;
        }

        set[u] = prevSetU.lastElement();
        set[v] = prevSetV.lastElement();
        rnk[u] = prevRnk.lastElement();

        prevU.remove(prevU.size() - 1);
        prevV.remove(prevV.size() - 1);
        prevSetU.remove(prevSetU.size() - 1);
        prevSetV.remove(prevSetV.size() - 1);
        prevRnk.remove(prevRnk.size() - 1);
    }
}
