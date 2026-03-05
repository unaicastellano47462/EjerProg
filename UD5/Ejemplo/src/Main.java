//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Vista.MenuBanco;

public class Main {
    public static void main(String[] args) {
        /*
        Main crea el primer elemento de la vista y a partir de ahí,
        el controlador se encarga de gestionar la lógica y la interacción
        con el modelo.
         */

        MenuBanco menu = new MenuBanco();
        menu.mostrarMenu();
    }
}
