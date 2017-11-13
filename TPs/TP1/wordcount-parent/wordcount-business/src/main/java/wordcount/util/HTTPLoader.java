package wordcount.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HTTPLoader {

	/**
	 * Open a url and read text data, for example html file
	 * @param _url url
	 * @return String file content
	 */
	public static String getTextURL(String _url) {
		BufferedReader reader = null;
		try {
			URL url = new URL(_url);
			URLConnection urlConnection = url.openConnection();
			reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			return sb.toString();
		} catch (IOException ex) {
			Logger.getLogger(HTTPLoader.class.getName()).log(Level.SEVERE, null, ex);
			return "";
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException ex) {
				Logger.getLogger(HTTPLoader.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

}
