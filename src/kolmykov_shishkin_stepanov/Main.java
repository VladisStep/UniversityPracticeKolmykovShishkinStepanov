package kolmykov_shishkin_stepanov;

import javax.swing.*;

import kolmykov_shishkin_stepanov.graphics.GraphicsPanel;
import kolmykov_shishkin_stepanov.listeners.*;

import java.awt.*;

public class Main {
    private static JFrame mainFrame;
    private static JMenuBar menuBar;
    private static JMenu createMenu;
    private static JMenuItem createNodesMenuItem;
    private static JMenuItem createVertexMenuItem;
    private static GraphicsPanel graphicsPanel;

    private static int nodesQuantity;

    private static KruskalAlgorithm algorithm;

    public static void main(String[] agrs) {
        initWindow();
    }

    public static void initWindow() {
        mainFrame = new JFrame("Genius app");
        mainFrame.setSize(1600, 1000);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(new GridBagLayout());

        menuBar = new JMenuBar();
        mainFrame.setJMenuBar(menuBar);

        createMenu = new JMenu("Create graph");
        menuBar.add(createMenu);
        createNodesMenuItem = new JMenuItem("Create nodes");
        createNodesMenuItem.addActionListener(new CreateNodeActionListener());
        createMenu.add(createNodesMenuItem);
        createVertexMenuItem = new JMenuItem("Create vertex");
        createVertexMenuItem.addActionListener(new CreateVertexActionListener());
        createMenu.add(createVertexMenuItem);
        createVertexMenuItem.setEnabled(false);

        graphicsPanel = new GraphicsPanel();
        mainFrame.add(graphicsPanel,
                new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH,
                GridBagConstraints.BOTH,
                new Insets(2, 2, 2, 2),
                0, 0));

        algorithm = new KruskalAlgorithm();

        mainFrame.setVisible(true);
    }

    public static void addVertex(int number1, int number2, int value) {

        graphicsPanel.drawVertex(number1, number2, value, nodesQuantity);
    }

    public static void setNumberOfNodes(int num) {
        nodesQuantity = num;
        algorithm.setNumOfNodes(num);
    }

    public static void changeEnableOfCreateMenu() {
        createNodesMenuItem.setEnabled(false);
        createVertexMenuItem.setEnabled(true);
    }

    public static JFrame getMainFrame() {
        return mainFrame;
    }

    public static GraphicsPanel getGraphicsPanel() {
        return graphicsPanel;
    }
}
