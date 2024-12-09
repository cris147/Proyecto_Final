/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Perfil {
    private JLabel dinero;
    private List<Carro> carrosUsuario;
    private double dineroGastado;
    private double dineroObtenido;

    public Perfil(JLabel dinero, List<Carro> carrosUsuario, double dineroGastado, double dineroObtenido) {
        this.dinero = dinero;
        this.carrosUsuario = carrosUsuario;
        this.dineroGastado = dineroGastado;
        this.dineroObtenido = dineroObtenido;
    }

    public void MenuPerfil() {
    JFrame perfilFrame = new JFrame("Perfil del Usuario");
    perfilFrame.setSize(800, 400);
    perfilFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel perfilPanel = new JPanel();
    perfilPanel.setLayout(new BoxLayout(perfilPanel, BoxLayout.Y_AXIS));

    JLabel perfilLabel = new JLabel("Perfil de " + Proyecto_Final.getUsuarioNombre());
    perfilLabel.setFont(new Font("Arial", Font.BOLD, 24));

    JLabel carrosLabel = new JLabel("Carros comprados:");
    perfilPanel.add(perfilLabel);
    perfilPanel.add(carrosLabel);

    for (Carro carro : carrosUsuario) {
        perfilPanel.add(new JLabel(carro.toString()));
    }

    JLabel dineroGastadoLabel = new JLabel("Dinero gastado: $" + dineroGastado);
    JLabel dineroObtenidoLabel = new JLabel("Dinero obtenido por ventas: $" + dineroObtenido);

    perfilPanel.add(dineroGastadoLabel);
    perfilPanel.add(dineroObtenidoLabel);

    perfilFrame.add(perfilPanel);
    perfilFrame.setVisible(true);
}

}
