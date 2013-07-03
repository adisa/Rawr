import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class AlienLang {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("C:/Users/Adisa/workspace/2009_Qual/src/A-large-practice.in");
			
			DataInputStream in = new DataInputStream(fin);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			String[] headers = br.readLine().split(" ");
			
			int L = Integer.parseInt(headers[0]);
			int D = Integer.parseInt(headers[1]);
			int N = Integer.parseInt(headers[2]);
			
			String[] words = new String[D];
			
			for (int i = 0; i < D; i++){
				words[i] = br.readLine();
			}
			
			for (int i = 0; i < N; i++) {
				
				ArrayList<HashSet<Character>> charSets = new ArrayList<HashSet<Character>>(L);
				for (int j = 0; j < L; j++){
					charSets.add(new HashSet<Character>());
				}
				
				String line = br.readLine();
				StringReader sr = new StringReader(line);
				
				int index = 0;
				boolean move = true;
				
				for (int j = 0; j < line.length(); j++){
					char next = (char) sr.read();
					
					if (next == '(') {
						move = false;
					} else if (next == ')') {
						move = true;
					} else {
						charSets.get(index).add(next);
					}
					
					if (move){
						index++;
					}
				}
				
				int count = 0;
				
				for (int j = 0; j < D; j++) {
					String word = words[j];
					
					boolean match = true;
					
					for (int k = 0; k < L; k++){
						
						if(!charSets.get(k).contains(word.charAt(k))){
							match = false;
							break;
						}
					}
					
					if(match){
						count++;
					}
				}
				
				System.out.println("Case #" + Integer.toString(i+1) + ": " + Integer.toString(count));
			}
			
			br.close();
		
		} catch (IOException e){
			e.printStackTrace();
		}

	}

}
