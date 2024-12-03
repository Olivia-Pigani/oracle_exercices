import java.util.*;

public class Directory {

    private Long id;

    private String name;

    Set<Person> personSet = new HashSet<Person>();

    public Directory(String name, Set<Person> personSet){
        this.id = id;
        this.name = name;
        this.personSet = personSet;
    }

     public Directory(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public Set<Person> getPersonSet(){
        return this.personSet;
    }

    public void setId(Long id){
        this.id = id;
    }

      public void setName(String name){
        this.name = name;
    }

    public void setPersonSet(Set<Person> personSet){
        this.personSet = personSet;
    }

}