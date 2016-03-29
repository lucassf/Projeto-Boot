package projetoboot;

import java.util.Vector;

public class EditAnnotation {
    
    private Vector<Annotation> allannotations;
    
    public EditAnnotation(){
        allannotations = new Vector<>();
        
    }
    
    public void Create(Annotation an){
        allannotations.add(an);
    }
    
    public void Edit(){
        
    }
    
    public void Delete(){
        
    }
    
    public Vector<Annotation> getAnnotations(){
        return allannotations;
    }
}
