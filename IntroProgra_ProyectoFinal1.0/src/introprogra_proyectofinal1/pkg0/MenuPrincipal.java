/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package introprogra_proyectofinal1.pkg0;

/**
 *
 * @author andreyvargassolis
 */
import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    public void menuPrincipal() {
        setTitle("Menú Principal - Gimnasio");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Logo
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/smart-fit-logo-0.png")); // Ruta del logo
        Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Redimensionar
        JLabel logo = new JLabel(new ImageIcon(img), SwingConstants.CENTER);
        logo.setPreferredSize(new Dimension(400, 180));
        add(logo, BorderLayout.NORTH);

        //Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5, 1, 15, 15));
        panelBotones.setBackground(new Color(0, 0, 0));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 50, 30, 50));

        // Botones
        JButton btnParqueo = new JButton("Parqueo");
        JButton btnSalaPesas = new JButton("Sala de Pesas");
        JButton btnAuditorio = new JButton("Auditorio");
        JButton btnCabina = new JButton("Cabina");
        JButton btnClasesGrupales = new JButton("Clases Grupales");
        JButton btnRecreacion = new JButton("Recreación");
        JButton btnSalir = new JButton("Salir");

        // Estilo de botones
        JButton[] botones = {btnParqueo, btnSalaPesas, btnAuditorio, btnRecreacion, btnClasesGrupales, btnCabina, btnSalir};
        for (JButton b : botones) {
            b.setBackground(new Color(0, 200, 76));
            b.setForeground(Color.WHITE);
            b.setFont(new Font("Arial", Font.BOLD, 18));
            b.setFocusPainted(false);
            b.setBorder(BorderFactory.createLineBorder(new Color(251, 199, 5), 1));
            panelBotones.add(b);
        }

        add(panelBotones, BorderLayout.CENTER);

        // Eventos
        btnParqueo.addActionListener(e -> new Parqueo().abrirInterfaz());
        btnSalaPesas.addActionListener(e -> new SalaPesas().abrirInterfaz());
        btnAuditorio.addActionListener(e -> new Auditorio().abrirInterfaz());
        btnCabina.addActionListener(e -> new Cabina().abrirInterfaz());
        btnClasesGrupales.addActionListener(e -> new ClasesGrupales().abrirInterfaz());
        btnRecreacion.addActionListener(e -> new Recreacion().abrirInterfaz());
        btnSalir.addActionListener(e -> System.exit(0));

        setLocationRelativeTo(null);
        setVisible(true);

    }
}



