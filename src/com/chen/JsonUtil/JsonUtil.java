package com.chen.JsonUtil;

import java.util.Iterator;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import org.junit.Test;

import com.chen.bean.User;

public class JsonUtil 
{
	
//	@Test
	//JSONObject  JSONArray
	public void parse()
	{
		//创建JSONObject对象
		JSONObject jo = new JSONObject();
		jo.put("name", "陈");
		jo.put("sex", "男");
		jo.put("age", 28);
		jo.put("nickname", "Jack");
		jo.put("家乡", "山东");
		//{"name":"陈","sex":"男","age":28,"nickname":"Jack","家乡":"山东"}
		p(jo);
		
		//增加元素
		jo.accumulate("className", "JsonUtil");

		JSONArray array = new JSONArray();
		array.add(0,"我是0");
		array.add(1,"我是1");
		//把数组给jsonObject 
		jo.element("array", array);
		//{"name":"陈","sex":"男","age":28,"nickname":"Jack","家乡":"山东","array":["我是0","我是1"]}
		p("jo ="+jo);
		
		//从JSONObject获取 jsonArray
		JSONArray arr = jo.getJSONArray("array");
		
		//根据键取值
		String name = jo.getString("name");
		
		//把字符串  转成 JSONObject
		String jsonStr = jo.toString();
		p("jsonStr="+jsonStr);
		JSONObject jo2 = JSONObject.fromObject(jsonStr);
		p("jo2="+jo2);
	}
	
	//JSONObject  和  bean 互转
//	@Test
	public void parseBean()
	{
		User user = new User();
		//bean 转 jsonObject
		JSONObject jo = JSONObject.fromObject(user);
		p("jo="+jo);//jo={"age":18,"array":["one","two","three"],"name":"chen","nickname":"jack","sex":"男","家乡":""}
		
		//JSONObject 转  bean
		User user1 = (User) JSONObject.toBean(jo,User.class);
		p(user1);
	}
	
	/**
	 * JsonConfig
	 * 可以设置把某个json属性过滤掉
	 * */
	@Test
	public void testConfig()
	{
		//创建JSONObject对象
		JSONObject jo = new JSONObject();
		jo.put("name", "陈");
		jo.put("sex", "男");
		jo.put("age", 28);
		jo.put("nickname", "Jack");
		jo.put("家乡", "山东");
		p(jo);//{"name":"陈","sex":"男","age":28,"nickname":"Jack","家乡":"山东"}
		p(jo.keys());
		Iterator it = jo.keys();
		while(it.hasNext())
		{
			p(it.next());
		}
		p(jo.values());
		
		//创建JsonConfig
		JsonConfig conf = new JsonConfig();
		//把sex属性过滤掉
		conf.setExcludes(new String []{"sex"});
		JSON json = JSONSerializer.toJSON(jo, conf);  
		p(json);//{"name":"陈","age":28,"nickname":"Jack","家乡":"山东"}

	}
	
	public void p(Object o)
	{
		System.out.println(o);
	}
	
	
	
	
}
