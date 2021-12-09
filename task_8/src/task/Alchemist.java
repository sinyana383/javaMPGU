package task;

public class Alchemist extends BattleUnitBase{
    public Alchemist(String name, int maxHealth, int baseStrength, int maxArmor)
    {
        super(name, maxHealth, baseStrength, maxArmor);
    }
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam)
    {
        int targetMin = -1;
        int targetMax = -1;
        int minHealth = -1;
        int maxHealth = 0;

        for(int i = 0; i < ownTeam.length; i++)
        {
            if(ownTeam[i].health() > 0)
            {
                if(ownTeam[i].health() > maxHealth)
                {
                    maxHealth = ownTeam[i].health();
                    targetMax = i;
                }
                if (ownTeam[i].health() < minHealth || minHealth == -1)
                {
                    minHealth = ownTeam[i].health();
                    targetMin = i;
                }
            }
        }
        if(targetMax < 0)
            return;
        ownTeam[targetMin].heal(10);
        ownTeam[targetMax].setStrength(ownTeam[targetMax].strength() + 1);
    }
    public void attack(BattleUnit other)
    {
        other.setStrength(other.strength() - 2);
        other.setMaxHealth(other.maxHealth() - 4 > 0 ? other.maxHealth() - 4 : 0); // Алхимик убить может
    }
}
