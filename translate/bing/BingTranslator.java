package nlputil.translate.bing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import nlputil.translate.Translator;
import nlputil.translate.TranslateMethodException;

public class BingTranslator extends Translator{
	private String from_translate;
	private String to_translate;
	private String access_token;
	
	public BingTranslator( String from_translate, String to_translate, String access_token ){
		super("BingTranslator");
		
		this.from_translate = from_translate;
		this.to_translate = to_translate;
		this.access_token = access_token;
	}
	
	@Override
	public ArrayList<String> translateWord(String word, String tag)	throws TranslateMethodException {

		//Segundo a documentação do bing, a palavra Bearer deve ser inserida no token de acesso
		//accesToken = "Bearer " + accesToken;
		
		URL url;
		
		try {
			url = new URL(
					"http://api.microsofttranslator.com/v2/Http.svc/GetTranslations?"
					+ "&" + "text=" + URLEncoder.encode( word, "UTF-8")
					+ "&" + "from=" + this.from_translate + "&" + "to=" + this.to_translate 
					+ "&" +  "maxTranslations=5");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			//Adicionando dados de cabeçalho
			conn.setRequestProperty("Authorization", this.access_token );
			conn.setRequestProperty("Content-Type", "text/plain");
			conn.setRequestMethod("POST");
			
			//Faz com que a saída seja gerada
			conn.setDoOutput(true);
			
			//Envia os dados
			OutputStreamWriter writer = new OutputStreamWriter( conn.getOutputStream() );
			writer.flush();
			
			BufferedReader reader = new BufferedReader( new InputStreamReader(conn.getInputStream()));
			String line = "";
			while( (line = reader.readLine() ) != null )
				System.out.println( line );
			
			reader.close();
			
			//Fazendo a leitura do xml retornado		
			Document document = null;				
			//construtor do documento
			SAXBuilder docBuilder = new SAXBuilder();
			document = docBuilder.build( conn.getInputStream() );
			
			//Pegando os elementos do documento
			Element root = document.getRootElement();
			Element t = root.getChild("Translations", root.getNamespace() );
			List<Element> elements = t.getChildren();
			String translates[] = new String[ elements.size() ];
			int index = 0;
			for( Element e : elements ){
				//System.out.println( e );
				translates[ index ] = e.getChildText("TranslatedText" , e.getNamespace());
				index++;
			}		
			
			writer.close();		
			return translates;			

		} catch (IOException e) {			
			throw new TranslateMethodException( e.getMessage(), "translateWord",  super.toString() );
		}
	
		return null;
	}

	@Override
	public ArrayList<String> translateWord(String word)	throws TranslateMethodException {		
		return translateWord( word , "N" );
	}

	@Override
	public String translateText(String text) throws TranslateMethodException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCache() throws TranslateMethodException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadSavedCache() throws TranslateMethodException {
		// TODO Auto-generated method stub
		
	}

}
