package com.spring.mybatis.user.web.service;

import com.spring.mybatis.user.web.entity.UserAreaEntity;
import java.util.List;

/**
 * ClassName：UserAreaService<br>
 * Description：数据库中 t_user_area表对应的实体类        .<br>
 * @author auto
 * @Date 20170829202750
 * @since JRE 1.6.0_22  or higher
 */
public interface UserAreaService {
    /**
     * 根据主键id删除数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入数据
     * @param entity
     * @return
     */
    int insert(UserAreaEntity entity);

    /**
     * 根据已有数据的列插入数据
     * @param entity
     * @return
     */
    int insertSelective(UserAreaEntity entity);

    /**
     * 根据主键id获取实体
     * @param id
     * @return
     */
    UserAreaEntity selectByPrimaryKey(Long id);

    /**
     * 根据已有数据的列更新数据
     * @param entity
     * @return
     */
    int updateByPrimaryKeySelective(UserAreaEntity entity);

    /**
     * 更新实体信息
     * @param entity
     * @return
     */
    int updateByPrimaryKey(UserAreaEntity entity);   
        /**分页查询
     * @param offset
     * @param size
     * @return
     */
    List<UserAreaEntity>  getListByPage(int offset,int size);
}