package projetoboot;

import java.util.Date;
import java.util.Set;
import java.util.Comparator;

enum SortCriteria{
    TITLE,CREATION,LASTMODIFICATION
};

public class Annotation{
    private String arquivo; //nome do .txt
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
