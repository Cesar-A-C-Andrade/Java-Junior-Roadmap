package Day2;

public interface IBaseAttack {

    public void Attack(IDamageable PTarget, int PAttackLevel);
    public int CalculateDamage(int PAttackLevel);
    public String GetAttackName();
}
