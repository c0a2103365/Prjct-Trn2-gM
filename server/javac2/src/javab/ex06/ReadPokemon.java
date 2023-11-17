package javab.ex06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadPokemon {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("pokemon.dat");
			BufferedReader br = new BufferedReader(fr);
			
			for(int i=0;i<251;i++) {
				String str = br.readLine();
				if(i%10==0) {
					System.out.println(str);
				}
			}
		}catch(IOException e) {
			System.out.println(e);
		}
	}

}
