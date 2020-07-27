package com.hw.airport.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class XmlHandler
{
    private static XmlHandler instance;
    public static XmlHandler getInstance()
    {
        if(instance == null)
        {
            instance = new XmlHandler();
        }
        return instance;
    }

    private XStream xStream;
    private XmlHandler()
    {
       xStream = new XStream(new StaxDriver());
    }

    public <T> T loadFromXml(String filePath) throws FileNotFoundException {
        return (T) xStream.fromXML(new FileReader(filePath));
    }

    public <T> void loadToXml(String filePath, T objToSave) throws IOException
    {
        xStream.toXML(objToSave, new FileWriter(filePath));
    }
}