/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import model.Service;
import model.ServiceList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import vista.App;

public class ServiceListController {

    private File ficXML = null;
    private Document doc = null;
    private ServiceList serviceList;

    final String ET_SERVICELIST = "servicelist";

    public ServiceListController() {
        this.serviceList = new ServiceList();
    }

    public ServiceListController(File fichXML) {
        this.ficXML = fichXML;
        this.serviceList = new ServiceList();
    }

    public ServiceListController(File fichXML, ServiceList negocio) {
        this.ficXML = fichXML;
        this.serviceList = negocio;
    }

    public void recuperarXML() throws SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            this.doc = builder.parse(this.ficXML);
            doc.normalize();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ServiceList leerDOM() {
        Element serviceList = this.doc.getDocumentElement();

        NodeList service = serviceList.getChildNodes();
        this.serviceList.clear();

        for (int i = 0; i < service.getLength(); i++) {
            if (service.item(i).getNodeType() == Node.ELEMENT_NODE) {
                this.serviceList.add(ServiceController.leerService((Element) service.item(i)));
            }

        }
        return this.serviceList;
    }

    public Document iniDoc() throws ParserConfigurationException {
        Document doc = null;
        doc = (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        return doc;
    }

    /*public void escribirDOM() throws ParserConfigurationException {
        this.doc = iniDoc();
        Element elemNegocio = doc.createElement(ET_SERVICELIST);
        this.doc.appendChild(elemNegocio);
        
        for (Service proveedor : serviceList) {
            ServiceController.escribirService(proveedor, elemNegocio, this.doc);
        }
    }*/
    public void guardarXML() throws TransformerConfigurationException, TransformerException {
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        trans.setOutputProperty(OutputKeys.INDENT, "yes");
        StreamResult result = new StreamResult(this.ficXML);
        DOMSource source = new DOMSource(this.doc);
        trans.transform(source, result);
    }

}
