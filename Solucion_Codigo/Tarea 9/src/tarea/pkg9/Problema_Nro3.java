package tarea.pkg9;

public class Problema_Nro3 {
        public static void main(String[] args) {
        Movil remitente = new Movil("123456789", "Juan Pérez");
        Movil destinatario = new Movil("987654321", "María López");

        SMS sms = new SMS(remitente, destinatario, "Hola, ¿cómo estás?");
        MMS mms = new MMS(remitente, destinatario, "Juan.jpg");

        sms.enviarMensaje();
        sms.visualizarMensaje();

        mms.enviarMensaje();
        mms.visualizarMensaje();
    }
}


class Movil {
    private String numeroMovil;
    private String nombre;

    public Movil(String numeroMovil, String nombre) {
        this.numeroMovil = numeroMovil;
        this.nombre = nombre;
    }

    public String getNumeroMovil() {
        return numeroMovil;
    }

    public String getNombre() {
        return nombre;
    }
}

class Mensaje {
    protected Movil remitente;
    protected Movil destinatario;

    public Mensaje(Movil remitente, Movil destinatario) {
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    public void enviarMensaje(){
    }
    public void visualizarMensaje(){
    }
    
}

class SMS extends Mensaje {
    private String contenido;

    public SMS(Movil remitente, Movil destinatario, String contenido) {
        super(remitente, destinatario);
        this.contenido = contenido;
    }

    @Override
    public void enviarMensaje() {
        System.out.println("Enviando SMS de " + remitente.getNumeroMovil() + " a " + destinatario.getNumeroMovil() + ": " + contenido);
    }

    @Override
    public void visualizarMensaje() {
        System.out.println("SMS de " + remitente.getNumeroMovil() + " a " + destinatario.getNumeroMovil() + ": " + contenido);
    }
}

class MMS extends Mensaje {
    private String nombreFicheroImagen;

    public MMS(Movil remitente, Movil destinatario, String nombreFicheroImagen) {
        super(remitente, destinatario);
        this.nombreFicheroImagen = nombreFicheroImagen;
    }

    @Override
    public void enviarMensaje() {
        System.out.println("Enviando MMS de " + remitente.getNumeroMovil() + " a " + destinatario.getNumeroMovil() + ": " + nombreFicheroImagen);
    }

    @Override
    public void visualizarMensaje() {
        System.out.println("MMS de " + remitente.getNumeroMovil() + " a " + destinatario.getNumeroMovil() + ": " + nombreFicheroImagen);
    }
}


