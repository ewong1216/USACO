package interactive;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Player extends Trainer{
	private Bag bag = new Bag();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private class Bag implements ActionListener{
		private String[][] bag = new String[20][8];
		JFrame f = new JFrame("Hello World");
		JMenuBar bar = new JMenuBar();
		JMenuItem items = new JMenuItem("Items");
		JMenuItem medicine = new JMenuItem("Medicine");
		JMenuItem pokeballs = new JMenuItem("Pokeballs");
		JMenuItem tmshms = new JMenuItem("TMs & HMs");
		JMenuItem berries = new JMenuItem("Berries");
		JMenuItem mail = new JMenuItem("Mail");
		JMenuItem battleitems = new JMenuItem("Battle Items");
		JMenuItem keyitems = new JMenuItem("Key Items");
		JTextArea stuff= new JTextArea(10, 10);
		public Bag(){
			for(int row = 0; row < bag.length; row++){
				for(int col = 0; col < bag[0].length; col++){
					bag[row][col] = col + row * bag[0].length + "";
				}
			}
			f.setSize(800, 300);
			f.setLocation(1125, 30);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setJMenuBar(bar);
			Container contentPane = f.getContentPane();
			items.addActionListener(this);
			medicine.addActionListener(this);
			pokeballs.addActionListener(this);
			tmshms.addActionListener(this);
			berries.addActionListener(this);
			mail.addActionListener(this);
			battleitems.addActionListener(this);
			keyitems.addActionListener(this);
			bar.add(items);
			bar.add(medicine);
			bar.add(pokeballs);
			bar.add(tmshms);
			bar.add(berries);
			bar.add(mail);
			bar.add(battleitems);
			bar.add(keyitems);
			stuff.setEditable(false);
			contentPane.add(new JScrollPane(stuff));
			f.setVisible(true);
		}
		
		public void actionPerformed(ActionEvent e){
			String s = "";
			int col = -1;
			if(e.getSource() == items)
				col = 0;
			else if(e.getSource() == medicine)
				col = 1;
			else if(e.getSource() == pokeballs)
				col = 2;
			else if(e.getSource() == tmshms)
				col = 3;
			else if(e.getSource() == berries)
				col = 4;
			else if(e.getSource() == mail)
				col = 5;
			else if(e.getSource() == battleitems)
				col = 6;
			else if(e.getSource() == keyitems)
				col = 7;
			for(int row = 0; row < bag.length; row++)
				s += bag[row][col] + "\n";
			stuff.setText(s);
		}
	}
}
