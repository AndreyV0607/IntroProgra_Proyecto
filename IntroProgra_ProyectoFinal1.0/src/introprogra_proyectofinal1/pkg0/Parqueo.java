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
public class Parqueo {
    
    private String[][] g1 = new String[4][5];
    private String[][] g2 = new String[5][5];
    private String[][] g3 = new String[6][5];

    public Parqueo() {
        setupParqueos();
        //Este contructor hace que cuando lo llamemos al main asgine los espacione de los tres parqueos
    }

    private void setupParqueos() {
        //Aquí se asgina los espacios para los tres parqueos
        g1 = new String[][]{
            {"E","O", "L", "L", "O"},
            {"L", "L", "L", "L", "L"},
            {"L", "O", "L", "L", "L"},
            {"D", "D", "D", "L", "E"}
        };
        g2 = new String[][]{
            {"O","O","L","L","O"},
            {"L","E","L","L","L"},
            {"L","O","L","L","L"},
            {"L","L","L","L","O"},
            {"D","D","D","O","O"}
        };
        g3 = new String[][]{
            {"O","O","L","L","O"},
            {"L","L","L","L","L"},
            {"L","O","L","L","L"},
            {"L","L","L","L","O"},
            {"O","O","E","O","O"},
            {"D","D","D","L","E"}
        };
       
    }
    
    private String[][] escogerNivelParqueo(String nivel){
    switch (nivel.toUpperCase()) {
        case "G1": return g1;
        case "G2": return g2;
        case "G3": return g3;

        default:
            JOptionPane.showMessageDialog(null, "Nivel no válido");
            return null;
    }
}
    //Lógica para validar que el espacio ingresado sea correcto
    private boolean validarPosicion(String[][] matriz, int fila, int columna) {
    return fila >= 0 && fila < matriz.length && columna >= 0 && columna < matriz[0].length;
}
    
    
    //Con esto se reserva un campo 
    public void asignarEspacioParqueo(String nivel, int fila, int columna) {
        String[][] matriz = escogerNivelParqueo(nivel);
        if (matriz != null && validarPosicion(matriz, fila, columna)) {
            
            if (matriz[fila][columna].equals("L")) {
            matriz[fila][columna] = "O";
            JOptionPane.showMessageDialog(null, "Se ha reservado el espacio con exito");
            
            } else {
            JOptionPane.showMessageDialog(null, "El espacio seleccionado ya esta ocupado");

            }
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Posición inválida");
        }

        

    }
    
    //Con este se libera un campo ocupado
    public void liberarEspacioParqueo(String nivel, int fila, int columna){
        String[][] matriz = escogerNivelParqueo(nivel);
        if (matriz != null && validarPosicion(matriz, fila, columna)) {
            
        }
        if(matriz[fila][columna].equals("O")){
            matriz[fila][columna] = "L";
            JOptionPane.showMessageDialog(null, "El espacio fue libreado");
        }
    }
    
    
    

    
}
    


    



