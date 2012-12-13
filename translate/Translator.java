package nlputil.translate;

import java.util.ArrayList;

/**
 * Classe abstrata que encapsula métodos de tradução automática que devem ser implementados
 * 
 * @author fernando
 *
 */
public abstract class Translator {
	private String translate_name;
	
	public Translator( String translate_name ){
		this.translate_name = translate_name;
	}
	
	public String toString(){
		return translate_name;
	}
	
	/**
	 * Traduz uma palavra mostrando todas suas possibilidades de traduação 
	 * 
	 * @param word uma {@link String} que representa a palavra a ser desambiguada
	 * @param tag uma {@link String} que representa a tag morfossintática da palavra
	 * @return um {@link ArrayList} contendo todas as possibilidade de tradução 
	 * 
	 * @throws TranslateMethodException Lança-se exceções quando ocorre algum erro no método, ou o método não é aceito pelo tradutor
	 */
	public abstract ArrayList<String> translateWord( String word , String tag) throws TranslateMethodException;
		
	/**
	 * Traduz uma palavra mostrando todas suas possibilidades de traduação 
	 * 
	 * @param word uma {@link String} que representa a palavra a ser desambiguada
	 * @return um {@link ArrayList} contendo todas as possibilidade de tradução 
	 * 
	 * @throws TranslateMethodException Lança-se exceções quando ocorre algum erro no método, ou o método não é aceito pelo tradutor
	 */
	public abstract ArrayList<String> translateWord( String word ) throws TranslateMethodException;;
	
	/**
	 * Traduz um senteção
	 * 
	 * @param text uma {@link String} representando a sentença, ou texto, a ser traduzido
	 * 
	 * @return uma {@link String} encapuslando a tradução do texto
	 * 
	 * @throws TranslateMethodException Lança-se exceções quando ocorre algum erro no método, ou o método não é aceito pelo tradutor
	 */
	public abstract String translateText( String text ) throws TranslateMethodException;
	
	/**
	 * Alguns tradutores podem usar caching de suas traduações. Caso a aplicação necessite
	 * este método pode ser aplciado para salvar o cache atual de traduções para futura utilização
	 * 
	 * @throws TranslateMethodException Lança-se exceções quando ocorre algum erro no método, ou o método não é aceito pelo tradutor
	 */
	public abstract void saveCache() throws TranslateMethodException;
	
	/**
	 * Este método é aplicado para carregar um cache, anterimente salvo, de um tradutor
	 * 
	 * @throws TranslateMethodException Lança-se exceções quando ocorre algum erro no método, ou o método não é aceito pelo tradutor
	 */
	public abstract void loadSavedCache() throws TranslateMethodException;
}
