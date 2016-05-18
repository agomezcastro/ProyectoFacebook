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
                .setOAuthAppId("1067703549971504")
                .setOAuthAppSecret("b65471d90c08d99d14fd7dac21230b6f")
                .setOAuthAccessToken("94bda5217d0dfc259a557771740fd5b2");
        
        FacebookFactory ff = new FacebookFactory(cb.build());
            Facebook facebook = ff.getInstance();
            facebook.postStatusMessage("Prueba de estado");
        
        
    }
    
    
    
}
