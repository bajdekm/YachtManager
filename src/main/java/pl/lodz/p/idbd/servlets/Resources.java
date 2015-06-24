package pl.lodz.p.idbd.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Resources extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String> mimeTypes = new HashMap<String, String>();
        mimeTypes.put("css", "text/css");
        mimeTypes.put("js", "text/javascript");

        try(OutputStream stream = resp.getOutputStream()) {
            File f = new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI());
            String path = f.getParent() + "/../../.." + req.getRequestURI();
            String extension = path.replaceAll("^.*\\.(.*)$", "$1");

            String contentType = mimeTypes.get(extension);
            if (contentType != null) {
                resp.setContentType(contentType);
            } else {
                resp.setContentType("text/plain");
            }
            
            try(FileInputStream fileStream = new FileInputStream(path)){
            	int data;
            	while ((data = fileStream.read()) != -1) { 
            		stream.write(data); 
            	}
            }

        } catch (Exception e) {
        	System.out.println("Can not get resource!");
        }
	}
	
}
