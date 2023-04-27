package com.abril.miercoles26.patronActiveRecord;

import com.abril.miercoles26.patronActiveRecord.ordenador.OrdenadorAR2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Principal {

    public static void main(String[] args) {


        JFrame frame = new JFrame("Hello World Java Swing");

        // set frame site
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton b = new JButton("pulsame");

        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                OrdenadorAR2 o = new OrdenadorAR2(7, "nuevo", 200);
                try {
                    o.insertar();
                    JOptionPane.showMessageDialog(null, "hemos insertado");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                    throw new RuntimeException(ex);

                }
            }
        });

        // add JLabel to JFrame
        frame.getContentPane().add(b);

        // display it
        frame.pack();
        frame.setVisible(true);

    }
}
