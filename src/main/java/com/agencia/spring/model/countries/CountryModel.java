package com.agencia.spring.model.countries;

import com.agencia.spring.model.destiny.DestinyModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Representa o modelo de países na aplicação. Cada instância dessa classe
 * reflete uma entrada na tabela "tb_countries" do banco de dados.
 * Essa entidade armazena informações relacionadas a países, como nome,
 * código ISO, moeda, idioma, código numérico e o continente ao qual pertence.
 * <p>
 * Esta entidade possui um relacionamento bidirecional com a entidade DestinyModel,
 * onde um país pode possuir múltiplos destinos relacionados.
 * <p>
 * Campos:
 * - id: Identificador único do país.
 * - name: Nome do país.
 * - iso_code: Código ISO de três letras que identifica o país.
 * - currency: Moeda oficial do país.
 * - language: Idioma oficial do país.
 * - number_code: Código numérico do país que inicia com "+" seguido de 1 a 3 dígitos.
 * - continent: Enumeração que indica o continente ao qual o país pertence.
 * - destinies: Lista de destinos associados ao país.
 * <p>
 * Regras de validação:
 * - O campo name não pode ser nulo nem vazio.
 * - O campo iso_code deve conter exatamente 3 letras maiúsculas.
 * - O campo currency não pode ser nulo nem vazio.
 * - O campo language não pode ser nulo nem vazio.
 * - O campo number_code deve começar com "+" e ser seguido por 1 a 3 dígitos.
 * - O campo continent não pode ser nulo.
 * <p>
 * Relacionamentos:
 * - Um para muitos: Um país pode ter múltiplos destinos.
 */
@Entity
@Table(name = "tb_countries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false, length = 3)
    @NotBlank
    @Pattern(regexp = "^[A-Z]{3}$", message = "O código ISO deve conter exatamente 3 letras maiúsculas.")
    private String iso_code;

    @Column(nullable = false)
    @NotBlank
    private String currency;

    @Column(nullable = false)
    @NotBlank
    private String language;

    @Column(nullable = false, length=4)
    @NotBlank
    @Size(min=2, max=4)
    @Pattern(regexp = "^\\+\\d{1,3}$", message = "O código numérico deve começar com '+' seguido de 1 a 3 dígitos.")
    private String number_code;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Continent continent;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<DestinyModel> destinies;

}
