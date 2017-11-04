package com.spring.mybatis.user.web.service;

import com.spring.mybatis.user.web.entity.UserExtrainfoEntity;
import java.util.List;

/**
 * ClassName：UserExtrainfoService<br>
 * Description：数据库中 t_user_extrainfo表对应的实体类        .<br>
 * @author auto
 * @Date 20170829202750
 * @since JRE 1.6.0_22  or higher
 */
public interface UserExtrainfoService {
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
    int insert(UserExtrainfoEntity entity);

    /**
     * 根据已有数据的列插入数据
     * @param entity
     * @return
     */
    int insertSelective(UserExtrainfoEntity entity);

    /**
     * 根据主键id获取实体
     * @param id
     * @return
     */
    UserExtrainfoEntity selectByPrimaryKey(Long id);

    /**
     * 根据已有数据的列更新数据
     * @param entity
     * @return
     */
    int updateByPrimaryKeySelective(UserExtrainfoEntity entity);

    /**
     * 更新实体信息
     * @param entity
     * @return
     */
    int updateByPrimaryKey(UserExtrainfoEntity entity);   
        /**分页查询
     * @param offset
     * @param size
     * @return
     */
    List<UserExtrainfoEntity>  getListByPage(int offset,int size);
}