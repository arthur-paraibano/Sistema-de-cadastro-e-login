package Util;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Message {

    public static void fatal(Component component, String message) {
        Icon figura = new ImageIcon(new ImageIcon(Objects.requireNonNull(Message.class.getResource("/Resources/triste.png"))).getImage());
        JOptionPane.showMessageDialog(component, message, "ERRO", JOptionPane.ERROR_MESSAGE, figura);
        System.exit(0);
    }

    public static void erroTrist(Component component, String message) {
        Icon figura = new ImageIcon(new ImageIcon(Objects.requireNonNull(Message.class.getResource("/Resources/triste.png"))).getImage());
        JOptionPane.showMessageDialog(component, message, "ERRO", JOptionPane.ERROR_MESSAGE, figura);
    }

    public static void errorX(Component component, String message) {
        Icon figura = new ImageIcon(new ImageIcon(Objects.requireNonNull(Message.class.getResource("/Resources/x.png"))).getImage());
        JOptionPane.showMessageDialog(component, message, "ERRO", JOptionPane.ERROR_MESSAGE, figura);
    }

    public static void sucess(Component component, String message) {
        Icon figura = new ImageIcon(new ImageIcon(Objects.requireNonNull(Message.class.getResource("/Resources/sucesso.png"))).getImage());
        JOptionPane.showMessageDialog(component, message + "\n", "Sucesso", JOptionPane.ERROR_MESSAGE, figura);
    }

    public static void sqlErro(Component component, String message) {
        Icon figura = new ImageIcon(new ImageIcon(Objects.requireNonNull(Message.class.getResource("/Resources/x.png"))).getImage());
        JOptionPane.showMessageDialog(component, message, "ERRO", JOptionPane.ERROR_MESSAGE, figura);
    }
}
