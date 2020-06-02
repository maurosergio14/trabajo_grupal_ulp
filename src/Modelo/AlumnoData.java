/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.Conexion;
import Controlador.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author alejo
 */
public class AlumnoData {

    private Connection con;

    public AlumnoData() {
    }

    public AlumnoData(Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }

    public void guardarAlumno(Alumno alumno) {
        try {
            String sql = "INSERT INTO alumno (nombre, fecNac, activo) VALUES ( ? , ? , ? );";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alumno.getNombre());
            ps.setDate(2, Date.valueOf(alumno.getFecNac()));
            ps.setBoolean(3, alumno.getActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                alumno.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un alumno");
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
    }

    public List<Alumno> obtenerAlumnos() {
        List<Alumno> alumnos = new ArrayList<Alumno>();

        try {
            String sql = "SELECT * FROM alumno;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            Alumno alumno;
            while (resultSet.next()) {
                alumno = new Alumno();
                alumno.setId(resultSet.getInt("id_alumno"));
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setFecNac(resultSet.getDate("fecNac").toLocalDate());
                alumno.setActivo(resultSet.getBoolean("activo"));

                alumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }
        return alumnos;
    }

    public void borrarAlumno(int id_alumno) {

        try {
            String sql = "DELETE FROM alumno WHERE id_alumno =?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_alumno);
            ps.executeUpdate();
            ps.close();
          //  int x=Integer.parseInt(JOptionPane.showInputDialog("introduzca el id a borrar"));
        } catch (SQLException ex) {
            System.out.println("Error al borrar un alumno: " + ex.getMessage());
        }
    }

    public void actualizarAlumno(Alumno alumno) {

        try {

            String sql = "UPDATE alumno SET nombre = ?, fecNac = ? , "
                    + "activo =? WHERE id_alumno = ?;";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alumno.getNombre());
            ps.setDate(2, Date.valueOf(alumno.getFecNac()));
            ps.setBoolean(3, alumno.getActivo());
            ps.setInt(4, alumno.getId());
            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al actualizar un alumno: " + ex.getMessage());
        }

    }

    public Alumno buscarAlumno(int id_alumno) {
        Alumno alumno = null;
        try {

            String sql = "SELECT * FROM alumno WHERE id_alumno =?;";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_alumno);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                alumno = new Alumno();
                alumno.setId(resultSet.getInt("id_alumno"));
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setFecNac(resultSet.getDate("fecNac").toLocalDate());
                alumno.setActivo(resultSet.getBoolean("activo"));
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar un alumno: " + ex.getMessage());
        }

        return alumno;
    }

}
