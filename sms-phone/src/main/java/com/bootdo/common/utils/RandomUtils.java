package com.bootdo.common.utils;

import java.util.Random;

/**
 * @Author:luiz
 * @Date: 2018/8/6 14:50
 * @Descripton:
 * @Modify :
 **/
public class RandomUtils {
    /**
     * 生成随机码值，包含数字、大小写字母
     * @author 郑明亮
     * @param number 生成的随机码位数
     * @return
     */
    public static String getRandomCode(int number){
        String codeNum = "";
        int [] code = new int[3];
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            int num = random.nextInt(10) + 48;
            int uppercase = random.nextInt(26) + 65;
            int lowercase = random.nextInt(26) + 97;
            code[0] = num;
            code[1] = uppercase;
            code[2] = lowercase;
            codeNum+=(char)code[random.nextInt(3)];
        }
        System.out.println(codeNum);

        return codeNum;
    }

}
