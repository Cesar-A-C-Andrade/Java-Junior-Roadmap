package Day2;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class CharacterAttackComponent extends AttackComponent{
    ArrayList<IBaseAttack> attacks;


    public CharacterAttackComponent(int PBaseAttackPower, int PAttackLevel) {
        super(PBaseAttackPower, PAttackLevel);
        this.attacks = new ArrayList<>();
        this.attacks.add(new FireBall(2, 3));
        this.attacks.add(new NormalAttack(3));
    }

    @Override
    public void DoDamage(IDamageable PTarget) {
        Scanner _sc = new Scanner(System.in);
        System.out.println("Chose what attack u want to make");
        System.out.println("Press: ");
        for (int _attackIndex = 0; _attackIndex < attacks.size(); _attackIndex++){
            System.out.println((_attackIndex + 1) + ": " + attacks.get(_attackIndex).GetAttackName());
        }
        int attack = _sc.nextInt();
        attack -= 1;
        attacks.get(attack).Attack(PTarget, this.attackLevel);

    }
}
