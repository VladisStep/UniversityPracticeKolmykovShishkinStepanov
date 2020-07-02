package kolmykov_shishkin_stepanov.listeners;

import kolmykov_shishkin_stepanov.Main;
import kolmykov_shishkin_stepanov.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateEdgeActionListener implements ActionListener {
    Window window;

    public CreateEdgeActionListener(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = JOptionPane.showInputDialog("Enter node's numbers and value (with space)");
        int number1;
        int number2;
        int value;
        try {
            String[] arr = input.split(" ");
            if (arr.length != 3) {
                JOptionPane.showMessageDialog(window, "Incorrect input (should be 3 args)");
                return;
            }
            number1 = Integer.parseInt(arr[0]);
            number2 = Integer.parseInt(arr[1]);
            if(number1 == number2) {
                JOptionPane.showMessageDialog(window, "Incorrect input (same node's number)");
                return;
            }
            value = Integer.parseInt(arr[2]);
            if(value <= 0) {
                JOptionPane.showMessageDialog(window, "Incorrect input (value <= 0)");
                return;
            }
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(window, "Incorrect input (NaN)");
            return;
        }

        window.addEdge(number1, number2, value);
    }
}
