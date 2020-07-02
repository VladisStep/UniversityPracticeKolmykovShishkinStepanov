package kolmykov_shishkin_stepanov;

public class KruskalAlgorithm {
    private int num = 0;
    private Node[] nodes;
    private Window window;

    public KruskalAlgorithm(Window window) {
        this.window = window;
    }

    public void setNumOfNodes(int num) {
        nodes = new Node[num];
        for (int i = 0; i < num; i++) {
            nodes[i] = new Node(i);
            window.getGraphicsPanel().drawNode(i, num);
        }
    }

    public void addVertex(int number1, int number2, int value) {
        //TODO реализовать
    }
}
