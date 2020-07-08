package kolmykov_shishkin_stepanov.algorithm;

import kolmykov_shishkin_stepanov.exceptions.AddEdgeException;

public abstract class Algorithm {
    protected AlgorithmManager algorithmManager;

    public Algorithm(AlgorithmManager algorithmManager) {
        this.algorithmManager = algorithmManager;
    }

    public abstract void run() throws Exception;

    public abstract boolean step();

    public abstract void getResult();

    public abstract int getIntermediateResult();

    public abstract void restart();

    public abstract void prev() throws Exception;

    public abstract boolean isValid();

    public abstract void setNumOfNodes(int num);

    public abstract void addEdge(int from, int to, int capacity) throws AddEdgeException;
}
