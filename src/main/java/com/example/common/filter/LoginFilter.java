package com.example.common.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Slf4j
public class LoginFilter implements Filter {

    private static final String[] WHITE_LIST = {"/", "/user/signup", "/login","/logout"};


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        log.info("로그인 필터 로직 실행");


        // WITHE LIST에 포함된 경우 true -> !true
        if (!isWHITELIST(requestURI)) {

            // cookie/session
            // 세션이 없는 경우 새로운 세션 생성 x
            HttpSession session = httpRequest.getSession(false);
            if (session == null || session.getAttribute("sessionkey") == null) {
                throw new RuntimeException("로그인 해주세요.");
            }

            // 로그인 성공 로직
            log.info("로그인에 성공했습니다.");

        }

        // 1번 경우 WHITE LIST에 등록된 URL 요청이라면 chain.doFilter 메서드 호출
        // 2번 경우 WHITE LIST가 아닌 경우 위에 있는 필터 로직을 통과 후에 chain.doFilter로 다음 필터나 servlet을 호출한다
        // chain.doFilter 역할은 다음 필터가 없으면 servlet -> controller, 다음 필터가 있으면 다음  filter를 호출한다.
        filterChain.doFilter(servletRequest,servletResponse);



    }

    private boolean isWHITELIST(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);

    }
}
