package Day1;

public class NormalAttack implements IBaseAttack{

    private int attackDamage = 0;


    @Override
    public void Attack(IDamageable PTarget) {
        PTarget.TakeDamage(attackDamage);
    }
}
