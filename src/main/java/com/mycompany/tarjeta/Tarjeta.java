/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarjeta;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.*;
import javax.swing.*;
import org.apache.commons.validator.routines.CreditCardValidator;

public final class Tarjeta extends JPanel implements Serializable {

    public Tarjeta() {
        initComponents();
        comprobarTarjeta();
        comprobarCVV();
        verificarFecha();
        
    }
    public void comprobarTarjeta(){
        CreditCardValidator x = new CreditCardValidator();
        tarjeta.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                tarjeta.setForeground(Color.black);
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (!x.isValid(tarjeta.getText().replace(" ",""))) 
                    tarjeta.setForeground(Color.red);
                else
                    tarjeta.setForeground(Color.green);
                
            }
        });
    }
    public void comprobarCVV(){
        
        cvv.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                
                cvv.setForeground(Color.black);
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (cvv.getText().length() == 4 || cvv.getText().length() == 3) 
                    cvv.setForeground(Color.green);
                else
                    cvv.setForeground(Color.red);
                
            }
        });    
    }
    public void verificarFecha(){
        LocalDate fecha = LocalDate.now();
        int mesAct = fecha.getMonthValue();
        int anoAct = fecha.getYear();
        ano.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                
                ano.setForeground(Color.black);
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (ano.getText().length() == 2 && Integer.valueOf("20" + ano.getText()) >= anoAct || Integer.valueOf(ano.getText()) >= anoAct){
                    ano.setForeground(Color.green);
                    if (ano.getForeground() == Color.green && Integer.parseInt(mes.getText()) >= mesAct && Integer.parseInt(mes.getText()) < 13){
                        mes.setForeground(Color.green);
                }
                    else
                        mes.setForeground(Color.red);
                }
                else{
                    ano.setForeground(Color.red);
                    mes.setForeground(Color.red);
                }
                
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tarjeta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        mes = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ano = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cvv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setText("Fecha:");

        mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesActionPerformed(evt);
            }
        });

        jLabel2.setText("/");

        ano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anoActionPerformed(evt);
            }
        });

        jLabel3.setText("cvv");

        jLabel4.setText("Numero de tarjeta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ano, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cvv, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cvv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesActionPerformed

    private void anoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ano;
    private javax.swing.JTextField cvv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField mes;
    private javax.swing.JTextField tarjeta;
    // End of variables declaration//GEN-END:variables
}
