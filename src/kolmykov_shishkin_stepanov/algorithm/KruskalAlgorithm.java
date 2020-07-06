package kolmykov_shishkin_stepanov.algorithm;

import kolmykov_shishkin_stepanov.Node;
import kolmykov_shishkin_stepanov.Window;
import kolmykov_shishkin_stepanov.exceptions.AddEdgeException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KruskalAlgorithm {
    private int nodesNumber = 0;
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
        edges = new ArrayList<>();
        makeDrawRequest();
    }

    public void addEdge(int number1, int number2, int capacity) throws AddEdgeException {
        if (number1 >= nodes.length || number1 < 0) {
            throw new AddEdgeException("There is no such vertex(" + number1 + ")");
        } else if (number2 >= nodes.length || number2 < 0) {
            throw new AddEdgeException("There is no such vertex(" + number2 + ")");
        }
        else if (number1 == number2) {
            throw new AddEdgeException("Same vertex");
        }

        Edge edge = new Edge(number1, number2, capacity);
        nodes[number1].addEdge(number2, edge);
        nodes[number2].addEdge(number1, edge);
        edges.add(edge);
        makeDrawRequest();
    }

    public void makeDrawRequest() {
        window.getGraphicsPanel().drawGraph(nodes);
    }

    public void run() {
        currentEdge = null;
        currentEdgeIndex = 0;
        minMSTWeight = 0;

        dsf = new DSF(nodesNumber); // СНМ
        edges.sort(Edge::compareTo); // Сортируем ребра
    }

    public boolean step() {

        if (currentEdge == null) {
            chooseEdge();
        } else {
            handleEdge();
            currentEdge = null;
        }

        if (currentEdgeIndex == edges.size()) {
            return false;
        }

        return true;
    }

    private void chooseEdge() {
        currentEdge = edges.get(currentEdgeIndex);
        currentEdge.setColor(Color.YELLOW);
    }

    private void handleEdge() {
        if (dsf.union(currentEdge.getFrom(), currentEdge.getTo())) {// если ребра принадлежат разным компонентам
            currentEdge.setColor(Color.GREEN);
            minMSTWeight += currentEdge.getCapacity(); // добавляем вес ребра к стоимости MST
        } else {
            currentEdge.setColor(Color.RED);
        }
        currentEdgeIndex++;
    }

    public int getMinMSTWeight() {
        return minMSTWeight;
    }

    public void getResult() {
        while (step()) {
        }
    }

    public void restart() {
        currentEdge = null;
        currentEdgeIndex = 0;
        minMSTWeight = 0;
        dsf = new DSF(nodesNumber); // СНМ

        for (Edge edge : edges) {
            edge.setColor(Color.BLACK);
        }
    }

    public boolean isValidGraph() { //проверка связности
        ArrayList<Integer> visited = new ArrayList<>();
        visited.add(0);
        for (int i = 0; i < visited.size(); i++) {
            for (Integer neighborNumber : nodes[visited.get(i)].getEdgesMap().keySet()) {
                if (!visited.contains(neighborNumber)) {
                    visited.add(neighborNumber);
                }
            }
        }
        return (visited.size() == nodes.length);
    }

    public void prev() {
        boolean isPrevAtIndex0 = false;
        if (currentEdgeIndex == 0) {
            currentEdge = edges.get(currentEdgeIndex);
            if (currentEdge.getColor() == Color.YELLOW) {
                isPrevAtIndex0 = true;
                currentEdge.setColor(Color.BLACK);
            }
            currentEdge = null;
        }

        if (currentEdgeIndex <= 0) {
            if (!isPrevAtIndex0)
                JOptionPane.showMessageDialog(window, "You can't click this button because you haven't pressed the button \"step\" yet");
            return;
        }

        if (currentEdge == null) {
            rehandleEdgeForPrev();
        }
        else if (currentEdge.getColor() == Color.YELLOW) {
            rechooseEdgeForPrev();
            currentEdge = null;
        }
    }

    private void rechooseEdgeForPrev() {    //Если перед нажатием "prev" ребро закрашено в желтый
        currentEdge = edges.get(currentEdgeIndex);
        currentEdge.setColor(Color.BLACK);
    }

    private void rehandleEdgeForPrev() {    //Если перед нажатием "prev" ребро закрашено в зеленый или красный
        currentEdgeIndex--;
        currentEdge = edges.get(currentEdgeIndex);
        if (currentEdge.getColor() == Color.GREEN) {
            minMSTWeight -= currentEdge.getCapacity();
        }
        currentEdge.setColor(Color.YELLOW);
        dsf.unUnionForPrev();
    }
}