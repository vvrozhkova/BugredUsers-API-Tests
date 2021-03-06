package io.vvrozhkova.bugredusers_common.helpers.youtrack;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ExtendWith(YoutrackExtension.class)
public @interface TestCaseId {
    String value();
}
