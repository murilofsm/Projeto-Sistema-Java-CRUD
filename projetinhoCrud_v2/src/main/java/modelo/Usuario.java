package modelo;

public class Usuario {

    private int id;
    private String usuarioLogin;
    private String senhaLogin;
    private String nivelAcesso;

    public Usuario() {
        this.nivelAcesso = "funcionario";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getSenhaLogin() {
        return senhaLogin;
    }

    public void setSenhaLogin(String senhaLogin) {
        this.senhaLogin = senhaLogin;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", usuarioLogin='" + usuarioLogin + '\'' +
                ", senhaLogin='" + senhaLogin + '\'' +
                ", nivelAcesso='" + nivelAcesso + '\'' +
                '}';
    }
}
