package kolmykov_shishkin_stepanov;

import kolmykov_shishkin_stepanov.exceptions.AddEdgeException;

import java.util.HashMap;
import java.util.Map;

public class Node {
    private int number;

    private Map<Integer, Integer> edgesMap = new HashMap<>(); //Словарь номер вершины - длина ребра для хранения исходящих ребер

    public Node(int number){ this.number = number; }

    public int getNumber() {
        return number;
    }

    public void addEdge(int number, int capacity) throws AddEdgeException { //TODO написать классы для исключений
        if (capacity > 0 && number >= 0 && this.number != number) {
            edgesMap.put(number, capacity);
        }
        else {
            if (capacity <= 0){
                throw new AddEdgeException("Capacity should be > 0, but your capacity " + capacity + " <= 0");
            }else if (number < 0){
                throw  new AddEdgeException("There is no such vertex (" + number + ")");
            }else if (number == this.number){
                throw  new AddEdgeException("Vertex1 can't be equal to Vertex2");
            }
        }
    }

    public Map<Integer, Integer> getEdgesMap() {
        return edgesMap;
    }
}
