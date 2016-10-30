package study.unit2.ex07;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface AboutSubmarine {
    String author();
    boolean isTrue();
}
