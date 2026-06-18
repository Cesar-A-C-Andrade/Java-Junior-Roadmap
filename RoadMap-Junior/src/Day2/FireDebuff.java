package Day2;

public class FireDebuff implements IDebuff{

    private int roundsLeft = 0;
    private int damage = 0;

    public FireDebuff(int PRoundsQuantity, int PDamage) {
        this.roundsLeft = PRoundsQuantity;
        this.damage = PDamage;
    }


    @Override
    public void ApplyDebuff(IDamageable PTarget) {
        PTarget.TakeDamage(this.damage);
        roundsLeft -= 1;
    }

    @Override
    public int RoundsLeft() {
        return this.roundsLeft;
    }
}
