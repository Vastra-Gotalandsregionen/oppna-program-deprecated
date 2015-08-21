package se.vgr.javg.util.webcomponent.support;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

public class ClasspathResourceLoadingServletTest {
  private ClasspathResourceLoadingServlet servlet;

  @Before
  public void setUp() {
    servlet = new ClasspathResourceLoadingServlet();
  }

  public static void main(String... args) {
    ClasspathResourceLoadingServletTest test = new ClasspathResourceLoadingServletTest();
    test.setUp();
    try {
      Thread.sleep(10000);

      test.testDoGetHttpServletRequestHttpServletResponse();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testDoGetHttpServletRequestHttpServletResponse() throws Exception {
    for (int i = 1; i <= 10000; i++) {
      servlet.doGet(new HttpServletRequestMock(), new HttpServletResponseMock());
    }
  }

  private static class HttpServletResponseMock implements HttpServletResponse {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    public ServletOutputStream getOutputStream() throws IOException {
      return new ServletOutputStream() {

        @Override
        public void write(int b) throws IOException {
          outputStream.write(b);
        }
      };
    }

    // Unimplemented methods

    public void addCookie(Cookie cookie) {
    }

    public void addDateHeader(String name, long date) {
    }

    public void addHeader(String name, String value) {
    }

    public void addIntHeader(String name, int value) {
    }

    public boolean containsHeader(String name) {
      return false;
    }

    public String encodeRedirectURL(String url) {
      return null;
    }

    public String encodeRedirectUrl(String url) {
      return null;
    }

    public String encodeURL(String url) {
      return null;
    }

    public String encodeUrl(String url) {
      return null;
    }

    public void sendError(int sc) throws IOException {
    }

    public void sendError(int sc, String msg) throws IOException {
    }

    public void sendRedirect(String location) throws IOException {
    }

    public void setDateHeader(String name, long date) {
    }

    public void setHeader(String name, String value) {
    }

    public void setIntHeader(String name, int value) {
    }

    public void setStatus(int sc) {
    }

    public void setStatus(int sc, String sm) {
    }

    public void flushBuffer() throws IOException {
    }

    public int getBufferSize() {
      return 0;
    }

    public String getCharacterEncoding() {
      return null;
    }

    public String getContentType() {
      return null;
    }

    public Locale getLocale() {
      return null;
    }

    public PrintWriter getWriter() throws IOException {
      return null;
    }

    public boolean isCommitted() {
      return false;
    }

    public void reset() {
    }

    public void resetBuffer() {
    }

    public void setBufferSize(int size) {
    }

    public void setCharacterEncoding(String charset) {
    }

    public void setContentLength(int len) {
    }

    public void setContentType(String type) {
    }

    public void setLocale(Locale loc) {
    }
  }

  private static class HttpServletRequestMock implements HttpServletRequest {
    public String getServletPath() {
      return "/resources";
    }

    public String getPathInfo() {
      return "/dummy_resource.txt";
    }

    // Unimplemented methods

    public String getAuthType() {
      return null;
    }

    public String getContextPath() {
      return null;
    }

    public Cookie[] getCookies() {
      return null;
    }

    public long getDateHeader(String name) {
      return 0;
    }

    public String getHeader(String name) {
      return null;
    }

    public Enumeration getHeaderNames() {
      return null;
    }

    public Enumeration getHeaders(String name) {
      return null;
    }

    public int getIntHeader(String name) {
      return 0;
    }

    public String getMethod() {
      return null;
    }

    public String getPathTranslated() {
      return null;
    }

    public String getQueryString() {
      return null;
    }

    public String getRemoteUser() {
      return null;
    }

    public String getRequestURI() {
      return null;
    }

    public StringBuffer getRequestURL() {
      return null;
    }

    public String getRequestedSessionId() {
      return null;
    }

    public HttpSession getSession() {
      return null;
    }

    public HttpSession getSession(boolean create) {
      return null;
    }

    public Principal getUserPrincipal() {
      return null;
    }

    public boolean isRequestedSessionIdFromCookie() {
      return false;
    }

    public boolean isRequestedSessionIdFromURL() {
      return false;
    }

    public boolean isRequestedSessionIdFromUrl() {
      return false;
    }

    public boolean isRequestedSessionIdValid() {
      return false;
    }

    public boolean isUserInRole(String role) {
      return false;
    }

    public Object getAttribute(String name) {
      return null;
    }

    public Enumeration getAttributeNames() {
      return null;
    }

    public String getCharacterEncoding() {
      return null;
    }

    public int getContentLength() {
      return 0;
    }

    public String getContentType() {
      return null;
    }

    public ServletInputStream getInputStream() throws IOException {
      return null;
    }

    public String getLocalAddr() {
      return null;
    }

    public String getLocalName() {
      return null;
    }

    public int getLocalPort() {
      return 0;
    }

    public Locale getLocale() {
      return null;
    }

    public Enumeration getLocales() {
      return null;
    }

    public String getParameter(String name) {
      return null;
    }

    public Map getParameterMap() {
      return null;
    }

    public Enumeration getParameterNames() {
      return null;
    }

    public String[] getParameterValues(String name) {
      return null;
    }

    public String getProtocol() {
      return null;
    }

    public BufferedReader getReader() throws IOException {
      return null;
    }

    public String getRealPath(String path) {
      return null;
    }

    public String getRemoteAddr() {
      return null;
    }

    public String getRemoteHost() {
      return null;
    }

    public int getRemotePort() {
      return 0;
    }

    public RequestDispatcher getRequestDispatcher(String path) {
      return null;
    }

    public String getScheme() {
      return null;
    }

    public String getServerName() {
      return null;
    }

    public int getServerPort() {
      return 0;
    }

    public boolean isSecure() {
      return false;
    }

    public void removeAttribute(String name) {
    }

    public void setAttribute(String name, Object o) {
    }

    public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
    }
  }
}
