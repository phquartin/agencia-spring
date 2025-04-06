package com.agencia.spring.model.destiny;

import com.agencia.spring.model.country.CountryModel;
import com.agencia.spring.model.vpackage.VacationPackageModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import java.util.List;

/**
 * Representa o modelo de destino turístico na aplicação. Cada instância dessa classe
 * corresponde a uma entrada na tabela "tb_destinies" do banco de dados.
 * Esta entidade é utilizada para gerenciar informações relacionadas a destinos
 * disponíveis em pacotes de férias.
 * <p>
 * Atributos:
 * <ul>
 *      <li> id: Identificador único do destino (gerado automaticamente).</li>
 *      <li> name: Nome do destino. Este campo é obrigatório e não pode ser nulo ou em branco.</li>
 *      <li> country: País ao qual o destino pertence. Relacionamento muitos-para-um com a entidade CountryModel.</li>
 *      <li> description: Descrição do destino (opcional).</li>
 *      <li> vacationPackages: Lista de pacotes de férias associados ao destino. Relacionamento muitos-para-muitos com a entidade VacationPackageModel.</li>
 * </ul>
 * <p>
 * Regras de validação:
 * <ul>
 *      <li>O campo "name" é obrigatório e deve ser preenchido. Não pode conter valores nulos ou em branco.</li>
 * </ul>
 * <p>
 * Relacionamentos:
 * <ul>
 *      <li> Muitos-para-um: Um destino pertence a um único país (CountryModel).</li>
 *      <li> Muitos-para-muitos: Um destino pode estar associado a vários pacotes de férias (VacationPackageModel).</li>
 * </ul>
 */
@Entity
@Table(name = "tb_destinies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DestinyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_country", nullable = false)
    private CountryModel country;

    @Column(nullable = false)
    @NotBlank(message = "O campo nome nao pode estar vazio ou em branco!")
    private String name;

    private String description;

    @ManyToMany(mappedBy = "destinies")
    @JsonIgnore
    private List<VacationPackageModel> vacationPackages;

}
