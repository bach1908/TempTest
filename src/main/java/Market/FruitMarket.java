import CommonEnum.FruitEnum;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author liuyu
 * @create 2024-03-11-15:16
 */
public class FruitMarket {

    //原价计价
    public BigDecimal Count(Map<String, BigDecimal> fruitCounts){
        BigDecimal total = new BigDecimal("0");
        fruitCounts.forEach((type,count)->
        total.add(count.multiply(FruitEnum.getPriceByType(type)))
        );
        return total;
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
        BigDecimal discount = total.divideToIntegralValue(new BigDecimal("100"));
        
    }


}
