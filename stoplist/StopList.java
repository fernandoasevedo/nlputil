package nlputil.stoplist;

import java.util.ArrayList;

public abstract class StopList {
	private String stoplist_name;

	public StopList( String stoplist_name ){
		this.stoplist_name = stoplist_name;
	}
	
	/**
	 * Verifica se uma palavra é ou não stopword. 
	 * 
	 * @param word uma {@link String} representando a palavra que será verificada
	 * @return true caso word seja uma stopword
	 * @return false caso word não seja stopword
	 */
	public abstract boolean isStopWord( String word );
	
	/**
	 * Remove todas as stopwrods de uma lista de Strings
	 * @param words uma {@link ArrayList} contendo as palavras que serão analisadas
	 */
	public abstract void removeStopWord( ArrayList<String> words );
	
	
	public String toString(){
		return this.stoplist_name;
	}
}
