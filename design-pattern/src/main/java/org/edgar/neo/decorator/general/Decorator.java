package org.edgar.neo.decorator.general;

public abstract class Decorator extends Component {

    protected Component component;

    // 构造方法传入
    public Decorator(Component component) {
        this.component = component;
    }

    public void operation() {
        // 转发请求给组件对象，可以在转发前后执行一些附加动作
        component.operation();
    }
}
