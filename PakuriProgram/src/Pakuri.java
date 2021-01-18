public class Pakuri {
    private String species;
    private int attack, defense, speed;

    //Sets species name, attack score, defense score, and speed  score
    public Pakuri(String species){
        this.species = species;
        this.attack = (species.length() * 7) + 9;
        this.defense = (species.length() * 5) + 17;
        this.speed = (species.length() * 6) + 13;
    }

    //Returns species name
    public String getSpecies() {
        return species;
    }

    //Returns attack score
    public int getAttack () {
        return attack;
    }

    //Returns defense score
    public int getDefense () {
        return defense;
    }

    //Returns speed score
    public int getSpeed () {
        return speed;
    }

    //Sets attack score
    public void setAttack (int newAttack) {
        this.attack = newAttack;
    }

    //Evolves species.
    public void evolve () {
        this.attack = this.attack * 2 ;
        this.defense = this.defense * 4;
        this.speed = this.speed * 3;
    }

}
