package entity;


import org.springframework.data.annotation.Id;

public class Project {

    @Id
    private long id;

    private String name;

    private boolean done;

    public Project(String name, boolean done) {
        this.name = name;
        this.done = done;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
