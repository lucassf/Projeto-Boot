package projetoboot;

public class Main {

    public static void main(String[] args) {
        //mainframe=new screens.MainFrame();

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //mainframe.setVisible(true);
                new screens.MainFrame().setVisible(true);
            }
        });
    }

}
