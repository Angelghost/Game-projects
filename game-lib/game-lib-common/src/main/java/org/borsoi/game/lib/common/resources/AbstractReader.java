package org.borsoi.game.lib.common.resources;

import java.io.InputStream;

import com.thoughtworks.xstream.XStream;

public abstract class AbstractReader
{

    public abstract String getLabelResourceFile();

    public abstract XStream getXStream();

    public Object getObject()
    {

        if (getLabelResourceFile() != null)
        {
            InputStream inputStream = getClass().getResourceAsStream(getLabelResourceFile());
            if (inputStream != null)
            {
                XStream xStream = getXStream();
                return xStream.fromXML(inputStream);
            }
        }

        return null;
    }
}
