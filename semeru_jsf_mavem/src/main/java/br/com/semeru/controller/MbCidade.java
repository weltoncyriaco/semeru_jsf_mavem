
package br.com.semeru.controller;

import br.com.semeru.model.dao.HibernateDao;
import br.com.semeru.model.dao.InterfaceDao;
import br.com.semeru.model.entities.Cidade;
import br.com.semeru.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



/**
 *
 * @author Welton
 */
@ManagedBean(name="mbCidade")
@SessionScoped
public class MbCidade implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Cidade cidade = new Cidade();
    private List<Cidade> cidades;

    public MbCidade() {
    }
    
    private InterfaceDao<Cidade> cidadeDAO(){
        InterfaceDao<Cidade> cidadeDAO = new HibernateDao<Cidade>(Cidade.class, FacesContextUtil.getREQUEST_SESSION());
        return cidadeDAO;
    }
    
    public String editCidade(){
        return "/restrict/cadastrarcidade.faces";
    }
    
     public String limparCidade() {
        cidade = new Cidade();
        return "/restrict/cadastrarcidade.faces";
    }
    
    public String addCidade(){
        if (cidade.getIdCidade() == null || cidade.getIdCidade() == 0){
            insertCidade();
        }else{
            updateCidade();
        }           
        limparCidade();
        return null;
    }

    private void insertCidade() {
        cidadeDAO().save(cidade);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação Efetuada com sucesso", ""));
    }

    private void updateCidade() {
        cidadeDAO().update(cidade);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização Efetuada com sucesso", ""));
    }
    
    public void deleteCidade(){
        cidadeDAO().remove(cidade);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Deleção Efetuada com sucesso", ""));
    }

    public List<Cidade> getCidades() {
        cidades = cidadeDAO().getEntities();
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
    
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

   
    
    

}
