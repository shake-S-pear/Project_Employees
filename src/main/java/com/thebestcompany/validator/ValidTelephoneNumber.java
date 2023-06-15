package com.thebestcompany.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TelephoneNumberValidator.class)
public @interface ValidTelephoneNumber {
    String message() default "doesn't seem to be a valid phone number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
