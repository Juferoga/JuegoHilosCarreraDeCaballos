/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreravagosori;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author glud-mint
 */
public class Lienzo extends JPanel {
    
   
    
    public Lienzo(int x, int y){
        setBounds(x, y, 100, 100);
   //     setBorder(new LineBorder(new Color(156,156,156)));
    }
    
    @Override
    public void paint(Graphics g){ 
        g.setColor(Color.RED);
        g.drawRect(60, 100, 60, 20);
        g.setColor(Color.BLUE);
        g.drawRect(60, 160, 60, 20); 
    }
}
