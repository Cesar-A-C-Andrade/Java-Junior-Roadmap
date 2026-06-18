package Day2;

public class AttackComponent {

    private int baseAttackPower = 10;
    protected int attackLevel = 1;


    public AttackComponent(int PBaseAttackPower, int PAttackLevel){
        this.baseAttackPower = PBaseAttackPower;
        this.attackLevel = PAttackLevel;
    }

    public void DoDamage(IDamageable PTarget) {
        System.out.println("Attacking the enemy");
        PTarget.TakeDamage(CalculateDamage());
    }

    public void UpAttack() {
        attackLevel += 1;
    }

    private int CalculateDamage() {
        return this.baseAttackPower + this.attackLevel;
    }


}
