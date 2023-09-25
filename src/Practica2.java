import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;

public class Practica2 extends JFrame {

    JPanel panel, panelArea;
    JLabel lbl;
    JTextField textField;
    JTextArea textArea;
    JRadioButton radioButton;
    ButtonGroup buttonGroup;
    JButton button;
    GridBagConstraints c;

    Practica2() {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        c = new GridBagConstraints();

        c.insets = new Insets(10, 10, 10, 10);
        // labels
        lbl = new JLabel("Numerador 1");
        c.gridy = 0;
        c.gridx = 0;
        panel.add(lbl, c);
        lbl = new JLabel("Numerador 2");
        c.gridy = 1;
        c.gridx = 0;
        panel.add(lbl, c);
        lbl = new JLabel("Denominador 1");
        c.gridy = 0;
        c.gridx = 2;
        panel.add(lbl, c);
        lbl = new JLabel("Denominador 2");
        c.gridy = 1;
        c.gridx = 2;
        panel.add(lbl, c);
        // textfields
        textField = new JTextField(10);
        textField.setName("txtNum1");
        c.gridy = 0;
        c.gridx = 1;
        panel.add(textField, c);
        textField = new JTextField(10);
        textField.setName("txtNum2");
        c.gridy = 1;
        c.gridx = 1;
        panel.add(textField, c);
        textField = new JTextField(10);
        textField.setName("txtDen1");
        c.gridy = 0;
        c.gridx = 3;
        panel.add(textField, c);
        textField = new JTextField(10);
        textField.setName("txtDen2");
        c.gridy = 1;
        c.gridx = 3;
        panel.add(textField, c);
        // textarea
        textArea = new JTextArea("Resultados");
        c.gridy = 3;
        c.gridx = 0;
        panelArea = new JPanel(new GridLayout(3, 2));

        panelArea.add(textArea);
        panel.add(panelArea, c);

        //
        setContentPane(panel);
        setBounds(500, 300, 250, 250);
        // setResizable(false);
        setSize(800, 800);
        // centra la ventana
        setLocationRelativeTo(null);
        setTitle("Practica 2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
