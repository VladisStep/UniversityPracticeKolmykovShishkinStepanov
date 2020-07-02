package kolmykov_shishkin_stepanov.listeners;

import kolmykov_shishkin_stepanov.Main;
import kolmykov_shishkin_stepanov.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateFirstExampleActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        Window.setNumberOfNodes(7);
        Window.changeEnableOfCreateMenu();

        Window.addEdge(0, 1, 7);
        Window.addEdge(0, 3, 5);
        Window.addEdge(1, 2, 8);
        Window.addEdge(1, 3, 9);
        Window.addEdge(1, 4, 7);
        Window.addEdge(2, 4, 5);
        Window.addEdge(3, 5, 6);
        Window.addEdge(3, 4, 15);
        Window.addEdge(4, 5, 8);
        Window.addEdge(4, 6, 9);
        Window.addEdge(5, 6, 11);










    }
}
