package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;


    @RestController
    public class TwitterController {

        @RequestMapping("/twitter/data")
        public TwitterData data(@RequestParam(value="screen_name", defaultValue="vivekpatil2092") String name) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            headers.set("Authorization", "Bearer "+"AAAAAAAAAAAAAAAAAAAAADAMzQAAAAAAU5v5bZKNqcrAknH7T5DCq8n8d4Q%3Dv9k0vR2qOC850JefBWGpzRu247qeBymkWuSSLJm9vgYXqIufqn");
            UriComponentsBuilder builder = UriComponentsBuilder
                    .fromHttpUrl("https://api.twitter.com/1.1/users/show.json?screen_name" +name);

            RestTemplate restTemplate = new RestTemplate();
          TwitterData finalData = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, TwitterData.class).getBody();
            return finalData;



        }
    }


