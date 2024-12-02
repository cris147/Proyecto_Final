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

public class Proyecto_Final{

   /*Probando el GUI, luego agrego las funciones del codigo a el.  
    private static JPanel panel;
    private static JFrame frame;
    private static JLabel label;
    private static JTextField u;
    private static JLabel pass;
    private static JPasswordField p;
    private static JButton boton;
    private static JLabel per;*/

    public static void main(String[] args) {
        /*panel = new JPanel();
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

        List<Carro> inv = Inventario();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido Motomami's Company");
        System.out.println("1. Mostrar inventario completo.");
        System.out.println("2. Buscar carro por marca.");
        System.out.println("3. Buscar carro por anio.");
        System.out.println("4. Salir.");
        System.out.print("Seleccione una opcion: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                mostrar(inv);
                break;
            case 2:
                System.out.print("Ingrese la marca: ");
                String marca = scanner.next();
                marcac(inv, marca);
                break;
            case 3:
                System.out.print("Ingrese el anio: ");
                int anio = scanner.nextInt();
                anioc(inv, anio);
                break;
            case 4:
                System.out.println("Gracias por usar el sistema.");
                break;
            default:
                System.out.println("Opción invalida.");
        }
    }

   
    private static List<Carro> Inventario() {
        List<Carro> inventario = new ArrayList<>();
        inventario.add(new Carro("Toyota", "Corolla", 2015, 15000));
        inventario.add(new Carro("Honda", "Civic", 2018, 18000));
        inventario.add(new Carro("BMW", "X5", 2020, 50000));
        return inventario;
    }

    private static void mostrar(List<Carro> inv) {
        for (Carro carro : inv) {
            System.out.println(carro);
        }
    }

    private static void marcac(List<Carro> inv, String marca) {
        for (Carro carro : inv) {
            if (carro.getMarca().equalsIgnoreCase(marca)) {
                System.out.println(carro);
            }
        }
    }

    private static void anioc(List<Carro> inv, int anio) {
        for (Carro carro : inv) {
            if (carro.getAnio() == anio) {
                System.out.println(carro);
            }
        }
    }

    /* @Override
    public void actionPerformed(ActionEvent e) {
        String us = u.getText();
        String pass = p.getText();

        if (us.equalsIgnoreCase("Alex") && pass.equalsIgnoreCase("Hola123")) {
            per.setText("Bien hecho");
        } else {
            per.setText("Wrong user or password");
        }
    }*/
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
        return "Marca: " + marca + ", Modelo: " + modelo + ", Anio: " + anio + ", Precio: " + precio;
    }
}


/*Acciones o Funcionalidades
Mostrar el inventario completo de carros.
Buscar carros por marca.
Buscar carros por anio.
Salir del sistema.

Elementos Utilizados
Clases:
Proyecto_Final
Carro

Estructuras de control:
Condicional switch para manejar el menu de opciones.
Bucles for para recorrer el inventario y realizar búsquedas.

Colecciones:
List<Carro> (ArrayList)

Entradas y salidas:
Scanner
System.out.println.

Métodos:
Inventario, mostrar, marcac y anioc

Interfaz gráfica (en proceso):
JFrame, JPanel, JButton, JTextField, JPasswordField
*/
