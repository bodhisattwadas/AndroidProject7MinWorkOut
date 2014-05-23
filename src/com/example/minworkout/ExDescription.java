package com.example.minworkout;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

@SuppressLint("SetJavaScriptEnabled")
public class ExDescription extends Activity {
	private TextView exName;
	private WebView webView;
	private String URL;
	private String ExerciseName;
	private VideoView videoView;
	private String videoUrl;
	private String myUrl = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);  
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_ex_description);
		exName = (TextView)findViewById(R.id.exName);
		webView = (WebView)findViewById(R.id.webView1);
		videoView = (VideoView)findViewById(R.id.videoView1);
		Intent intent = getIntent();
		String receivedValue = intent.getStringExtra(ExerciseList.NUMBER_OF_ROW);
		// Toast.makeText(getApplicationContext(), receivedValue, Toast.LENGTH_SHORT).show();
		switch(Integer.parseInt(receivedValue)){
		case 1:
			ExerciseName  = AllStringClass.ListOfExerciseName[0];
			URL = AllStringClass.ListOfFileURL[0];
			myUrl = "http://www.youtube.com/watch?v=lpkGnHoTgHc";
			break;
		case 2:
			ExerciseName  = AllStringClass.ListOfExerciseName[1];
			URL = AllStringClass.ListOfFileURL[1];
			myUrl = "http://www.youtube.com/watch?v=qJAO5qcqTwM";
			break;
		case 3:
			ExerciseName  = AllStringClass.ListOfExerciseName[2];
			URL = AllStringClass.ListOfFileURL[2];
			myUrl = "http://www.youtube.com/watch?v=9Bevndlj3D0";
			break;
		case 4:
			ExerciseName  = AllStringClass.ListOfExerciseName[3];
			URL = AllStringClass.ListOfFileURL[3];
			myUrl = "http://www.youtube.com/watch?v=MKmrqcoCZ-M";
			break;
		case 5:
			ExerciseName  = AllStringClass.ListOfExerciseName[4];
			URL = AllStringClass.ListOfFileURL[4];
			myUrl = "http://www.youtube.com/watch?v=BLGKFwQWyCk";
			break;
		case 6:
			ExerciseName  = AllStringClass.ListOfExerciseName[5];
			URL = AllStringClass.ListOfFileURL[5];
			myUrl = "http://www.youtube.com/watch?v=p3g4wAsu0R4";
			break;
		case 7:
			ExerciseName  = AllStringClass.ListOfExerciseName[6];
			URL = AllStringClass.ListOfFileURL[6];
			myUrl = "http://www.youtube.com/watch?v=Ht1KDIrwDZM";
			break;
		case 8:
			ExerciseName  = AllStringClass.ListOfExerciseName[7];
			URL = AllStringClass.ListOfFileURL[7];
			myUrl = "http://www.youtube.com/watch?v=u_iG_DWLdN8";
			break;
		case 9:
			ExerciseName  = AllStringClass.ListOfExerciseName[8];
			URL = AllStringClass.ListOfFileURL[8];
			myUrl = "http://www.youtube.com/watch?v=S4_ApTHhuv8";
			break;
		case 10:
			ExerciseName  = AllStringClass.ListOfExerciseName[9];
			URL = AllStringClass.ListOfFileURL[9];
			myUrl = "http://www.youtube.com/watch?v=tTej-ax9XiA";
			break;
		case 11:
			ExerciseName  = AllStringClass.ListOfExerciseName[10];
			URL = AllStringClass.ListOfFileURL[10];
			myUrl = "http://www.youtube.com/watch?v=uGqZONsnZa8";
			break;
		case 12:
			ExerciseName  = AllStringClass.ListOfExerciseName[11];
			URL = AllStringClass.ListOfFileURL[11];
			myUrl = "http://www.youtube.com/watch?v=wlHBypwBbw8";
			break;
			
		}
		
		exName.setText(ExerciseName);
		webView.loadUrl(URL);
		webView.getSettings().setJavaScriptEnabled(true);
	    webView.getSettings().setSaveFormData(true);
	    webView.getSettings().setBuiltInZoomControls(true);
	    webView.setWebViewClient(new MyWebViewClient());
	    new YourAsyncTask().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_ex_description, menu);
		return true;
	}
	
	private class MyWebViewClient extends WebViewClient 
	{ 
	    @Override 
	    //show the web page in webview but not in web browser
	    public boolean shouldOverrideUrlLoading(WebView view, String url) { 
	        view.loadUrl (url); 
	        return true;
	    }
	}
	
	private class YourAsyncTask extends AsyncTask<Void, Void, Void>
    {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(ExDescription.this, "", "Loading Video wait...", true);
        }

        @Override
        protected Void doInBackground(Void... params)
        {
            try
            {
               // String url = "http://www.youtube.com/watch?v=OtLa7wDpuOU";
                videoUrl = getUrlVideoRTSP(myUrl);
                Log.e("Video url for playing=========>>>>>", videoUrl);
            }
            catch (Exception e)
            {
                Log.e("Login Soap Calling in Exception", e.toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result)
        {
            super.onPostExecute(result);
            progressDialog.dismiss();
      
            videoView.setVideoURI(Uri.parse(videoUrl));
            MediaController mc = new MediaController(ExDescription.this);
            videoView.setMediaController(mc);
            videoView.requestFocus();
            videoView.start();          
            mc.show();
        }

    }

	public static String getUrlVideoRTSP(String urlYoutube)
    {
        try
        {
            String gdy = "http://gdata.youtube.com/feeds/api/videos/";
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String id = extractYoutubeId(urlYoutube);
            URL url = new URL(gdy + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            Document doc = documentBuilder.parse(connection.getInputStream());
            Element el = doc.getDocumentElement();
            NodeList list = el.getElementsByTagName("media:content");///media:content
            String cursor = urlYoutube;
            for (int i = 0; i < list.getLength(); i++)
            {
                Node node = list.item(i);
                if (node != null)
                {
                    NamedNodeMap nodeMap = node.getAttributes();
                    HashMap<String, String> maps = new HashMap<String, String>();
                    for (int j = 0; j < nodeMap.getLength(); j++)
                    {
                        Attr att = (Attr) nodeMap.item(j);
                        maps.put(att.getName(), att.getValue());
                    }
                    if (maps.containsKey("yt:format"))
                    {
                        String f = maps.get("yt:format");
                        if (maps.containsKey("url"))
                        {
                            cursor = maps.get("url");
                        }
                        if (f.equals("1"))
                            return cursor;
                    }
                }
            }
            return cursor;
        }
        catch (Exception ex)
        {
            Log.e("Get Url Video RTSP Exception======>>", ex.toString());
        }
        return urlYoutube;

    }

	protected static String extractYoutubeId(String url) throws MalformedURLException
    {
        String id = null;
        try
        {
            String query = new URL(url).getQuery();
            if (query != null)
            {
                String[] param = query.split("&");
                for (String row : param)
                {
                    String[] param1 = row.split("=");
                    if (param1[0].equals("v"))
                    {
                        id = param1[1];
                    }
                }
            }
            else
            {
                if (url.contains("embed"))
                {
                    id = url.substring(url.lastIndexOf("/") + 1);
                }
            }
        }
        catch (Exception ex)
        {
            Log.e("Exception", ex.toString());
        }
        return id;
    }
	public void onPause ()
{
	super.onPause();
	videoView.stopPlayback();
}
	}

