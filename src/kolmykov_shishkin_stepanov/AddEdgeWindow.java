package kolmykov_shishkin_stepanov;

import kolmykov_shishkin_stepanov.exceptions.AddEdgeException;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class AddEdgeWindow extends JFrame {
    private Window window;

    private JLabel v1Label;
    private JLabel v2Label;
    private JLabel capacityLabel;
    private JFormattedTextField capacityInput;
    private JFormattedTextField v1Input;
    private JFormattedTextField v2Input;
    private JButton addButton;

    public AddEdgeWindow(Window window) {
        this.window = window;
        setSize(350, 200);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setTitle("Adding edge");

        v1Label = new JLabel("Vertex 1 number");
        v2Label = new JLabel("Vertex 2 number");
        capacityLabel = new JLabel("Capacity       ");
        capacityInput = new JFormattedTextField(new NumberFormatter());
        v1Input = new JFormattedTextField(new NumberFormatter());
        v2Input = new JFormattedTextField(new NumberFormatter());
        addButton = new JButton("Add");

        add(v1Label, new GridBagConstraints(0, 0, 2, 1, 0, 0.5,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 20, 0));
        add(v2Label, new GridBagConstraints(2, 0, 2, 1, 0, 0.5,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 20, 0));
        add(capacityLabel, new GridBagConstraints(4, 0, 2, 1, 0, 0.5,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 20, 0));
        add(v1Input, new GridBagConstraints(0, 1, 2, 1, 0, 0.5,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 20, 0));
        add(v2Input, new GridBagConstraints(2, 1, 2, 1, 0, 0.5,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 20, 0));
        add(capacityInput, new GridBagConstraints(4, 1, 2, 1, 0, 0.5,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 20, 0));
        add(addButton, new GridBagConstraints(0, 2, 9, 1, 0, 0.5,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 20, 0));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int v1num = 0;
                int v2num = 0;
                int capacity = 0;
                try {
                    v1num = Integer.parseInt(v1Input.getText());
                    v2num = Integer.parseInt(v2Input.getText());
                    capacity = Integer.parseInt(capacityInput.getText());

                    window.addEdge(v1num, v2num, capacity);

                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(window, "Incorrect input (NaN)");
                }
            }
        });
    }
}
