/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofacebook;

import facebook4j.Event;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author agomezcastro
 */
public class MetodosFacebook {
    public Facebook facebook;
    /**
     * inicia Facebook
     * @return 
     */
    public Facebook inicio(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId("")
                .setOAuthAppSecret("")
                .setOAuthAccessToken("");
                
        FacebookFactory ff = new FacebookFactory(cb.build());
        facebook = ff.getInstance();
        return facebook;
            
    }        
    /**
     * Publica un estado que escribas
     * @throws FacebookException 
     */
    public void estado() throws FacebookException{
            facebook.postStatusMessage(JOptionPane.showInputDialog("Introduce el estado"));
    }
    /**
     * Da me gusta a un post que elijas, seleccionas los números del enlace da la URL
     * @throws FacebookException 
     */
    public void darLike() throws FacebookException{
        facebook.likePost(JOptionPane.showInputDialog("Introduce la ID del post que te gusta:"));
    }
    
    /**
     * Comenta un post que elijas, seleccionas los numeros del enlace de la URL
     * @throws FacebookException 
     */
    public void comentar() throws FacebookException{
        facebook.commentPost(JOptionPane.showInputDialog("Introduce la ID del post que quieres comentar:"), JOptionPane.showInputDialog("Escribe un comentario:"));
    }
    /**
     * Comenta una foto del post que elijas, seleccionas los numeros del enlace de la URL
     * @throws FacebookException 
     */
    public void comentarFoto() throws FacebookException{
        facebook.commentPhoto(JOptionPane.showInputDialog("ID de la foto"), JOptionPane.showInputDialog("Comentario de la foto:"));
    }
    /**
     * publica una imagen
     * @throws MalformedURLException
     * @throws FacebookException 
     */
    public void publicarFoto() throws MalformedURLException, FacebookException{
        PostUpdate post = new PostUpdate(new URL("http://motor.as.com/motor/2016/05/18/motociclismo/1463593379_244334.html"))
                .picture(new URL("http://as01.epimg.net/motor/imagenes/2016/05/18/motociclismo/1463593379_244334_1463593942_noticia_normal.jpg"))
                .description("noticia de motos");
        facebook.postFeed(post);
    }
    
    public void buscarTemas() throws FacebookException{
        ResponseList<Event> results = facebook.searchEvents(JOptionPane.showInputDialog(""));
        results.add(null);
    }
}
