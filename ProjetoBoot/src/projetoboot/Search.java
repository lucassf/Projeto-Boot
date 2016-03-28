package projetoboot;

import java.util.Vector;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public class Search {
    
    private ArrayList<Annotation> results;
    private Vector<Annotation> allan;
    
    public Search(Vector<Annotation> allan){
        results = new ArrayList<>();
        this.allan = allan;
    }
    
    private boolean StringMatch(String s1,String s2){
        boolean ret = false;
        if (s1.toLowerCase().contains(s2.toLowerCase())){
            ret = true;
        }
        return ret;
    }
    
    public int Search(String name,Set<String> tags,Date creation,Date lastupdate,
            SortCriteria sortcriteria){
        results.clear();
        for (Annotation a:allan){
            boolean isamatch;
            isamatch = StringMatch(a.getTitle(),name) & a.getMetatag().
                    containsAll(tags) & a.getCreation().compareTo(creation)==0 & 
                    a.getLastmodification().compareTo(lastupdate)==0;
            if (isamatch){
                results.add(a);
            }
        }
        if (sortcriteria==SortCriteria.TITLE)
            results.sort(Annotation.NameComparison);
        else if (sortcriteria==SortCriteria.CREATION)
            results.sort(Annotation.CreationComparison);
        else if (sortcriteria==SortCriteria.LASTMODIFICATION)
            results.sort(Annotation.UpdateComparison);
        return results.size();
    }
}
