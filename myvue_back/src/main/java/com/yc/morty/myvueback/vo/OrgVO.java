package com.yc.morty.myvueback.vo;

import com.yc.morty.myvueback.domain.Org;
import lombok.Data;

import java.util.List;

/**
 * Package: com.yc.morty.myvueback.vo
 * <p>
 * Description： TODO
 * <p>
 * Author: wondefulMorty
 * <p>
 * Date: Created in 2021/9/8 15:35
 */

/*
org实体对应的vo层
org在数据库中只有name、id和pid，但是，web要求还要传children
所以，在这里要构造一个children
* */
@Data
public class OrgVO extends Org {
    List<OrgVO> childrenOrgs;
}
