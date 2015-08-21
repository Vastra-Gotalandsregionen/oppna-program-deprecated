/* Copyright 2009 VŠsta Gštalandsregionen

  This library is free software; you can redistribute it and/or modify
  it under the terms of version 2.1 of the GNU Lesser General Public
  License as published by the Free Software Foundation.

  This library is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU Lesser General Public License for more details.

  You should have received a copy of the GNU Lesser General Public
  License along with this library; if not, write to the
  Free Software Foundation, Inc., 59 Temple Place, Suite 330,
  Boston, MA 02111-1307  USA
*/
package se.vgr.javg.util.webcomponent.support;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This servlet should be configured in the web-app, mapped to trap all requests for resources.
 * Resources could for instance be defined as anything referenced by a URL matching the following pattern:
 * /resource/*
 * @author Johan Eltes
 *
 */
public class ClasspathResourceLoadingServlet extends HttpServlet {

	private Log logger;

	public ClasspathResourceLoadingServlet() {
		logger = LogFactory.getLog(ClasspathResourceLoadingServlet.class);
		logger.info("ClasspathResourceLoadingServlet instance has been initialized");
		System.out.println("SystemOut:ClasspathResourceLoadingServlet instance has been initialized");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String resourceName = (request.getServletPath() + request.getPathInfo()).substring(1);

		logger.debug("getContextPath: " + request.getContextPath());
		logger.debug("getLocalAddr: " + request.getLocalAddr());
		logger.debug("getPathInfo: " + request.getPathInfo());
		logger.debug("getRequestURI: " + request.getRequestURI());
		logger.debug("getServletPath: " + request.getServletPath());
		
		URL resolved = null;
		Enumeration urls;
		try {
			urls = ClassLoader.getSystemClassLoader()
					.getResources(resourceName);
			if (urls.hasMoreElements() == false) {
				urls = Thread.currentThread().getContextClassLoader()
						.getResources(resourceName);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new ServletException("Could not locate resource "
					+ resourceName);
		}
		if (urls.hasMoreElements()) {
			resolved = (URL)urls.nextElement();
			writeUrlResource(resolved, response);
		} else {
			logger.warn("Failed to resolve resource: " + resourceName);
			super.doGet(request, response);
		}
	}

	/**
	 * Copy the content of the resolved URL to the specified servlet response.
	 *
	 * @param resolved -
	 *            URL of resource to be copied
	 * @param writer -
	 *            target writer
	 */
	private void writeUrlResource(URL resolvedResource, HttpServletResponse response)
			throws ServletException {
		try {
// TODO: optimize! add buffering ...
			InputStream sourceReader = resolvedResource.openConnection().getInputStream();
			OutputStream responseStream = response.getOutputStream();
			int c;
			int count = 0;
			while ((c = sourceReader.read()) != -1) {
				responseStream.write(c);
				count++;
			}
			
			//Added by Anders Asplund - KnowIt to set mime types on resources
			String fileName = resolvedResource.getFile();
			if(fileName != null) {
				String contentType = MimetypesFileTypeMap.getDefaultFileTypeMap().getContentType(fileName);
				response.setContentType(contentType);
			}
			
			response.flushBuffer();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ServletException("Failed to write data for resource "
					+ resolvedResource.toExternalForm());
		}
	}
}
