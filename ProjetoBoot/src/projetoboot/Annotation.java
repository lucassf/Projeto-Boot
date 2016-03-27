package projetoboot;

import java.util.Date;
import java.util.Vector;

public class Annotation {
    private String title;
    private String text;
    private Date creation;
    private Date lastmodification;
    private Vector<String> metatag;

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

    public Vector<String> getMetatag() {
        return metatag;
    }

    public void setMetatag(Vector<String> metatag) {
        this.metatag = metatag;
    }
    
    
}
