package homework.project;
/*
 * 냉장고 안의 식자재 정보는 식자재 이름, 수량, 유통기한, 식자재 설명이 있습니다. 
 * 식자재 정보를 입력받아 배열에 저장해야 합니다. 이름은 문자열로 저장하며, 수량
은 정수, 유통기한은 문자열, 설명은 문자열로 저장합니다. 식자재 정보는 클래스를 
이용하여 데이터를 저장하도록 
 */
public class Food {
    private String foodName;
    private int foodCount;
    private String expiration;
    private String description;

    public Food() {
    }

    public Food(String foodName, int foodCount, String expiration, String description){
        this.foodName = foodName;
        this.foodCount = foodCount;
        this.expiration = expiration;
        this.description = description;
    }

    public String getFoodName() {
        return this.foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodCount() {
        return this.foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }

    public String getExpiration() {
        return this.expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
