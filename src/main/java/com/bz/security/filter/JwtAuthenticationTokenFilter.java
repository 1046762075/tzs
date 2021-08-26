package com.bz.security.filter;

import com.bz.security.UserDetailsServiceImpl;
import com.bz.security.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
									HttpServletResponse response,
									FilterChain chain) throws ServletException, IOException {

//		Cookie[] cookies = request.getCookies();
//		String authToken = null;
//		for (Cookie cookie : cookies) {
//			if(cookie.getName().equals(tokenHeader)){
//				authToken = cookie.getValue();
//				break;
//			}
//		}
		//拿到 requset 中的head
//		String authHeader = request.getHeader(this.tokenHeader);
//		if (authHeader != null && authHeader.startsWith(this.tokenHead)) {
//			// The part after "Bearer "
//			String authToken = authHeader.substring(this.tokenHead.length());
//			//解析token获取用户名
//			String username = jwtUtils.getUserNameFromToken(authToken);
//			log.info("checking username:{}", username);
//			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//				UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
//				if (userDetails != null) {
//					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//					log.info("给{}授权", username);
//					SecurityContextHolder.getContext().setAuthentication(authentication);
//				}
//			}
//		}
        chain.doFilter(request, response);
    }
}

