package manu.projects.useragenda.useragenda.model;

import com.opencsv.bean.CsvBindByName;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user", schema = "public")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @CsvBindByName(column = "name")
  @Column(name = "name")
  @Size(min=2, message="Almeno 2 caratteri")
  private String name;
  @CsvBindByName(column = "surname")
  @Column(name = "surname")
  @Size(min=2, message="Almeno 2 caratteri")
  private String surname;
  @Email
  @CsvBindByName(column = "mail")
  @Column(name = "mail")
  @Size(min=2, message="Almeno 2 caratteri")
  private String mail;
  @CsvBindByName(column = "address")
  @Column(name = "address")
  @Size(min=2, message="Almeno 2 caratteri")
  private String address;
}
