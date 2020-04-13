package com.lyh.zone.common.config.thymeleaf.dialect;


import com.lyh.zone.common.config.thymeleaf.tag.ThSysTagProcessor;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.standard.processor.StandardXmlNsTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.HashSet;
import java.util.Set;

/**
 * 项目名称：zone
 * 类名称：ThSysDialect
 * 类描述：系统方言
 */
public class ThSysDialect extends AbstractProcessorDialect {

    //定义方言名称
    private static final String DIALECT_NAME="Sys Dialect";

    public ThSysDialect(){
        //设置自定义方言与方言处理器优先级相同
        super(DIALECT_NAME,"thSys", StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(String s) {
        Set<IProcessor> processors=new HashSet<>();
        processors.add(new ThSysTagProcessor(s));
        processors.add(new StandardXmlNsTagProcessor(TemplateMode.HTML,s));
        return processors;
    }
}
