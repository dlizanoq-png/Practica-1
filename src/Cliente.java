import java.util.ArrayList;

public class Cliente extends Usuario {
    private String sexo;
    private String profesion;
    private String direccion;
    private ArrayList<Cuenta> cuentas;

    public Cliente(String nombreCompleto, String cedula, String sexo, String correoElectronico,
                   String profesion, String direccion, String contrasenia) {
        super(nombreCompleto, cedula, correoElectronico, contrasenia);
        this.sexo = sexo;
        this.profesion = profesion;
        this.direccion = direccion;
        this.cuentas = new ArrayList<>();
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public double calcularSaldoConsolidado() {
        double total = 0;
        for (int i = 0; i < cuentas.size(); i++) {
            total = total + cuentas.get(i).saldoConsolidado();
        }
        return total;
    }

    public void generarReporte() {
        System.out.println("=== Reporte de cuentas de " + getNombreCompleto() + " ===");
        if (cuentas.isEmpty()) {
            System.out.println("El cliente no tiene cuentas.");
        }
        for (int i = 0; i < cuentas.size(); i++) {
            System.out.println(cuentas.get(i));
        }
        System.out.println("Saldo final consolidado: " + calcularSaldoConsolidado());
    }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public String getProfesion() { return profesion; }
    public void setProfesion(String profesion) { this.profesion = profesion; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public ArrayList<Cuenta> getCuentas() { return cuentas; }
    public void setCuentas(ArrayList<Cuenta> cuentas) { this.cuentas = cuentas; }

    @Override
    public String toString() {
        return "[Cliente] " + super.toString() + " | Sexo: " + sexo
                + " | Profesion: " + profesion + " | Direccion: " + direccion
                + " | Cuentas: " + cuentas.size();
    }
}
