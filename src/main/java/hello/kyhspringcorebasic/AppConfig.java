package hello.kyhspringcorebasic;

import hello.kyhspringcorebasic.discount.DiscountPolicy;
import hello.kyhspringcorebasic.discount.FixDiscountPolicy;
import hello.kyhspringcorebasic.discount.RateDiscountPolicy;
import hello.kyhspringcorebasic.member.MemberRepository;
import hello.kyhspringcorebasic.member.MemberService;
import hello.kyhspringcorebasic.member.MemberServiceImpl;
import hello.kyhspringcorebasic.member.MemoryMemberRepository;
import hello.kyhspringcorebasic.order.OrderService;
import hello.kyhspringcorebasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
