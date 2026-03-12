//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Utilidades.DBConnection;
import Vista.MenuBanco;
import Vista.MenuTitular;
import jakarta.persistence.EntityManagerFactory;


public class Main {
    public static void main(String[] args) {
        // Inicializamos la conexión a la base de datos
        DBConnection.crearEMF();
        /*
        Main crea el primer elemento de la vista y a partir de ahí,
        el controlador se encarga de gestionar la lógica y la interacción
        con el modelo.
         */

        MenuBanco menu = new MenuBanco();
        menu.mostrarMenu();
    }
}
