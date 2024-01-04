package Model;

public class Login {
    private String noemCompleto;
    private String gmailHotmail;
    private String nomeLogin;
    private String senha;
    private String acessoModulo;
    private String tipoUsuario;
    private int mcm;

    public int getMcm() {
        return mcm;
    }

    public void setMcm(int mcm) {
        this.mcm = mcm;
    }

    public Login() {
    }

    public Login(String noemCompleto, String gmailHotmail, String nomeLogin, String senha, String acessoModulo, String tipoUsuario) {
        this.noemCompleto = noemCompleto;
        this.gmailHotmail = gmailHotmail;
        this.nomeLogin = nomeLogin;
        this.senha = senha;
        this.acessoModulo = acessoModulo;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNoemCompleto() {
        return noemCompleto;
    }

    public void setNoemCompleto(String noemCompleto) {
        this.noemCompleto = noemCompleto;
    }

    public String getGmailHotmail() {
        return gmailHotmail;
    }

    public void setGmailHotmail(String gmailHotmail) {
        this.gmailHotmail = gmailHotmail;
    }

    public String getNomeLogin() {
        return nomeLogin;
    }

    public void setNomeLogin(String nomeLogin) {
        this.nomeLogin = nomeLogin;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAcessoModulo() {
        return acessoModulo;
    }

    public void setAcessoModulo(String acessoModulo) {
        this.acessoModulo = acessoModulo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
