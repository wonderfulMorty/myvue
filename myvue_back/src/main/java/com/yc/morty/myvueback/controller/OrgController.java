package com.yc.morty.myvueback.controller;

import com.alibaba.fastjson.JSON;
import com.yc.morty.myvueback.common.Result;
import com.yc.morty.myvueback.domain.Org;
import com.yc.morty.myvueback.mapper.OrgMapper;
import com.yc.morty.myvueback.vo.OrgVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: com.yc.morty.myvueback.controller
 * <p>
 * Description： TODO
 * <p>
 * Author: wondefulMorty
 * <p>
 * Date: Created in 2021/9/8 15:30
 */
@RestController
@Slf4j
@RequestMapping("/org")
public class OrgController {
    @Autowired(required = false)
    OrgMapper orgMapper;

    /**
     * 递归查询子集
     * 思想：
     * 遍历list,找到父节点
     * 利用父节点找到子节点，找到子节点后，
     * 把这次子节点加入到list,这次的子节点作为下一次的父节点，继续遍历
     *
     * @param pid
     * @param allOrgs
     * @return
     */
    private List<OrgVO> loopQuery(Integer pid, List<OrgVO> allOrgs) {
        List<OrgVO> orgList = new ArrayList<>();
        for (OrgVO org : allOrgs) {
            if (pid == 0) {
                if (org.getPid() == 0) {
                    orgList.add(org);
                    org.setChildrenOrgs(loopQuery(org.getId(), allOrgs));
                }
            } else if (pid.equals(org.getPid())) {
                orgList.add(org);
                org.setChildrenOrgs(loopQuery(org.getId(), allOrgs));
            }
        }
        return orgList;
    }


    /**
     * 分类父子查询
     *
     * @return
     */
    @GetMapping("/getAllOrgs")
    public Result<?> getAll() {
        // 先查询所有的数据
        List<Org> allOrgs = orgMapper.selectList(null);
        //将查询出来的Org实体列表转换成OrgVO视图对象
        List<OrgVO> allOrgVOs = JSON.parseArray(JSON.toJSONString(allOrgs), OrgVO.class);
        //将视图对象利用递归算法，
        return Result.success(loopQuery(0, allOrgVOs));
    }


    /*
    增加Org节点
     */
    @PostMapping("/add")
    public Result<?> addOrg(@RequestBody Org org){
        orgMapper.insert(org);
        return Result.success();
    }

    /*
    * 删除节点
    *
    * */
    @DeleteMapping("/del")
    public Result<?> delOrg(@RequestParam("id")Integer id){
        orgMapper.deleteById(id);
        return Result.success();
    }

    /*
    * 修改节点
    * */
    @PutMapping("/update")
    public Result<?> updateOrg(@RequestBody Org org){
        orgMapper.updateById(org);
        return Result.success();
    }





}
