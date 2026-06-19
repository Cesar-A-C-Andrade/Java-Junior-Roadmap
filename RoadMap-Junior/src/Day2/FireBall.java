package Day2;

public class FireBall implements IBaseAttack {

    private int fireDamage;
    private int debuffRounds;
    private String name = "FireBall";

    public FireBall(int PFireDamage, int PDebuffRounds) {
        this.fireDamage = PFireDamage;
        this.debuffRounds = PDebuffRounds;
    }

    @Override
    public void Attack(IDamageable PTarget, int PAttackLevel) {
        PTarget.TakeDamage(CalculateDamage(PAttackLevel), new FireDebuff(this.debuffRounds, this.fireDamage));
    }

    @Override
    public int CalculateDamage(int PAttackLevel) {
        return fireDamage + PAttackLevel;
    }

    @Override
    public String GetAttackName() {
        return name;
    }
}
