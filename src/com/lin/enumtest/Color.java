package com.lin.enumtest;

public enum Color {

    RED(0, "红色"),
    BLUE(1, "蓝色"),
    GREEN(2, "绿色"),
    ;

    private int code;
    private String desc;

    Color(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static Color getValue(int code) {

        for (Color color : values()) {
            if (color.getCode() == code) {
                return color;
            }
        }
        return null;

    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Color{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }

    public static void main(String[] args) {
        //System.out.println(Color.valueOf("RED").code);
        Color c = Color.GREEN;
        System.out.println(c+"1");
    }

}
