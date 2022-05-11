package greenbananas.game;

import java.util.ArrayList;

public class LevelSuperclass {
	
	ArrayList<String> levels=new ArrayList<>();
	String key;
	
	
	
	public LevelSuperclass(String key) {
		this.key=key;
		levels.add("2a50b50c100d100e200f200g");
		levels.add("3a50b50c100d100e200f200g");
		levels.add("4a50b50c100d100e200f200g");
		levels.add("5a50b50c100d100e200f200g");
		levels.add("6a50b50c100d100e200f200g");
		levels.add("7a50b50c100d100e200f200g");
		levels.add("8a50b50c100d100e200f200g");
		levels.add("9a50b50c100d100e200f200g");
		
	}
	
	public int numOfBlocksGenerator(String level) {
		String sub=level.substring(0,level.indexOf('a'));
		return Integer.parseInt(sub);
	}
	
	public int[] coordinatesForStorage(String level) {
		int[] coordinates=new int[6];
		
		coordinates[0]=Integer.parseInt(level.substring(level.indexOf('a')+1),level.indexOf('b'));
		coordinates[1]=Integer.parseInt(level.substring(level.indexOf('b')+1),level.indexOf('c'));
		coordinates[2]=Integer.parseInt(level.substring(level.indexOf('c')+1),level.indexOf('d'));
		coordinates[3]=Integer.parseInt(level.substring(level.indexOf('d')+1),level.indexOf('e'));
		coordinates[4]=Integer.parseInt(level.substring(level.indexOf('e')+1),level.indexOf('f'));
		coordinates[5]=Integer.parseInt(level.substring(level.indexOf('f')+1),level.indexOf('g'));
		
		return coordinates;
		
	}
	
}
