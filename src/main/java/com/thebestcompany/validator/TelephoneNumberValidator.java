package com.thebestcompany.validator;

import org.springframework.beans.factory.annotation.Configurable;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

@Configurable
public class TelephoneNumberValidator  implements ConstraintValidator<ValidTelephoneNumber, String> {

    private Pattern pattern;

    private static final String TELEPHONE_PATTERN = "^(\\d{3}[- .]?){2}(\\d{2}[- .]?){2}$";

    @Override
    public void initialize(ValidTelephoneNumber constraintAnnotation) {
        pattern = Pattern.compile(TELEPHONE_PATTERN);
    }

    @Override
    public boolean isValid(String telephone, ConstraintValidatorContext context) {

        if (telephone == null || "".equals(telephone.trim())) return false;
        return pattern.matcher(telephone).matches();
    }
}
