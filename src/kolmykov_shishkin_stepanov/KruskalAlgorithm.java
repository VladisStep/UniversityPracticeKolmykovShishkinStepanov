package kolmykov_shishkin_stepanov;

import kolmykov_shishkin_stepanov.exceptions.AddEdgeException;

public class KruskalAlgorithm implements Runnable{
    private int num = 0;
    private Node[] nodes = new Node[0];
    private Window window;

    public KruskalAlgorithm(Window window) {
        this.window = window;
    }

    public void setNumOfNodes(int num) {
        this.num = num;
        nodes = new Node[num];
        for (int i = 0; i < num; i++) {
            nodes[i] = new Node(i);
        }
        makeDrawRequest();
    }

    public void addEdge(int number1, int number2, int capacity) throws AddEdgeException { //TODO поменять exception на свое исключение
        if (number1 >= nodes.length || number2 >= nodes.length) {
            throw new AddEdgeException("Incorrect number of node");
        }
        nodes[number1].addEdge(number2, capacity);
        nodes[number2].addEdge(number1, capacity);
        makeDrawRequest();
    }

    public void makeDrawRequest() {
        window.getGraphicsPanel().drawGraph(nodes);
    }


    @Override
    public void run() {
        //TODO здесь будет сам алгоритм
    }
}
