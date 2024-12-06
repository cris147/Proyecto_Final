/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Proyecto_Final {

    private static List<Carro> inventario = crearInventario();

    public static void main(String[] args) {
        JFrame menuFrame = new JFrame("Motomami's Company");
        menuFrame.setSize(400, 200);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLayout(new GridLayout(3, 1));

        JButton btnComprar = new JButton("Comprar Carros");
        JButton btnVender = new JButton("Vender Carros");
        JButton btnSalir = new JButton("Salir");

        
        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Compra compra = new Compra(inventario);
                compra.MenuC();
            }
        });

        // Acción para salir
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuFrame.add(btnComprar);
        menuFrame.add(btnVender);
        menuFrame.add(btnSalir);

        menuFrame.setVisible(true);
    }

    private static List<Carro> crearInventario() {
        List<Carro> inventario = new ArrayList<>();
        inventario.add(new Carro("Toyota", "Corolla", 2015, 15000));
        inventario.add(new Carro("Honda", "Civic", 2018, 18000));
        inventario.add(new Carro("BMW", "X5", 2020, 50000));
        return inventario;
    }
}
