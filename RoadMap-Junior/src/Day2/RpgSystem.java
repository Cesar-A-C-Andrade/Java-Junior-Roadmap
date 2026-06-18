package Day2;

import java.util.Scanner;

public class RpgSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your player name");
        String playerName = sc.nextLine();

        BaseCharacter player = new BaseCharacter(playerName, 10, 3, 2, 1, 1, 1);

        int _choice = 0;
        int _continue = 1;
        int _phaseLevel = 1;
        do{
            Enemy _enemy = new Enemy(_phaseLevel,7 * _phaseLevel, 3, 1, _phaseLevel, _phaseLevel, _phaseLevel,"Cleber");
            do {
                _enemy.DebugStatus();
                player.DebugStatus();
                System.out.println("Make ur choice, 1: Attack, 2: Defense");
                _choice = sc.nextInt();
                if (_choice == 1){
                    _enemy.DoAction(player);
                    player.DoDamage(_enemy);
                }else{
                    player.DoDefense();
                    _enemy.DoAction(player);
                }
                player.EndTurn();
                _enemy.EndTurn();
                if(player.IsDead()){
                    System.out.println("You Died, good bye");
                    return;
                }
            }while (_enemy.IsAlive());
            player.GainXP(_enemy.DropXP());
            _phaseLevel += 1;
            System.out.println("Want the next enemy? Press 1 to continue or 0 to end the game");
            _continue = sc.nextInt();
        }while (_continue == 1);

    }
}
