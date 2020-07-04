package kolmykov_shishkin_stepanov;

import kolmykov_shishkin_stepanov.exceptions.AddEdgeException;

import java.util.HashMap;
import java.util.Map;

public class Node {
    private int number;

    private Map<Integer, Integer> edgesMap = new HashMap<>(); //Словарь номер вершины - длина ребра для хранения исходящих ребер

    public Node(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void addEdge(int number, int capacity) throws AddEdgeException { //TODO написать классы для исключений
        if (capacity > 0 || number >= 0) {
            edgesMap.put(number, capacity);
        }
        else {
            throw new AddEdgeException("Negative value");
        }
    }

    public Map<Integer, Integer> getEdgesMap() {
        return edgesMap;
    }
}
