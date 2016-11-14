package com.sativa.exception

import org.springframework.security.core.AuthenticationException

class SativaAuthException extends AuthenticationException {

	public SativaAuthException() {
	}

	public SativaAuthException(String message) {
		super(message);
	}

	public SativaAuthException(Throwable cause) {
		super(cause);
	}

	public SativaAuthException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public SativaAuthException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}