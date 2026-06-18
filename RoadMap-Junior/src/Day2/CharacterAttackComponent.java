package Day2;

import java.util.ArrayList;
import java.util.Scanner;

public class CharacterAttackComponent extends AttackComponent{

    ArrayList<IBaseAttack> attacks;


    public CharacterAttackComponent(int PBaseAttackPower, int PAttackLevel) {
        super(PBaseAttackPower, PAttackLevel);
        this.attacks = new ArrayList<>();
        this.attacks.add(new FireBall(2, 2));
        this.attacks.add(new NormalAttack(3));
    }

    @Override
    public void DoDamage(IDamageable PTarget) {
        Scanner _sc = new Scanner(System.in);
        System.out.println("Chose what attack u want to make");
        System.out.println("Press 1 to Normal Attack or 2 to FireBall Attack");
        int attack = _sc.nextInt();
        if (attack == 1){
            attacks.get(1).Attack(PTarget, this.attackLevel);
        }else{
            attacks.getFirst().Attack(PTarget, this.attackLevel);
        }
    }
}
