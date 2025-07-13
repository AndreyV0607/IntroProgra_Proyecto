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
public class Cabina {
    //atributos 
    private final String[] horarios = {"9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"};
    private final int[][] reservas; // [cabina][horario] = ID de socio (0 = libre)
    private final String[] nombresCabinas = {"Cabina 1", "Cabina 2", "Cabina 3", "Cabina 4", "Cabina 5"};

    //constructor vacío
    public Cabina() {
        reservas = new int[5][9];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                reservas[i][j] = 0; 
            }
        }
    }

    //método para menú
    public void menuCabinas() {
        boolean salir = false;
        while (!salir) {
            String opcion = JOptionPane.showInputDialog(
                "MENÚ CABINAS\n" +
                "1. Ver disponibilidad\n" +
                "2. Reservar cabina\n" +
                "3. Cancelar reserva\n" +
                "4. Salir");
            
            if (opcion == null) break;
            
            switch (opcion) {
                case "1":
                    mostrarDisponibilidad();
                    break;
                case "2":
                    reservarCabina();
                    break;
                case "3":
                    cancelarReserva();
                    break;
                case "4":
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }

    //métodos
    private void mostrarDisponibilidad() {
        StringBuilder mensaje = new StringBuilder("HORARIOS (9:00 - 17:00)\nCabina\\Hora\t");
        for (String hora : horarios) mensaje.append(hora).append("\t");
        mensaje.append("\n");
        
        for (int i = 0; i < 5; i++) {
            mensaje.append(nombresCabinas[i]).append("\t");
            for (int j = 0; j < 9; j++) {
                mensaje.append(reservas[i][j] == 0 ? "L" : "O").append("\t");
            }
            mensaje.append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    private void reservarCabina() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su ID de socio:"));

        int cabina = Integer.parseInt(JOptionPane.showInputDialog(
            "Seleccione cabina:\n1. Cabina 1\n2. Cabina 2\n3. Cabina 3\n4. Cabina 4\n5. Cabina 5")) - 1;
        
        int horario = Integer.parseInt(JOptionPane.showInputDialog(
            "Seleccione horario (1-9):\n1. 9:00\n2. 10:00\n...")) - 1;
        
        if (reservas[cabina][horario] == 0) {
            reservas[cabina][horario] = id;
            JOptionPane.showMessageDialog(null, "Reserva exitosa para " + horarios[horario]);
        } else {
            JOptionPane.showMessageDialog(null, "Horario ocupado");
        }
    }

    private void cancelarReserva() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su ID de socio:"));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (reservas[i][j] == id) {
                    reservas[i][j] = 0;
                    JOptionPane.showMessageDialog(null, "Reserva cancelada");
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontraron reservas para este ID");
    }
}
