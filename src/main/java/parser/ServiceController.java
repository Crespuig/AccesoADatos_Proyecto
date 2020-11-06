/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;
import model.BasicData;
import model.Media;
import model.Multimedia;
import model.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import static parser.ServiceController.leerMedia;

/**
 *
 * @author mati
 */
public class ServiceController {
    //ETIQUETAS
    static final String ET_SERVICE = "service";
    
    static final String ET_BASICDATA = "basicData";
    static final String ET_LANGUAGE = "language";
    static final String ET_PHONE = "phone";
    static final String ET_WEB = "web";
    
    static final String ET_MULTIMEDIA = "multimedia";
    static final String ET_MEDIA = "media";
    static final String ET_URL = "url";
    
    //ATRIBUTOS
    static final String ATR_FECHAACTUALIZACION = "fechaActualizacion";
    static final String ATR_ID = "id";
    static final String ATR_TYPE = "type";
    
    public static String getValorEtiqueta(String etiqueta, Element element) {
        Node nValue = element.getElementsByTagName(etiqueta).item(0);
        return nValue.getChildNodes().item(0).getNodeValue();
    }

    public static Element getElementEtiqueta(String etiqueta,
            Element element) {
        return (Element) element.getElementsByTagName(etiqueta).item(0);
    }
    
    protected static Service leerService(Element elemenService) {
        Service service;
   
        String valorService;
        String valorBasicData;
        String valorMultimedia;
        String valorFecha;
      
        Element elemService;      
        Element elemBasicData;
        Element elemMultimedia;
           
        /*valorService = getValorEtiqueta(ET_SERVICE, elemenService);
        elemService = getElementEtiqueta(ET_SERVICE, elemenService);
        valorFecha = elemService.getAttribute(ATR_FECHAACTUALIZACION);*/
        
        valorBasicData = getValorEtiqueta(ET_BASICDATA, elemenService);
        elemBasicData = getElementEtiqueta(ET_BASICDATA, elemenService);
        
        /*valorMultimedia = getValorEtiqueta(ET_MULTIMEDIA, elemenService);
        elemMultimedia = getElementEtiqueta(ET_MULTIMEDIA, elemenService);*/

        service = new Service(leerBasicData(elemBasicData)/*, valorMultimedia*/);
        
        return service;
        
    }

    protected static BasicData leerBasicData(Element elemenService){
        BasicData basicData;
        
        String valorLanguage;
        String valorPhone;
        String valorWeb;
        
        Element elemLanguage;
        Element elemPhone;
        Element elemWeb;
        
        valorLanguage = getValorEtiqueta(ET_LANGUAGE, elemenService);
        elemLanguage = getElementEtiqueta(ET_LANGUAGE, elemenService);
        
        valorPhone = getValorEtiqueta(ET_PHONE, elemenService);
        elemPhone = getElementEtiqueta(ET_PHONE, elemenService);
                       
        valorWeb = getValorEtiqueta(ET_WEB, elemenService);
        elemWeb = getElementEtiqueta(ET_WEB, elemenService);
        
        basicData = new BasicData(valorLanguage, valorPhone, valorWeb);
        
        return basicData;
    }
    
    protected static Multimedia leerMultimedia(Element elemenMultimedia){
        Multimedia multimedia;
        
        String valorMedia;
        String valorType;
        
        Element elemMedia;
        
        NodeList medias;
        
        valorMedia = getValorEtiqueta(ET_MEDIA, elemenMultimedia);
        elemMedia = getElementEtiqueta(ET_MEDIA, elemenMultimedia);
        valorType = elemMedia.getAttribute(ATR_TYPE);
        medias = elemMedia.getChildNodes();
       
        multimedia = new Multimedia(leerMedia (medias));
        
        return multimedia;
    }
    
    protected static ArrayList<Media> leerMedia(NodeList medias){
        ArrayList<Media> listMedia = new ArrayList();
        Media media;
        String url;
        
        for (int i = 0; i < medias.getLength(); i++) {
            if (medias.item(i).getNodeType() == Node.ELEMENT_NODE) {
                url = getValorEtiqueta(ET_URL, (Element) medias.item(i));

                media = new Media(url);
                listMedia.add(media);
            }
        }
        return listMedia;
    }

}
