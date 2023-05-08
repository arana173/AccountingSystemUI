/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package JSFCdiBeans;

import Entities.SourceDocumentType;
import Entities.UserMaster;
import RestClient.RestClient;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author 57ren
 */
@Named(value = "userBean")
@SessionScoped
public class userBean implements Serializable {

    /**
     * Creates a new instance of userBean
     */
    List<UserMaster> users;
    GenericType<List<UserMaster>> genUserList;
    Response response;
    RestClient cli;

    List<SourceDocumentType> src_DocumentTypes;
    GenericType<List<SourceDocumentType>> gensrc_DocumentTypes;
    
   
    public userBean() {
        cli = new RestClient();
        users = new ArrayList<UserMaster>();
        genUserList = new GenericType<List<UserMaster>>() {
        };
        
        src_DocumentTypes = new ArrayList<SourceDocumentType>();
        gensrc_DocumentTypes =  new GenericType<List<SourceDocumentType>>() {
        }; 
    }

    public List<SourceDocumentType> getSrc_DocumentTypes() {
        return src_DocumentTypes;
    }

    public void setSrc_DocumentTypes(List<SourceDocumentType> src_DocumentTypes) {
        this.src_DocumentTypes = src_DocumentTypes;
    }
    
    public List<SourceDocumentType> displaySource_DocumentTypes()
    {
        response = cli.getallSource_Document(Response.class);
        src_DocumentTypes = (List<SourceDocumentType>) response.readEntity(gensrc_DocumentTypes);
        System.out.println();
        return src_DocumentTypes;
    }
    
    public List<UserMaster> diplayUsers() {
        response = cli.getallUser(Response.class);
        users = (List<UserMaster>) response.readEntity(genUserList);
        System.out.println(users);
        return users;
    }
    public void deletesrc()
    {
        
    }
    
    private SourceDocumentType select_src;

    public SourceDocumentType getSelect_src() {
        return select_src;
    }

    public void setSelect_src(SourceDocumentType select_src) {
        this.select_src = select_src;
    }
    
    
    
    public List<UserMaster> getUsers() {
        return users;
    }

    public void setUsers(List<UserMaster> users) {
        this.users = users;
    }

}
