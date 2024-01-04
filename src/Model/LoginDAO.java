package Model;

import Util.Base.BaseDados;
import Util.Encrypt;
import Util.Message;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO extends Component {

    public LoginDAO() {
    }

    public boolean checkLogin(String user, String password) {
        Connection con = BaseDados.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        if (!user.isEmpty() && !password.isEmpty()) {
            try {
                assert con != null;
                stmt = con.prepareStatement("SELECT * FROM base.Login WHERE USERNAME = ?");
                stmt.setString(1, user);
                rs = stmt.executeQuery();
                if (rs.next()) {
                    String storedPassword = rs.getString("PASSWORD");
                    if (Encrypt.encriptografat(password).equals(storedPassword)) {
                        check = true;
                    }
                }
            } catch (SQLException ex) {
                Message.fatal(this, "Erro no SQL de Login \nContate o ADM do sistema!!!");
            } finally {
                BaseDados.closeConnection(con, stmt, rs);
            }
        }
        return check;
    }
}
