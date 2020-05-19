package org.edgar.neo.factory.payfactory;

public class InternalPayFactory extends AbstractPayFactory {

    public IPay create() {
        return null;
    }

    public IPay createAliPay() {
        return new AliPay();
    }

    public IPay createWeChatPay() {
        return new WeChatPay();
    }

    public IPay createUnionPay() {
        return new UnionPay();
    }

}
