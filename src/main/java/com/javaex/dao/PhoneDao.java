package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {

	@Autowired
	private SqlSession sqlSession;

	// 전체리스트 가져오기
	public List<PersonVo> getPersonList() {
		System.out.println("[PhoneDao.getPersonList()]");

		List<PersonVo> personList = sqlSession.selectList("phonebook.selectList");

		return personList;
	}
	
	// 전화번호 저장
	public int personInsert(PersonVo personVo) {
		System.out.println("[PhoneDao.personInsert()]");
		
		int count = sqlSession.insert("phonebook.personInsert", personVo);
		
		return count;
	}
	

}