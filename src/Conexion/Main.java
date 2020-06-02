package Conexion;
import Conexion.Conexion;
import Controlador.Alumno;
import Controlador.Cursada;
import Controlador.Materia;
import Modelo.AlumnoData;
import Modelo.CursadaData;
import Modelo.MateriaData;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
/**
 *
 * @author Sergio
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        //conectar a la base de datos
        Conexion cargar = null;
        try {
            cargar = new Conexion();
        } catch (ClassNotFoundException ex) {
            System.out.println("error al conectar");
        }
        Connection con = cargar.getConexion();

        //crear alumno
        Alumno alumno1 = new Alumno("charl", LocalDate.now(), true);
        AlumnoData ad = new AlumnoData();
        
         //ad.guardarAlumno(alumno1);
        //ad.borrarAlumno(1);
        
        //recorrer lista de alumnos
        // List<Alumno>lista=ad.obtenerAlumnos();
        //for(Alumno it:lista){
        // System.out.println("id "+it.getId());
       //  System.out.println("nombre "+it.getNombre());
        
        
       // Alumno ab = ad.buscarAlumno(2);
        //  System.out.println(ab);
        //agregar alumno a base de datos 
      //  ab.setNombre("yenny");
      //  ad.actualizarAlumno(ab);
        
        
        Materia mt = new Materia("nueva_materia");
        MateriaData md = new MateriaData(cargar);
        
        //guardar materia en base de datos
        //md.guardarMateria(mt);
        
        
        //Materia ml=md.buscarMateria(4);
        // System.out.println(ml);
        // System.out.println(md.obtenerMaterias());
        
        //mostrar lista de materias
        //List<Materia> materias=cd.obtenerMateriasCursadas(1);
       // System.out.println(materias);
        
        
        Cursada cur = new Cursada(alumno1, mt, 9);
        CursadaData cd = new CursadaData(cargar);
        //agregar cursada a base de datos
//punto n°3 alumno se pueda inscribir o des-inscribir
        //cd.guardarCursada(cur);
       // cd.borrarCursadaDeUnaMateriaDeunAlumno(0, 0);
        
//punto n°1 mostrar lista de materias cursadas
        List<Materia> cursada = cd.obtenerMateriasCursadas(1);
        for(Materia it:cursada){
        System.out.println("id "+it.getId());
       // System.out.println(materia);
        }
        //buscar materia en bd por id
        //System.out.println(cd.buscarMateria(5));
       //System.out.println(cd.obtenerMateriasCursadas(2));
       
//punto n°2 mostrar lista de cursadas por alumno
       // cd.obtenerCursadasXAlumno(0);
      //  List<Cursada>cursada=cd.obtenerCursadas();
      //  System.out.println(cursada);
        
       
//punto n°4 registrar la calificación final de una materia
       // cd.actualizarNotaCursada(0, 0, 0);
    }
}
