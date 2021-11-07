package task;

public class BattleUnit {
    private int strength;
    private int armor;
    private int health;
    private int x, y;

    public BattleUnit(int strength, int armor, int health, int x, int y)
    {
        this.strength = strength;
        this.armor = armor;
        this.health = health;
        this.x = x;
        this.y = y;
    }
    public int getStrength()
    {
        return strength;
    }
    public int getArmor()
    {
        return armor;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getHealth()
    {
        return health;
    }

    public void attacked(BattleUnit enemy)
    {
        if(enemy.getStrength() < 0)
            return;
        int defence = this.armor;
        if(defence < 0)
            defence = 0;
        int damage = enemy.getStrength() - defence;
        if(damage >= 0 && damage <= enemy.getStrength())
            this.health -= damage;
    }
    public boolean isAlive()
    {
        if(health > 0)
            return true;
        return false;
    }

    public void moveUp()
    {
        --y;
    }
    public void moveDown()
    {
        ++y;
    }
    public void moveLeft()
    {
        --x;
    }
    public void moveRight()
    {
        ++x;
    }
}
