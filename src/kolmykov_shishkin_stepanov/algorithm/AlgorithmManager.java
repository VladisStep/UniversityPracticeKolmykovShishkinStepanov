package kolmykov_shishkin_stepanov.algorithm;

import kolmykov_shishkin_stepanov.Node;
import kolmykov_shishkin_stepanov.Window;
import kolmykov_shishkin_stepanov.exceptions.AddEdgeException;

public class AlgorithmManager {
    private Window window;
    private Algorithm algorithm;

    public AlgorithmManager(Window window, Algorithm algorithm) {
        this.window = window;
        this.algorithm = algorithm;
    }

    public AlgorithmManager(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public AlgorithmManager(Window window) {
        this.window = window;
    }

    public AlgorithmManager() {
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    //--------------------------------------------------------

    public void runAlgorithm() throws Exception {
        algorithm.run();
    }

    public boolean makeStep() {
        return algorithm.step();
    }

    public void makePrev() throws Exception{
        algorithm.prev();
    }

    public void getResultOfAlgorithm() {
        algorithm.getResult();
    }

    public int getIntermediateResultOfAlgorithm() {
        return algorithm.getIntermediateResult();
    }

    public void restartAlgorithm() {
        algorithm.restart();
    }

    public void setNumOfNodes(int num) {
        algorithm.setNumOfNodes(num);
    }

    public void addEdge(int from, int to, int capacity) throws AddEdgeException {
        algorithm.addEdge(from, to, capacity);
    }

    //-----------------------------------------------------------------------

    public void makeDrawGraphRequest(Node[] nodes) {
        window.makeDrawGraphRequest(nodes);
    }
}
