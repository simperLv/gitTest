package com.lv;

import com.lv.core.MailSender;
import com.lv.enums.MailContentTypeEnum;

import java.util.ArrayList;

/**
 * Created by simperLv
 * on 2018/10/09 17:13
 *
 * @Description //TODO
 */
public class MailTest {
    public static void main(String[] args) throws Exception
    {
        new MailSender()
                .title("javamail")
                .content("今天天气真好")
                .contentType(MailContentTypeEnum.TEXT)
                .targets(new ArrayList<String>(){{
                    add("593324988@qq.com");
                }})
                .send();
    }
}
