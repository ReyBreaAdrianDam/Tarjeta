# Tarjeta y DNI
Ejercicio basado en javaBeans para el uso de componentes
## Contenido

Este ejercicio consta de dos clases que verifican un dni y una tarjeta de credito


## Clases
### El ejercicio tiene 4 clases
#### Comprobante
nada, esta clase sobra, solo era paa probar los elementos
#### JDniField
Esta clase extiende de JFrame y verifica dnis
##### Tarjeta
Esta clase extiende de JPanel, y verifica tarjetas de credito
##### NewJFrame
Esta clase eestaba para comprobar el funcionamiento de los JavaBeans
Metodo para comprobar el dni
```Java
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
```
Metodo para comprobar la tarjeta
```Java
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
```
