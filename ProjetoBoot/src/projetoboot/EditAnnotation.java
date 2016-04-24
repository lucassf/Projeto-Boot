package projetoboot;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import screens.EditingFrame;
import screens.MainFrame;
public class EditAnnotation {
    
    private Vector<Annotation> allannotations;
    
    public EditAnnotation() throws IOException{
        Annotation annot;
        annot = new Annotation();
        allannotations = new Vector<>();
        FilenameFilter filter = new FilenameFilter() {
          public boolean accept(File dir, String name) {
             return name.endsWith(".txt");             
          }
        };        
        File folder = new File("C:/Users/G1511NEW/Desktop/ITA/CES-22/Lab/Projeto-Boot/ProjetoBoot");
        File[] listOfFiles = folder.listFiles(filter);
        for (int i = 0; i < listOfFiles.length; i++) {
            File file = listOfFiles[i];
            FileReader reader = null;
            try {
                reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);
                annot.setFile(br.readLine());
                annot.setTitle(br.readLine());                
                annot.setMetatag((Set<String>)Arrays.asList(br.readLine())); //PROBLEMA!!!!!
                DateFormat format = new SimpleDateFormat("E MMM dd HH:mm:ss yyyy");
                Date creation = null;
                try {
                    creation = format.parse(br.readLine());
                } catch (ParseException ex) {
                    System.out.println("Error afasdf");
                    Logger.getLogger(EditAnnotation.class.getName()).log(Level.SEVERE, null, ex);
                }
                annot.setCreation(creation);
                Date lastmodification = null;
                try {
                    lastmodification = format.parse(br.readLine());
                } catch (ParseException ex) {
                    System.out.println("Error afasdf");
                    Logger.getLogger(EditAnnotation.class.getName()).log(Level.SEVERE, null, ex);
                }
                annot.setLastmodification(lastmodification);
                String text = null;
                int c = br.read();                
                while (c != -1){
                    text = text + (char)c;
                    c = br.read();
                }                    
                annot.setText(text);
                allannotations.add(annot);
            } catch (FileNotFoundException ex) {
                System.out.println("Error afasdf");
               // Logger.getLogger(EditAnnotation.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
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
    //old: annotation a ser mudada
    //new: a nova anotation apos a edicao
    public void Edit(Annotation old, Annotation nova){
        String a;
        a = old.getFile();
        File file = new File(a);
        file.delete();
        allannotations.remove(old);           
        OutputStream os = null;
        try {
            os = new FileOutputStream(a);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw); 
        try {
            //nome do .txt
            bw.write(a);
            bw.newLine();
            //segunda linha titulo, terceira tags, quarta data inicial e quinta data de modificaçao
            bw.write(nova.getTitle());
            bw.newLine();
            bw.write(nova.getMetatag().toString());            
            bw.newLine();
            bw.write(nova.getCreation().toString());                  
            bw.newLine();
            bw.write(nova.getLastmodification().toString());
            bw.newLine();
            bw.write(nova.getText());                        
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }      
        allannotations.add(nova);         
        
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
