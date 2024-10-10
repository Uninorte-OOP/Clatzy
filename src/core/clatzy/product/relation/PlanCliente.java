/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.clatzy.product.relation;

import core.clatzy.product.Plan;
import core.clatzy.product.Producto;
import core.person.Cliente;
import java.time.LocalDate;

/**
 *
 * @author edangulo
 */
public class PlanCliente extends Producto {
    
    private Cliente cliente;
    private Plan plan;

    public PlanCliente(int id, String nombre, LocalDate fechaInicio, LocalDate fechaFin, boolean estadoActivo, double valor, Cliente cliente, Plan plan) {
        super(id, nombre, fechaInicio, fechaFin, estadoActivo, valor);
        this.cliente = cliente;
        this.plan = plan;
        
        this.cliente.addPlan(this);
        this.plan.addPlanCliente(this);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Plan getPlan() {
        return plan;
    }
    
}
