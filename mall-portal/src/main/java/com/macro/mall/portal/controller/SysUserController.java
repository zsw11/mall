package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.portal.domain.SysUser;
import com.macro.mall.portal.service.impl.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author zsw
 * @date 2021/5/11 15:48
 * @description :mongo
 */
@RestController
@RequestMapping("/mongo")
@Api(description = "mongo 测试 sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/findAll")
    public CommonResult<Page<SysUser>> findAll(@RequestParam int pageNum, @RequestParam int pageSize) {
        Page<SysUser> all = sysUserService.findAll(pageNum, pageSize);
        return CommonResult.success(all);
    }

    @PostMapping("/add")
    public CommonResult<SysUser> add(@RequestBody @ApiParam(value = "用户") SysUser sysUser) {
        SysUser add = sysUserService.add(sysUser);
        return CommonResult.success(add);
    }

    @GetMapping("/get")
    public CommonResult<SysUser> getById(@PathVariable @ApiParam("用户id")int id) {
        SysUser byId = sysUserService.getById(id);
        return CommonResult.success(byId);
    }

    @DeleteMapping("/delete")
    public CommonResult<Integer> delete(@PathVariable int id) {
        sysUserService.remove(id);
        return CommonResult.success(id);
    }

    @PutMapping("/update")
    public CommonResult<SysUser> update(@RequestBody SysUser sysUser) {
        SysUser modify = sysUserService.modify(sysUser);
        return CommonResult.success(modify);
    }

}
