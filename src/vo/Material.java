/**
 * This file was generated by the JPA Modeler
 */
package vo;

import DAO.EntidadeBase;
import enumm.PoliticaUso;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

/**
 * @author Eduardo
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Material.consultarPorDescricao",
            query = "select m from Material m where UPPER (m.descricao) like :descricao"),

    @NamedQuery(name = "Material.consultarPorQuantidade",
            query = "select m from Material m where m.quantidade = :quantidade"),

    @NamedQuery(name = "Material.consultarPorCategoria",
            query = "Select m from Material m where m.id_categoria.id_categoria = :idcategoria"),

    @NamedQuery(name = "Material.consultarTodos",
            query = "Select m from Material m ORDER BY (m.descricao)")

})
public class Material implements Serializable, EntidadeBase {

    @Id
    private Long id_material;

    @Column(nullable = false)
    private int quantidade;

    @Column(length = 200)
    private String descricao;

    @Column(length = 500)
    private String DadosTecnicos;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private PoliticaUso politicaUso;

    @ManyToOne(fetch = FetchType.EAGER)
    private TipoUnidade id_tipo_unidade = null;

    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria id_categoria = null;

    @Transient
    private String CategoriNome;

    @Transient
    private String unidadeMedida;

    public TipoUnidade getId_tipo_unidade() {
        return id_tipo_unidade;
    }

    public void setId_tipo_unidade(TipoUnidade id_tipo_unidade) {
        this.id_tipo_unidade = id_tipo_unidade;
    }

    public Categoria getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Categoria id_categoria) {
        this.id_categoria = id_categoria;
    }

    @Override
    public Long getId() {
        return this.id_material;
    }

    public void setId_material(Long id_material) {
        this.id_material = id_material;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.toUpperCase();
    }

    public String getCategoriNome() {
        return CategoriNome;
    }

    public void setCategoriNome(String CategoriNome) {
        this.CategoriNome = CategoriNome;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getDadosTecnicos() {
        return DadosTecnicos;
    }

    public void setDadosTecnicos(String DadosTecnicos) {
        this.DadosTecnicos = DadosTecnicos;
    }

    public PoliticaUso getPoliticaUso() {
        return politicaUso;
    }

    public void setPoliticaUso(PoliticaUso politicaUso) {
        this.politicaUso = politicaUso;
    }

}
