import java.time.LocalDate;

public abstract class Cuenta {
    private static int contadorCuentas = 1000;
    private int numeroCuenta;
    protected double saldo;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private double porcentajeInteres;

    public Cuenta(double saldo, LocalDate fechaEmision, LocalDate fechaVencimiento, double porcentajeInteres) {
        contadorCuentas++;
        this.numeroCuenta = contadorCuentas;
        this.saldo = saldo;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.porcentajeInteres = porcentajeInteres;
    }

    public boolean estaVencida() {
        LocalDate hoy = LocalDate.now();
        return fechaVencimiento.isBefore(hoy) || fechaVencimiento.isEqual(hoy);
    }

    public abstract void pagar(double monto);

    public abstract double saldoConsolidado();

    public void generarIntereses() {
        if (estaVencida()) {
            System.out.println("Cuenta " + numeroCuenta + " vencida. No se generan intereses.");
            return;
        }
        double interes = saldo * porcentajeInteres / 100;
        saldo = saldo + interes;
        System.out.println("Intereses generados en cuenta " + numeroCuenta + ": " + interes + ". Nuevo saldo: " + saldo);
    }

    public int getNumeroCuenta() { return numeroCuenta; }
    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }
    public LocalDate getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(LocalDate fechaEmision) { this.fechaEmision = fechaEmision; }
    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
    public double getPorcentajeInteres() { return porcentajeInteres; }
    public void setPorcentajeInteres(double porcentajeInteres) { this.porcentajeInteres = porcentajeInteres; }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Cuenta otra = (Cuenta) obj;
        return numeroCuenta == otra.numeroCuenta;
    }

    @Override
    public String toString() {
        return "Cuenta #" + numeroCuenta + " | Saldo: " + saldo + " | Emision: " + fechaEmision
                + " | Vencimiento: " + fechaVencimiento + " | Interes: " + porcentajeInteres + "%";
    }
}
