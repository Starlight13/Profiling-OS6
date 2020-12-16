package com.company;

//public class Main {
//
//
//    static boolean func1(int a) throws InterruptedException {
//        for(int i = 0; i < 100000000; i++)
//        {
//            Thread.sleep(1);
//            if(i>a)
//                return true;
//
//        }
//
//        return false;
//    }
//
//    static boolean func2() throws InterruptedException {
//        for(int i = 0; i < 10; i++)
//        {
//            Thread.sleep(10000000);
//        }
//        return false;
//    }
//    static boolean func3(int b) throws InterruptedException {
//        for(int i = 10; i > 3; i++)
//        {
//            Thread.sleep(1);
//            if(i<b)
//                return true;
//        }
//        return false;
//    }
//
//
//    public static void main(String[] args) throws InterruptedException {
//        System.out.println("\n Inside main()\n");
//
//        int i = 0;
//
//        for(;i<10;i++);
//        {
//            for(int j=1000000; j > 0; j--)
//            {
//                if(func1(i) || func2() || func3(j)){
//                System.out.println("\n Inside if()\n");
//            }
//            }
//        }
//    }
//}

public class Main {


    static boolean func1(int a){
            if(a < 100000000)
                return true;

        return false;
    }

    static boolean func3(int b){
        if (b > 10)
                return true;
        return false;
    }


    public static void main(String[] args){
        System.out.println("\n Inside main()\n");

        int i = 0;

        for(;i<10;i++);
        {
            for(int j=1000000; j > 0; j--)
            {
                if(func1(i) || func3(j)){
                    System.out.println("\n Inside if()\n");
                }
            }
        }
    }
}
