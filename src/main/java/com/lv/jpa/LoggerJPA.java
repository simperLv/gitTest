package com.lv.jpa;

import com.lv.model.LoggerInfos;
import jdk.nashorn.internal.runtime.options.LoggingOption;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by simperLv
 * on 2018/10/13 10:51
 *
 * @Description //TODO
 */
public interface LoggerJPA extends JpaRepository<LoggerInfos,Long> {
}
