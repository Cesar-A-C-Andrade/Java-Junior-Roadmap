package Day2;

public class NormalAttack implements IBaseAttack {

    private int attackDamage = 0;


    public NormalAttack(int PAttackDamage) {
        this.attackDamage = PAttackDamage;
    }

    @Override
    public void Attack(IDamageable PTarget, int PAttacKLevel) {

        PTarget.TakeDamage(CalculateDamage(PAttacKLevel));
    }

    @Override
    public int CalculateDamage(int PAttackLevel) {
        return this.attackDamage + PAttackLevel;
    }
}
