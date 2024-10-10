/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.clatzy.product;

import core.clatzy.product.relation.PlanCliente;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author edangulo
 */
public class Plan extends Producto {
    
    private double valorMaximoCurso;
    private ArrayList<PlanCliente> planes;

    public Plan(int id, String nombre, LocalDate fechaInicio, LocalDate fechaFin, boolean estadoActivo, double valor, double valorMaximoCurso) {
        super(id, nombre, fechaInicio, fechaFin, estadoActivo, valor);
        this.valorMaximoCurso = valorMaximoCurso;
        this.planes = new ArrayList<>();
    }

    public double getValorMaximoCurso() {
        return valorMaximoCurso;
    }
    
    public boolean addPlanCliente(PlanCliente plan) {
        if (!this.planes.contains(plan)) {
            this.planes.add(plan);
            return true;
        }
        return false;
    }
    
}
