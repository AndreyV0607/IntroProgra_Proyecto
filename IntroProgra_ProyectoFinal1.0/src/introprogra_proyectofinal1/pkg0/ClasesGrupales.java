/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package introprogra_proyectofinal1.pkg0;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author andreyvargassolis
 */
public class ClasesGrupales {

    public static void menuClasesGrupales() {
        // Nombres de las 6 clases disponibles
        String[] clases = {"Yoga", "Crossfit", "Funcional", "Pilates", "Zumba", "Spinning"};

        // Cupos disponibles por clase (máximo 50 inicialmente)
        int[] cuposDisponibles = {50, 50, 50, 50, 50, 50};

        // Matriz para registrar los ID de socios inscritos en cada clase
        // inscripciones[clase][posicion]
        String[][] inscripciones = new String[6][50];

        // Horarios actuales asignados a cada clase (cada clase tiene un horario distinto)
        String[] horarios = {"8:00 AM", "10:00 AM", "12:00 PM", "2:00 PM", "4:00 PM", "6:00 PM"};

        // Lista de horarios disponibles para seleccionar cuando se modifica una clase
        String[] horariosDisponibles = {"8:00 AM", "10:00 AM", "12:00 PM", "2:00 PM", "4:00 PM", "6:00 PM"};

        boolean salir = false; // Controla si el usuario quiere cerrar el programa

        while (!salir) {
            // Menú principal mostrado con JOptionPane
            String opcion = JOptionPane.showInputDialog(
                    "Gimnasio - Selecciona una opción:\n"
                    + "1. Ver clases y cupos\n"
                    + "2. Reservar clase\n"
                    + "3. Salir\n"
                    + "4. Modificar clase");

            if (opcion == null) {
                break; // Si el usuario cierra la ventana, se sale del programa
            }
            switch (opcion) {
                case "1": // Mostrar clases y cupos disponibles
                    String mensaje = "Cupos disponibles:\n";
                    for (int i = 0; i < clases.length; i++) {
                        mensaje += (i + 1) + ". " + clases[i] + " - " + horarios[i] + ": " + cuposDisponibles[i] + " cupos\n";
                    }
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;

                case "2": // Reservar un cupo en una clase
                    String idSocio = JOptionPane.showInputDialog("Ingrese su ID de socio:");

                    // Mostrar menú con las clases disponibles y sus cupos
                    String claseTexto = "Seleccione clase:\n";
                    for (int i = 0; i < clases.length; i++) {
                        claseTexto += (i + 1) + ". " + clases[i] + " (" + horarios[i] + ") - " + cuposDisponibles[i] + " cupos\n";
                    }

                    int claseSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(claseTexto)) - 1;

                    if (claseSeleccionada >= 0 && claseSeleccionada < clases.length) {
                        if (cuposDisponibles[claseSeleccionada] == 0) {
                            // Si ya no hay cupos, se informa al usuario
                            JOptionPane.showMessageDialog(null, "Lo sentimos, no hay cupos en esa clase.");
                        } else {
                            // Verificar si el socio ya está registrado en esa clase
                            boolean yaRegistrado = false;
                            for (int j = 0; j < 50; j++) {
                                if (idSocio.equals(inscripciones[claseSeleccionada][j])) {
                                    yaRegistrado = true;
                                    break;
                                }
                            }

                            if (yaRegistrado) {
                                // El socio ya está inscrito en esta clase
                                JOptionPane.showMessageDialog(null, "Ya estás registrado en esta clase.");
                            } else {
                                // Buscar un espacio libre en esa clase para registrar al socio
                                for (int j = 0; j < 50; j++) {
                                    if (inscripciones[claseSeleccionada][j] == null) {
                                        inscripciones[claseSeleccionada][j] = idSocio; // Guardar el ID
                                        cuposDisponibles[claseSeleccionada]--; // Reducir cupos disponibles
                                        JOptionPane.showMessageDialog(null, "Reserva exitosa en " + clases[claseSeleccionada]);
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        // Si el número ingresado no es válido
                        JOptionPane.showMessageDialog(null, "Clase no válida.");
                    }

                    break;

                case "3": // Salir del programa
                    salir = true;
                    break;

                case "4": // Modificar nombre, horario o cupos de una clase
                    // Mostrar lista de clases para elegir cuál modificar
                    String menuModificar = "Seleccione la clase que desea modificar:\n";
                    for (int i = 0; i < clases.length; i++) {
                        menuModificar += (i + 1) + ". " + clases[i] + " (" + horarios[i] + ") - " + cuposDisponibles[i] + " cupos\n";
                    }

                    int indiceModificar = Integer.parseInt(JOptionPane.showInputDialog(menuModificar)) - 1;

                    if (indiceModificar >= 0 && indiceModificar < clases.length) {
                        // Cambiar el nombre de la clase
                        String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre para la clase (actual: " + clases[indiceModificar] + "):");
                        if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                            clases[indiceModificar] = nuevoNombre;
                        }

                        // Cambiar el horario, mostrando las opciones posibles
                        String opcionesHorarios = "Seleccione nuevo horario:\n";
                        for (int i = 0; i < horariosDisponibles.length; i++) {
                            opcionesHorarios += (i + 1) + ". " + horariosDisponibles[i] + "\n";
                        }

                        int horarioSeleccionado = Integer.parseInt(JOptionPane.showInputDialog(opcionesHorarios)) - 1;
                        if (horarioSeleccionado >= 0 && horarioSeleccionado < horariosDisponibles.length) {
                            horarios[indiceModificar] = horariosDisponibles[horarioSeleccionado];
                        } else {
                            JOptionPane.showMessageDialog(null, "Horario no válido. Se mantiene el actual.");
                        }

                        // Ver cuántos socios ya están inscritos en esa clase
                        int reservados = 0;
                        for (int j = 0; j < 50; j++) {
                            if (inscripciones[indiceModificar][j] != null) {
                                reservados++;
                            }
                        }

                        // Cambiar el número máximo de cupos disponibles (mínimo: la cantidad ya ocupada)
                        String nuevoCupoStr = JOptionPane.showInputDialog(
                                "Cupos máximos (actuales: " + (reservados + cuposDisponibles[indiceModificar])
                                + "). Debe ser mayor o igual a reservados (" + reservados + "):");

                        if (nuevoCupoStr != null) {
                            int nuevoCupo = Integer.parseInt(nuevoCupoStr);
                            if (nuevoCupo >= reservados && nuevoCupo <= 50) {
                                // Actualiza los cupos disponibles sin afectar los ya ocupados
                                cuposDisponibles[indiceModificar] = nuevoCupo - reservados;
                                JOptionPane.showMessageDialog(null, "Clase modificada correctamente.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Valor inválido. Debe ser entre " + reservados + " y 50.");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Selección inválida.");
                    }

                    break;

                default:
                    // Si la opción no es 1, 2, 3 o 4
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }


public void abrirInterfaz() {
    // === VARIABLES LOCALES ===
    String[] clases = {"Yoga", "Crossfit", "Funcional", "Pilates", "Zumba", "Spinning"};
    int[] cuposDisponibles = {50, 50, 50, 50, 50, 50};
    String[][] inscripciones = new String[6][50];
    String[] horarios = {"8:00 AM", "10:00 AM", "12:00 PM", "2:00 PM", "4:00 PM", "6:00 PM"};
    String[] horariosDisponibles = {"8:00 AM", "10:00 AM", "12:00 PM", "2:00 PM", "4:00 PM", "6:00 PM"};

    // === CREAR VENTANA ===
    JFrame frame = new JFrame("Gestión de Clases Grupales");
    frame.setSize(400, 300);
    frame.setLayout(new GridLayout(4, 1, 10, 10));

    // Botones
    JButton btnVer = new JButton("Ver Clases y Cupos");
    JButton btnReservar = new JButton("Reservar Clase");
    JButton btnModificar = new JButton("Modificar Clase");
    JButton btnCerrar = new JButton("Cerrar");

    frame.add(btnVer);
    frame.add(btnReservar);
    frame.add(btnModificar);
    frame.add(btnCerrar);

    // === Eventos ===

    // Ver clases
    btnVer.addActionListener(e -> {
        StringBuilder mensaje = new StringBuilder("Cupos disponibles:\n");
        for (int i = 0; i < clases.length; i++) {
            mensaje.append((i + 1)).append(". ").append(clases[i])
                   .append(" - ").append(horarios[i])
                   .append(": ").append(cuposDisponibles[i]).append(" cupos\n");
        }
        JOptionPane.showMessageDialog(frame, mensaje.toString());
    });

    // Reservar clase
    btnReservar.addActionListener(e -> {
        String idSocio = JOptionPane.showInputDialog("Ingrese su ID de socio:");
        if (idSocio == null) return;

        // Mostrar menú de clases
        StringBuilder claseTexto = new StringBuilder("Seleccione clase:\n");
        for (int i = 0; i < clases.length; i++) {
            claseTexto.append((i + 1)).append(". ").append(clases[i])
                      .append(" (").append(horarios[i])
                      .append(") - ").append(cuposDisponibles[i]).append(" cupos\n");
        }

        try {
            int claseSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(claseTexto.toString())) - 1;

            if (claseSeleccionada >= 0 && claseSeleccionada < clases.length) {
                if (cuposDisponibles[claseSeleccionada] == 0) {
                    JOptionPane.showMessageDialog(frame, "Lo sentimos, no hay cupos en esa clase.");
                } else {
                    boolean yaRegistrado = false;
                    for (int j = 0; j < 50; j++) {
                        if (idSocio.equals(inscripciones[claseSeleccionada][j])) {
                            yaRegistrado = true;
                            break;
                        }
                    }
                    if (yaRegistrado) {
                        JOptionPane.showMessageDialog(frame, "Ya estás registrado en esta clase.");
                    } else {
                        for (int j = 0; j < 50; j++) {
                            if (inscripciones[claseSeleccionada][j] == null) {
                                inscripciones[claseSeleccionada][j] = idSocio;
                                cuposDisponibles[claseSeleccionada]--;
                                JOptionPane.showMessageDialog(frame, "Reserva exitosa en " + clases[claseSeleccionada]);
                                break;
                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Clase no válida.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Entrada inválida.");
        }
    });

    // Modificar clase
    btnModificar.addActionListener(e -> {
        StringBuilder menuModificar = new StringBuilder("Seleccione la clase que desea modificar:\n");
        for (int i = 0; i < clases.length; i++) {
            menuModificar.append((i + 1)).append(". ").append(clases[i])
                         .append(" (").append(horarios[i])
                         .append(") - ").append(cuposDisponibles[i]).append(" cupos\n");
        }
        try {
            int indiceModificar = Integer.parseInt(JOptionPane.showInputDialog(menuModificar.toString())) - 1;

            if (indiceModificar >= 0 && indiceModificar < clases.length) {
                String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre para la clase (actual: " + clases[indiceModificar] + "):");
                if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                    clases[indiceModificar] = nuevoNombre;
                }

                StringBuilder opcionesHorarios = new StringBuilder("Seleccione nuevo horario:\n");
                for (int i = 0; i < horariosDisponibles.length; i++) {
                    opcionesHorarios.append((i + 1)).append(". ").append(horariosDisponibles[i]).append("\n");
                }

                int horarioSeleccionado = Integer.parseInt(JOptionPane.showInputDialog(opcionesHorarios.toString())) - 1;
                if (horarioSeleccionado >= 0 && horarioSeleccionado < horariosDisponibles.length) {
                    horarios[indiceModificar] = horariosDisponibles[horarioSeleccionado];
                } else {
                    JOptionPane.showMessageDialog(frame, "Horario no válido. Se mantiene el actual.");
                }

                int reservados = 0;
                for (int j = 0; j < 50; j++) {
                    if (inscripciones[indiceModificar][j] != null) reservados++;
                }

                String nuevoCupoStr = JOptionPane.showInputDialog("Cupos máximos (actuales: " + (reservados + cuposDisponibles[indiceModificar]) + "). Debe ser mayor o igual a reservados (" + reservados + "):");
                if (nuevoCupoStr != null) {
                    int nuevoCupo = Integer.parseInt(nuevoCupoStr);
                    if (nuevoCupo >= reservados && nuevoCupo <= 50) {
                        cuposDisponibles[indiceModificar] = nuevoCupo - reservados;
                        JOptionPane.showMessageDialog(frame, "Clase modificada correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Valor inválido. Debe ser entre " + reservados + " y 50.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Selección inválida.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Entrada inválida.");
        }
    });

    // Cerrar
    btnCerrar.addActionListener(e -> frame.dispose());

    // Configuración de ventana
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}

    
}


