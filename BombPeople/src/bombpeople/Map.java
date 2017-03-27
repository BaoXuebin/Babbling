package bombpeople;

public class Map {
	public static int[][] map = new int[19][15];
	public Map() {
		map[1][1] = 1;
		map[1][3] = 1;
		map[4][4] = 1;
		map[7][7] = 1;
		map[6][7] = 1;
		map[7][8] = 1;
		map[6][8] = 1;
		map[10][12] = 2;
		map[18][13] = -1;
	}
//	public void setMap(int[][] map) {
//		this.map = map;
//	}
	public void setSingerMap(int x,int y,int z){
		map[x][y] = z;
	}
}
