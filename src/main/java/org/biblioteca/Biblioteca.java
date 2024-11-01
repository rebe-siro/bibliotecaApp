//Esta es la clase main

package org.biblioteca;

import org.biblioteca.controller.ViewController;
import org.biblioteca.view.LoginScreen;

/**
 *
 * @author Luzzio
 */
public class Biblioteca {

    public static void main(String[] args) { 
        
        LoginScreen ls = new LoginScreen();
        ls.setVisible(true);
        ls.setLocationRelativeTo(null);
        
        ViewController lsc = new ViewController(ls);
    }
}
