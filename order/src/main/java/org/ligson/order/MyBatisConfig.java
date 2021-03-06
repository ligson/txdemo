package org.ligson.order;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ligson on 2017/4/19.
 */
@Configuration
public class MyBatisConfig {
    private static Logger logger = LoggerFactory.getLogger(MyBatisConfig.class);

    @Bean(name = "sessionFactory")
    public static SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //bean.setTypeAliasesPackage("com.xb.sbm.domain");


        //添加插件
        //bean.setPlugins(new Interceptor[]{pagePlugin});

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            //mapper
            List<Resource> mapperResources = new ArrayList<>();
            Resource[] resources = resolver.getResources("classpath:META-INF/mybatis/mapper/*.xml");
            mapperResources.addAll(Arrays.asList(resources));
            mapperResources.add(resolver.getResource("classpath:META-INF/mybatis/ReuseSQL.xml"));
            bean.setMapperLocations(mapperResources.toArray(resources));

            //config
            bean.setConfigLocation(resolver.getResource("classpath:META-INF/mybatis/mybatis-config.xml"));
            return bean.getObject();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    @Bean
    public static SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
