package tarea.pkg9;

public class Problema_Nro4 {
    public static void main(String[] args) {
        Jefe jefe = new Jefe("Carlos", "Gomez", "Calle Paris", "1234567845", 5000.0);
        TrabajadorFijoMensual trabajadorFijo = new TrabajadorFijoMensual("Ana", "Perez", "Avenida Eugenio Espejo", "8765432156", jefe, 2000.0);
        Comisionista comisionista = new Comisionista("Luis", "Martinez", "Calle Cuba", "234567894", jefe, 10.0);
        TrabajadorPorHoras trabajadorPorHoras = new TrabajadorPorHoras("Maria", "Lopez", "Av. Orillas Del Zamora", "3456789042", jefe, 15.0, 20.0);

        comisionista.registrarVenta(15000);
        trabajadorPorHoras.registrarHoras(45);

        trabajadorFijo.imprimirNomina();
        comisionista.imprimirNomina();
        trabajadorPorHoras.imprimirNomina();
        jefe.imprimirNomina();
    }
}
    class Trabajador {
    protected String nombre;
    protected String apellidos;
    protected String direccion;
    protected String dni;
    protected Trabajador jefe;

    public Trabajador(String nombre, String apellidos, String direccion, String dni, Trabajador jefe) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.dni = dni;
        this.jefe = jefe;
    }

    public double calcularSueldo(){
        return 0;
    }

    public void imprimirNomina() {
        System.out.println("Nombre: " + nombre + " " + apellidos);
        System.out.println("DNI: " + dni);
        System.out.println("Direccion: " + direccion);
        if (jefe != null) {
            System.out.println("Jefe: " + jefe.nombre + " " + jefe.apellidos);
        }
        System.out.println("Sueldo: " + calcularSueldo());
    }
}

class TrabajadorFijoMensual extends Trabajador {
    private double sueldoMensual;

    public TrabajadorFijoMensual(String nombre, String apellidos, String direccion, String dni, Trabajador jefe, double sueldoMensual) {
        super(nombre, apellidos, direccion, dni, jefe);
        this.sueldoMensual = sueldoMensual;
    }

    @Override
    public double calcularSueldo() {
        return sueldoMensual;
    }
}

class Comisionista extends Trabajador {
    private double ventasRealizadas;
    private double porcentajeComision;

    public Comisionista(String nombre, String apellidos, String direccion, String dni, Trabajador jefe, double porcentajeComision) {
        super(nombre, apellidos, direccion, dni, jefe);
        this.porcentajeComision = porcentajeComision;
        this.ventasRealizadas = 0;
    }

    public void registrarVenta(double monto) {
        this.ventasRealizadas += monto;
    }

    @Override
    public double calcularSueldo() {
        return ventasRealizadas * (porcentajeComision / 100);
    }
}

class TrabajadorPorHoras extends Trabajador {
    private int horasTrabajadas;
    private double precioHora;
    private double precioHoraExtra;

    public TrabajadorPorHoras(String nombre, String apellidos, String direccion, String dni, Trabajador jefe, double precioHora, double precioHoraExtra) {
        super(nombre, apellidos, direccion, dni, jefe);
        this.precioHora = precioHora;
        this.precioHoraExtra = precioHoraExtra;
        this.horasTrabajadas = 0;
    }

    public void registrarHoras(int horas) {
        this.horasTrabajadas += horas;
    }

    @Override
    public double calcularSueldo() {
        int horasNormales = Math.min(40, horasTrabajadas);
        int horasExtras = Math.max(0, horasTrabajadas - 40);
        return (horasNormales * precioHora) + (horasExtras * precioHoraExtra);
    }
}

class Jefe extends Trabajador {
    private double sueldoFijo;

    public Jefe(String nombre, String apellidos, String direccion, String dni, double sueldoFijo) {
        super(nombre, apellidos, direccion, dni, null);
        this.sueldoFijo = sueldoFijo;
    }

    @Override
    public double calcularSueldo() {
        return sueldoFijo;
    }
}

