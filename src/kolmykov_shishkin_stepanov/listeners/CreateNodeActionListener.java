package kolmykov_shishkin_stepanov.listeners;

import kolmykov_shishkin_stepanov.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateNodeActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = JOptionPane.showInputDialog("Enter the number of vertices (2 <= number <= 15)");
        int num;
        try {
            num = Integer.parseInt(input);
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(Main.getMainFrame(), "Incorrect input");
            return;
        }
        if (num < 2) {
            JOptionPane.showMessageDialog(Main.getMainFrame(), "Incorrect input (< 2)");
            return;
        } else if (num > 15) {
            JOptionPane.showMessageDialog(Main.getMainFrame(), "Incorrect input (> 15)");
            return;
        }
        Main.setNumberOfNodes(num);

        Main.changeEnableOfCreateMenu();
    }
}
