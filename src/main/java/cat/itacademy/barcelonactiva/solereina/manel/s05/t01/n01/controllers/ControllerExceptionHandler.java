package cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerExceptionHandler {
       /* public static final String DEFAULT_ERROR_VIEW = "error";

        @ExceptionHandler(value = ResourceNotFoundException.class)
        public ModelAndView notFoundErrorHandler(HttpServletRequest req, ResourceNotFoundException e) {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", req.getRequestURL());
            mav.setViewName(DEFAULT_ERROR_VIEW);
            return mav;
        }

        */
}
