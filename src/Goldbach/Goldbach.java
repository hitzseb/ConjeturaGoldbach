/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Goldbach;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Sebastian
 */
public class Goldbach extends JFrame implements ActionListener {

    JTextArea textarea;
    JScrollPane scrollpane;
    JButton boton;

    Goldbach() {
        setLayout(null);
        textarea = new JTextArea();
        scrollpane = new JScrollPane(textarea);
        scrollpane.setBounds(20, 20, 405, 400);
        add(scrollpane);

        boton = new JButton("Detener");
        boton.addActionListener(this);
        boton.setBounds(170, 470, 100, 30);
        add(boton);

        textarea.setText("                                CONJETURA DE GOLDBACH\n"
        +"Todo número par > 4 puede expresarse como la suma de dos primos.\n"
        +"A continuación se comprueba su validez hasta 10.000\n\n");
        HiloGoldbach hg = new HiloGoldbach(textarea);
        hg.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton)
            System.exit(0);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Goldbach goldbach;
        goldbach = new Goldbach();
        goldbach.setBounds(0, 0, 457, 600);
        goldbach.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        goldbach.setVisible(true);
        goldbach.setLocationRelativeTo(null);
        
    }

}
