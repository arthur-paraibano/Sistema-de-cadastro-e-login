package App;

import Util.Theme;
import View.Cadastro;
import View.LoginView;

public class Main {
    public static void main(String[] args) {
        Theme.setTheme(Theme.NIMBUS);
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
    }
}