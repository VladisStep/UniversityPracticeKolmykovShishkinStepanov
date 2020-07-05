package kolmykov_shishkin_stepanov;

import kolmykov_shishkin_stepanov.algorithm.KruskalAlgorithm;
import kolmykov_shishkin_stepanov.exceptions.AddEdgeException;
import kolmykov_shishkin_stepanov.graphics.GraphicsPanel;
import kolmykov_shishkin_stepanov.listeners.*;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JButton prevButton;

    private JLabel weightOfMST;

    private int nodesQuantity;
    private KruskalAlgorithm algorithm;

    public Window() {
        super("Genius app");                                // создание формы
        this.setSize(1600, 1000);                   // выбор размера формы
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // выбор действия при закрытии формы
        this.setLocationRelativeTo(null);                       // открытие формы посередине экрана
        this.setLayout(new GridBagLayout());

// TODO сделать граф левее и немного выше

        menuBar = new JMenuBar();            // создание и установка меню-бара
        this.setJMenuBar(menuBar);

        createMenu = new JMenu("Create graph");                                 // создание пункта меню
        menuBar.add(createMenu);                                                   // добавление пункта
        createNodesMenuItem = new JMenuItem("Create new graph");              // создание подпункта меню
        createNodesMenuItem.addActionListener(new CreateNodeActionListener(this));     // добавление метода в пункт
        createMenu.add(createNodesMenuItem);                                       // добавление подпукнкта
        createEdgeMenuItem = new JMenuItem("Add edge");
        createEdgeMenuItem.addActionListener(new CreateEdgeActionListener(this));
        createMenu.add(createEdgeMenuItem);
        createEdgeMenuItem.setEnabled(false);                                       // блокировка кнопки "Add edge"

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

        Font bigFontTR = new Font("Arial", Font.BOLD, 20);

        weightOfMST = new JLabel("Weight: 0");
        weightOfMST.setFont(bigFontTR);
        buttonsPanel.add(weightOfMST);
        weightOfMST.setVisible(false);

        stepButton = new JButton("Step");
        stepButton.setMaximumSize(new Dimension(20, 20));
        stepButton.setFont(bigFontTR);
        stepButton.addActionListener(new StepButtonActionListener(this));
        buttonsPanel.add(stepButton);
        stepButton.setVisible(false);
        stepButton.setEnabled(false);
        stepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isRun = algorithm.step();
                redraw();
                weightOfMST.setText("Weight: " + algorithm.getMinMSTWeight());
                if (!isRun) {
                    changeEnableOfResultButton();
                }
            }
        });

        prevButton = new JButton("Prev");
        prevButton.setMaximumSize(new Dimension(20, 20));
        prevButton.setFont(bigFontTR);
        prevButton.addActionListener(new StepButtonActionListener(this));
        buttonsPanel.add(prevButton);
        prevButton.setVisible(false);
        prevButton.setEnabled(false);

        showResultButton = new JButton("Result");
        showResultButton.setPreferredSize(new Dimension(120, 50));
        showResultButton.setFont(bigFontTR);
        //showResultButton.addActionListener(new ResultActionListener(this));
        showResultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                algorithm.getResult();
                changeEnableOfResultButton();
                redraw();
                weightOfMST.setText("Weight: " + algorithm.getMinMSTWeight());
            }
        });
        buttonsPanel.add(showResultButton);
        showResultButton.setVisible(false);
        showResultButton.setEnabled(false);

        restartButton = new JButton("Restart");
        restartButton.setPreferredSize(new Dimension(120, 50));
        restartButton.setFont(bigFontTR);
        restartButton.addActionListener(new RestartActionListener(this));
        buttonsPanel.add(restartButton);
        restartButton.setVisible(false);
        restartButton.setEnabled(false);
        restartButton.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                redraw();
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
                redraw();
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
                redraw();
            }
        });
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                algorithm.restart();
                redraw();
                weightOfMST.setText("Weight: 0");
            }
        });

        createAlgorithmMenu = new JMenu("Algorithm");
        menuBar.add(createAlgorithmMenu);
        createRunItem = new JMenuItem("Run");
        createRunItem.setEnabled(false);
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
                super.componentResized(e);
                redraw();
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                super.componentMoved(e);
                redraw();
            }

            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                redraw();
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                super.componentHidden(e);
                redraw();
            }
        });

        setResizable(false);
        setVisible(true);     // отображение формы
    }

    public void addEdge(int number1, int number2, int capacity) {
        try {
            algorithm.addEdge(number1, number2, capacity);
        }
        catch (AddEdgeException eex){
            JOptionPane.showMessageDialog(this, eex.getMessage());
        }
        catch (Exception e) { //TODO заменить на свое исключение, возможно обработать его нормально
            e.printStackTrace();
        }
    }

    public void setNumberOfNodes(int num) {
        nodesQuantity = num;
        algorithm.setNumOfNodes(num);
        makeInvisibleAlgoButtons();
    }

    public void changeEnableOfCreateMenu() {   // "Create new graph" – нельзя, "Add edge" – можно, "Examples" - нельзя
        createNodesMenuItem.setEnabled(false);
        createEdgeMenuItem.setEnabled(true);
        createExampleMenu.setEnabled(true);
        createRunItem.setEnabled(true);
    }


    public void changeEnableOfRunAlgButton() {
        createAlgorithmMenu.setEnabled(false);
        createMenu.setEnabled(false);
        createExampleMenu.setEnabled(false);

        weightOfMST.setText("Weight: 0");
        stepButton.setEnabled(true);
        prevButton.setEnabled(true);
        showResultButton.setEnabled(true);
        restartButton.setEnabled(true);
        weightOfMST.setVisible(true);
        prevButton.setVisible(true);
        stepButton.setVisible(true);
        showResultButton.setVisible(true);
        restartButton.setVisible(true);
    }

    public void changeEnableOfExample(){
        createNodesMenuItem.setEnabled(true);
        createEdgeMenuItem.setEnabled(false);
        //createExampleMenu.setEnabled(false);
        createRunItem.setEnabled(true);
    }

    public void changeEnableOfResultButton() {
        createAlgorithmMenu.setEnabled(true);
        createMenu.setEnabled(true);
        createExampleMenu.setEnabled(true);

        stepButton.setEnabled(false);
        prevButton.setEnabled(false);
        showResultButton.setEnabled(false);
        restartButton.setEnabled(false);
        createRunItem.setEnabled(false);
    }

    public GraphicsPanel getGraphicsPanel() {
        return graphicsPanel;
    }

    public int getNodesQuantity() {
        return nodesQuantity;
    }

    public void redraw() {
        algorithm.makeDrawRequest();
    }

    public void runAlgorithm () { algorithm.run();}

    public void makeInvisibleAlgoButtons() {
        weightOfMST.setVisible(false);
        stepButton.setVisible(false);
        prevButton.setVisible(false);
        showResultButton.setVisible(false);
        restartButton.setVisible(false);
    }

    public boolean checkValidate() {
        return algorithm.isValidGraph();
    }
}
