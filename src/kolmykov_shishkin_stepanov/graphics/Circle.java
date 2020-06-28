package kolmykov_shishkin_stepanov.graphics;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Circle extends Ellipse2D {
    double x;
    double y;
    double w;
    double h;

    public Circle(double x, double y, double w, double h) {
        setFrame(x, y, w, h);
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getWidth() {
        return w;
    }

    @Override
    public double getHeight() {
        return h;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void setFrame(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }
}
