package kolmykov_shishkin_stepanov;

import kolmykov_shishkin_stepanov.algorithm.Edge;

import javax.swing.*;
import java.awt.*;

public class AlgorithmLoggingWindow extends JFrame {
    private Window window;
    private JTextArea textArea;

    public AlgorithmLoggingWindow(Window window) {
        this.window = window;

        setSize(300, 120);

        textArea = new JTextArea(8, 20);
        textArea.setText("");
        textArea.setCaretPosition(textArea.getDocument().getLength());
        //textArea.setCaretPosition(0);
        //textArea.setAutoscrolls(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);
    }

    public void printCondition(String log){
        textArea.append(log + "\n");

//        if (edge.getColor() == Color.YELLOW){
//            text += "\nSelect edge " + edge.getFrom() + " - " + edge.getTo() + " to check";
//        }
//        else if (edge.getColor() == Color.GREEN){
//            text += "\nEdge " + edge.getFrom() + " - " + edge.getTo() + " doesn't form cycles and is added to the spanning tree";
//        }
//        else if (edge.getColor() == Color.RED){
//            text += "\nEdge " + edge.getFrom() + " - " + edge.getTo() + " form cycles";
//        }
    }
}
