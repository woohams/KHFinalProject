package com.prj.te.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.prj.te.dto.CalendarDto;
import com.prj.te.model.dao.CalendarDao;

public class CalendarBizImpl implements CalendarBiz {

	@Autowired
	private CalendarDao dao;
	
	@Override
	public List<CalendarDto> selectList() {
		return dao.selectList();
	}

	@Override
	public CalendarDto selectOne(int calendar_seq) {
		return dao.selectOne(calendar_seq);
	}

	@Override
	public int insert(CalendarDto calendarDto) {
		return dao.insert(calendarDto);
	}

	@Override
	public int update(CalendarDto calendarDto) {
		return dao.update(calendarDto);
	}

	@Override
	public int delete(int calendar_seq) {
		return dao.delete(calendar_seq);
	}

}
