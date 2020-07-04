package kolmykov_shishkin_stepanov.algorithm;

import kolmykov_shishkin_stepanov.Node;
import kolmykov_shishkin_stepanov.Window;
import kolmykov_shishkin_stepanov.exceptions.AddEdgeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KruskalAlgorithm {
    private int nodesNumber= 0;
    private Node[] nodes = new Node[0];
    private Window window;

    private ArrayList<Edge> edges = new ArrayList<>();
    private DSF dsf;
    private Edge currentEdge;
    private int currentEdgeIndex;
    private int minMSTWeight = 0;

    public KruskalAlgorithm(Window window) {
        this.window = window;
    }

    public void setNumOfNodes(int num) {
        this.nodesNumber = num;
        nodes = new Node[num];
        for (int i = 0; i < num; i++) {
            nodes[i] = new Node(i);
        }
        makeDrawRequest();
    }

    public void addEdge(int number1, int number2, int capacity) throws AddEdgeException { //TODO поменять exception на свое исключение
        if (number1 >= nodes.length || number1 < 0) {
            throw new AddEdgeException("There is no such vertex(" + number1 +")");
        } else if ( number2 >= nodes.length || number2 < 0){
            throw new AddEdgeException("There is no such vertex(" + number2 +")");
        }
        nodes[number1].addEdge(number2, capacity);
        nodes[number2].addEdge(number1, capacity);


        edges.add(new Edge(number1, number2, capacity));
        makeDrawRequest();
    }

    public void makeDrawRequest() {
        window.getGraphicsPanel().drawGraph(nodes);
    }

    public void run() {

        dsf = new DSF(nodesNumber); // СНМ

        edges.sort(Edge::compareTo); // Сортируем ребра

       /* int ret = 0; // результат

        for (Edge e : edges) {// перебираем ребра в порядке возрастания
            System.out.println("Чекаем ребро " + e.getFrom() + " - " + e.getTo() + " с весом " + e.getCapacity() + " (Yellow)");
            if (dsf.union(e.getFrom(), e.getTo())) {// если ребра принадлежат разным компонентам
                //System.out.println("GREEN");
                //e.setColor();
                ret += e.getCapacity(); // добавляем вес ребра к стоимости MST
            }
            else {
                //System.out.println("RED");
                //e.setGreen(false);
            }
        }

        System.out.println(ret);*/
    }

    public boolean step () {

        if (currentEdge == null) {
            chooseEdge();
        } else {
            handleEdge();
            currentEdge = null;
        }

        if (currentEdgeIndex == edges.size()){
            //TODO сделать обращение к окну с блокировкой кнопок
            return false;
        }

        return true;
    }

    private void chooseEdge(){
        currentEdge = edges.get(currentEdgeIndex);
        currentEdge.setColor(EdgeColor.YELLOW);
    }

    private void handleEdge(){


        if (dsf.union(currentEdge.getFrom(), currentEdge.getTo())) {// если ребра принадлежат разным компонентам
            currentEdge.setColor(EdgeColor.GREEN);
            minMSTWeight += currentEdge.getCapacity(); // добавляем вес ребра к стоимости MST
        }
        else {
            currentEdge.setColor(EdgeColor.RED);
        }
        currentEdgeIndex++;

        /*if (currentEdgeIndex == edges.size()-1){
            //TODO сделать обращение к окну с блокировкой кнопок
        }*/
    }

    public int getMinMSTWeight() {
        return minMSTWeight;
    }

    public void getResult(){
        while (step()){}
    }
}
