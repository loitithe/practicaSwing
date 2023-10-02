import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class Practica2 extends JFrame implements ItemListener, ActionListener {
        JLabel JLnumerador1;
        JLabel JLnumerador2;
        JLabel JLdenominador1;
        JLabel JLdenominador2;

        JTextField JTFnum1, JTFnum2, JTFden1, JTFden2;

        JButton JBcalc, JBlimp;

        JTextArea JTAresultado;

        JPanel panelOperaciones;

        CheckboxGroup operacion;
        Checkbox checkbox_Suma;
        Checkbox checkbox_Resta;
        Checkbox checkbox_Multiplicacion;
        Checkbox checkbox_Division;

        float resultado1 = 0;
        float resultado2 = 0;

        Practica2() {

                // Constructor de la interfaz

                JLnumerador1 = new JLabel("Numerador1");
                // Pongo este código para comprobar lo que ocupa la etiqueta
                JLnumerador1.setOpaque(true);
                JLnumerador1.setBackground(Color.WHITE);

                JLnumerador2 = new JLabel("Numerador2");
                JLnumerador2.setOpaque(true);
                JLnumerador2.setBackground(Color.WHITE);

                JLdenominador1 = new JLabel("Denominador1");
                JLdenominador1.setOpaque(true);
                JLdenominador1.setBackground(Color.WHITE);

                JLdenominador2 = new JLabel("Denominador2");
                JLdenominador2.setOpaque(true);
                JLdenominador2.setBackground(Color.WHITE);

                JTFnum1 = new JTextField();
                JTFnum2 = new JTextField();
                JTFden1 = new JTextField();
                JTFden2 = new JTextField();

                JBcalc = new JButton("Calcular");
                JBlimp = new JButton("Limpiar");

                JTAresultado = new JTextArea(5, 5);

                panelOperaciones = new JPanel();

                operacion = new CheckboxGroup();
                checkbox_Suma = new Checkbox("Suma", false, operacion);
                checkbox_Resta = new Checkbox("Resta", false, operacion);
                checkbox_Multiplicacion = new Checkbox("Multipliacion", false, operacion);
                checkbox_Division = new Checkbox("Division", false, operacion);

                // Asignar un nuevo layout al JFrame
                this.setLayout(new GridBagLayout());

                this.getContentPane().add(JLnumerador1, createConstraints(0, 0, 1,
                                1, 0, 1.0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST,
                                new Insets(4, 4, 10, 1)));

                this.getContentPane().add(JTFnum1, createConstraints(1, 0, 1, 1,
                                1.0, 1.0, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTH,
                                new Insets(4, 0, 10, 1)));

                this.getContentPane().add(JLnumerador2, createConstraints(2, 0, 1, 1,
                                0.5, 1.0, GridBagConstraints.NONE, GridBagConstraints.NORTH, new Insets(4, 1, 10, 1)));

                this.getContentPane().add(JTFnum2, createConstraints(3, 0, 1, 1, 0.5, 1.0,
                                GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTH, new Insets(4, 0, 10, 4)));

                this.getContentPane().add(JLdenominador1, createConstraints(0, 1, 1, 1,
                                0, 1.0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST,
                                new Insets(4, 4, 10, 1)));

                this.getContentPane().add(JTFden1, createConstraints(1, 1, 1, 1, 1.0,
                                1.0, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTH, new Insets(4, 0, 10, 5)));

                this.getContentPane().add(JLdenominador2, createConstraints(2, 1, 1, 1,
                                0.5, 1.0, GridBagConstraints.NONE, GridBagConstraints.NORTH, new Insets(4, 1, 10, 1)));

                this.getContentPane().add(JTFden2, createConstraints(3, 1, 1, 1, 0.5, 1.0,
                                GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTH, new Insets(4, 0, 10, 4)));
                checkbox_Suma.addItemListener(this);
                checkbox_Resta.addItemListener(this);
                checkbox_Multiplicacion.addItemListener(this);
                checkbox_Division.addItemListener(this);
                JBcalc.addActionListener(this);
                JBlimp.addActionListener(this);
                // Para que se partan automaticamente las lineas al llegar al final
                JTAresultado.setLineWrap(true);
                JTAresultado.setWrapStyleWord(true);
                JTAresultado.setEditable(false);
                JTAresultado.setAutoscrolls(true);
                JTAresultado.setBorder(BorderFactory.createTitledBorder("RESULTADOS"));

                JScrollPane scrollingArea = new JScrollPane(JTAresultado);
                this.getContentPane().add(JTAresultado, createConstraints(1, 2, 3,
                                3, 0.5, 1.0, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
                                new Insets(4, 1, 10, 10)));

                panelOperaciones.setLayout(new GridLayout(4, 1));
                panelOperaciones.setBorder(BorderFactory.createTitledBorder("Operacion"));

                panelOperaciones.add(checkbox_Suma);
                panelOperaciones.add(checkbox_Resta);
                panelOperaciones.add(checkbox_Multiplicacion);
                panelOperaciones.add(checkbox_Division);

                this.getContentPane().add(panelOperaciones, createConstraints(0, 3, 1, 3,
                                1.0, 1.0, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
                                new Insets(4, 1, 10, 10)));
                this.getContentPane().add(JBcalc, createConstraints(0, 6, 1, 1, 1.0,
                                1.0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(4, 10, 10, 4)));
                JBcalc.setEnabled(false); // Poner el bot�n de calcular desactivado hasta elegir una operacion

                this.getContentPane().add(JBlimp, createConstraints(3, 6, 1, 1, 1.0,
                                1.0, GridBagConstraints.NONE, GridBagConstraints.NORTHEAST, new Insets(4, 1, 10, 10)));

        }

        private static GridBagConstraints createConstraints(
                        int gridx,
                        int gridy,
                        int gridwidth,
                        int gridheight,
                        double weightx,
                        double weighty,
                        int fill,
                        int anchor,
                        Insets insets) {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = gridx;
                constraints.gridy = gridy;
                constraints.gridwidth = gridwidth;
                constraints.gridheight = gridheight;
                constraints.weightx = weightx;
                constraints.weighty = weighty;
                constraints.fill = fill;
                constraints.anchor = anchor;
                constraints.insets = insets;
                return constraints;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
                JButton jButton = (JButton) e.getSource();
                if (jButton == JBcalc) {
                        JTAresultado.setText("Resultado 1: " + resultado1 + "\nResultado 2: " + resultado2);

                }
                if (jButton == JBlimp) {
                        System.exit(1);
                }
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
                // instanciamos objeto jcheckbox con el evento del item
                Checkbox checkBox = (Checkbox) e.getSource();
                JBcalc.setEnabled(true);
                float num1, num2;
                float den1, den2;

                num1 = Float.parseFloat(JTFnum1.getText());
                num2 = Float.parseFloat(JTFnum2.getText());
                den1 = Float.parseFloat(JTFden1.getText());
                den2 = Float.parseFloat(JTFden2.getText());
                if (checkBox == checkbox_Suma) {
                        resultado1 = num1 + den1;
                        resultado2 = num2 + den2;
                }
                if (checkBox == checkbox_Resta) {
                        resultado1 = num1 - den1;
                        resultado2 = num2 - den2;

                }
                if (checkBox == checkbox_Multiplicacion) {
                        resultado1 = num1 * den1;
                        resultado2 = num2 * den2;
                }
                if (checkBox == checkbox_Division) {
                        resultado1 = num1 / den1;
                        resultado2 = num2 / den2;
                }

        }
}
