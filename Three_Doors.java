import java.util.Random;
//有一说一，为什么换之后是汽车的概率是2/3，我依然理解不了，
//写了段代码来验证，代码是不会骗人的（除非我写错了）
public class Three_Doors {
    //对题意的一些陈述：主持人知道汽车的所在，
    // 从2，3号门中打开了一扇有山羊的门，
    // 而不是主持人打开了2，3门中的其中一个，恰好是山羊。
    public static void main(String[] args) {
        //得出五次结果，每次结果均是通过100000个案例得出的
        for (int j = 0; j < 5; j++) {
            int count = 0;//100000次中得到汽车的次数
            for (int i = 0; i < 100000; i++) {
                Random random = new Random();
                //car 是1~3的一个随机整数，表示哪个门后面有汽车
                int car = random.nextInt(3) + 1;
                //此数组中存三个数据，1代表汽车，0代表山羊
                //three_doors[0]代表一号门，以此类推
                int[] three_doors = new int[3];
                three_doors[car - 1] = 1;
                int show ;//show表示主持人打开了几号门
                if (three_doors[1] == 1) {
                    show = 3;
                } else if (three_doors[2] == 1) {
                    show = 2;
                } else {
                    //这里show随机为2或3
                    show = random.nextInt(2) + 2;
                }
                if (three_doors[4 - show] == 1) {
                    count++;//换之后如果是汽车，count就+1
                }
            }
            //换之后得到汽车的概率
            double get_car = 1.0 * count / 100000;
            System.out.println(get_car);
        }
    }
}
