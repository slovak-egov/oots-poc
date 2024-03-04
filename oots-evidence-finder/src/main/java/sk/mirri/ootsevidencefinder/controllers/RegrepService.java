package sk.mirri.ootsevidencefinder.controllers;

import eu.europa.oots.binding.regrep.query.QueryResponse;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.InputStream;

public abstract class RegrepService {

    public static JAXBContext jaxbContext;

    static {
        try {
            jaxbContext = JAXBContext.newInstance("eu.europa.oots.binding.regrep.query:eu.europa.oots.binding.sdg");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    protected QueryResponse parseFromInput(InputStream in) throws JAXBException {
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        var resp = (QueryResponse) jaxbUnmarshaller.unmarshal(in);
        return resp;
    }
}
