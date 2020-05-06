package com.packt.casino.validator;

import com.packt.casino.domain.UserDataTransferClasses.UserDataTransfer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object>
{

	@Override
	public void initialize(PasswordMatches constraintAnnotation)
	{
	}

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context)
	{
		if(object instanceof UserDataTransfer)
		{
			UserDataTransfer user = (UserDataTransfer) object;
			return user.getPassword().equals(user.getMatchingPassword());
		}
		return true;
	}
}
