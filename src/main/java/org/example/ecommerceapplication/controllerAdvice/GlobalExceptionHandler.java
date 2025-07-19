package org.example.ecommerceapplication.controllerAdvice;

import org.example.ecommerceapplication.dtos.ProductNotFoundExceptionDTO;
import org.example.ecommerceapplication.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ProductNotFoundException.class)
  private ResponseEntity<ProductNotFoundExceptionDTO> handleProductNotFoundEx(
      ProductNotFoundException ex) {
    ProductNotFoundExceptionDTO productNotFoundExceptionDTO = new ProductNotFoundExceptionDTO();
    productNotFoundExceptionDTO.setMessage("Product with id not found " + ex.getProductId());
    productNotFoundExceptionDTO.setResolution("PLease give a proper ID");
    return new ResponseEntity<>(productNotFoundExceptionDTO, HttpStatus.BAD_REQUEST);

  }

}
