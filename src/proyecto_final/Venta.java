/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Venta {
    private List<Carro> inventario;
    private JLabel dinero;
    private JPanel panelDerecha;
    private List<Carro> carrosUsuario;

    public Venta(List<Carro> inventario, JLabel dinero, JPanel panelDerecha, List<Carro> carrosUsuario) {
        this.inventario = inventario;
        this.dinero = dinero;
        this.panelDerecha = panelDerecha;
        this.carrosUsuario = carrosUsuario;
    }

    public void MenuV() {
        // Usamos el diseño estándar sin CardLayout
        JPanel ventaPanel = new JPanel();
        ventaPanel.setLayout(new BoxLayout(ventaPanel, BoxLayout.Y_AXIS));

        // Panel para Marca
        JPanel panelMarca = new JPanel();
        JLabel lblMarca = new JLabel("Marca:");
        JTextField txtMarca = new JTextField(8);
        panelMarca.add(lblMarca);
        panelMarca.add(txtMarca);

        // Panel para Año
        JPanel panelAnio = new JPanel();
        JLabel lblAnio = new JLabel("Año:");
        JTextField txtAnio = new JTextField(4);
        panelAnio.add(lblAnio);
        panelAnio.add(txtAnio);

        // Panel para Precio
        JPanel panelPrecio = new JPanel();
        JLabel lblPrecio = new JLabel("Precio:");
        JTextField txtPrecio = new JTextField(6);
        panelPrecio.add(lblPrecio);
        panelPrecio.add(txtPrecio);

        // Botón para vender carro
        JPanel panelBotones = new JPanel();
        JButton btnVender = new JButton("Vender Carro");
        panelBotones.add(btnVender);

        ventaPanel.add(panelMarca);
        ventaPanel.add(panelAnio);
        ventaPanel.add(panelPrecio);
        ventaPanel.add(panelBotones);

        // Añadir el panel a la derecha
        panelDerecha.removeAll();
        panelDerecha.add(ventaPanel);
        panelDerecha.revalidate();
        panelDerecha.repaint();

        // Acción del botón "Vender Carro"
        btnVender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String marca = txtMarca.getText();
                String anio = txtAnio.getText();
                String precio = txtPrecio.getText();

                // Validar que no esté vacío
                if (!marca.isEmpty() && !anio.isEmpty() && !precio.isEmpty()) {
                    // Verificamos si el precio es un número
                    if (esNumero(precio)) {
                        double precioDouble = Double.parseDouble(precio);
                        Carro carroVendido = new Carro(marca, "", Integer.parseInt(anio), precio);
                        Proyecto_Final.dinero += precioDouble * 0.88;
                        Proyecto_Final.dineroObtenido += precioDouble*0.88;
                        dinero.setText("Dinero disponible: $" + Proyecto_Final.dinero);
                        carrosUsuario.remove(carroVendido);
                        JOptionPane.showMessageDialog(panelDerecha, "Carro vendido con éxito");
                    } else {
                        JOptionPane.showMessageDialog(panelDerecha, "El precio no es válido.");
                    }
                } else {
                    JOptionPane.showMessageDialog(panelDerecha, "Por favor, complete todos los campos.");
                }
            }
        });
    }

    // Método para verificar si una cadena es un número
    private boolean esNumero(String str) {
        // Comprobamos si la cadena contiene solo dígitos
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
