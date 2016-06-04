## Spring Boot + Async
+ 在需要异步的方法上使用`@Async`注解标明该方法异步执行。
+ 使用`@EnableAsync`开启异步支持
> 有三个坑需要注意：（1）static方法不能异步；（2）内部调用不能异步；（3）重复扫描不能异步

### 参考文章：
+ [http://www.jianshu.com/p/21f220c12199](http://www.jianshu.com/p/21f220c12199)
+ [http://www.jianshu.com/p/86e915d616c4](http://www.jianshu.com/p/86e915d616c4)
+ [http://www.baeldung.com/spring-async](http://www.baeldung.com/spring-async)