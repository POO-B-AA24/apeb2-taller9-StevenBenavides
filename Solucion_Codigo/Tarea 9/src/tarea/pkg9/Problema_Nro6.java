package tarea.pkg9;

public class Problema_Nro6 {
    public static void main(String[] args) {
        Cuenta[] cuentas = new Cuenta[3];
        cuentas[0] = new CuentaCheques(1001, "Juan Perez");
        cuentas[1] = new CuentaAhorros(1002, "Maria Gomez");
        cuentas[2] = new CuentaPlatino(1003, "Luis Martinez");

        cuentas[0].depositar(500);
        cuentas[1].depositar(1000);
        cuentas[2].depositar(3200);

        cuentas[0].retirar(100);
        cuentas[1].retirar(200);
        cuentas[2].retirar(3000); 

        for (Cuenta cuenta : cuentas) {
            if (cuenta instanceof CuentaAhorros) {
                ((CuentaAhorros) cuenta).calcularInteres();
            }
            if (cuenta instanceof CuentaPlatino) {
                ((CuentaPlatino) cuenta).calcularInteres();
            }
            System.out.println(cuenta);
        }
    }
}

class Cuenta {
    private int numeroCuenta;
    private String nombreCliente;
    protected double balance;

    public Cuenta(int numeroCuenta, String nombreCliente) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.balance = 0.0;
    }

    public void depositar(double cantidad) {
        balance += cantidad;
    }

    public void retirar(double cantidad) {
        if (balance >= cantidad) {
            balance -= cantidad;
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Cuenta [numeroCuenta=" + numeroCuenta + ", nombreCliente=" + nombreCliente + ", balance=" + balance + "]";
    }
}

class CuentaCheques extends Cuenta {
    public CuentaCheques(int numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }

    @Override
    public void retirar(double cantidad) {
        balance -= cantidad;
    }
}

class CuentaAhorros extends Cuenta {
    private static final double TASA_INTERES = 0.02;

    public CuentaAhorros(int numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }

    public void calcularInteres() {
        balance += balance * TASA_INTERES;
    }
}

class CuentaPlatino extends Cuenta {
    private static final double TASA_INTERES = 0.10;

    public CuentaPlatino(int numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }

    public void calcularInteres() {
        balance += balance * TASA_INTERES;
    }
}
