package nlputil.wordnet;

import java.io.File;

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;
import edu.smu.tspell.wordnet.impl.file.SynsetFactory;
import edu.smu.tspell.wordnet.impl.file.SynsetPointer;

/**
 * Classe que encapsula operações para busca de synset na WordNet
 * 
 * @author fernando
 *
 */
public class WordNet {
	
	//Endereço (relativo) do diretório dict da WordNet
	private static String wordnet_dir = 
				".." + File.separator + 
				"lib" + File.separator +
				"WordNet-3.0" +	File.separator + 
				"dict"+File.separator;
	
	
	/**
	 * Método privado para configurações de propriedades do sistema necessárias para operações
	 * sobre a WordNet
	 */
	private static void setDirectory( ){		
		//necessário para encontrar o dicionário da wordnet
		//System.setProperty("wordnet.database.dir", wordnet_dir );
	}
	

	/**
	 * Retorna todos os synsets que contêm uma determinada palavra passada como parâmetro.
	 * Obs.: A palavra deve ser passada no idioma ingês, visto que a base utilizada é em inlgês
	 * 
	 * @param word uma {@link String} representando a palavra que será buscada 
	 * @return um array contendo todos os synsets que contêm a palavra do parâmetro. Caso não encontre
	 * nenhum synset, retora-se null
	 */
	public static Synset[] getSynonyms( String word ){
	
		//Trocando espaços em brando por _, que é o padrão da WordNet
		word = word.replace(" ", "_");
	
		setDirectory();
		
		WordNetDatabase database = WordNetDatabase.getFileInstance();
		
		Synset[] synsets = database.getSynsets( word  );
		
		return synsets;
	}
	
	
	/**
	 * Retorna todos os synsets que contêm uma determinada palavra passada como parâmetro, restringindo a classe gramatical 
	 * Obs.: A palavra deve ser passada no idioma ingês, visto que a base utilizada é em inlgês
	 * 
	 * Para reconhcer os possíveis tipos, pode-se utilizar as constantes disponíveis pela classe SynsetType
	 * 
	 * @param word uma {@link String} representando a palavra que será buscada 
	 * @param synset_type é um {@link SynsetType} que representa a classe gramatical do synset: Substantivo, Verbo, Adjetivo e Advérbio
	 * 
	 * @return um array contendo todos os synsets que contêm a palavra do parâmetro. Caso não encontre
	 * nenhum synset, retora-se null
	 */
	public static Synset[] getSynonyms( String word , SynsetType synset_type ){
	
		//Trocando espaços em brando por _, que é o padrão da WordNet
		word = word.replace(" ", "_");
	
		setDirectory();
		
		WordNetDatabase database = WordNetDatabase.getFileInstance();
		
		Synset[] synsets = database.getSynsets( word , synset_type );
		
		return synsets;
	}
	
	/**
	 * Retorna um synset correspondente ao identificador passado como parâmetro
	 * 
	 * @param synset_id um número representando o identificador do synset
	 * 
	 * @return retorna o synset correspondente ao identificador, ou null caso não encontre
	 * 
	 * @throws Exception lança-se uma exceção caso algum erro de acesso à base da wordnet ocorra
	 */
	public static Synset getSynset( int synset_id ) throws Exception{	
		
		setDirectory(); 
		
		SynsetFactory factory = SynsetFactory.getInstance();
		
		return factory.getSynset( new SynsetPointer( SynsetType.NOUN, synset_id ) );
	}
	
	/**
	 * Mapeia uma etiqueta usada pelo MXPOST para um tipo de Synset da WordNet
	 * @param tag uma {@link String} representando a etiqueta
	 * @return um objeto {@link SynsetType} correspondente a etiqueta, ou null caso não há corresondência
	 */
	public static SynsetType mapSynset(String tag) {
		
		if( tag.compareTo("N") == 0 )
			return SynsetType.NOUN;
		
		if( tag.compareTo("VERB") == 0 )
			return SynsetType.VERB;
		
		if( tag.compareTo("ADV") == 0 )
			return SynsetType.ADVERB;	
		
		if( tag.compareTo("ADJ") == 0 )
			return SynsetType.ADJECTIVE;
		
		//NAO PROCURAR NA WORDNET
		return null;
	}
	
}

