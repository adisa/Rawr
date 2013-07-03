import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class AlienLanguage {

	public static ArrayList<ArrayList<Character>> chars = new ArrayList<ArrayList<Character>>();
	public static HashSet<String> words = new HashSet<String>();
	public static HashSet<String> firstTwo = new HashSet<String>();
	
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("C:\\Users\\Adisa\\workspace\\2009_Qual\\src\\A-small-practice.in");
			
			DataInputStream in = new DataInputStream(fin);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			String[] headers = br.readLine().split(" ");
			
			int L = Integer.parseInt(headers[0]);
			int D = Integer.parseInt(headers[1]);
			int N = Integer.parseInt(headers[2]);			
			
			for (int i = 0; i < D; i++){
				String word = br.readLine();
				words.add(word);
		
				
			}
			
			
			/*for (int i = 0; i < N; i++) {
				
				//list of array characters
				for (int j = 0; j < L; j++) {
					chars.add(new ArrayList());
				}
				
				String possible = br.readLine();
				
				StringReader sr = new StringReader(possible);
				
				boolean next = true;
				int index = 0;
				
				for (int j = 0; j < possible.length(); j++) {
					char nextChar = (char) sr.read();
					
					if (nextChar == '(') {
						next = false; 
					} else if (nextChar == ')') {
						next = true; 
					} else {
						chars.get(index).add(nextChar);
					}
					
					if (next){
						index++;
					}
				}
				
				ArrayList<String> b1 = subWords(0,3);
				ArrayList<String> b2 = subWords(3,6);
				ArrayList<String> b3 = subWords(6,L);
				
				for (int j = 0; j < b1.size(); j++){	
					if(!w1.contains(b1.get(j))){
						b1.remove(j);
					}
				}
				
				for (int j = 0; j < b2.size(); j++){	
					if(!w2.contains(b2.get(j))){
						b2.remove(j);
					}
				}
				
				for (int j = 0; j < b3.size(); j++){	
					if(!w3.contains(b3.get(j))){
						b3.remove(j);
					}
				}
				
			
				int count = 0;
				
				for (int j = 0; j < b1.size(); j++){
					for (int k = 0; k < b2.size(); k++) {
						for (int l = 0; l < b3.size(); l++){
							
							if (words.contains(b1.get(j) + b2.get(k) + b3.get(l))) {
								count += 1;
							}
						}
					}
					
				}
				
				System.out.println("Case #" + Integer.toString(i+1) + ": " + Integer.toString(count));
			}*/
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<String> subWords(int beg, int end){
		int length = end - beg;
		
		ArrayList<String> build = new ArrayList<String>(Arrays.asList(""));
		
		for (int i = 0; i < length; i++){
			ArrayList<String> temp = new ArrayList<String>();
			
			ArrayList<Character> nextCharSet = chars.get(beg + i);
			
			for (int j = 0; j < build.size(); j++){
				
				for (int k = 0; k < nextCharSet.size(); k ++) {
					String word = build.get(j) + nextCharSet.get(k);
					temp.add(word);
				}
			}
			build.clear();
			build.addAll(temp);
		}
		return build;
	}
}
