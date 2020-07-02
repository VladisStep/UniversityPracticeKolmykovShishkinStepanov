package kolmykov_shishkin_stepanov;

import kolmykov_shishkin_stepanov.graphics.GraphicsPanel;
import kolmykov_shishkin_stepanov.listeners.CreateEdgeActionListener;
import kolmykov_shishkin_stepanov.listeners.CreateFirstExampleActionListener;
import kolmykov_shishkin_stepanov.listeners.CreateNodeActionListener;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private JMenuBar menuBar;
    private JMenu createMenu;
    private JMenuItem createNodesMenuItem;
    private JMenuItem createEdgeMenuItem;
    private GraphicsPanel graphicsPanel;

    private JMenu createExampleMenu;
    private JMenuItem createFirstExampleItem;

    private int nodesQuantity;
    private KruskalAlgorithm algorithm;

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
        createNodesMenuItem.addActionListener(new CreateNodeActionListener(this));     // добавление метода в пункт
        createMenu.add(createNodesMenuItem);                                       // добавление подпукнкта
        createEdgeMenuItem = new JMenuItem("Create edge");
        createEdgeMenuItem.addActionListener(new CreateEdgeActionListener(this));
        createMenu.add(createEdgeMenuItem);
        createEdgeMenuItem.setEnabled(false);                                       // блокировка кнопки "Create edge"

        //----------------------------------------

        createExampleMenu = new JMenu("Examples");                                 // создание пункта меню
        menuBar.add(createExampleMenu);                                                   // добавление пункта
        createFirstExampleItem = new JMenuItem("First");                  // создание подпункта меню
        createFirstExampleItem.addActionListener(new CreateFirstExampleActionListener(this));     // добавление метода в пункт
        createExampleMenu.add(createFirstExampleItem);                                       // добавление подпункта

        //----------------------------------------

        graphicsPanel = new GraphicsPanel();
        this.add(graphicsPanel,
                new GridBagConstraints(0, 0, 1, 1, 1, 1,
                        GridBagConstraints.NORTH,
                        GridBagConstraints.BOTH,
                        new Insets(2, 2, 2, 2),
                        0, 0));

        algorithm = new KruskalAlgorithm(this);

        this.setVisible(true);     // отображение формы
    }

    public void addEdge(int number1, int number2, int value) {
        if (number1 >= nodesQuantity || number1 < 0 || number2 >= nodesQuantity || number2 < 0) {
            JOptionPane.showMessageDialog(this, "Incorrect input (wrong nodes numbers)");
            return;
        }

        graphicsPanel.drawEdge(number1, number2, value, nodesQuantity);
    }

    public void setNumberOfNodes(int num) {
        nodesQuantity = num;
        algorithm.setNumOfNodes(num);
    }

    public void changeEnableOfCreateMenu() {   // "Create nodes" – нельзя, "Create edge" – можно, "Examples" - нельзя
        createNodesMenuItem.setEnabled(false);
        createEdgeMenuItem.setEnabled(true);
        createExampleMenu.setEnabled(false);
    }

    public GraphicsPanel getGraphicsPanel() {
        return graphicsPanel;
    }
}
