package task;

public abstract class BattleUnitBase implements BattleUnit {
    String name;
    int health;
    int maxHealth;
    int baseStrength;
    int maxArmor;
    int strength;
    int armor;
    public BattleUnitBase(String name, int maxHealth, int baseStrength, int maxArmor)
    {
        this.name = name;
        this.maxHealth = 0;
        this.maxArmor = 0;
        this.baseStrength = 0;
        if(maxHealth > 0)
            this.maxHealth = maxHealth;
        if(maxArmor > 0)
            this.maxArmor = maxArmor;
        if(baseStrength > 0)
        this.baseStrength = baseStrength;
        health = this.maxHealth;
        armor = this.maxArmor;
        strength = this.baseStrength;
    }

    public abstract void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam);
    public abstract void attack(BattleUnit other);

    public String name()
    {
        return name;
    }
    public int health(){ return health;}
    public int maxHealth(){ return maxHealth;}
    public void setMaxHealth(int value)
    {
        if (value < 0)
            return;
        maxHealth = value;
        if (health > maxHealth)
            health = maxHealth;
    }
    public void heal(int value)
    {
        if (value < 0)
            return;
        if (value + health >= maxHealth)
            health = maxHealth;
        else
            health += value;
    }
    public void takeDamage(int value)
    {
        if (value <= 0)
            return;
        if(health - value < 0)
            health = 0;
        else
            health -= value;
    }
    public int strength(){ return strength;}
    public void setStrength(int value)
    {
        strength = 0;
        strength = value;
    }
    public int baseStrength(){ return baseStrength;}
    public int armor(){ return armor;}
    public void restoreArmor(int value)
    {
        if (value <= 0)
            return;
        if(armor + value >= maxArmor)
            armor = maxArmor;
        else
            armor += value;
    }
    public void damageArmor(int value)
    {
        if (value < 0)
            return;
        armor = armor - value < 0 ? 0 : armor - value;
    }
    public int maxArmor(){ return maxArmor;}
    public void setMaxArmor(int value)
    {
        if (value < 0)
            return;
        maxArmor = value;
        if (armor > maxArmor)
            armor = maxArmor;
    }
}
