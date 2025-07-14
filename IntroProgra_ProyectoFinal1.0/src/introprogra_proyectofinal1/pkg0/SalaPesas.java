/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package introprogra_proyectofinal1.pkg0;

import javax.swing.*;

public class SalaPesas {

    // Horarios disponibles para reservar en la sala de pesas (cada 3 horas de 6 AM a 9 PM)
    private final String[] horarios = {"6:00 AM", "9:00 AM", "12:00 PM", "3:00 PM", "6:00 PM", "9:00 PM"};

    // Arreglo que almacena los ID de los usuarios registrados por horario
    private final int[][] idsPorHorario = new int[6][50]; // hasta 50 personas por cada horario

    // Contador de cuántos usuarios están registrados en cada horario
    private final int[] contadorPorHorario = new int[6];

    // Método principal para mostrar el menú y controlar la lógica del módulo Sala de Pesas
    public void iniciarSalaPesas() {
        boolean salir = false;

        while (!salir) {
            // Menú principal con opciones
            String opcion = JOptionPane.showInputDialog(
                "Sala de Pesas - Menú\n" +
                "1. Ingresar a un horario\n" +
                "2. Salir de un horario\n" +
                "3. Ver presentes\n" +
                "4. Salir del sistema"
            );

            if (opcion == null) break;

            switch (opcion) {
                case "1":
                    // Selección e ingreso a un horario
                    Usuario uIn = seleccionarUsuarioSalaPesas();
                    if (uIn != null && uIn.isActivo()) {
                        ingresarSalaPesas(uIn.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario inválido o inactivo.");
                    }
                    break;

                case "2":
                    // Salida del usuario de su horario
                    Usuario uOut = seleccionarUsuarioSalaPesas();
                    if (uOut != null) {
                        salirSalaPesas(uOut.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                    }
                    break;

                case "3":
                    // Mostrar todos los usuarios presentes por horario
                    mostrarPresentesSalaPesas();
                    break;

                case "4":
                    // Salir del menú
                    salir = true;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }

    // Permite seleccionar un usuario activo de la lista de usuarios
    private Usuario seleccionarUsuarioSalaPesas() {
        
        String input = JOptionPane.showInputDialog( "\nIngrese el ID del usuario:");
        if (input == null) return null;

        try {
            int id = Integer.parseInt(input);
            return Usuario.buscarPorId(id); // Devuelve el objeto Usuario si existe
        } catch (NumberFormatException e) { // Obtiene los ids que no fueron registrados(Investigado por cuenta propia)
            //Cuando obtiene un valor que va a dar error, evita que se cierre el programa, manejando los errores ingresados por el usuario
            JOptionPane.showMessageDialog(null, "ID inválido.");
            return null;
        }
    }

    // Registra un usuario en un horario disponible de la sala de pesas
    public void ingresarSalaPesas(int id) {
        // Mostrar los horarios y cuántos cupos están ocupados
        StringBuilder menu = new StringBuilder("Seleccione horario:\n");
        for (int i = 0; i < horarios.length; i++) {
            menu.append(i + 1).append(". ").append(horarios[i])
                 .append(" (").append(contadorPorHorario[i]).append("/50)\n");
        }

        String input = JOptionPane.showInputDialog(menu.toString());
        if (input == null) return;

        int opcion = Integer.parseInt(input) - 1;

        // Validación de selección de horario
        if (opcion < 0 || opcion >= horarios.length) {
            JOptionPane.showMessageDialog(null, "Horario inválido.");
            return;
        }

        // Validar si el horario ya está lleno
        if (contadorPorHorario[opcion] >= 50) {
            JOptionPane.showMessageDialog(null, "Ese horario ya está lleno.");
            return;
        }

        // Validar si el usuario ya está inscrito en ese horario
        for (int i = 0; i < contadorPorHorario[opcion]; i++) {
            if (idsPorHorario[opcion][i] == id) {
                JOptionPane.showMessageDialog(null, "Ya estás inscrito en ese horario.");
                return;
            }
        }

        // Registrar al usuario en la matriz y aumentar el contador
        idsPorHorario[opcion][contadorPorHorario[opcion]] = id;
        contadorPorHorario[opcion]++;
        JOptionPane.showMessageDialog(null, "Reserva exitosa para las " + horarios[opcion]);
    }

    // Elimina al usuario de cualquier horario en el que esté registrado
    public void salirSalaPesas(int id) {
        boolean encontrado = false;

        // Buscar en cada horario si el ID está registrado
        for (int h = 0; h < horarios.length; h++) {
            for (int i = 0; i < contadorPorHorario[h]; i++) {
                if (idsPorHorario[h][i] == id) {
                    // Eliminar al usuario desplazando el resto hacia la izquierda
                    for (int j = i; j < contadorPorHorario[h] - 1; j++) {
                        idsPorHorario[h][j] = idsPorHorario[h][j + 1];
                    }
                    contadorPorHorario[h]--;
                    JOptionPane.showMessageDialog(null, "Usuario con ID " + id + " ha salido del horario " + horarios[h]);
                    encontrado = true;
                    break;
                }
            }
        }

        // Si el usuario no estaba en ningún horario
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "El ID " + id + " no está registrado en ningún horario.");
        }
    }

    // Muestra todos los usuarios presentes en cada horario de la sala de pesas
    public void mostrarPresentesSalaPesas() {
        StringBuilder mensaje = new StringBuilder("Usuarios por horario:\n");

        for (int h = 0; h < horarios.length; h++) {
            mensaje.append(horarios[h]).append(" (").append(contadorPorHorario[h]).append("):\n");

            for (int i = 0; i < contadorPorHorario[h]; i++) {
                int id = idsPorHorario[h][i];
                Usuario u = Usuario.buscarPorId(id); // Obtener el nombre del usuario si existe
                mensaje.append("  - ").append(id);
                if (u != null) mensaje.append(" - ").append(u.getNombre());
                mensaje.append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}
