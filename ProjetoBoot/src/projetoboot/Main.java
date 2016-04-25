package projetoboot;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    screens.MainFrame mainframe;
                    mainframe = new screens.MainFrame();
                    mainframe.setVisible(true);
                } catch (IOException e) {
                    System.out.println("Erro fatal na leitura dos arquivos");
                }
            }
        });
    }

}
