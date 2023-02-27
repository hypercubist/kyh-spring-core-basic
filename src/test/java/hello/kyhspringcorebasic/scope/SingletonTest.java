package hello.kyhspringcorebasic.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
        SingletonBean sb1 = ac.getBean(SingletonBean.class);
        SingletonBean sb2 = ac.getBean(SingletonBean.class);
        assertThat(sb1).isSameAs(sb2);
        ac.close();
    }

    @Scope("singleton")
    static class SingletonBean{

        @PostConstruct
        public void init() {
            System.out.println("singleton init");
        }

        @PreDestroy
        public void destory() {
            System.out.println("singleton destroy");
        }

    }
}
