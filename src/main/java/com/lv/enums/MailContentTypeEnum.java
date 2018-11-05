package com.lv.enums;

/**
 * Created by simperLv
 * on 2018/10/09 16:52
 *
 * @Description //TODO
 */
public enum MailContentTypeEnum {
    HTML("text/html;charset=UTF-8"), //html格式
    TEXT("text");

    private String value;

    MailContentTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
