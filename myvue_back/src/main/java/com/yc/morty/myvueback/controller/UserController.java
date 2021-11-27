package com.yc.morty.myvueback.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yc.morty.myvueback.common.Result;
import com.yc.morty.myvueback.domain.User;
import com.yc.morty.myvueback.mapper.UserMapper;
import com.yc.morty.myvueback.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.PeriodUnit;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Package: com.yc.morty.myvueback.controller
 * <p>
 * Description： TODO
 * <p>
 * Author: wondefulMorty
 * <p>
 * Date: Created in 2021/9/4 19:39
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired(required = false)
    UserMapper userMapper;

    @GetMapping("/findPageUsers")
    public Result<?> findPageUsers(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(User::getNickName, search);
        }
        Page<User> userPage = userMapper.findPage(new Page<>(pageNum, pageSize), search);
        return Result.success(userPage);
    }

    @DeleteMapping("/{id}")
    public Result<?> delUserById(@PathVariable Long id) {
        Integer i = userMapper.deleteById(id);
        if(i>0){
            return Result.success();
        }
        return Result.error("502","删除失败");
    }

    @PostMapping("add")
    public Result<?> add(@RequestBody User user) {
        if (user.getPassword() == null) {
            user.setPassword("123456");
        }
        Integer i = userMapper.insert(user);
        if(i>0){
            return Result.success();
        }
        return Result.error("502","删除失败");
    }

    @PutMapping("update")
    public Result<?> update(@RequestBody User user) {
        Integer i = userMapper.updateById(user);
        if(i>0){
            return Result.success();
        }
        return Result.error("502","修改失败");
    }



}
