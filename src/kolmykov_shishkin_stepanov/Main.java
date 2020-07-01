package kolmykov_shishkin_stepanov;

import javax.swing.*;

import kolmykov_shishkin_stepanov.graphics.GraphicsPanel;
import kolmykov_shishkin_stepanov.listeners.*;

import java.awt.*;

public class Main {
    private static Window window;

    public static void main(String[] agrs) {
        window = new Window();
        window.setVisible(true);
    }

    public static JFrame getMainFrame() {
        return window;
    }
}
