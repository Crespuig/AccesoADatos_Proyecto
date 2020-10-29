/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import model.BasicData;
import model.Media;
import model.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author mati
 */
public class ServiceController {
    //ETIQUETAS
    static final String ET_SERVICE = "service";
    
    static final String ET_BASICDATA = "basicData";
    static final String ET_NAME = "name";
    static final String ET_PHONE = "phone";
    static final String ET_TITLE = "title";
    
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
    
    protected static Service leerService(Element elemService, Element elemBasicData, Element elemMultimedia) {
        Service service = new Service();
        BasicData basicData = new BasicData();
        Media media = new Media();
        
        //SERVICE
        String basicD = getValorEtiqueta(ET_BASICDATA, elemService);
        String multi = getValorEtiqueta(ET_MULTIMEDIA, elemService);
        
        //BASICDATA
        String name = getValorEtiqueta(ET_NAME, elemBasicData);
        basicData.setName(name);
        String phone = getValorEtiqueta(ET_PHONE, elemBasicData);
        basicData.setPhone(phone);
        String title = getValorEtiqueta(ET_TITLE, elemBasicData);
        basicData.setTitle(title);
        
        //MEDIA
        String url = getValorEtiqueta(ET_URL, elemMultimedia);
        media.setUrl(url);
        
        
        /*String titulo = getValorEtiqueta(ET_TITULO, elemLibro);
        libro.setTitulo(titulo);
        String autores = getValorEtiqueta(ET_AUTORES, elemLibro);
        libro.setAutor(autores);
        String autor = getValorEtiqueta(ET_AUTOR, elemLibro);
        libro.setAutor(autor);
        float precio = Float.parseFloat(getValorEtiqueta(ET_PRECIO, elemLibro));
        libro.setPrecio(precio);
        String categoria = getValorEtiqueta(ET_CATEGORIA, elemLibro);
        libro.setCategoria(categoria);
        String cover = getValorEtiqueta(ET_COVER, elemLibro);
        libro.setCover(cover);*/

        return service;
        
    }

    static void escribirService(Service service, Element elemService, Document doc) {
        /*Element elemLibro = doc.createElement(ET_LIBRO);
        
        Element elemTitulo = doc.createElement(ET_TITULO);
        elemTitulo.appendChild(doc.createTextNode(String.valueOf(libro.getTitulo())));
        elemLibro.appendChild(elemTitulo);

        Element elemAutores = doc.createElement(ET_AUTORES);
        Element elemAutor = doc.createElement(ET_AUTOR);
        elemAutores.appendChild(elemAutor);
        elemAutor.appendChild(doc.createTextNode(String.valueOf(libro.getAutor())));
        elemLibro.appendChild(elemAutores);

        Element elemPrecio = doc.createElement(ET_PRECIO);
        elemPrecio.appendChild(doc.createTextNode(String.valueOf(libro.getPrecio())));
        elemLibro.appendChild(elemPrecio);
        
        elemBookstore.appendChild(elemLibro);*/
    }

}
