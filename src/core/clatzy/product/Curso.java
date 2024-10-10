/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.clatzy.product;

import core.clatzy.product.relation.ProductoCliente;
import core.person.Instructor;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author edangulo
 */
public class Curso extends Producto {
    
    private ArrayList<Instructor> instructores;
    private ArrayList<ProductoCliente> productosCliente;

    public Curso(int id, String nombre, LocalDate fechaInicio, LocalDate fechaFin, boolean estadoActivo, double valor, Instructor instructor) {
        super(id, nombre, fechaInicio, fechaFin, estadoActivo, valor);
        this.instructores = new ArrayList<>();
        this.productosCliente = new ArrayList<>();
        
        this.instructores.add(instructor);
        
        this.instructores.get(0).addCurso(this);
    }
    
    public boolean addProductoCliente(ProductoCliente producto) {
        if (!this.productosCliente.contains(producto)) {
            this.productosCliente.add(producto);
            return true;
        }
        return false;
    }
    
}
