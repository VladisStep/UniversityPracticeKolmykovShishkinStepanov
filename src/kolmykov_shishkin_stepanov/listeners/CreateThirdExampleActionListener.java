package kolmykov_shishkin_stepanov.listeners;

import kolmykov_shishkin_stepanov.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateThirdExampleActionListener implements ActionListener {

    private Window window;

    public CreateThirdExampleActionListener(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        window.setNumberOfNodes(9);
        //window.changeEnableOfCreateMenu();
        window.changeEnableOfExample();

        window.addEdge(0, 1, 4);
        window.addEdge(0, 7, 8);
        window.addEdge(1, 7, 11);
        window.addEdge(1, 2, 8);
        window.addEdge(7, 8, 7);
        window.addEdge(8, 2, 2);
        window.addEdge(8, 6, 6);
        window.addEdge(7, 6, 1);
        window.addEdge(6, 5, 2);
        window.addEdge(2, 5, 4);
        window.addEdge(2, 3, 7);
        window.addEdge(3, 5, 14);
        window.addEdge(5, 4, 10);
        window.addEdge(3, 4, 9);

        window.log("Third example loaded");
    }
}
