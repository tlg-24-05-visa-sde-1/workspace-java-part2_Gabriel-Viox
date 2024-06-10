package gov.irs;

public interface IRS {
    public void collectTaxes();
    public void register(TaxPayer payer);

    // static factory method - clients Must come here for the instance (i.e, IRSEnum.INSTANCE)
    public static IRS getInstance(){
        return IRSEnum.INSTANCE;
    }
}
