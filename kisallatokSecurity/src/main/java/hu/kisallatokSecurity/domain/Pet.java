package hu.kisallatokSecurity.domain;

public class Pet {

    private int id;
    private String race;
    private String name;
    private int age;
    private Owner owner;

    public Pet(String race, String name, int age, Owner owner) {
        this.race = race;
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    public Pet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
