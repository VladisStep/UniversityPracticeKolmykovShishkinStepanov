package kolmykov_shishkin_stepanov.listeners;

import kolmykov_shishkin_stepanov.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateNodeActionListener implements ActionListener {
    Window window;

    public CreateNodeActionListener(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = JOptionPane.showInputDialog("Enter the number of vertices (2 <= number <= 15)");
        int num;
        try {
            num = Integer.parseInt(input);
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(window, "Incorrect input");
            return;
        }
        if (num < 2) {
            JOptionPane.showMessageDialog(window, "Incorrect input (< 2)");
            return;
        } else if (num > 15) {
            JOptionPane.showMessageDialog(window, "Incorrect input (> 15)");
            return;
        }
        window.setNumberOfNodes(num);

        window.changeEnableOfCreateMenu();
    }
}
