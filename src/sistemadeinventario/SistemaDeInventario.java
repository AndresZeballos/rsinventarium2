/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeinventario;

import presentacion.Principal;

/**
 * Clase con el Main del cliente.
 * @author Andres
 */
public class SistemaDeInventario {

    /**
     * Main del cliente.
     * No se utilizan parametros
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal principal = new Principal();
        if (principal.getOk()) {
            principal.setVisible(true);
        } else {
            // Si la aplicación no puede levantar, mata al proceso.
            principal.dispose();
        }
    }
}
