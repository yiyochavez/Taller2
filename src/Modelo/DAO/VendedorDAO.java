/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Vendedor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VendedorDAO {

    Conexion con;

    public VendedorDAO() {
        this.con = new Conexion();
    }

    public ArrayList<Vendedor> getVendedores() {

        ArrayList<Vendedor> vendedores = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM vendedor ";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                int id_vendedor = resultados.getInt("id_vendedor");
                String nombre = resultados.getString("nombre");
                String apellido = resultados.getString("apellido");
                String rut = resultados.getString("rut");

                vendedores.add(new Vendedor(id_vendedor, nombre, apellido, rut));
            }
            accesoBD.close();
            return vendedores;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }

    public Vendedor obtenerVendedor(int id_vendedor) {

        Vendedor p;
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM vendedor WHERE id = " + id_vendedor + " ";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.first()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String rut = rs.getString("rut");

                p = new Vendedor(id_vendedor, nombre, apellido, rut);
                accesoBD.close();
                return p;
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



}