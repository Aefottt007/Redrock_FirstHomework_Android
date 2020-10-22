package com.redrock.firstHomework;
/*
    点餐系统
 */
public class Level3 {
    public static class foodKind{
        String foodName;
        int foodPrice;
        int foodNumber;
    }
    public static class canteen{
        String canteenName;
        public void pay(){
            System.out.println("1.支付宝\n2.微信\n3.人脸识别");
        }
        public void welcom(){
            System.out.println("欢迎来到国民饭店，这是今天的菜单：");
        }
    }
}
