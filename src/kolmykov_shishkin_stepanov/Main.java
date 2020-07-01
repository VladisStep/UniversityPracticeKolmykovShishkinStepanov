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
    private static JMenuItem createEdgeMenuItem;
    private static GraphicsPanel graphicsPanel;

    private static JMenu createExampleMenu;
    private static JMenuItem createFirstExampleItem;

    private static int nodesQuantity;

    private static KruskalAlgorithm algorithm;

    public static void main(String[] agrs) {
        initWindow();
    }

    public static void initWindow() {
        mainFrame = new JFrame("Genius app");                   // создание формы
        mainFrame.setSize(1600, 1000);                  // выбор размера формы
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // выбор действия при закрытии формы
        mainFrame.setLocationRelativeTo(null);                       // открытие формы посередине экрана
        mainFrame.setLayout(new GridBagLayout());                    // установка расположения вершин

        menuBar = new JMenuBar();           // создание и установка меню-бара
        mainFrame.setJMenuBar(menuBar);

        createMenu = new JMenu("Create graph");                                 // создание пункта меню
        menuBar.add(createMenu);                                                   // добавление пункта
        createNodesMenuItem = new JMenuItem("Create nodes");                  // создание подпункта меню
        createNodesMenuItem.addActionListener(new CreateNodeActionListener());     // добавление метода в пункт
        createMenu.add(createNodesMenuItem);                                       // добавление подпкнкта
        createEdgeMenuItem = new JMenuItem("Create edge");
        createEdgeMenuItem.addActionListener(new CreateEdgeActionListener());
        createMenu.add(createEdgeMenuItem);
        createEdgeMenuItem.setEnabled(false);                                       // блокировка "Create edge" вначале



        //----------------------------------------


        createExampleMenu = new JMenu("Examples");                                 // создание пункта меню
        menuBar.add(createExampleMenu);                                                   // добавление пункта
        createFirstExampleItem = new JMenuItem("First");                  // создание подпункта меню
        createFirstExampleItem.addActionListener(new CreateFirstExampleActionListener());     // добавление метода в пункт
        createExampleMenu.add(createFirstExampleItem);                                       // добавление подпкнкта

        //----------------------------------------


        graphicsPanel = new GraphicsPanel();
        mainFrame.add(graphicsPanel,
                new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH,
                GridBagConstraints.BOTH,
                new Insets(2, 2, 2, 2),
                0, 0));

        algorithm = new KruskalAlgorithm();

        mainFrame.setVisible(true);     // отображение формы
    }

    public static void addEdge(int number1, int number2, int value) {

        graphicsPanel.drawEdge(number1, number2, value, nodesQuantity);
    }

    public static void setNumberOfNodes(int num) {
        nodesQuantity = num;
        algorithm.setNumOfNodes(num);
    }

    public static void changeEnableOfCreateMenu() {   // "Create nodes" – нельзя, а "Create edge" – можно
        createNodesMenuItem.setEnabled(false);
        createEdgeMenuItem.setEnabled(true);
    }

    public static JFrame getMainFrame() {
        return mainFrame;
    }

    public static GraphicsPanel getGraphicsPanel() {
        return graphicsPanel;
    }
}
