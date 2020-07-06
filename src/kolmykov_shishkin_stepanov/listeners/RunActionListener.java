package kolmykov_shishkin_stepanov.listeners;

import kolmykov_shishkin_stepanov.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RunActionListener implements ActionListener {
    private Window window;

    public RunActionListener(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (window.checkValidate()){
            window.changeEnableOfRunAlgButton();
            window.redraw();
            window.runAlgorithm();
        }
        else {
            JOptionPane.showMessageDialog(window, "Graph is not connected");
        }
    }
}
