package com.prj.te;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.prj.te.dto.CalendarDto;
import com.prj.te.model.biz.CalendarBiz;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/mypageinfo.do")
	public String myPage() {
		
		return "mypageinfo";
	}
	
	@Autowired 
	private CalendarBiz biz;
	
	@RequestMapping(value = "/calendarform.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String calendarform(Model model) {
			
		return "calendar";
	}
	
	@RequestMapping(value = "/calendar.do")
	@ResponseBody
	public HashMap<String, Object> selectList(HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
	
		String id = (String)session.getAttribute("id");
	
		List<CalendarDto> calendarList = biz.selectList();
		map.put("calendarList", calendarList);
		
		return map;
	}
	
	/*@RequestMapping(value = "/calendarajax.do", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public HashMap<String, Object> selectList(Model model) {
		
		List<CalendarDto> list = biz.selectList();
		JSONArray jArr = new JSONArray();
		HashMap<String, Object> map = null;
		for(int i=0; i<list.size(); i++) {
			map = new HashMap<String, Object>();
			map.put("id", list.get(i).getCalendar_seq());
			map.put("title", list.get(i).getCalendar_title());
			map.put("start", list.get(i).getCalendar_start());
			map.put("end", list.get(i).getCalendar_end());
			map.put("description", list.get(i).getCalendar_content());
			map.put("url", list.get(i).getId());
		
			
			jArr.add(map);
		}
		
		JSONObject jobj;
		try {
			jobj = new JSONObject();
			jobj.put("event", jArr);
			
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(jobj.toString());
			
		} catch (JsonSyntaxException e) {
			System.out.println("JSON 변환실패");
			e.printStackTrace();
		}

		System.out.println(jArr.toString());
		
		return map;
	}*/

}
