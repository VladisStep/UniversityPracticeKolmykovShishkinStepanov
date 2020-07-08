package kolmykov_shishkin_stepanov.graphics;

import kolmykov_shishkin_stepanov.Node;
import kolmykov_shishkin_stepanov.algorithm.Edge;

import java.awt.*;
import java.util.Map;

public class GraphGraphicManager {
    private GraphicsPanel graphicsPanel;

    private final double RADIUS = 300; // было 450, на 13-дюймовый экран не все вершины влезают
    private final double H = 50;
    private final double W = 50;
    private final double X0 = 800;
    private final double Y0 = 450;
    private final int RECT_H = 15;
    private final int RECT_W = 15;

    private Node[] lastNodes;

    public GraphGraphicManager(GraphicsPanel graphicsPanel) {
        this.graphicsPanel = graphicsPanel;
    }

    public void redrawGraph() {
        if(lastNodes != null) {
            drawGraph(lastNodes);
        }
    }

    public void drawGraph(Node[] nodes) { //Для каждой вершины отрисовывается вершина и ребра к ее соседям
        this.lastNodes = nodes;
        graphicsPanel.clear();
        for (Node node : nodes) {
            drawNode(node.getNumber(), nodes.length);
            Map<Integer, Edge> edgesMap = node.getEdgesMap();
            for (Integer neighbourNumber : edgesMap.keySet()) {
                drawEdge(node.getNumber(), neighbourNumber, edgesMap.get(neighbourNumber).getCapacity(), nodes.length, edgesMap.get(neighbourNumber).getColor());
            }
        }
    }

    public void drawNode(int number, int quantity) {
        double angle = Math.PI* 2/quantity * number;
        double x = X0 + RADIUS * Math.cos(angle);
        double y = Y0 + RADIUS * Math.sin(angle);
        graphicsPanel.drawCircle(x, y, W, H);
        graphicsPanel.drawNumber(number, x, y, Color.WHITE);
    }

    public void drawEdge(int number1, int number2, int value, int quantity, Color color) {
        double angle1 = Math.PI* 2/quantity * number1;
        double x1 = X0 + RADIUS * Math.cos(angle1) + 20;
        double y1 = Y0 + RADIUS * Math.sin(angle1) + 30;

        double angle2 = Math.PI* 2/quantity * number2;
        double x2 = X0 + RADIUS * Math.cos(angle2) + 20;
        double y2 = Y0 + RADIUS * Math.sin(angle2) + 30;

        graphicsPanel.drawLine(x1, y1, x2, y2, color);
        graphicsPanel.drawSquare((int)((x1 + x2)/2), (int)((y1 + y2)/2 - 10), RECT_W, RECT_H);
        graphicsPanel.drawNumber(value, (x1 + x2 - 40)/2, (y1 + y2 - 60)/2, Color.BLACK);
        drawNode(number1, quantity);
        drawNode(number2, quantity);
    }
}
