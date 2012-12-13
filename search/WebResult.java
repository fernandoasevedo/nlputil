package nlputil.search;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Classe que abstrai um resultado de busca web
 *  
 * @author fernando
 *
 */
public class WebResult {
	private URL url_result;
	private String title;
	private String description;
	
	public WebResult( String url, String title, String description ){
		
		try {
			init( new URL( url ), title, description);
			
		} catch (MalformedURLException e) {
			
			init( null, title, description);
			
			e.printStackTrace();
		}
	}
	
	public WebResult( URL url, String title, String description ){
		init( url, title, description);
	}
	
	private void init( URL url, String title, String description ){
		this.url_result = url;
		this.title = title;
		this.description = description;
	}
	
	
	public URL getUrl_result() {
		return url_result;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
}
