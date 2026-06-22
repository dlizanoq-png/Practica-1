import java.time.LocalDate;

public class CuentaAhorro extends Cuenta {

    public CuentaAhorro(double saldo, LocalDate fechaEmision, LocalDate fechaVencimiento, double porcentajeInteres) {
        super(saldo, fechaEmision, fechaVencimiento, porcentajeInteres);
        if (saldo < 100) {
            System.out.println("La cuenta de ahorro debe tener al menos $100. Se ajusta el saldo a $100.");
            this.saldo = 100;
        }
    }

    @Override
    public void pagar(double monto) {
        if (estaVencida()) {
            System.out.println("Cuenta vencida. Transaccion bloqueada.");
            return;
        }
        if (saldo - monto < 100) {
            System.out.println("Pago rechazado: el saldo no puede bajar de $100.");
            return;
        }
        saldo = saldo - monto;
        System.out.println("Pago de " + monto + " realizado. Nuevo saldo: " + saldo);
    }

    public void depositar(double monto) {
        if (estaVencida()) {
            System.out.println("Cuenta vencida. Transaccion bloqueada.");
            return;
        }
        if (monto <= 0) {
            System.out.println("El monto debe ser positivo.");
            return;
        }
        saldo = saldo + monto;
        System.out.println("Deposito de " + monto + " realizado. Nuevo saldo: " + saldo);
    }

    @Override
    public double saldoConsolidado() {
        return saldo;
    }

    @Override
    public String toString() {
        return "[Ahorro] " + super.toString();
    }
}
