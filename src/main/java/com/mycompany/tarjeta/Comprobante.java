package com.mycompany.tarjeta;

import java.awt.*;
import javax.swing.*;

public class Comprobante {

    public static void main(String[] args) {
        JFrame x = new JFrame();
        //x.add(new JDniField());
        x.add(new Tarjeta());
        x.setVisible(true);
    }

}
