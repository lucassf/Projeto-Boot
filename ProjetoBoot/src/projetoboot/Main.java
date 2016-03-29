package projetoboot;

public class Main {

    static screens.NovoPrincipal mainframe;
    
    public static void main(String[] args) {
        mainframe=new screens.NovoPrincipal();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainframe.setVisible(true);
            }
        });
    }
    
}
