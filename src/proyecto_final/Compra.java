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
import java.util.Iterator;

public class Compra {
    private List<Carro> inventario;
    private JLabel dine;
    private List<Carro> carrosUsuario;

    public Compra(List<Carro> inventario, JLabel dine, List<Carro> carrosUsuario) {
        this.inventario = inventario;
        this.dine = dine;
        this.carrosUsuario = carrosUsuario;
    }

    public void MenuC(JPanel panelDerecha) {
        panelDerecha.removeAll();

        JButton btnPorMarca = new JButton("Filtrar por Marca");
        JButton btnPorAnio = new JButton("Filtrar por Año");
        JButton btnPorPrecio = new JButton("Filtrar por Precio");
        JButton btnVerTodos = new JButton("Ver Todos");

        panelDerecha.add(btnPorMarca);
        panelDerecha.add(btnPorAnio);
        panelDerecha.add(btnPorPrecio);
        panelDerecha.add(btnVerTodos);

        // Botón para filtrar por marca
        btnPorMarca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCarrosFiltrados(panelDerecha, "marca");
            }
        });

        // Botón para filtrar por año
        btnPorAnio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCarrosFiltrados(panelDerecha, "anio");
            }
        });

        // Botón para filtrar por precio
        btnPorPrecio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCarrosFiltrados(panelDerecha, "precio");
            }
        });

        // Botón para ver todos los carros
        btnVerTodos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCarrosFiltrados(panelDerecha, "todos");
            }
        });

        panelDerecha.revalidate();
        panelDerecha.repaint();
    }

    private void mostrarCarrosFiltrados(JPanel panelDerecha, String filtro) {
        panelDerecha.removeAll();

        String valor = "";
        // Si no es el filtro "todos", pedimos el valor para el filtro
        if (!"todos".equals(filtro)) {
            valor = JOptionPane.showInputDialog("Ingrese el valor para el filtro:");
            if (valor == null || valor.trim().isEmpty()) return;
        }

        // Recorrer el inventario y mostrar los carros que coinciden con el filtro
        for (Carro carro : inventario) {
            boolean coincide = false;

            if ("marca".equals(filtro)) {
                coincide = carro.getMarca().equalsIgnoreCase(valor);
            } else if ("anio".equals(filtro)) {
                coincide = Integer.toString(carro.getAnio()).equals(valor);
            } else if ("precio".equals(filtro)) {
                coincide = esNumero(valor) && carro.getPrecio() <= Integer.parseInt(valor);
            } else if ("todos".equals(filtro)) {
                coincide = true;
            }

            if (coincide) {
                JPanel carroPanel = new JPanel(new BorderLayout());
                JLabel carroLabel = new JLabel(carro.toString() + " - $" + carro.getPrecio());
                JButton btnComprar = new JButton("Comprar");

                btnComprar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Verifica si el usuario tiene suficiente dinero para comprar el carro
                        if (Proyecto_Final.dinero >= carro.getPrecio()) {
                            // Restamos el precio del carro del dinero disponible
                            Proyecto_Final.dinero -= carro.getPrecio();
                            // Actualizamos el dinero gastado
                            Proyecto_Final.dineroGastado += carro.getPrecio();
                            // Actualizamos la etiqueta de dinero disponible
                            dine.setText("Dinero disponible: $" + Proyecto_Final.dinero);
                            // Agregamos el carro al inventario del usuario
                            carrosUsuario.add(carro);
                            // Eliminamos el carro del inventario de la tienda
                            eliminarCarroDelInventario(carro);
                            // Mostramos un mensaje de éxito
                            JOptionPane.showMessageDialog(null, "Compra exitosa de: " + carro.getMarca() + " " + carro.getModelo());
                        } else {
                            // Si no tiene suficiente dinero, mostramos un mensaje
                            JOptionPane.showMessageDialog(null, "No tienes suficiente dinero.");
                        }
                    }
                });

                carroPanel.add(carroLabel, BorderLayout.CENTER);
                carroPanel.add(btnComprar, BorderLayout.SOUTH);
                panelDerecha.add(carroPanel);
            }
        }

        JButton btnVolver = new JButton("Volver al menú de compra");
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuC(panelDerecha);
            }
        });
        panelDerecha.add(btnVolver);

        panelDerecha.revalidate();
        panelDerecha.repaint();
    }

    private void eliminarCarroDelInventario(Carro carro) {
        Iterator<Carro> iterator = inventario.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(carro)) {
                iterator.remove();
                break;
            }
        }
    }

    private boolean esNumero(String str) {
        return str.matches("\\d+");
    }
}
