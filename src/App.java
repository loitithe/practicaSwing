import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame {
    JPanel panel;
    JLabel label;
    JTextField textField;
    JCheckBox checkBox;
    // restricciones
    GridBagConstraints c;
    // String cad = "";
    Font negrita = new Font("SansSerif", Font.BOLD, 18);

    App() {

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        c = new GridBagConstraints();

        c.insets = new Insets(10, 10, 10, 10);
        c.fill = GridBagConstraints.HORIZONTAL;
        label = new JLabel("Introduce un texto cualquiera");
        label.setFont(negrita);
        // centra la label horizontalmente
        label.setHorizontalAlignment(0);
        panel.add(label, c);
        System.out.println("insets label" + c.insets);
        textField = new JTextField();
        c.weightx = 0.5;
        c.weighty = 0.0;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(textField, c);

        System.out.println("insets textfield" + c.insets);
        checkBox = new JCheckBox("Convertir a mayusculas");
        checkBox.setFont(negrita);
        c.gridy = 2;
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (checkBox.isSelected()) {
                    textField.setText(textField.getText().toUpperCase());
                } else
                    textField.setText(textField.getText().toLowerCase(getLocale()));

            }
        });
        panel.add(checkBox, c);

        System.out.println("insets checkbox" + c.insets);
        setContentPane(panel);
        // setResizable(false);
        setSize(600, 200);
        // centra la ventana
        setLocationRelativeTo(null);
        setTitle("Ejemplo de uso de JCheckBox");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        App a = new App();

    }
}
