package hello.kyhspringcorebasic.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototype bean 1");
        PrototypeBean pb1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototype bean 2");
        PrototypeBean pb2 = ac.getBean(PrototypeBean.class);
        Assertions.assertThat(pb1).isNotSameAs(pb2);
        ac.close();
    }

    @Scope("prototype")
    static class PrototypeBean{

        @PostConstruct
        public void init() {
            System.out.println("prototype init");
        }

        @PreDestroy
        public void destory() {
            System.out.println("prototype destroy");
        }

    }
}
