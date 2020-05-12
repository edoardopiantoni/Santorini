package it.polimi.ingsw;

import it.polimi.ingsw.view.client.cli.Cli;
import it.polimi.ingsw.view.client.gui.Gui;
import java.util.Scanner;

public class App {

    private static final String TITLE = "\n\u001B[31m" +
            "             ___       ___  ___          ___    _____   ___      ___               _____  ___   ___                  |_|  |_|\n" +
            " \\   \\/   / |    |    |    |   | |\\  /| |         |    |   |    |       /\\   |\\  |   |   |   | |   | | |\\  | |     ___________\n" +
            "  \\  /\\  /  |--  |    |    |   | | \\/ | |--       |    |   |    |---|  /--\\  | \\ |   |   |   | |___| | | \\ | |     |   _|_   |\n" +
            "   \\/  \\/   |___ |___ |___ |___| |    | |___      |    |___|     ___| /    \\ |  \\|   |   |___| |  \\  | |  \\| |      |_______|\n\n\u001B[0m";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("INSERT:\n>>> [1] CLI\n>>> [2] GUI\n");

        String keyboard = input.nextLine();
        while (!keyboard.equals("1") && !keyboard.equals("2"))
        {
            System.out.print("\nWRONG NUMBER. PLEASE, REINSERT YOUR CHOOSE: ");
            keyboard = input.nextLine();
        }

        if(keyboard.equals("1")) {
            Cli cli = new Cli();
            cli.start();
        }
        else {
            Gui gui = new Gui();
            gui.avvio();
        }

    }

}
