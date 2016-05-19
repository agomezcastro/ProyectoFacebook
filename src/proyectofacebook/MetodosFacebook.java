/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofacebook;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PostUpdate;
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
                .setOAuthAccessToken("EAACEdEose0cBAFFE2ZAefCRVtjvK8RUUBa9SVTmh20i2GNmEuIY6uGfQHlZApwgwQ6sF6ad4qleZBPx9AoS59LHIvTevjztyPyLVrFIhn7vzGZCcBs29GCLp0Y6ZAePlOveS7aRKd5CYqRvZBhzEG8aly34aIegQMpaAj7rKtP1ROqmMU29u16");
                
        FacebookFactory ff = new FacebookFactory(cb.build());
        Facebook facebook = ff.getInstance();
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
        PostUpdate post = new PostUpdate(new URL(""))
                .picture(new URL(""))
                .description("");
        facebook.postFeed(post);
    }
    
//    public void buscarTemas(){
//        faceboo
//    }
}
