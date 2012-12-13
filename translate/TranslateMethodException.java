package nlputil.translate;

/**
 * Classe que representa um Exceção que ocorre quando há erro de métodos de tradução 
 * 
 * @author fernando
 *
 */
public class TranslateMethodException extends RuntimeException{
	
	public TranslateMethodException( String message, String method, String translator_name ){
		
		super( translator_name + "--" + method +"\n" + message );
	}

}
