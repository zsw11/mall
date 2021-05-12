package com.macro.mall.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.portal.dao.SysUserDao;
import com.macro.mall.portal.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author zsw
 * @date 2021/5/11 14:32
 * @description : mongo SysUser
 */
@Service
@Transactional(rollbackForClassName ="Exception")
public class SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    //查询所有
    public Page<SysUser> findAll(int pageNum,int pageSize){
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<SysUser> all = sysUserDao.findAll(pageable);
        return all;
    }

    // 添加
    public SysUser add(SysUser sysUser) {
//        SysUser sysUser = new SysUser();
//        sysUser.setId(1);
//        sysUser.setAge(14);
//        sysUser.setName("zswwww");
        return sysUserDao.insert(sysUser);
    }

    //根据id 查询
    public SysUser getById(int id) {
        Optional<SysUser> byId = sysUserDao.findById(id);
        return byId.get();
    }

    //删除
    public void remove(int id) {
        sysUserDao.deleteById(id);
    }

    //修改
    public SysUser modify(SysUser sysUser) {
//        SysUser sysUser = new SysUser();
//        sysUser.setId(1);
//        sysUser.setAge(58);
//        sysUser.setName("扎三");
        return sysUserDao.save(sysUser);
    }
}

