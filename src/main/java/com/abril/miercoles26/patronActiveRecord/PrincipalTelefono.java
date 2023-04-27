package com.abril.miercoles26.patronActiveRecord;

import com.abril.miercoles26.patronActiveRecord.telefono.TelefonoAR;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class PrincipalTelefono {

    public static void main(String[] args) {


        JFrame frame = new JFrame("Hello World Java Swing");

        // set frame site
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton b = new JButton("pulsame");

        b.addActionListener(e -> {
            TelefonoAR tfn = new TelefonoAR(7, "Nokia", "modelo8", 150);
            try {
                tfn.insertar();
                JOptionPane.showMessageDialog(null, "hemos insertado tu telefono " + tfn.getMarca());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
                throw new RuntimeException(ex);

            }
        });

        // add JLabel to JFrame
        frame.getContentPane().add(b);

        // display it
        frame.pack();
        frame.setVisible(true);

    }
}
