package kolmykov_shishkin_stepanov.listeners;

import kolmykov_shishkin_stepanov.AddEdgeWindow;
import kolmykov_shishkin_stepanov.AlgorithmLoggingWindow;
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
        try {
            window.runAlgorithm();
            window.changeEnableOfRunAlgButton();
            window.redraw();
            window.log("Algorithm starts");
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(window, ex.getMessage());
            window.log("Error: " + ex.getMessage());
        }
    }
}
