txdemo
==============

### 广告
    
    专业的人干专业的事,专业的人交流专业的事，专业的人成就专业的事。
    大神，我们期待您的加入！
    QQ群：450794233，程序员工会致力于讨论解决程序员权益的问题！当然少不了技术交流...
    还等什么....快上车
    

### 流程

1. gateway发起请求
2. order生成订单
3. 调用user服务修改余额
4. gateway记录流水

### 要求

1. 步骤2、3、4只有一个步骤出错，他之前的步骤必须事务回滚

### 使用技术

1. springcloud
2. lcn（tcc方式）

### 实现方式

1. 分布式事务本来就不应该出现的

2. 出现这种情况解决方式目前有2PC和TCC

2.1. 2pc

2.1.1. 2pc步骤
    
    阶段1：“准备提交”。事务协调者向所有参与者发起prepare，所有参与者回答yes/no。 
    阶段2：“正式提交”。如果所有参与者都回答yes，则向所有参与者发起commit；否则，向所有参与者发起rollback。 
    因此，要实现2pc，所有参与者，都得实现3个接口：prepare/commit/rollback。

2.1.2. 2pc的问题
    
    （1）阶段2，事务协调者挂了，则所有参与者接受不到commit/rollback指令，将处于“悬而不决”状态 
    （2）阶段2，其中一个参与者超时或者出错，那其他参与者，是commit，还是rollback呢？ 也不能确定
    为了解决2pc的问题，又引入3pc。3pc有类似的挂了如何解决的问题，因此还是没能彻底解决问题，此处就不详述了
    
2.1.3 2pc的实现
     
    关于2pc，对应的实现层面，也就是XA协议。有一个Atomikos开源库，也实现了这个协议

2.2. tcc

2.2.1. tcc步骤
   
    为了解决SOA系统中的分布式事务问题，支付宝提出了TCC。2PC通常都是在跨库的DB层面，而TCC本质就是一个应用层面的2PC。
    同样，TCC中，每个参与者需要3个操作：Try/Confirm/Cancel，也是2个阶段。 
    阶段1：”资源预留/资源检查“，也就是事务协调者调用所有参与者的Try操作 
    阶段2：“一起提交”。如果所有的Try成功，一起执行Confirm。否则，所有的执行Cancel.
    
2.2.2. 问题
    
    业务实现过于复杂

2.2.3. 实现
    
    LCN
    
### 总结
    
    分布式事务其实最终必须成功，所以解决方式是有错误重试，如果重试次数还没有解决，提交日志，人工处理，重试时可以使用mq的ack机制(框架有myth,coolmq)，所以如果强一致性，先考虑枷锁,然后在考虑Atomikos
    


    

