package com.mywebsite.core.servlets;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.request.RequestParameter;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.servlet.Servlet;
import java.io.IOException;

@Component(service = Servlet.class, property = {
        Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_POST,
        "sling.servlet.paths=" + "/bin/submitdata3" })

public class FormNodeServlet extends SlingAllMethodsServlet{
    private static final long serialVersionUID = -159625176093879129L;
    private static final Logger log = LoggerFactory.getLogger(FormNodeServlet.class);

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        try {
            ResourceResolver resourceResolver = request.getResourceResolver();
            Resource resource = resourceResolver.getResource("/content");
            Node node = resource.adaptTo(Node.class);
            Node newNode = node.addNode("VikrantNode", "nt:unstructured");
            newNode.setProperty("name", getRequestParameter(request,"name"));
            newNode.setProperty("phoneNo", getRequestParameter(request,"phoneNo"));
            newNode.setProperty("age",getRequestParameter(request,"age"));
            newNode.setProperty("dob",getRequestParameter(request,"dob"));
            response.getWriter().write("Form submitted");
            resourceResolver.commit();
        }

        catch (RepositoryException e) {
            e.printStackTrace();

        } catch (PersistenceException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String getRequestParameter(SlingHttpServletRequest request,String s) {
        String var= request.getParameter(s);
        return var;
    }
}
