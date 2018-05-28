package com.feivirus.annotation;
import java.lang.annotation.*;
import java.lang.annotation.ElementType;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
	String value() default "";
}
