package Day2;

import java.util.ArrayList;

public interface IDamageable {
    public void TakeDamage(int PDamageAmount, IDebuff... PDebuffs);
    public void RestoreLife(int PLifeRestored);
    public void Die();

}
