package Day1;

import java.util.Scanner;

public class BaseCharacter implements  IDamageable, IFight{


    private LifeComponent lifeComponent;
    private AttackComponent attackComponent;
    private String name;
    private int experienceAmount = 0;
    private int level = 1;
    private int currentExperienceCap = 10;

    public BaseCharacter(String PName, int PlifeAmout, int PAttackDamage, int PDefensePower, int PLifeRegem,int PDefenseLevel, int PAttackLevel) {
        this.lifeComponent = new LifeComponent(PlifeAmout, PDefensePower, PLifeRegem, PDefenseLevel);
        this.attackComponent = new AttackComponent(PAttackDamage, PAttackLevel);
        this.name = PName;
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
        lifeComponent.Die();
    }

    @Override
    public void DoDamage(IDamageable PTarget) {
        attackComponent.DoDamage(PTarget);
    }

    @Override
    public void DoDefense() {
        lifeComponent.DoDefense();
    }

    @Override
    public void EndTurn() {
        lifeComponent.SetIsDefending(false);
    }

    public boolean IsDead(){
        return !this.lifeComponent.IsAlive();
    }

    public void DebugStatus() {
        System.out.println(this.name + " has Life: "+ lifeComponent.GetLife());
    }

    public void GainXP(int PXpAmount) {
        this.experienceAmount += PXpAmount;
        if(experienceAmount >= currentExperienceCap){
            LevelUp();
        }
    }

    private void LevelUp() {
        this.level += 1;
        this.currentExperienceCap += 10;
        this.experienceAmount = 0;
        lifeComponent.UpLife();
        System.out.println("You need to level ur defense or attack:");
        System.out.println("Press 1 for defense or 2 for attack");
        Scanner _sc = new Scanner(System.in);
        int _result = _sc.nextInt();
        if (_result == 0){
            lifeComponent.UpDefense();
        }else{
            attackComponent.UpAttack();
        }
        _sc.close();
    }

}
