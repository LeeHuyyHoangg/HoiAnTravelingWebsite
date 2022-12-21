package GenshinICT2022.example.SeleniumDemo.controller.data_port;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/data")
public class DataController {
//    @Autowired
//    private OAuth2AuthorizedClientService authorizedClientService;

    @GetMapping("/randomData/{name}")
    public ResponseEntity<?> getRandomData(@Valid @NotEmpty @PathVariable String name){
        return ResponseEntity.ok("DogeCoin " + name);
    }

//    @GetMapping("/loginSuccess")
//    public String getLoginInfo(Model model, OAuth2AuthenticationToken authentication) {
//        OAuth2AuthorizedClient client = authorizedClientService
//                .loadAuthorizedClient(
//                        authentication.getAuthorizedClientRegistrationId(),
//                        authentication.getName());
//        String userInfoEndpointUri = client.getClientRegistration()
//                .getProviderDetails().getUserInfoEndpoint().getUri();
//
//        if (!StringUtils.isEmpty(userInfoEndpointUri)) {
//            RestTemplate restTemplate = new RestTemplate();
//            HttpHeaders headers = new HttpHeaders();
//            headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken()
//                    .getTokenValue());
//            HttpEntity entity = new HttpEntity("", headers);
//            ResponseEntity <Map>response = restTemplate
//                    .exchange(userInfoEndpointUri, HttpMethod.GET, entity, Map.class);
//            Map userAttributes = response.getBody();
//            model.addAttribute("name", userAttributes.get("name"));
//        }
//        return "index";
//    }
}
