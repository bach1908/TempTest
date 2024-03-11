package CommonEnum;

import java.math.BigDecimal;

/**
 * @author liuyu
 * @create 2024-03-11-15:25
 */
public enum FruitEnum {
    Apple(BigDecimal.valueOf(8),"1"),
    Strawberry(BigDecimal.valueOf(13),"2"),
    Mango(BigDecimal.valueOf(20),"3");

    public BigDecimal price;
    public String type;

    private FruitEnum(BigDecimal price,String type){
        this.price = price;
        this.type = type;
    }

    public static BigDecimal getPriceByType(String targetType) {
        for (FruitEnum fruit : FruitEnum.values()) {
            if (fruit.type.equals(targetType)) {
                return fruit.price;
            }
        }
        return BigDecimal.ZERO;
    }


}
