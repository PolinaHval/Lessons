package springmvc.dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreateTenderDto {


  @NotEmpty
  private String subject;

  @NotEmpty
  private String shortDescription;

  @NotEmpty
  private String valuta;

  @NotNull
  private int price;

  @NotEmpty
  private String termsOfPayment;

  @NotEmpty
  private String deliveryConditions;
}
