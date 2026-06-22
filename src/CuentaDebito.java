import java.time.LocalDate;

public class CuentaDebito extends Cuenta {

    public CuentaDebito(double saldo, LocalDate fechaEmision, LocalDate fechaVencimiento, double porcentajeInteres) {
        super(saldo, fechaEmision, fechaVencimiento, porcentajeInteres);
        if (saldo < 0) {
            System.out.println("La cuenta de debito no puede iniciar con saldo negativo. Se ajusta a $0.");
            this.saldo = 0;
        }
    }

    @Override
    public void pagar(double monto) {
        if (estaVencida()) {
            System.out.println("Cuenta vencida. Transaccion bloqueada.");
            return;
        }
        if (saldo - monto < 0) {
            System.out.println("Pago rechazado: el saldo no puede ser negativo.");
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
        return "[Debito] " + super.toString();
    }
}
