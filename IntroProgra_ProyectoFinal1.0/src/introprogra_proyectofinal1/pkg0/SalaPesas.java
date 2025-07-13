/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package introprogra_proyectofinal1.pkg0;

import javax.swing.*;

public class SalaPesas {
    private final String[] horarios = {"6:00 AM", "9:00 AM", "12:00 PM", "3:00 PM", "6:00 PM", "9:00 PM"};
    private final int[][] idsPorHorario = new int[6][50];
    private final int[] contadorPorHorario = new int[6];

    public void iniciarSalaPesas() {
        boolean salir = false;

        while (!salir) {
            String opcion = JOptionPane.showInputDialog(
                "Sala de Pesas - Menú\n" +
                "1. Ingresar a un horario\n" +
                "2. Salir de un horario\n" +
                "3. Ver presentes\n" +
                "4. Salir al menú"
            );

            if (opcion == null) break;

            switch (opcion) {
                case "1":
                    Usuario uIn = seleccionarUsuarioSalaPesas();
                    if (uIn != null && uIn.isActivo()) {
                        ingresarSalaPesas(uIn.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario inválido o inactivo.");
                    }
                    break;

                case "2":
                    Usuario uOut = seleccionarUsuarioSalaPesas();
                    if (uOut != null) {
                        salirSalaPesas(uOut.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                    }
                    break;

                case "3":
                    mostrarPresentesSalaPesas();
                    break;

                case "4":
                    salir = true;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }

    private Usuario seleccionarUsuarioSalaPesas() {
        /*StringBuilder lista = new StringBuilder("Usuarios activos:\n");
        for (Usuario u : Usuario.listaUsuarios) {
            if (u.isActivo()) {
                lista.append(u.getId()).append(" - ").append(u.getNombre()).append("\n");
            }
        }*/
        String ingreso = JOptionPane.showInputDialog("\nIngrese el ID del usuario:");
        if (ingreso == null) return null;

        try {
            int id = Integer.parseInt(ingreso);
            //usa la funcion buscarid dentro de usuario para verificar exista el usuario
            return Usuario.buscarPorId(id);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido.");
            return null;
        }
    }

    public void ingresarSalaPesas(int id) {
        StringBuilder menu = new StringBuilder("Seleccione horario:\n");
        for (int i = 0; i < horarios.length; i++) {
            menu.append(i + 1).append(". ").append(horarios[i])
                 .append(" (").append(contadorPorHorario[i]).append("/50)\n");
        }

        String input = JOptionPane.showInputDialog(menu.toString());
        if (input == null) return;

        int opcion = Integer.parseInt(input) - 1;

        if (opcion < 0 || opcion >= horarios.length) {
            JOptionPane.showMessageDialog(null, "Horario inválido.");
            return;
        }

        if (contadorPorHorario[opcion] >= 50) {
            JOptionPane.showMessageDialog(null, "Ese horario ya está lleno.");
            return;
        }

        for (int i = 0; i < contadorPorHorario[opcion]; i++) {
            if (idsPorHorario[opcion][i] == id) {
                JOptionPane.showMessageDialog(null, "Ya estás inscrito en ese horario.");
                return;
            }
        }

        idsPorHorario[opcion][contadorPorHorario[opcion]] = id;
        contadorPorHorario[opcion]++;
        JOptionPane.showMessageDialog(null, "Reserva exitosa para las " + horarios[opcion]);
    }

    public void salirSalaPesas(int id) {
        boolean encontrado = false;
        for (int h = 0; h < horarios.length; h++) {
            for (int i = 0; i < contadorPorHorario[h]; i++) {
                if (idsPorHorario[h][i] == id) {
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
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "El ID " + id + " no está registrado en ningún horario.");
        }
    }

    public void mostrarPresentesSalaPesas() {
        StringBuilder mensaje = new StringBuilder("Usuarios por horario:\n");
        for (int h = 0; h < horarios.length; h++) {
            mensaje.append(horarios[h]).append(" (").append(contadorPorHorario[h]).append("):\n");
            for (int i = 0; i < contadorPorHorario[h]; i++) {
                int id = idsPorHorario[h][i];
                Usuario u = Usuario.buscarPorId(id);
                mensaje.append("  - ").append(id);
                if (u != null) mensaje.append(" - ").append(u.getNombre());
                mensaje.append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}
