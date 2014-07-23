package com.domain.register.console.exception;

public final class DomainRegisterException extends Exception
{
	private static final long serialVersionUID = 5583888608623969881L;

	public static String ERROR_PARSE_INPUT = "The system can not parse the input!\nPlease input like [<PURCHASE_DOMAIN_NAME>,<NUMBER_OF_YEARS>]";

	public DomainRegisterException(String string)
    {
        super(string);
    }
}