package com.a3.presentation.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a3.service.EmployeeService;

@Controller
public class LogInOutController implements AuthenticationSuccessHandler {

	@RequestMapping("**/logout")
	public String setupForm(Map<String, Object> map, HttpServletRequest request) {
		request.getSession(true).invalidate();
		return "redirect:/login";
	}

	@Override
	@RequestMapping("/")
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authResult) throws IOException, ServletException {
		/* Redirect on the successful authentication of the user */
		// String redirectAddress = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String role = auth.getAuthorities().toString();
		if (role.contains("ADMIN")) {
			response.sendRedirect(response.encodeURL("admin"));
		} else {
			if (role.contains("SECRETARY"))
				response.sendRedirect(response.encodeURL("secretary"));
			else {
				if (role.contains("DOCTOR"))
					response.sendRedirect(response.encodeURL("doctor"));

			}
		}
	}
}