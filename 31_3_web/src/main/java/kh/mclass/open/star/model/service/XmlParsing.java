package kh.mclass.open.star.model.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.management.modelmbean.XMLParseException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlParsing {
	enum WeatherValue{
		SKY, PTY
	}
	
	public static void main(String[] args) throws Exception {
		WeatherVo vo = new WeatherVo();
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=0qnidPXg3UwLV%2FvJens2YsEun%2B7iJKaY0QgrLcOCeqVrR08tVI%2FhvKAvm4Qg3WFAa3sLuQf%2B%2BBdZpunNxZADmg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode("20240404", "UTF-8")); /*‘21년 6월 28일발표*/
        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode("0500", "UTF-8")); /*05시 발표*/
        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode("55", "UTF-8")); /*예보지점의 X 좌표값*/
        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode("127", "UTF-8")); /*예보지점의 Y 좌표값*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        String result = sb.toString();
        System.out.println(result);
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(result));
        Document document = db.parse(is);
        try {
        	document.getDocumentElement().normalize();
        	System.out.println("Root Element : " + document.getDocumentElement().getNodeName());
        	NodeList nList = document.getElementsByTagName("item");
        	for(int temp = 0; temp < nList.getLength(); temp++) {
        		Node nNode = nList.item(temp);
        		
        		if(nNode.getNodeType() == Node.ELEMENT_NODE) {
        			Element eElement = (Element) nNode;
        			
        			String category = eElement.getElementsByTagName("category").item(0).getTextContent();
        			int value = Integer.parseInt(eElement.getElementsByTagName("fcstValue").item(0).getTextContent());
        			
        			WeatherValue weatherVal = WeatherValue.valueOf(category);
        			
        			switch(weatherVal) {
        			case SKY:
        				vo.setSKY(value);
        				break;
        			case PTY:
        				vo.setPTY(value);
        				break;
        			default:
        				throw new XMLParseException();
        			}
        		}
        	}
        	System.out.println(vo.toString());
		} catch (XMLParseException e) {
			e.printStackTrace();
		}
	}
}
