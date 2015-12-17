package org.borsoi.game.lib.common.resources;

import java.io.File;
import java.net.URL;

import com.thoughtworks.xstream.XStream;

public  abstract class AbstractReader {
	
	 public abstract String getLabelResourceFile();

	    public abstract XStream getXStream();

	    public Object getObject()
	    {

	        if (getLabelResourceFile() != null)
	        {
	            ClassLoader classLoader = getClass().getClassLoader();
	            URL resource = classLoader.getResource(getLabelResourceFile());
	            if (resource != null && resource.getFile() != null)
	            {
	                File file = new File(resource.getFile());
	                XStream xStream = getXStream();
	                return xStream.fromXML(file);
	            }
	        }

	        return null;
	    }
}
