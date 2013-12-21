package pl.edu.agh.useraccounts.service;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.7
 * 2013-12-21T09:53:59.908+01:00
 * Generated source version: 2.7.7
 * 
 */
@WebServiceClient(name = "UserServiceImplService", 
                  wsdlLocation = "UserService.wsdl",
                  targetNamespace = "http://service.useraccounts.agh.edu.pl/") 
public class UserServiceImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://service.useraccounts.agh.edu.pl/", "UserServiceImplService");
    public final static QName UserServiceImplPort = new QName("http://service.useraccounts.agh.edu.pl/", "UserServiceImplPort");
    static {
        URL url = UserServiceImplService.class.getResource("UserService.wsdl");
        if (url == null) {
            url = UserServiceImplService.class.getClassLoader().getResource("UserService.wsdl");
        } 
        if (url == null) {
            java.util.logging.Logger.getLogger(UserServiceImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "UserService.wsdl");
        }       
        WSDL_LOCATION = url;
    }

    public UserServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public UserServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserServiceImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns UserService
     */
    @WebEndpoint(name = "UserServiceImplPort")
    public UserService getUserServiceImplPort() {
        return super.getPort(UserServiceImplPort, UserService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UserService
     */
    @WebEndpoint(name = "UserServiceImplPort")
    public UserService getUserServiceImplPort(WebServiceFeature... features) {
        return super.getPort(UserServiceImplPort, UserService.class, features);
    }

}
