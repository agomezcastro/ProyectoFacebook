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
    
    public Facebook inicio(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId("1993686774190575")
                .setOAuthAppSecret("5e01f656c682cbd1bc6facbbb165b8ed")
                .setOAuthAccessToken("EAACEdEose0cBAKT7WG4VfvvvnZCMJhv2LOWl1hfFy8TToP1qOBLOmKzt2GZBRyIGxxwO6ZCZBQsS9aiGBQziyE1Tg7NMy2XUjZBm2ZABKlqVZCkLPR5cQvalPbGyhTQ4XZBnkrOqVQZB5xWdVd9xnIRN3VJTg9HA6LA1x7ye965vlGZBatun8aZAji0");
                
        FacebookFactory ff = new FacebookFactory(cb.build());
        facebook = ff.getInstance();
        return facebook;
            
    }        
    public void estado() throws FacebookException{
            facebook.postStatusMessage(JOptionPane.showInputDialog("Introduce el estado"));
    }
    
    public void darLike() throws FacebookException{
        facebook.likePost(JOptionPane.showInputDialog("Introduce la ID del post que te gusta:"));
    }
    
    public void comentar() throws FacebookException{
        facebook.commentPost(JOptionPane.showInputDialog("Introduce la ID del post que quieres comentar:"), JOptionPane.showInputDialog("Escribe un comentario:"));
    }
    
    public void comentarFoto() throws FacebookException{
        facebook.commentPhoto(JOptionPane.showInputDialog("ID de la foto"), JOptionPane.showInputDialog("Comentario de la foto:"));
    }
    
    public void publicarFoto() throws MalformedURLException, FacebookException{
        PostUpdate post = new PostUpdate(new URL("http://www.capilda.com"))
                .picture(new URL("http://www.capilda.com/tag/frutas/"))
                .description("frutas");
        facebook.postFeed(post);
    }
    
    public void buscarTemas() throws FacebookException{
        ResponseList<Event> results = facebook.searchEvents(JOptionPane.showInputDialog(""));
        results.add(null);
    }
}
