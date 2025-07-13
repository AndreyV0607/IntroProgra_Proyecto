/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package introprogra_proyectofinal1.pkg0;

import javax.swing.JOptionPane;

/**
 *
 * @author andreyvargassolis
 */
public class IntroProgra_ProyectoFinal10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SalaPesas sala = new SalaPesas();

        // Ingresar socios
        int id1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del primer socio:"));
        sala.ingresar(id1);

        int id2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del segundo socio:"));
        sala.ingresar(id2);

        int id3 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del tercer socio:"));
        sala.ingresar(id3);

        // Mostrar presentes
        sala.mostrarPresentes();

        // Salida de un socio
        int idSalida = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del socio que va a salir:"));
        sala.salir(idSalida);

        // Mostrar presentes de nuevo
        sala.mostrarPresentes();
    }
}


