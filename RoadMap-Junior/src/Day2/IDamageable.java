package Day2;

import java.util.ArrayList;

public interface IDamageable {
    public void TakeDamage(int PDamageAmount, IDebuff... debuffs);
    public void RestoreLife(int PLifeRestored);
    public void Die();

}
