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
import javax.swing.JOptionPane;

public class Recreacion {

    // Capacidades máximas por cancha
    private final int max_Futbol = 12;
    private final int max_Basquetbol = 10;
    private final int max_Tenis = 2;

    // Contadores de jugadores por espacio
    private int jugadoresFutbol1;
    private int jugadoresFutbol2;
    private int jugadoresBasquetbol;
    private int jugadoresTenis1;
    private int jugadoresTenis2;

    // Constructor
    public Recreacion() {
        this.jugadoresFutbol1 = 0;
        this.jugadoresFutbol2 = 0;
        this.jugadoresBasquetbol = 0;
        this.jugadoresTenis1 = 0;
        this.jugadoresTenis2 = 0;
    }

    // Método principal con menú para llamar desde main()
    public void iniciarRecreacion() {
        boolean salir = false;

        while (!salir) {
            String opcion = JOptionPane.showInputDialog("""
                Área de Recreación - Menú
                1. Reservar cancha de fútbol
                2. Reservar cancha de baloncesto
                3. Reservar cancha de tenis
                4. Liberar cancha
                5. Ver estado actual
                6. Salir
            """);

            if (opcion == null) break;

            switch (opcion) {
                case "1": 
                    // Selección e ingreso a un horario
                    Usuario uInF = seleccionarUsuarioRecreacion();
                    if (uInF != null && uInF.isActivo()) {
                        reservarFutbol(uInF.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario inválido o inactivo.");
                    }
                    break;
                    
                case "2": 
                    Usuario uInB = seleccionarUsuarioRecreacion();
                    if (uInB != null && uInB.isActivo()) {
                        reservarBaloncesto(uInB.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario inválido o inactivo.");
                    }
                    break;
                    
                    
                case "3": 
                    Usuario uInT = seleccionarUsuarioRecreacion();
                    if (uInT != null && uInT.isActivo()) {
                        reservarTenis(uInT.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario inválido o inactivo.");
                    }
                    break;
                   
                    
                case "4": 
                    Usuario uOut = seleccionarUsuarioRecreacion();
                    if (uOut != null) {
                        liberarCancha(uOut.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                    }
                    break;
                    
                    
                case "5": 
                    mostrarEstadoRecreacion();
                    
                case "6": 
                    salir = true;
                default: 
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }
    private Usuario seleccionarUsuarioRecreacion() {
        
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

    // Reserva fútbol, se escoge cancha 1 o 2
    private void reservarFutbol(int id) {
    Usuario u = seleccionarUsuarioRecreacion();
    if (u == null || !u.isActivo()) {
        JOptionPane.showMessageDialog(null, "Usuario no válido o inactivo.");
        return;
    }

    int cancha = Integer.parseInt(JOptionPane.showInputDialog("Seleccione cancha:\n1. Fútbol 1\n2. Fútbol 2"));
    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos jugadores desea ingresar?"));

    if (cancha == 1) {
        if (jugadoresFutbol1 + cantidad <= max_Futbol) {
            jugadoresFutbol1 += cantidad;
            JOptionPane.showMessageDialog(null, "Reservado por " + u.getNombre() + " en Fútbol 1. Jugadores actuales: " + jugadoresFutbol1);
        } else {
            JOptionPane.showMessageDialog(null, "Cancha llena. Máximo " + max_Futbol + " jugadores.");
        }
    } else if (cancha == 2) {
        if (jugadoresFutbol2 + cantidad <= max_Futbol) {
            jugadoresFutbol2 += cantidad;
            JOptionPane.showMessageDialog(null, "Reservado por " + u.getNombre() + " en Fútbol 2. Jugadores actuales: " + jugadoresFutbol2);
        } else {
            JOptionPane.showMessageDialog(null, "Cancha llena. Máximo " + max_Futbol + " jugadores.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Cancha inválida.");
    }
}


    // Reserva baloncesto
    private void reservarBaloncesto(int id) {
    Usuario u = seleccionarUsuarioRecreacion();
    if (u == null || !u.isActivo()) {
        JOptionPane.showMessageDialog(null, "Usuario no válido o inactivo.");
        return;
    }

    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos jugadores desea ingresar a baloncesto?"));

    if ((jugadoresBasquetbol + cantidad) <= max_Basquetbol) {
        jugadoresBasquetbol += cantidad;
        JOptionPane.showMessageDialog(null, "Reserva exitosa por " + u.getNombre() + ". Jugadores en cancha: " + jugadoresBasquetbol);
    } else {
        JOptionPane.showMessageDialog(null, "No hay suficiente espacio en la cancha de baloncesto.");
    }
}


    // Reserva tenis, se escoge cancha 1 o 2
    private void reservarTenis(int id) {
    Usuario u = seleccionarUsuarioRecreacion();
    if (u == null || !u.isActivo()) {
        JOptionPane.showMessageDialog(null, "Usuario no válido o inactivo.");
        return;
    }

    int cancha = Integer.parseInt(JOptionPane.showInputDialog("Seleccione cancha:\n1. Tenis 1\n2. Tenis 2"));
    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos jugadores desea ingresar?"));

    if (cancha == 1) {
        if (jugadoresTenis1 + cantidad <= max_Tenis) {
            jugadoresTenis1 += cantidad;
            JOptionPane.showMessageDialog(null, "Reservado por " + u.getNombre() + " en Tenis 1. Jugadores actuales: " + jugadoresTenis1);
        } else {
            JOptionPane.showMessageDialog(null, "Cancha llena. Máximo " + max_Tenis + " jugadores.");
        }
    } else if (cancha == 2) {
        if (jugadoresTenis2 + cantidad <= max_Tenis) {
            jugadoresTenis2 += cantidad;
            JOptionPane.showMessageDialog(null, "Reservado por " + u.getNombre() + " en Tenis 2. Jugadores actuales: " + jugadoresTenis2);
        } else {
            JOptionPane.showMessageDialog(null, "Cancha llena. Máximo " + max_Tenis + " jugadores.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Cancha inválida.");
    }
}


    // Libera jugadores de una cancha seleccionada
    private void liberarCancha(int id) {
        String tipo = JOptionPane.showInputDialog("""
            ¿Qué cancha desea liberar?
            1. Fútbol 1
            2. Fútbol 2
            3. Baloncesto
            4. Tenis 1
            5. Tenis 2
        """);

        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos jugadores desea liberar?"));

        switch (tipo) {
            case "1" -> jugadoresFutbol1 = Math.max(0, jugadoresFutbol1 - cantidad);
            case "2" -> jugadoresFutbol2 = Math.max(0, jugadoresFutbol2 - cantidad);
            case "3" -> jugadoresBasquetbol = Math.max(0, jugadoresBasquetbol - cantidad);
            case "4" -> jugadoresTenis1 = Math.max(0, jugadoresTenis1 - cantidad);
            case "5" -> jugadoresTenis2 = Math.max(0, jugadoresTenis2 - cantidad);
            default -> {
                JOptionPane.showMessageDialog(null, "Selección inválida.");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Liberación realizada correctamente.");
    }

    // Muestra el estado actual de todas las canchas
    private void mostrarEstadoRecreacion() {
        String estado = """
            Estado actual de las canchas:
            Fútbol 1: """ + jugadoresFutbol1 + "/" + max_Futbol + "\n" +
            "Fútbol 2: " + jugadoresFutbol2 + "/" + max_Futbol + "\n" +
            "Baloncesto: " + jugadoresBasquetbol + "/" + max_Basquetbol + "\n" +
            "Tenis 1: " + jugadoresTenis1 + "/" + max_Tenis + "\n" +
            "Tenis 2: " + jugadoresTenis2 + "/" + max_Tenis;

        JOptionPane.showMessageDialog(null, estado);
    }

public void abrirInterfaz() {
    // Crear ventana
    JFrame frame = new JFrame("Área de Recreación");
    frame.setSize(400, 400);
    frame.setLayout(new GridLayout(6, 1, 10, 10));

    // Botones
    JButton btnFutbol = new JButton("Reservar Fútbol");
    JButton btnBasket = new JButton("Reservar Baloncesto");
    JButton btnTenis = new JButton("Reservar Tenis");
    JButton btnLiberar = new JButton("Liberar Cancha");
    JButton btnEstado = new JButton("Ver Estado Actual");
    JButton btnCerrar = new JButton("Cerrar");

    // Agregar botones
    frame.add(btnFutbol);
    frame.add(btnBasket);
    frame.add(btnTenis);
    frame.add(btnLiberar);
    frame.add(btnEstado);
    frame.add(btnCerrar);

    // === Eventos ===
    btnFutbol.addActionListener(e -> {
        Usuario u = seleccionarUsuarioRecreacion();
        if (u != null && u.isActivo()) {
            reservarFutbol(u.getId());
        } else {
            JOptionPane.showMessageDialog(frame, "Usuario inválido o inactivo.");
        }
    });

    btnBasket.addActionListener(e -> {
        Usuario u = seleccionarUsuarioRecreacion();
        if (u != null && u.isActivo()) {
            reservarBaloncesto(u.getId());
        } else {
            JOptionPane.showMessageDialog(frame, "Usuario inválido o inactivo.");
        }
    });

    btnTenis.addActionListener(e -> {
        Usuario u = seleccionarUsuarioRecreacion();
        if (u != null && u.isActivo()) {
            reservarTenis(u.getId());
        } else {
            JOptionPane.showMessageDialog(frame, "Usuario inválido o inactivo.");
        }
    });

    btnLiberar.addActionListener(e -> {
        Usuario u = seleccionarUsuarioRecreacion();
        if (u != null) {
            liberarCancha(u.getId());
        } else {
            JOptionPane.showMessageDialog(frame, "Usuario no encontrado.");
        }
    });

    btnEstado.addActionListener(e -> mostrarEstadoRecreacion());

    btnCerrar.addActionListener(e -> frame.dispose());

    // Configurar ventana
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}

}
