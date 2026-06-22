import java.util.ArrayList;

public class Banco {
    private String nombre;
    private Administrador administrador;
    private ArrayList<Cliente> clientes;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.clientes = new ArrayList<>();
    }

    public void registrarAdministrador(Administrador admin) {
        if (administrador != null) {
            System.out.println("Ya existe un administrador.");
            return;
        }
        administrador = admin;
        System.out.println("Administrador registrado.");
    }

    public void registrarCliente(Cliente cliente) {
        if (administrador == null) {
            System.out.println("No se pueden registrar clientes sin un administrador.");
            return;
        }
        clientes.add(cliente);
        System.out.println("Cliente registrado: " + cliente.getNombreCompleto());
    }

    public void listarClientes() {
        System.out.println("=== Clientes registrados ===");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(clientes.get(i));
        }
    }

    public void listarCuentas() {
        System.out.println("=== Cuentas de ahorro ===");
        for (int i = 0; i < clientes.size(); i++) {
            ArrayList<Cuenta> cuentas = clientes.get(i).getCuentas();
            for (int j = 0; j < cuentas.size(); j++) {
                if (cuentas.get(j) instanceof CuentaAhorro) {
                    System.out.println(cuentas.get(j));
                }
            }
        }
        System.out.println("=== Cuentas de debito ===");
        for (int i = 0; i < clientes.size(); i++) {
            ArrayList<Cuenta> cuentas = clientes.get(i).getCuentas();
            for (int j = 0; j < cuentas.size(); j++) {
                if (cuentas.get(j) instanceof CuentaDebito) {
                    System.out.println(cuentas.get(j));
                }
            }
        }
        System.out.println("=== Cuentas de credito ===");
        for (int i = 0; i < clientes.size(); i++) {
            ArrayList<Cuenta> cuentas = clientes.get(i).getCuentas();
            for (int j = 0; j < cuentas.size(); j++) {
                if (cuentas.get(j) instanceof CuentaCredito) {
                    System.out.println(cuentas.get(j));
                }
            }
        }
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Administrador getAdministrador() { return administrador; }
    public ArrayList<Cliente> getClientes() { return clientes; }

    @Override
    public String toString() {
        return "Banco: " + nombre + " | Clientes: " + clientes.size();
    }
}
