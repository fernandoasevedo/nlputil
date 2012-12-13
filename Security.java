package nlputil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Classe utilizada para controlar o mecanismo de seguraça com chaves de acesso de serviços de terceiros.
 * Esta classe faz com que informações extras necessárias para utilização 
 * @author fernandoasevedo
 *
 */
public class Security {
	private static Hashtable<String, String> security_infos;
	
	public static void read() throws IOException{
		security_infos = new Hashtable<String, String>();
		
		File file = new File("config");
		
		if( !file.exists())
			return;
		
		BufferedReader reader = new BufferedReader( 
				new FileReader( 
						new File( file.getAbsolutePath()) ) );

		String line;
		String split[];
		while( (line = reader.readLine() ) != null ){
			split = line.split(":");
			if( split.length > 1 )
				security_infos.put( split[ 0 ], split[ 1 ] );
		}
		
		reader.close();

	}
	
	public static String getInfo( String name_info ){
		
		if( security_infos == null ) return null;
		
		return security_infos.get( name_info );
	}
}
