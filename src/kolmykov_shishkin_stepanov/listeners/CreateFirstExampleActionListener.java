package kolmykov_shishkin_stepanov.listeners;

import kolmykov_shishkin_stepanov.Main;
import kolmykov_shishkin_stepanov.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateFirstExampleActionListener implements ActionListener {
    private Window window;

    public CreateFirstExampleActionListener(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        window.setNumberOfNodes(7);
        window.changeEnableOfCreateMenu();

        window.addEdge(0, 1, 7);
        window.addEdge(0, 3, 5);
        window.addEdge(1, 2, 8);
        window.addEdge(1, 3, 9);
        window.addEdge(1, 4, 7);
        window.addEdge(2, 4, 5);
        window.addEdge(3, 5, 6);
        window.addEdge(3, 4, 15);
        window.addEdge(4, 5, 8);
        window.addEdge(4, 6, 9);
        window.addEdge(5, 6, 11);
    }
}
