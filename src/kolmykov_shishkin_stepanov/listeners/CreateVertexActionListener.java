package kolmykov_shishkin_stepanov.listeners;

import kolmykov_shishkin_stepanov.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateVertexActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String input = JOptionPane.showInputDialog("Inter node's numbers and value (with space)");
        int number1;
        int number2;
        int value;
        try {
            String[] arr = input.split(" ");
            if (arr.length != 3) {
                JOptionPane.showMessageDialog(Main.getMainFrame(), "Incorrect input (should be 3 args)");
                return;
            }
            number1 = Integer.parseInt(arr[0]);
            number2 = Integer.parseInt(arr[1]);
            if(number1 == number2) {
                JOptionPane.showMessageDialog(Main.getMainFrame(), "Incorrect input (same node's number)");
                return;
            }
            value = Integer.parseInt(arr[2]);
            if(value <= 0) {
                JOptionPane.showMessageDialog(Main.getMainFrame(), "Incorrect input (same node's number)");
                return;
            }
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(Main.getMainFrame(), "Incorrect input (NaN)");
            return;
        }

        Main.addVertex(number1, number2, value);
    }
}
