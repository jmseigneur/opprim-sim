package eu.muses.sim.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpPostRequest {

	public HttpPostRequest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		/*
		 * Create the POST request
		 */
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost("http://databreachcalculator.com/Calculator/Default.aspx?q=1");
		// Request parameters and other properties.
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("1","1.33"));
		params.add(new BasicNameValuePair("2","0.75"));
		params.add(new BasicNameValuePair("3","0.77"));
		params.add(new BasicNameValuePair("4","1.31"));
		params.add(new BasicNameValuePair("5","1.05"));
		params.add(new BasicNameValuePair("6","0.61"));
		params.add(new BasicNameValuePair("7","0.88"));
		params.add(new BasicNameValuePair("8","0.82"));
		params.add(new BasicNameValuePair("9","0.89"));
		params.add(new BasicNameValuePair("10","0.01"));
		params.add(new BasicNameValuePair("11","1.01"));
		params.add(new BasicNameValuePair("12","188"));
		params.add(new BasicNameValuePair("13","3000"));
		params.add(new BasicNameValuePair("numquestions","11"));
		params.add(new BasicNameValuePair("numquestionstocalc","9"));
		try {
		    httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
		    // writing error to Log
		    e.printStackTrace();
		}
		/*
		 * Execute the HTTP Request
		 */
		try {
		    HttpResponse response = httpClient.execute(httpPost);
		    HttpEntity respEntity = response.getEntity();

		    if (respEntity != null) {
		        // EntityUtils to get the response content
		        String content =  EntityUtils.toString(respEntity);
		        System.out.println(content);
		        HttpGet httpGet = new HttpGet("http://databreachcalculator.com/Calculator/Result.aspx");

				    HttpResponse responseGet = httpClient.execute(httpGet);
				    HttpEntity respGetEntity = responseGet.getEntity();

				    if (respGetEntity != null) {
				        // EntityUtils to get the response content
				        String contentGet =  EntityUtils.toString(respGetEntity);
				        System.out.println(contentGet);
				    }
		    }
		} catch (ClientProtocolException e) {
		    // writing exception to log
		    e.printStackTrace();
		} catch (IOException e) {
		    // writing exception to log
		    e.printStackTrace();
		}

	}

}
