package e.g.spitter.controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppWideExceptionHandler {
	
	@ExceptionHandler(DuplicateSpittleException.class)
	public String duplicateSpittleHandler() {
		return "error/duplicate";
	}
}
