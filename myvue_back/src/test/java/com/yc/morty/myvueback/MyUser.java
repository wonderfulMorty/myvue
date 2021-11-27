package com.yc.morty.myvueback;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Package: com.yc.morty.myvueback
 * <p>
 * Description： TODO
 * <p>
 * Author: wondefulMorty
 * <p>
 * Date: Created in 2021/9/13 22:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyUser {
    private String name;
    private Integer age;

   /* @Override
    public String toString() {
        return "MyUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }*/
}
