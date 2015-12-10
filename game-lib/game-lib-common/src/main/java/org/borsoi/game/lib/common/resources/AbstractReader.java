package org.borsoi.game.lib.common.resources;

import java.io.File;

import com.thoughtworks.xstream.XStream;

public abstract class AbstractReader
{

    public abstract String getLabelResourceFile();

    public abstract XStream getXStream();

    public Object getObject()
    {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(getLabelResourceFile()).getFile());
        XStream xStream = getXStream();
        return xStream.fromXML(file);
    }
}
