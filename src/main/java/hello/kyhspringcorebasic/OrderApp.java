package hello.kyhspringcorebasic;

import hello.kyhspringcorebasic.member.Grade;
import hello.kyhspringcorebasic.member.Member;
import hello.kyhspringcorebasic.member.MemberService;
import hello.kyhspringcorebasic.member.MemberServiceImpl;
import hello.kyhspringcorebasic.order.Order;
import hello.kyhspringcorebasic.order.OrderService;
import hello.kyhspringcorebasic.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = "+ order);
    }
}
