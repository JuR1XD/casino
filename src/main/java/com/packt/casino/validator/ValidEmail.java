package com.packt.casino.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface ValidEmail
{
	String message() default  "{casino.signIn.email.error}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload()default {};
}
