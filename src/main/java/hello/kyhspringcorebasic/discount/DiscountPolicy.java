package hello.kyhspringcorebasic.discount;

import hello.kyhspringcorebasic.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member Member, int price);
}
