package org.edgar.neo.factory.abstractfactory;

/**
 * 抽象工厂 遵循单一原则 也很复杂
 *
 * 产品族：一系列相关的产品，整合到一起有关联性
 * 产品等级：同一个继承体系
 *
 * 对比接口实现
 */
public abstract class CourseFactory {

    public void init() {
        System.out.println("init data...");
    }

    protected abstract INote createNode();

    protected abstract IVideo createVideo();

}
