package projetoboot;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new screens.MainFrame().setVisible(true);
                } catch (IOException ex) {
                    System.out.print("Erro na main");
                    //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
