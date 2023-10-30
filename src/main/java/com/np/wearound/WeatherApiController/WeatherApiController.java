package com.np.wearound.WeatherApiController;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import java.io.BufferedReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/weather")
public class WeatherApiController {
	
	// 화면에서 여러가지를 받을 꺼라 map 으로 리턴
	@GetMapping("/today")
	public Map<String, Object> weather () 
		throws ServletException, IOException, ParseException {
		System.out.println("API 실행");
		
		
    	Date sysdate = new Date();
    	
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String formattedSysdate = dateFormat.format(sysdate); // 지금 당일 날짜 설정
		
		String apiUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst";
		// 홈페이지에서 받은 키
		String serviceKey = "evzyFT1OhFuB8sLzt%2BZhFLN222xmnNgsyt7EjsGnUDkFYd%2FDRvHgCR5CNAtFcdtwBUGPJeLGgy%2BM7H%2BbAB%2B5Kw%3D%3D";
		String nx = "60";	//위도
		String ny = "128";	//경도
		String baseTime = "0800";	//조회하고싶은 시간
		String type = "json";	//타입 xml, json 등등 ..
		
		// api url 수정하기 위한 StringBuilder
        StringBuilder urlBuilder = new StringBuilder(apiUrl);
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+serviceKey);
        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode(nx, "UTF-8")); //경도
        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode(ny, "UTF-8")); //위도
        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(formattedSysdate, "UTF-8")); /* 조회하고싶은 날짜*/
        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(baseTime, "UTF-8")); /* 조회하고싶은 시간 AM 02시부터 3시간 단위 */
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode(type, "UTF-8"));	/* 타입 */
        // api 사용 가이드대로 경도, 위도, 날짜, 시간, 데이터 타입을 url로 지정
        
        // GET방식으로 전송해서 파라미터 받아오기
        URL url = new URL(urlBuilder.toString());
        // 넘어가는 url 확인용
        System.out.println("url 체크 " + url);
        // http 객체 생성 후, 요청 보냄 (방식과 데이터 타입 등 지정)
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        
        // BufferedReader 객체 생성
        BufferedReader rd;
        // 오류일 경우 getErrorStream 로 오류 내뱉음
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        
        // StringBuilder 객채 생성
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        // 객체 사용 종료 및 프린틴
        rd.close();
        conn.disconnect();
        String result= sb.toString();
        System.out.println(result);
        //---------------------------------------------------------------------------
		// Json parser를 만들어 만들어진 문자열 데이터를 객체화 
		JSONParser parser = new JSONParser(); 
		JSONObject obj = (JSONObject) parser.parse(result); 
		// response 키를 가지고 데이터를 파싱 
		JSONObject parse_response = (JSONObject) obj.get("response"); 
		// response 로 부터 body 찾기
		JSONObject parse_body = (JSONObject) parse_response.get("body"); 
		// body 로 부터 items 찾기 
		JSONObject parse_items = (JSONObject) parse_body.get("items");

		// items로 부터 itemlist 를 받기 
		JSONArray parse_item = (JSONArray) parse_items.get("item");
		String category;
		JSONObject weather; // parse_item은 배열형태이기 때문에 하나씩 데이터를 하나씩 가져올때 사용
		// 카테고리와 값만 받아오기
		String day="";
		String time="";
		for(int i = 0 ; i < parse_item.size(); i++) {
			weather = (JSONObject) parse_item.get(i);
			//Object fcstValue = weather.get("fcstValue");
			Object obsrValue = weather.get("obsrValue");
			//Object fcstTime = weather.get("fcstTime");
			//double형으로 받고싶으면 아래내용 주석 해제
			//double fcstValue = Double.parseDouble(weather.get("fcstValue").toString());
			category = (String)weather.get("category"); 
			// 출력
//			if(!day.equals(fcstDate.toString())) {
//				day=fcstDate.toString();
//			}
//			if(!time.equals(fcstTime.toString())) {
//				time=fcstTime.toString();
//				System.out.println(day+"  "+time);
//			}
			System.out.print("\tcategory : "+ category);
			//System.out.print(", fcst_Value : "+ fcstValue);
			System.out.println(", obsrValue : "+ obsrValue);
			//System.out.println(", fcstTime : "+ fcstTime);

		}
		//model.addAttribute("parse_item", parse_item);
		
		Map<String, Object> t1hList = new HashMap<>();
		for (int i = 0; i < parse_item.size(); i++) {
		    weather = (JSONObject) parse_item.get(i);
		    category = (String) weather.get("category");
		    if ("T1H".equals(category)) {
		        // "T1H" 카테고리의 값을 추출하여 리스트에 추가합니다.
		    	String t1hValue1 = (String) weather.get("obsrValue");
		    	double t1hValue = Double.parseDouble(t1hValue1);
		        t1hList.put("t1hValue", t1hValue);
		        
		        if (t1hValue >= 28) {
		        	String clothes = "민소매, 반팔, 반바지, 짧은 치마, 린넨 옷";
		        	t1hList.put("clothes", clothes);
		        }
		        else if (t1hValue <= 27 && t1hValue >= 23) {
		        	String clothes = "반팔, 얇은 셔츠, 반바지, 면바지";
		        	t1hList.put("clothes", clothes);
		        }
		        else if (t1hValue <= 22 && t1hValue >= 20) {
		        	String clothes = "블라우스, 긴팔 티, 면바지, 슬렉스";
		        	t1hList.put("clothes", clothes);
		        }
		        else if (t1hValue <= 19 && t1hValue >= 17) {
		        	String clothes = "얇은 가디건, 니트, 후드, 맨투맨, 긴 바지";
		        	t1hList.put("clothes", clothes);
		        }
		        else if (t1hValue <= 16 && t1hValue >= 12) {
		        	String clothes = "자켓, 가디건, 청바지, 니트";
		        	t1hList.put("clothes", clothes);
		        }
		        else if (t1hValue <= 11 && t1hValue >= 9) {
		        	String clothes = "트렌치 코트, 야상, 점퍼, 스타킹, 기모바지";
		        	t1hList.put("clothes", clothes);
		        }
		        else if (t1hValue <= 8 && t1hValue >= 5) {
		        	String clothes = "울 코트, 히트텍, 가죽 옷, 기모";
		        	t1hList.put("clothes", clothes);
		        }
		        else {
		        	String clothes = "롱패팅, 두꺼운 코트, 누빔 옷, 기모, 목도리";
		        	t1hList.put("clothes", clothes);
		        }
		    }
		}
		
		return t1hList;
	}
}
