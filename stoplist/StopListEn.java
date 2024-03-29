package nlputil.stoplist;

import java.util.ArrayList;
import java.util.LinkedList;

public class StopListEn extends StopList{
	public final ArrayList<String> stop_list;
	
	public StopListEn(){
		super("English stoplist");
		
		stop_list = new ArrayList<String>( 199 );
			
		stop_list.add( "I" );
		stop_list.add( "a" );
		stop_list.add( "an" );
		stop_list.add( "as" );
		stop_list.add( "at" );
		stop_list.add( "by" );
		stop_list.add( "he" );
		stop_list.add( "his" );
		stop_list.add( "me" );
		stop_list.add( "or" );
		stop_list.add( "thou" );
		stop_list.add( "us" );
		stop_list.add( "who" );
		stop_list.add( "against" );
		stop_list.add( "amid" );
		stop_list.add( "amidst" );
		stop_list.add( "among" );
		stop_list.add( "amongst" );
		stop_list.add( "and" );
		stop_list.add( "anybody" );
		stop_list.add( "anyone" );
		stop_list.add( "because" );
		stop_list.add( "beside" );
		stop_list.add( "circa" );
		stop_list.add( "despite" );
		stop_list.add( "during" );
		stop_list.add( "everybody" );
		stop_list.add( "everyone" );
		stop_list.add( "for" );
		stop_list.add( "from" );
		stop_list.add( "her" );
		stop_list.add( "hers" );
		stop_list.add( "herself" );
		stop_list.add( "him" );
		stop_list.add( "himself" );
		stop_list.add( "hisself" );
		stop_list.add( "idem" );
		stop_list.add( "if" );
		stop_list.add( "into" );
		stop_list.add( "it" );
		stop_list.add( "its" );
		stop_list.add( "itself" );
		stop_list.add( "myself" );
		stop_list.add( "nor" );
		stop_list.add( "of" );
		stop_list.add( "oneself" );
		stop_list.add( "onto" );
		stop_list.add( "our" );
		stop_list.add( "ourself" );
		stop_list.add( "ourselves" );
		stop_list.add( "per" );
		stop_list.add( "she" );
		stop_list.add( "since" );
		stop_list.add( "than" );
		stop_list.add( "that" );
		stop_list.add( "the" );
		stop_list.add( "thee" );
		stop_list.add( "theirs" );
		stop_list.add( "them" );
		stop_list.add( "themselves" );
		stop_list.add( "they" );
		stop_list.add( "thine" );
		stop_list.add( "this" );
		stop_list.add( "thyself" );
		stop_list.add( "to" );
		stop_list.add( "tother" );
		stop_list.add( "toward" );
		stop_list.add( "towards" );
		stop_list.add( "unless" );
		stop_list.add( "until" );
		stop_list.add( "upon" );
		stop_list.add( "versus" );
		stop_list.add( "via" );
		stop_list.add( "we" );
		stop_list.add( "what" );
		stop_list.add( "whatall" );
		stop_list.add( "whereas" );
		stop_list.add( "which" );
		stop_list.add( "whichever" );
		stop_list.add( "whichsoever" );
		stop_list.add( "whoever" );
		stop_list.add( "whom" );
		stop_list.add( "whomever" );
		stop_list.add( "whomso" );
		stop_list.add( "whomsoever" );
		stop_list.add( "whose" );
		stop_list.add( "whosoever" );
		stop_list.add( "with" );
		stop_list.add( "without" );
		stop_list.add( "ye" );
		stop_list.add( "you" );
		stop_list.add( "you-all" );
		stop_list.add( "yours" );
		stop_list.add( "yourself" );
		stop_list.add( "yourselves" );
		stop_list.add( "aboard" );
		stop_list.add( "about" );
		stop_list.add( "above" );
		stop_list.add( "across" );
		stop_list.add( "after" );
		stop_list.add( "all" );
		stop_list.add( "along" );
		stop_list.add( "alongside" );
		stop_list.add( "although" );
		stop_list.add( "another" );
		stop_list.add( "anti" );
		stop_list.add( "any" );
		stop_list.add( "anything" );
		stop_list.add( "around" );
		stop_list.add( "astride" );
		stop_list.add( "aught" );
		stop_list.add( "bar" );
		stop_list.add( "barring" );
		stop_list.add( "before" );
		stop_list.add( "behind" );
		stop_list.add( "below" );
		stop_list.add( "beneath" );
		stop_list.add( "besides" );
		stop_list.add( "between" );
		stop_list.add( "beyond" );
		stop_list.add( "both" );
		stop_list.add( "but" );
		stop_list.add( "concerning" );
		stop_list.add( "considering" );
		stop_list.add( "down" );
		stop_list.add( "each" );
		stop_list.add( "either" );
		stop_list.add( "enough" );
		stop_list.add( "except" );
		stop_list.add( "excepting" );
		stop_list.add( "excluding" );
		stop_list.add( "few" );
		stop_list.add( "fewer" );
		stop_list.add( "following" );
		stop_list.add( "ilk" );
		stop_list.add( "in" );
		stop_list.add( "including" );
		stop_list.add( "inside" );
		stop_list.add( "like" );
		stop_list.add( "many" );
		stop_list.add( "mine" );
		stop_list.add( "minus" );
		stop_list.add( "more" );
		stop_list.add( "most" );
		stop_list.add( "naught" );
		stop_list.add( "near" );
		stop_list.add( "neither" );
		stop_list.add( "nobody" );
		stop_list.add( "none" );
		stop_list.add( "nothing" );
		stop_list.add( "notwithstanding" );
		stop_list.add( "off" );
		stop_list.add( "on" );
		stop_list.add( "opposite" );
		stop_list.add( "other" );
		stop_list.add( "otherwise" );
		stop_list.add( "outside" );
		stop_list.add( "over" );
		stop_list.add( "own" );
		stop_list.add( "past" );
		stop_list.add( "pending" );
		stop_list.add( "plus" );
		stop_list.add( "regarding" );
		stop_list.add( "round" );
		stop_list.add( "save" );
		stop_list.add( "self" );
		stop_list.add( "several" );
		stop_list.add( "so" );
		stop_list.add( "some" );
		stop_list.add( "somebody" );
		stop_list.add( "someone" );
		stop_list.add( "something" );
		stop_list.add( "somewhat" );
		stop_list.add( "such" );
		stop_list.add( "suchlike" );
		stop_list.add( "sundry" );
		stop_list.add( "there" );
		stop_list.add( "though" );
		stop_list.add( "through" );
		stop_list.add( "throughout" );
		stop_list.add( "till" );
		stop_list.add( "twain" );
		stop_list.add( "under" );
		stop_list.add( "underneath" );
		stop_list.add( "unlike" );
		stop_list.add( "up" );
		stop_list.add( "various" );
		stop_list.add( "vis-a-vis" );
		stop_list.add( "whatever" );
		stop_list.add( "whatsoever" );
		stop_list.add( "when" );
		stop_list.add( "wherewith" );
		stop_list.add( "wherewithal" );
		stop_list.add( "while" );
		stop_list.add( "within" );
		stop_list.add( "worth" );
		stop_list.add( "yet" );
		stop_list.add( "yon" );
		stop_list.add( "yonder" );
	}
	
	public boolean isStopWord( String word ){		
		return stop_list.contains( word );
	}
	
	public void removeStopWord( ArrayList<String> words ){		
		words.removeAll( stop_list );
	}
}
