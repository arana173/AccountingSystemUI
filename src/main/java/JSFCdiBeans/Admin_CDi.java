/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package JSFCdiBeans;

import Entities.UserMaster;
import RestClient.RestClient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.event.FlowEvent;

@Named(value = "myCdi")
@RequestScoped
public class Admin_CDi {

    RestClient client;
    Response res;

    Collection<UserMaster> users;
    GenericType<Collection<UserMaster>> gusers;
    private boolean skip;

    public Admin_CDi() {
        client = new RestClient();
        users = new ArrayList<>();
        gusers = new GenericType<Collection<UserMaster>>() {
        };

    }

    public Collection<UserMaster> getUsers() {
        res = client.getallUser(Response.class);
        users = res.readEntity(gusers);
        System.out.println(users);
        return users;

    }

    public List<UserMaster> DisplayUsers() {
        res = client.getallUser(Response.class);
        users = res.readEntity(gusers);
        System.out.println(users);
        return (List<UserMaster>) users;
    }

    public void setUsers(List<UserMaster> users) {
        this.users = users;
    }

    public boolean isSkip() {

        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false; //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

}
