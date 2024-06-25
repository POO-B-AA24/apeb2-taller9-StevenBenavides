package tarea.pkg9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problema_Nro5 {
    public static void main(String[] args) {
        SistemaVentaEntradas sistema = new SistemaVentaEntradas();

        // Casos de uso de ejemplo
        sistema.venderEntrada("Principal", "Juan Perez", "normal");
        sistema.venderEntrada("PalcoB", "Maria Gomez", "abonada");
        sistema.venderEntrada("Central", "Luis Martinez", "reducida");

        sistema.consultarEntrada(1);
        sistema.consultarEntrada(2);
        sistema.consultarEntrada(3);
    }
}

class SistemaVentaEntradas {
    public List<Zona> zonas;
    public Map<Integer, Entrada> entradas;

    public SistemaVentaEntradas() {
        this.zonas = new ArrayList<>();
        this.entradas = new HashMap<>();
        zonas.add(new ZonaPrincipal());
        zonas.add(new ZonaPalcoB());
        zonas.add(new ZonaCentral());
        zonas.add(new ZonaLateral());
    }

    public Entrada venderEntrada(String nombreZona, String nombreComprador, String tipo) {
        Zona zona = buscarZona(nombreZona);
        if (zona == null) {
            System.out.println("Zona no encontrada.");
            return null;
        }

        if (!zona.hayLocalidades()) {
            System.out.println("La zona " + nombreZona + " está completa.");
            return null;
        }

        Entrada entrada;
        switch (tipo.toLowerCase()) {
            case "normal":
                entrada = new EntradaNormal(zona, nombreComprador);
                break;
            case "reducida":
                entrada = new EntradaReducida(zona, nombreComprador);
                break;
            case "abonada":
                entrada = new EntradaAbonada(zona, nombreComprador);
                break;
            default:
                System.out.println("Tipo de entrada desconocido.");
                return null;
        }

        zona.venderLocalidad();
        entradas.put(entrada.getId(), entrada);
        System.out.println("Entrada vendida con ID: " + entrada.getId() + ", Precio: " + entrada.getPrecio());
        return entrada;
    }

    public Entrada consultarEntrada(int id) {
        Entrada entrada = entradas.get(id);
        if (entrada == null) {
            System.out.println("Entrada no encontrada.");
            return null;
        }

        System.out.println("Entrada ID: " + id);
        System.out.println("Comprador: " + entrada.getNombreComprador());
        System.out.println("Zona: " + entrada.getNombreZona());
        System.out.println("Precio: " + entrada.getPrecio());
        return entrada;
    }

    public Zona buscarZona(String nombre) {
        for (Zona zona : zonas) {
            if (zona.getNombre().equalsIgnoreCase(nombre)) {
                return zona;
            }
        }
        return null;
    }
}

abstract class Zona {
    public String nombre;
    public int numeroLocalidades;
    public int localidadesDisponibles;
    public double precioNormal;
    public double precioAbonado;

    public Zona(String nombre, int numeroLocalidades, double precioNormal, double precioAbonado) {
        this.nombre = nombre;
        this.numeroLocalidades = numeroLocalidades;
        this.localidadesDisponibles = numeroLocalidades;
        this.precioNormal = precioNormal;
        this.precioAbonado = precioAbonado;
    }

    public boolean hayLocalidades() {
        return localidadesDisponibles > 0;
    }

    public void venderLocalidad() {
        if (hayLocalidades()) {
            localidadesDisponibles--;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioNormal() {
        return precioNormal;
    }

    public double getPrecioAbonado() {
        return precioAbonado;
    }
}

class ZonaPrincipal extends Zona {
    public ZonaPrincipal() {
        super("Principal", 200, 25.0, 17.5);
    }
}

class ZonaPalcoB extends Zona {
    public ZonaPalcoB() {
        super("PalcoB", 40, 70.0, 40.0);
    }
}

class ZonaCentral extends Zona {
    public ZonaCentral() {
        super("Central", 400, 20.0, 14.0);
    }
}

class ZonaLateral extends Zona {
    public ZonaLateral() {
        super("Lateral", 100, 15.5, 10.0);
    }
}

abstract class Entrada {
    public Zona zona;
    public int id;
    public String nombreComprador;
    public double precio;
    public static int contador = 0;

    public Entrada(Zona zona, String nombreComprador) {
        this.zona = zona;
        this.nombreComprador = nombreComprador;
        this.id = ++contador;
        this.precio = calcularPrecioEntrada();
    }

    public int getId() {
        return id;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public String getNombreZona() {
        return zona.getNombre();
    }

    public double getPrecio() {
        return precio;
    }

    protected abstract double calcularPrecioEntrada();
}

class EntradaNormal extends Entrada {
    public EntradaNormal(Zona zona, String nombreComprador) {
        super(zona, nombreComprador);
    }

    @Override
    protected double calcularPrecioEntrada() {
        return zona.getPrecioNormal();
    }
}

class EntradaReducida extends Entrada {
    public EntradaReducida(Zona zona, String nombreComprador) {
        super(zona, nombreComprador);
    }

    @Override
    protected double calcularPrecioEntrada() {
        return zona.getPrecioNormal() * 0.85;
    }
}

class EntradaAbonada extends Entrada {
    public EntradaAbonada(Zona zona, String nombreComprador) {
        super(zona, nombreComprador);
    }

    @Override
    protected double calcularPrecioEntrada() {
        return zona.getPrecioAbonado();
    }
}
