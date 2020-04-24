package com.lin.ai.parsexml;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 15:22 2020/4/13
 */
public class Property {
    private String name;
    private String value;
    private Ref ref;
    private String type;

    public Property() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) throws Exception {
        this.value = value;
    }

    public void setRef(Ref ref) {
        this.ref = ref;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
