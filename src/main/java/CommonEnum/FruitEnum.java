import java.math.BigDecimal;

/**
 * @author liuyu
 * @create 2024-03-11-15:25
 */
public enum FruitEnum {
    Apple(BigDecimal.valueOf(8)),
    Strawberry(BigDecimal.valueOf(13));

    private BigDecimal price;

    private FruitEnum(BigDecimal price){
        this.price = price;
    }

}
