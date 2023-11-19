package test;
import java.util.*;


public class PrisonerDilema {
    /*
    Iterative prisoner's dilemma

    4 players in the simulation
    Player 1: Always cooperates
    Player 2: Always defects
    Player 3: tit-for-tat strategy (copies opponent's decision from previous round)
    Player 4: gradual tit-for-tat (has a 2-round apology period and copies the opponent's
    decision for several rounds)
*/
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<Player>();
        // players.add(new Player(0, 0));
        PrisonerDilema prisonerDilema = new PrisonerDilema();
        players.add(prisonerDilema.new Player(0, 1));
        // players.add(new Player(0, 2));
        players.add(prisonerDilema.new Player(0, 3));

        for (int i = 0; i < players.size(); i++) {
            Player p1 = players.get(i);
            for (int j = i + 1; j < players.size(); j++) {
                Player p2 = players.get(j);
                boolean p1Prev = true;
                boolean p2Prev = true;
                for (int k = 0; k < 10; k++) {
                    boolean p1C = p1.getDecision(p2Prev);
                    boolean p2C = p2.getDecision(p1Prev);
                    if (p1C && p2C) {
                        p1.score += 3;
                        p2.score += 3;
                    } else if (p1C && !p2C) {
                        p2.score += 5;
                    } else if (!p1C && p2C) {
                        p1.score += 5;
                    } else {
                        p1.score++;
                        p2.score++;
                    }
                    p1Prev = p1C;
                    p2Prev = p2C;
                    System.out.println("Round " + k);
                    System.out.println("Player " + i + " score: " + p1.score);
                    System.out.println("Player " + j + " score: " + p2.score);
                    System.out.println("Player " + i + " decision: " + p1C);
                    System.out.println("Player " + j + " decision: " + p2C);
                    System.out.println();
                }
                players.set(i, p1);
                players.set(j, p2);
            }
        }

        for (int i = 0; i < players.size(); i++) {
            System.out.println("Player " + i + " score: " + players.get(i).score);
        }
    }


    public class Player {
        int score;
        int strategy;
        int defectPeriods;
        int periodIndex;

        public Player(int score, int strategy) {
            this.score = score;
            this.strategy = strategy;
            defectPeriods = 0;
            periodIndex = -1;
        }

        public boolean getDecision(boolean oppPrevC) {
            if (strategy == 0) { // Always C
                return true;
            } else if (strategy == 1) { // Always D
                return false;
            } else if (strategy == 2) { // tit for tat
                return oppPrevC;
            } else { // gradual tft
                if (periodIndex > -1) {
                    periodIndex++;
                    if (periodIndex > defectPeriods + 2) {
                        periodIndex = -1;
                    }
                    if (periodIndex >= defectPeriods) { // apology period, coop
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (!oppPrevC) {
                        defectPeriods++;
                        periodIndex = 0;
                    }
                    return oppPrevC;
                }
            }
        }
    }

}
