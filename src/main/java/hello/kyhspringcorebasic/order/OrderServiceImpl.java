package hello.kyhspringcorebasic.order;

import hello.kyhspringcorebasic.annotation.MainDiscountPolicy;
import hello.kyhspringcorebasic.discount.DiscountPolicy;
import hello.kyhspringcorebasic.discount.FixDiscountPolicy;
import hello.kyhspringcorebasic.member.Member;
import hello.kyhspringcorebasic.member.MemberRepository;
import hello.kyhspringcorebasic.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
