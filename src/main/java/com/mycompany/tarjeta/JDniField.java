/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarjeta;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class JDniField extends JPanel implements Serializable {
    private String dni;
    private final static char [] DNI_CHR ={ 'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
    private boolean dniErroneo;
    private JTextField campoDNI;
    private JButton comprobar;
    public JDniField(){
        
        this.setLayout(new GridLayout());
        campoDNI = new JTextField();
        comprobar = new JButton("Comprobar");
        dniErroneo = false;
        this.add(campoDNI);
        this.add(comprobar);
        comprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try{
                    dni = campoDNI.getText();
                    comprobarDNI(getNumero(), getLetra());
            
               }
               catch(Exception ex){
                   JOptionPane.showMessageDialog(null,"un DNI tiene 8 digitos y una letra","ERROR", JOptionPane.ERROR_MESSAGE);
               }
            }
        });
        
        
    }
    public boolean comprobarDNI(int numero, char letra){
        dniErroneo = true;
        if(letra == DNI_CHR[(numero % 23)])
            dniErroneo = false;
        
        if(dniErroneo){
        campoDNI.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                campoDNI.setForeground(Color.black);
            }

            @Override
            public void focusLost(FocusEvent e) {
            campoDNI.setForeground(Color.red);
            }
            
            
        }); 
        }
        else{
            campoDNI.setForeground(Color.black);
        }
        return dniErroneo;
    }

    public String getDni() {
        return dni;
    }
    public char getLetra() {
        return dni.charAt(8);
    }
    public int getNumero() {
        return Integer.parseInt(dni.substring(0, dni.length() - 1));
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean isDniErroneo() {
        return dniErroneo;
    }

    public void setDniErroneo(boolean dniErroneo) {
        this.dniErroneo = dniErroneo;
    }
    
}
