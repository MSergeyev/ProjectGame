package RolePlayingGame;

import RolePlayingGame.Herois.Goblin;
import RolePlayingGame.Herois.Hero;
import RolePlayingGame.Herois.Skelet;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.Scanner;


public class Realm {
    private static BufferedReader br;
    private static FantasyCharacter player = null;
    private static BattleScene battleScene = null;


    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        battleScene = new BattleScene();
        System.out.println("Enter character name: ");
        try {
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void commitFight() {
        battleScene.fight(player, createMonster(), new FightCallback() {
            public void fightWin() {
                System.out.println(String.format("%s победил! Теперь у вас %d опыта и %d золота, а также осталось %d едениц здоровья.", player.getName(), player.getXp(), player.getGold(), player.getHealthPoints()));
                System.out.println("Желаете продолжить поход или вернуться в город? (да/нет)");
                try {
                    command(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            public void fightLost() {

            }
        });
    }

    private static FantasyCharacter createMonster() {

        int random = (int) (Math.random() * 10);

        if (random % 2 == 0) return new Goblin(
                "Гоблин",
                50,
                10,
                10,
                100,
                20
        );
        else return new Skelet(
                "Скелет",
                25,
                20,
                20,
                100,
                10
        );
    }

    private static void command(String string) throws IOException {
        if (player == null) {
            player = new Hero(string, 100, 20, 20, 0, 0);
            System.out.println(String.format("Спасти наш мир от драконов вызвался %s! Да будет его броня крепка и бицепс кругл!", player.getName()));
            printNavigation();
        }
        switch (string) {
            case "1": {

                command(br.readLine());
            }
            break;
            case "2": {

                commitFight();
            }
            break;
            case "3": {

                System.exit(1);
            }
            break;
            case "да": {

                command("2");
            }
            case "нет": {

                printNavigation();
                command(br.readLine());
            }
        }
        command(br.readLine());
    }

    private static void printNavigation() {
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1. К Торговцу");
        System.out.println("2. В темный лес");
        System.out.println("3. Выход");
        System.out.println("Желаете продолжить поход или вернуться в город? (да/нет)");
        try {
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    interface FightCallback {
        void fightWin();

        void fightLost();
    }


}
