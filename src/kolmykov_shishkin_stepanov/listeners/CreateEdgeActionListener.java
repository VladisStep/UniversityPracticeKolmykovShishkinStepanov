package kolmykov_shishkin_stepanov.listeners;

import kolmykov_shishkin_stepanov.AddEdgeWindow;
import kolmykov_shishkin_stepanov.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateEdgeActionListener implements ActionListener {
    Window window;

    public CreateEdgeActionListener(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new AddEdgeWindow(window).setVisible(true);
    }
}
