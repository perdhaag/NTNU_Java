import Nim.Nim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> pileList = new ArrayList<>(Arrays.asList(1, 2, 3));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        var nimGame = new Nim(10);
        int currentPlayer = 1;

        System.out.printf("Player 1: Select which pile you want to draw from. Select between %s, %s and %s%n", pileList.get(0), pileList.get(1), pileList.get(2));
        var playerOnePile = Integer.parseInt(reader.readLine());
        System.out.printf("Player 1 selected pile number %s%n", playerOnePile);

        pileList.remove(Integer.valueOf(playerOnePile));

        System.out.printf("Player 2: Select which pile you want to draw from. Select between %s, %s%n", pileList.get(0), pileList.get(1));
        var playerTwoPile = Integer.parseInt(reader.readLine());
        System.out.printf("Player 2 selected pile number %s%n", playerTwoPile);

        System.out.println(nimGame);

        while (!nimGame.isGameOver()) {

            System.out.printf("How many piles do you want to withdraw player %s?", currentPlayer);
            System.out.println();
            var number = Integer.parseInt(reader.readLine());

            try{
                nimGame.removePieces(number, currentPlayer == 1 ? playerOnePile - 1 : playerTwoPile - 1); //Take into account 0 index.
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                continue;
            }
            currentPlayer = (currentPlayer == 1) ? 2 : 1;
            System.out.println(nimGame);
        }

        displayWinnerAsciiArt(currentPlayer);
    }

    private static void displayWinnerAsciiArt(int winner) {
        System.out.printf("Congratulations! Player %d is the winner! You're a Nim master!%n", winner);

        System.out.println("                                       .");
        System.out.println("              . .                     -:-             .  .  .");
        System.out.println("            .'.:,'.        .  .  .     ' .           . \\ | / .");
        System.out.println("            .'.;.`.       ._. ! ._.       \\          .__\\:/__.");
        System.out.println("             `,:.'         ._\\!/_.                     .';`.      . ' .");
        System.out.println("             ,'             . ! .        ,.,      ..======..       .:.");
        System.out.println("            ,                 .         ._!_.     ||::: : | .        ',");
        System.out.println("     .====.,                  .           ;  .~.===: : : :|   ..===.");
        System.out.println("     |.::'||      .=====.,    ..=======.~,   |\"|: :|::::::|   ||:::|=====|");
        System.out.println("  ___| :::|!__.,  |:::::|!_,   |: :: ::|\"|l_l|\"|:: |:;;:::|___!| ::|: : :|");
        System.out.println(" |: :|::: |:: |!__|; :: |: |===::: :: :|\"||_||\"| : |: :: :|: : |:: |:::::|");
        System.out.println(" |:::| _::|: :|:::|:===:|::|:::|:===F=:|\"!/|\\!\"|::F|:====:|::_:|: :|::__:|");
        System.out.println(" !_[]![_]_!_[]![]_!_[__]![]![_]![_][I_]!//_:_\\\\![]I![_][_]!_[_]![]_!_[__]!");
        System.out.println(" -----------------------------------\"---''''```---\"-----------------------");
        System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |= _ _:_ _ =| _ _ _ _ _ _ _ _ _ _ _ _");
        System.out.println("                                     |=    :    =|                NIM");
        System.out.println("_____________________________________L___________J________________________");
        System.out.println("--------------------------------------------------------------------------");
    }
}
