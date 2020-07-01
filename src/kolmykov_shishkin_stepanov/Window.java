package kolmykov_shishkin_stepanov;

import kolmykov_shishkin_stepanov.graphics.GraphicsPanel;
import kolmykov_shishkin_stepanov.listeners.CreateEdgeActionListener;
import kolmykov_shishkin_stepanov.listeners.CreateFirstExampleActionListener;
import kolmykov_shishkin_stepanov.listeners.CreateNodeActionListener;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private static JMenuBar menuBar;
    private static JMenu createMenu;
    private static JMenuItem createNodesMenuItem;
    private static JMenuItem createEdgeMenuItem;
    private static GraphicsPanel graphicsPanel;

    private static JMenu createExampleMenu;
    private static JMenuItem createFirstExampleItem;

    private static int nodesQuantity;
    private static KruskalAlgorithm algorithm;

    public Window() {
        super("Genius app");        // создание формы
        this.setSize(1600, 1000);                  // выбор размера формы
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // выбор действия при закрытии формы
        this.setLocationRelativeTo(null);                       // открытие формы посередине экрана
        this.setLayout(new GridBagLayout());                    // установка расположения вершин

        menuBar = new JMenuBar();           // создание и установка меню-бара
        this.setJMenuBar(menuBar);

        createMenu = new JMenu("Create graph");                                 // создание пункта меню
        menuBar.add(createMenu);                                                   // добавление пункта
        createNodesMenuItem = new JMenuItem("Create nodes");                  // создание подпункта меню
        createNodesMenuItem.addActionListener(new CreateNodeActionListener());     // добавление метода в пункт
        createMenu.add(createNodesMenuItem);                                       // добавление подпукнкта
        createEdgeMenuItem = new JMenuItem("Create edge");
        createEdgeMenuItem.addActionListener(new CreateEdgeActionListener());
        createMenu.add(createEdgeMenuItem);
        createEdgeMenuItem.setEnabled(false);                                       // блокировка кнопки "Create edge"

        //----------------------------------------

        createExampleMenu = new JMenu("Examples");                                 // создание пункта меню
        menuBar.add(createExampleMenu);                                                   // добавление пункта
        createFirstExampleItem = new JMenuItem("First");                  // создание подпункта меню
        createFirstExampleItem.addActionListener(new CreateFirstExampleActionListener());     // добавление метода в пункт
        createExampleMenu.add(createFirstExampleItem);                                       // добавление подпункта

        //----------------------------------------

        graphicsPanel = new GraphicsPanel();
        this.add(graphicsPanel,
                new GridBagConstraints(0, 0, 1, 1, 1, 1,
                        GridBagConstraints.NORTH,
                        GridBagConstraints.BOTH,
                        new Insets(2, 2, 2, 2),
                        0, 0));

        algorithm = new KruskalAlgorithm();

        this.setVisible(true);     // отображение формы
    }

    public static void addEdge(int number1, int number2, int value) {
        if (number1 >= nodesQuantity || number1 < 0 || number2 >= nodesQuantity || number2 < 0) {
            JOptionPane.showMessageDialog(Main.getMainFrame(), "Incorrect input (wrong nodes numbers)");
            return;
        }

        graphicsPanel.drawEdge(number1, number2, value, nodesQuantity);
    }

    public static void setNumberOfNodes(int num) {
        nodesQuantity = num;
        algorithm.setNumOfNodes(num);
    }

    public static void changeEnableOfCreateMenu() {   // "Create nodes" – нельзя, "Create edge" – можно, "Examples" - нельзя
        createNodesMenuItem.setEnabled(false);
        createEdgeMenuItem.setEnabled(true);
        createExampleMenu.setEnabled(false);
    }

    public static GraphicsPanel getGraphicsPanel() {
        return graphicsPanel;
    }
}
