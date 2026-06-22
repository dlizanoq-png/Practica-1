import java.time.LocalDate;

public class CuentaCredito extends Cuenta {
    private double limiteCredito;
    private String tipo;

    public CuentaCredito(double limiteCredito, String tipo, LocalDate fechaEmision, LocalDate fechaVencimiento, double porcentajeInteres) {
        super(0, fechaEmision, fechaVencimiento, porcentajeInteres);
        this.limiteCredito = limiteCredito;
        this.tipo = tipo;
    }

    @Override
    public void pagar(double monto) {
        if (estaVencida()) {
            System.out.println("Cuenta vencida. Transaccion bloqueada.");
            return;
        }
        if (monto <= 0) {
            System.out.println("El monto debe ser positivo.");
            return;
        }
        if (saldo + monto > limiteCredito) {
            System.out.println("Pago rechazado: se supera el limite de credito de " + limiteCredito + ".");
            return;
        }
        saldo = saldo + monto;
        System.out.println("Compra de " + monto + " realizada. Deuda actual: " + saldo);
    }

    public void abonar(double monto) {
        if (estaVencida()) {
            System.out.println("Cuenta vencida. Transaccion bloqueada.");
            return;
        }
        if (monto <= 0) {
            System.out.println("El monto debe ser positivo.");
            return;
        }
        if (monto > saldo) {
            System.out.println("No se puede abonar mas que la deuda. Se abona el total de " + saldo + ".");
            monto = saldo;
        }
        saldo = saldo - monto;
        System.out.println("Abono de " + monto + " realizado. Deuda actual: " + saldo);
    }

    @Override
    public double saldoConsolidado() {
        return -saldo;
    }

    public double getLimiteCredito() { return limiteCredito; }
    public void setLimiteCredito(double limiteCredito) { this.limiteCredito = limiteCredito; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public String toString() {
        return "[Credito - " + tipo + "] " + super.toString() + " | Limite: " + limiteCredito;
    }
}
