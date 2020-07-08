package kolmykov_shishkin_stepanov.listeners;

import kolmykov_shishkin_stepanov.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateSecondExampleActionListener implements ActionListener {

    private Window window;

    public CreateSecondExampleActionListener(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        window.setNumberOfNodes(5);
        //window.changeEnableOfCreateMenu();
        window.changeEnableOfExample();

        window.addEdge(0, 1, 3);
        window.addEdge(0, 4, 1);
        window.addEdge(1, 4, 4);
        window.addEdge(1, 2, 5);
        window.addEdge(2, 4, 6);
        window.addEdge(2, 3, 2);
        window.addEdge(3, 4, 7);

        window.log("Second example loaded");
    }
}
