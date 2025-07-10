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
        /*SalaPesas sala = new SalaPesas();

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
        sala.mostrarPresentes();*/
        SalaPesas sala = new SalaPesas();

        Usuario usuario1 = new Usuario(101, "Mateo", true);
        Usuario usuario2 = new Usuario(102, "Valeria", true);

        boolean salirSalaPesas = false;

        while (!salirSalaPesas) {
            String opcion = JOptionPane.showInputDialog(
                    "Sala de Pesas - Selecciona una opción:\n" +
                    "1. Ingresar usuario 1 (" + usuario1.getNombre() + ")\n" +
                    "2. Ingresar usuario 2 (" + usuario2.getNombre() + ")\n" +
                    "3. Salir usuario 1\n" +
                    "4. Salir usuario 2\n" +
                    "5. Ver presentes\n" +
                    "6. Salir del sistema"
            );

            if (opcion == null) break;

            switch (opcion) {
                case "1":
                    if (usuario1.isActivo()) {
                        sala.ingresarSalaPesas(usuario1.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario inactivo.");
                    }
                    break;

                case "2":
                    if (usuario2.isActivo()) {
                        sala.ingresarSalaPesas(usuario2.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario inactivo.");
                    }
                    break;

                case "3":
                    sala.salirSalaPesas(usuario1.getId());
                    break;

                case "4":
                    sala.salirSalaPesas(usuario2.getId());
                    break;

                case "5":
                    sala.mostrarPresentesSalaPesas();
                    break;

                case "6":
                    salirSalaPesas = true;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }
}


