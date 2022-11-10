package com.example.commerce.Component;

import com.example.commerce.Dto.CardProductDto;
import com.example.commerce.Dto.CartDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ShoppingComponent {

    private RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8082/shopping";

    public long createCart(){
        String request = url + "/cart/create";
        Long cartId =  restTemplate.getForObject(request, Long.class);
        return cartId;
    }

    public void addProduct(CardProductDto dto) {

        String request = url + "/cart/add";
        restTemplate.postForObject(request, dto, CardProductDto.class);
    }

    public void deleteProduct(Long cardId, Long productId){
        String request = url + "/cart/" +cardId+"/remove/"+ productId;
        restTemplate.delete(request);
    }

    public void checkout(Long cartId) {
        String request = url + "/checkout/" + cartId;
        restTemplate.getForObject(request, void.class);
    }

    public CartDto find(long id){
        String request = url + "/cart/find";
        CartDto dto =  restTemplate.getForObject(request, CartDto.class);
        return dto;
    }
}
