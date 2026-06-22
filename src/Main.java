import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco PC");

        Cliente clienteSinAdmin = new Cliente("Laura Rojas", "111", "F",
                "laura@correo.com", "Ingeniera", "San Jose", "Laura2024#");
        banco.registrarCliente(clienteSinAdmin);

        Administrador admin = new Administrador("Eddy Chacon", "100",
                "admin@bancopc.com", "AdminPC2024$");
        banco.registrarAdministrador(admin);

        System.out.println("Contrasenia del admin valida: " + admin.validarContrasenia());

        Cliente cliente = new Cliente("Mario Soto", "222", "M",
                "mario@correo.com", "Contador", "Heredia", "Mario2024@");
        banco.registrarCliente(cliente);

        CuentaAhorro ahorro = new CuentaAhorro(500, LocalDate.now(), LocalDate.now().plusYears(2), 3.5);
        CuentaDebito debito = new CuentaDebito(200, LocalDate.now(), LocalDate.now().plusYears(1), 1.0);
        CuentaCredito credito = new CuentaCredito(1500, "Cashback", LocalDate.now(), LocalDate.now().plusYears(3), 2.5);

        cliente.agregarCuenta(ahorro);
        cliente.agregarCuenta(debito);
        cliente.agregarCuenta(credito);

        System.out.println();
        System.out.println("--- Cuenta de ahorro ---");
        ahorro.depositar(300);
        ahorro.pagar(650);
        ahorro.pagar(800);
        ahorro.generarIntereses();

        System.out.println();
        System.out.println("--- Cuenta de debito ---");
        debito.depositar(100);
        debito.pagar(250);
        debito.pagar(100);

        System.out.println();
        System.out.println("--- Cuenta de credito ---");
        credito.pagar(1000);
        credito.pagar(800);
        credito.abonar(400);

        System.out.println();
        System.out.println("--- Cuenta vencida ---");
        CuentaDebito vencida = new CuentaDebito(300, LocalDate.now().minusYears(1), LocalDate.now().minusDays(1), 1.0);
        cliente.agregarCuenta(vencida);
        vencida.pagar(50);

        System.out.println();
        cliente.generarReporte();

        System.out.println();
        banco.listarClientes();
        banco.listarCuentas();

        System.out.println();
        System.out.println("Login admin: " + admin.autenticar("admin@bancopc.com", "AdminPC2024$"));
        System.out.println("Login cliente con clave mala: " + cliente.autenticar("mario@correo.com", "claveMala"));
    }
}