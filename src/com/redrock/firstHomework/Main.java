package com.redrock.firstHomework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Level1作业
//        level1();

        //Level2作业
//        level2();

        //Level3作业
//        level3();

        //Level4作业
        level4();
    }

    //level4
    static void level4() {
        MutableArraylist arr = new MutableArraylist();
        arr.add("红岩网校冲冲冲！0");
        System.out.println(arr.get(0));
        System.out.println("一共有" + arr.size() + "个元素");
        arr.add("红岩网校冲冲冲！1");
        arr.add("红岩网校冲冲冲！2");
        arr.add("红岩网校冲冲冲！3");
        arr.add("红岩网校冲冲冲！4");
        arr.add("红岩网校冲冲冲！5");
        arr.add("红岩网校冲冲冲！6");
        arr.add("红岩网校冲冲冲！7");
        arr.add("红岩网校冲冲冲！8");
        arr.add("红岩网校冲冲冲！9");
        arr.add("红岩网校冲冲冲！10");
        arr.add("红岩网校冲冲冲！11");
        arr.add("红岩网校冲冲冲！12");
        arr.add("红岩网校冲冲冲！13");
        arr.add("红岩网校冲冲冲！14");
        arr.add("红岩网校冲冲冲！15");
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
        System.out.println("一共有" + arr.size() + "个元素");
        System.out.println("数组大小为"+arr.length());
    }

    public static class MutableArraylist {
        private int size = 5;//初始数组元素默认大小为5
        private Object[] elementData = new Object[this.size];
        /*
            返回数组的有效长度
         */
        public int size() {
            return getLength(this.elementData);
        }

        /*
            返回数组容量大小
         */
        public int length() {
            return this.elementData.length;
        }

        /*
            添加数组元素
         */
        public void add(Object obj) {
            if (getLength(this.elementData) >= this.elementData.length) {
                //扩容
                this.elementData = largeArr(this.elementData);
            }
            this.elementData[getLength(this.elementData)] = obj;
        }

        public void add(int index, Object obj) {
            while (index >= elementData.length) {
                //扩容
                this.elementData = largeArr(this.elementData);
            }
            this.elementData[index] = obj;
        }

        /*
            移除数组元素
         */
        public void remove(int index) {
            if (index >= elementData.length)
                System.out.println("超出数组最大下标");
            else
                this.elementData[index] = null;
        }

        public void remove(Object obj) {
            boolean isRemove = false;
            for (int i = 0; i < elementData.length; i++) {
                if (this.elementData[i] == obj) {
                    this.elementData[i] = null;
                    break;
                }
            }
            if(isRemove) System.out.println("替换成功");
            else System.out.println("查无此元素");
        }

        /*
            获取数组元素
         */
        public Object get(int index) {
            return elementData[index];
        }

        /*
            自动为数组扩容，如果数组储存达到上限，每次给数组长度加5
        */
        private Object[] largeArr(Object[] obj) {
            Object[] target = new Object[obj.length + 5];
            for (int i = 0; i < obj.length; i++) target[i] = obj[i];
            return target;
        }

        /*
            判断数组的有效长度
        */
        private int getLength(Object[] obj) {
            int length = 0;
            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null) length++;
            }
            return length;
        }
    }

    //level1
    static void level1() {
        int[] num1 = {15, 25, 10, 30, 40, 20, 50, 0};
        maoPao(num1);//先冒泡排序
        System.out.println("输入数字：");
        Scanner sc = new Scanner(System.in);
        int theNum = sc.nextInt();
        insertNum(num1, theNum);//再插入数字
    }

    //冒泡排序函数
    static void maoPao(int[] num1) {
        for (int i = 0; i < num1.length - 2; i++) {
            for (int j = 0; j < num1.length - 2 - i; j++) {
                if (num1[j] > num1[j + 1]) {
                    int temp = num1[j];
                    num1[j] = num1[j + 1];
                    num1[j + 1] = temp;
                }
            }
        }
        System.out.println("冒泡排序后的结果是：");
        for (int k = 0; k < num1.length - 1; k++) System.out.print(num1[k] + " ");
        System.out.println();
    }

    //插入算法函数
    static void insertNum(int[] num1, int a) {
        for (int i = 0; i < num1.length - 1; i++) {
            //先判断插入的数字是否比原数组中最大的数还要大
            if (a > num1[num1.length - 2]) {
                num1[num1.length - 1] = a;
                break;
            }
            //先把后面的数依次后排，然后再把插入的数放进去
            if (a <= num1[i]) {
                for (int j = num1.length - 1; j > i; j--) {
                    num1[j] = num1[j - 1];
                }
                num1[i] = a;
                break;
            }
        }
        System.out.println("插入后的结果是：");
        for (int num : num1) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    //level2
    static void level2() {
        System.out.println("输入行列数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] num1 = new int[n][n];
        int[][] num2 = new int[n][n];
        /*
            创建随机数组
         */
        Random ran = new Random(1);
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                num1[i][j] = (int) (Math.random() * 10);//生成[0,10)的随机数
                num2[i][j] = (int) (Math.random() * 10);
            }
        }
        /*
            打印随机数组
         */
        System.out.println("随机对称矩阵A：");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print("\t" + num1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("随机对称矩阵B：");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print("\t" + num2[i][j] + " ");
            }
            System.out.println();
        }
        /*
            矩阵相乘并打印
         */
        int[][] result = new int[n][n];
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += num1[i][k] * num2[k][j];
                }
            }
        }
        System.out.println("相乘后的矩阵为：");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print("\t" + result[i][j] + " ");
            }
            System.out.println();
        }
        /*
            对角线之和
         */
        int sum = 0;
        for (i = 0; i < n; i++) {
            sum += result[i][i];
        }
        System.out.println("对角线之和为：" + sum);
    }

    /*
        Level3
     */
    static void level3() {
        //添加菜单
        Level3.foodKind[] order = new Level3.foodKind[5];
        for (int i = 0; i < 5; i++) {
            order[i] = new Level3.foodKind();
        }
        order[0].foodName = "辣子鸡丁";
        order[0].foodNumber = 1;
        order[0].foodPrice = 38;
        order[1].foodName = "水煮肉片";
        order[1].foodNumber = 2;
        order[1].foodPrice = 22;
        order[2].foodName = "糖醋里脊";
        order[2].foodNumber = 3;
        order[2].foodPrice = 18;
        order[3].foodName = "干锅牛肉";
        order[3].foodNumber = 4;
        order[3].foodPrice = 38;
        order[4].foodName = "干锅排骨";
        order[4].foodNumber = 5;
        order[4].foodPrice = 29;
        Level3.canteen canteen = new Level3.canteen();
        //欢迎光临
        canteen.welcom();
        //点菜循环系统
        Scanner sc = new Scanner(System.in);
        int[] orderGuess = new int[10];
        int i = 0, sum = 0;
        while (true) {
            printOrder(order);
            System.out.println("请输入想点的菜的序号：（空格键分割，输入大于5的数字结束点菜,最多十道菜哦，勤俭节约从我做起）");
            //开始开始点菜
            while (true) {
                int num = sc.nextInt();
                if (num < 1 || num > 5) break;
                else orderGuess[i] = num;
                i++;
            }
            System.out.println("您一共选了：");
            for (i = 0; orderGuess[i] != 0; i++) {
                System.out.println(order[orderGuess[i] - 1].foodName + " " + order[orderGuess[i] - 1].foodPrice + "元");
                sum += order[orderGuess[i] - 1].foodPrice;
            }
            System.out.println("共计" + sum + "元");
            System.out.println("还有想点的菜吗？（输入0退出，输入1继续点菜）");
            if (sc.nextInt() == 0) break;
        }
        System.out.println("一共消费" + sum + "元，请选择消费方式：");
        while (true) {
            canteen.pay();
            int payWay = sc.nextInt();
            if (payWay == 1 || payWay == 2) {
                System.out.println("出示付款码.....");
                break;
            } else if (payWay == 3) {
                System.out.println("请对准脸");
                break;
            } else System.out.println("请输入正确的付款方式。");
        }
        System.out.println("支付成功，祝您用餐愉快！");
    }

    static void printOrder(Level3.foodKind[] order) {
        for (int i = 0; i < 5; i++) {
            System.out.println(order[i].foodNumber + "." + order[i].foodName + "  " + order[i].foodPrice + "元");
        }
    }
}
