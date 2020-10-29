/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.io.File;
import model.Service;
import model.ServiceList;
import org.w3c.dom.Document;


public class ServiceListController {
    private File fichXML = null;
    private Document doc = null;
    private ServiceList serviceList;
    final String ET_SERVICELIST = "servicelist";
    
    public ServiceListController(File fichXML) {
        this.fichXML = fichXML;
        this.serviceList = new ServiceList();
    }

    public ServiceListController(ServiceList serviceList) {
        this.serviceList = serviceList;
    }

    public ServiceListController(ServiceList serviceList, File ficXML, Document doc) {
        this.fichXML = fichXML;
        this.serviceList = serviceList;
        this.doc = doc;
    }

    public ServiceListController(Service service, File fichXML) {
        this.fichXML = fichXML;
    }

    public ServiceListController(ServiceList serviceList, File fichXML) {
        this.serviceList = serviceList;
        this.fichXML = fichXML;
    }

    public File getFichXML() {
        return fichXML;
    }

    public void setFichXML(File fichXML) {
        this.fichXML = fichXML;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public ServiceList getServiceList() {
        return serviceList;
    }

    public void setServiceList(ServiceList serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public String toString() {
        return "ServiceListController{" + "fichXML=" + fichXML + ", doc=" + doc + ", serviceList=" + serviceList + ", ET_SERVICELIST=" + ET_SERVICELIST + '}';
    }
    
    
}
