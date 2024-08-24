package com.comcast.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	public String getDataFromJsonFile(String key) throws Throwable {
		FileReader fileR= new FileReader("./configAppData/appCommonData.json");
		JSONParser parser= new JSONParser();
		Object Obj = parser.parse(fileR);
		JSONObject map= (JSONObject)Obj;
		String data= (String) map.get(key);
		return data;
	}

}
