package Services;

public interface OnlinePaymentService {

    Double paymentFee(Double amount); // ‘interfaces’ não precisam declarar se que é publico, pois presume-se que o método é publico e abstrato.
    Double interest(Double amount, Integer months);

}
