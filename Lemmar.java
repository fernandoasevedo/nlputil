package nlputil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

//import lematizador.Main;

public class Lemmar {

	public static String lemma( String word , String tag) throws IOException{
		
		//Salvando a saída padrão do sistema		
		OutputStream out_strem = System.out;
		String lemma = word;
		try{		
			
			//Alterando a entrada e saída padrão do sistema, para que o mxpost possa rodar normalmente
			File out = new File("file" + File.separator + "word_lemar.txt");
			out.createNewFile();
						
			System.setOut( new PrintStream( out ));
			
			//Chamando o lematizador				
			lematizador.Main.main( new String[]{ word , tag } );
			
			BufferedReader reader = new BufferedReader( 
					new InputStreamReader( new FileInputStream( out ), "UTF-8") );
			
			lemma = reader.readLine().split("/")[ 1 ];
			
		}catch (IOException e) {
			e.printStackTrace();
			return word;
		}
		//Retornando a saída padrão do programa
		System.setOut( (PrintStream) out_strem );
		
		
		return lemma;		
	}
}
