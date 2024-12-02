/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_final;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Proyecto_Final implements ActionListener {

    /*
    private static JPanel panel;
    private static JFrame frame;
    private static JLabel label;
    private static JTextField u;
    private static JLabel pass;
    private static JPasswordField p;
    private static JButton boton;
    private static JLabel per;

    public static void main(String[] args) {
        panel = new JPanel();
        frame = new JFrame();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);
        label = new JLabel("Usuario");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        u = new JTextField(20);
        u.setBounds(100, 20, 165, 25);
        panel.add(u);

        pass = new JLabel("Contrasenia");
        pass.setBounds(10, 50, 80, 25);
        panel.add(pass);

        p = new JPasswordField();
        p.setBounds(100, 50, 165, 25);
        panel.add(p);

        boton = new JButton("Enter");
        boton.setBounds(10, 80, 80, 25);
        boton.addActionListener(new Proyecto_Final());
        panel.add(boton);

        per = new JLabel("");
        per.setBounds(10, 110, 300, 25);
        panel.add(per);
        per.setText("");

        frame.setVisible(true);*/

       
        List<Carro> inventario = inicializarInventario();

       
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de compra y venta de carros.");
        System.out.println("1. Mostrar inventario completo.");
        System.out.println("2. Buscar carro por marca.");
        System.out.println("3. Buscar carro por año.");
        System.out.println("4. Salir.");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                mostrarInventario(inventario);
                break;
            case 2:
                System.out.print("Ingrese la marca: ");
                String marca = scanner.next();
                buscarPorMarca(inventario, marca);
                break;
            case 3:
                System.out.print("Ingrese el año: ");
                int anio = scanner.nextInt();
                buscarPorAnio(inventario, anio);
                break;
            case 4:
                System.out.println("Gracias por usar el sistema.");
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    // Método para inicializar el inventario con 30 carros
    private static List<Carro> inicializarInventario() {
        List<Carro> inventario = new ArrayList<>();
        inventario.add(new Carro("Toyota", "Corolla", 2015, 15000));
        inventario.add(new Carro("Honda", "Civic", 2018, 18000));
        inventario.add(new Carro("BMW", "X5", 2020, 50000));
        // Añade más carros hasta llegar a 30
        return inventario;
    }

    // Método para mostrar todo el inventario
    private static void mostrarInventario(List<Carro> inventario) {
        for (Carro carro : inventario) {
            System.out.println(carro);
        }
    }

    // Método para buscar carros por marca
    private static void buscarPorMarca(List<Carro> inventario, String marca) {
        for (Carro carro : inventario) {
            if (carro.getMarca().equalsIgnoreCase(marca)) {
                System.out.println(carro);
            }
        }
    }

    // Método para buscar carros por año
    private static void buscarPorAnio(List<Carro> inventario, int anio) {
        for (Carro carro : inventario) {
            if (carro.getAnio() == anio) {
                System.out.println(carro);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String us = u.getText();
        String pass = p.getText();

        if (us.equalsIgnoreCase("Alex") && pass.equalsIgnoreCase("Hola123")) {
            per.setText("Bien hecho");
        } else {
            per.setText("Wrong user or password");
        }
    }
}

// Clase Carro
class Carro {
    private String marca;
    private String modelo;
    private int anio;
    private double precio;

    public Carro(String marca, String modelo, int anio, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Año: " + anio + ", Precio: $" + precio;
    }
}
