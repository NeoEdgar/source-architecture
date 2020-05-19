package org.edgar.neo.factory.payfactory;

public class IInternationalPayFactory extends AbstractPayFactory {

    public IPay create() {
        return new ApplePay();
    }
}
