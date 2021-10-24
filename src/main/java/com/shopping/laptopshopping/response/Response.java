package com.shopping.laptopshopping.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {

  private Header header;

  private T body;

  private ErrorInfo error;
}
