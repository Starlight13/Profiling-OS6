# Profiling-OS6
Profiling tools are useful for exploring which methods are run most of the time. They can help you find the most expensive methods and understand exactly how they behave.

IntelliJ IDEA is integrated with the following profiling tools:
1. Async Profiler: a CPU and memory profiling tool for Linux and macOS.
2. Java Flight Recorder: a CPU tool provided by Oracle available on Linux, macOS, and Windows.

Async Profiler monitors JVM-level parameters of your application to provide a better understanding of how your application is executed and how exactly memory and CPU resources are allocated. This data can help you find and resolve performance problems and bottlenecks.

Async Profiler does not require threads to be at safe points to be able to sample stacks, which means that it avoids the safepoint bias problem. On top of that, the profiler features Flame Graph support that allows it to visualize stack traces.

### Given code
```java
public class Main {


    static boolean func1(int a) throws InterruptedException {
        for(int i = 0; i < 100000000; i++)
        {
            Thread.sleep(1);
            if(i>a)
                return true;

        }

        return false;
    }

    static boolean func2() throws InterruptedException {
        for(int i = 0; i < 10; i++)
        {
            Thread.sleep(10000000);
        }
        return false;
    }
    static boolean func3(int b) throws InterruptedException {
        for(int i = 10; i > 3; i++)
        {
            Thread.sleep(1);
            if(i<b)
                return true;
        }
        return false;
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println("\n Inside main()\n");

        int i = 0;

        for(;i<10;i++);
        {
            for(int j=1000000; j > 0; j--)
            {
                if(func1(i) || func2() || func3(j)){
                System.out.println("\n Inside if()\n");
            }
            }
        }
    }
}
```
This code was sterted with a CPU profiler, but there was an infinite loop, so the process was stopped, after 2 minutes of execution, when enough information was geathered.
![Profiler before modification](https://github.com/Starlight13/Profiling-OS6/blob/main/Screen1.png)

### Code modifications
```java
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
```
Listed modifications
1. Removed all sleeps in the thread.
2. The function `func2` had no purpose, so it was removed.
3. The logic behind `func1` was to check if a is less than 100000000. So I changed a loop into 1 if statement.
4. The logic behind `func3` was to check if b is bigger than 10. So I changed a loop into 1 if statement.

### Results
After the listed modifications, the code ran without any issues. The infinite loop was removed and the program maintained it's logic.
The profiler results were much better and the program was executed in 7 seconds, which means that the performance was greatly improved.
![Profiler after modification](https://github.com/Starlight13/Profiling-OS6/blob/main/Screen2.png)

