/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


/**
 *
 * @author Rodrigo Chàvez
 */
public class Venta {
    private int id_venta;
    private String sucursal;
    private int monto;
    private String fecha;
    private Vendedor vendedor;

    public Venta(int id_venta, String sucursal, int monto, String fecha, Vendedor vendedor) {
        this.id_venta = id_venta;
        this.sucursal = sucursal;
        this.monto = monto;
        this.fecha = fecha;
        this.vendedor = vendedor;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    
    
}
