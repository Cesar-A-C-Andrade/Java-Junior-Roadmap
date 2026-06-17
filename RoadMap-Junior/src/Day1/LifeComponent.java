package Day1;

import java.util.Random;

public class LifeComponent implements IDamageable{
    private int life = 10;
    private boolean isAlive = true;
    private int defensePower = 3;
    private boolean isDefending = false;
    private int lifeRegem = 1;
    private int defenseLevel = 1;
    private int maxLife = 10;

    public LifeComponent(int PlifeAmout, int PDefensePower, int PLifeRegem, int PDefenseLevel){
        this.life = PlifeAmout;
        this.maxLife = PlifeAmout;
        this.defensePower = PDefensePower;
        this.lifeRegem = PLifeRegem;
        this.defenseLevel = PDefenseLevel;
    }

    @Override
    public void TakeDamage(int PDamageAmount) {
        if (this.isDefending){
            PDamageAmount = ApplyDamageReduction(PDamageAmount);
        }
        System.out.println("Taking damage equals " + PDamageAmount);
        this.life -= PDamageAmount;
        if (this.life <= 0){
            Die();
        }
    }

    @Override
    public void RestoreLife(int PLifeRestored) {
        if(!isAlive){
            return;
        }
        this.life = Integer.min(this.maxLife, this.life + PLifeRestored);
    }

    @Override
    public void Die() {
        this.isAlive = false;
    }

    public void DoDefense() {
        this.isDefending = true;
        RestoreLife(this.lifeRegem);
    }

    public boolean IsAlive() {
        return this.isAlive;
    }

    public void SetIsDefending(boolean PValue) {
        this.isDefending = PValue;
    }

    public int GetLife() {
        return this.life;
    }

    public void UpDefense() {
        defenseLevel += 1;
    }

    public int ApplyDamageReduction(int PTotalDamageTaken) {
        return PTotalDamageTaken - this.defensePower - this.defenseLevel;
    }

    public void UpLife() {
        maxLife += 5;
        RestoreLife(maxLife);
    }
}
