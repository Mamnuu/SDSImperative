package Clases;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
public class Paciente {
    public Integer id;
    public String nombre;
    public String apellido;
    public List<Enfermedad> enfermedades;
    public Regimen regimen;
    public Afiliacion afiliacion;
    public Double costos;
    public Integer numEnfermedades;
    public Eps eps;

    public Paciente(Integer id, String nombre, String apellido, Regimen regimen,
                    Afiliacion afiliacion, Double costos, Integer numEnfermedades,
                    List<Enfermedad> enfermedades, Eps eps){
        this.id = id;
        this.nombre = nombre;
        this.apellido=apellido;
        this.regimen = regimen;
        this.afiliacion = afiliacion;
        this.costos = costos;
        this.numEnfermedades = numEnfermedades;
        this.enfermedades =enfermedades;
        this.eps= eps;
    }
    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                "apellido='" + apellido + '\'' +
                "tipo de afiliación='" + afiliacion + '\'' +
                "tipo de regimen='" + regimen + '\'' +
                "costos='" + costos + '\'' +
                "número de enfermedades='" + numEnfermedades + '\'' +
                "eps='" + eps + '\'' +
                ", id=" + id +
                '}';
    }

}
