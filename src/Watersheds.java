import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Watersheds {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("C:/Users/Adisa/workspace/2009_Qual/src/B-small-practice.in");
			
			DataInputStream in = new DataInputStream(fin);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			int T = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < T; i++) {
				
				String[] mapSize = br.readLine().split(" ");
				
				int H = Integer.parseInt(mapSize[0]);
				int W = Integer.parseInt(mapSize[1]);
				
				int[][] altitudes = new int[H][W];
				
				Pair[][] sinks = new Pair[H][W];
				
				for (int j = 0; j < H; j++) {
					String[] altStrings = br.readLine().split(" ");
					
					for (int k = 0; k < W; k ++){
						
						altitudes[j][k] = Integer.parseInt(altStrings[k]);						
						sinks[j][k] = null;
					}
				}
				
				for (int j = 0; j < H; j++) {//ickyyy
					
					for (int k = 0; k < W; k++) {
						
						int[] neighbors = {10000, 10000, 10000, 10000};
						Pair[] nCoords = {new Pair(j -1, k), new Pair(j, k+1), new Pair(j+1, k), new Pair(j, k-1)};
								
						if (j - 1 > -1) {
							neighbors[0] = altitudes[j - 1][k];
						}						
						if (k + 1 < W) {
							neighbors[1] = altitudes[j][k + 1];
						}					
						if (j + 1 < H) {
							neighbors[2] = altitudes[j + 1][k];
						}
						if (k - 1 > -1) {
							neighbors[3] = altitudes[j][k - 1];
						}
						
						int min = altitudes[j][k];
						int min_index = -1;
						
						for (int m = 0; m < 4; m++){
							if (neighbors[m] < min) {
								min = neighbors[m];
								min_index = m;
							}
						}
						
						if (min_index > -1){
							sinks[j][k] = nCoords[min_index];
						}
					}
				}
				
				char[][] basins = new char[H][W];
				
				int basinChar = 'a';
				
				char[][] sinkChar = new char[H][W];
				
				for (int j = 0; j < H; j++) {
					
					for (int k = 0; k < W; k++) {
						
						if (basins[j][k] == '\u0000'){
							
							List<Pair> basin = new ArrayList<Pair>();
							
							Pair cur = new Pair(j, k);
							basin.add(cur);
							
							while(sinks[cur.left][cur.right] != null){
								cur = sinks[cur.left][cur.right];
								basin.add(cur);
							}
							
							if (sinkChar[cur.left][cur.right] == '\u0000') {
								sinkChar[cur.left][cur.right] = (char) basinChar;
								
								for (int b = 0; b < basin.size(); b++) {
									Pair pair = basin.get(b);
									
									basins[pair.left][pair.right] = (char) basinChar;
								}
								
								basinChar++;
							} else {
								char bChar = sinkChar[cur.left][cur.right];
								
								for (int b = 0; b < basin.size(); b++) {
									Pair pair = basin.get(b);
									
									basins[pair.left][pair.right] = (char) bChar;
								}
							}
						}
					}
				}
				
				System.out.println("Case #" + Integer.toString(i + 1) + ": ");
				for (int j = 0; j < H; j++) {
					StringBuilder sb = new StringBuilder();
					
					for (int k = 0; k < W; k++){
						sb.append(basins[j][k]);
						
						if (k != W - 1){
							sb.append(" ");
						}
					}
					System.out.println(sb.toString());
				}
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static class Pair {
		
		private final int left;
		private final int right;
		
		public Pair(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}

}
