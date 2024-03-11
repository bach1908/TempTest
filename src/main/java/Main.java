import Market.FruitMarket;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @author liuyu
 * @create 2024-03-11-16:16
 */
public class Main {
    public static void main(String[] args) {
        FruitMarket fruitMarket = new FruitMarket();
        //由枚举类可知苹果type为1 草莓2 芒果3
        //使用HashMap构建题目四种情况测试方法:

        //1.
        HashMap<String, BigDecimal> test1 = new HashMap<>();
        test1.put("1",BigDecimal.valueOf(0.5));
        test1.put("2",BigDecimal.valueOf(3));
        System.out.println("题目一 买苹果和草莓的结果为:" + fruitMarket.Count(test1));

        //2.
        HashMap<String, BigDecimal> test2 = new HashMap<>();
        test2.put("1",BigDecimal.valueOf(0.5));
        test2.put("2",BigDecimal.valueOf(3));
        test2.put("3",BigDecimal.valueOf(2.3));
        System.out.println("题目二 买苹果、草莓和芒果的结果为:" + fruitMarket.Count(test2));

        //3.
        System.out.println("题目三 买苹果、草莓和芒果 但是草莓打折的结果为:" + fruitMarket.StrawberryDiscount(test2));

        //4.
        System.out.println("题目四 买苹果、草莓和芒果 但是草莓打折 且满100减10的结果为:" + fruitMarket.SubtractTenFromHundred(test2));
        test2.put("3",BigDecimal.valueOf(10));
        System.out.println("题目四 买苹果、草莓和芒果 但是草莓打折 且满100减10的结果为:" + fruitMarket.SubtractTenFromHundred(test2));



    }
}
