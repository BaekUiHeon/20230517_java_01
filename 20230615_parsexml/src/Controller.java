import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import java.io.BufferedReader;
import java.io.IOException;

public class Controller{
	public void getEvIfoAll() {
		EvInfoService service = new EvInfoService();
		service.start();	
	}
}
