package kolmykov_shishkin_stepanov;

import kolmykov_shishkin_stepanov.graphics.GraphicsPanel;
import kolmykov_shishkin_stepanov.listeners.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Window extends JFrame {
    private JMenuBar menuBar;
    private JMenu createMenu;
    private JMenuItem createNodesMenuItem;
    private JMenuItem createEdgeMenuItem;
    private GraphicsPanel graphicsPanel;

    private JMenu createExampleMenu;
    private JMenuItem createFirstExampleItem;
    private JMenuItem createSecondExampleItem;
    private JMenuItem createThirdExampleItem;

    private JMenu createAlgorithmMenu;                  // Algorithm
    private JMenuItem createRunItem;                    // Algorithm -> Run

    private JButton stepButton;
    private JButton showResultButton;
    private JButton restartButton;

    private int nodesQuantity;
    private KruskalAlgorithm algorithm;

    public Window() {
        super("Genius app");                                // создание формы
        this.setSize(1600, 1000);                  // выбор размера формы
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // выбор действия при закрытии формы
        this.setLocationRelativeTo(null);                       // открытие формы посередине экрана
        this.setLayout(new GridBagLayout());

        menuBar = new JMenuBar();            // создание и установка меню-бара
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

        createExampleMenu = new JMenu("Examples");
        menuBar.add(createExampleMenu);

        createFirstExampleItem = new JMenuItem("First");                                        // first example
        createFirstExampleItem.addActionListener(new CreateFirstExampleActionListener(this));
        createExampleMenu.add(createFirstExampleItem);

        createSecondExampleItem = new JMenuItem("Second");                                      // second example
        createSecondExampleItem.addActionListener(new CreateSecondExampleActionListener(this));
        createExampleMenu.add(createSecondExampleItem);

        createThirdExampleItem = new JMenuItem("Third");                                        //  third example
        createThirdExampleItem.addActionListener(new CreateThirdExampleActionListener(this));
        createExampleMenu.add(createThirdExampleItem);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(0,1));
        add(buttonsPanel,new GridBagConstraints(1, 0, 1, 1, 0.1, 0.4,
                GridBagConstraints.CENTER,
                GridBagConstraints.CENTER,
                new Insets(2, 2, 2, 2),
                0, 0) );



        stepButton = new JButton("Step");
        stepButton.setMaximumSize(new Dimension(20, 20));
        Font bigFontTR = new Font("Arial", Font.BOLD, 20);
        stepButton.setFont(bigFontTR);
        stepButton.addActionListener(new StepButtonActionListener(this));
        buttonsPanel.add(stepButton);
        stepButton.setVisible(false);

        showResultButton = new JButton("Result");
        showResultButton.setPreferredSize(new Dimension(120, 50));
        showResultButton.setFont(bigFontTR);
        showResultButton.addActionListener(new StepButtonActionListener(this));
        buttonsPanel.add(showResultButton);
        showResultButton.setVisible(false);

        restartButton = new JButton("Restart");
        restartButton.setPreferredSize(new Dimension(120, 50));
        restartButton.setFont(bigFontTR);
        restartButton.addActionListener(new StepButtonActionListener(this));
        buttonsPanel.add(restartButton);
        restartButton.setVisible(false);

        createAlgorithmMenu = new JMenu("Algorithm");
        menuBar.add(createAlgorithmMenu);
        createRunItem = new JMenuItem("Run");
        createRunItem.addActionListener(new RunActionListener(this));
        createAlgorithmMenu.add(createRunItem);

        graphicsPanel = new GraphicsPanel();
        this.add(graphicsPanel,
                new GridBagConstraints(0, 0, 1, 1, 1, 1,
                        GridBagConstraints.NORTH,
                        GridBagConstraints.BOTH,
                        new Insets(2, 2, 2, 2),
                        0, 0));

        algorithm = new KruskalAlgorithm(this);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                //TODO ОТРИСОВКА ГРАФА
            }
        });

        this.setVisible(true);     // отображение формы
    }

    public void addEdge(int number1, int number2, int value) {


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

    public void changeEnableOfstepButton(){
        stepButton.setVisible(true);
        showResultButton.setVisible(true);
        restartButton.setVisible(true);
    }

    public GraphicsPanel getGraphicsPanel() {
        return graphicsPanel;
    }

    public int getNodesQuantity() {
        return nodesQuantity;
    }
}
