package net.kzn.onlineShopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "The page is not constructed");
		mv.addObject("errorDescription", "The page you are looking for is not available now");
		mv.addObject("title", "404 Error page");
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Product not availble");
		mv.addObject("errorDescription", "The product you are looking for is not available right now");
		mv.addObject("title", "Product Unavailable");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception exception) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Contact your Administrator!");
		
		//only for debugging
		StringWriter writer = new StringWriter();
		PrintWriter  printWriter = new PrintWriter(writer);
		
		exception.printStackTrace(printWriter);
		
		mv.addObject("errorDescription", writer.toString());
		mv.addObject("title", "Error");
		return mv;
	}
}
