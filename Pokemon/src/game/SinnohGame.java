package game;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import pokemon.Pokemon;
import pokemonTypes.Grass;

public class SinnohGame{
	public static void main(String[] args){
		Pokemon turtwig = new Grass(1,5);
		System.out.println(turtwig);
	}
	
	private void battle(Pokemon p1, Pokemon p2){
		while(!p1.isFainted() && !p2.isFainted()){
			
		}
	}
}
