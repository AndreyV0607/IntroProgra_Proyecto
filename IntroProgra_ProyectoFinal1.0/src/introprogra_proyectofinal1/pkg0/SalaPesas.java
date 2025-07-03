/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package introprogra_proyectofinal1.pkg0;

import javax.swing.JOptionPane;

/**
 *
 * @author andreyvargassolis
 */
public class SalaPesas {
    
    private int capacidad =50;
    private int[] usuariosRegistrados = new int[capacidad];
    private int acumulador = 0;
    
    //Se van guardando los registros de usuarios al arreglo hasta llenar el aforo
    public boolean ingresarPesas(int usuarioID){
        if(acumulador<capacidad){
            usuariosRegistrados[acumulador] = usuarioID;
            acumulador++;
            JOptionPane.showMessageDialog(null, "Se le ha asignado un espacio al usuario"+ usuarioID + "con extio");
            return true;
        }  
        JOptionPane.showMessageDialog(null, "La sala de pesas esta a máxima capacidad");
        return false;
    }
    public void salirPesas(int usuarioID){
        for (int i = 0; i < acumulador; i++) {
            if (usuariosRegistrados[i] == usuarioID) {
                    // Desplazar para no dejar huecos
                    for (int j = i; j < acumulador - 1; j++) {
                        usuariosRegistrados[j] = usuariosRegistrados[j + 1];
                    }
                    acumulador--; // Disminuye cantidad
                    break;
            }
        }
    }
    
    public void mostrarPresentesPesas() {
        if (acumulador == 0) {
            JOptionPane.showMessageDialog(null, "No hay socios en la sala.");
        } else {
            String mensaje = "Socios actualmente en la sala:\n";
            for (int i = 0; i < acumulador; i++) {
                mensaje += "- ID: " + usuariosRegistrados[i] + "\n";
            }
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
}

