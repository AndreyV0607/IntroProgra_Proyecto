/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package introprogra_proyectofinal1.pkg0;

import javax.swing.JOptionPane;

public class SalaPesas {
    
    //atributos
    private final String[] horarios = {"6:00 AM", "9:00 AM", "12:00 PM", "3:00 PM", "6:00 PM", "9:00 PM"};
    private final int[][] idsPorHorario = new int[6][50];  // hasta 50 personas por horario
    private final int[] contadorPorHorario = new int[6];   // lleva el conteo por horario

    public void ingresarSalaPesas(int id) {
        String menu = "Seleccione horario:\n";
        for (int i = 0; i < horarios.length; i++) {
            menu += (i + 1) + ". " + horarios[i] + " (ocupados: " + contadorPorHorario[i] + "/50)\n (Utilice del 1 al 6 para elegir su horario)\n";
        }

        String input = JOptionPane.showInputDialog(menu);
        if (input == null) return; // Cancelado

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
                mensaje.append("  - ID: ").append(idsPorHorario[h][i]).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}
