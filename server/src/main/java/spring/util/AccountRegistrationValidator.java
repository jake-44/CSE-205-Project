package spring.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import spring.form.AccountRegistrationForm;

@Component
public class AccountRegistrationValidator implements Validator {
    /**
     * Can this {@link Validator} {@link #validate(Object, Errors) validate}
     * instances of the supplied {@code clazz}?
     * <p>This method is <i>typically</i> implemented like so:
     * <pre class="code">return Foo.class.isAssignableFrom(clazz);</pre>
     * (Where {@code Foo} is the class (or superclass) of the actual
     * object instance that is to be {@link #validate(Object, Errors) validated}.)
     *
     * @param clazz the {@link Class} that this {@link Validator} is
     *              being asked if it can {@link #validate(Object, Errors) validate}
     * @return {@code true} if this {@link Validator} can indeed
     * {@link #validate(Object, Errors) validate} instances of the
     * supplied {@code clazz}
     */
    @Override
    public boolean supports( Class<?> clazz )
    {
        return clazz == AccountRegistrationForm.class;
    }

    /**
     * Validate the supplied {@code target} object, which must be
     * of a {@link Class} for which the {@link #supports(Class)} method
     * typically has (or would) return {@code true}.
     * <p>The supplied {@link Errors errors} instance can be used to report
     * any resulting validation errors.
     *
     * @param target the object that is to be validated
     * @param errors contextual state about the validation process
     * @see ValidationUtils
     */
    @Override
    public void validate( Object target, Errors errors )
    {
        AccountRegistrationForm form = (AccountRegistrationForm) target;

        // TODO
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username", "EmptyOrWhite.username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email", "EmptyOrWhite.email");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors,"address", "EmptyOrWhite.address");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstName", "EmptyOrWhite.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastName", "EmptyOrWhite.lastName");
        System.out.println("Validation...");

    }
}
