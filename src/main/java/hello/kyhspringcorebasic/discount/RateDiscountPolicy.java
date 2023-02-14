package hello.kyhspringcorebasic.discount;

import hello.kyhspringcorebasic.member.Grade;
import hello.kyhspringcorebasic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
