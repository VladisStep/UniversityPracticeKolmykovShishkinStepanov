package kolmykov_shishkin_stepanov.algorithm;

import java.awt.*;

public class Edge implements Comparable<Edge> {
    private int from;
    private int to;
    private int capacity;
    Color color = Color.BLACK;


    public Edge(int from, int to, int capacity){
        this.from = from;
        this.to = to;
        this.capacity = capacity;
    }

    @Override
    public int compareTo(Edge o) {
        if (capacity != o.capacity) {
            return capacity < o.capacity ? -1 : 1;
        }
        return 0;
    }

    public int getCapacity () {return capacity;}
    public int getFrom () {return from;}
    public int getTo () {return  to;}

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
