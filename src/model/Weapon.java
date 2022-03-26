// FILE: Weapon.java
// AUTHOR: Elijah Combes
// PURPOSE: Defines a Wepaon, a type of Item
package model.items;

import java.util.*;
import model.items.*;

public class Weapon extends ConcreteItem
{
    private String weaponType; // fields
    private String damageType;

    public Weapon() // default constructor
    {
        super(); 
    }

    public Weapon(String inName, int inCost, int inMin, int inMax, String inDamage, String inWeapon ) // alternate constructor
    {
        super(inName, inCost, inMin, inMax);
        weaponType = inWeapon;
        damageType = inDamage;
    }
    // MUTATORS 
    public void setWeaponType( String inWeaponType )
    {
        weaponType = inWeaponType;
    }

    public void setDamageType( String inDamageType )
    {
        damageType = inDamageType;
    } 
 
    @Override // converts Weapon to string representation, part of strategy pattern
    public String toString()
    {
        return (super.toString() + ", WeaponType: " + weaponType + ", DamageType: "+damageType);
    } 
}