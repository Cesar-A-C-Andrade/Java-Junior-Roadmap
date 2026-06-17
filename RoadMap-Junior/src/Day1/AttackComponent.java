package Day1;

public class AttackComponent {

    private int baseAttackPower = 10;
    private int attackLevel = 1;

    public AttackComponent(int PBaseAttackPower, int PAttackLevel){
        this.baseAttackPower = PBaseAttackPower;
        this.attackLevel = PAttackLevel;
    }

    public void DoDamage(IDamageable PTarget) {
        try{
            System.out.println("Attacking the enemy");
            PTarget.TakeDamage(CalculateDamage());
        } catch (Exception e) {
            System.out.println("The target does not implements IDamageable");
        }
    }

    public void UpAttack() {
        attackLevel += 1;
    }

    private int CalculateDamage() {
        return this.baseAttackPower + this.attackLevel;
    }


}
