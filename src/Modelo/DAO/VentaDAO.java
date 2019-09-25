/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Vendedor;
import Modelo.Venta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VentaDAO {

    Conexion con;

    public VentaDAO() {
        this.con = new Conexion();
    }

    public ArrayList<Venta> getVenta() {

        ArrayList<Venta> ventas = new ArrayList<>();
        Connection accesoBD = con.getConexion();
        VendedorDAO vendedor1 = new VendedorDAO();

        try {
            String sql = "SELECT * FROM venta ";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                int id_venta = resultados.getInt("id_venta");
                String sucursal = resultados.getString("sucursal");
                int monto = resultados.getInt("monto");
                String fecha = resultados.getString("fecha");
                int id_vendedor = resultados.getInt("id_vendedor");
                Vendedor v = vendedor1.obtenerVendedor(id_vendedor);

                ventas.add(new Venta(id_venta, sucursal, monto, fecha, v));
            }
            accesoBD.close();
            return ventas;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }

    public Venta obtenerVenta(String fecha) {

        Venta venta;
        Connection accesoBD = con.getConexion();
        String mesNumero = transformar(fecha);
        VendedorDAO vendedor = new VendedorDAO();

        try {
            String sql = "SELECT * FROM venta WHERE fecha BETWEEN '2019-" + mesNumero + "-01' AND '2019-" + mesNumero + "-31";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.first()) {
                int id_venta = rs.getInt("id_venta");
                String sucursal = rs.getString("sucursal");
                int monto = rs.getInt("monto");
                int id_vendedor = rs.getInt("id_vendedor");
                Vendedor v = vendedor.obtenerVendedor(id_vendedor);

                venta = new Venta(id_venta, sucursal, monto, fecha, v);
                accesoBD.close();
                return venta;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }

    private String transformar(String fecha) {

        if ("Enero".equals(fecha)) {
            return "01";

        }
        if ("Febrero".equals(fecha)) {
            return "02";

        }
        if ("Marzo".equals(fecha)) {
            return "03";

        }
        if ("Abril".equals(fecha)) {
            return "04";

        }
        if ("Mayo".equals(fecha)) {
            return "05";

        }
        if ("Junio".equals(fecha)) {
            return "06";

        }
        if ("Julio".equals(fecha)) {
            return "07";

        }
        if ("Agosto".equals(fecha)) {
            return "08";

        }
        if ("Septiembre".equals(fecha)) {
            return "09";

        }
        if ("Octubre".equals(fecha)) {
            return "10";

        }
        if ("Noviembre".equals(fecha)) {
            return "11";

        }
        if ("Diciembre".equals(fecha)) {
            return "12";

        }

        return null;

    }

}
