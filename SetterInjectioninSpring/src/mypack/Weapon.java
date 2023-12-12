package mypack;
public interface Weapon {
    void attack();
}

class Gun implements Weapon {
    public void attack() {
        System.out.println("Gun attack");
    }
}

class Sword implements Weapon {
    public void attack() {
        System.out.println("Sword attack");
    }
}

 class Missiles implements Weapon {
    public void attack() {
        System.out.println("Missiles attack");
    }
}

 class Soldier {
    private Weapon weapon;

    // Setter method for dependency injection
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void perform() {
        weapon.attack();
    }
}
