package kh.mclass.jdbc.model.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.Gson;

import kh.mclass.jdbc.common.JdbcTemplate;
import kh.mclass.jdbc.model.vo.OpenApiVo;

public class OpenApiService2 {
	private Properties prop = new Properties();

	public List<OpenApiVo> getCtprvnRltmMesureDnsty() throws IOException {
		List<OpenApiVo> volist = null;

		prop.load(new FileReader(JdbcTemplate.class.getResource("./").getPath() + "driver.properties"));
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty");
		urlBuilder.append("?"+URLEncoder.encode("serviceKey","UTF-8")+"="+URLEncoder.encode(prop.getProperty("openapi.serviceKey.CtprvnRltmMesureDnsty"),"UTF-8"));
		urlBuilder.append("&"+URLEncoder.encode("returnType","UTF-8")+"="+URLEncoder.encode("json", "UTF-8"));
		urlBuilder.append("&"+URLEncoder.encode("numOfRows", "UTF-8")+"="+URLEncoder.encode("100", "UTF-8"));
		urlBuilder.append("&"+URLEncoder.encode("pageNo", "UTF-8")+"="+URLEncoder.encode("1", "UTF-8"));
		urlBuilder.append("&"+URLEncoder.encode("sidoName", "UTF-8")+"="+URLEncoder.encode("서울", "UTF-8"));
		urlBuilder.append("&"+URLEncoder.encode("ver", "UTF-8")+"="+URLEncoder.encode("1.0", "UTF-8"));
		
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: "+ conn.getResponseCode());
		
		Document doc = parseXML(conn.getInputStream());
		conn.disconnect();
		
		NodeList nodelist = doc.getElementsByTagName("item");
		
		if(nodelist.getLength()<1) {
			return volist;
		}
		
		volist = new ArrayList<OpenApiVo>();
		for(int i = 0; i < nodelist.getLength(); i++) {
			Node item = nodelist.item(i);
			Node n = item.getFirstChild();
			OpenApiVo vo = new OpenApiVo();
			while(n!=null) {
				String nodeName = n.getNodeName();
				String nodeText = n.getTextContent();
				
				switch(nodeName) {
				case "stationName":
					vo.setStationName(nodeText);
					break;
				case "dateTime":
					vo.setDateTime(nodeText);
					break;
				case "pm10Value":
					vo.setPm10Value(nodeText);
					break;
				case "so2Value":
					vo.setSo2Value(nodeText);
					break;
				case "so2Grade":
					vo.setSo2Grade(nodeText);
					break;
				}
				n = n.getNextSibling();
			}
		}
		
		return volist;
	}
	
	public Map<String, Object> getCtprvnRltmMesureDnstyByJson() throws IOException {
		Map<String, Object> map = null;
		
		prop.load(new FileReader(JdbcTemplate.class.getResource("./").getPath() + "driver.properties"));
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty");
		urlBuilder.append("?"+URLEncoder.encode("serviceKey","UTF-8")+"="+URLEncoder.encode(prop.getProperty("openapi.serviceKey.CtprvnRltmMesureDnsty"),"UTF-8"));
		urlBuilder.append("&"+URLEncoder.encode("returnType","UTF-8")+"="+URLEncoder.encode("json", "UTF-8"));
		urlBuilder.append("&"+URLEncoder.encode("numOfRows", "UTF-8")+"="+URLEncoder.encode("100", "UTF-8"));
		urlBuilder.append("&"+URLEncoder.encode("pageNo", "UTF-8")+"="+URLEncoder.encode("1", "UTF-8"));
		urlBuilder.append("&"+URLEncoder.encode("sidoName", "UTF-8")+"="+URLEncoder.encode("서울", "UTF-8"));
		urlBuilder.append("&"+URLEncoder.encode("ver", "UTF-8")+"="+URLEncoder.encode("1.0", "UTF-8"));
		
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type","application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if((conn.getResponseCode())>=200 && (conn.getResponseCode())<=300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		}else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = rd.readLine())!=null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		
		Gson gson = new Gson();
		map = new HashMap<String, Object>();
		map = gson.fromJson(sb.toString(), map.getClass());
		
		return map;
	}
	
	// xml to Java Object
		private Document parseXML(InputStream stream) {
			DocumentBuilderFactory objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder objDocumentBuilder = null;
			Document result = null;

			try {
				objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();
				result = objDocumentBuilder.parse(stream);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) { // Simple API for XML
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return result;
		}
}
