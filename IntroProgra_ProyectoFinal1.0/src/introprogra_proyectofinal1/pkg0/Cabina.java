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
            
            
            //detecta si el usuario canceló el cuadro de diálogo y termina el ciclo while para salir del menú.
            if (opcion == null) break;

            //opciones del menú
            switch (opcion) {
                case "1":
                    mostrarDisponibilidad();
                    break;
                    
                    //verifica que el id sea real y este activo para inscribir
                case "2":
                    Usuario uInC = seleccionarUsuarioCabina();
                    if (uInC != null && uInC.isActivo()) {
                        reservarCabina(uInC.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario inválido o inactivo.");
                    }
                    break;
                    
                case "3":
                    Usuario uOtC = seleccionarUsuarioCabina();
                    if (uOtC != null && uOtC.isActivo()) {
                        cancelarReserva(uOtC.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario inválido o inactivo.");
                    }
                    
                    break;
                case "4":
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }
    
    private Usuario seleccionarUsuarioCabina() {
        
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

    //con un arreglo junta toda la info de los arreglos y y la junta al mensaje que se imprime
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

    // Da opciones para elegir cual cabina y su horario 
    private void reservarCabina(int id) {
        int ids = id;

        int cabina = Integer.parseInt(JOptionPane.showInputDialog(
            "Seleccione cabina:\n1. Cabina 1\n2. Cabina 2\n3. Cabina 3\n4. Cabina 4\n5. Cabina 5")) - 1;
        
        int horario = Integer.parseInt(JOptionPane.showInputDialog(
            "Seleccione horario (1-9):\n1. 9:00\n2. 10:00\n...")) - 1;
        
        if (reservas[cabina][horario] == 0) {
            reservas[cabina][horario] = ids;
            JOptionPane.showMessageDialog(null, "Reserva exitosa para " + horarios[horario]);
        } else {
            JOptionPane.showMessageDialog(null, "Horario ocupado");
        }
    }

    // para cancelar la clase con el id verifica por todas las posiciones donde esta ese id para removerlo
    private void cancelarReserva(int id) {
        int ids = id;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (reservas[i][j] == ids) {
                    reservas[i][j] = 0;
                    JOptionPane.showMessageDialog(null, "Reserva cancelada");
                    return;
                }
            }
        }
        //al id no ser encontrado imprime este mensaje
        JOptionPane.showMessageDialog(null, "No se encontraron reservas para este ID");
    }
   
public void abrirInterfaz() {
    // Crear ventana principal
    JFrame frame = new JFrame("Gestión de Cabinas");
    frame.setSize(400, 300);
    frame.setLayout(new GridLayout(4, 1, 10, 10));

    // Botones
    JButton btnVer = new JButton("Ver Disponibilidad");
    JButton btnReservar = new JButton("Reservar Cabina");
    JButton btnCancelar = new JButton("Cancelar Reserva");
    JButton btnCerrar = new JButton("Cerrar");

    // Agregar botones a la ventana
    frame.add(btnVer);
    frame.add(btnReservar);
    frame.add(btnCancelar);
    frame.add(btnCerrar);

    // === Eventos de los botones ===
    btnVer.addActionListener(e -> mostrarDisponibilidad());

    btnReservar.addActionListener(e -> {
        Usuario uIn = seleccionarUsuarioCabina();
        if (uIn != null && uIn.isActivo()) {
            reservarCabina(uIn.getId());
        } else {
            JOptionPane.showMessageDialog(frame, "Usuario inválido o inactivo.");
        }
    });

    btnCancelar.addActionListener(e -> {
        Usuario uOut = seleccionarUsuarioCabina();
        if (uOut != null && uOut.isActivo()) {
            cancelarReserva(uOut.getId());
        } else {
            JOptionPane.showMessageDialog(frame, "Usuario inválido o inactivo.");
        }
    });

    btnCerrar.addActionListener(e -> frame.dispose());

    // Configuración de ventana
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}


    
}
