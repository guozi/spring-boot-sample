## Spring Boot + Event

Spring Boot 目前支持的事件类型有如下五种：
+ ApplicationStartedEvent
+ ApplicationEnvironmentPreparedEvent
+ ApplicationPreparedEvent
+ ApplicationReadyEvent
+ ApplicationFailedEvent



`ApplicationStartedEvent` ：Spring Boot 启动开始时执行的事件，在该事件中可以获取到`SpringApplication`对象，可做一些执行前的设置。

`ApplicationEnvironmentPreparedEvent`：Spring Boot 运行环境已准备完成，但是`spring`上下文`context`还没有准备好，在该监听中获取到`ConfigurableEnvironment`后可以对配置信息做操作，例如：修改默认的配置信息，增加额外的配置信息等等。

`ApplicationPreparedEvent`：Spring Boot运行上下文context已创建完成，但是`spring`中的`bean`还没有加载完成。在获取完上下文后，可以将上下文传递出去做一些额外的操作。**在该监听器中是无法获取自定义bean并进行操作的**。

`ApplicationReadyEvent`： Spring Boot中所有的`bean`已加载完成。应用已经启动，可以接收请求。

`ApplicationFailedEvent`：Spring Boot启动异常时执行的事件。在异常发生时，最好是添加虚拟机对应的钩子进行资源的回收与释放，能友善的处理异常信息。



