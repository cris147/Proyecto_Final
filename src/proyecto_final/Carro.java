/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final;

public class Carro {
    private String marca;
    private String modelo;
    private int anio;
    private double precio;

    public Carro(String marca, String modelo, int anio, String precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = Double.parseDouble(precio);
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " (" + anio + ") - $" + precio;
    }
}
