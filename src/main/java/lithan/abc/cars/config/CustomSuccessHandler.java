package lithan.abc.cars.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {

    String redirectURL = "/user";

    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

    List<String> roles = new ArrayList<>();

    for (GrantedAuthority a : authorities) {
      roles.add(a.getAuthority());
    }

    if (isAdmin(roles)) {
      redirectURL = "/admin";
    }

    new DefaultRedirectStrategy().sendRedirect(request, response, redirectURL);
  }

  private boolean isAdmin(List<String> roles) {
    if (roles.contains("ROLE_ADMIN")) {
      return true;
    }

    return false;
  }

}
