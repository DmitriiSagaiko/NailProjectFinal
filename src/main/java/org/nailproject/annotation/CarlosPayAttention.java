package org.nailproject.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface CarlosPayAttention{
    String whatToDo() default  "just make it!";

}
