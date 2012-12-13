package nlputil.search.bing;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jws.WebResult;

import org.apache.commons.codec.binary.Base64;

import nlputil.search.SearchException;
import nlputil.search.Searcher;


public class BingSearch extends Searcher{
	private String acount_key;
	private String response;
	private Hashtable<String, String> cache;
	
	public BingSearch( String acount_key ) {
		super( "Bing" );
		this.response = "";
		
		this.acount_key = acount_key;
		cache = new Hashtable<String, String>();
	}
	
	@Override
	public ArrayList<WebResult> search(String query) throws SearchException {
		
		if ( cache.contains( query  ))
			response = cache.get( query );
		
		else{
			try {
				
				URL url = new URL (
						"https://api.datamarket.azure.com/Bing/Search/Composite?" +
						"WebSearchOptions='DisableQueryAlterations'" +
						"&Sources='web'" +
						"&Query='" + URLEncoder.encode( query ) + "'");
				
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				
				//Necessário para enviar os dados de autenticação
				connection.setDoInput( true );
				
				/*
				 * Codificando com base64, disponível pela biblioteca apache,
				 * e enviados os dados de autenticação
				 */			 
				byte[] password = (this.acount_key+ ":"+ this.acount_key).getBytes();
				Base64 base_encode = new Base64();
				connection.setRequestProperty(
						"Authorization", 
						"Basic "+ base_encode.encodeAsString( password ) );
				
				this.response = super.response( connection );		
				
				//System.out.println( acount_key + "\n" + url.toString() + "\n " + response + "\n\n");			
				
			} catch (MalformedURLException e) {			
				e.printStackTrace();
				
			} catch (IOException e) {			
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	public int getNumberResults(String query) throws SearchException {
		
		if ( !cache.contains( query  ))
			search( query );
		else
			response = cache.get( query );
		
		
		Pattern total_result = Pattern.compile("\\d+</d:WebTotal>");
		Matcher matcher = total_result.matcher( response );
		
		if( matcher.find() )
			return Integer.parseInt( matcher.group().split("<")[ 0 ] );
		
		return 0;
	}
		
}
