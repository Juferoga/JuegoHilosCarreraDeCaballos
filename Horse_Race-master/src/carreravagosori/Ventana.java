/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreravagosori;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author glud-mint
 */
public class Ventana extends JFrame {

    private JLabel label;
    private String consoleS;
    JPanel panel;
    JPanel panel2;
    private JPanel contentPanel;

    // Canvas lienzo; // no se combinan awt y swing ¨¨¨¨¨ parte de .awt
    //Graphics2D g;
    public String getConsoleS() {
        return consoleS;
    }

    public void setConsoleS(String consoleS) {
        this.consoleS = consoleS;
    }

    public Ventana() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);

        // Definicion de variables
        label = new JLabel();
        panel = new Lienzo(30, 30);
        panel2 = new JPanel();
        contentPanel = new JPanel();
        setContentPane(contentPanel);
        contentPanel.setSize(getWidth(), getHeight());
        //contentPanel.setBackground(Color.yellow);
        contentPanel.setLayout(null);

        //lienzo = new Canvas();
        // agregar cosas al dibujo del formulario
        contentPanel.add(panel);
        panel.repaint();
        //panel.add(label);
        /*
        label.setBorder(new LineBorder(Color.black, 2, true));
        label.setText(consoleS);
        label.setVisible(true);
        label.setLocation(30, 30);
        label.setSize(60, 60);
         */
        //g.drawLine(10, 10, 200,200 );
        //panel.add(lienzo);
        //g.draw(s);
        //g.drawString("Welcome to TutorialsPoint", 50, 70);
        this.setVisible(true);
        this.setLocation(250, 250);

        //apuesta();
    }

    public void drawCanvas() {

    }

    public void apuesta() {

        Ventana V = new Ventana();

        Scanner teclado = new Scanner(System.in);

        Hilo hilo1;
        Hilo hilocorredor2;

        int saldo = 100;
        int apuesta = 0;

        hilo1 = new Hilo("Juan felipe");
        hilocorredor2 = new Hilo("Falsh");

        V.setConsoleS("-- ¡EMPIEZA LA CARRERA! --");

        V.setConsoleS("Para quien quieres apostar? -> Juferoga || Flash <-");
        String jugadorApostado = teclado.next();

        V.setConsoleS("Cuanto quieres apostar? Tienes: " + saldo + "$");
        apuesta = teclado.nextInt();

        //Controlamos que no puedan apostar más del dinero que tienen
        while (apuesta > saldo) {
            V.setConsoleS("Lo siento vuelve a probar:");
            apuesta = teclado.nextInt();
        }

        hilo1.start();
        hilocorredor2.start();

        //Control de interrupciones + Apuestas
        while (!Hilo.interrupted()) {
            if (hilo1.getTiempoDormido() == 5) {
                //si gana hilo1, paramos a hilocorredor2
                hilocorredor2.interrupt();
                if (jugadorApostado.equals("Juan felipe")) {
                    int nuevoSaldo = saldo + apuesta * 2;
                    V.setConsoleS("¡Has ganado " + apuesta * 2 + "$! Tu nuevo saldo es " + nuevoSaldo + "$");
                } else {
                    int nuevoSaldo = saldo - apuesta;
                    V.setConsoleS("Has perdido la apuesta ): te quedan: " + nuevoSaldo + "$");
                }
                System.exit(0); //Para cerrar la ejecución del programa en cuanto gane uno
            } else if (hilocorredor2.getTiempoDormido() == 5) {
                //si gana hilocorredor2, paramos a hilo1
                hilo1.interrupt();
                if (jugadorApostado.equals("Flash")) {
                    int nuevoSaldo = saldo + apuesta * 2;
                    V.setConsoleS("¡Has ganado " + apuesta * 2 + "$! Tu nuevo saldo es " + nuevoSaldo + "$");
                } else {
                    int nuevoSaldo = saldo - apuesta;
                    V.setConsoleS("Has perdido la apuesta ): te quedan: " + nuevoSaldo + "$");
                }
                System.exit(0); //Para cerrar la ejecución del programa en cuanto gane uno
            }
        }

    }

}
