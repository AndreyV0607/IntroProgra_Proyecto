/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package introprogra_proyectofinal1.pkg0;

/**
 *
 * @author andreyvargassolis
 */
import java.util.ArrayList;
import java.util.List;


//atributos
public class Usuario {
    private int id;
    private String nombre;
    private boolean activo;

    
    //arreglo de usuarios quemados simulando que el programa este pegado a una base de datos donde todos los usuarios estan
    public static final List<Usuario> listaUsuarios = new ArrayList<>();

    static {
        listaUsuarios.add(new Usuario(101, "Mateo", true));
        listaUsuarios.add(new Usuario(102, "Valeria", true));
        listaUsuarios.add(new Usuario(103, "Andres", true));
        listaUsuarios.add(new Usuario(104, "Sofía", true));
        listaUsuarios.add(new Usuario(105, "Carlos", true));
        listaUsuarios.add(new Usuario(106, "Carmonis", true));
        listaUsuarios.add(new Usuario(107, "Luis", true));
        listaUsuarios.add(new Usuario(108, "María", true));
        listaUsuarios.add(new Usuario(109, "Juan", true));
        listaUsuarios.add(new Usuario(110, "Ana", true));
        listaUsuarios.add(new Usuario(111, "José", true));
        listaUsuarios.add(new Usuario(112, "Lucía", true));
        listaUsuarios.add(new Usuario(113, "Daniel", true));
        listaUsuarios.add(new Usuario(114, "Camilo", true));
        listaUsuarios.add(new Usuario(115, "David", false));
        listaUsuarios.add(new Usuario(116, "Laura", true));
        listaUsuarios.add(new Usuario(117, "Pedro", true));
        listaUsuarios.add(new Usuario(118, "Isabela", true));
        listaUsuarios.add(new Usuario(119, "Andrés", true));
        listaUsuarios.add(new Usuario(120, "Gabriela", true));
        listaUsuarios.add(new Usuario(121, "Sebastián", true));
        listaUsuarios.add(new Usuario(122, "Natalia", true));
        listaUsuarios.add(new Usuario(123, "Diego", true));
        listaUsuarios.add(new Usuario(124, "Emma", true));
        listaUsuarios.add(new Usuario(125, "Tomás", true));
        listaUsuarios.add(new Usuario(126, "Renata", true));
        listaUsuarios.add(new Usuario(127, "Martín", true));
        listaUsuarios.add(new Usuario(128, "Paula", true));
        listaUsuarios.add(new Usuario(129, "Esteban", true));
        listaUsuarios.add(new Usuario(130, "Fernanda", true));
        listaUsuarios.add(new Usuario(131, "Julián", true));
        listaUsuarios.add(new Usuario(132, "Elena", true));
        listaUsuarios.add(new Usuario(133, "Max", true));
        listaUsuarios.add(new Usuario(134, "Victoria", true));
        listaUsuarios.add(new Usuario(135, "Samuel", true));
        listaUsuarios.add(new Usuario(136, "Mariana", true));
        listaUsuarios.add(new Usuario(137, "Kevin", true));
        listaUsuarios.add(new Usuario(138, "Allison", true));
        listaUsuarios.add(new Usuario(139, "Rodrigo", true));
        listaUsuarios.add(new Usuario(140, "Patricia", true));
        listaUsuarios.add(new Usuario(141, "Alexander", true));
        listaUsuarios.add(new Usuario(142, "Nicole", true));
        listaUsuarios.add(new Usuario(143, "Axel", true));
        listaUsuarios.add(new Usuario(144, "Daniela", true));
        listaUsuarios.add(new Usuario(145, "Jorge", true));
        listaUsuarios.add(new Usuario(146, "Tatiana", true));
        listaUsuarios.add(new Usuario(147, "Lucas", true));
        listaUsuarios.add(new Usuario(148, "Andrea", true));
        listaUsuarios.add(new Usuario(149, "Pablo", true));
        listaUsuarios.add(new Usuario(150, "Fiorella", true));
    }

    //constructor
    public Usuario(int id, String nombre, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
    }

    //setters&getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
    //funcion para verificar el id que luego se utilizara en las diferentes clases para verificar el id antes de ingresar el usuario
    public static Usuario buscarPorId(int id) {
        for (Usuario u : listaUsuarios) {
            if (u.getId() == id) return u;
        }
        return null;
    }
}
