package com.aya.bootstrap;

import com.aya.enums.Status;
import com.aya.model.Merchant;
import com.aya.model.Payment;
import com.aya.model.PaymentDetail;
import com.aya.repository.MerchantRepository;
import com.aya.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;


@Component
public class DataGenerator implements CommandLineRunner {
    PaymentRepository paymentRepository;
    MerchantRepository merchantRepository;

    public DataGenerator(PaymentRepository paymentRepository, MerchantRepository merchantRepository) {
        this.paymentRepository = paymentRepository;
        this.merchantRepository = merchantRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Payment payment1 = new Payment(LocalDate.of(2022,4,19),new BigDecimal("150000"), Status.SUCCESS);
        PaymentDetail paymentDetail1 = new PaymentDetail(new BigDecimal("140000"),new BigDecimal("10000"),LocalDate.of(2022,4,24));

        payment1.setPaymentDetail(paymentDetail1);

        Payment payment2 = new Payment(LocalDate.of(2022,4,25),new BigDecimal("100000"), Status.FAILURE);
        PaymentDetail paymentDetail2 = new PaymentDetail(new BigDecimal("90000"),new BigDecimal("5000"),LocalDate.of(2022,4,29));

        payment2.setPaymentDetail(paymentDetail2);

        Merchant merchant1 = new Merchant("AmazonSubMerchant","M123",new BigDecimal("0.25"),new BigDecimal("3.25"),5);

        merchantRepository.save(merchant1);

        payment1.setMerchant(merchant1);
        payment2.setMerchant(merchant1);

        paymentRepository.save(payment1);
        paymentRepository.save(payment2);

    }
}
