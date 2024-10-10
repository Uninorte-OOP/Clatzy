/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.clatzy;

import core.clatzy.product.Curso;
import core.clatzy.product.Plan;
import core.clatzy.product.relation.PlanCliente;
import core.clatzy.product.relation.ProductoCliente;
import core.person.Cliente;
import core.person.Instructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

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
        boolean hasCurso = (boolean) data.get(0);
        String obtencion = (String) data.get(1);
        if (hasCurso) {
            System.out.println("El cliente " + cliente.getNombre() + " ya habia " + obtencion + " el curso " + curso.getNombre());
            return false;
        } else if (cliente.hasPlanActivo()) {
            PlanCliente planCliente = cliente.getPlanActivo();
            if (curso.getValor() <= planCliente.getPlan().getValorMaximoCurso()) {
                ProductoCliente productoCliente = new ProductoCliente(0, "", fecha, null, true, 0, false, 0, cliente, curso);
                System.out.println("El cliente " + productoCliente.getCliente().getNombre() + " registro exitosamente el curso " + productoCliente.getCurso().getNombre());
                return true;
            } else {
                System.out.println("El plan del cliente " + cliente.getNombre() + " no cubre el curso " + curso.getNombre());
                return false;
            }
        }
        return false;
    }
    
    public boolean comprarCurso(Cliente cliente, Curso curso, LocalDate fecha, double valor) {
        ArrayList<Object> data = cliente.hasCursoCompradoRegistrado(curso);
        boolean hasCurso = (boolean) data.get(0);
        String obtencion = (String) data.get(1);
        if (hasCurso) {
            System.out.println("El cliente " + cliente.getNombre() + " ya habia " + obtencion + " el curso " + curso.getNombre());
            return false;
        } else if (cliente.hasPlanActivo()) {
            PlanCliente planCliente = cliente.getPlanActivo();
            if (curso.getValor() <= planCliente.getPlan().getValorMaximoCurso()) {
                ProductoCliente productoCliente = new ProductoCliente(0, "", fecha, null, true, 0, false, 0, cliente, curso);
                System.out.println("El curso esta incluido en el plan del cliente " + productoCliente.getCliente().getNombre() + ", por lo tanto no debe pagar. Se procede a registrar el curso " + productoCliente.getCurso().getNombre() + " con costo $0");
                return true;
            }
        }
        if (valor == curso.getValor()) {
            ProductoCliente productoCliente = new ProductoCliente(0, "", fecha, null, true, valor, false, 0, cliente, curso);
            System.out.println("El cliente " + productoCliente.getCliente().getNombre() + " compro exitosamente el curso " + productoCliente.getCurso().getNombre());
            return true;
        } else {
            System.out.println("El cliente " + cliente.getNombre() + " no pago el valor correcto por el curso " + curso.getNombre());
            return false;
        }
    }
    
    public boolean comprarPlan(Cliente cliente, Plan plan, LocalDate fecha) {
        if (cliente.hasPlanActivo()) {
            System.out.println("El cliente " + cliente.getNombre() + " ya tiene un plan activo");
            return false;
        }
        PlanCliente planCliente = new PlanCliente(0, "", fecha, fecha.plusYears(1), true, plan.getValor(), cliente, plan);
        System.out.println("El cliente " + planCliente.getCliente().getNombre() + " compro exitosamente un plan " + planCliente.getPlan().getNombre());
        return true;
    }
    
    public String getClienteMayorIngreso() {
        ArrayList<Double> ingresos = new ArrayList<>();
        for (Cliente cliente : this.clientes) {
            ingresos.add(cliente.getIngreso());
        }
        int index = ingresos.indexOf(Collections.max(ingresos));
        return this.clientes.get(index).getNombre();
    }
    
    public void listAll() {
        System.out.println("Lista de clientes con sus compras:");
        for (Cliente cliente : this.clientes) {
            System.out.println("----------------------------------------");
            System.out.println(cliente.getNombre());
            System.out.println("Planes:");
            for (PlanCliente plan : cliente.getPlanes()) {
                System.out.println(plan.getPlan().getNombre() + " " + plan.getFechaInicio() + " " + String.format("%.1f", plan.getValor()).replace(",", ".") + " " + (plan.getEstadoActivo() ? "True" : "False"));
            }
            System.out.println("\nCursos:");
            for (ProductoCliente producto : cliente.getProductos()) {
                System.out.println(producto.getCurso().getNombre() + " " + producto.getFechaInicio() + " " + String.format("%.1f", producto.getValor()).replace(",", ".") + " " + (producto.getEstadoActivo() ? "True" : "False"));
            }
        }
    }
    
}
