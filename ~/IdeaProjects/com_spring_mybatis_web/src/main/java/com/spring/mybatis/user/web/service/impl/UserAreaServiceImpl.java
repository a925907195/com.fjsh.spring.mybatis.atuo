package com.spring.mybatis.user.web.service.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.spring.mybatis.user.web.dao.UserAreaDao;
import com.spring.mybatis.user.web.entity.UserAreaEntity;
import com.spring.mybatis.user.web.service.UserAreaService;

/**
 * ClassName：UserAreaServiceImpl<br>
 * Description：数据库中t_user_area表对应的实体类        .<br>
 * @author auto
 * @Date 20170829202750
 * @since JRE 1.6.0_22  or higher
 */
@Service
public class UserAreaServiceImpl implements UserAreaService {

	@Resource
	private UserAreaDao userAreaDao;
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return userAreaDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(UserAreaEntity entity) {
		// TODO Auto-generated method stub
		return userAreaDao.insert(entity);
	}

	@Override
	public int insertSelective(UserAreaEntity entity) {
		// TODO Auto-generated method stub
		return userAreaDao.insertSelective(entity);
	}

	@Override
	public UserAreaEntity selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return userAreaDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(UserAreaEntity entity) {
		// TODO Auto-generated method stub
		return userAreaDao.updateByPrimaryKeySelective(entity);
	}

	@Override
	public int updateByPrimaryKey(UserAreaEntity entity) {
		// TODO Auto-generated method stub
		return userAreaDao.updateByPrimaryKey(entity);
	}
	@Override
	public List<UserAreaEntity> getListByPage(int offset, int size) {
		// TODO Auto-generated method stub
		return userAreaDao.getListByPage(offset, size);
	}
}
