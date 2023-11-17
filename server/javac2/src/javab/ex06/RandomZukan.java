package javab.ex06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
class RandomZukan{
	public static void main(String[] args){
		Random r = new Random();
		int ID = r.nextInt(251);
		try{
			FileReader fr = new FileReader("pokemonDetail.dat");
			BufferedReader br = new BufferedReader(fr);
			for(int i = 0; i < 251; i++){
				String str = br.readLine();

			if(i == ID) System.out.println(str);
		}
			br.close();
		}catch(IOException e){
			System.out.println(e);
		}
	}
}
