/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.person;

import core.clatzy.product.Curso;
import core.clatzy.product.relation.PlanCliente;
import core.clatzy.product.relation.ProductoCliente;
import java.util.ArrayList;

/**
 *
 * @author edangulo
 */
public class Cliente extends Persona {
    
    private ArrayList<PlanCliente> planes;
    private ArrayList<ProductoCliente> productos;
    
    public Cliente(String nombre, String cedula, String telefono, String email) {
        super(nombre, cedula, telefono, email);
        this.planes = new ArrayList<>();
        this.productos = new ArrayList<>();
    }

    public ArrayList<PlanCliente> getPlanes() {
        return planes;
    }

    public ArrayList<ProductoCliente> getProductos() {
        return productos;
    }
    
    public boolean addPlan(PlanCliente plan) {
        if (!this.planes.contains(plan)) {
            this.planes.add(plan);
            return true;
        }
        return false;
    }
    
    public boolean addProducto(ProductoCliente producto) {
        if (!this.productos.contains(producto)) {
            this.productos.add(producto);
            return true;
        }
        return false;
    }
    
    public PlanCliente getPlan(int index) {
        return this.planes.get(index);
    }
    
    public PlanCliente getPlanActivo() {
        for (PlanCliente plan : this.planes) {
            if (plan.getEstadoActivo()) {
                return plan;
            }
        }
        return null;
    }
    
    public double getIngreso() {
        double ingresos = 0;
        for (ProductoCliente producto : this.productos) {
            ingresos += producto.getValor();
        }
        return ingresos;
    }
    
    public boolean hasPlanActivo() {
        for (PlanCliente plan : this.planes) {
            if (plan.getEstadoActivo()) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Object> hasCursoCompradoRegistrado(Curso curso) {
        ArrayList<Object> data = new ArrayList<>();
        for (ProductoCliente producto : this.productos) {
            if (producto.getCurso().equals(curso)) {
                data.add(true);
                if (producto.getValor() == 0) {
                    data.add("registrado");
                } else {
                    data.add("comprado");
                }
                return data;
            }
        }
        data.add(false);
        data.add(null);
        return data;
    }
    
}
