package billydev;

public class InnerClassSingletonDemo {
    private InnerClassSingletonDemo(){

    }

    private static class Inner {
        private static InnerClassSingletonDemo innerClassSingletonDemo= new InnerClassSingletonDemo();
    }
    public static InnerClassSingletonDemo getInstance(){
        return Inner.innerClassSingletonDemo;
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
                System.out.println(getInstance());
            }).start();
        }
    }
}
