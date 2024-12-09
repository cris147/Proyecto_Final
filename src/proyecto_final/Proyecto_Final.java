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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List; // Importar List

public class Proyecto_Final {
    private static List<Carro> inventario = crearInventario(); // Lista de carros en inventario
    private static List<Carro> carrosUsuario = new ArrayList<>(); // Lista de carros comprados por el usuario
    private static String usuarioNombre = "";
    public static double dinero = 50000;
    public static double dineroGastado = 0;
    public static double dineroObtenido = 0;
    static JPanel panelPequeno = new JPanel();
    private static JLabel dine;

    public static void main(String[] args) {
        // Crear la ventana de bienvenida
        JFrame bienvenidaFrame = new JFrame("Motomami's Company");
        bienvenidaFrame.setSize(800, 400);
        bienvenidaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bienvenidaFrame.setLayout(new BorderLayout());

        // Título de bienvenida
        JLabel bienvenidaLabel = new JLabel("BIENVENIDO A MOTOMAMI'S COMPANY", SwingConstants.CENTER);
        bienvenidaLabel.setFont(new Font("Arial", Font.BOLD, 30));
        bienvenidaLabel.setForeground(Color.WHITE);
        bienvenidaFrame.add(bienvenidaLabel, BorderLayout.NORTH);

        // Fondo de la ventana de bienvenida
        bienvenidaFrame.getContentPane().setBackground(new Color(0, 102, 204));

        // Logo (cargar imagen desde la URL)
        String logoUrl = "https://i.ibb.co/vq85T0h/logo.png"; // URL de la imagen del logo
        try {
            URL url = new URL(logoUrl);
            ImageIcon logoIcon = new ImageIcon(url);
            Image logoImage = logoIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Ajustar tamaño
            JLabel logoLabel = new JLabel(new ImageIcon(logoImage), SwingConstants.CENTER);
            bienvenidaFrame.add(logoLabel, BorderLayout.CENTER);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(bienvenidaFrame, "No se pudo cargar el logo.");
        }

        // Campo para ingresar el nombre del usuario
        JPanel panelNombre = new JPanel();
        panelNombre.setLayout(new FlowLayout());
        panelNombre.setBackground(new Color(0, 102, 204));

        JLabel nombreLabel = new JLabel("Ingrese su nombre:");
        nombreLabel.setForeground(Color.WHITE);
        JTextField nombreField = new JTextField(20);
        panelNombre.add(nombreLabel);
        panelNombre.add(nombreField);
        bienvenidaFrame.add(panelNombre, BorderLayout.SOUTH);

        // Botón para continuar
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBackground(new Color(255, 153, 51)); // Naranja
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                usuarioNombre = nombreField.getText(); // Guardar el nombre ingresado
                if (!usuarioNombre.isEmpty()) {
                    bienvenidaFrame.dispose(); // Cerrar la ventana de bienvenida
                    mostrarMenu(); // Llamar al método para mostrar el menú principal
                } else {
                    JOptionPane.showMessageDialog(bienvenidaFrame, "Por favor, ingrese su nombre.");
                }
            }
        });

        panelNombre.add(btnEntrar);

        bienvenidaFrame.setVisible(true);
    }

    // Método para mostrar el menú principal después de la bienvenida
    private static void mostrarMenu() {
        JFrame menuFrame = new JFrame("Motomami's Company");
        menuFrame.setSize(800, 400);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLayout(new BorderLayout());

        // Fondo del menú
        menuFrame.getContentPane().setBackground(new Color(240, 240, 240));

        // Panel de dinero
        dine = new JLabel("Dinero disponible: $" + dinero);
        dine.setHorizontalAlignment(SwingConstants.CENTER);
        dine.setFont(new Font("Arial", Font.BOLD, 20));
        menuFrame.add(dine, BorderLayout.NORTH);

        // Panel de búsqueda
        JPanel panelBusqueda = new JPanel();
        panelBusqueda.setLayout(new FlowLayout());
        panelBusqueda.setBackground(new Color(240, 240, 240));
        menuFrame.add(panelBusqueda, BorderLayout.SOUTH);

        // Panel de opciones
        JPanel panelIzquierda = new JPanel();
        panelIzquierda.setLayout(new BoxLayout(panelIzquierda, BoxLayout.Y_AXIS));
        panelIzquierda.setBackground(new Color(0, 102, 204));

        JButton btnComprar = new JButton("Comprar Carros");
        JButton btnVender = new JButton("Vender Carros");
        JButton btnVerPerfil = new JButton("Ver Perfil");
        JButton btnSalir = new JButton("Salir");

        btnComprar.setBackground(new Color(255, 153, 51));
        btnVender.setBackground(new Color(255, 153, 51));
        btnVerPerfil.setBackground(new Color(255, 153, 51));
        btnSalir.setBackground(new Color(255, 153, 51));

        panelIzquierda.add(btnComprar);
        panelIzquierda.add(btnVender);
        panelIzquierda.add(btnVerPerfil);
        panelIzquierda.add(btnSalir);

        menuFrame.add(panelIzquierda, BorderLayout.WEST);

        // Panel de resultados
        JPanel panelResultados = new JPanel();
        panelResultados.setLayout(new BorderLayout());
        panelPequeno.setPreferredSize(new Dimension(300, 100));

        JLabel resultadoSuperior = new JLabel("Resultados de Carros");
        resultadoSuperior.setHorizontalAlignment(SwingConstants.CENTER);
        panelResultados.add(resultadoSuperior, BorderLayout.NORTH);
        panelResultados.add(panelPequeno, BorderLayout.CENTER);

        JScrollPane scrollPaneDerecha = new JScrollPane(panelResultados);
        menuFrame.add(scrollPaneDerecha, BorderLayout.CENTER);

        // Acción para comprar carros
        btnComprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Compra compra = new Compra(inventario, dine, carrosUsuario);
                compra.MenuC(panelPequeno);
            }
        });

        // Acción para vender carros
        btnVender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelPequeno.removeAll();
                panelPequeno.revalidate();
                panelPequeno.repaint();
                Venta venta = new Venta(inventario, dine, panelPequeno, carrosUsuario);
                venta.MenuV();
            }
        });

        // Acción para ver perfil
        btnVerPerfil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Perfil perfil = new Perfil(dine, carrosUsuario, dineroGastado, dineroObtenido);
                perfil.MenuPerfil();
            }
        });

        // Acción para salir
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
