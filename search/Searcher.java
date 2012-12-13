/**
 * 
 */
package nlputil.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;

import javax.jws.WebResult;

/**
 * Classe abstrata que encapsula métodos de busca 
 * 
 * @author fernando
 *
 */
public abstract class Searcher {

	private String searcher_name;
	
	public Searcher( String searcher_name ) {
		this.searcher_name = searcher_name;
	}
	
	public String toString(){
		return this.searcher_name;
	}

	/**
	 * Método que retorna um {@link ArrayList} contendo todos os resultados retornados
	 * pela query passada como parâmetro
	 * 
	 * @param query uma {@link String} representando a query de busca
	 * 
	 * @return um {@link ArrayList} contendo todos os resultados retornados
	 * 
	 * @throws SearchException caso ocorra algum erro de acesso ou parâmetros inválidos
	 */
	public abstract ArrayList<WebResult> search( String query ) throws SearchException;
	
	
	/**
	 * Método que retorna apenas a quantidade de resultados retornados pela query de busca
	 * 
	 * @param query uma {@link String} representando a query de busca
	 * 
	 * @return o valor numérico representando a quantide de resultados retornados pela busca
	 * 
	 * @throws SearchException caso ocorra algum erro de acesso ou parâmetros inválidos
	 */
	public abstract int getNumberResults( String query ) throws SearchException;
	

	public String response( HttpURLConnection conn) throws IOException {
	
		BufferedReader reader = new BufferedReader( new InputStreamReader( conn.getInputStream() ));
		String response = "";
		String line = "";
		while( (line = reader.readLine()) != null )
			response += line;
		
		reader.close();
		return response;
	}
}
