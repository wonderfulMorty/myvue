package com.yc.morty.myvueback;

import com.yc.morty.myvueback.common.Result;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: com.yc.morty.myvueback
 * <p>
 * Description： TODO
 * <p>
 * Author: wondefulMorty
 * <p>
 * Date: Created in 2021/9/13 22:56
 */
public class MyTest {

    @Test
    public void myTest1(){
        List<MyUser> list =  new ArrayList<>();
        MyUser myUser = new MyUser();
        myUser.setName("morty");
        list.add(myUser);
        myUser.setAge(22);
        System.out.println(list);
        System.out.println(myUser);

        System.out.println(Result.success(myUser));

    }
}
