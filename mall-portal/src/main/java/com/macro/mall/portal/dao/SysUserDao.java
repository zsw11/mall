package com.macro.mall.portal.dao;

import com.macro.mall.portal.domain.SysUser;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author zsw
 * @date 2021/5/11 14:24
 * @description :
 */
public interface SysUserDao extends MongoRepository<SysUser, Integer> {
}
