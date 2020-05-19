package org.edgar.neo.strategy.marketing;

public class MarketingContext {

    private IMarketing marketing;

    public MarketingContext(IMarketing marketing) {
        this.marketing = marketing;
    }

    public void execute() {
        marketing.doSell();
    }
}
