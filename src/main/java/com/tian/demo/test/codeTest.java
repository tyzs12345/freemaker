package com.tian.demo.test;


import com.tian.demo.util.CodeGeneraterUtil;

public class codeTest {

    public static void main(String[] args)throws Exception {

        CodeGeneraterUtil codeGeneraterUtil = new CodeGeneraterUtil();
        codeGeneraterUtil.codeGenerater("com.coffeebean.module.swipe", "t_user_discount_code_other","123","t_");

    }
}
