package adt;

public class ADTHashmap implements ADTHashmapInterface{

	private Integer size;
	private Strategy strategy;
	private Integer[][] map;
	
	private ADTHashmap(Integer size, Strategy strategy) {
		this.size = size;
		this.strategy = strategy;
		map = new Integer[size][2];
	}
	
	public static ADTHashmap create(Integer size, Strategy strategy) {
		return new ADTHashmap(size, strategy);
	}
	

	@Override
	public ADTHashmap insert(String word) {
		Integer i = Integer.parseInt(word);
		
		map[0][0] = i;
		map[0][1] = 0;
		return this;
	}

	@Override
	public Integer find(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString(){
		return "hashmap: key = " + map[0][0] + "value = " + map[0][1];
	}
	
	

}
