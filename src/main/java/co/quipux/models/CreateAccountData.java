package co.quipux.models;

import co.quipux.utils.BaseConfig;

public class CreateAccountData extends BaseConfig {

    private String tipo;
    private String numeroDocumento;
    private String nombres;
    private String apellidos;
    private String pais;
    private String celular;
    private String email;
    private String confirmarEmail;
    private String password;
    private String confirmarPassword;

    public CreateAccountData(String tipo, String numeroDocumento, String nombres, String apellidos, String pais, String celular, String email, String confirmarEmail, String password, String confirmarPassword) {
        super(CreateAccountData.class);
        this.tipo = tipo;
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.pais = pais;
        this.celular = celular;
        this.email = email;
        this.confirmarEmail = confirmarEmail;
        this.password = password;
        this.confirmarPassword = confirmarPassword;
        BaseConfig.log.info("User information setup ["+this.getClass().getName()+"]");
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmarEmail() {
        return confirmarEmail;
    }

    public void setConfirmarEmail(String confirmarEmail) {
        this.confirmarEmail = confirmarEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmarPassword() {
        return confirmarPassword;
    }

    public void setConfirmarPassword(String confirmarPassword) {
        this.confirmarPassword = confirmarPassword;
    }

}
