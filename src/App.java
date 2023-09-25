import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class App extends JFrame {
    JPanel panel;
    JLabel label;
    JTextField textField;
    JCheckBox checkBox;
    GridBagConstraints c;
    Font negrita=new Font("SansSerif", Font.BOLD, 18);

    App() {

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        c = new GridBagConstraints();

        c.insets = new Insets(20, 20, 20, 20);
        c.fill = GridBagConstraints.HORIZONTAL;
        label = new JLabel("Introduce un texto cualquiera");
        // centra la label horizontalmente
        label.setFont(negrita);
        label.setHorizontalAlignment(0);
        panel.add(label, c);

        textField = new JTextField();
        // c.insets=new Insets(20, 20, 20, 20);
        c.weightx = 0.5;
        c.weighty = 0.0;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(textField, c);

        checkBox = new JCheckBox("Convertir a mayusculas");
        checkBox.setFont(negrita);
        c.gridy = 2;
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (checkBox.isSelected()) {
                    textField.setText(textField.getText().toUpperCase());
                }else textField.setText(textField.getText().toLowerCase(getLocale()));
                
            }
        });
        panel.add(checkBox, c);
        setContentPane(panel);
        setResizable(false);
        setSize(600, 200);
        // centra la ventana
        setLocationRelativeTo(null);
        setTitle("Ejemplo de uso de JCheckBox");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args) throws Exception {
        //App a = new App();
        Practica2 p2= new Practica2();
    }
}
