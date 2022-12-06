package task;

public class Infantryman extends BattleUnitBase{
    public Infantryman(String name, int maxHealth, int baseStrength, int maxArmor)
    {
        super(name, maxHealth, baseStrength, maxArmor);
    }
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam){}
    public void attack(BattleUnit other)
    {
        if (other.armor() > 0)
        {
            other.takeDamage(strength/2 < 1 ? 1 : strength/2);
            other.damageArmor(strength/4 < 1 ? 1 : strength/4);
        }
        else
            other.takeDamage(strength < 1 ? 1 : strength);
    }
}
