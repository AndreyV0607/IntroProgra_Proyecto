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

    //  Atributos 
    // Capacidades máximas
    private final int max_Futbol = 12;
    private final int max_Basquetbol = 10;
    private final int max_Tenis = 2;
    
    //  variables para contar jugadores
    private int jugadoresFutbol1;
    private int jugadoresFutbol2;
    private int jugadoresBasquetbol;
    private int jugadoresTenis1;
    private int jugadoresTenis2;

//Constructor 
    public Recreacion() {
        this.jugadoresFutbol1 = 0;
        this.jugadoresFutbol2 = 0;
        this.jugadoresBasquetbol = 0; // Se usa tu variable
        this.jugadoresTenis1 = 0;
        this.jugadoresTenis2 = 0;
    }
//  Métodos de Baloncesto 
    public void reservarBaloncesto(int cantidadJugadores) {
        // Verifica si la suma de los jugadores actuales y los nuevos se pasa del maximo
        if ((this.jugadoresBasquetbol + cantidadJugadores) <= this.max_Basquetbol) {
            // Si hay espacio, se suman los nuevos jugadores
            this.jugadoresBasquetbol += cantidadJugadores;
            JOptionPane.showMessageDialog(null, "Reserva exitosa. Jugadores en cancha: " + this.jugadoresBasquetbol);
        } else {
            // Si no hay espacio, se muestra un error
            JOptionPane.showMessageDialog(null, " No hay suficiente espacio en la cancha de basquet.");
        }
    }
 public void liberarBaloncesto(int cantidadJugadores) {
        // Verifica que no se liberen más jugadores de los que hay
        if ((this.jugadoresBasquetbol - cantidadJugadores) >= 0) {
            // Si es válido, se restan los jugadores
            this.jugadoresBasquetbol -= cantidadJugadores;
            JOptionPane.showMessageDialog(null, "Liberación exitosa. Jugadores en cancha: " + this.jugadoresBasquetbol);
        } else {
            // Si se intenta liberar más de los que hay, se establece en 0
            this.jugadoresBasquetbol = 0;
            JOptionPane.showMessageDialog(null, "Error: No se pueden liberar más jugadores de los que existen. La cancha ha sido vaciada.");
        }
    }
}

    
}
