package javab.ex06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


class WritePokemon{
	public static void main(String[] args){ 
		try{
	
			FileReader fr = new FileReader("pokemon.dat");
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter("pokemon10.res");
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for(int i = 0; i < 251; i++){ 
				String str= br.readLine(); 
				
				if(i%10 == 0) {
					
					pw.println(str);
				}
			}
			br.close(); 
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}