package org.ligson.user;

import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/***
 * <!-- ***************事务配置************** -->
 */
@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
public class TxConfig {
    @Autowired
    private PlatformTransactionManager transactionManager;

    // 创建事务通知
    @Bean(name = "txAdvice")
    public TransactionInterceptor transactionInterceptor() {
        NameMatchTransactionAttributeSource attributeSource = new NameMatchTransactionAttributeSource();
        DefaultTransactionAttribute queryTx = new DefaultTransactionAttribute();
        queryTx.setReadOnly(true);

        DefaultTransactionAttribute modifyTx = new DefaultTransactionAttribute();
        modifyTx.rollbackOn(new Exception());
        modifyTx.setPropagationBehaviorName("PROPAGATION_REQUIRED");

        attributeSource.addTransactionalMethod("get*", queryTx);
        attributeSource.addTransactionalMethod("query*", queryTx);
        attributeSource.addTransactionalMethod("find*", queryTx);
        attributeSource.addTransactionalMethod("load*", queryTx);
        attributeSource.addTransactionalMethod("select*", queryTx);
        attributeSource.addTransactionalMethod("delete*", modifyTx);
        attributeSource.addTransactionalMethod("save*", modifyTx);
        attributeSource.addTransactionalMethod("update*", modifyTx);
        attributeSource.addTransactionalMethod("insert*", modifyTx);
        attributeSource.addTransactionalMethod("add*", modifyTx);
        attributeSource.addTransactionalMethod("*", modifyTx);
        TransactionInterceptor tsi = new TransactionInterceptor(transactionManager, attributeSource);
        return tsi;
    }

    /**
     * 切面拦截规则 参数会自动从容器中注入
     */
    @Bean
    public AspectJExpressionPointcutAdvisor pointcutAdvisor() {
        AspectJExpressionPointcutAdvisor pointcutAdvisor = new AspectJExpressionPointcutAdvisor();
        pointcutAdvisor.setAdvice(transactionInterceptor());
        pointcutAdvisor.setExpression("execution(* com.xb..*.service..*Impl.*(..))");
        return pointcutAdvisor;
    }
}
