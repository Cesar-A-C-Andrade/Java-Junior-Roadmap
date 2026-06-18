package Day1;

import java.util.Random;

public class Enemy implements IDamageable, IFight{

    private String name = "";
    private LifeComponent lifeComponent;
    private AttackComponent attackComponent;
    private int level = 1;


    public Enemy(int Plevel, int PlifeAmout, int PAttackDamage, int PDefensePower, int PLifeRegem,int PDefenseLevel, int PAttackLevel ,String PName){
        this.lifeComponent = new LifeComponent(PlifeAmout, PDefensePower, PLifeRegem, PDefenseLevel);
        this.attackComponent = new AttackComponent(PAttackDamage, PAttackLevel);
        this.name = PName;
        this.level = Plevel;
    }

    @Override
    public void TakeDamage(int PDamageAmount) {
        lifeComponent.TakeDamage(PDamageAmount);
    }

    @Override
    public void RestoreLife(int PLifeRestored) {
        lifeComponent.RestoreLife(PLifeRestored);
    }

    @Override
    public void Die() {
        System.out.println(this.name + " Died!");
        lifeComponent.Die();
    }

    @Override
    public void DoDamage(IDamageable PTarget) {
        attackComponent.DoDamage(PTarget);
    }

    @Override
    public void DoDefense() {
        System.out.println(this.name + " raise his shield");
        lifeComponent.DoDefense();
    }

    @Override
    public void EndTurn() {
        lifeComponent.SetIsDefending(false);
    }

    public void DoAction(IDamageable PTarget) {
        Random randomizer = new Random();
        int _result = randomizer.nextInt(2);
        if (_result == 0){
            DoDamage(PTarget);
        } else{
            DoDefense();
        }
    }

    public boolean IsAlive() {
        return lifeComponent.IsAlive();
    }

    public void DebugStatus() {
        System.out.println(this.name + " has Life: "+ lifeComponent.GetLife());
    }

    public int DropXP() {
        return 2 * this.level;
    }
}
