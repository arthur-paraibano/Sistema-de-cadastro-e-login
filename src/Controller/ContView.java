package Controller;

import Model.Login;
import Model.LoginDAO;
import Model.RegisterDAO;
import Util.Encrypt;
import Util.Message;
import View.Cadastro;

import javax.swing.*;
import java.util.Objects;


public class ContView {

    private static JDialog parentDialog;

    public ContView() {
    }

    public ContView(JDialog parentDialog) {
        ContView.parentDialog = parentDialog;
    }

    /***
     * Verifica usuario no Base de dados.
     */
    public static void loginUser(String minusculaUsuario, String usuario, String senha) {
        LoginDAO dao = new LoginDAO();

        if (dao.checkLogin(usuario, senha)) {
            Cadastro tela = new Cadastro();
            tela.setVisible(true);
        } else {
            Message.erroTrist(parentDialog, "Parece que você digitou o Usuário ou Senha incorreto!");
        }
    }

    /***
     * Metodo que valida dos compos e pedi pra registrar no banco de dados.
     */
    public static void registraUsuario(String nomeCompleto, String gmail, String username, String senha) {
        // Method to Register user with encryption
        RegisterDAO dao = new RegisterDAO(parentDialog);
        Login obj = new Login();

        if (nomeCompleto.isEmpty() || gmail.isEmpty() || username.isEmpty() || senha.isEmpty()) {
            Message.errorX(parentDialog, "Preencha todos os campos");
        } else {
            obj.setNoemCompleto(nomeCompleto);
            obj.setNomeLogin(username);
            String novaSenha = (Encrypt.encriptografat(senha));
            obj.setSenha(novaSenha);

            if (isValidEmail(gmail)) {
                obj.setGmailHotmail(gmail);
                dao.toCheckUser(obj);
            } else {
                Message.erroTrist(parentDialog, "Por favor, insira um endereço de e-mail válido!!!");
            }
        }
    }

    /***
     * Verifica se o Gmail/Hotmail tá no formato correto...
     */
    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(regex);

    }
}
