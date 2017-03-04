package userManagement.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import userManagement.model.User;
@Component
public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> classs) {
		return User.class.isAssignableFrom(classs);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		if(!StringUtils.hasText(user.getUsername())){
			errors.rejectValue("username", "error.field.empty");
		}
		if(!StringUtils.hasText(user.getPassword())){
			errors.rejectValue("password", "error.field.empty");
		}
	}

}
