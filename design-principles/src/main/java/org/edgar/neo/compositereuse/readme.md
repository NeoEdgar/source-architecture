# 合成复用原则

合成复用原则（Composite/Aggregate Reuse Principle,CARP）
是指尽量使用对象组合(has-a)/ 聚合(contanis-a)，而不是继承关系(is-a)达到软件复用的目的。
可以使系统更加灵活，降低类与类之间的耦 合度，一个类的变化对其他类造成的影响相对较少。 

继承我们叫做白箱复用，相当于把所有的实现细节暴露给子类。
组合/聚合也称之为黑箱复用，对类以外的对象是无法获取到实现细节的。

要根据具体的业务场景来做代码设计，其实也都需要遵循 OOP 模型。