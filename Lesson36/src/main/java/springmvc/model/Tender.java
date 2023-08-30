package springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tenders")
@Builder
@AllArgsConstructor
public class Tender {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  @Column(name = "subject")
  String subject;

  @Column(name = "short_Description")
  String shortDescription;

  @Column(name = "valuta")
  String valuta;

  @Column(name = "price")
  int price;

  @Column(name = "terms_Of_Payment")
  String termsOfPayment;

  @Column(name = "delivery_Conditions")
  String deliveryConditions;

  @ManyToOne
  @JoinColumn(name = "organization_Id", nullable = false)
  public Organization organizationTenders;

}
