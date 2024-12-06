/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.List;

/**
 *
 * @author BLINTEC
 */
public class Compra{
   
    
    private List<Carro> inventario;
    
   public Compra(List<Carro> inventario){
       this.inventario = inventario;
   }
   
   public void MenuC() {
       JFrame comprar  = new JFrame("Comprar Carros");
       comprar.setSize(400,300);
       comprar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       comprar.setLayout(new BoxLayout(comprar.getContentPane(), BoxLayout.Y_AXIS));
       
       JButton BMarca = new JButton("Buscar por marca");
       JButton BAnio  = new JButton("Buscar por anio");
       JButton BPrecio = new JButton("Buscar por precio");
       
       BMarca.addActionListener(new ActionListener(){
       @Override
        public void actionPerformed(ActionEvent arg0){
           Marca();
       }
   
   });
   
        BAnio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                Anio();
            }
        });
        
        BPrecio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                Precio();
            }
        
        });
   
        comprar.add(BMarca);
        comprar.add(BAnio);
        comprar.add(BPrecio);
        
        
        comprar.setVisible(true);
   }
    
   private void Marca() {
        String marca = JOptionPane.showInputDialog(null, "Ingrese la marca:");
        if (marca != null && !marca.isEmpty()) {
            StringBuilder resultado = new StringBuilder("Resultados de búsqueda:\n");
            for (Carro carro : inventario) {
                if (carro.getMarca().equalsIgnoreCase(marca)) {
                    resultado.append(carro).append("\n");
                }
            }
            Mostrar(resultado.toString());
        }
    }
   
   
   private void Anio() {
    String Anio = JOptionPane.showInputDialog(null, "Ingrese el año:");
    if (Anio != null && !Anio.isEmpty()) {
        boolean Num = true;
        for (int i = 0; i < Anio.length(); i++) {
            if (Anio.charAt(i) < '0' || Anio.charAt(i) >'9'){
                Num = false;
                break;
            }
            
        }
        if (Num) {
            int anio = Integer.parseInt(Anio);
            StringBuilder resultado = new StringBuilder("Resultados de búsqueda:\n");
            for (Carro carro : inventario) {
                if (carro.getAnio() == anio) {
                    resultado.append(carro).append("\n");
                }
            }
            Mostrar(resultado.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un año válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

    private void Precio() {
    String precio = JOptionPane.showInputDialog(null, "Ingrese el precio: ");
  
    if (precio != null && !precio.isEmpty()) {
        boolean nm = true;
        
        // Verificar si el precio ingresado es válido (solo números)
        for (int i = 0; i < precio.length(); i++) {
            if (precio.charAt(i) < '0' || precio.charAt(i) > '9') {
                nm = false;
                break;
            }
        }
        
        if (nm) {
            int pr = Integer.parseInt(precio);
            if (pr >= 0) {
                StringBuilder re = new StringBuilder("Resultado de búsqueda: \n");
                boolean found = false; 

                for (Carro carro : inventario) {
                    if (carro.getPrecio() <= pr) {
                        re.append(carro).append("\n");
                        found = true;  
                    }
                }
                
                if (!found) {
                    re.append("No se encontraron carros con ese precio.\n");
                }

                Mostrar(re.toString()); 
            } else {
                JOptionPane.showMessageDialog(null, "El precio no puede ser negativo.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un precio válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

    
    private void Mostrar(String mensaje){
            JOptionPane.showMessageDialog(null, mensaje,"Resultados", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
}
