package projetoboot;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import screens.EditingFrame;
public class EditAnnotation {
    
    private Vector<Annotation> allannotations;
    
    public EditAnnotation(){
        allannotations = new Vector<>();
        
    }
    //cria um .txt de an e adiciona an ao vetor allannotations
    public void Create(Annotation an){
        an.getMetatag().remove("");
        allannotations.add(an);
        int q = 0;
        int i;
        String a;
        //verificar o proximo arquivo a ser criado
        for(i = 1; ; i++) {            
            a = i + ".txt";
            try {
                FileInputStream teste = new FileInputStream(a);
                try {
                    teste.close();
                } catch (IOException ex) {
                    Logger.getLogger(EditingFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                break;
            }
        }        
        a = i + ".txt";
        an.setId(i);
        OutputStream os = null;
        try {
            os = new FileOutputStream(a);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EditingFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw); 
        try {
            //nome do .txt
            bw.write(a);
            bw.newLine();
            //segunda linha titulo, terceira tags, quarta data inicial e quinta data de modificaçao
            bw.write(an.getTitle());
            bw.newLine();
            bw.write(an.getMetatag().toString());            
            bw.newLine();
            bw.write(an.getCreation().toString());                  
            bw.newLine();
            bw.write(an.getLastmodification().toString());
            bw.newLine();
            bw.write(an.getText());                        
        } catch (IOException ex) {
            Logger.getLogger(EditingFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(EditingFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Edit(){
        
    }
    //deleta um arquivo, deletando o .txt e removendo o annotation do vetor
    //An: annotation a ser removido
    //obs: ainda nao foi testado
    public void Delete(Annotation an){
        allannotations.remove(an);
        File file = new File(an.getFile());     
        file.delete();
      
    }
    
    public Vector<Annotation> getAnnotations(){
        return allannotations;
    }
}
