package ma.project.api.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import ma.project.api.ws.ChambreSoapService;
import ma.project.api.ws.ClientSoapService;
import ma.project.api.ws.ReservationSoapService;
import ma.project.api.ws.UtilisateurSoapService;

@Configuration
@AllArgsConstructor
public class CxfConfig {

    private final Bus bus;
    private final ClientSoapService clientSoapService;
    private final ChambreSoapService chambreSoapService;
    private final ReservationSoapService reservationSoapService;
    private final UtilisateurSoapService utilisateurSoapService;

    @Bean
    public EndpointImpl clientEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, clientSoapService);
        endpoint.publish("/client"); // L'URL sera /ws/client
        return endpoint;
    }

    @Bean
    public EndpointImpl chambreEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, chambreSoapService);
        endpoint.publish("/chambre"); // L'URL sera /ws/chambre
        return endpoint;
    }

    @Bean
    public EndpointImpl reservationEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, reservationSoapService);
        endpoint.publish("/reservation"); // L'URL sera /ws/reservation
        return endpoint;
    }

    @Bean
    public EndpointImpl utilisateurEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, utilisateurSoapService);
        endpoint.publish("/utilisateur"); // L'URL sera /ws/utilisateur
        return endpoint;
    }
}
