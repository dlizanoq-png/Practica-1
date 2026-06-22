public abstract class Usuario {
    private String nombreCompleto;
    private String cedula;
    private String correoElectronico;
    private String contrasenia;

    public Usuario(String nombreCompleto, String cedula, String correoElectronico, String contrasenia) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
    }

    public boolean validarContrasenia() {
        if (contrasenia.length() < 8) {
            return false;
        }
        boolean minuscula = false;
        boolean mayuscula = false;
        boolean digito = false;
        boolean especial = false;
        for (int i = 0; i < contrasenia.length(); i++) {
            char c = contrasenia.charAt(i);
            if (Character.isLowerCase(c)) {
                minuscula = true;
            } else if (Character.isUpperCase(c)) {
                mayuscula = true;
            } else if (Character.isDigit(c)) {
                digito = true;
            } else {
                especial = true;
            }
        }
        return minuscula && mayuscula && digito && especial;
    }

    public boolean autenticar(String correo, String clave) {
        return correoElectronico.equals(correo) && contrasenia.equals(clave);
    }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }
    public String getContrasenia() { return contrasenia; }
    public void setContrasenia(String contrasenia) { this.contrasenia = contrasenia; }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Usuario otro = (Usuario) obj;
        return cedula.equals(otro.cedula);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto + " | Cedula: " + cedula + " | Correo: " + correoElectronico;
    }
}