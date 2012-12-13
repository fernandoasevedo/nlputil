package nlputil.translate.bing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Classe que encapsula métodos para autenticação na API do BingTanslator
 * 
 * @author fernando
 *
 */
public class BingAuth {

	/**
	 * Atributo que armazena o valor padrão para escopo do cliente da aplicação
	 */
	public static final String default_scop = "http://api.microsofttranslator.com";

	/**
	 * Método privado que encapsula o procedimento para requisição do token de acesso
	 * 
	 * @param clientId uma {@link String} representando o id do cliente
	 * @param clientSecret uma {@link String} representando o código secreto do cliente
	 * @param scope uma {@link String} representando o escopo da aplicação
	 * 
	 * @return {@link String} contendo o token de acesso ou null caso os parâmetros não sejam válidos
	 * 
	 * @throws IOException Este método é embasado em acesso online, então, retorna-se exceções quando ocorre algum erro de acesso
	 */
	private static String getToken( String clientId, String clientSecret, String scope) throws IOException{
				
		String data = URLEncoder.encode("grant_type", "UTF-8")+"=" + URLEncoder.encode("client_credentials", "UTF-8");
		data+="&"+ URLEncoder.encode("client_id", "UTF-8")+"=" + URLEncoder.encode( clientId , "UTF-8");
		data+="&"+ URLEncoder.encode("client_secret", "UTF-8")+"=" + URLEncoder.encode( clientSecret , "UTF-8");
		data+="&"+ URLEncoder.encode("scope", "UTF-8")+ "=" + scope;
		
		//System.out.println( data );
		
		URL url = new URL("https://datamarket.accesscontrol.windows.net/v2/OAuth2-13/");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestMethod("POST");
		conn.setDoOutput( true );
		
		OutputStreamWriter writer = new OutputStreamWriter( conn.getOutputStream() );
		writer.write( data );
		writer.flush();
		
		
		//Resposta
		BufferedReader reader = new BufferedReader( new InputStreamReader(conn.getInputStream()));
		String line;
		String token = "";
		while( (line = reader.readLine()) != null )
			token+= line ;
		
		
		writer.close();
		reader.close();
		
		return token;
	}
	
	/**
	 * Método que retorna um token de acesso à API do BingTranslator para respectivos parâmetros: id do cliente, 
	 * código secreto do cliente e escopo do cliente. 
	 * 
	 * Obs.: Todos esses parâmetros podem ser encontrados na painel de controle da api do Bing 
	 * 
	 * @param client_id uma {@link String} representando o id do cliente
	 * @param client_secret uma {@link String} representando o código secreto do cliente
	 * @param scope uma {@link String} representando o escopo da aplicação
	 * 
	 * @return {@link String} contendo o token de acesso ou null caso os parâmetros não sejam válidos
	 * 
	 * @throws IOException Este método é embasado em acesso online, então, retorna-se exceções quando ocorre algum erro de acesso
	 */
	public static String accessToken( String client_id, String client_secret, String scope ) throws IOException{
		
		String acess_token = "";		
		acess_token =  getToken( client_id, client_secret, scope ).split(",")[ 0 ].split(":")[ 1 ];		
		
		//É necessário acrescentar o préfixo 'Bearer ' ao token de acesso
		return "Bearer " + acess_token.substring( 1, acess_token.length() -1 );
	}
	
}
