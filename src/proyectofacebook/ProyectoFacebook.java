package proyectofacebook;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.conf.ConfigurationBuilder;

/**
 *
 * @author agomezcastro
 */
public class ProyectoFacebook {

    
    public static void main(String[] args) throws FacebookException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId("")
                .setOAuthAppSecret("")
                .setOAuthAccessToken("");
        
        FacebookFactory ff = new FacebookFactory(cb.build());
            Facebook facebook = ff.getInstance();
            facebook.postStatusMessage("Prueba de estado");
        
        
    }
    
    
    
}
