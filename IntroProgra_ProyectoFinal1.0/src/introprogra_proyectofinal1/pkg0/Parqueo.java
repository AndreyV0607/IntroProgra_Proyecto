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
    
        // Matrices que representan los 3 niveles del parqueo (G1, G2 y G3)
    // Cada celda guarda: "L" (libre), un ID como string si está ocupado, o "E"/"D" si es espacio especial
    private String[][] g1 = new String[4][5];
    private String[][] g2 = new String[5][5];
    private String[][] g3 = new String[6][5];

    // Constructor: al crear un objeto Parqueo, se inicializan los espacios
    public Parqueo() {
        inicializarParqueo();
    }

    // Llena las matrices con el estado inicial (algunos espacios ocupados, libres y especiales)
    private void inicializarParqueo() {
        g1 = new String[][]{
            {"E", "O", "L", "L", "O"},
            {"L", "L", "L", "L", "L"},
            {"L", "O", "L", "L", "L"},
            {"D", "D", "D", "L", "E"}
        };
        g2 = new String[][]{
            {"O", "O", "L", "L", "O"},
            {"L", "L", "L", "L", "L"},
            {"L", "O", "L", "L", "L"},
            {"L", "L", "L", "L", "O"},
            {"D", "D", "D", "O", "O"}
        };
        g3 = new String[][]{
            {"O", "O", "L", "L", "O"},
            {"L", "L", "L", "L", "L"},
            {"L", "O", "L", "L", "L"},
            {"L", "L", "L", "L", "O"},
            {"O", "O", "E", "O", "O"},
            {"D", "D", "D", "L", "E"}
        };
    }

    // Menú principal para el usuario
    public void iniciarParqueo() {
        boolean salir = false;

        while (!salir) {
            // Opciones del menú principal
            String opcion = JOptionPane.showInputDialog("""
                PARQUEO - Seleccione una opción:
                1. Ver parqueo
                2. Reservar espacio
                3. Liberar espacio
                4. Salir
            """);

            if (opcion == null) {
                break;
            }

            switch (opcion) {
                case "1":
                    mostrarParqueo(); // Mostrar el estado de todos los niveles
                    break;

                case "2":
                    Usuario uIn = seleccionarUsuarioParqueo(); // Pide el ID del usuario
                    if (uIn != null && uIn.isActivo()) {
                        asignarEspacioParqueo(uIn.getId()); // Asigna un espacio al ID
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario inválido o inactivo.");
                    }
                    break;

                case "3":
                    Usuario uOut = seleccionarUsuarioParqueo(); // Pide el ID para liberar
                    if (uOut != null && uOut.isActivo()) {
                        liberarEspacioParqueo(uOut.getId()); // Libera un espacio si ese ID lo reservó
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario inválido o inactivo.");
                    }
                    break;

                case "4":
                    salir = true; // Cierra el menú
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }

    // Muestra lista de usuarios activos y permite seleccionar uno
    private Usuario seleccionarUsuarioParqueo() {
        

        String input = JOptionPane.showInputDialog("\nIngrese su ID:");
        if (input == null) {
            return null;
        }

        try {
            int id = Integer.parseInt(input);
            return Usuario.buscarPorId(id); // Busca el usuario en la lista global
        } catch (NumberFormatException e) { // Obtiene los ids que no fueron registrados(Investigado por cuenta propia)
            //Cuando obtiene un valor que va a dar error, evita que se cierre el programa, manejando los errores ingresados por el usuario
            JOptionPane.showMessageDialog(null, "ID inválido.");
            return null;
        }
    }

    // Asigna un espacio si está libre
    private void asignarEspacioParqueo(int id) {
        String nivel = JOptionPane.showInputDialog("Ingrese nivel (G1, G2, G3):");
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila:"));
        int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna:"));

        String[][] matriz = escogerNivelParqueo(nivel);
        if (matriz != null && validarPosicion(matriz, fila, columna)) {
            if (matriz[fila][columna].equals("L")) {
                matriz[fila][columna] = String.valueOf(id); // Guarda el ID como ocupante
                JOptionPane.showMessageDialog(null, "Espacio reservado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Ese espacio ya está ocupado por ID: " + matriz[fila][columna]);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Posición o nivel inválido.");
        }
    }

    // Libera un espacio si el ID coincide con el que lo reservó
    private void liberarEspacioParqueo(int id) {
        String nivel = JOptionPane.showInputDialog("Ingrese nivel (G1, G2, G3):");
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila:"));
        int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna:"));

        String[][] matriz = escogerNivelParqueo(nivel);
        if (matriz != null && validarPosicion(matriz, fila, columna)) {
            if (matriz[fila][columna].equals(String.valueOf(id))) {
                matriz[fila][columna] = "L"; // Lo deja libre otra vez
                JOptionPane.showMessageDialog(null, "Espacio liberado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Este espacio no está reservado por usted.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Posición o nivel inválido.");
        }
    }

    // Retorna la matriz correspondiente al nivel ingresado
    private String[][] escogerNivelParqueo(String nivel) {
        switch (nivel.toUpperCase()) {
            case "G1":
                return g1;
            case "G2":
                return g2;
            case "G3":
                return g3;
            default:
                return null;
        }
    }

    // Verifica si la fila y columna están dentro de los límites de la matriz
    private boolean validarPosicion(String[][] matriz, int fila, int columna) {
        return fila >= 0 && fila < matriz.length && columna >= 0 && columna < matriz[0].length;
    }

    // Muestra los 3 niveles del parqueo en formato visual
    private void mostrarParqueo() {
        StringBuilder sb = new StringBuilder("Estado actual del parqueo:\n");

        sb.append("\nG1:\n").append(matrizToString(g1));
        sb.append("\nG2:\n").append(matrizToString(g2));
        sb.append("\nG3:\n").append(matrizToString(g3));

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    // Convierte una matriz en string visual con tabulación
    private String matrizToString(String[][] matriz) {
        StringBuilder sb = new StringBuilder();
        for (String[] fila : matriz) {
            for (String espacio : fila) {
                sb.append((espacio == null ? "L" : espacio)).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
