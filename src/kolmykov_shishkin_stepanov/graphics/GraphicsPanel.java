package kolmykov_shishkin_stepanov.graphics;

import kolmykov_shishkin_stepanov.Node;
import kolmykov_shishkin_stepanov.algorithm.Edge;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class GraphicsPanel extends JPanel {

    public void drawLine(double x1, double y1, double x2, double y2, Color color) {
        Graphics2D graphics2D = (Graphics2D) getGraphics();
        graphics2D.setColor(color);
        graphics2D.setBackground(color);
        graphics2D.setStroke(new BasicStroke(4));
        graphics2D.draw(new Line(x1, y1, x2, y2));
        graphics2D.dispose();
    }

    public void drawCircle(double x, double y, double w, double h) {
        Graphics2D graphics2D = (Graphics2D) getGraphics();
        graphics2D.setColor(new Color(158, 8, 8));
        graphics2D.fill(new Circle(x, y, w, h));
        graphics2D.dispose();
    }

    public void drawNumber(int number, double x, double y, Color color) {
        Graphics2D graphics2D = (Graphics2D) getGraphics();
        graphics2D.setColor(color);
        graphics2D.drawString(String.valueOf(number), (int)x + 20, (int)y + 30);
    }

    public void drawSquare(int x, int y, int w, int h) {
        Graphics2D graphics2D = (Graphics2D) getGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(x, y, w, h);
    }

    public void clear() {
        Graphics2D graphics2D = (Graphics2D) getGraphics();
        graphics2D.setBackground(Color.WHITE);
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(300, 0, 1000, 1000);
    }
}
