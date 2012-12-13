package nlputil.translate.wordreference;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nlputil.translate.Translator;
import nlputil.translate.TranslateMethodException;

public class WordReferenceTranslate extends Translator{
	private String api_key;
	private String dictionary;
	private String version;
	
	private HashMap<String, ArrayList<String>> translator_cache;
	
	public WordReferenceTranslate( String api_key, String dictionary ){
		super("WordRerence-0.8");
		
		this.api_key = api_key;
		this.dictionary = dictionary;
		this.version = "0.8";
		
		this.translator_cache = new HashMap<String, ArrayList<String>>();
	}
	
	public void setVersion( String version ){
		this.version = version;
	}
	
	public void setDictionary( String dictonary ){
		this.dictionary = dictonary;
	}
		
	@Override
	public ArrayList<String> translateWord(String word)	throws TranslateMethodException {
	
		try{
			ArrayList<String> translates = null;
			
					
			//Verifica se a palavra está em cache
			if( this.translator_cache.containsKey( word ) )
				return this.translator_cache.get( word );
			
			URL url;
			url = new URL(
				"http://api.wordreference.com/"+
				this.version +"/" + 
				this.api_key+"/json/"+
				this.dictionary+"/"+
				URLEncoder.encode( word ));
		
			translates = new ArrayList<String>( 5 );
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			String response = response( conn );		
			String array[] = response.split("OtherSideEntries");
			
			//Padroes auxiliares
			Pattern word_patter = Pattern.compile("[a-z][a-z ]+");
			Pattern term_patter = Pattern.compile("term\" : \"[a-z ,]+\"");
					
			Pattern tag_patter = Pattern.compile("Translation\"[^}]+");
			Matcher tag_matcher;
			Matcher term_matcher;
			Matcher word_matcher;
			String aux;
			if( array.length > 0 ){
				//Capturando as tags de tradução
				tag_matcher = tag_patter.matcher( array[ 0 ]);
				
				while( tag_matcher.find() ){				
					//Capturando os termos
					aux = tag_matcher.group();
					term_matcher = term_patter.matcher( aux );
	
					while( term_matcher.find() ){
						//Pegando as palavras
						aux = term_matcher.group().split(":")[ 1 ];
						word_matcher = word_patter.matcher( aux  );
						
						while( word_matcher.find() ){
							aux = word_matcher.group();
							if( !translates.contains( aux ) )
								translates.add( aux );
						}
					}				
				}
			}
			
			tag_patter = Pattern.compile("OriginalTerm\"[^}]+");
			
			
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream("pten.dic", true ) , "utf-8") );
			
			writer.write( word + ":");
			for( String t : translates )
				writer.write( t + ",");		
			writer.newLine();
			writer.close();
			
			
			//Inserindo a nova tradução em cache
			this.translator_cache.put( word , translates );
			
			return translates;
		
		}catch (MalformedURLException e) {
			throw new TranslateMethodException( e.getMessage(), "translateWord" ,  super.toString() );
			
		} catch (IOException e) {
			throw new TranslateMethodException( e.getMessage(), "translateWord" ,  super.toString() );		
		}		
	}
	
	@Override
	public ArrayList<String> translateWord(String word, String tag)	throws TranslateMethodException {
		return translateWord( word );
	}

	@Override
	public String translateText(String text) throws TranslateMethodException {
		throw new TranslateMethodException( "No suported method", "translateText" ,  super.toString() );
	}
	
	
	private String response(HttpURLConnection conn) throws IOException {
		
		BufferedReader reader = new BufferedReader( new InputStreamReader( conn.getInputStream() ));
		StringBuilder response = new StringBuilder();
		String line = "";
		while( (line = reader.readLine()) != null )
			response.append( line );
		
		reader.close();
		return response.toString();
	}

	@Override
	public void saveCache() throws TranslateMethodException {
		
		
	}

	@Override
	public void loadSavedCache() throws TranslateMethodException {
		
		
	}
}
	
