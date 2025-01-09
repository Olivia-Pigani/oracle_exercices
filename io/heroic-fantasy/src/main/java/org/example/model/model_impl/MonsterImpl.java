package org.example.model.model_impl;


import org.example.model.ICharacter;

import java.io.Serializable;

public final class MonsterImpl implements ICharacter, Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private int strength;

    private int health;

    public MonsterImpl(String name, int strength, int health) {
        this.name = name;
        this.strength = strength;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "MonsterImpl{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", health=" + health +
                '}';
    }
}
