package hust.hieutm.model;

public class Skill {
    private int id;
    private String name;
    private String percent;

    public Skill() {
    }

    public Skill(String name, String percent) {
        this.name = name;
        this.percent = percent;
    }

    public Skill(int id, String name, String percent) {
        this.id = id;
        this.name = name;
        this.percent = percent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                ", percent='" + percent + '\'' +
                '}';
    }
}
