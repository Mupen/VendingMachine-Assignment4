package se.lexicon.daniel.vending_machine.assignment4;
import se.lexicon.daniel.vending_machine.assignment4.controller.ConsoleMenuController;

/**
 * Hello world!
 *
 */

public class Main {
	static ConsoleMenuController ui = new ConsoleMenuController();
	public static void main(String[] args) {
    	while(ui.isRunning()) {
    		ui.run();
    		
    	}
	}
}

