package com.spring.mybatis.user.web.service.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.spring.mybatis.user.web.dao.UserExtrainfoDao;
import com.spring.mybatis.user.web.entity.UserExtrainfoEntity;
import com.spring.mybatis.user.web.service.UserExtrainfoService;

/**
 * ClassName：UserExtrainfoServiceImpl<br>
 * Description：数据库中t_user_extrainfo表对应的实体类        .<br>
 * @author auto
 * @Date 20170829202750
 * @since JRE 1.6.0_22  or higher
 */
@Service
public class UserExtrainfoServiceImpl implements UserExtrainfoService {

	@Resource
	private UserExtrainfoDao userExtrainfoDao;
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return userExtrainfoDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(UserExtrainfoEntity entity) {
		// TODO Auto-generated method stub
		return userExtrainfoDao.insert(entity);
	}

	@Override
	public int insertSelective(UserExtrainfoEntity entity) {
		// TODO Auto-generated method stub
		return userExtrainfoDao.insertSelective(entity);
	}

	@Override
	public UserExtrainfoEntity selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return userExtrainfoDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(UserExtrainfoEntity entity) {
		// TODO Auto-generated method stub
		return userExtrainfoDao.updateByPrimaryKeySelective(entity);
	}

	@Override
	public int updateByPrimaryKey(UserExtrainfoEntity entity) {
		// TODO Auto-generated method stub
		return userExtrainfoDao.updateByPrimaryKey(entity);
	}
	@Override
	public List<UserExtrainfoEntity> getListByPage(int offset, int size) {
		// TODO Auto-generated method stub
		return userExtrainfoDao.getListByPage(offset, size);
	}
}
