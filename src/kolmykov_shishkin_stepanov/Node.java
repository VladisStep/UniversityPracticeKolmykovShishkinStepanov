package kolmykov_shishkin_stepanov;

import kolmykov_shishkin_stepanov.algorithm.Edge;
import kolmykov_shishkin_stepanov.exceptions.AddEdgeException;

import java.util.HashMap;
import java.util.Map;

public class Node {
    private int number;

    private Map<Integer, Edge> edgesMap = new HashMap<>(); //Словарь номер вершины - длина ребра для хранения исходящих ребер

    public Node(int number){ this.number = number; }

    public int getNumber() {
        return number;
    }

    public void addEdge(int number, Edge edge) throws AddEdgeException { //TODO написать классы для исключений
        edgesMap.put(number, edge);
    }

    public Map<Integer, Edge> getEdgesMap() {
        return edgesMap;
    }
}
