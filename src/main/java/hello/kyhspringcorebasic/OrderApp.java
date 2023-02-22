package hello.kyhspringcorebasic;

import hello.kyhspringcorebasic.member.Grade;
import hello.kyhspringcorebasic.member.Member;
import hello.kyhspringcorebasic.member.MemberService;
import hello.kyhspringcorebasic.member.MemberServiceImpl;
import hello.kyhspringcorebasic.order.Order;
import hello.kyhspringcorebasic.order.OrderService;
import hello.kyhspringcorebasic.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
//        MemberService memberService = new MemberServiceImpl(null);
//        OrderService orderService = new OrderServiceImpl(null, null);

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = "+ order);
    }
}
