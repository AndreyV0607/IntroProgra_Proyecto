/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package introprogra_proyectofinal1.pkg0;

/**
 *
 * @author andreyvargassolis
 */
public class SalaPesas {
    
    private int capacidad =50;
    private int[] usuariosRegistrados = new int[capacidad];
    private int acumulador = 0;
    
    //Se van guardando los registros de usuarios al arreglo hasta llenar el aforo
    public void ingresar(int usuarioID){
        if(acumulador<capacidad){
            usuariosRegistrados[acumulador] = usuarioID;
            acumulador++;
        }  
    }
    public void cancelar(int usuarioID){
        //SIN TERMINAR
        //Salida de la clase
    }
}
