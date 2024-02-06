import Nim.Nim;
import Nim.NimPlayer;

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

        var playerOne = new NimPlayer("Erik", 23);
        var playerTwo = new NimPlayer("Per", 28);

        var nim = new Nim(10, playerOne, playerTwo);

        System.out.printf("%s, select your pile. Select between %s, %s and %s%n",
                nim.getCurrentPlayer().getName(), pileList.get(0), pileList.get(1), pileList.get(2));

        var playerOnePile = Integer.parseInt(reader.readLine());
        playerOne.selectPile(nim.getPile(playerOnePile - 1));
        pileList.remove(Integer.valueOf(playerOnePile));

        System.out.printf("%s, select your pile: Select between %s, %s%n", playerTwo.getName(), pileList.get(0), pileList.get(1));
        var playerTwoPile = Integer.parseInt(reader.readLine());
        playerTwo.selectPile(nim.getPile(playerTwoPile - 1));

        while (!nim.isGameOver()) {
            System.out.printf("How many piles do you want to withdraw player %s?%n", nim.getCurrentPlayer().getName());
            var pilesToDraw = Integer.parseInt(reader.readLine());

            try {
                nim.removePieces(nim.getCurrentPlayer(), pilesToDraw);
                nim.changeCurrentPlayer();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                continue;
            }

            System.out.println(nim);
        }
        displayWinnerAsciiArt(nim.getCurrentPlayer());
    }

    private static void displayWinnerAsciiArt(NimPlayer winner) {
        System.out.printf("Congratulations! Player %s is the winner! You're a Nim master!%n", winner.getName());

        System.out.println("                                       .                                        ");
        System.out.println("              . .                     -:-             .  .  .                   ");
        System.out.println("            .'.:,'.        .  .  .     ' .           . \\ | / .                 ");
        System.out.println("            .'.;.`.       ._. ! ._.       \\          .__\\:/__.                ");
        System.out.println("             `,:.'         ._\\!/_.                     .';`.      . ' .        ");
        System.out.println("             ,'             . ! .        ,.,      ..======..       .:.          ");
        System.out.println("            ,                 .         ._!_.     ||::: : | .        ',         ");
        System.out.println("     .====.,                  .           ;  .~.===: : : :|   ..===.            ");
        System.out.println("     |.::'||      .=====.,    ..=======.~,   |\"|: :|::::::|   ||:::|=====|     ");
        System.out.println("  ___| :::|!__.,  |:::::|!_,   |: :: ::|\"|l_l|\"|:: |:;;:::|___!| ::|: : :|    ");
        System.out.println(" |: :|::: |:: |!__|; :: |: |===::: :: :|\"||_||\"| : |: :: :|: : |:: |:::::|    ");
        System.out.println(" |:::| _::|: :|:::|:===:|::|:::|:===F=:|\"!/|\\!\"|::F|:====:|::_:|: :|::__:|   ");
        System.out.println(" !_[]![_]_!_[]![]_!_[__]![]![_]![_][I_]!//_:_\\\\![]I![_][_]!_[_]![]_!_[__]!    ");
        System.out.println(" -----------------------------------\"---''''```---\"-----------------------    ");
        System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |= _ _:_ _ =| _ _ _ _ _ _ _ _ _ _ _ _      ");
        System.out.println("                                     |=    :    =|                NIM           ");
        System.out.println("_____________________________________L___________J________________________      ");
        System.out.println("--------------------------------------------------------------------------      ");
    }
}