package tarea.pkg9;

import java.util.ArrayList;
import java.util.Arrays;

public class Problema_Nro2 {
    public static void main(String[] args) {
        DVD soporteDVD = new DVD(5);
        VHS soprteVHS = new VHS("cinta magnetica estandar");
        ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>(Arrays.asList(
                                             new Pelicula("Intensamente", "Ricardo", "2024", "Espanol", soporteDVD),
                                             new Pelicula("JuegoTronos", "Daniel", "2000", "Espanol", soporteDVD),
                                             new Pelicula("Matrix", "Steven", "2024", "Espaniol", soporteDVD)));
            for (Pelicula peli : listaPeliculas){
                System.out.println(peli);
            }      
    }
}
class Pelicula{
    public String titulo;
    public String autor;
    public String yearEdition;
    public String idioma;
    public double costoAlquiler;
    public Soporte soporte;

    public Pelicula(String titulo, String autor, String yearEdition, String idioma, Soporte soporte) {
        this.titulo = titulo;
        this.autor = autor;
        this.yearEdition = yearEdition;
        this.idioma = idioma;
        this.soporte = soporte;
    }
    
    public void calcularCostoAlquiler(){
        
    }

    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", autor=" + autor + ", yearEdition=" + yearEdition + ", idioma=" + idioma + ", costoAlquiler=" + costoAlquiler + ", soporte=" + soporte + '}';
    }
    
}
class Soporte{

}
class DVD extends Soporte{
    public double Capacidad;

    public DVD(double Capacidad) {
        this.Capacidad = Capacidad;
    }
    
    @Override
    public String toString() {
        return "DVD{" + "Capacidad=" + Capacidad + '}';
    }
    
}
class VHS extends Soporte{
    public String tipoCintaMagnetica;

    public VHS(String tipoCintaMagnetica) {
        this.tipoCintaMagnetica = tipoCintaMagnetica;
    }

    @Override
    public String toString() {
        return "VHS{" + "tipoCintaMagnetica=" + tipoCintaMagnetica + '}';
    }
    
}
