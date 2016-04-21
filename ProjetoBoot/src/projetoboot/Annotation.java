package projetoboot;

import java.util.Date;
import java.util.Set;
import java.util.Comparator;

public class Annotation{
    private String arquivo; //nome do .txt
    
    public enum SortCriteria{
    TITLE,CREATION,LASTMODIFICATION
    };
    
    private String title;
    private String text;
    private Date creation;
    private Date lastmodification;
    private Set<String> metatag;

    public String getArquivo(){
        return arquivo;
    }
    public void setArquivo(String x){
        this.arquivo = x;
    }
    
    public Annotation(){    
    }
    
    public Annotation(String title,String text,Date creation,Date lastmodification,
            Set<String> metatag){
        this.title=title;
        this.text=text;
        this.creation=creation;
        this.lastmodification=lastmodification;
        this.metatag=metatag;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getLastmodification() {
        return lastmodification;
    }

    public void setLastmodification(Date lastmodification) {
        this.lastmodification = lastmodification;
    }

    public Set<String> getMetatag() {
        return metatag;
    }

    public void setMetatag(Set<String> metatag) {
        this.metatag = metatag;
    }
    
    public boolean equals(Annotation an){
        boolean ret;
        ret = an.getCreation().equals(creation)&an.getLastmodification().equals(lastmodification)
                &an.getTitle().equals(title)&an.getMetatag().equals(metatag)&
                an.getText().equals(text);
        return ret;
    }

    public static Comparator<Annotation> NameComparison = new Comparator<Annotation>(){
        @Override
        public int compare(Annotation an1,Annotation an2){
            return an1.getTitle().compareTo(an2.getTitle());
        }
    };
    
    public static Comparator<Annotation> CreationComparison = new Comparator<Annotation>(){
        @Override
        public int compare(Annotation an1,Annotation an2){
            return an1.getCreation().compareTo(an2.getCreation());
        }
    };
    
    public static Comparator<Annotation> UpdateComparison = new Comparator<Annotation>(){
        @Override
        public int compare(Annotation an1,Annotation an2){
            return an1.getLastmodification().compareTo(an2.getLastmodification());
        }
    };
}
