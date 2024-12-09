/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List; 

public class Proyecto_Final {
    private static List<Carro> inventario = crearInventario(); 
    private static List<Carro> carrosUsuario = new ArrayList<>(); 
    private static String usuarioNombre = "";
    public static double dinero = 50000;
    public static double dineroGastado = 0;
    public static double dineroObtenido = 0;
    static JPanel panelPequeno = new JPanel();
    private static JLabel dine;

    public static void main(String[] args) {
        JFrame bienvenidaFrame = new JFrame("Motomami's Company");
        bienvenidaFrame.setSize(800, 400);
        bienvenidaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bienvenidaFrame.setLayout(new BorderLayout());

        JLabel bienvenidaLabel = new JLabel("BIENVENIDO A MOTOMAMI'S COMPANY", SwingConstants.CENTER);
        bienvenidaLabel.setFont(new Font("Arial", Font.BOLD, 30));
        bienvenidaLabel.setForeground(Color.BLACK);
        bienvenidaFrame.add(bienvenidaLabel, BorderLayout.NORTH);

        bienvenidaFrame.getContentPane().setBackground(new Color(211, 211, 211));

        
        URL logoURL = Proyecto_Final.class.getResource("/Logo.png");
        ImageIcon logoIcon = new ImageIcon("Logo.png");
        JLabel logolabel = new JLabel("Logo.png");
        logolabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JPanel panelNombre = new JPanel();
        panelNombre.setLayout(new FlowLayout());
        panelNombre.setBackground(new Color(211, 201, 211));

        JLabel nombreLabel = new JLabel("Ingrese su nombre:");
        nombreLabel.setForeground(Color.BLACK);
        JTextField nombreField = new JTextField(20);
        panelNombre.add(nombreLabel);
        panelNombre.add(nombreField);
        bienvenidaFrame.add(panelNombre, BorderLayout.SOUTH);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBackground(new Color(255, 153, 51));
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                usuarioNombre = nombreField.getText(); 
                if (!usuarioNombre.isEmpty()) {
                    bienvenidaFrame.dispose(); 
                    mostrarMenu(); 
                } else {
                    JOptionPane.showMessageDialog(bienvenidaFrame, "Por favor, ingrese su nombre.");
                }
            }
        });

        panelNombre.add(btnEntrar);

        bienvenidaFrame.setVisible(true);
    }

    

    private static void mostrarMenu() {
        JFrame menuFrame = new JFrame("Motomami's Company");
        menuFrame.setSize(800, 400);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLayout(new BorderLayout());

        menuFrame.getContentPane().setBackground(new Color(240, 240, 240));

        dine = new JLabel("Dinero disponible: $" + dinero);
        dine.setHorizontalAlignment(SwingConstants.CENTER);
        dine.setFont(new Font("Arial", Font.BOLD, 20));
        menuFrame.add(dine, BorderLayout.NORTH);

        JPanel panelBusqueda = new JPanel();
        panelBusqueda.setLayout(new FlowLayout());
        panelBusqueda.setBackground(new Color(240, 240, 240));
        menuFrame.add(panelBusqueda, BorderLayout.SOUTH);

        JPanel panelIzquierda = new JPanel();
        panelIzquierda.setLayout(new BoxLayout(panelIzquierda, BoxLayout.Y_AXIS));
        panelIzquierda.setBackground(new Color(169, 169, 169));
        
        JButton btnComprar = new JButton("Comprar Carros");
        JButton btnVender = new JButton("Vender Carros");
        JButton btnVerPerfil = new JButton("Ver Perfil");
        JButton btnSalir = new JButton("Salir");

       btnComprar.setBackground(new Color(216, 168, 92));
       btnVender.setBackground(new Color(216, 168, 92)); 
       btnVerPerfil.setBackground(new Color(216, 168, 92)); 
       btnSalir.setBackground(new Color(216, 168, 92)); 

        panelIzquierda.add(btnComprar);
        panelIzquierda.add(btnVender);
        panelIzquierda.add(btnVerPerfil);
        panelIzquierda.add(btnSalir);

        menuFrame.add(panelIzquierda, BorderLayout.WEST);

        JPanel panelResultados = new JPanel();
        panelResultados.setLayout(new BorderLayout());
        panelPequeno.setPreferredSize(new Dimension(300, 100));

        JLabel resultadoSuperior = new JLabel("Resultados de Carros");
        resultadoSuperior.setHorizontalAlignment(SwingConstants.CENTER);
        panelResultados.add(resultadoSuperior, BorderLayout.NORTH);
        panelResultados.add(panelPequeno, BorderLayout.CENTER);

        JScrollPane scrollPaneDerecha = new JScrollPane(panelResultados);
        menuFrame.add(scrollPaneDerecha, BorderLayout.CENTER);

        btnComprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Compra compra = new Compra(inventario, dine, carrosUsuario);
                compra.MenuC(panelPequeno);
            }
        });

        btnVender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelPequeno.removeAll();
                panelPequeno.revalidate();
                panelPequeno.repaint();
                Venta venta = new Venta(inventario, dine, panelPequeno, carrosUsuario);
                venta.MenuV();
            }
        });

        btnVerPerfil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Perfil perfil = new Perfil(dine, carrosUsuario, dineroGastado, dineroObtenido);
                perfil.MenuPerfil();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuFrame.setVisible(true);
    }

    private static List<Carro> crearInventario() {
        List<Carro> inventario = new ArrayList<>();
        inventario.add(new Carro("BMW", "M3", 2020, "35000"));
        inventario.add(new Carro("Audi", "A4", 2021, "38000"));
        inventario.add(new Carro("Tesla", "Model 3", 2022, "40000"));
        inventario.add(new Carro("Ferrari", "488 GTB", 2018, "180000"));
        inventario.add(new Carro("Chevrolet", "Camaro", 2019, "30000"));
        return inventario;
    }

    public static double getDinero() {
        return dinero;
    }

    public static void setDinero(double dinero) {
        Proyecto_Final.dinero = dinero;
    }

    public static String getUsuarioNombre() {
        return usuarioNombre;
    }
}
