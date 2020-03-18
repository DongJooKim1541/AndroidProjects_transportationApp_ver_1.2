package com.example.busappver12;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class CityCodeListParser {

    private BusItems bi;

    public ArrayList<BusItems> cityCodeListApi(ArrayList<BusItems> list){
        try{
            list=new ArrayList<BusItems>();
            String key="pL4Erh3b64mgmWQeg9qh3bQ4rP9SAu1zAOanR4S1I2U3dJ%2BPproQUh9jY93JXyYnj2NIuC7ShhgecOwvq25pmw%3D%3D";
            String urlStr="http://openapi.tago.go.kr/openapi/service/BusRouteInfoInqireService/getCtyCodeList?serviceKey="+key;

            //URL클래스 객체 생성하여 접근할 경로 설정
            URL url=new URL(urlStr);
            //URL클래스의 연결 정보를 Connection 객체에 전달
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            //메소드방식 설정
            connection.setRequestMethod("GET");
            //타입설정
            connection.setRequestProperty("Content-Type","application/xml");
            //URL을 수행하여 받을 자원을 변환하기위한 객체 준비
            XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
            //파서 객체를 생성한다.
            XmlPullParser parser=factory.newPullParser();
            //connection을 통해서 파싱을 진행한다.
            parser.setInput(connection.getInputStream(),null);
            //파서를 통하여 각 요소(Element)들을 반복 수행처리 한다.
            int parserEvent=parser.getEventType();
            while(parserEvent!= XmlPullParser.END_DOCUMENT){
                //xml문서의 끝이 아닐때만 반복한다
                //시작 태그일때만 태그의 이름을 알아낸다.

                //</item>일때 Item객체 생성
                if(parserEvent==XmlPullParser.START_TAG){
                    String tagName=parser.getName();
                    if(tagName.equalsIgnoreCase("item")){
                        bi=new BusItems();
                    }
                }

                if(parserEvent==XmlPullParser.START_TAG){
                    String tagName=parser.getName();

                    if(tagName.equalsIgnoreCase("citycode")){
                        String cityCode=parser.nextText();
                        bi.setCityCode(cityCode);
                        //android.util.Log.d("KDJ","bi.getCityCode(): "+bi.getCityCode());
                    }

                    if(tagName.equalsIgnoreCase("cityname")){
                        String cityName=parser.nextText();
                        bi.setCityName(cityName);
                        //android.util.Log.d("KDJ","bi.getCityName(): "+bi.getCityName());
                        list.add(bi);
                    }
                }
                parserEvent=parser.next();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
