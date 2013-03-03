
package br.com.semeru.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Welton
 */
@Entity
@Table(name = "cidade")
public class Cidade implements Serializable{
      private static final long serialVersionUID = 1L;
      
      @Id
      @GeneratedValue
      @Column(name = "IdCidade", nullable = false)
      private Integer idCidade;
      @Column(name = "Nome", nullable = false, unique = true, length = 80)
      private String nome;

    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
    @ForeignKey(name = "cidadeEndereco")
    private List<Endereco> enderecos;
    
    public Cidade() {
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.idCidade != null ? this.idCidade.hashCode() : 0);
        return hash;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        if (this.idCidade != other.idCidade && (this.idCidade == null || !this.idCidade.equals(other.idCidade))) {
            return false;
        }
        return true;
    }
      
}