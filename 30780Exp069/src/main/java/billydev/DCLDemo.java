package billydev;

public class DCLDemo {

    private static volatile DCLDemo dclDemo;

    private DCLDemo(){

    }

    public static DCLDemo getInstance() {
        if (dclDemo == null) {
            synchronized (DCLDemo.class) {
                if (dclDemo == null) {
                    dclDemo = new DCLDemo();
                  }
            }
        }
        return dclDemo;
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            new Thread(()->{
                System.out.println(DCLDemo.getInstance());

            }).start();
        }
    }

}
