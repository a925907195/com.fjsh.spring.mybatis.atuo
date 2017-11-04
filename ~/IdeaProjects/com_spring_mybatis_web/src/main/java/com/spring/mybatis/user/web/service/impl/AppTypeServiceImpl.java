package com.spring.mybatis.user.web.service.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.spring.mybatis.user.web.dao.AppTypeDao;
import com.spring.mybatis.user.web.entity.AppTypeEntity;
import com.spring.mybatis.user.web.service.AppTypeService;

/**
 * ClassName：AppTypeServiceImpl<br>
 * Description：数据库中app_type表对应的实体类        .<br>
 * @author auto
 * @Date 20170829202750
 * @since JRE 1.6.0_22  or higher
 */
@Service
public class AppTypeServiceImpl implements AppTypeService {

	@Resource
	private AppTypeDao appTypeDao;
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return appTypeDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(AppTypeEntity entity) {
		// TODO Auto-generated method stub
		return appTypeDao.insert(entity);
	}

	@Override
	public int insertSelective(AppTypeEntity entity) {
		// TODO Auto-generated method stub
		return appTypeDao.insertSelective(entity);
	}

	@Override
	public AppTypeEntity selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return appTypeDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(AppTypeEntity entity) {
		// TODO Auto-generated method stub
		return appTypeDao.updateByPrimaryKeySelective(entity);
	}

	@Override
	public int updateByPrimaryKey(AppTypeEntity entity) {
		// TODO Auto-generated method stub
		return appTypeDao.updateByPrimaryKey(entity);
	}
	@Override
	public List<AppTypeEntity> getListByPage(int offset, int size) {
		// TODO Auto-generated method stub
		return appTypeDao.getListByPage(offset, size);
	}
}
