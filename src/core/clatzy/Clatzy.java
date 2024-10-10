/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.clatzy;

import core.clatzy.product.Curso;
import core.clatzy.product.Plan;
import core.person.Cliente;
import core.person.Instructor;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author edangulo
 */
public class Clatzy {
    
    private ArrayList<Cliente> clientes;
    private ArrayList<Instructor> instructores;
    private ArrayList<Curso> cursos;
    private ArrayList<Plan> planes;

    public Clatzy() {
        this.clientes = new ArrayList<>();
        this.instructores = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.planes = new ArrayList<>();
    }
    
    public boolean addCliente(String nombre, String cedula, String telefono, String email) {
        this.clientes.add(new Cliente(nombre, cedula, telefono, email));
        return true;
    }
    
    public boolean addCurso(int id, String nombre, LocalDate fechaInicio, double valor, Instructor instructor) {
        this.cursos.add(new Curso(id, nombre, fechaInicio, null, true, valor, instructor));
        return true;
    }
    
    public boolean addInstructor(String nombre, String cedula, String telefono, String email) {
        this.instructores.add(new Instructor(nombre, cedula, telefono, email));
        return true;
    }
    
    public boolean addPlan(String nombre, LocalDate fechaInicio, double valor, double valorMaximoCurso) {
        this.planes.add(new Plan(0, nombre, fechaInicio, null, true, valor, valorMaximoCurso));
        return true;
    }
    
    public Cliente getCliente(int index) {
        return this.clientes.get(index);
    }
    
    public Curso getCurso(int index) {
        return this.cursos.get(index);
    }
    
    public Instructor getInstructor(int index) {
        return this.instructores.get(index);
    }
    
    public Plan getPlan(int index) {
        return this.planes.get(index);
    }
    
    public boolean comprarCurso(Cliente cliente, Curso curso, LocalDate fecha) {
        ArrayList<Object> data = cliente.hasCursoCompradoRegistrado(curso);
        return true;
    }
    
    public boolean comprarCurso(Cliente cliente, Curso curso, LocalDate fecha, double valor) {
        return true;
    }
    
}
