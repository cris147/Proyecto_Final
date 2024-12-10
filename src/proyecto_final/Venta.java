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
        JPanel ventaPanel = new JPanel();
        ventaPanel.setLayout(new BoxLayout(ventaPanel, BoxLayout.Y_AXIS));

        JPanel panelMarca = new JPanel();
        JLabel lblMarca = new JLabel("Marca:");
        JTextField txtMarca = new JTextField(8);
        panelMarca.add(lblMarca);
        panelMarca.add(txtMarca);

        JPanel panelAnio = new JPanel();
        JLabel lblAnio = new JLabel("Año:");
        JTextField txtAnio = new JTextField(4);
        panelAnio.add(lblAnio);
        panelAnio.add(txtAnio);

        JPanel panelPrecio = new JPanel();
        JLabel lblPrecio = new JLabel("Precio:");
        JTextField txtPrecio = new JTextField(6);
        panelPrecio.add(lblPrecio);
        panelPrecio.add(txtPrecio);

        JPanel panelBotones = new JPanel();
        JButton btnVender = new JButton("Vender Carro");
        panelBotones.add(btnVender);

        ventaPanel.add(panelMarca);
        ventaPanel.add(panelAnio);
        ventaPanel.add(panelPrecio);
        ventaPanel.add(panelBotones);

        panelDerecha.removeAll();
        panelDerecha.add(ventaPanel);
        panelDerecha.revalidate();
        panelDerecha.repaint();

        btnVender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String marca = txtMarca.getText();
                String anio = txtAnio.getText();
                String precio = txtPrecio.getText();

                if (!marca.isEmpty() && !anio.isEmpty() && !precio.isEmpty()) {
                    if (num(precio)) {
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

    private boolean num(String str) {
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
