package task;

public class ArmorDestroyer extends BattleUnitBase{

    public ArmorDestroyer(String name, int maxHealth, int baseStrength, int maxArmor)
    {
        super(name, maxHealth, baseStrength, maxArmor);
    }
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam)
    {
        int maxAr = -1;
        int target = -1;
        for(int i = 0; i < enemyTeam.length; i++)
        {
            if(enemyTeam[i].health() > 0)
            {
                if(enemyTeam[i].armor() > maxAr)
                {
                    maxAr = enemyTeam[i].armor();
                    target = i;
                }
            }
        }
        if(maxAr < 0)   // никого нет в живых
            return;
        if(maxAr > 0)
            enemyTeam[target].damageArmor(strength*2 > 1? strength*2 : 1);
        else
            enemyTeam[target].takeDamage(strength/4 > 1? strength/4 : 1);

    }
    public void attack(BattleUnit other)
    {
        if(other.armor() > 0)
        {
            other.takeDamage(strength/4 > 1? strength/4 : 1);
            other.damageArmor(strength > 0 ? strength : 1);
        }
        else
            other.takeDamage(strength/2 > 0 ? strength/2 : 1);
    }
}
