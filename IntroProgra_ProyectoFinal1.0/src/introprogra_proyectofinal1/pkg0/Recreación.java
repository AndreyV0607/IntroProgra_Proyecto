/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package introprogra_proyectofinal1.pkg0;

/**
 *
 * @author andreyvargassolis
 */
public class Recreacion {
    
    private int maxEspacios = 10;
    private int maxReservas = 100;
    private int cantidadTurnosMesas = 16; 

    // --- Atributos de la Clase ---
    private EspacioRecreativo[] espacios;
    private Reserva[] reservas;
    private String[][] matrizHorariosMesas; 
    private String[] etiquetasTurnos;

    private int numEspacios;
    private int numReservas;

    private Usuario[] listaGeneralDeUsuarios;
    private int cantidadTotalUsuarios;
}
