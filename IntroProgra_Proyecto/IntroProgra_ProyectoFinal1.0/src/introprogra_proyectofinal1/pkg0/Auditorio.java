/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package introprogra_proyectofinal1.pkg0;

import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Auditorio {
    
// Temas de charlas (pueden variar cada día si lo desea)
    static String[] temas = {"Salud", "Rutinas Especiales", "Capacitaciones"};

    // Horarios fijos
    static String[] horarios = {"10:00 AM", "3:00 PM"};

    // Matriz para inscripciones: [horario][posición en la lista de 30]
    static String[][] inscripciones = new String[2][30];

    // Método principal
    public static void main(String[] args) {
        gestionarAuditorio(); // Inicia el menú del auditorio
    }

    public static void gestionarAuditorio() {
        boolean salir = false;

        while (!salir) {
            String opcion = JOptionPane.showInputDialog("""
                    Auditorio Fitness - Selecciona una opción:
                    1. Ver charlas disponibles
                    2. Inscribirse a una charla
                    3. Modificar charla
                    4. Salir
                    """);

            if (opcion == null) break;

            switch (opcion) {
                case "1" -> mostrarCharlas();
                case "2" -> inscribirParticipante();
                case "3" -> modificarNombreCharla(); 
                case "4" -> salir = true;
                default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }

    
    // Despliegue de informacion de los horarios
    private static void mostrarCharlas() {
        String mensaje = "Charlas disponibles en el Auditorio Fitness:\n";
        for (int i = 0; i < horarios.length; i++) {
            int cuposRestantes = contarCupos(i);
            mensaje += (i + 1) + ". " + temas[i % temas.length] + " - " + horarios[i] + " (" + cuposRestantes + " cupos disponibles)\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    // inscripcion de la charla
    private static void inscribirParticipante() {
        String idParticipante = JOptionPane.showInputDialog("Ingrese su ID de participante:");

        String opciones = "Seleccione la charla:\n";
        for (int i = 0; i < horarios.length; i++) {
            int cuposRestantes = contarCupos(i);
            opciones += (i + 1) + ". " + temas[i % temas.length] + " - " + horarios[i] + " (" + cuposRestantes + " cupos disponibles)\n";
        }

        try {
            int seleccion = Integer.parseInt(JOptionPane.showInputDialog(opciones)) - 1;
            if (seleccion >= 0 && seleccion < horarios.length) {
                if (contarCupos(seleccion) == 0) {
                    JOptionPane.showMessageDialog(null, "Cupo lleno para esta charla.");
                    return;
                }

                // Validar si ya está inscrito
                for (int i = 0; i < 30; i++) {
                    if (idParticipante.equals(inscripciones[seleccion][i])) {
                        JOptionPane.showMessageDialog(null, "Ya estás inscrito en esta charla.");
                        return;
                    }
                }

                // Registrar participante
                for (int i = 0; i < 30; i++) {
                    if (inscripciones[seleccion][i] == null) {
                        inscripciones[seleccion][i] = idParticipante;
                        JOptionPane.showMessageDialog(null, "Inscripción exitosa en la charla de " + temas[seleccion % temas.length] + " a las " + horarios[seleccion]);
                        return;
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Selección no válida.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada no válida.");
        }
    }
    
    //Modifica la charla que se va a recibir
    private static void modificarNombreCharla() {
        String mensaje = "Seleccione la charla que desea modificar:\n";
        for (int i = 0; i < horarios.length; i++) {
            mensaje += (i + 1) + ". " + temas[i % temas.length] + " - " + horarios[i] + "\n";
        }

        try {
            int seleccion = Integer.parseInt(JOptionPane.showInputDialog(mensaje)) - 1;

            if (seleccion >= 0 && seleccion < horarios.length) {
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre para la charla:");
                if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                    temas[seleccion % temas.length] = nuevoNombre.trim();
                    JOptionPane.showMessageDialog(null, "Nombre de la charla actualizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Nombre no válido. No se realizaron cambios.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selección fuera de rango.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida.");
        }
    }

    private static int contarCupos(int horarioIndex) {
        int inscritos = 0;
        for (String id : inscripciones[horarioIndex]) {
            if (id != null) inscritos++;
        }
        return 30 - inscritos;
    }
}


