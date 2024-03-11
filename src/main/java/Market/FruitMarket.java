package Market;

import CommonEnum.FruitEnum;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liuyu
 * @create 2024-03-11-15:16
 */
public class FruitMarket {
    public FruitMarket(){};

    //原价计价
    public BigDecimal Count(Map<String, BigDecimal> fruitCounts){
        AtomicReference<BigDecimal> total = new AtomicReference<>(new BigDecimal("0"));
        System.out.println(FruitEnum.getPriceByType("1"));
        fruitCounts.forEach((type,count)->{
            BigDecimal result = count.multiply(FruitEnum.getPriceByType(type));
            total.updateAndGet(oldTotal -> oldTotal.add(result));
        });
        return total.get();
    };

    //草莓打折
    public BigDecimal StrawberryDiscount(Map<String, BigDecimal> fruitCounts){
        BigDecimal total = Count(fruitCounts);
        BigDecimal strawberryCount = fruitCounts.get("2");
        BigDecimal originalPrice = strawberryCount.multiply(FruitEnum.Strawberry.price);
        BigDecimal discount = strawberryCount.multiply(FruitEnum.Strawberry.price).multiply(BigDecimal.valueOf(0.8));
        return total.subtract(originalPrice.subtract(discount));
    };

    //草莓打折+满一百减10
    public BigDecimal SubtractTenFromHundred(Map<String, BigDecimal> fruitCounts){
        BigDecimal total = StrawberryDiscount(fruitCounts);
//        System.out.println("满减原价为:" + total);
        //默认向下取整
        BigDecimal discount = total.divideToIntegralValue(new BigDecimal("100"));
        return total.subtract(discount.multiply(BigDecimal.valueOf(10)));
    }


}
