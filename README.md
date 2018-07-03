txdemo
==============

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

