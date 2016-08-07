package kr.progracker.mvc_test01.dao;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public int getLoginResult(Map<String, String> map) {
		return (Integer)getSqlSession().selectOne("userDao.getLoginResult", map);
	}

}
