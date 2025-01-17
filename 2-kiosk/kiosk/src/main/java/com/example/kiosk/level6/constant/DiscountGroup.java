package com.example.kiosk.level6.constant;

public enum DiscountGroup {
    NATIONAL_HONOREE(1,"국가유공자",0.10),
    SOLDIER(2,"군인",0.05),
    STUDENT(3,"학생",0.03),
    DEFAULT(4,"일반",0.0);

    private final int id;
    private final String koreanName;
    private final Double discountRate;

    DiscountGroup(int id, String koreanName, Double discountRate) {
        this.id = id;
        this.koreanName = koreanName;
        this.discountRate = discountRate;
    }

    public int getId() {
        return id;
    }

    public String getKoreanName() {
        return koreanName;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public static DiscountGroup fromId(int id) {
        for(DiscountGroup group: values()) {
            if(group.getId() == id) {
                return group;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 DiscountGroup Id : "+id);
    }
}
