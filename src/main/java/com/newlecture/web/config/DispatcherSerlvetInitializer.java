package com.newlecture.web.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherSerlvetInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] { 
				ServletContextConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {
	  
		return new String[] {"/"};
	}
	
	
	//UTF8 설
	 @Override
     protected Filter[] getServletFilters() {

       CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
       characterEncodingFilter.setEncoding("UTF-8");
       return new Filter[] { characterEncodingFilter };
     }

	
}
