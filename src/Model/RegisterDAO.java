package Model;

import Util.Base.BaseDados;
import Util.Message;

import javax.swing.*;
import java.sql.*;

public class RegisterDAO {
    private static JDialog parentDialog;

    public RegisterDAO(JDialog parentDialog) {
        RegisterDAO.parentDialog = parentDialog;
    }

    /***
     * Dados para inserir um novo usuario.
     ***/
    private void registerUser(Login obj) {
        Connection con = BaseDados.getConnection();
        PreparedStatement stmt = null;

        try {
            assert con != null;
            stmt = con.prepareStatement("INSERT INTO base.Login (FULL_NAME, GMAIL, USERNAME, PASSWORD) VALUES (?,?,?,?)");
            stmt.setString(1, obj.getNoemCompleto());
            stmt.setString(2, obj.getGmailHotmail());
            stmt.setString(3, obj.getNomeLogin());
            stmt.setString(4, obj.getSenha());
            stmt.executeUpdate();

            Message.sucess(parentDialog, "Dados salvos com sucesso!");
        } catch (Exception e) {
            Message.errorX(parentDialog, "Erro ao salvar novo usuário " + e);
        } finally {
            BaseDados.closeConnection(con, stmt);
        }
    }

    /***
     * Verificar se o usuario existe no Banco de dados.
     ***/
    public void toCheckUser(Login obj) {
        Connection con = BaseDados.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean userExists = false;

        try {
            assert con != null;
            stmt = con.prepareStatement("SELECT * FROM base.Login WHERE USERNAME = ?");
            stmt.setString(1, obj.getNomeLogin());
            rs = stmt.executeQuery();

            if (rs.next()) {
                String collum = rs.getString("USERNAME");
                if (obj.getNomeLogin().equalsIgnoreCase(collum)) {
                    Message.errorX(parentDialog, "Usuario Já existente!!");
                    userExists = true;
                }
            }
            if (!userExists && !toCheckGmailHotmail(obj.getGmailHotmail())) {
                registerUser(obj);
            }
        } catch (SQLException ex) {
            Message.erroTrist(parentDialog, "Erro ao salvar usuário" + ex);
        } finally {
            BaseDados.closeConnection(con, stmt, rs);
        }
    }

    /***
     * Verificar se o Gmail/Hotmail existe no Banco de dados.
     ***/
    public static boolean toCheckGmailHotmail(String gmail) {
        Connection con = BaseDados.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            assert con != null;
            stmt = con.prepareStatement("SELECT * FROM base.Login WHERE GMAIL = ?");
            stmt.setString(1, gmail);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Message.errorX(parentDialog, "Gmail Já existente!!");
                return true;
            }
        } catch (SQLException ex) {
            Message.erroTrist(parentDialog, "Erro ao executar 'toCheckGmailHotmail'" + ex);
        } finally {
            BaseDados.closeConnection(con, stmt, rs);
        }
        return false;
    }
}
